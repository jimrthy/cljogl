(ns frjogl.core
  (:require [frjogl.awt :as awt])
  (:gen-class))

(defn -main
  "Wrap around pieces that I consider interesting so I can play with them.
Doesn't do much...yet"
  [& args]
  ;; work around dangerous default behaviour in Clojure
  (alter-var-root #'*read-eval* (constantly false))
  (awt/run))
