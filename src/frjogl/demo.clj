(ns frjogl.demo
  (:require [seesaw.core :refer :all])
  (:gen-class))

;;;; Show off (or whatever) the available demos.
;;;; Seems like it'd be much nicer to show them embedded
;;;; in a frame (think wx...whatever it's called these
;;;; days). Oh well. Plan on something along those lines later.

(defn build
  "Create a window/dialog/form that knows how to kick off the
actual demos."
  []
  (let [lbl (label "Have to start somewhere")
        f (frame :title "JOGL from Clojure"
                 :content lbl)]
    (-> f pack! show!)
    f))

