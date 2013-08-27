(defproject cljogl "0.1.0-SNAPSHOT"
  :description "Try messing around with JOGL again"
  :url "http://frereth.com/"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojars.toxi/jogl "2.0.0-rc11"]
                 [seesaw "1.4.3"]]
  :profiles {:dev {:source-paths ["dev"]
                   :dependencies [[org.clojure/tools.namespace "0.2.3"]
                                  [org.clojure/java.classpath "0.2.0"]]}}
  :main cljogl.core)
