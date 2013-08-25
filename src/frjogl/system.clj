(ns frjogl.system
  (:require [seesaw.core :as seesaw])
  (:gen-class))

;;;; If only because I'm turning into a total fanboi for Stuart
;;;; Sierra's Workflow Revisited.

(defn system 
  "Generate a world with uninitialized state"
  []
  {})

(defn start 
  "Perform the side-effects to make the world come to life"
  [world]
  (seesaw/native!)

  world)

(defn stop
  "Perform appropriate side-effects to wipe all life from the world."
  [world]
  (system))
