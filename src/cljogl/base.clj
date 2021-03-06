(ns cljogl.base
  (:import [javax.media.opengl GL GL2]
           javax.media.opengl.glu.GLU)
  ;; Only for show-members...which definitely does
  ;; not belong here.
  (:require [clojure.reflect :as r]
            [clojure.pprint :as pp]))

(defn show-members
  "Realistically, this is a debug-only method that belongs
in pretty much everyone's standard repertoire."
  [o]
  (pp/print-table
   (sort-by :name
            (filter :exception-types
                    (:members (r/reflect o))))))

(defn setup [gl2 width height]
  (.glMatrixMode gl2 GL2/GL_PROJECTION)
  (.glLoadIdentity gl2)

  (.gluOrtho2D (GLU.) 0.0 (double width) 0.0 (double height))
  
  (.glMatrixMode gl2 GL2/GL_MODELVIEW)
  (.glLoadIdentity gl2)

  (.glViewport gl2 0 0 width height))

(defn render [gl2 width height]
  (.glClear gl2 GL/GL_COLOR_BUFFER_BIT)

  ;; Draw a triangle filling the window
  (doto gl2
    (.glLoadIdentity)
    (.glBegin GL/GL_TRIANGLES)
    (.glColor3f 1 0 0)
    (.glVertex2f 0 0)
    (.glColor3f 0 1 0)
    (.glVertex2f width 0)
    (.glColor3f 0 0 1)
    (.glVertex2f (/ 2 width) height)
    (.glEnd)))
