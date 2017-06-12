
(ns gov.nist.sinet.util.fitness)

(def qpn-m2-bas
  [{:act :bj, :tkns [{:type :a, :id 17}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 17}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 11}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 11}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 12}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 11}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 12}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 18} {:type :a, :id 17}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 18}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 17}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 18}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 18}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 12}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 12}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 13}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 12}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 13}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 18} {:type :a, :id 19}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 19}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 18}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 19}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 19}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 13}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 13}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 14}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 13}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 14}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 20} {:type :a, :id 19}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 20}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 19}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 20}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 20}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 14}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 14}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 15}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 14}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 15}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 21} {:type :a, :id 20}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 21}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 20}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 21}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 21}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 15}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 15}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 16}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 15}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 16}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 21} {:type :a, :id 22}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 22}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 21}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :ej, :tkns [{:type :a, :id 16}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 16}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 17}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 16}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 17}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :bj, :tkns [{:type :a, :id 22}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 22}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :aj, :tkns [{:type :a, :id 23} {:type :a, :id 22}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 23}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 22}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 23}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 23}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 17}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 17}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 18}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 17}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 18}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 24} {:type :a, :id 23}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 24}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 23}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 24}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 24}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 18}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 18}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 19}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 18}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 19}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 24} {:type :a, :id 25}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 25}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 24}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :ej, :tkns [{:type :a, :id 19}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 19}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 20}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 19}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 20}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :bj, :tkns [{:type :a, :id 25}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 25}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :aj, :tkns [{:type :a, :id 26} {:type :a, :id 25}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 26}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 25}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 26}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 26}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 20}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 20}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 21}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 20}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 21}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 26} {:type :a, :id 27}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 27}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 26}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 27}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 27}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 21}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 21}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 22}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 21}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 22}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 28} {:type :a, :id 27}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 28}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 27}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 28}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 28}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 22}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 22}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 23}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 22}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 23}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 29} {:type :a, :id 28}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 29}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 28}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 29}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 29}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 23}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 23}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 24}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 23}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 24}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 29} {:type :a, :id 30}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 30}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 29}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 30}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 30}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 24}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 24}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 25}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 24}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 25}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 31} {:type :a, :id 30}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 31}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 30}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 31}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 31}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 25}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 25}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 26}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 25}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 26}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 32} {:type :a, :id 31}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 32}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 31}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 32}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 32}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 26}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 26}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 27}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 26}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 27}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 33} {:type :a, :id 32}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 33}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 32}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 33}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 33}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 27}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 27}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 28}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 27}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 28}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 33} {:type :a, :id 34}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 34}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 33}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 34}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 34}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 28}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 28}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 29}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 28}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 29}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 35} {:type :a, :id 34}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 35}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 34}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 35}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 35}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 29}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 29}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 30}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 29}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 30}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 36} {:type :a, :id 35}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 36}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 35}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 36}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 36}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 30}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 30}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 31}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 30}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 31}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 36} {:type :a, :id 37}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 37}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 36}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 37}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 37}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 31}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 31}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 32}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 31}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 32}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 37} {:type :a, :id 38}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 38}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 37}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :ej, :tkns [{:type :a, :id 32}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 32}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 33}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 32}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 33}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :bj, :tkns [{:type :a, :id 38}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 38}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :aj, :tkns [{:type :a, :id 38} {:type :a, :id 39}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 39}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 38}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 39}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 39}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 33}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 33}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 34}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 33}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 34}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 40} {:type :a, :id 39}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 40}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 39}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 40}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 40}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 34}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 34}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 35}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 34}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 35}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 40} {:type :a, :id 41}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 41}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 40}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 41}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 41}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 35}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 35}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 36}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 35}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 36}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 42} {:type :a, :id 41}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 42}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 41}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 42}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 42}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 36}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 36}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 37}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 36}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 37}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 42} {:type :a, :id 43}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 43}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 42}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 43}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 43}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 37}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 37}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 38}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 37}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 38}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 43} {:type :a, :id 44}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 44}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 43}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 44}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 44}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 38}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 38}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 39}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 38}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 39}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 45} {:type :a, :id 44}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 45}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 44}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 45}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 45}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 39}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 39}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 40}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 39}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 40}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 45} {:type :a, :id 46}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 46}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 45}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :ej, :tkns [{:type :a, :id 40}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 40}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 41}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 40}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 41}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :ej, :tkns [{:type :a, :id 41}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 41}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 42}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 41}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 42}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :ej, :tkns [{:type :a, :id 42}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 42}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 43}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 42}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 43}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :bj, :tkns [{:type :a, :id 46}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 46}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :aj, :tkns [{:type :a, :id 46} {:type :a, :id 47}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 47}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 46}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :ej, :tkns [{:type :a, :id 43}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 43}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 44}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 43}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 44}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :bj, :tkns [{:type :a, :id 47}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 47}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :aj, :tkns [{:type :a, :id 48} {:type :a, :id 47}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 48}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 47}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 48}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 48}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :aj, :tkns [{:type :a, :id 49} {:type :a, :id 48}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 49}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 48}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 49}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 49}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :aj, :tkns [{:type :a, :id 49} {:type :a, :id 50}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 50}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 49}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 50}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 50}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 44}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 44}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 45}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 44}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 45}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 51} {:type :a, :id 50}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 51}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 50}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :ej, :tkns [{:type :a, :id 45}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 45}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 46}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 45}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 46}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :bj, :tkns [{:type :a, :id 51}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 51}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :aj, :tkns [{:type :a, :id 51} {:type :a, :id 52}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 52}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 51}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 52}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 52}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 46}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 46}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 47}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 46}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 47}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 53} {:type :a, :id 52}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 53}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 52}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 53}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 53}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 47}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 47}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 48}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 47}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 48}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 54} {:type :a, :id 53}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 54}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 53}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :ej, :tkns [{:type :a, :id 48}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 48}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 49}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 48}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 49}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :ej, :tkns [{:type :a, :id 49}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 49}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 50}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 49}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 50}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :ej, :tkns [{:type :a, :id 50}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 50}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 51}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 50}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 51}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :ej, :tkns [{:type :a, :id 51}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 51}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 52}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 51}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 52}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :bj, :tkns [{:type :a, :id 54}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 54}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :aj, :tkns [{:type :a, :id 54} {:type :a, :id 55}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 55}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 54}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :ej, :tkns [{:type :a, :id 52}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 52}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 53}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 52}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 53}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :bj, :tkns [{:type :a, :id 55}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 55}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :aj, :tkns [{:type :a, :id 56} {:type :a, :id 55}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 56}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 55}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 56}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 56}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :aj, :tkns [{:type :a, :id 56} {:type :a, :id 57}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 57}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 56}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 57}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 57}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :aj, :tkns [{:type :a, :id 58} {:type :a, :id 57}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 58}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 57}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 58}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 58}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :aj, :tkns [{:type :a, :id 58} {:type :a, :id 59}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 59}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 58}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 59}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 59}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 53}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 53}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 54}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 53}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 54}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 59} {:type :a, :id 60}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 60}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 59}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 60}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 60}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 54}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 54}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 55}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 54}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 55}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 61} {:type :a, :id 60}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 61}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 60}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 61}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 61}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 55}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 55}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 56}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 55}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 56}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 61} {:type :a, :id 62}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 62}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 61}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :ej, :tkns [{:type :a, :id 56}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 56}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 57}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 56}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 57}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :bj, :tkns [{:type :a, :id 62}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 62}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :aj, :tkns [{:type :a, :id 62} {:type :a, :id 63}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 63}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 62}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 63}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 63}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 57}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 57}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 58}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 57}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 58}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 63} {:type :a, :id 64}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 64}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 63}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 64}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 64}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 58}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 58}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 59}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 58}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 59}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 65} {:type :a, :id 64}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 65}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 64}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 65}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 65}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 59}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 59}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 60}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 59}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 60}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 65} {:type :a, :id 66}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 66}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 65}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 66}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 66}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 60}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 60}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 61}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 60}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 61}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 67} {:type :a, :id 66}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 67}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 66}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 67}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 67}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 61}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 61}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 62}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 61}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 62}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 67} {:type :a, :id 68}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 68}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 67}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 68}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 68}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 62}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 62}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 63}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 62}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 63}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 69} {:type :a, :id 68}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 69}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 68}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 69}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 69}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 63}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 63}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 64}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 63}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 64}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 69} {:type :a, :id 70}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 70}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 69}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :ej, :tkns [{:type :a, :id 64}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 64}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 65}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 64}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 65}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :bj, :tkns [{:type :a, :id 70}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 70}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :aj, :tkns [{:type :a, :id 71} {:type :a, :id 70}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 71}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 70}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 71}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 71}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 65}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 65}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 66}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 65}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 66}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 71} {:type :a, :id 72}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 72}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 71}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 72}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 72}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 66}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 66}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 67}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 66}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 67}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 73} {:type :a, :id 72}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 73}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 72}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 73}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 73}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 67}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 67}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 68}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 67}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 68}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 73} {:type :a, :id 74}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 74}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 73}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 74}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 74}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 68}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 68}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 69}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 68}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 69}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 74} {:type :a, :id 75}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 75}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 74}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 75}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 75}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 69}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 69}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 70}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 69}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 70}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 76} {:type :a, :id 75}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 76}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 75}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 76}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 76}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 70}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 70}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 71}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 70}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 71}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 77} {:type :a, :id 76}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 77}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 76}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :ej, :tkns [{:type :a, :id 71}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 71}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 72}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 71}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 72}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :bj, :tkns [{:type :a, :id 77}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 77}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :aj, :tkns [{:type :a, :id 78} {:type :a, :id 77}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 78}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 77}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 78}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 78}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 72}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 72}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 73}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 72}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 73}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 78} {:type :a, :id 79}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 79}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 78}, :motion :move, :from :m1-blocked, :to :buffer}
   {:act :bj, :tkns [{:type :a, :id 79}]}
   {:on-act :m1-complete-job, :tkn {:type :a, :id 79}, :motion :move, :from :m1-busy, :to :m1-blocked}
   {:act :ej, :tkns [{:type :a, :id 73}]}
   {:on-act :m2-complete-job, :tkn {:type :a, :id 73}, :motion :move, :from :m2-busy, :to :m2-starved}
   {:act :sm, :tkns [{:type :a, :id 74}]}
   {:on-act :m2-start-job, :tkn {:type :a, :id 73}, :motion :remove}
   {:on-act :m2-start-job, :tkn {:type :a, :id 74}, :motion :move, :from :buffer, :to :m2-busy}
   {:act :aj, :tkns [{:type :a, :id 80} {:type :a, :id 79}]}
   {:on-act :m1-start-job, :tkn {:type :a, :id 80}, :motion :add}
   {:on-act :m1-start-job, :tkn {:type :a, :id 79}, :motion :move, :from :m1-blocked, :to :buffer}])
