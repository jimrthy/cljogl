(ns frjogl.base
  (:import [javax.media.opengl GL GL2]
           [javax.media.opengl.glu.GLU]))

(defn setup [gl2 width height]
  (.glMatrixModel gl2 GL2/GL_PROJECTION)
  (.glLoadIdentity gl2)

  (.gluOrtho2D (GLU.) 0.0 width 0.0 height)
  
  (.glMatrixModel gl2 GL2/GL_MODELVIEW)
  (.glLoadIdentity gl2)

  (.glViewport gl2 0 0 width height))

(defn render [gl2 width height]
  (.glClear gl2 GL/GL_COLOR_BUFFER_BIT)
  
  (throw (RuntimeException. "Start here!"))
  )
