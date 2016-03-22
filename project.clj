(defproject pfad "0.1.0-SNAPSHOT"
            :description "A Clojure Look at Pearls of Functional Algorithm Design"
            :url "http://djhaskin987.blogspot.com"
            :license {:name "Eclipse Public License"
                      :url "http://www.eclipse.org/legal/epl-v10.html"}
            :dependencies [[org.clojure/clojure "1.8.0"]
                           [criterium "0.4.4"]]
            :test-selectors {:default (constantly true)
                             :minfree :minfree
                             :surpasser :surpasser})

