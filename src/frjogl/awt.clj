(ns frjogl.awt
  (:require [frjogl.base :as base])
  (:import [javax.media.opengl GLAutoDrawable GLEventListener GLProfile
            GLCapabilities]
           javax.media.opengl.awt.GLCanvas
           java.awt.Frame
           [java.awt.event WindowAdapter WindowEvent])
  (:gen-class))

;;; Minimal program that draws with JOGL in an AWT Frame
;;; Originally by Wade Walker
;;; Translated into clojure by James Gatannah

(defn build-gl-listener []
  (proxy [GLEventListener] []
    (reshape [gl-auto-drawable x y w h]
      (base/setup (.getGL2 (.getGL gl-auto-drawable)) w h))
    
    (init [_])
    (dispose [_])

    (display [gl-auto-drawable]
      (base/render (.getGL2 (.getGL gl-auto-drawable))
                   (.getWidth gl-auto-drawable)
                   (.getHeight gl-auto-drawable)))))

(defn build-gl-canvas []
  (let [profile (GLProfile/getDefault)
        caps (GLCapabilities. profile)
        canvas (GLCanvas. caps)
        listener (build-gl-listener)]
    (.addGLEventListener canvas (build-gl-listener))
    canvas))

(defn build-frame [gl-canvas]
  (let [f (Frame. "One Triangle AWT")]
    (doto f
      (.add gl-canvas)
      (.addWindowListener (proxy [WindowAdapter] []
                              (windowClosing [event]
                                             (doto f
                                               (.remove gl-canvas)
                                               (.dispose))
                                             ;; The original calls
                                             ;; (System/exit 0) here.
                                             ;; I'm pretty sure I don't
                                             ;; want to do that.
                                             ))))))

(defn run []
  (let [canvas (build-gl-canvas)
        frame (build-frame canvas)]
    (doto frame
      (.setSize 640 480)
      (.setVisible true))))
