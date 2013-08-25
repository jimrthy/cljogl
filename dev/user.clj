(ns user
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [clojure.pprint :refer (pprint)]
            [clojure.repl :refer :all]
            [clojure.test :as test]
            [clojure.tools.namespace.repl :refer (refresh refresh-all)]
            [frjogl.system :as system]))

(def system nil)

(defn init
  "Constructs the next development system"
  []
  (alter-var-root #'system
                  (constantly (system/system))))

(defn start
  "Starts the current development system"
  []
  (alter-var-root #'system system/start))

(defn stop
  "Shuts down and destroys the current development system"
  []
  (alter-var-root #'system
                  (fn [s]
                    (when s
                      (system/stop s)))))

(defn go
  "Initializes a new development system and starts it"
  []
  (init)
  (start))

(defn reset
  "The heart of the entire development workflow"
  []
  (stop)
  (refresh :after 'user/go))
