(ns frjogl.demo
  (:require [seesaw.core :refer :all]
            [frjogl.awt :as awt])
  (:gen-class))

;;;; Show off (or whatever) the available demos.
;;;; Seems like it'd be much nicer to show them embedded
;;;; in a frame (think wx...whatever it's called these
;;;; days). Oh well. Plan on something along those lines later.

(defn build
  "Create a window/dialog/form that knows how to kick off the
actual demos."
  []
  (let [b (button :text "Coolness!")
        f (frame :title "JOGL from Clojure"
                 :content b)]
    ;; This next function's actually a nightmare:
    ;; There isn't any real way to actually close the resulting window,
    ;; short of killing the JVM.
    ;; At least, it would be if it actually worked.
    ;; Still: baby steps.
    (listen b :action (fn [_] (comment (Thread. awt/run))
                        (alert nil "Click")))
    (-> f pack! show!)
    f))

