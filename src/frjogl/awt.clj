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
      ;; Note that this only gets called the first time through.
      ;; Not exactly what I expected.
      (println "Reshape!")
      (base/setup (-> gl-auto-drawable
                      (.getGL) 
                      (.getGL2))
                  w h))
    
    (init [_])
    (dispose [_])

    (display [gl-auto-drawable]
      (base/render (-> gl-auto-drawable
                       (.getGL)
                       (.getGL2))
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
                                               (.dispose))))))))

(defn run []
  (let [canvas (build-gl-canvas)
        frame (build-frame canvas)]
    (doto frame
      (.setSize 640 480)
      (.setVisible true))
    frame))
