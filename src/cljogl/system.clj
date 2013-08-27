(ns cljogl.system
  (:require [seesaw.core :as seesaw]
            [cljogl.demo :as demo])
  (:import java.awt.event.WindowEvent)
  (:gen-class))

;;;; If only because I'm turning into a total fanboi for Stuart
;;;; Sierra's Workflow Revisited.

(defn system 
  "Generate a world with uninitialized state"
  []
  {;; Top-Level window/frame
   :top (atom nil)})

(defn start 
  "Perform the side-effects to make the world come to life"
  [world]
  (seesaw/native!)

  (reset! (:top world) (demo/build))

  world)

(defn stop
  "Perform appropriate side-effects to wipe all life from the world."
  [world]
  ;; Realistically, this should be a method on the top instance.
  ;; I'm fine with quick-and-dirty for now.
  (when-let [top @(:top world)]
    (.dispatchEvent top (WindowEvent. top WindowEvent/WINDOW_CLOSING)))
  (system))
