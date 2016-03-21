(ns pfad.core)


(defn checklist [x]
  (let [c (count x)
        result (transient (vec (repeat c false)))]
   (doseq [e x]
     (when (< e c)
       (assoc! result e true)))
   (persistent! result)))


(defn minfrom [a n x]
  (if (= 0 n)
    a
    (let [b (+ 1 (quot n 2) a)
          {us true vs false} (group-by #(< % b) x)
          m (count us)]
      (if (= m (- b a))
        (minfrom b (- n m) vs)
        (minfrom a m us)))))

(defn minfree
  "Find the smallest natural number in a list."
  [x]
  (minfrom 0 (count x) x))

(defn search [x]
  (first (keep-indexed #(when (not %2) %1) x)))

(defn minfree-multi
  "Find the smallest natural number in a set,
  where the elements of the list are not guaranteed to be unique."

  [X]
  (let [search-result  (search (checklist X))]
    (if search-result
      search-result
      (count X))))
