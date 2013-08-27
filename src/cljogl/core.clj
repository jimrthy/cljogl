(ns cljogl.core
  (:require [cljogl.awt :as awt]
            [cljogl.demo :as demo])
  (:gen-class))

(defn -main
  "Wrap around pieces that I consider interesting so I can play with them.
Doesn't do much...yet"
  [& args]
  ;; work around dangerous default behaviour in Clojure
  (alter-var-root #'*read-eval* (constantly false))
  (demo/build))
