(ns pfad.core
  (:require [clojure.core.typed :as t]))


(t/ann ^:no-check checklist [(t/Seq t/AnyInteger) -> (t/AVec t/Bool)])
(defn checklist [x]
  (let [c (count x)
        result (transient (vec (repeat c false)))]
   (doseq [e x]
     (when (< e c)
       (assoc! result e true)))
   (persistent! result)))

(t/ann ^:no-check search [(t/AVec t/Bool) -> t/AnyInteger])
(defn search [x]
  (first (keep-indexed #(when (not %2) %1) x)))

(t/ann minfree [(t/Seq t/AnyInteger) -> t/AnyInteger])
(defn minfree
  "Find the smallest natural number in a set."
  [X]
  (let [search-result  (search (checklist X))]
    (if search-result
      search-result
      (count X))))

