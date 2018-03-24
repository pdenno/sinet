;;; This created 2018-03-24 for the 2-machine parallel example for JMS.

{:clk 647.1413, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 362,    :dets {:run {:m3-1 357, :m4 358, :m2 nil, :m1 364, :m3-2 359}, :bufs {:b2 [360 361], :b1 [362 363], :b3 []}}, :line 0}
{:clk 647.1413, :act :m1-unblocked, :m :m1, :mjpact :ub,                           :dets {:run {:m3-1 357, :m4 358, :m2 362, :m1 364, :m3-2 359}, :bufs {:b2 [360 361], :b1 [363], :b3 []}}, :line 1}
{:clk 647.1413, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 364, :dets {:run {:m3-1 357, :m4 358, :m2 362, :m1 364, :m3-2 359}, :bufs {:b2 [360 361], :b1 [363], :b3 []}}, :line 2}
{:clk 647.1413, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 648.1413, :j 365, :dets {:run {:m3-1 357, :m4 358, :m2 362, :m1 nil, :m3-2 359}, :bufs {:b2 [360 361], :b1 [363 364], :b3 []}}, :line 3}
{:clk 648.1413, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 634.7642, :j 358, :dets {:run {:m3-1 357, :m4 358, :m2 362, :m1 365, :m3-2 359}, :bufs {:b2 [360 361], :b1 [363 364], :b3 []}}, :line 4}
{:clk 648.1413, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 357, :m4 nil, :m2 362, :m1 365, :m3-2 359}, :bufs {:b2 [360 361], :b1 [363 364], :b3 []}}, :line 5}
{:clk 648.1413, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 357, :m4 nil, :m2 362, :m1 365, :m3-2 359}, :bufs {:b2 [360 361], :b1 [363 364], :b3 []}}, :line 6}
{:clk 648.1413, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 357, :m4 nil, :m2 362, :m1 365, :m3-2 359}, :bufs {:b2 [360 361], :b1 [363 364], :b3 []}}, :line 7}
{:clk 650.1413, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 359, :dets {:run {:m3-1 357, :m4 nil, :m2 362, :m1 365, :m3-2 359}, :bufs {:b2 [360 361], :b1 [363 364], :b3 []}}, :line 8}
{:clk 650.1413, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 360, :dets {:run {:m3-1 357, :m4 nil, :m2 362, :m1 365, :m3-2 nil}, :bufs {:b2 [360 361], :b1 [363 364], :b3 [359]}}, :line 9}
{:clk 650.1413, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 357, :m4 nil, :m2 362, :m1 365, :m3-2 360}, :bufs {:b2 [361], :b1 [363 364], :b3 [359]}}, :line 10}
{:clk 650.1413, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 359, :dets {:run {:m3-1 357, :m4 nil, :m2 362, :m1 365, :m3-2 360}, :bufs {:b2 [361], :b1 [363 364], :b3 [359]}}, :line 11}
{:clk 650.1413, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 357, :m4 359, :m2 362, :m1 365, :m3-2 360}, :bufs {:b2 [361], :b1 [363 364], :b3 []}}, :line 12}
{:clk 650.1413, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 362, :dets {:run {:m3-1 357, :m4 359, :m2 362, :m1 365, :m3-2 360}, :bufs {:b2 [361], :b1 [363 364], :b3 []}}, :line 13}
{:clk 650.1413, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 363, :dets {:run {:m3-1 357, :m4 359, :m2 nil, :m1 365, :m3-2 360}, :bufs {:b2 [361 362], :b1 [363 364], :b3 []}}, :line 14}
{:clk 650.1413, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 357, :m4 359, :m2 363, :m1 365, :m3-2 360}, :bufs {:b2 [361 362], :b1 [364], :b3 []}}, :line 15}
{:clk 650.1413, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 365, :dets {:run {:m3-1 357, :m4 359, :m2 363, :m1 365, :m3-2 360}, :bufs {:b2 [361 362], :b1 [364], :b3 []}}, :line 16}
{:clk 650.1413, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 652.9349, :j 366, :dets {:run {:m3-1 357, :m4 359, :m2 363, :m1 nil, :m3-2 360}, :bufs {:b2 [361 362], :b1 [364 365], :b3 []}}, :line 17}
{:clk 651.1413, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 635.7642, :j 359, :dets {:run {:m3-1 357, :m4 359, :m2 363, :m1 366, :m3-2 360}, :bufs {:b2 [361 362], :b1 [364 365], :b3 []}}, :line 18}
{:clk 651.1413, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 357, :m4 nil, :m2 363, :m1 366, :m3-2 360}, :bufs {:b2 [361 362], :b1 [364 365], :b3 []}}, :line 19}
{:clk 651.1413, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 357, :m4 nil, :m2 363, :m1 366, :m3-2 360}, :bufs {:b2 [361 362], :b1 [364 365], :b3 []}}, :line 20}
{:clk 652.9349, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 357, :m4 nil, :m2 363, :m1 366, :m3-2 360}, :bufs {:b2 [361 362], :b1 [364 365], :b3 []}}, :line 21}
{:clk 653.1413, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 360, :dets {:run {:m3-1 357, :m4 nil, :m2 363, :m1 366, :m3-2 360}, :bufs {:b2 [361 362], :b1 [364 365], :b3 []}}, :line 22}
{:clk 653.1413, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 361, :dets {:run {:m3-1 357, :m4 nil, :m2 363, :m1 366, :m3-2 nil}, :bufs {:b2 [361 362], :b1 [364 365], :b3 [360]}}, :line 23}
{:clk 653.1413, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 357, :m4 nil, :m2 363, :m1 366, :m3-2 361}, :bufs {:b2 [362], :b1 [364 365], :b3 [360]}}, :line 24}
{:clk 653.1413, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 357, :m4 nil, :m2 363, :m1 366, :m3-2 361}, :bufs {:b2 [362], :b1 [364 365], :b3 [360]}}, :line 25}
{:clk 653.1413, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 363, :dets {:run {:m3-1 357, :m4 nil, :m2 363, :m1 366, :m3-2 361}, :bufs {:b2 [362], :b1 [364 365], :b3 [360]}}, :line 26}
{:clk 653.1413, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 364, :dets {:run {:m3-1 357, :m4 nil, :m2 nil, :m1 366, :m3-2 361}, :bufs {:b2 [362 363], :b1 [364 365], :b3 [360]}}, :line 27}
{:clk 653.1413, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 357, :m4 nil, :m2 364, :m1 366, :m3-2 361}, :bufs {:b2 [362 363], :b1 [365], :b3 [360]}}, :line 28}
{:clk 653.1413, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 366, :dets {:run {:m3-1 357, :m4 nil, :m2 364, :m1 366, :m3-2 361}, :bufs {:b2 [362 363], :b1 [365], :b3 [360]}}, :line 29}
{:clk 653.1413, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 654.1413, :j 367, :dets {:run {:m3-1 357, :m4 nil, :m2 364, :m1 nil, :m3-2 361}, :bufs {:b2 [362 363], :b1 [365 366], :b3 [360]}}, :line 30}
{:clk 654.1413, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 357, :m4 nil, :m2 364, :m1 367, :m3-2 361}, :bufs {:b2 [362 363], :b1 [365 366], :b3 [360]}}, :line 31}
{:clk 654.1413, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 357, :m4 nil, :m2 364, :m1 367, :m3-2 361}, :bufs {:b2 [362 363], :b1 [365 366], :b3 [360]}}, :line 32}
{:clk 654.492, :act :m3-1-blocked, :m :m3-1, :mjpact :bl, :dets {:run {:m3-1 357, :m4 nil, :m2 364, :m1 367, :m3-2 361}, :bufs {:b2 [362 363], :b1 [365 366], :b3 [360]}}, :line 33}
{:clk 656.9731, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 360, :dets {:run {:m3-1 357, :m4 nil, :m2 364, :m1 367, :m3-2 361}, :bufs {:b2 [362 363], :b1 [365 366], :b3 [360]}}, :line 34}
{:clk 656.9731, :act :m3-1-unblocked, :m :m3-1, :mjpact :ub, :dets {:run {:m3-1 357, :m4 360, :m2 364, :m1 367, :m3-2 361}, :bufs {:b2 [362 363], :b1 [365 366], :b3 []}}, :line 35}
{:clk 656.9731, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 357, :dets {:run {:m3-1 357, :m4 360, :m2 364, :m1 367, :m3-2 361}, :bufs {:b2 [362 363], :b1 [365 366], :b3 []}}, :line 36}
{:clk 656.9731, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 362, :dets {:run {:m3-1 nil, :m4 360, :m2 364, :m1 367, :m3-2 361}, :bufs {:b2 [362 363], :b1 [365 366], :b3 [357]}}, :line 37}
{:clk 656.9731, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 362, :m4 360, :m2 364, :m1 367, :m3-2 361}, :bufs {:b2 [363], :b1 [365 366], :b3 [357]}}, :line 38}
{:clk 656.9731, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 364, :dets {:run {:m3-1 362, :m4 360, :m2 364, :m1 367, :m3-2 361}, :bufs {:b2 [363], :b1 [365 366], :b3 [357]}}, :line 39}
{:clk 656.9731, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 365, :dets {:run {:m3-1 362, :m4 360, :m2 nil, :m1 367, :m3-2 361}, :bufs {:b2 [363 364], :b1 [365 366], :b3 [357]}}, :line 40}
{:clk 656.9731, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 362, :m4 360, :m2 365, :m1 367, :m3-2 361}, :bufs {:b2 [363 364], :b1 [366], :b3 [357]}}, :line 41}
{:clk 656.9731, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 367, :dets {:run {:m3-1 362, :m4 360, :m2 365, :m1 367, :m3-2 361}, :bufs {:b2 [363 364], :b1 [366], :b3 [357]}}, :line 42}
{:clk 656.9731, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 657.9731, :j 368, :dets {:run {:m3-1 362, :m4 360, :m2 365, :m1 nil, :m3-2 361}, :bufs {:b2 [363 364], :b1 [366 367], :b3 [357]}}, :line 43}
{:clk 657.8363, :act :m3-2-blocked, :m :m3-2, :mjpact :bl, :dets {:run {:m3-1 362, :m4 360, :m2 365, :m1 368, :m3-2 361}, :bufs {:b2 [363 364], :b1 [366 367], :b3 [357]}}, :line 44}
{:clk 657.9731, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 637.5413, :j 360, :dets {:run {:m3-1 362, :m4 360, :m2 365, :m1 368, :m3-2 361}, :bufs {:b2 [363 364], :b1 [366 367], :b3 [357]}}, :line 45}
{:clk 657.9731, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 357, :dets {:run {:m3-1 362, :m4 nil, :m2 365, :m1 368, :m3-2 361}, :bufs {:b2 [363 364], :b1 [366 367], :b3 [357]}}, :line 46}
{:clk 657.9731, :act :m3-2-unblocked, :m :m3-2, :mjpact :ub, :dets {:run {:m3-1 362, :m4 357, :m2 365, :m1 368, :m3-2 361}, :bufs {:b2 [363 364], :b1 [366 367], :b3 []}}, :line 47}
{:clk 657.9731, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 361, :dets {:run {:m3-1 362, :m4 357, :m2 365, :m1 368, :m3-2 361}, :bufs {:b2 [363 364], :b1 [366 367], :b3 []}}, :line 48}
{:clk 657.9731, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 363, :dets {:run {:m3-1 362, :m4 357, :m2 365, :m1 368, :m3-2 nil}, :bufs {:b2 [363 364], :b1 [366 367], :b3 [361]}}, :line 49}
{:clk 657.9731, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 365, :dets {:run {:m3-1 362, :m4 357, :m2 365, :m1 368, :m3-2 363}, :bufs {:b2 [364], :b1 [366 367], :b3 [361]}}, :line 50}
{:clk 657.9731, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 366, :dets {:run {:m3-1 362, :m4 357, :m2 nil, :m1 368, :m3-2 363}, :bufs {:b2 [364 365], :b1 [366 367], :b3 [361]}}, :line 51}
{:clk 657.9731, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 368, :dets {:run {:m3-1 362, :m4 357, :m2 366, :m1 368, :m3-2 363}, :bufs {:b2 [364 365], :b1 [367], :b3 [361]}}, :line 52}
{:clk 657.9731, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 658.9731, :j 369, :dets {:run {:m3-1 362, :m4 357, :m2 366, :m1 nil, :m3-2 363}, :bufs {:b2 [364 365], :b1 [367 368], :b3 [361]}}, :line 53}
{:clk 658.9731, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 362, :m4 357, :m2 366, :m1 369, :m3-2 363}, :bufs {:b2 [364 365], :b1 [367 368], :b3 [361]}}, :line 54}
{:clk 658.9731, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 362, :m4 357, :m2 366, :m1 369, :m3-2 363}, :bufs {:b2 [364 365], :b1 [367 368], :b3 [361]}}, :line 55}
{:clk 659.1731, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 633.7642, :j 357, :dets {:run {:m3-1 362, :m4 357, :m2 366, :m1 369, :m3-2 363}, :bufs {:b2 [364 365], :b1 [367 368], :b3 [361]}}, :line 56}
{:clk 659.1731, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 361, :dets {:run {:m3-1 362, :m4 nil, :m2 366, :m1 369, :m3-2 363}, :bufs {:b2 [364 365], :b1 [367 368], :b3 [361]}}, :line 57}
{:clk 660.1731, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 638.5413, :j 361, :dets {:run {:m3-1 362, :m4 361, :m2 366, :m1 369, :m3-2 363}, :bufs {:b2 [364 365], :b1 [367 368], :b3 []}}, :line 58}
{:clk 660.1731, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 362, :m4 nil, :m2 366, :m1 369, :m3-2 363}, :bufs {:b2 [364 365], :b1 [367 368], :b3 []}}, :line 59}
{:clk 660.9731, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 363, :dets {:run {:m3-1 362, :m4 nil, :m2 366, :m1 369, :m3-2 363}, :bufs {:b2 [364 365], :b1 [367 368], :b3 []}}, :line 60}
{:clk 660.9731, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 364, :dets {:run {:m3-1 362, :m4 nil, :m2 366, :m1 369, :m3-2 nil}, :bufs {:b2 [364 365], :b1 [367 368], :b3 [363]}}, :line 61}
{:clk 660.9731, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 362, :m4 nil, :m2 366, :m1 369, :m3-2 364}, :bufs {:b2 [365], :b1 [367 368], :b3 [363]}}, :line 62}
{:clk 660.9731, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 363, :dets {:run {:m3-1 362, :m4 nil, :m2 366, :m1 369, :m3-2 364}, :bufs {:b2 [365], :b1 [367 368], :b3 [363]}}, :line 63}
{:clk 660.9731, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 362, :m4 363, :m2 366, :m1 369, :m3-2 364}, :bufs {:b2 [365], :b1 [367 368], :b3 []}}, :line 64}
{:clk 660.9731, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 366, :dets {:run {:m3-1 362, :m4 363, :m2 366, :m1 369, :m3-2 364}, :bufs {:b2 [365], :b1 [367 368], :b3 []}}, :line 65}
{:clk 660.9731, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 367, :dets {:run {:m3-1 362, :m4 363, :m2 nil, :m1 369, :m3-2 364}, :bufs {:b2 [365 366], :b1 [367 368], :b3 []}}, :line 66}
{:clk 660.9731, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 362, :m4 363, :m2 367, :m1 369, :m3-2 364}, :bufs {:b2 [365 366], :b1 [368], :b3 []}}, :line 67}
{:clk 660.9731, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 369, :dets {:run {:m3-1 362, :m4 363, :m2 367, :m1 369, :m3-2 364}, :bufs {:b2 [365 366], :b1 [368], :b3 []}}, :line 68}
{:clk 660.9731, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType2, :ends 661.9731, :j 370, :dets {:run {:m3-1 362, :m4 363, :m2 367, :m1 nil, :m3-2 364}, :bufs {:b2 [365 366], :b1 [368 369], :b3 []}}, :line 69}
{:clk 661.0995, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 362, :dets {:run {:m3-1 362, :m4 363, :m2 367, :m1 370, :m3-2 364}, :bufs {:b2 [365 366], :b1 [368 369], :b3 []}}, :line 70}
{:clk 661.0995, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 365, :dets {:run {:m3-1 nil, :m4 363, :m2 367, :m1 370, :m3-2 364}, :bufs {:b2 [365 366], :b1 [368 369], :b3 [362]}}, :line 71}
{:clk 661.9731, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 642.8678, :j 363, :dets {:run {:m3-1 365, :m4 363, :m2 367, :m1 370, :m3-2 364}, :bufs {:b2 [366], :b1 [368 369], :b3 [362]}}, :line 72}
{:clk 661.9731, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 367, :dets {:run {:m3-1 365, :m4 nil, :m2 367, :m1 370, :m3-2 364}, :bufs {:b2 [366], :b1 [368 369], :b3 [362]}}, :line 73}
{:clk 661.9731, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 362, :dets {:run {:m3-1 365, :m4 nil, :m2 nil, :m1 370, :m3-2 364}, :bufs {:b2 [366 367], :b1 [368 369], :b3 [362]}}, :line 74}
{:clk 661.9731, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 368, :dets {:run {:m3-1 365, :m4 362, :m2 nil, :m1 370, :m3-2 364}, :bufs {:b2 [366 367], :b1 [368 369], :b3 []}}, :line 75}
{:clk 661.9731, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 370, :dets {:run {:m3-1 365, :m4 362, :m2 368, :m1 370, :m3-2 364}, :bufs {:b2 [366 367], :b1 [369], :b3 []}}, :line 76}
{:clk 661.9731, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 662.9731, :j 371, :dets {:run {:m3-1 365, :m4 362, :m2 368, :m1 nil, :m3-2 364}, :bufs {:b2 [366 367], :b1 [369 370], :b3 []}}, :line 77}
{:clk 662.9731, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 641.1413, :j 362, :dets {:run {:m3-1 365, :m4 362, :m2 368, :m1 371, :m3-2 364}, :bufs {:b2 [366 367], :b1 [369 370], :b3 []}}, :line 78}
{:clk 662.9731, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 365, :m4 nil, :m2 368, :m1 371, :m3-2 364}, :bufs {:b2 [366 367], :b1 [369 370], :b3 []}}, :line 79}
{:clk 662.9731, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 365, :m4 nil, :m2 368, :m1 371, :m3-2 364}, :bufs {:b2 [366 367], :b1 [369 370], :b3 []}}, :line 80}
{:clk 662.9731, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 365, :m4 nil, :m2 368, :m1 371, :m3-2 364}, :bufs {:b2 [366 367], :b1 [369 370], :b3 []}}, :line 81}
{:clk 663.9731, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 364, :dets {:run {:m3-1 365, :m4 nil, :m2 368, :m1 371, :m3-2 364}, :bufs {:b2 [366 367], :b1 [369 370], :b3 []}}, :line 82}
{:clk 663.9731, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 366, :dets {:run {:m3-1 365, :m4 nil, :m2 368, :m1 371, :m3-2 nil}, :bufs {:b2 [366 367], :b1 [369 370], :b3 [364]}}, :line 83}
{:clk 663.9731, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 365, :m4 nil, :m2 368, :m1 371, :m3-2 366}, :bufs {:b2 [367], :b1 [369 370], :b3 [364]}}, :line 84}
{:clk 663.9731, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 364, :dets {:run {:m3-1 365, :m4 nil, :m2 368, :m1 371, :m3-2 366}, :bufs {:b2 [367], :b1 [369 370], :b3 [364]}}, :line 85}
{:clk 663.9731, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 365, :m4 364, :m2 368, :m1 371, :m3-2 366}, :bufs {:b2 [367], :b1 [369 370], :b3 []}}, :line 86}
{:clk 663.9731, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 368, :dets {:run {:m3-1 365, :m4 364, :m2 368, :m1 371, :m3-2 366}, :bufs {:b2 [367], :b1 [369 370], :b3 []}}, :line 87}
{:clk 663.9731, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 369, :dets {:run {:m3-1 365, :m4 364, :m2 nil, :m1 371, :m3-2 366}, :bufs {:b2 [367 368], :b1 [369 370], :b3 []}}, :line 88}
{:clk 663.9731, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 365, :m4 364, :m2 369, :m1 371, :m3-2 366}, :bufs {:b2 [367 368], :b1 [370], :b3 []}}, :line 89}
{:clk 663.9731, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 371, :dets {:run {:m3-1 365, :m4 364, :m2 369, :m1 371, :m3-2 366}, :bufs {:b2 [367 368], :b1 [370], :b3 []}}, :line 90}
{:clk 663.9731, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType2, :ends 664.9731, :j 372, :dets {:run {:m3-1 365, :m4 364, :m2 369, :m1 nil, :m3-2 366}, :bufs {:b2 [367 368], :b1 [370 371], :b3 []}}, :line 91}
{:clk 664.9731, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 644.1413, :j 364, :dets {:run {:m3-1 365, :m4 364, :m2 369, :m1 372, :m3-2 366}, :bufs {:b2 [367 368], :b1 [370 371], :b3 []}}, :line 92}
{:clk 664.9731, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 365, :m4 nil, :m2 369, :m1 372, :m3-2 366}, :bufs {:b2 [367 368], :b1 [370 371], :b3 []}}, :line 93}
{:clk 664.9731, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 365, :m4 nil, :m2 369, :m1 372, :m3-2 366}, :bufs {:b2 [367 368], :b1 [370 371], :b3 []}}, :line 94}
{:clk 664.9731, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 365, :m4 nil, :m2 369, :m1 372, :m3-2 366}, :bufs {:b2 [367 368], :b1 [370 371], :b3 []}}, :line 95}
{:clk 666.9731, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 366, :dets {:run {:m3-1 365, :m4 nil, :m2 369, :m1 372, :m3-2 366}, :bufs {:b2 [367 368], :b1 [370 371], :b3 []}}, :line 96}
{:clk 666.9731, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 367, :dets {:run {:m3-1 365, :m4 nil, :m2 369, :m1 372, :m3-2 nil}, :bufs {:b2 [367 368], :b1 [370 371], :b3 [366]}}, :line 97}
{:clk 666.9731, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 365, :m4 nil, :m2 369, :m1 372, :m3-2 367}, :bufs {:b2 [368], :b1 [370 371], :b3 [366]}}, :line 98}
{:clk 666.9731, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 366, :dets {:run {:m3-1 365, :m4 nil, :m2 369, :m1 372, :m3-2 367}, :bufs {:b2 [368], :b1 [370 371], :b3 [366]}}, :line 99}
{:clk 666.9731, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 365, :m4 366, :m2 369, :m1 372, :m3-2 367}, :bufs {:b2 [368], :b1 [370 371], :b3 []}}, :line 100}
{:clk 666.9731, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 369, :dets {:run {:m3-1 365, :m4 366, :m2 369, :m1 372, :m3-2 367}, :bufs {:b2 [368], :b1 [370 371], :b3 []}}, :line 101}
{:clk 666.9731, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 370, :dets {:run {:m3-1 365, :m4 366, :m2 nil, :m1 372, :m3-2 367}, :bufs {:b2 [368 369], :b1 [370 371], :b3 []}}, :line 102}
{:clk 666.9731, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 365, :m4 366, :m2 370, :m1 372, :m3-2 367}, :bufs {:b2 [368 369], :b1 [371], :b3 []}}, :line 103}
{:clk 666.9731, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 372, :dets {:run {:m3-1 365, :m4 366, :m2 370, :m1 372, :m3-2 367}, :bufs {:b2 [368 369], :b1 [371], :b3 []}}, :line 104}
{:clk 666.9731, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 667.9731, :j 373, :dets {:run {:m3-1 365, :m4 366, :m2 370, :m1 nil, :m3-2 367}, :bufs {:b2 [368 369], :b1 [371 372], :b3 []}}, :line 105}
{:clk 667.9731, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 650.1413, :j 366, :dets {:run {:m3-1 365, :m4 366, :m2 370, :m1 373, :m3-2 367}, :bufs {:b2 [368 369], :b1 [371 372], :b3 []}}, :line 106}
{:clk 667.9731, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 365, :m4 nil, :m2 370, :m1 373, :m3-2 367}, :bufs {:b2 [368 369], :b1 [371 372], :b3 []}}, :line 107}
{:clk 667.9731, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 365, :m4 nil, :m2 370, :m1 373, :m3-2 367}, :bufs {:b2 [368 369], :b1 [371 372], :b3 []}}, :line 108}
{:clk 667.9731, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 365, :m4 nil, :m2 370, :m1 373, :m3-2 367}, :bufs {:b2 [368 369], :b1 [371 372], :b3 []}}, :line 109}
{:clk 669.9731, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 367, :dets {:run {:m3-1 365, :m4 nil, :m2 370, :m1 373, :m3-2 367}, :bufs {:b2 [368 369], :b1 [371 372], :b3 []}}, :line 110}
{:clk 669.9731, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 368, :dets {:run {:m3-1 365, :m4 nil, :m2 370, :m1 373, :m3-2 nil}, :bufs {:b2 [368 369], :b1 [371 372], :b3 [367]}}, :line 111}
{:clk 669.9731, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 365, :m4 nil, :m2 370, :m1 373, :m3-2 368}, :bufs {:b2 [369], :b1 [371 372], :b3 [367]}}, :line 112}
{:clk 669.9731, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 367, :dets {:run {:m3-1 365, :m4 nil, :m2 370, :m1 373, :m3-2 368}, :bufs {:b2 [369], :b1 [371 372], :b3 [367]}}, :line 113}
{:clk 669.9731, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 365, :m4 367, :m2 370, :m1 373, :m3-2 368}, :bufs {:b2 [369], :b1 [371 372], :b3 []}}, :line 114}
{:clk 669.9731, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 370, :dets {:run {:m3-1 365, :m4 367, :m2 370, :m1 373, :m3-2 368}, :bufs {:b2 [369], :b1 [371 372], :b3 []}}, :line 115}
{:clk 669.9731, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 371, :dets {:run {:m3-1 365, :m4 367, :m2 nil, :m1 373, :m3-2 368}, :bufs {:b2 [369 370], :b1 [371 372], :b3 []}}, :line 116}
{:clk 669.9731, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 365, :m4 367, :m2 371, :m1 373, :m3-2 368}, :bufs {:b2 [369 370], :b1 [372], :b3 []}}, :line 117}
{:clk 669.9731, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 373, :dets {:run {:m3-1 365, :m4 367, :m2 371, :m1 373, :m3-2 368}, :bufs {:b2 [369 370], :b1 [372], :b3 []}}, :line 118}
{:clk 669.9731, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType2, :ends 670.9731, :j 374, :dets {:run {:m3-1 365, :m4 367, :m2 371, :m1 nil, :m3-2 368}, :bufs {:b2 [369 370], :b1 [372 373], :b3 []}}, :line 119}
{:clk 670.9731, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 653.1413, :j 367, :dets {:run {:m3-1 365, :m4 367, :m2 371, :m1 374, :m3-2 368}, :bufs {:b2 [369 370], :b1 [372 373], :b3 []}}, :line 120}
{:clk 670.9731, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 365, :m4 nil, :m2 371, :m1 374, :m3-2 368}, :bufs {:b2 [369 370], :b1 [372 373], :b3 []}}, :line 121}
{:clk 670.9731, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 365, :m4 nil, :m2 371, :m1 374, :m3-2 368}, :bufs {:b2 [369 370], :b1 [372 373], :b3 []}}, :line 122}
{:clk 670.9731, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 365, :m4 nil, :m2 371, :m1 374, :m3-2 368}, :bufs {:b2 [369 370], :b1 [372 373], :b3 []}}, :line 123}
{:clk 671.7865, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 365, :dets {:run {:m3-1 365, :m4 nil, :m2 371, :m1 374, :m3-2 368}, :bufs {:b2 [369 370], :b1 [372 373], :b3 []}}, :line 124}
{:clk 671.7865, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 369, :dets {:run {:m3-1 nil, :m4 nil, :m2 371, :m1 374, :m3-2 368}, :bufs {:b2 [369 370], :b1 [372 373], :b3 [365]}}, :line 125}
{:clk 671.7865, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 369, :m4 nil, :m2 371, :m1 374, :m3-2 368}, :bufs {:b2 [370], :b1 [372 373], :b3 [365]}}, :line 126}
{:clk 671.7865, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 365, :dets {:run {:m3-1 369, :m4 nil, :m2 371, :m1 374, :m3-2 368}, :bufs {:b2 [370], :b1 [372 373], :b3 [365]}}, :line 127}
{:clk 671.7865, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 369, :m4 365, :m2 371, :m1 374, :m3-2 368}, :bufs {:b2 [370], :b1 [372 373], :b3 []}}, :line 128}
{:clk 671.7865, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 371, :dets {:run {:m3-1 369, :m4 365, :m2 371, :m1 374, :m3-2 368}, :bufs {:b2 [370], :b1 [372 373], :b3 []}}, :line 129}
{:clk 671.7865, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 372, :dets {:run {:m3-1 369, :m4 365, :m2 nil, :m1 374, :m3-2 368}, :bufs {:b2 [370 371], :b1 [372 373], :b3 []}}, :line 130}
{:clk 671.7865, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 369, :m4 365, :m2 372, :m1 374, :m3-2 368}, :bufs {:b2 [370 371], :b1 [373], :b3 []}}, :line 131}
{:clk 671.7865, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 374, :dets {:run {:m3-1 369, :m4 365, :m2 372, :m1 374, :m3-2 368}, :bufs {:b2 [370 371], :b1 [373], :b3 []}}, :line 132}
{:clk 671.7865, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType2, :ends 672.7865, :j 375, :dets {:run {:m3-1 369, :m4 365, :m2 372, :m1 nil, :m3-2 368}, :bufs {:b2 [370 371], :b1 [373 374], :b3 []}}, :line 133}
{:clk 672.7865, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 647.1413, :j 365, :dets {:run {:m3-1 369, :m4 365, :m2 372, :m1 375, :m3-2 368}, :bufs {:b2 [370 371], :b1 [373 374], :b3 []}}, :line 134}
{:clk 672.7865, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 369, :m4 nil, :m2 372, :m1 375, :m3-2 368}, :bufs {:b2 [370 371], :b1 [373 374], :b3 []}}, :line 135}
{:clk 672.7865, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 369, :m4 nil, :m2 372, :m1 375, :m3-2 368}, :bufs {:b2 [370 371], :b1 [373 374], :b3 []}}, :line 136}
{:clk 672.7865, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 369, :m4 nil, :m2 372, :m1 375, :m3-2 368}, :bufs {:b2 [370 371], :b1 [373 374], :b3 []}}, :line 137}
{:clk 676.2058, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 369, :dets {:run {:m3-1 369, :m4 nil, :m2 372, :m1 375, :m3-2 368}, :bufs {:b2 [370 371], :b1 [373 374], :b3 []}}, :line 138}
{:clk 676.2058, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 370, :dets {:run {:m3-1 nil, :m4 nil, :m2 372, :m1 375, :m3-2 368}, :bufs {:b2 [370 371], :b1 [373 374], :b3 [369]}}, :line 139}
{:clk 676.2058, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 370, :m4 nil, :m2 372, :m1 375, :m3-2 368}, :bufs {:b2 [371], :b1 [373 374], :b3 [369]}}, :line 140}
{:clk 676.2058, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 369, :dets {:run {:m3-1 370, :m4 nil, :m2 372, :m1 375, :m3-2 368}, :bufs {:b2 [371], :b1 [373 374], :b3 [369]}}, :line 141}
{:clk 676.2058, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 370, :m4 369, :m2 372, :m1 375, :m3-2 368}, :bufs {:b2 [371], :b1 [373 374], :b3 []}}, :line 142}
{:clk 676.2058, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 372, :dets {:run {:m3-1 370, :m4 369, :m2 372, :m1 375, :m3-2 368}, :bufs {:b2 [371], :b1 [373 374], :b3 []}}, :line 143}
{:clk 676.2058, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 373, :dets {:run {:m3-1 370, :m4 369, :m2 nil, :m1 375, :m3-2 368}, :bufs {:b2 [371 372], :b1 [373 374], :b3 []}}, :line 144}
{:clk 676.2058, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 370, :m4 369, :m2 373, :m1 375, :m3-2 368}, :bufs {:b2 [371 372], :b1 [374], :b3 []}}, :line 145}
{:clk 676.2058, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 375, :dets {:run {:m3-1 370, :m4 369, :m2 373, :m1 375, :m3-2 368}, :bufs {:b2 [371 372], :b1 [374], :b3 []}}, :line 146}
{:clk 676.2058, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 677.2058, :j 376, :dets {:run {:m3-1 370, :m4 369, :m2 373, :m1 nil, :m3-2 368}, :bufs {:b2 [371 372], :b1 [374 375], :b3 []}}, :line 147}
{:clk 677.2058, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 657.9731, :j 369, :dets {:run {:m3-1 370, :m4 369, :m2 373, :m1 376, :m3-2 368}, :bufs {:b2 [371 372], :b1 [374 375], :b3 []}}, :line 148}
{:clk 677.2058, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 370, :m4 nil, :m2 373, :m1 376, :m3-2 368}, :bufs {:b2 [371 372], :b1 [374 375], :b3 []}}, :line 149}
{:clk 677.2058, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 370, :m4 nil, :m2 373, :m1 376, :m3-2 368}, :bufs {:b2 [371 372], :b1 [374 375], :b3 []}}, :line 150}
{:clk 677.2058, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 370, :m4 nil, :m2 373, :m1 376, :m3-2 368}, :bufs {:b2 [371 372], :b1 [374 375], :b3 []}}, :line 151}
{:clk 679.8058, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 370, :dets {:run {:m3-1 370, :m4 nil, :m2 373, :m1 376, :m3-2 368}, :bufs {:b2 [371 372], :b1 [374 375], :b3 []}}, :line 152}
{:clk 679.8058, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 371, :dets {:run {:m3-1 nil, :m4 nil, :m2 373, :m1 376, :m3-2 368}, :bufs {:b2 [371 372], :b1 [374 375], :b3 [370]}}, :line 153}
{:clk 679.8058, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 371, :m4 nil, :m2 373, :m1 376, :m3-2 368}, :bufs {:b2 [372], :b1 [374 375], :b3 [370]}}, :line 154}
{:clk 679.8058, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 370, :dets {:run {:m3-1 371, :m4 nil, :m2 373, :m1 376, :m3-2 368}, :bufs {:b2 [372], :b1 [374 375], :b3 [370]}}, :line 155}
{:clk 679.8058, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 371, :m4 370, :m2 373, :m1 376, :m3-2 368}, :bufs {:b2 [372], :b1 [374 375], :b3 []}}, :line 156}
{:clk 679.8058, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 373, :dets {:run {:m3-1 371, :m4 370, :m2 373, :m1 376, :m3-2 368}, :bufs {:b2 [372], :b1 [374 375], :b3 []}}, :line 157}
{:clk 679.8058, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 374, :dets {:run {:m3-1 371, :m4 370, :m2 nil, :m1 376, :m3-2 368}, :bufs {:b2 [372 373], :b1 [374 375], :b3 []}}, :line 158}
{:clk 679.8058, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 371, :m4 370, :m2 374, :m1 376, :m3-2 368}, :bufs {:b2 [372 373], :b1 [375], :b3 []}}, :line 159}
{:clk 679.8058, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 376, :dets {:run {:m3-1 371, :m4 370, :m2 374, :m1 376, :m3-2 368}, :bufs {:b2 [372 373], :b1 [375], :b3 []}}, :line 160}
{:clk 680.4594, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 368, :dets {:run {:m3-1 371, :m4 370, :m2 374, :m1 nil, :m3-2 368}, :bufs {:b2 [372 373], :b1 [375 376], :b3 []}}, :line 161}
{:clk 680.4594, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 372, :dets {:run {:m3-1 371, :m4 370, :m2 374, :m1 nil, :m3-2 nil}, :bufs {:b2 [372 373], :b1 [375 376], :b3 [368]}}, :line 162}
{:clk 681.0058, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 660.9731, :j 370, :dets {:run {:m3-1 371, :m4 370, :m2 374, :m1 nil, :m3-2 372}, :bufs {:b2 [373], :b1 [375 376], :b3 [368]}}, :line 163}
{:clk 681.0058, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 368, :dets {:run {:m3-1 371, :m4 nil, :m2 374, :m1 nil, :m3-2 372}, :bufs {:b2 [373], :b1 [375 376], :b3 [368]}}, :line 164}
{:clk 682.0058, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 656.9731, :j 368, :dets {:run {:m3-1 371, :m4 368, :m2 374, :m1 nil, :m3-2 372}, :bufs {:b2 [373], :b1 [375 376], :b3 []}}, :line 165}
{:clk 682.0058, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 371, :m4 nil, :m2 374, :m1 nil, :m3-2 372}, :bufs {:b2 [373], :b1 [375 376], :b3 []}}, :line 166}
{:clk 682.8058, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 371, :dets {:run {:m3-1 371, :m4 nil, :m2 374, :m1 nil, :m3-2 372}, :bufs {:b2 [373], :b1 [375 376], :b3 []}}, :line 167}
{:clk 682.8058, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 1, :j 373, :dets {:run {:m3-1 nil, :m4 nil, :m2 374, :m1 nil, :m3-2 372}, :bufs {:b2 [373], :b1 [375 376], :b3 [371]}}, :line 168}
{:clk 682.8058, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 373, :m4 nil, :m2 374, :m1 nil, :m3-2 372}, :bufs {:b2 [], :b1 [375 376], :b3 [371]}}, :line 169}
{:clk 682.8058, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 371, :dets {:run {:m3-1 373, :m4 nil, :m2 374, :m1 nil, :m3-2 372}, :bufs {:b2 [], :b1 [375 376], :b3 [371]}}, :line 170}
{:clk 683.8058, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 661.9731, :j 371, :dets {:run {:m3-1 373, :m4 371, :m2 374, :m1 nil, :m3-2 372}, :bufs {:b2 [], :b1 [375 376], :b3 []}}, :line 171}
{:clk 683.8058, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 373, :m4 nil, :m2 374, :m1 nil, :m3-2 372}, :bufs {:b2 [], :b1 [375 376], :b3 []}}, :line 172}
{:clk 683.9687, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType2, :ends 684.9687, :j 377, :dets {:run {:m3-1 373, :m4 nil, :m2 374, :m1 nil, :m3-2 372}, :bufs {:b2 [], :b1 [375 376], :b3 []}}, :line 173}
{:clk 684.0594, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 372, :dets {:run {:m3-1 373, :m4 nil, :m2 374, :m1 377, :m3-2 372}, :bufs {:b2 [], :b1 [375 376], :b3 []}}, :line 174}
{:clk 684.0594, :act :m3-2-starved, :m :m3-2, :mjpact :st, :dets {:run {:m3-1 373, :m4 nil, :m2 374, :m1 377, :m3-2 nil}, :bufs {:b2 [], :b1 [375 376], :b3 [372]}}, :line 175}
{:clk 684.0594, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 373, :m4 nil, :m2 374, :m1 377, :m3-2 nil}, :bufs {:b2 [], :b1 [375 376], :b3 [372]}}, :line 176}
{:clk 684.0594, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 372, :dets {:run {:m3-1 373, :m4 nil, :m2 374, :m1 377, :m3-2 nil}, :bufs {:b2 [], :b1 [375 376], :b3 [372]}}, :line 177}
{:clk 684.553, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 0, :j 374, :dets {:run {:m3-1 373, :m4 372, :m2 374, :m1 377, :m3-2 nil}, :bufs {:b2 [], :b1 [375 376], :b3 []}}, :line 178}
{:clk 684.553, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 375, :dets {:run {:m3-1 373, :m4 372, :m2 nil, :m1 377, :m3-2 nil}, :bufs {:b2 [374], :b1 [375 376], :b3 []}}, :line 179}
{:clk 684.553, :act :m3-2-unstarved, :m :m3-2, :mjpact :us, :dets {:run {:m3-1 373, :m4 372, :m2 375, :m1 377, :m3-2 nil}, :bufs {:b2 [374], :b1 [376], :b3 []}}, :line 180}
{:clk 684.553, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 1, :j 374, :dets {:run {:m3-1 373, :m4 372, :m2 375, :m1 377, :m3-2 nil}, :bufs {:b2 [374], :b1 [376], :b3 []}}, :line 181}
{:clk 684.9687, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 377, :dets {:run {:m3-1 373, :m4 372, :m2 375, :m1 377, :m3-2 374}, :bufs {:b2 [], :b1 [376], :b3 []}}, :line 182}
{:clk 684.9687, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 685.9687, :j 378, :dets {:run {:m3-1 373, :m4 372, :m2 375, :m1 nil, :m3-2 374}, :bufs {:b2 [], :b1 [376 377], :b3 []}}, :line 183}
{:clk 685.2594, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 663.9731, :j 372, :dets {:run {:m3-1 373, :m4 372, :m2 375, :m1 378, :m3-2 374}, :bufs {:b2 [], :b1 [376 377], :b3 []}}, :line 184}
{:clk 685.2594, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 373, :m4 nil, :m2 375, :m1 378, :m3-2 374}, :bufs {:b2 [], :b1 [376 377], :b3 []}}, :line 185}
{:clk 685.553, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 0, :j 375, :dets {:run {:m3-1 373, :m4 nil, :m2 375, :m1 378, :m3-2 374}, :bufs {:b2 [], :b1 [376 377], :b3 []}}, :line 186}
{:clk 685.553, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 376, :dets {:run {:m3-1 373, :m4 nil, :m2 nil, :m1 378, :m3-2 374}, :bufs {:b2 [375], :b1 [376 377], :b3 []}}, :line 187}
{:clk 685.9687, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 378, :dets {:run {:m3-1 373, :m4 nil, :m2 376, :m1 378, :m3-2 374}, :bufs {:b2 [375], :b1 [377], :b3 []}}, :line 188}
{:clk 685.9687, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 686.9687, :j 379, :dets {:run {:m3-1 373, :m4 nil, :m2 376, :m1 nil, :m3-2 374}, :bufs {:b2 [375], :b1 [377 378], :b3 []}}, :line 189}
{:clk 686.553, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 376, :dets {:run {:m3-1 373, :m4 nil, :m2 376, :m1 379, :m3-2 374}, :bufs {:b2 [375], :b1 [377 378], :b3 []}}, :line 190}
{:clk 686.553, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 377, :dets {:run {:m3-1 373, :m4 nil, :m2 nil, :m1 379, :m3-2 374}, :bufs {:b2 [375 376], :b1 [377 378], :b3 []}}, :line 191}
{:clk 686.9429, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 373, :dets {:run {:m3-1 373, :m4 nil, :m2 377, :m1 379, :m3-2 374}, :bufs {:b2 [375 376], :b1 [378], :b3 []}}, :line 192}
{:clk 686.9429, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 375, :dets {:run {:m3-1 nil, :m4 nil, :m2 377, :m1 379, :m3-2 374}, :bufs {:b2 [375 376], :b1 [378], :b3 [373]}}, :line 193}
{:clk 686.9429, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 375, :m4 nil, :m2 377, :m1 379, :m3-2 374}, :bufs {:b2 [376], :b1 [378], :b3 [373]}}, :line 194}
{:clk 686.9429, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 373, :dets {:run {:m3-1 375, :m4 nil, :m2 377, :m1 379, :m3-2 374}, :bufs {:b2 [376], :b1 [378], :b3 [373]}}, :line 195}
{:clk 686.9687, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 379, :dets {:run {:m3-1 375, :m4 373, :m2 377, :m1 379, :m3-2 374}, :bufs {:b2 [376], :b1 [378], :b3 []}}, :line 196}
{:clk 686.9687, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType2, :ends 687.9687, :j 380, :dets {:run {:m3-1 375, :m4 373, :m2 377, :m1 nil, :m3-2 374}, :bufs {:b2 [376], :b1 [378 379], :b3 []}}, :line 197}
{:clk 687.553, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 377, :dets {:run {:m3-1 375, :m4 373, :m2 377, :m1 380, :m3-2 374}, :bufs {:b2 [376], :b1 [378 379], :b3 []}}, :line 198}
{:clk 687.553, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 378, :dets {:run {:m3-1 375, :m4 373, :m2 nil, :m1 380, :m3-2 374}, :bufs {:b2 [376 377], :b1 [378 379], :b3 []}}, :line 199}
{:clk 687.9687, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 380, :dets {:run {:m3-1 375, :m4 373, :m2 378, :m1 380, :m3-2 374}, :bufs {:b2 [376 377], :b1 [379], :b3 []}}, :line 200}
{:clk 687.9687, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 688.9687, :j 381, :dets {:run {:m3-1 375, :m4 373, :m2 378, :m1 nil, :m3-2 374}, :bufs {:b2 [376 377], :b1 [379 380], :b3 []}}, :line 201}
{:clk 688.153, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 374, :dets {:run {:m3-1 375, :m4 373, :m2 378, :m1 381, :m3-2 374}, :bufs {:b2 [376 377], :b1 [379 380], :b3 []}}, :line 202}
{:clk 688.153, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 376, :dets {:run {:m3-1 375, :m4 373, :m2 378, :m1 381, :m3-2 nil}, :bufs {:b2 [376 377], :b1 [379 380], :b3 [374]}}, :line 203}
{:clk 688.553, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 378, :dets {:run {:m3-1 375, :m4 373, :m2 378, :m1 381, :m3-2 376}, :bufs {:b2 [377], :b1 [379 380], :b3 [374]}}, :line 204}
{:clk 688.553, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 379, :dets {:run {:m3-1 375, :m4 373, :m2 nil, :m1 381, :m3-2 376}, :bufs {:b2 [377 378], :b1 [379 380], :b3 [374]}}, :line 205}
{:clk 688.9687, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 381, :dets {:run {:m3-1 375, :m4 373, :m2 379, :m1 381, :m3-2 376}, :bufs {:b2 [377 378], :b1 [380], :b3 [374]}}, :line 206}
{:clk 688.9687, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 689.9687, :j 382, :dets {:run {:m3-1 375, :m4 373, :m2 379, :m1 nil, :m3-2 376}, :bufs {:b2 [377 378], :b1 [380 381], :b3 [374]}}, :line 207}
{:clk 689.2094, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 666.9731, :j 373, :dets {:run {:m3-1 375, :m4 373, :m2 379, :m1 382, :m3-2 376}, :bufs {:b2 [377 378], :b1 [380 381], :b3 [374]}}, :line 208}
{:clk 689.2094, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 374, :dets {:run {:m3-1 375, :m4 nil, :m2 379, :m1 382, :m3-2 376}, :bufs {:b2 [377 378], :b1 [380 381], :b3 [374]}}, :line 209}
{:clk 689.553, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 375, :m4 374, :m2 379, :m1 382, :m3-2 376}, :bufs {:b2 [377 378], :b1 [380 381], :b3 []}}, :line 210}
{:clk 689.9687, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 375, :m4 374, :m2 379, :m1 382, :m3-2 376}, :bufs {:b2 [377 378], :b1 [380 381], :b3 []}}, :line 211}
{:clk 690.4094, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 669.9731, :j 374, :dets {:run {:m3-1 375, :m4 374, :m2 379, :m1 382, :m3-2 376}, :bufs {:b2 [377 378], :b1 [380 381], :b3 []}}, :line 212}
{:clk 690.4094, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 375, :m4 nil, :m2 379, :m1 382, :m3-2 376}, :bufs {:b2 [377 378], :b1 [380 381], :b3 []}}, :line 213}
{:clk 690.5429, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 375, :dets {:run {:m3-1 375, :m4 nil, :m2 379, :m1 382, :m3-2 376}, :bufs {:b2 [377 378], :b1 [380 381], :b3 []}}, :line 214}
{:clk 690.5429, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 377, :dets {:run {:m3-1 nil, :m4 nil, :m2 379, :m1 382, :m3-2 376}, :bufs {:b2 [377 378], :b1 [380 381], :b3 [375]}}, :line 215}
{:clk 690.5429, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 377, :m4 nil, :m2 379, :m1 382, :m3-2 376}, :bufs {:b2 [378], :b1 [380 381], :b3 [375]}}, :line 216}
{:clk 690.5429, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 375, :dets {:run {:m3-1 377, :m4 nil, :m2 379, :m1 382, :m3-2 376}, :bufs {:b2 [378], :b1 [380 381], :b3 [375]}}, :line 217}
{:clk 690.5429, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 377, :m4 375, :m2 379, :m1 382, :m3-2 376}, :bufs {:b2 [378], :b1 [380 381], :b3 []}}, :line 218}
{:clk 690.5429, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 379, :dets {:run {:m3-1 377, :m4 375, :m2 379, :m1 382, :m3-2 376}, :bufs {:b2 [378], :b1 [380 381], :b3 []}}, :line 219}
{:clk 690.5429, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 380, :dets {:run {:m3-1 377, :m4 375, :m2 nil, :m1 382, :m3-2 376}, :bufs {:b2 [378 379], :b1 [380 381], :b3 []}}, :line 220}
{:clk 690.5429, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 377, :m4 375, :m2 380, :m1 382, :m3-2 376}, :bufs {:b2 [378 379], :b1 [381], :b3 []}}, :line 221}
{:clk 690.5429, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 382, :dets {:run {:m3-1 377, :m4 375, :m2 380, :m1 382, :m3-2 376}, :bufs {:b2 [378 379], :b1 [381], :b3 []}}, :line 222}
{:clk 690.5429, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType2, :ends 691.5429, :j 383, :dets {:run {:m3-1 377, :m4 375, :m2 380, :m1 nil, :m3-2 376}, :bufs {:b2 [378 379], :b1 [381 382], :b3 []}}, :line 223}
{:clk 691.153, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 376, :dets {:run {:m3-1 377, :m4 375, :m2 380, :m1 383, :m3-2 376}, :bufs {:b2 [378 379], :b1 [381 382], :b3 []}}, :line 224}
{:clk 691.153, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 378, :dets {:run {:m3-1 377, :m4 375, :m2 380, :m1 383, :m3-2 nil}, :bufs {:b2 [378 379], :b1 [381 382], :b3 [376]}}, :line 225}
{:clk 691.5429, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 380, :dets {:run {:m3-1 377, :m4 375, :m2 380, :m1 383, :m3-2 378}, :bufs {:b2 [379], :b1 [381 382], :b3 [376]}}, :line 226}
{:clk 691.5429, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 381, :dets {:run {:m3-1 377, :m4 375, :m2 nil, :m1 383, :m3-2 378}, :bufs {:b2 [379 380], :b1 [381 382], :b3 [376]}}, :line 227}
{:clk 691.5429, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 383, :dets {:run {:m3-1 377, :m4 375, :m2 381, :m1 383, :m3-2 378}, :bufs {:b2 [379 380], :b1 [382], :b3 [376]}}, :line 228}
{:clk 691.5429, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 692.5429, :j 384, :dets {:run {:m3-1 377, :m4 375, :m2 381, :m1 nil, :m3-2 378}, :bufs {:b2 [379 380], :b1 [382 383], :b3 [376]}}, :line 229}
{:clk 691.7429, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 671.7865, :j 375, :dets {:run {:m3-1 377, :m4 375, :m2 381, :m1 384, :m3-2 378}, :bufs {:b2 [379 380], :b1 [382 383], :b3 [376]}}, :line 230}
{:clk 691.7429, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 376, :dets {:run {:m3-1 377, :m4 nil, :m2 381, :m1 384, :m3-2 378}, :bufs {:b2 [379 380], :b1 [382 383], :b3 [376]}}, :line 231}
{:clk 692.5429, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 377, :m4 376, :m2 381, :m1 384, :m3-2 378}, :bufs {:b2 [379 380], :b1 [382 383], :b3 []}}, :line 232}
{:clk 692.5429, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 377, :m4 376, :m2 381, :m1 384, :m3-2 378}, :bufs {:b2 [379 380], :b1 [382 383], :b3 []}}, :line 233}
{:clk 692.7429, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 676.2058, :j 376, :dets {:run {:m3-1 377, :m4 376, :m2 381, :m1 384, :m3-2 378}, :bufs {:b2 [379 380], :b1 [382 383], :b3 []}}, :line 234}
{:clk 692.7429, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 377, :m4 nil, :m2 381, :m1 384, :m3-2 378}, :bufs {:b2 [379 380], :b1 [382 383], :b3 []}}, :line 235}
{:clk 694.1429, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 377, :dets {:run {:m3-1 377, :m4 nil, :m2 381, :m1 384, :m3-2 378}, :bufs {:b2 [379 380], :b1 [382 383], :b3 []}}, :line 236}
{:clk 694.1429, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 379, :dets {:run {:m3-1 nil, :m4 nil, :m2 381, :m1 384, :m3-2 378}, :bufs {:b2 [379 380], :b1 [382 383], :b3 [377]}}, :line 237}
{:clk 694.1429, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 379, :m4 nil, :m2 381, :m1 384, :m3-2 378}, :bufs {:b2 [380], :b1 [382 383], :b3 [377]}}, :line 238}
{:clk 694.1429, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 377, :dets {:run {:m3-1 379, :m4 nil, :m2 381, :m1 384, :m3-2 378}, :bufs {:b2 [380], :b1 [382 383], :b3 [377]}}, :line 239}
{:clk 694.1429, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 379, :m4 377, :m2 381, :m1 384, :m3-2 378}, :bufs {:b2 [380], :b1 [382 383], :b3 []}}, :line 240}
{:clk 694.1429, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 381, :dets {:run {:m3-1 379, :m4 377, :m2 381, :m1 384, :m3-2 378}, :bufs {:b2 [380], :b1 [382 383], :b3 []}}, :line 241}
{:clk 694.1429, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 382, :dets {:run {:m3-1 379, :m4 377, :m2 nil, :m1 384, :m3-2 378}, :bufs {:b2 [380 381], :b1 [382 383], :b3 []}}, :line 242}
{:clk 694.1429, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 379, :m4 377, :m2 382, :m1 384, :m3-2 378}, :bufs {:b2 [380 381], :b1 [383], :b3 []}}, :line 243}
{:clk 694.1429, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 384, :dets {:run {:m3-1 379, :m4 377, :m2 382, :m1 384, :m3-2 378}, :bufs {:b2 [380 381], :b1 [383], :b3 []}}, :line 244}
{:clk 694.1429, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 695.1429, :j 385, :dets {:run {:m3-1 379, :m4 377, :m2 382, :m1 nil, :m3-2 378}, :bufs {:b2 [380 381], :b1 [383 384], :b3 []}}, :line 245}
{:clk 694.153, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 378, :dets {:run {:m3-1 379, :m4 377, :m2 382, :m1 385, :m3-2 378}, :bufs {:b2 [380 381], :b1 [383 384], :b3 []}}, :line 246}
{:clk 694.153, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 380, :dets {:run {:m3-1 379, :m4 377, :m2 382, :m1 385, :m3-2 nil}, :bufs {:b2 [380 381], :b1 [383 384], :b3 [378]}}, :line 247}
{:clk 695.1429, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 382, :dets {:run {:m3-1 379, :m4 377, :m2 382, :m1 385, :m3-2 380}, :bufs {:b2 [381], :b1 [383 384], :b3 [378]}}, :line 248}
{:clk 695.1429, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 383, :dets {:run {:m3-1 379, :m4 377, :m2 nil, :m1 385, :m3-2 380}, :bufs {:b2 [381 382], :b1 [383 384], :b3 [378]}}, :line 249}
{:clk 695.1429, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 385, :dets {:run {:m3-1 379, :m4 377, :m2 383, :m1 385, :m3-2 380}, :bufs {:b2 [381 382], :b1 [384], :b3 [378]}}, :line 250}
{:clk 695.1429, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 696.1429, :j 386, :dets {:run {:m3-1 379, :m4 377, :m2 383, :m1 nil, :m3-2 380}, :bufs {:b2 [381 382], :b1 [384 385], :b3 [378]}}, :line 251}
{:clk 695.3429, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 683.9687, :j 377, :dets {:run {:m3-1 379, :m4 377, :m2 383, :m1 386, :m3-2 380}, :bufs {:b2 [381 382], :b1 [384 385], :b3 [378]}}, :line 252}
{:clk 695.3429, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 378, :dets {:run {:m3-1 379, :m4 nil, :m2 383, :m1 386, :m3-2 380}, :bufs {:b2 [381 382], :b1 [384 385], :b3 [378]}}, :line 253}
{:clk 696.1429, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 379, :m4 378, :m2 383, :m1 386, :m3-2 380}, :bufs {:b2 [381 382], :b1 [384 385], :b3 []}}, :line 254}
{:clk 696.1429, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 379, :m4 378, :m2 383, :m1 386, :m3-2 380}, :bufs {:b2 [381 382], :b1 [384 385], :b3 []}}, :line 255}
{:clk 696.3429, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 684.9687, :j 378, :dets {:run {:m3-1 379, :m4 378, :m2 383, :m1 386, :m3-2 380}, :bufs {:b2 [381 382], :b1 [384 385], :b3 []}}, :line 256}
{:clk 696.3429, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 379, :m4 nil, :m2 383, :m1 386, :m3-2 380}, :bufs {:b2 [381 382], :b1 [384 385], :b3 []}}, :line 257}
{:clk 697.753, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 380, :dets {:run {:m3-1 379, :m4 nil, :m2 383, :m1 386, :m3-2 380}, :bufs {:b2 [381 382], :b1 [384 385], :b3 []}}, :line 258}
{:clk 697.753, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 381, :dets {:run {:m3-1 379, :m4 nil, :m2 383, :m1 386, :m3-2 nil}, :bufs {:b2 [381 382], :b1 [384 385], :b3 [380]}}, :line 259}
{:clk 697.753, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 379, :m4 nil, :m2 383, :m1 386, :m3-2 381}, :bufs {:b2 [382], :b1 [384 385], :b3 [380]}}, :line 260}
{:clk 697.753, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 380, :dets {:run {:m3-1 379, :m4 nil, :m2 383, :m1 386, :m3-2 381}, :bufs {:b2 [382], :b1 [384 385], :b3 [380]}}, :line 261}
{:clk 697.753, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 379, :m4 380, :m2 383, :m1 386, :m3-2 381}, :bufs {:b2 [382], :b1 [384 385], :b3 []}}, :line 262}
{:clk 697.753, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 383, :dets {:run {:m3-1 379, :m4 380, :m2 383, :m1 386, :m3-2 381}, :bufs {:b2 [382], :b1 [384 385], :b3 []}}, :line 263}
{:clk 697.753, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 384, :dets {:run {:m3-1 379, :m4 380, :m2 nil, :m1 386, :m3-2 381}, :bufs {:b2 [382 383], :b1 [384 385], :b3 []}}, :line 264}
{:clk 697.753, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 379, :m4 380, :m2 384, :m1 386, :m3-2 381}, :bufs {:b2 [382 383], :b1 [385], :b3 []}}, :line 265}
{:clk 697.753, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 386, :dets {:run {:m3-1 379, :m4 380, :m2 384, :m1 386, :m3-2 381}, :bufs {:b2 [382 383], :b1 [385], :b3 []}}, :line 266}
{:clk 697.753, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 698.753, :j 387, :dets {:run {:m3-1 379, :m4 380, :m2 384, :m1 nil, :m3-2 381}, :bufs {:b2 [382 383], :b1 [385 386], :b3 []}}, :line 267}
{:clk 698.753, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 379, :m4 380, :m2 384, :m1 387, :m3-2 381}, :bufs {:b2 [382 383], :b1 [385 386], :b3 []}}, :line 268}
{:clk 698.753, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 379, :m4 380, :m2 384, :m1 387, :m3-2 381}, :bufs {:b2 [382 383], :b1 [385 386], :b3 []}}, :line 269}
{:clk 698.953, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 686.9687, :j 380, :dets {:run {:m3-1 379, :m4 380, :m2 384, :m1 387, :m3-2 381}, :bufs {:b2 [382 383], :b1 [385 386], :b3 []}}, :line 270}
{:clk 698.953, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 379, :m4 nil, :m2 384, :m1 387, :m3-2 381}, :bufs {:b2 [382 383], :b1 [385 386], :b3 []}}, :line 271}
{:clk 700.5958, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 379, :dets {:run {:m3-1 379, :m4 nil, :m2 384, :m1 387, :m3-2 381}, :bufs {:b2 [382 383], :b1 [385 386], :b3 []}}, :line 272}
{:clk 700.5958, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 382, :dets {:run {:m3-1 nil, :m4 nil, :m2 384, :m1 387, :m3-2 381}, :bufs {:b2 [382 383], :b1 [385 386], :b3 [379]}}, :line 273}
{:clk 700.5958, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 382, :m4 nil, :m2 384, :m1 387, :m3-2 381}, :bufs {:b2 [383], :b1 [385 386], :b3 [379]}}, :line 274}
{:clk 700.5958, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 382, :m4 nil, :m2 384, :m1 387, :m3-2 381}, :bufs {:b2 [383], :b1 [385 386], :b3 [379]}}, :line 275}
{:clk 700.5958, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 384, :dets {:run {:m3-1 382, :m4 nil, :m2 384, :m1 387, :m3-2 381}, :bufs {:b2 [383], :b1 [385 386], :b3 [379]}}, :line 276}
{:clk 700.5958, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 385, :dets {:run {:m3-1 382, :m4 nil, :m2 nil, :m1 387, :m3-2 381}, :bufs {:b2 [383 384], :b1 [385 386], :b3 [379]}}, :line 277}
{:clk 700.5958, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 382, :m4 nil, :m2 385, :m1 387, :m3-2 381}, :bufs {:b2 [383 384], :b1 [386], :b3 [379]}}, :line 278}
{:clk 700.5958, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 387, :dets {:run {:m3-1 382, :m4 nil, :m2 385, :m1 387, :m3-2 381}, :bufs {:b2 [383 384], :b1 [386], :b3 [379]}}, :line 279}
{:clk 700.5958, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 701.5958, :j 388, :dets {:run {:m3-1 382, :m4 nil, :m2 385, :m1 nil, :m3-2 381}, :bufs {:b2 [383 384], :b1 [386 387], :b3 [379]}}, :line 280}
{:clk 700.753, :act :m3-2-blocked, :m :m3-2, :mjpact :bl, :dets {:run {:m3-1 382, :m4 nil, :m2 385, :m1 388, :m3-2 381}, :bufs {:b2 [383 384], :b1 [386 387], :b3 [379]}}, :line 281}
{:clk 701.5958, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 382, :m4 nil, :m2 385, :m1 388, :m3-2 381}, :bufs {:b2 [383 384], :b1 [386 387], :b3 [379]}}, :line 282}
{:clk 701.5958, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 382, :m4 nil, :m2 385, :m1 388, :m3-2 381}, :bufs {:b2 [383 384], :b1 [386 387], :b3 [379]}}, :line 283}
{:clk 701.8349, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 379, :dets {:run {:m3-1 382, :m4 nil, :m2 385, :m1 388, :m3-2 381}, :bufs {:b2 [383 384], :b1 [386 387], :b3 [379]}}, :line 284}
{:clk 701.8349, :act :m3-2-unblocked, :m :m3-2, :mjpact :ub, :dets {:run {:m3-1 382, :m4 379, :m2 385, :m1 388, :m3-2 381}, :bufs {:b2 [383 384], :b1 [386 387], :b3 []}}, :line 285}
{:clk 701.8349, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 381, :dets {:run {:m3-1 382, :m4 379, :m2 385, :m1 388, :m3-2 381}, :bufs {:b2 [383 384], :b1 [386 387], :b3 []}}, :line 286}
{:clk 701.8349, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 383, :dets {:run {:m3-1 382, :m4 379, :m2 385, :m1 388, :m3-2 nil}, :bufs {:b2 [383 384], :b1 [386 387], :b3 [381]}}, :line 287}
{:clk 701.8349, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 382, :m4 379, :m2 385, :m1 388, :m3-2 383}, :bufs {:b2 [384], :b1 [386 387], :b3 [381]}}, :line 288}
{:clk 701.8349, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 385, :dets {:run {:m3-1 382, :m4 379, :m2 385, :m1 388, :m3-2 383}, :bufs {:b2 [384], :b1 [386 387], :b3 [381]}}, :line 289}
{:clk 701.8349, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 386, :dets {:run {:m3-1 382, :m4 379, :m2 nil, :m1 388, :m3-2 383}, :bufs {:b2 [384 385], :b1 [386 387], :b3 [381]}}, :line 290}
{:clk 701.8349, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 382, :m4 379, :m2 386, :m1 388, :m3-2 383}, :bufs {:b2 [384 385], :b1 [387], :b3 [381]}}, :line 291}
{:clk 701.8349, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 388, :dets {:run {:m3-1 382, :m4 379, :m2 386, :m1 388, :m3-2 383}, :bufs {:b2 [384 385], :b1 [387], :b3 [381]}}, :line 292}
{:clk 701.8349, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType2, :ends 702.8349, :j 389, :dets {:run {:m3-1 382, :m4 379, :m2 386, :m1 nil, :m3-2 383}, :bufs {:b2 [384 385], :b1 [387 388], :b3 [381]}}, :line 293}
{:clk 702.8349, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 685.9687, :j 379, :dets {:run {:m3-1 382, :m4 379, :m2 386, :m1 389, :m3-2 383}, :bufs {:b2 [384 385], :b1 [387 388], :b3 [381]}}, :line 294}
{:clk 702.8349, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 382, :m4 nil, :m2 386, :m1 389, :m3-2 383}, :bufs {:b2 [384 385], :b1 [387 388], :b3 [381]}}, :line 295}
{:clk 702.8349, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 381, :dets {:run {:m3-1 382, :m4 nil, :m2 386, :m1 389, :m3-2 383}, :bufs {:b2 [384 385], :b1 [387 388], :b3 [381]}}, :line 296}
{:clk 703.5958, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 382, :dets {:run {:m3-1 382, :m4 381, :m2 386, :m1 389, :m3-2 383}, :bufs {:b2 [384 385], :b1 [387 388], :b3 []}}, :line 297}
{:clk 703.5958, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 384, :dets {:run {:m3-1 nil, :m4 381, :m2 386, :m1 389, :m3-2 383}, :bufs {:b2 [384 385], :b1 [387 388], :b3 [382]}}, :line 298}
{:clk 703.8349, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 687.9687, :j 381, :dets {:run {:m3-1 384, :m4 381, :m2 386, :m1 389, :m3-2 383}, :bufs {:b2 [385], :b1 [387 388], :b3 [382]}}, :line 299}
{:clk 703.8349, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 382, :dets {:run {:m3-1 384, :m4 nil, :m2 386, :m1 389, :m3-2 383}, :bufs {:b2 [385], :b1 [387 388], :b3 [382]}}, :line 300}
{:clk 704.1648, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 386, :dets {:run {:m3-1 384, :m4 382, :m2 386, :m1 389, :m3-2 383}, :bufs {:b2 [385], :b1 [387 388], :b3 []}}, :line 301}
{:clk 704.1648, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 387, :dets {:run {:m3-1 384, :m4 382, :m2 nil, :m1 389, :m3-2 383}, :bufs {:b2 [385 386], :b1 [387 388], :b3 []}}, :line 302}
{:clk 704.1648, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 384, :m4 382, :m2 387, :m1 389, :m3-2 383}, :bufs {:b2 [385 386], :b1 [388], :b3 []}}, :line 303}
{:clk 704.1648, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 389, :dets {:run {:m3-1 384, :m4 382, :m2 387, :m1 389, :m3-2 383}, :bufs {:b2 [385 386], :b1 [388], :b3 []}}, :line 304}
{:clk 704.1648, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 705.1648, :j 390, :dets {:run {:m3-1 384, :m4 382, :m2 387, :m1 nil, :m3-2 383}, :bufs {:b2 [385 386], :b1 [388 389], :b3 []}}, :line 305}
{:clk 704.8349, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 688.9687, :j 382, :dets {:run {:m3-1 384, :m4 382, :m2 387, :m1 390, :m3-2 383}, :bufs {:b2 [385 386], :b1 [388 389], :b3 []}}, :line 306}
{:clk 704.8349, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 384, :m4 nil, :m2 387, :m1 390, :m3-2 383}, :bufs {:b2 [385 386], :b1 [388 389], :b3 []}}, :line 307}
{:clk 705.1648, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 384, :m4 nil, :m2 387, :m1 390, :m3-2 383}, :bufs {:b2 [385 386], :b1 [388 389], :b3 []}}, :line 308}
{:clk 705.1648, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 384, :m4 nil, :m2 387, :m1 390, :m3-2 383}, :bufs {:b2 [385 386], :b1 [388 389], :b3 []}}, :line 309}
{:clk 705.4349, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 383, :dets {:run {:m3-1 384, :m4 nil, :m2 387, :m1 390, :m3-2 383}, :bufs {:b2 [385 386], :b1 [388 389], :b3 []}}, :line 310}
{:clk 705.4349, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 385, :dets {:run {:m3-1 384, :m4 nil, :m2 387, :m1 390, :m3-2 nil}, :bufs {:b2 [385 386], :b1 [388 389], :b3 [383]}}, :line 311}
{:clk 705.4349, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 384, :m4 nil, :m2 387, :m1 390, :m3-2 385}, :bufs {:b2 [386], :b1 [388 389], :b3 [383]}}, :line 312}
{:clk 705.4349, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 383, :dets {:run {:m3-1 384, :m4 nil, :m2 387, :m1 390, :m3-2 385}, :bufs {:b2 [386], :b1 [388 389], :b3 [383]}}, :line 313}
{:clk 705.4349, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 384, :m4 383, :m2 387, :m1 390, :m3-2 385}, :bufs {:b2 [386], :b1 [388 389], :b3 []}}, :line 314}
{:clk 705.4349, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 387, :dets {:run {:m3-1 384, :m4 383, :m2 387, :m1 390, :m3-2 385}, :bufs {:b2 [386], :b1 [388 389], :b3 []}}, :line 315}
{:clk 705.4349, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 388, :dets {:run {:m3-1 384, :m4 383, :m2 nil, :m1 390, :m3-2 385}, :bufs {:b2 [386 387], :b1 [388 389], :b3 []}}, :line 316}
{:clk 705.4349, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 384, :m4 383, :m2 388, :m1 390, :m3-2 385}, :bufs {:b2 [386 387], :b1 [389], :b3 []}}, :line 317}
{:clk 705.4349, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 390, :dets {:run {:m3-1 384, :m4 383, :m2 388, :m1 390, :m3-2 385}, :bufs {:b2 [386 387], :b1 [389], :b3 []}}, :line 318}
{:clk 705.4349, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 706.4349, :j 391, :dets {:run {:m3-1 384, :m4 383, :m2 388, :m1 nil, :m3-2 385}, :bufs {:b2 [386 387], :b1 [389 390], :b3 []}}, :line 319}
{:clk 706.4349, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 384, :m4 383, :m2 388, :m1 391, :m3-2 385}, :bufs {:b2 [386 387], :b1 [389 390], :b3 []}}, :line 320}
{:clk 706.4349, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 384, :m4 383, :m2 388, :m1 391, :m3-2 385}, :bufs {:b2 [386 387], :b1 [389 390], :b3 []}}, :line 321}
{:clk 706.5958, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 384, :dets {:run {:m3-1 384, :m4 383, :m2 388, :m1 391, :m3-2 385}, :bufs {:b2 [386 387], :b1 [389 390], :b3 []}}, :line 322}
{:clk 706.5958, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 386, :dets {:run {:m3-1 nil, :m4 383, :m2 388, :m1 391, :m3-2 385}, :bufs {:b2 [386 387], :b1 [389 390], :b3 [384]}}, :line 323}
{:clk 706.5958, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 386, :m4 383, :m2 388, :m1 391, :m3-2 385}, :bufs {:b2 [387], :b1 [389 390], :b3 [384]}}, :line 324}
{:clk 706.5958, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 388, :dets {:run {:m3-1 386, :m4 383, :m2 388, :m1 391, :m3-2 385}, :bufs {:b2 [387], :b1 [389 390], :b3 [384]}}, :line 325}
{:clk 706.5958, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 389, :dets {:run {:m3-1 386, :m4 383, :m2 nil, :m1 391, :m3-2 385}, :bufs {:b2 [387 388], :b1 [389 390], :b3 [384]}}, :line 326}
{:clk 706.5958, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 386, :m4 383, :m2 389, :m1 391, :m3-2 385}, :bufs {:b2 [387 388], :b1 [390], :b3 [384]}}, :line 327}
{:clk 706.5958, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 391, :dets {:run {:m3-1 386, :m4 383, :m2 389, :m1 391, :m3-2 385}, :bufs {:b2 [387 388], :b1 [390], :b3 [384]}}, :line 328}
{:clk 706.5958, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 707.5958, :j 392, :dets {:run {:m3-1 386, :m4 383, :m2 389, :m1 nil, :m3-2 385}, :bufs {:b2 [387 388], :b1 [390 391], :b3 [384]}}, :line 329}
{:clk 706.6349, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 690.5429, :j 383, :dets {:run {:m3-1 386, :m4 383, :m2 389, :m1 392, :m3-2 385}, :bufs {:b2 [387 388], :b1 [390 391], :b3 [384]}}, :line 330}
{:clk 706.6349, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 384, :dets {:run {:m3-1 386, :m4 nil, :m2 389, :m1 392, :m3-2 385}, :bufs {:b2 [387 388], :b1 [390 391], :b3 [384]}}, :line 331}
{:clk 707.5958, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 386, :m4 384, :m2 389, :m1 392, :m3-2 385}, :bufs {:b2 [387 388], :b1 [390 391], :b3 []}}, :line 332}
{:clk 707.5958, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 386, :m4 384, :m2 389, :m1 392, :m3-2 385}, :bufs {:b2 [387 388], :b1 [390 391], :b3 []}}, :line 333}
{:clk 707.6349, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 691.5429, :j 384, :dets {:run {:m3-1 386, :m4 384, :m2 389, :m1 392, :m3-2 385}, :bufs {:b2 [387 388], :b1 [390 391], :b3 []}}, :line 334}
{:clk 707.6349, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 386, :m4 nil, :m2 389, :m1 392, :m3-2 385}, :bufs {:b2 [387 388], :b1 [390 391], :b3 []}}, :line 335}
{:clk 708.4349, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 385, :dets {:run {:m3-1 386, :m4 nil, :m2 389, :m1 392, :m3-2 385}, :bufs {:b2 [387 388], :b1 [390 391], :b3 []}}, :line 336}
{:clk 708.4349, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 387, :dets {:run {:m3-1 386, :m4 nil, :m2 389, :m1 392, :m3-2 nil}, :bufs {:b2 [387 388], :b1 [390 391], :b3 [385]}}, :line 337}
{:clk 708.4349, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 386, :m4 nil, :m2 389, :m1 392, :m3-2 387}, :bufs {:b2 [388], :b1 [390 391], :b3 [385]}}, :line 338}
{:clk 708.4349, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 385, :dets {:run {:m3-1 386, :m4 nil, :m2 389, :m1 392, :m3-2 387}, :bufs {:b2 [388], :b1 [390 391], :b3 [385]}}, :line 339}
{:clk 708.4349, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 386, :m4 385, :m2 389, :m1 392, :m3-2 387}, :bufs {:b2 [388], :b1 [390 391], :b3 []}}, :line 340}
{:clk 708.4349, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 389, :dets {:run {:m3-1 386, :m4 385, :m2 389, :m1 392, :m3-2 387}, :bufs {:b2 [388], :b1 [390 391], :b3 []}}, :line 341}
{:clk 708.4349, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 390, :dets {:run {:m3-1 386, :m4 385, :m2 nil, :m1 392, :m3-2 387}, :bufs {:b2 [388 389], :b1 [390 391], :b3 []}}, :line 342}
{:clk 708.4349, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 386, :m4 385, :m2 390, :m1 392, :m3-2 387}, :bufs {:b2 [388 389], :b1 [391], :b3 []}}, :line 343}
{:clk 708.4349, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 392, :dets {:run {:m3-1 386, :m4 385, :m2 390, :m1 392, :m3-2 387}, :bufs {:b2 [388 389], :b1 [391], :b3 []}}, :line 344}
{:clk 708.4349, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType2, :ends 709.4349, :j 393, :dets {:run {:m3-1 386, :m4 385, :m2 390, :m1 nil, :m3-2 387}, :bufs {:b2 [388 389], :b1 [391 392], :b3 []}}, :line 345}
{:clk 709.4349, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 694.1429, :j 385, :dets {:run {:m3-1 386, :m4 385, :m2 390, :m1 393, :m3-2 387}, :bufs {:b2 [388 389], :b1 [391 392], :b3 []}}, :line 346}
{:clk 709.4349, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 386, :m4 nil, :m2 390, :m1 393, :m3-2 387}, :bufs {:b2 [388 389], :b1 [391 392], :b3 []}}, :line 347}
{:clk 709.4349, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 386, :m4 nil, :m2 390, :m1 393, :m3-2 387}, :bufs {:b2 [388 389], :b1 [391 392], :b3 []}}, :line 348}
{:clk 709.4349, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 386, :m4 nil, :m2 390, :m1 393, :m3-2 387}, :bufs {:b2 [388 389], :b1 [391 392], :b3 []}}, :line 349}
{:clk 709.5958, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 386, :dets {:run {:m3-1 386, :m4 nil, :m2 390, :m1 393, :m3-2 387}, :bufs {:b2 [388 389], :b1 [391 392], :b3 []}}, :line 350}
{:clk 709.5958, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 388, :dets {:run {:m3-1 nil, :m4 nil, :m2 390, :m1 393, :m3-2 387}, :bufs {:b2 [388 389], :b1 [391 392], :b3 [386]}}, :line 351}
{:clk 709.5958, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 388, :m4 nil, :m2 390, :m1 393, :m3-2 387}, :bufs {:b2 [389], :b1 [391 392], :b3 [386]}}, :line 352}
{:clk 709.5958, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 386, :dets {:run {:m3-1 388, :m4 nil, :m2 390, :m1 393, :m3-2 387}, :bufs {:b2 [389], :b1 [391 392], :b3 [386]}}, :line 353}
{:clk 709.5958, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 388, :m4 386, :m2 390, :m1 393, :m3-2 387}, :bufs {:b2 [389], :b1 [391 392], :b3 []}}, :line 354}
{:clk 709.5958, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 390, :dets {:run {:m3-1 388, :m4 386, :m2 390, :m1 393, :m3-2 387}, :bufs {:b2 [389], :b1 [391 392], :b3 []}}, :line 355}
{:clk 709.5958, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 391, :dets {:run {:m3-1 388, :m4 386, :m2 nil, :m1 393, :m3-2 387}, :bufs {:b2 [389 390], :b1 [391 392], :b3 []}}, :line 356}
{:clk 709.5958, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 388, :m4 386, :m2 391, :m1 393, :m3-2 387}, :bufs {:b2 [389 390], :b1 [392], :b3 []}}, :line 357}
{:clk 709.5958, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 393, :dets {:run {:m3-1 388, :m4 386, :m2 391, :m1 393, :m3-2 387}, :bufs {:b2 [389 390], :b1 [392], :b3 []}}, :line 358}
{:clk 709.5958, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 710.5958, :j 394, :dets {:run {:m3-1 388, :m4 386, :m2 391, :m1 nil, :m3-2 387}, :bufs {:b2 [389 390], :b1 [392 393], :b3 []}}, :line 359}
{:clk 710.5958, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 695.1429, :j 386, :dets {:run {:m3-1 388, :m4 386, :m2 391, :m1 394, :m3-2 387}, :bufs {:b2 [389 390], :b1 [392 393], :b3 []}}, :line 360}
{:clk 710.5958, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 388, :m4 nil, :m2 391, :m1 394, :m3-2 387}, :bufs {:b2 [389 390], :b1 [392 393], :b3 []}}, :line 361}
{:clk 710.5958, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 388, :m4 nil, :m2 391, :m1 394, :m3-2 387}, :bufs {:b2 [389 390], :b1 [392 393], :b3 []}}, :line 362}
{:clk 710.5958, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 388, :m4 nil, :m2 391, :m1 394, :m3-2 387}, :bufs {:b2 [389 390], :b1 [392 393], :b3 []}}, :line 363}
{:clk 712.5958, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 388, :dets {:run {:m3-1 388, :m4 nil, :m2 391, :m1 394, :m3-2 387}, :bufs {:b2 [389 390], :b1 [392 393], :b3 []}}, :line 364}
{:clk 712.5958, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 389, :dets {:run {:m3-1 nil, :m4 nil, :m2 391, :m1 394, :m3-2 387}, :bufs {:b2 [389 390], :b1 [392 393], :b3 [388]}}, :line 365}
{:clk 712.5958, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 389, :m4 nil, :m2 391, :m1 394, :m3-2 387}, :bufs {:b2 [390], :b1 [392 393], :b3 [388]}}, :line 366}
{:clk 712.5958, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 388, :dets {:run {:m3-1 389, :m4 nil, :m2 391, :m1 394, :m3-2 387}, :bufs {:b2 [390], :b1 [392 393], :b3 [388]}}, :line 367}
{:clk 712.5958, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 389, :m4 388, :m2 391, :m1 394, :m3-2 387}, :bufs {:b2 [390], :b1 [392 393], :b3 []}}, :line 368}
{:clk 712.5958, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 391, :dets {:run {:m3-1 389, :m4 388, :m2 391, :m1 394, :m3-2 387}, :bufs {:b2 [390], :b1 [392 393], :b3 []}}, :line 369}
{:clk 712.5958, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 392, :dets {:run {:m3-1 389, :m4 388, :m2 nil, :m1 394, :m3-2 387}, :bufs {:b2 [390 391], :b1 [392 393], :b3 []}}, :line 370}
{:clk 712.5958, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 389, :m4 388, :m2 392, :m1 394, :m3-2 387}, :bufs {:b2 [390 391], :b1 [393], :b3 []}}, :line 371}
{:clk 712.5958, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 394, :dets {:run {:m3-1 389, :m4 388, :m2 392, :m1 394, :m3-2 387}, :bufs {:b2 [390 391], :b1 [393], :b3 []}}, :line 372}
{:clk 713.1673, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 714.1673, :j 395, :dets {:run {:m3-1 389, :m4 388, :m2 392, :m1 nil, :m3-2 387}, :bufs {:b2 [390 391], :b1 [393 394], :b3 []}}, :line 373}
{:clk 713.5958, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 700.5958, :j 388, :dets {:run {:m3-1 389, :m4 388, :m2 392, :m1 395, :m3-2 387}, :bufs {:b2 [390 391], :b1 [393 394], :b3 []}}, :line 374}
{:clk 713.5958, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 389, :m4 nil, :m2 392, :m1 395, :m3-2 387}, :bufs {:b2 [390 391], :b1 [393 394], :b3 []}}, :line 375}
{:clk 713.5958, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 389, :m4 nil, :m2 392, :m1 395, :m3-2 387}, :bufs {:b2 [390 391], :b1 [393 394], :b3 []}}, :line 376}
{:clk 714.0016, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 387, :dets {:run {:m3-1 389, :m4 nil, :m2 392, :m1 395, :m3-2 387}, :bufs {:b2 [390 391], :b1 [393 394], :b3 []}}, :line 377}
{:clk 714.0016, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 390, :dets {:run {:m3-1 389, :m4 nil, :m2 392, :m1 395, :m3-2 nil}, :bufs {:b2 [390 391], :b1 [393 394], :b3 [387]}}, :line 378}
{:clk 714.0016, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 389, :m4 nil, :m2 392, :m1 395, :m3-2 390}, :bufs {:b2 [391], :b1 [393 394], :b3 [387]}}, :line 379}
{:clk 714.0016, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 387, :dets {:run {:m3-1 389, :m4 nil, :m2 392, :m1 395, :m3-2 390}, :bufs {:b2 [391], :b1 [393 394], :b3 [387]}}, :line 380}
{:clk 714.0016, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 389, :m4 387, :m2 392, :m1 395, :m3-2 390}, :bufs {:b2 [391], :b1 [393 394], :b3 []}}, :line 381}
{:clk 714.0016, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 392, :dets {:run {:m3-1 389, :m4 387, :m2 392, :m1 395, :m3-2 390}, :bufs {:b2 [391], :b1 [393 394], :b3 []}}, :line 382}
{:clk 714.0016, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 393, :dets {:run {:m3-1 389, :m4 387, :m2 nil, :m1 395, :m3-2 390}, :bufs {:b2 [391 392], :b1 [393 394], :b3 []}}, :line 383}
{:clk 714.1673, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 395, :dets {:run {:m3-1 389, :m4 387, :m2 393, :m1 395, :m3-2 390}, :bufs {:b2 [391 392], :b1 [394], :b3 []}}, :line 384}
{:clk 714.1673, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType2, :ends 715.1673, :j 396, :dets {:run {:m3-1 389, :m4 387, :m2 393, :m1 nil, :m3-2 390}, :bufs {:b2 [391 392], :b1 [394 395], :b3 []}}, :line 385}
{:clk 715.0016, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 697.753, :j 387, :dets {:run {:m3-1 389, :m4 387, :m2 393, :m1 396, :m3-2 390}, :bufs {:b2 [391 392], :b1 [394 395], :b3 []}}, :line 386}
{:clk 715.0016, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 389, :m4 nil, :m2 393, :m1 396, :m3-2 390}, :bufs {:b2 [391 392], :b1 [394 395], :b3 []}}, :line 387}
{:clk 715.0016, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 389, :m4 nil, :m2 393, :m1 396, :m3-2 390}, :bufs {:b2 [391 392], :b1 [394 395], :b3 []}}, :line 388}
{:clk 715.1673, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 389, :m4 nil, :m2 393, :m1 396, :m3-2 390}, :bufs {:b2 [391 392], :b1 [394 395], :b3 []}}, :line 389}
{:clk 716.4515, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 389, :dets {:run {:m3-1 389, :m4 nil, :m2 393, :m1 396, :m3-2 390}, :bufs {:b2 [391 392], :b1 [394 395], :b3 []}}, :line 390}
{:clk 716.4515, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 391, :dets {:run {:m3-1 nil, :m4 nil, :m2 393, :m1 396, :m3-2 390}, :bufs {:b2 [391 392], :b1 [394 395], :b3 [389]}}, :line 391}
{:clk 716.4515, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 391, :m4 nil, :m2 393, :m1 396, :m3-2 390}, :bufs {:b2 [392], :b1 [394 395], :b3 [389]}}, :line 392}
{:clk 716.4515, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 391, :m4 nil, :m2 393, :m1 396, :m3-2 390}, :bufs {:b2 [392], :b1 [394 395], :b3 [389]}}, :line 393}
{:clk 716.4515, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 393, :dets {:run {:m3-1 391, :m4 nil, :m2 393, :m1 396, :m3-2 390}, :bufs {:b2 [392], :b1 [394 395], :b3 [389]}}, :line 394}
{:clk 716.4515, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 394, :dets {:run {:m3-1 391, :m4 nil, :m2 nil, :m1 396, :m3-2 390}, :bufs {:b2 [392 393], :b1 [394 395], :b3 [389]}}, :line 395}
{:clk 716.4515, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 391, :m4 nil, :m2 394, :m1 396, :m3-2 390}, :bufs {:b2 [392 393], :b1 [395], :b3 [389]}}, :line 396}
{:clk 716.4515, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 396, :dets {:run {:m3-1 391, :m4 nil, :m2 394, :m1 396, :m3-2 390}, :bufs {:b2 [392 393], :b1 [395], :b3 [389]}}, :line 397}
{:clk 716.4515, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 721.6331, :j 397, :dets {:run {:m3-1 391, :m4 nil, :m2 394, :m1 nil, :m3-2 390}, :bufs {:b2 [392 393], :b1 [395 396], :b3 [389]}}, :line 398}
{:clk 717.0016, :act :m3-2-blocked, :m :m3-2, :mjpact :bl, :dets {:run {:m3-1 391, :m4 nil, :m2 394, :m1 397, :m3-2 390}, :bufs {:b2 [392 393], :b1 [395 396], :b3 [389]}}, :line 399}
{:clk 717.2054, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 389, :dets {:run {:m3-1 391, :m4 nil, :m2 394, :m1 397, :m3-2 390}, :bufs {:b2 [392 393], :b1 [395 396], :b3 [389]}}, :line 400}
{:clk 717.2054, :act :m3-2-unblocked, :m :m3-2, :mjpact :ub, :dets {:run {:m3-1 391, :m4 389, :m2 394, :m1 397, :m3-2 390}, :bufs {:b2 [392 393], :b1 [395 396], :b3 []}}, :line 401}
{:clk 717.2054, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 390, :dets {:run {:m3-1 391, :m4 389, :m2 394, :m1 397, :m3-2 390}, :bufs {:b2 [392 393], :b1 [395 396], :b3 []}}, :line 402}
{:clk 717.2054, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 392, :dets {:run {:m3-1 391, :m4 389, :m2 394, :m1 397, :m3-2 nil}, :bufs {:b2 [392 393], :b1 [395 396], :b3 [390]}}, :line 403}
{:clk 717.4515, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 394, :dets {:run {:m3-1 391, :m4 389, :m2 394, :m1 397, :m3-2 392}, :bufs {:b2 [393], :b1 [395 396], :b3 [390]}}, :line 404}
{:clk 717.4515, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 395, :dets {:run {:m3-1 391, :m4 389, :m2 nil, :m1 397, :m3-2 392}, :bufs {:b2 [393 394], :b1 [395 396], :b3 [390]}}, :line 405}
{:clk 718.4054, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 701.8349, :j 389, :dets {:run {:m3-1 391, :m4 389, :m2 395, :m1 397, :m3-2 392}, :bufs {:b2 [393 394], :b1 [396], :b3 [390]}}, :line 406}
{:clk 718.4054, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 390, :dets {:run {:m3-1 391, :m4 nil, :m2 395, :m1 397, :m3-2 392}, :bufs {:b2 [393 394], :b1 [396], :b3 [390]}}, :line 407}
{:clk 718.4515, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 391, :m4 390, :m2 395, :m1 397, :m3-2 392}, :bufs {:b2 [393 394], :b1 [396], :b3 []}}, :line 408}
{:clk 719.4054, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 704.1648, :j 390, :dets {:run {:m3-1 391, :m4 390, :m2 395, :m1 397, :m3-2 392}, :bufs {:b2 [393 394], :b1 [396], :b3 []}}, :line 409}
{:clk 719.4054, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 391, :m4 nil, :m2 395, :m1 397, :m3-2 392}, :bufs {:b2 [393 394], :b1 [396], :b3 []}}, :line 410}
{:clk 719.4515, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 391, :dets {:run {:m3-1 391, :m4 nil, :m2 395, :m1 397, :m3-2 392}, :bufs {:b2 [393 394], :b1 [396], :b3 []}}, :line 411}
{:clk 719.4515, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 393, :dets {:run {:m3-1 nil, :m4 nil, :m2 395, :m1 397, :m3-2 392}, :bufs {:b2 [393 394], :b1 [396], :b3 [391]}}, :line 412}
{:clk 719.4515, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 393, :m4 nil, :m2 395, :m1 397, :m3-2 392}, :bufs {:b2 [394], :b1 [396], :b3 [391]}}, :line 413}
{:clk 719.4515, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 391, :dets {:run {:m3-1 393, :m4 nil, :m2 395, :m1 397, :m3-2 392}, :bufs {:b2 [394], :b1 [396], :b3 [391]}}, :line 414}
{:clk 719.4515, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 393, :m4 391, :m2 395, :m1 397, :m3-2 392}, :bufs {:b2 [394], :b1 [396], :b3 []}}, :line 415}
{:clk 719.4515, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 395, :dets {:run {:m3-1 393, :m4 391, :m2 395, :m1 397, :m3-2 392}, :bufs {:b2 [394], :b1 [396], :b3 []}}, :line 416}
{:clk 719.4515, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 1, :j 396, :dets {:run {:m3-1 393, :m4 391, :m2 nil, :m1 397, :m3-2 392}, :bufs {:b2 [394 395], :b1 [396], :b3 []}}, :line 417}
{:clk 720.2054, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 392, :dets {:run {:m3-1 393, :m4 391, :m2 396, :m1 397, :m3-2 392}, :bufs {:b2 [394 395], :b1 [], :b3 []}}, :line 418}
{:clk 720.2054, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 394, :dets {:run {:m3-1 393, :m4 391, :m2 396, :m1 397, :m3-2 nil}, :bufs {:b2 [394 395], :b1 [], :b3 [392]}}, :line 419}
{:clk 720.4515, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 705.4349, :j 391, :dets {:run {:m3-1 393, :m4 391, :m2 396, :m1 397, :m3-2 394}, :bufs {:b2 [395], :b1 [], :b3 [392]}}, :line 420}
{:clk 720.4515, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 396, :dets {:run {:m3-1 393, :m4 nil, :m2 396, :m1 397, :m3-2 394}, :bufs {:b2 [395], :b1 [], :b3 [392]}}, :line 421}
{:clk 720.4515, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 392, :dets {:run {:m3-1 393, :m4 nil, :m2 nil, :m1 397, :m3-2 394}, :bufs {:b2 [395 396], :b1 [], :b3 [392]}}, :line 422}
{:clk 720.4515, :act :m2-starved, :m :m2, :mjpact :st, :dets {:run {:m3-1 393, :m4 392, :m2 nil, :m1 397, :m3-2 394}, :bufs {:b2 [395 396], :b1 [], :b3 []}}, :line 423}
{:clk 721.4515, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 706.5958, :j 392, :dets {:run {:m3-1 393, :m4 392, :m2 nil, :m1 397, :m3-2 394}, :bufs {:b2 [395 396], :b1 [], :b3 []}}, :line 424}
{:clk 721.4515, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 393, :m4 nil, :m2 nil, :m1 397, :m3-2 394}, :bufs {:b2 [395 396], :b1 [], :b3 []}}, :line 425}
{:clk 721.6331, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 0, :j 397, :dets {:run {:m3-1 393, :m4 nil, :m2 nil, :m1 397, :m3-2 394}, :bufs {:b2 [395 396], :b1 [], :b3 []}}, :line 426}
{:clk 721.6331, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType2, :ends 722.6331, :j 398, :dets {:run {:m3-1 393, :m4 nil, :m2 nil, :m1 nil, :m3-2 394}, :bufs {:b2 [395 396], :b1 [397], :b3 []}}, :line 427}
{:clk 721.6331, :act :m2-unstarved, :m :m2, :mjpact :us, :dets {:run {:m3-1 393, :m4 nil, :m2 nil, :m1 398, :m3-2 394}, :bufs {:b2 [395 396], :b1 [397], :b3 []}}, :line 428}
{:clk 721.6331, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 1, :j 397, :dets {:run {:m3-1 393, :m4 nil, :m2 nil, :m1 398, :m3-2 394}, :bufs {:b2 [395 396], :b1 [397], :b3 []}}, :line 429}
{:clk 722.6331, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 0, :j 398, :dets {:run {:m3-1 393, :m4 nil, :m2 397, :m1 398, :m3-2 394}, :bufs {:b2 [395 396], :b1 [], :b3 []}}, :line 430}
{:clk 722.6331, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 393, :m4 nil, :m2 397, :m1 nil, :m3-2 394}, :bufs {:b2 [395 396], :b1 [398], :b3 []}}, :line 431}
{:clk 722.6331, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType2, :ends 723.6331, :j 399, :dets {:run {:m3-1 393, :m4 nil, :m2 397, :m1 nil, :m3-2 394}, :bufs {:b2 [395 396], :b1 [398], :b3 []}}, :line 432}
{:clk 723.0515, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 393, :dets {:run {:m3-1 393, :m4 nil, :m2 397, :m1 399, :m3-2 394}, :bufs {:b2 [395 396], :b1 [398], :b3 []}}, :line 433}
{:clk 723.0515, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 395, :dets {:run {:m3-1 nil, :m4 nil, :m2 397, :m1 399, :m3-2 394}, :bufs {:b2 [395 396], :b1 [398], :b3 [393]}}, :line 434}
{:clk 723.0515, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 395, :m4 nil, :m2 397, :m1 399, :m3-2 394}, :bufs {:b2 [396], :b1 [398], :b3 [393]}}, :line 435}
{:clk 723.0515, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 393, :dets {:run {:m3-1 395, :m4 nil, :m2 397, :m1 399, :m3-2 394}, :bufs {:b2 [396], :b1 [398], :b3 [393]}}, :line 436}
{:clk 723.0515, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 395, :m4 393, :m2 397, :m1 399, :m3-2 394}, :bufs {:b2 [396], :b1 [398], :b3 []}}, :line 437}
{:clk 723.0515, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 397, :dets {:run {:m3-1 395, :m4 393, :m2 397, :m1 399, :m3-2 394}, :bufs {:b2 [396], :b1 [398], :b3 []}}, :line 438}
{:clk 723.0515, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 1, :j 398, :dets {:run {:m3-1 395, :m4 393, :m2 nil, :m1 399, :m3-2 394}, :bufs {:b2 [396 397], :b1 [398], :b3 []}}, :line 439}
{:clk 723.2054, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 394, :dets {:run {:m3-1 395, :m4 393, :m2 398, :m1 399, :m3-2 394}, :bufs {:b2 [396 397], :b1 [], :b3 []}}, :line 440}
{:clk 723.2054, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 396, :dets {:run {:m3-1 395, :m4 393, :m2 398, :m1 399, :m3-2 nil}, :bufs {:b2 [396 397], :b1 [], :b3 [394]}}, :line 441}
{:clk 723.6331, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 0, :j 399, :dets {:run {:m3-1 395, :m4 393, :m2 398, :m1 399, :m3-2 396}, :bufs {:b2 [397], :b1 [], :b3 [394]}}, :line 442}
{:clk 723.6331, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 724.6331, :j 400, :dets {:run {:m3-1 395, :m4 393, :m2 398, :m1 nil, :m3-2 396}, :bufs {:b2 [397], :b1 [399], :b3 [394]}}, :line 443}
{:clk 724.0515, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 398, :dets {:run {:m3-1 395, :m4 393, :m2 398, :m1 400, :m3-2 396}, :bufs {:b2 [397], :b1 [399], :b3 [394]}}, :line 444}
{:clk 724.0515, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 1, :j 399, :dets {:run {:m3-1 395, :m4 393, :m2 nil, :m1 400, :m3-2 396}, :bufs {:b2 [397 398], :b1 [399], :b3 [394]}}, :line 445}
{:clk 724.2515, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 708.4349, :j 393, :dets {:run {:m3-1 395, :m4 393, :m2 399, :m1 400, :m3-2 396}, :bufs {:b2 [397 398], :b1 [], :b3 [394]}}, :line 446}
{:clk 724.2515, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 394, :dets {:run {:m3-1 395, :m4 nil, :m2 399, :m1 400, :m3-2 396}, :bufs {:b2 [397 398], :b1 [], :b3 [394]}}, :line 447}
{:clk 724.6331, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 0, :j 400, :dets {:run {:m3-1 395, :m4 394, :m2 399, :m1 400, :m3-2 396}, :bufs {:b2 [397 398], :b1 [], :b3 []}}, :line 448}
{:clk 724.6331, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType2, :ends 725.8501, :j 401, :dets {:run {:m3-1 395, :m4 394, :m2 399, :m1 nil, :m3-2 396}, :bufs {:b2 [397 398], :b1 [400], :b3 []}}, :line 449}
{:clk 725.0515, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 395, :m4 394, :m2 399, :m1 401, :m3-2 396}, :bufs {:b2 [397 398], :b1 [400], :b3 []}}, :line 450}
{:clk 725.2515, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 709.5958, :j 394, :dets {:run {:m3-1 395, :m4 394, :m2 399, :m1 401, :m3-2 396}, :bufs {:b2 [397 398], :b1 [400], :b3 []}}, :line 451}
{:clk 725.2515, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 395, :m4 nil, :m2 399, :m1 401, :m3-2 396}, :bufs {:b2 [397 398], :b1 [400], :b3 []}}, :line 452}
{:clk 725.8501, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 401, :dets {:run {:m3-1 395, :m4 nil, :m2 399, :m1 401, :m3-2 396}, :bufs {:b2 [397 398], :b1 [400], :b3 []}}, :line 453}
{:clk 725.8501, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType2, :ends 726.8501, :j 402, :dets {:run {:m3-1 395, :m4 nil, :m2 399, :m1 nil, :m3-2 396}, :bufs {:b2 [397 398], :b1 [400 401], :b3 []}}, :line 454}
{:clk 726.0515, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 395, :dets {:run {:m3-1 395, :m4 nil, :m2 399, :m1 402, :m3-2 396}, :bufs {:b2 [397 398], :b1 [400 401], :b3 []}}, :line 455}
{:clk 726.0515, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 397, :dets {:run {:m3-1 nil, :m4 nil, :m2 399, :m1 402, :m3-2 396}, :bufs {:b2 [397 398], :b1 [400 401], :b3 [395]}}, :line 456}
{:clk 726.0515, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 397, :m4 nil, :m2 399, :m1 402, :m3-2 396}, :bufs {:b2 [398], :b1 [400 401], :b3 [395]}}, :line 457}
{:clk 726.0515, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 395, :dets {:run {:m3-1 397, :m4 nil, :m2 399, :m1 402, :m3-2 396}, :bufs {:b2 [398], :b1 [400 401], :b3 [395]}}, :line 458}
{:clk 726.0515, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 397, :m4 395, :m2 399, :m1 402, :m3-2 396}, :bufs {:b2 [398], :b1 [400 401], :b3 []}}, :line 459}
{:clk 726.0515, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 399, :dets {:run {:m3-1 397, :m4 395, :m2 399, :m1 402, :m3-2 396}, :bufs {:b2 [398], :b1 [400 401], :b3 []}}, :line 460}
{:clk 726.0515, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 400, :dets {:run {:m3-1 397, :m4 395, :m2 nil, :m1 402, :m3-2 396}, :bufs {:b2 [398 399], :b1 [400 401], :b3 []}}, :line 461}
{:clk 726.8054, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 396, :dets {:run {:m3-1 397, :m4 395, :m2 400, :m1 402, :m3-2 396}, :bufs {:b2 [398 399], :b1 [401], :b3 []}}, :line 462}
{:clk 726.8054, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 398, :dets {:run {:m3-1 397, :m4 395, :m2 400, :m1 402, :m3-2 nil}, :bufs {:b2 [398 399], :b1 [401], :b3 [396]}}, :line 463}
{:clk 726.8501, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 402, :dets {:run {:m3-1 397, :m4 395, :m2 400, :m1 402, :m3-2 398}, :bufs {:b2 [399], :b1 [401], :b3 [396]}}, :line 464}
{:clk 726.8501, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 727.8501, :j 403, :dets {:run {:m3-1 397, :m4 395, :m2 400, :m1 nil, :m3-2 398}, :bufs {:b2 [399], :b1 [401 402], :b3 [396]}}, :line 465}
{:clk 727.0515, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 713.1673, :j 395, :dets {:run {:m3-1 397, :m4 395, :m2 400, :m1 403, :m3-2 398}, :bufs {:b2 [399], :b1 [401 402], :b3 [396]}}, :line 466}
{:clk 727.0515, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 400, :dets {:run {:m3-1 397, :m4 nil, :m2 400, :m1 403, :m3-2 398}, :bufs {:b2 [399], :b1 [401 402], :b3 [396]}}, :line 467}
{:clk 727.0515, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 396, :dets {:run {:m3-1 397, :m4 nil, :m2 nil, :m1 403, :m3-2 398}, :bufs {:b2 [399 400], :b1 [401 402], :b3 [396]}}, :line 468}
{:clk 727.0515, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 401, :dets {:run {:m3-1 397, :m4 396, :m2 nil, :m1 403, :m3-2 398}, :bufs {:b2 [399 400], :b1 [401 402], :b3 []}}, :line 469}
{:clk 727.8501, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 403, :dets {:run {:m3-1 397, :m4 396, :m2 401, :m1 403, :m3-2 398}, :bufs {:b2 [399 400], :b1 [402], :b3 []}}, :line 470}
{:clk 727.8501, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 728.8501, :j 404, :dets {:run {:m3-1 397, :m4 396, :m2 401, :m1 nil, :m3-2 398}, :bufs {:b2 [399 400], :b1 [402 403], :b3 []}}, :line 471}
{:clk 728.0515, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 397, :m4 396, :m2 401, :m1 404, :m3-2 398}, :bufs {:b2 [399 400], :b1 [402 403], :b3 []}}, :line 472}
{:clk 728.2515, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 714.1673, :j 396, :dets {:run {:m3-1 397, :m4 396, :m2 401, :m1 404, :m3-2 398}, :bufs {:b2 [399 400], :b1 [402 403], :b3 []}}, :line 473}
{:clk 728.2515, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 397, :m4 nil, :m2 401, :m1 404, :m3-2 398}, :bufs {:b2 [399 400], :b1 [402 403], :b3 []}}, :line 474}
{:clk 728.8501, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 397, :m4 nil, :m2 401, :m1 404, :m3-2 398}, :bufs {:b2 [399 400], :b1 [402 403], :b3 []}}, :line 475}
{:clk 729.0515, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 397, :dets {:run {:m3-1 397, :m4 nil, :m2 401, :m1 404, :m3-2 398}, :bufs {:b2 [399 400], :b1 [402 403], :b3 []}}, :line 476}
{:clk 729.0515, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 399, :dets {:run {:m3-1 nil, :m4 nil, :m2 401, :m1 404, :m3-2 398}, :bufs {:b2 [399 400], :b1 [402 403], :b3 [397]}}, :line 477}
{:clk 729.0515, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 399, :m4 nil, :m2 401, :m1 404, :m3-2 398}, :bufs {:b2 [400], :b1 [402 403], :b3 [397]}}, :line 478}
{:clk 729.0515, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 397, :dets {:run {:m3-1 399, :m4 nil, :m2 401, :m1 404, :m3-2 398}, :bufs {:b2 [400], :b1 [402 403], :b3 [397]}}, :line 479}
{:clk 729.0515, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 399, :m4 397, :m2 401, :m1 404, :m3-2 398}, :bufs {:b2 [400], :b1 [402 403], :b3 []}}, :line 480}
{:clk 729.0515, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 401, :dets {:run {:m3-1 399, :m4 397, :m2 401, :m1 404, :m3-2 398}, :bufs {:b2 [400], :b1 [402 403], :b3 []}}, :line 481}
{:clk 729.0515, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 402, :dets {:run {:m3-1 399, :m4 397, :m2 nil, :m1 404, :m3-2 398}, :bufs {:b2 [400 401], :b1 [402 403], :b3 []}}, :line 482}
{:clk 729.0515, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 399, :m4 397, :m2 402, :m1 404, :m3-2 398}, :bufs {:b2 [400 401], :b1 [403], :b3 []}}, :line 483}
{:clk 729.0515, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 404, :dets {:run {:m3-1 399, :m4 397, :m2 402, :m1 404, :m3-2 398}, :bufs {:b2 [400 401], :b1 [403], :b3 []}}, :line 484}
{:clk 729.0515, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 730.0515, :j 405, :dets {:run {:m3-1 399, :m4 397, :m2 402, :m1 nil, :m3-2 398}, :bufs {:b2 [400 401], :b1 [403 404], :b3 []}}, :line 485}
{:clk 730.0515, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 716.4515, :j 397, :dets {:run {:m3-1 399, :m4 397, :m2 402, :m1 405, :m3-2 398}, :bufs {:b2 [400 401], :b1 [403 404], :b3 []}}, :line 486}
{:clk 730.0515, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 399, :m4 nil, :m2 402, :m1 405, :m3-2 398}, :bufs {:b2 [400 401], :b1 [403 404], :b3 []}}, :line 487}
{:clk 730.0515, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 399, :m4 nil, :m2 402, :m1 405, :m3-2 398}, :bufs {:b2 [400 401], :b1 [403 404], :b3 []}}, :line 488}
{:clk 730.0515, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 399, :m4 nil, :m2 402, :m1 405, :m3-2 398}, :bufs {:b2 [400 401], :b1 [403 404], :b3 []}}, :line 489}
{:clk 730.4054, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 398, :dets {:run {:m3-1 399, :m4 nil, :m2 402, :m1 405, :m3-2 398}, :bufs {:b2 [400 401], :b1 [403 404], :b3 []}}, :line 490}
{:clk 730.4054, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 400, :dets {:run {:m3-1 399, :m4 nil, :m2 402, :m1 405, :m3-2 nil}, :bufs {:b2 [400 401], :b1 [403 404], :b3 [398]}}, :line 491}
{:clk 730.4054, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 399, :m4 nil, :m2 402, :m1 405, :m3-2 400}, :bufs {:b2 [401], :b1 [403 404], :b3 [398]}}, :line 492}
{:clk 730.4054, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 398, :dets {:run {:m3-1 399, :m4 nil, :m2 402, :m1 405, :m3-2 400}, :bufs {:b2 [401], :b1 [403 404], :b3 [398]}}, :line 493}
{:clk 730.4054, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 399, :m4 398, :m2 402, :m1 405, :m3-2 400}, :bufs {:b2 [401], :b1 [403 404], :b3 []}}, :line 494}
{:clk 730.4054, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 402, :dets {:run {:m3-1 399, :m4 398, :m2 402, :m1 405, :m3-2 400}, :bufs {:b2 [401], :b1 [403 404], :b3 []}}, :line 495}
{:clk 730.4054, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 403, :dets {:run {:m3-1 399, :m4 398, :m2 nil, :m1 405, :m3-2 400}, :bufs {:b2 [401 402], :b1 [403 404], :b3 []}}, :line 496}
{:clk 730.4054, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 399, :m4 398, :m2 403, :m1 405, :m3-2 400}, :bufs {:b2 [401 402], :b1 [404], :b3 []}}, :line 497}
{:clk 730.4054, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 405, :dets {:run {:m3-1 399, :m4 398, :m2 403, :m1 405, :m3-2 400}, :bufs {:b2 [401 402], :b1 [404], :b3 []}}, :line 498}
{:clk 730.4054, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 731.4054, :j 406, :dets {:run {:m3-1 399, :m4 398, :m2 403, :m1 nil, :m3-2 400}, :bufs {:b2 [401 402], :b1 [404 405], :b3 []}}, :line 499}
{:clk 731.4054, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 399, :m4 398, :m2 403, :m1 406, :m3-2 400}, :bufs {:b2 [401 402], :b1 [404 405], :b3 []}}, :line 500}
{:clk 731.4054, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 399, :m4 398, :m2 403, :m1 406, :m3-2 400}, :bufs {:b2 [401 402], :b1 [404 405], :b3 []}}, :line 501}
{:clk 731.6054, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 721.6331, :j 398, :dets {:run {:m3-1 399, :m4 398, :m2 403, :m1 406, :m3-2 400}, :bufs {:b2 [401 402], :b1 [404 405], :b3 []}}, :line 502}
{:clk 731.6054, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 399, :m4 nil, :m2 403, :m1 406, :m3-2 400}, :bufs {:b2 [401 402], :b1 [404 405], :b3 []}}, :line 503}
{:clk 732.6515, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 399, :dets {:run {:m3-1 399, :m4 nil, :m2 403, :m1 406, :m3-2 400}, :bufs {:b2 [401 402], :b1 [404 405], :b3 []}}, :line 504}
{:clk 732.6515, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 401, :dets {:run {:m3-1 nil, :m4 nil, :m2 403, :m1 406, :m3-2 400}, :bufs {:b2 [401 402], :b1 [404 405], :b3 [399]}}, :line 505}
{:clk 732.6515, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 401, :m4 nil, :m2 403, :m1 406, :m3-2 400}, :bufs {:b2 [402], :b1 [404 405], :b3 [399]}}, :line 506}
{:clk 732.6515, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 399, :dets {:run {:m3-1 401, :m4 nil, :m2 403, :m1 406, :m3-2 400}, :bufs {:b2 [402], :b1 [404 405], :b3 [399]}}, :line 507}
{:clk 732.6515, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 401, :m4 399, :m2 403, :m1 406, :m3-2 400}, :bufs {:b2 [402], :b1 [404 405], :b3 []}}, :line 508}
{:clk 732.6515, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 403, :dets {:run {:m3-1 401, :m4 399, :m2 403, :m1 406, :m3-2 400}, :bufs {:b2 [402], :b1 [404 405], :b3 []}}, :line 509}
{:clk 732.6515, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 404, :dets {:run {:m3-1 401, :m4 399, :m2 nil, :m1 406, :m3-2 400}, :bufs {:b2 [402 403], :b1 [404 405], :b3 []}}, :line 510}
{:clk 732.6515, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 401, :m4 399, :m2 404, :m1 406, :m3-2 400}, :bufs {:b2 [402 403], :b1 [405], :b3 []}}, :line 511}
{:clk 732.6515, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 406, :dets {:run {:m3-1 401, :m4 399, :m2 404, :m1 406, :m3-2 400}, :bufs {:b2 [402 403], :b1 [405], :b3 []}}, :line 512}
{:clk 732.6515, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 733.6515, :j 407, :dets {:run {:m3-1 401, :m4 399, :m2 404, :m1 nil, :m3-2 400}, :bufs {:b2 [402 403], :b1 [405 406], :b3 []}}, :line 513}
{:clk 733.6515, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 401, :m4 399, :m2 404, :m1 407, :m3-2 400}, :bufs {:b2 [402 403], :b1 [405 406], :b3 []}}, :line 514}
{:clk 733.8515, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 722.6331, :j 399, :dets {:run {:m3-1 401, :m4 399, :m2 404, :m1 407, :m3-2 400}, :bufs {:b2 [402 403], :b1 [405 406], :b3 []}}, :line 515}
{:clk 733.8515, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 401, :m4 nil, :m2 404, :m1 407, :m3-2 400}, :bufs {:b2 [402 403], :b1 [405 406], :b3 []}}, :line 516}
{:clk 734.0772, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 401, :m4 nil, :m2 404, :m1 407, :m3-2 400}, :bufs {:b2 [402 403], :b1 [405 406], :b3 []}}, :line 517}
{:clk 736.0865, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 400, :dets {:run {:m3-1 401, :m4 nil, :m2 404, :m1 407, :m3-2 400}, :bufs {:b2 [402 403], :b1 [405 406], :b3 []}}, :line 518}
{:clk 736.0865, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 402, :dets {:run {:m3-1 401, :m4 nil, :m2 404, :m1 407, :m3-2 nil}, :bufs {:b2 [402 403], :b1 [405 406], :b3 [400]}}, :line 519}
{:clk 736.0865, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 401, :m4 nil, :m2 404, :m1 407, :m3-2 402}, :bufs {:b2 [403], :b1 [405 406], :b3 [400]}}, :line 520}
{:clk 736.0865, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 400, :dets {:run {:m3-1 401, :m4 nil, :m2 404, :m1 407, :m3-2 402}, :bufs {:b2 [403], :b1 [405 406], :b3 [400]}}, :line 521}
{:clk 736.0865, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 401, :m4 400, :m2 404, :m1 407, :m3-2 402}, :bufs {:b2 [403], :b1 [405 406], :b3 []}}, :line 522}
{:clk 736.0865, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 404, :dets {:run {:m3-1 401, :m4 400, :m2 404, :m1 407, :m3-2 402}, :bufs {:b2 [403], :b1 [405 406], :b3 []}}, :line 523}
{:clk 736.0865, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 405, :dets {:run {:m3-1 401, :m4 400, :m2 nil, :m1 407, :m3-2 402}, :bufs {:b2 [403 404], :b1 [405 406], :b3 []}}, :line 524}
{:clk 736.0865, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 401, :m4 400, :m2 405, :m1 407, :m3-2 402}, :bufs {:b2 [403 404], :b1 [406], :b3 []}}, :line 525}
{:clk 736.0865, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 407, :dets {:run {:m3-1 401, :m4 400, :m2 405, :m1 407, :m3-2 402}, :bufs {:b2 [403 404], :b1 [406], :b3 []}}, :line 526}
{:clk 736.0865, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType2, :ends 737.0865, :j 408, :dets {:run {:m3-1 401, :m4 400, :m2 405, :m1 nil, :m3-2 402}, :bufs {:b2 [403 404], :b1 [406 407], :b3 []}}, :line 527}
{:clk 737.0865, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 723.6331, :j 400, :dets {:run {:m3-1 401, :m4 400, :m2 405, :m1 408, :m3-2 402}, :bufs {:b2 [403 404], :b1 [406 407], :b3 []}}, :line 528}
{:clk 737.0865, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 401, :m4 nil, :m2 405, :m1 408, :m3-2 402}, :bufs {:b2 [403 404], :b1 [406 407], :b3 []}}, :line 529}
{:clk 737.0865, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 401, :m4 nil, :m2 405, :m1 408, :m3-2 402}, :bufs {:b2 [403 404], :b1 [406 407], :b3 []}}, :line 530}
{:clk 737.0865, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 401, :m4 nil, :m2 405, :m1 408, :m3-2 402}, :bufs {:b2 [403 404], :b1 [406 407], :b3 []}}, :line 531}
{:clk 738.409, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 401, :dets {:run {:m3-1 401, :m4 nil, :m2 405, :m1 408, :m3-2 402}, :bufs {:b2 [403 404], :b1 [406 407], :b3 []}}, :line 532}
{:clk 738.409, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 403, :dets {:run {:m3-1 nil, :m4 nil, :m2 405, :m1 408, :m3-2 402}, :bufs {:b2 [403 404], :b1 [406 407], :b3 [401]}}, :line 533}
{:clk 738.409, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 403, :m4 nil, :m2 405, :m1 408, :m3-2 402}, :bufs {:b2 [404], :b1 [406 407], :b3 [401]}}, :line 534}
{:clk 738.409, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 401, :dets {:run {:m3-1 403, :m4 nil, :m2 405, :m1 408, :m3-2 402}, :bufs {:b2 [404], :b1 [406 407], :b3 [401]}}, :line 535}
{:clk 738.409, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 403, :m4 401, :m2 405, :m1 408, :m3-2 402}, :bufs {:b2 [404], :b1 [406 407], :b3 []}}, :line 536}
{:clk 738.409, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 405, :dets {:run {:m3-1 403, :m4 401, :m2 405, :m1 408, :m3-2 402}, :bufs {:b2 [404], :b1 [406 407], :b3 []}}, :line 537}
{:clk 738.409, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 406, :dets {:run {:m3-1 403, :m4 401, :m2 nil, :m1 408, :m3-2 402}, :bufs {:b2 [404 405], :b1 [406 407], :b3 []}}, :line 538}
{:clk 738.409, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 403, :m4 401, :m2 406, :m1 408, :m3-2 402}, :bufs {:b2 [404 405], :b1 [407], :b3 []}}, :line 539}
{:clk 738.409, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 408, :dets {:run {:m3-1 403, :m4 401, :m2 406, :m1 408, :m3-2 402}, :bufs {:b2 [404 405], :b1 [407], :b3 []}}, :line 540}
{:clk 738.409, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 739.409, :j 409, :dets {:run {:m3-1 403, :m4 401, :m2 406, :m1 nil, :m3-2 402}, :bufs {:b2 [404 405], :b1 [407 408], :b3 []}}, :line 541}
{:clk 739.409, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 403, :m4 401, :m2 406, :m1 409, :m3-2 402}, :bufs {:b2 [404 405], :b1 [407 408], :b3 []}}, :line 542}
{:clk 739.409, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 403, :m4 401, :m2 406, :m1 409, :m3-2 402}, :bufs {:b2 [404 405], :b1 [407 408], :b3 []}}, :line 543}
{:clk 739.609, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 724.6331, :j 401, :dets {:run {:m3-1 403, :m4 401, :m2 406, :m1 409, :m3-2 402}, :bufs {:b2 [404 405], :b1 [407 408], :b3 []}}, :line 544}
{:clk 739.609, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 403, :m4 nil, :m2 406, :m1 409, :m3-2 402}, :bufs {:b2 [404 405], :b1 [407 408], :b3 []}}, :line 545}
{:clk 739.6865, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 402, :dets {:run {:m3-1 403, :m4 nil, :m2 406, :m1 409, :m3-2 402}, :bufs {:b2 [404 405], :b1 [407 408], :b3 []}}, :line 546}
{:clk 739.6865, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 404, :dets {:run {:m3-1 403, :m4 nil, :m2 406, :m1 409, :m3-2 nil}, :bufs {:b2 [404 405], :b1 [407 408], :b3 [402]}}, :line 547}
{:clk 739.6865, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 403, :m4 nil, :m2 406, :m1 409, :m3-2 404}, :bufs {:b2 [405], :b1 [407 408], :b3 [402]}}, :line 548}
{:clk 739.6865, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 402, :dets {:run {:m3-1 403, :m4 nil, :m2 406, :m1 409, :m3-2 404}, :bufs {:b2 [405], :b1 [407 408], :b3 [402]}}, :line 549}
{:clk 739.6865, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 403, :m4 402, :m2 406, :m1 409, :m3-2 404}, :bufs {:b2 [405], :b1 [407 408], :b3 []}}, :line 550}
{:clk 739.6865, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 406, :dets {:run {:m3-1 403, :m4 402, :m2 406, :m1 409, :m3-2 404}, :bufs {:b2 [405], :b1 [407 408], :b3 []}}, :line 551}
{:clk 739.6865, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 407, :dets {:run {:m3-1 403, :m4 402, :m2 nil, :m1 409, :m3-2 404}, :bufs {:b2 [405 406], :b1 [407 408], :b3 []}}, :line 552}
{:clk 739.6865, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 403, :m4 402, :m2 407, :m1 409, :m3-2 404}, :bufs {:b2 [405 406], :b1 [408], :b3 []}}, :line 553}
{:clk 739.6865, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 409, :dets {:run {:m3-1 403, :m4 402, :m2 407, :m1 409, :m3-2 404}, :bufs {:b2 [405 406], :b1 [408], :b3 []}}, :line 554}
{:clk 739.6865, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 740.6865, :j 410, :dets {:run {:m3-1 403, :m4 402, :m2 407, :m1 nil, :m3-2 404}, :bufs {:b2 [405 406], :b1 [408 409], :b3 []}}, :line 555}
{:clk 740.6865, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 403, :m4 402, :m2 407, :m1 410, :m3-2 404}, :bufs {:b2 [405 406], :b1 [408 409], :b3 []}}, :line 556}
{:clk 740.6865, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 403, :m4 402, :m2 407, :m1 410, :m3-2 404}, :bufs {:b2 [405 406], :b1 [408 409], :b3 []}}, :line 557}
{:clk 740.8865, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 725.8501, :j 402, :dets {:run {:m3-1 403, :m4 402, :m2 407, :m1 410, :m3-2 404}, :bufs {:b2 [405 406], :b1 [408 409], :b3 []}}, :line 558}
{:clk 740.8865, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 403, :m4 nil, :m2 407, :m1 410, :m3-2 404}, :bufs {:b2 [405 406], :b1 [408 409], :b3 []}}, :line 559}
{:clk 741.409, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 403, :dets {:run {:m3-1 403, :m4 nil, :m2 407, :m1 410, :m3-2 404}, :bufs {:b2 [405 406], :b1 [408 409], :b3 []}}, :line 560}
{:clk 741.409, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 405, :dets {:run {:m3-1 nil, :m4 nil, :m2 407, :m1 410, :m3-2 404}, :bufs {:b2 [405 406], :b1 [408 409], :b3 [403]}}, :line 561}
{:clk 741.409, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 405, :m4 nil, :m2 407, :m1 410, :m3-2 404}, :bufs {:b2 [406], :b1 [408 409], :b3 [403]}}, :line 562}
{:clk 741.409, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 403, :dets {:run {:m3-1 405, :m4 nil, :m2 407, :m1 410, :m3-2 404}, :bufs {:b2 [406], :b1 [408 409], :b3 [403]}}, :line 563}
{:clk 741.409, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 405, :m4 403, :m2 407, :m1 410, :m3-2 404}, :bufs {:b2 [406], :b1 [408 409], :b3 []}}, :line 564}
{:clk 741.409, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 407, :dets {:run {:m3-1 405, :m4 403, :m2 407, :m1 410, :m3-2 404}, :bufs {:b2 [406], :b1 [408 409], :b3 []}}, :line 565}
{:clk 741.409, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 408, :dets {:run {:m3-1 405, :m4 403, :m2 nil, :m1 410, :m3-2 404}, :bufs {:b2 [406 407], :b1 [408 409], :b3 []}}, :line 566}
{:clk 741.409, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 405, :m4 403, :m2 408, :m1 410, :m3-2 404}, :bufs {:b2 [406 407], :b1 [409], :b3 []}}, :line 567}
{:clk 741.409, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 410, :dets {:run {:m3-1 405, :m4 403, :m2 408, :m1 410, :m3-2 404}, :bufs {:b2 [406 407], :b1 [409], :b3 []}}, :line 568}
{:clk 741.409, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 742.409, :j 411, :dets {:run {:m3-1 405, :m4 403, :m2 408, :m1 nil, :m3-2 404}, :bufs {:b2 [406 407], :b1 [409 410], :b3 []}}, :line 569}
{:clk 742.409, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 726.8501, :j 403, :dets {:run {:m3-1 405, :m4 403, :m2 408, :m1 411, :m3-2 404}, :bufs {:b2 [406 407], :b1 [409 410], :b3 []}}, :line 570}
{:clk 742.409, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 405, :m4 nil, :m2 408, :m1 411, :m3-2 404}, :bufs {:b2 [406 407], :b1 [409 410], :b3 []}}, :line 571}
{:clk 742.409, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 405, :m4 nil, :m2 408, :m1 411, :m3-2 404}, :bufs {:b2 [406 407], :b1 [409 410], :b3 []}}, :line 572}
{:clk 742.409, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 405, :m4 nil, :m2 408, :m1 411, :m3-2 404}, :bufs {:b2 [406 407], :b1 [409 410], :b3 []}}, :line 573}
{:clk 742.6865, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 404, :dets {:run {:m3-1 405, :m4 nil, :m2 408, :m1 411, :m3-2 404}, :bufs {:b2 [406 407], :b1 [409 410], :b3 []}}, :line 574}
{:clk 742.6865, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 406, :dets {:run {:m3-1 405, :m4 nil, :m2 408, :m1 411, :m3-2 nil}, :bufs {:b2 [406 407], :b1 [409 410], :b3 [404]}}, :line 575}
{:clk 742.6865, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 405, :m4 nil, :m2 408, :m1 411, :m3-2 406}, :bufs {:b2 [407], :b1 [409 410], :b3 [404]}}, :line 576}
{:clk 742.6865, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 404, :dets {:run {:m3-1 405, :m4 nil, :m2 408, :m1 411, :m3-2 406}, :bufs {:b2 [407], :b1 [409 410], :b3 [404]}}, :line 577}
{:clk 742.6865, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 405, :m4 404, :m2 408, :m1 411, :m3-2 406}, :bufs {:b2 [407], :b1 [409 410], :b3 []}}, :line 578}
{:clk 742.6865, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 408, :dets {:run {:m3-1 405, :m4 404, :m2 408, :m1 411, :m3-2 406}, :bufs {:b2 [407], :b1 [409 410], :b3 []}}, :line 579}
{:clk 742.6865, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 409, :dets {:run {:m3-1 405, :m4 404, :m2 nil, :m1 411, :m3-2 406}, :bufs {:b2 [407 408], :b1 [409 410], :b3 []}}, :line 580}
{:clk 742.6865, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 405, :m4 404, :m2 409, :m1 411, :m3-2 406}, :bufs {:b2 [407 408], :b1 [410], :b3 []}}, :line 581}
{:clk 742.6865, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 411, :dets {:run {:m3-1 405, :m4 404, :m2 409, :m1 411, :m3-2 406}, :bufs {:b2 [407 408], :b1 [410], :b3 []}}, :line 582}
{:clk 742.6865, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType2, :ends 743.6865, :j 412, :dets {:run {:m3-1 405, :m4 404, :m2 409, :m1 nil, :m3-2 406}, :bufs {:b2 [407 408], :b1 [410 411], :b3 []}}, :line 583}
{:clk 743.6865, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 727.8501, :j 404, :dets {:run {:m3-1 405, :m4 404, :m2 409, :m1 412, :m3-2 406}, :bufs {:b2 [407 408], :b1 [410 411], :b3 []}}, :line 584}
{:clk 743.6865, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 405, :m4 nil, :m2 409, :m1 412, :m3-2 406}, :bufs {:b2 [407 408], :b1 [410 411], :b3 []}}, :line 585}
{:clk 743.6865, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 405, :m4 nil, :m2 409, :m1 412, :m3-2 406}, :bufs {:b2 [407 408], :b1 [410 411], :b3 []}}, :line 586}
{:clk 743.6865, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 405, :m4 nil, :m2 409, :m1 412, :m3-2 406}, :bufs {:b2 [407 408], :b1 [410 411], :b3 []}}, :line 587}
{:clk 744.409, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 405, :dets {:run {:m3-1 405, :m4 nil, :m2 409, :m1 412, :m3-2 406}, :bufs {:b2 [407 408], :b1 [410 411], :b3 []}}, :line 588}
{:clk 744.409, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 407, :dets {:run {:m3-1 nil, :m4 nil, :m2 409, :m1 412, :m3-2 406}, :bufs {:b2 [407 408], :b1 [410 411], :b3 [405]}}, :line 589}
{:clk 744.409, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 407, :m4 nil, :m2 409, :m1 412, :m3-2 406}, :bufs {:b2 [408], :b1 [410 411], :b3 [405]}}, :line 590}
{:clk 744.409, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 405, :dets {:run {:m3-1 407, :m4 nil, :m2 409, :m1 412, :m3-2 406}, :bufs {:b2 [408], :b1 [410 411], :b3 [405]}}, :line 591}
{:clk 744.409, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 407, :m4 405, :m2 409, :m1 412, :m3-2 406}, :bufs {:b2 [408], :b1 [410 411], :b3 []}}, :line 592}
{:clk 744.409, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 409, :dets {:run {:m3-1 407, :m4 405, :m2 409, :m1 412, :m3-2 406}, :bufs {:b2 [408], :b1 [410 411], :b3 []}}, :line 593}
{:clk 744.409, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 410, :dets {:run {:m3-1 407, :m4 405, :m2 nil, :m1 412, :m3-2 406}, :bufs {:b2 [408 409], :b1 [410 411], :b3 []}}, :line 594}
{:clk 744.409, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 407, :m4 405, :m2 410, :m1 412, :m3-2 406}, :bufs {:b2 [408 409], :b1 [411], :b3 []}}, :line 595}
{:clk 744.409, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 412, :dets {:run {:m3-1 407, :m4 405, :m2 410, :m1 412, :m3-2 406}, :bufs {:b2 [408 409], :b1 [411], :b3 []}}, :line 596}
{:clk 744.409, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 745.409, :j 413, :dets {:run {:m3-1 407, :m4 405, :m2 410, :m1 nil, :m3-2 406}, :bufs {:b2 [408 409], :b1 [411 412], :b3 []}}, :line 597}
{:clk 745.409, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 729.0515, :j 405, :dets {:run {:m3-1 407, :m4 405, :m2 410, :m1 413, :m3-2 406}, :bufs {:b2 [408 409], :b1 [411 412], :b3 []}}, :line 598}
{:clk 745.409, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 407, :m4 nil, :m2 410, :m1 413, :m3-2 406}, :bufs {:b2 [408 409], :b1 [411 412], :b3 []}}, :line 599}
{:clk 745.409, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 407, :m4 nil, :m2 410, :m1 413, :m3-2 406}, :bufs {:b2 [408 409], :b1 [411 412], :b3 []}}, :line 600}
{:clk 745.409, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 407, :m4 nil, :m2 410, :m1 413, :m3-2 406}, :bufs {:b2 [408 409], :b1 [411 412], :b3 []}}, :line 601}
{:clk 745.6865, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 406, :dets {:run {:m3-1 407, :m4 nil, :m2 410, :m1 413, :m3-2 406}, :bufs {:b2 [408 409], :b1 [411 412], :b3 []}}, :line 602}
{:clk 745.6865, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 408, :dets {:run {:m3-1 407, :m4 nil, :m2 410, :m1 413, :m3-2 nil}, :bufs {:b2 [408 409], :b1 [411 412], :b3 [406]}}, :line 603}
{:clk 745.6865, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 407, :m4 nil, :m2 410, :m1 413, :m3-2 408}, :bufs {:b2 [409], :b1 [411 412], :b3 [406]}}, :line 604}
{:clk 745.6865, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 406, :dets {:run {:m3-1 407, :m4 nil, :m2 410, :m1 413, :m3-2 408}, :bufs {:b2 [409], :b1 [411 412], :b3 [406]}}, :line 605}
{:clk 745.6865, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 407, :m4 406, :m2 410, :m1 413, :m3-2 408}, :bufs {:b2 [409], :b1 [411 412], :b3 []}}, :line 606}
{:clk 745.6865, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 410, :dets {:run {:m3-1 407, :m4 406, :m2 410, :m1 413, :m3-2 408}, :bufs {:b2 [409], :b1 [411 412], :b3 []}}, :line 607}
{:clk 745.6865, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 411, :dets {:run {:m3-1 407, :m4 406, :m2 nil, :m1 413, :m3-2 408}, :bufs {:b2 [409 410], :b1 [411 412], :b3 []}}, :line 608}
{:clk 745.6865, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 407, :m4 406, :m2 411, :m1 413, :m3-2 408}, :bufs {:b2 [409 410], :b1 [412], :b3 []}}, :line 609}
{:clk 745.6865, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 413, :dets {:run {:m3-1 407, :m4 406, :m2 411, :m1 413, :m3-2 408}, :bufs {:b2 [409 410], :b1 [412], :b3 []}}, :line 610}
{:clk 745.6865, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 747.6684, :j 414, :dets {:run {:m3-1 407, :m4 406, :m2 411, :m1 nil, :m3-2 408}, :bufs {:b2 [409 410], :b1 [412 413], :b3 []}}, :line 611}
{:clk 746.6865, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 730.4054, :j 406, :dets {:run {:m3-1 407, :m4 406, :m2 411, :m1 414, :m3-2 408}, :bufs {:b2 [409 410], :b1 [412 413], :b3 []}}, :line 612}
{:clk 746.6865, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 407, :m4 nil, :m2 411, :m1 414, :m3-2 408}, :bufs {:b2 [409 410], :b1 [412 413], :b3 []}}, :line 613}
{:clk 746.6865, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 407, :m4 nil, :m2 411, :m1 414, :m3-2 408}, :bufs {:b2 [409 410], :b1 [412 413], :b3 []}}, :line 614}
{:clk 747.409, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 407, :dets {:run {:m3-1 407, :m4 nil, :m2 411, :m1 414, :m3-2 408}, :bufs {:b2 [409 410], :b1 [412 413], :b3 []}}, :line 615}
{:clk 747.409, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 409, :dets {:run {:m3-1 nil, :m4 nil, :m2 411, :m1 414, :m3-2 408}, :bufs {:b2 [409 410], :b1 [412 413], :b3 [407]}}, :line 616}
{:clk 747.409, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 409, :m4 nil, :m2 411, :m1 414, :m3-2 408}, :bufs {:b2 [410], :b1 [412 413], :b3 [407]}}, :line 617}
{:clk 747.409, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 407, :dets {:run {:m3-1 409, :m4 nil, :m2 411, :m1 414, :m3-2 408}, :bufs {:b2 [410], :b1 [412 413], :b3 [407]}}, :line 618}
{:clk 747.409, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 409, :m4 407, :m2 411, :m1 414, :m3-2 408}, :bufs {:b2 [410], :b1 [412 413], :b3 []}}, :line 619}
{:clk 747.409, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 411, :dets {:run {:m3-1 409, :m4 407, :m2 411, :m1 414, :m3-2 408}, :bufs {:b2 [410], :b1 [412 413], :b3 []}}, :line 620}
{:clk 747.409, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 412, :dets {:run {:m3-1 409, :m4 407, :m2 nil, :m1 414, :m3-2 408}, :bufs {:b2 [410 411], :b1 [412 413], :b3 []}}, :line 621}
{:clk 747.6684, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 414, :dets {:run {:m3-1 409, :m4 407, :m2 412, :m1 414, :m3-2 408}, :bufs {:b2 [410 411], :b1 [413], :b3 []}}, :line 622}
{:clk 747.6684, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 748.6684, :j 415, :dets {:run {:m3-1 409, :m4 407, :m2 412, :m1 nil, :m3-2 408}, :bufs {:b2 [410 411], :b1 [413 414], :b3 []}}, :line 623}
{:clk 748.409, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 732.6515, :j 407, :dets {:run {:m3-1 409, :m4 407, :m2 412, :m1 415, :m3-2 408}, :bufs {:b2 [410 411], :b1 [413 414], :b3 []}}, :line 624}
{:clk 748.409, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 409, :m4 nil, :m2 412, :m1 415, :m3-2 408}, :bufs {:b2 [410 411], :b1 [413 414], :b3 []}}, :line 625}
{:clk 748.409, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 409, :m4 nil, :m2 412, :m1 415, :m3-2 408}, :bufs {:b2 [410 411], :b1 [413 414], :b3 []}}, :line 626}
{:clk 748.6684, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 409, :m4 nil, :m2 412, :m1 415, :m3-2 408}, :bufs {:b2 [410 411], :b1 [413 414], :b3 []}}, :line 627}
{:clk 750.2277, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 408, :dets {:run {:m3-1 409, :m4 nil, :m2 412, :m1 415, :m3-2 408}, :bufs {:b2 [410 411], :b1 [413 414], :b3 []}}, :line 628}
{:clk 750.2277, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 410, :dets {:run {:m3-1 409, :m4 nil, :m2 412, :m1 415, :m3-2 nil}, :bufs {:b2 [410 411], :b1 [413 414], :b3 [408]}}, :line 629}
{:clk 750.2277, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 409, :m4 nil, :m2 412, :m1 415, :m3-2 410}, :bufs {:b2 [411], :b1 [413 414], :b3 [408]}}, :line 630}
{:clk 750.2277, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 408, :dets {:run {:m3-1 409, :m4 nil, :m2 412, :m1 415, :m3-2 410}, :bufs {:b2 [411], :b1 [413 414], :b3 [408]}}, :line 631}
{:clk 750.2277, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 409, :m4 408, :m2 412, :m1 415, :m3-2 410}, :bufs {:b2 [411], :b1 [413 414], :b3 []}}, :line 632}
{:clk 750.2277, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 412, :dets {:run {:m3-1 409, :m4 408, :m2 412, :m1 415, :m3-2 410}, :bufs {:b2 [411], :b1 [413 414], :b3 []}}, :line 633}
{:clk 750.2277, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 413, :dets {:run {:m3-1 409, :m4 408, :m2 nil, :m1 415, :m3-2 410}, :bufs {:b2 [411 412], :b1 [413 414], :b3 []}}, :line 634}
{:clk 750.2277, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 409, :m4 408, :m2 413, :m1 415, :m3-2 410}, :bufs {:b2 [411 412], :b1 [414], :b3 []}}, :line 635}
{:clk 750.2277, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 415, :dets {:run {:m3-1 409, :m4 408, :m2 413, :m1 415, :m3-2 410}, :bufs {:b2 [411 412], :b1 [414], :b3 []}}, :line 636}
{:clk 750.2277, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType2, :ends 751.2277, :j 416, :dets {:run {:m3-1 409, :m4 408, :m2 413, :m1 nil, :m3-2 410}, :bufs {:b2 [411 412], :b1 [414 415], :b3 []}}, :line 637}
{:clk 751.2277, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 409, :m4 408, :m2 413, :m1 416, :m3-2 410}, :bufs {:b2 [411 412], :b1 [414 415], :b3 []}}, :line 638}
{:clk 751.2277, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 409, :m4 408, :m2 413, :m1 416, :m3-2 410}, :bufs {:b2 [411 412], :b1 [414 415], :b3 []}}, :line 639}
{:clk 751.4277, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 736.0865, :j 408, :dets {:run {:m3-1 409, :m4 408, :m2 413, :m1 416, :m3-2 410}, :bufs {:b2 [411 412], :b1 [414 415], :b3 []}}, :line 640}
{:clk 751.4277, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 409, :m4 nil, :m2 413, :m1 416, :m3-2 410}, :bufs {:b2 [411 412], :b1 [414 415], :b3 []}}, :line 641}
{:clk 753.2277, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 410, :dets {:run {:m3-1 409, :m4 nil, :m2 413, :m1 416, :m3-2 410}, :bufs {:b2 [411 412], :b1 [414 415], :b3 []}}, :line 642}
{:clk 753.2277, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 411, :dets {:run {:m3-1 409, :m4 nil, :m2 413, :m1 416, :m3-2 nil}, :bufs {:b2 [411 412], :b1 [414 415], :b3 [410]}}, :line 643}
{:clk 753.2277, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 409, :m4 nil, :m2 413, :m1 416, :m3-2 411}, :bufs {:b2 [412], :b1 [414 415], :b3 [410]}}, :line 644}
{:clk 753.2277, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 410, :dets {:run {:m3-1 409, :m4 nil, :m2 413, :m1 416, :m3-2 411}, :bufs {:b2 [412], :b1 [414 415], :b3 [410]}}, :line 645}
{:clk 753.2277, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 409, :m4 410, :m2 413, :m1 416, :m3-2 411}, :bufs {:b2 [412], :b1 [414 415], :b3 []}}, :line 646}
{:clk 753.2277, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 413, :dets {:run {:m3-1 409, :m4 410, :m2 413, :m1 416, :m3-2 411}, :bufs {:b2 [412], :b1 [414 415], :b3 []}}, :line 647}
{:clk 753.2277, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 414, :dets {:run {:m3-1 409, :m4 410, :m2 nil, :m1 416, :m3-2 411}, :bufs {:b2 [412 413], :b1 [414 415], :b3 []}}, :line 648}
{:clk 753.2277, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 409, :m4 410, :m2 414, :m1 416, :m3-2 411}, :bufs {:b2 [412 413], :b1 [415], :b3 []}}, :line 649}
{:clk 753.2277, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 416, :dets {:run {:m3-1 409, :m4 410, :m2 414, :m1 416, :m3-2 411}, :bufs {:b2 [412 413], :b1 [415], :b3 []}}, :line 650}
{:clk 753.2277, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType2, :ends 754.2277, :j 417, :dets {:run {:m3-1 409, :m4 410, :m2 414, :m1 nil, :m3-2 411}, :bufs {:b2 [412 413], :b1 [415 416], :b3 []}}, :line 651}
{:clk 754.2277, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 739.6865, :j 410, :dets {:run {:m3-1 409, :m4 410, :m2 414, :m1 417, :m3-2 411}, :bufs {:b2 [412 413], :b1 [415 416], :b3 []}}, :line 652}
{:clk 754.2277, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 409, :m4 nil, :m2 414, :m1 417, :m3-2 411}, :bufs {:b2 [412 413], :b1 [415 416], :b3 []}}, :line 653}
{:clk 754.2277, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 409, :m4 nil, :m2 414, :m1 417, :m3-2 411}, :bufs {:b2 [412 413], :b1 [415 416], :b3 []}}, :line 654}
{:clk 754.2277, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 409, :m4 nil, :m2 414, :m1 417, :m3-2 411}, :bufs {:b2 [412 413], :b1 [415 416], :b3 []}}, :line 655}
{:clk 754.2746, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 409, :dets {:run {:m3-1 409, :m4 nil, :m2 414, :m1 417, :m3-2 411}, :bufs {:b2 [412 413], :b1 [415 416], :b3 []}}, :line 656}
{:clk 754.2746, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 412, :dets {:run {:m3-1 nil, :m4 nil, :m2 414, :m1 417, :m3-2 411}, :bufs {:b2 [412 413], :b1 [415 416], :b3 [409]}}, :line 657}
{:clk 754.2746, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 412, :m4 nil, :m2 414, :m1 417, :m3-2 411}, :bufs {:b2 [413], :b1 [415 416], :b3 [409]}}, :line 658}
{:clk 754.2746, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 409, :dets {:run {:m3-1 412, :m4 nil, :m2 414, :m1 417, :m3-2 411}, :bufs {:b2 [413], :b1 [415 416], :b3 [409]}}, :line 659}
{:clk 754.2746, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 412, :m4 409, :m2 414, :m1 417, :m3-2 411}, :bufs {:b2 [413], :b1 [415 416], :b3 []}}, :line 660}
{:clk 754.2746, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 414, :dets {:run {:m3-1 412, :m4 409, :m2 414, :m1 417, :m3-2 411}, :bufs {:b2 [413], :b1 [415 416], :b3 []}}, :line 661}
{:clk 754.2746, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 415, :dets {:run {:m3-1 412, :m4 409, :m2 nil, :m1 417, :m3-2 411}, :bufs {:b2 [413 414], :b1 [415 416], :b3 []}}, :line 662}
{:clk 754.2746, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 412, :m4 409, :m2 415, :m1 417, :m3-2 411}, :bufs {:b2 [413 414], :b1 [416], :b3 []}}, :line 663}
{:clk 754.2746, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 417, :dets {:run {:m3-1 412, :m4 409, :m2 415, :m1 417, :m3-2 411}, :bufs {:b2 [413 414], :b1 [416], :b3 []}}, :line 664}
{:clk 754.2746, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 755.2746, :j 418, :dets {:run {:m3-1 412, :m4 409, :m2 415, :m1 nil, :m3-2 411}, :bufs {:b2 [413 414], :b1 [416 417], :b3 []}}, :line 665}
{:clk 755.2746, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 738.409, :j 409, :dets {:run {:m3-1 412, :m4 409, :m2 415, :m1 418, :m3-2 411}, :bufs {:b2 [413 414], :b1 [416 417], :b3 []}}, :line 666}
{:clk 755.2746, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 412, :m4 nil, :m2 415, :m1 418, :m3-2 411}, :bufs {:b2 [413 414], :b1 [416 417], :b3 []}}, :line 667}
{:clk 755.2746, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 412, :m4 nil, :m2 415, :m1 418, :m3-2 411}, :bufs {:b2 [413 414], :b1 [416 417], :b3 []}}, :line 668}
{:clk 755.2746, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 412, :m4 nil, :m2 415, :m1 418, :m3-2 411}, :bufs {:b2 [413 414], :b1 [416 417], :b3 []}}, :line 669}
{:clk 756.587, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 411, :dets {:run {:m3-1 412, :m4 nil, :m2 415, :m1 418, :m3-2 411}, :bufs {:b2 [413 414], :b1 [416 417], :b3 []}}, :line 670}
{:clk 756.587, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 413, :dets {:run {:m3-1 412, :m4 nil, :m2 415, :m1 418, :m3-2 nil}, :bufs {:b2 [413 414], :b1 [416 417], :b3 [411]}}, :line 671}
{:clk 756.587, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 412, :m4 nil, :m2 415, :m1 418, :m3-2 413}, :bufs {:b2 [414], :b1 [416 417], :b3 [411]}}, :line 672}
{:clk 756.587, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 411, :dets {:run {:m3-1 412, :m4 nil, :m2 415, :m1 418, :m3-2 413}, :bufs {:b2 [414], :b1 [416 417], :b3 [411]}}, :line 673}
{:clk 756.587, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 412, :m4 411, :m2 415, :m1 418, :m3-2 413}, :bufs {:b2 [414], :b1 [416 417], :b3 []}}, :line 674}
{:clk 756.587, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 415, :dets {:run {:m3-1 412, :m4 411, :m2 415, :m1 418, :m3-2 413}, :bufs {:b2 [414], :b1 [416 417], :b3 []}}, :line 675}
{:clk 757.587, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 741.409, :j 411, :dets {:run {:m3-1 412, :m4 411, :m2 nil, :m1 418, :m3-2 413}, :bufs {:b2 [414 415], :b1 [416 417], :b3 []}}, :line 676}
{:clk 757.587, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 412, :m4 nil, :m2 nil, :m1 418, :m3-2 413}, :bufs {:b2 [414 415], :b1 [416 417], :b3 []}}, :line 677}
{:clk 759.4336, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 412, :dets {:run {:m3-1 412, :m4 nil, :m2 nil, :m1 418, :m3-2 413}, :bufs {:b2 [414 415], :b1 [416 417], :b3 []}}, :line 678}
{:clk 759.4336, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 414, :dets {:run {:m3-1 nil, :m4 nil, :m2 nil, :m1 418, :m3-2 413}, :bufs {:b2 [414 415], :b1 [416 417], :b3 [412]}}, :line 679}
{:clk 759.4336, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 414, :m4 nil, :m2 nil, :m1 418, :m3-2 413}, :bufs {:b2 [415], :b1 [416 417], :b3 [412]}}, :line 680}
{:clk 759.4336, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 412, :dets {:run {:m3-1 414, :m4 nil, :m2 nil, :m1 418, :m3-2 413}, :bufs {:b2 [415], :b1 [416 417], :b3 [412]}}, :line 681}
{:clk 759.587, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 413, :dets {:run {:m3-1 414, :m4 412, :m2 nil, :m1 418, :m3-2 413}, :bufs {:b2 [415], :b1 [416 417], :b3 []}}, :line 682}
{:clk 759.587, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 1, :j 415, :dets {:run {:m3-1 414, :m4 412, :m2 nil, :m1 418, :m3-2 nil}, :bufs {:b2 [415], :b1 [416 417], :b3 [413]}}, :line 683}
{:clk 760.6336, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 742.6865, :j 412, :dets {:run {:m3-1 414, :m4 412, :m2 nil, :m1 418, :m3-2 415}, :bufs {:b2 [], :b1 [416 417], :b3 [413]}}, :line 684}
{:clk 760.6336, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 413, :dets {:run {:m3-1 414, :m4 nil, :m2 nil, :m1 418, :m3-2 415}, :bufs {:b2 [], :b1 [416 417], :b3 [413]}}, :line 685}
{:clk 761.6336, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 744.409, :j 413, :dets {:run {:m3-1 414, :m4 413, :m2 nil, :m1 418, :m3-2 415}, :bufs {:b2 [], :b1 [416 417], :b3 []}}, :line 686}
{:clk 761.6336, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 414, :m4 nil, :m2 nil, :m1 418, :m3-2 415}, :bufs {:b2 [], :b1 [416 417], :b3 []}}, :line 687}
{:clk 762.4336, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 414, :dets {:run {:m3-1 414, :m4 nil, :m2 nil, :m1 418, :m3-2 415}, :bufs {:b2 [], :b1 [416 417], :b3 []}}, :line 688}
{:clk 762.4336, :act :m3-1-starved, :m :m3-1, :mjpact :st, :dets {:run {:m3-1 nil, :m4 nil, :m2 nil, :m1 418, :m3-2 415}, :bufs {:b2 [], :b1 [416 417], :b3 [414]}}, :line 689}
{:clk 762.4336, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 nil, :m4 nil, :m2 nil, :m1 418, :m3-2 415}, :bufs {:b2 [], :b1 [416 417], :b3 [414]}}, :line 690}
{:clk 762.4336, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 414, :dets {:run {:m3-1 nil, :m4 nil, :m2 nil, :m1 418, :m3-2 415}, :bufs {:b2 [], :b1 [416 417], :b3 [414]}}, :line 691}
{:clk 762.587, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 415, :dets {:run {:m3-1 nil, :m4 414, :m2 nil, :m1 418, :m3-2 415}, :bufs {:b2 [], :b1 [416 417], :b3 []}}, :line 692}
{:clk 762.587, :act :m3-2-starved, :m :m3-2, :mjpact :st, :dets {:run {:m3-1 nil, :m4 414, :m2 nil, :m1 418, :m3-2 nil}, :bufs {:b2 [], :b1 [416 417], :b3 [415]}}, :line 693}
{:clk 763.1281, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 416, :dets {:run {:m3-1 nil, :m4 414, :m2 nil, :m1 418, :m3-2 nil}, :bufs {:b2 [], :b1 [416 417], :b3 [415]}}, :line 694}
{:clk 763.1281, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 nil, :m4 414, :m2 416, :m1 418, :m3-2 nil}, :bufs {:b2 [], :b1 [417], :b3 [415]}}, :line 695}
{:clk 763.1281, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 418, :dets {:run {:m3-1 nil, :m4 414, :m2 416, :m1 418, :m3-2 nil}, :bufs {:b2 [], :b1 [417], :b3 [415]}}, :line 696}
{:clk 763.4336, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 745.6865, :j 414, :dets {:run {:m3-1 nil, :m4 414, :m2 416, :m1 nil, :m3-2 nil}, :bufs {:b2 [], :b1 [417 418], :b3 [415]}}, :line 697}
{:clk 763.4336, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 415, :dets {:run {:m3-1 nil, :m4 nil, :m2 416, :m1 nil, :m3-2 nil}, :bufs {:b2 [], :b1 [417 418], :b3 [415]}}, :line 698}
{:clk 763.6591, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 764.6591, :j 419, :dets {:run {:m3-1 nil, :m4 415, :m2 416, :m1 nil, :m3-2 nil}, :bufs {:b2 [], :b1 [417 418], :b3 []}}, :line 699}
{:clk 764.1281, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 0, :j 416, :dets {:run {:m3-1 nil, :m4 415, :m2 416, :m1 419, :m3-2 nil}, :bufs {:b2 [], :b1 [417 418], :b3 []}}, :line 700}
{:clk 764.1281, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 417, :dets {:run {:m3-1 nil, :m4 415, :m2 nil, :m1 419, :m3-2 nil}, :bufs {:b2 [416], :b1 [417 418], :b3 []}}, :line 701}
{:clk 764.1281, :act :m3-2-unstarved, :m :m3-2, :mjpact :us, :dets {:run {:m3-1 nil, :m4 415, :m2 417, :m1 419, :m3-2 nil}, :bufs {:b2 [416], :b1 [418], :b3 []}}, :line 702}
{:clk 764.1281, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 1, :j 416, :dets {:run {:m3-1 nil, :m4 415, :m2 417, :m1 419, :m3-2 nil}, :bufs {:b2 [416], :b1 [418], :b3 []}}, :line 703}
{:clk 764.4336, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 747.6684, :j 415, :dets {:run {:m3-1 nil, :m4 415, :m2 417, :m1 419, :m3-2 416}, :bufs {:b2 [], :b1 [418], :b3 []}}, :line 704}
{:clk 764.4336, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 nil, :m4 nil, :m2 417, :m1 419, :m3-2 416}, :bufs {:b2 [], :b1 [418], :b3 []}}, :line 705}
{:clk 764.6591, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 419, :dets {:run {:m3-1 nil, :m4 nil, :m2 417, :m1 419, :m3-2 416}, :bufs {:b2 [], :b1 [418], :b3 []}}, :line 706}
{:clk 764.6591, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType2, :ends 765.6591, :j 420, :dets {:run {:m3-1 nil, :m4 nil, :m2 417, :m1 nil, :m3-2 416}, :bufs {:b2 [], :b1 [418 419], :b3 []}}, :line 707}
{:clk 765.1281, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 0, :j 417, :dets {:run {:m3-1 nil, :m4 nil, :m2 417, :m1 420, :m3-2 416}, :bufs {:b2 [], :b1 [418 419], :b3 []}}, :line 708}
{:clk 765.1281, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 418, :dets {:run {:m3-1 nil, :m4 nil, :m2 nil, :m1 420, :m3-2 416}, :bufs {:b2 [417], :b1 [418 419], :b3 []}}, :line 709}
{:clk 765.1281, :act :m3-1-unstarved, :m :m3-1, :mjpact :us, :dets {:run {:m3-1 nil, :m4 nil, :m2 418, :m1 420, :m3-2 416}, :bufs {:b2 [417], :b1 [419], :b3 []}}, :line 710}
{:clk 765.1281, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 1, :j 417, :dets {:run {:m3-1 nil, :m4 nil, :m2 418, :m1 420, :m3-2 416}, :bufs {:b2 [417], :b1 [419], :b3 []}}, :line 711}
{:clk 765.6591, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 420, :dets {:run {:m3-1 417, :m4 nil, :m2 418, :m1 420, :m3-2 416}, :bufs {:b2 [], :b1 [419], :b3 []}}, :line 712}
{:clk 765.6591, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 766.6591, :j 421, :dets {:run {:m3-1 417, :m4 nil, :m2 418, :m1 nil, :m3-2 416}, :bufs {:b2 [], :b1 [419 420], :b3 []}}, :line 713}
{:clk 766.1281, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 0, :j 418, :dets {:run {:m3-1 417, :m4 nil, :m2 418, :m1 421, :m3-2 416}, :bufs {:b2 [], :b1 [419 420], :b3 []}}, :line 714}
{:clk 766.1281, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 419, :dets {:run {:m3-1 417, :m4 nil, :m2 nil, :m1 421, :m3-2 416}, :bufs {:b2 [418], :b1 [419 420], :b3 []}}, :line 715}
{:clk 766.6591, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 421, :dets {:run {:m3-1 417, :m4 nil, :m2 419, :m1 421, :m3-2 416}, :bufs {:b2 [418], :b1 [420], :b3 []}}, :line 716}
{:clk 766.6591, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 767.6591, :j 422, :dets {:run {:m3-1 417, :m4 nil, :m2 419, :m1 nil, :m3-2 416}, :bufs {:b2 [418], :b1 [420 421], :b3 []}}, :line 717}
{:clk 767.1281, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 419, :dets {:run {:m3-1 417, :m4 nil, :m2 419, :m1 422, :m3-2 416}, :bufs {:b2 [418], :b1 [420 421], :b3 []}}, :line 718}
{:clk 767.1281, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 420, :dets {:run {:m3-1 417, :m4 nil, :m2 nil, :m1 422, :m3-2 416}, :bufs {:b2 [418 419], :b1 [420 421], :b3 []}}, :line 719}
{:clk 767.6591, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 422, :dets {:run {:m3-1 417, :m4 nil, :m2 420, :m1 422, :m3-2 416}, :bufs {:b2 [418 419], :b1 [421], :b3 []}}, :line 720}
{:clk 767.6591, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 768.6591, :j 423, :dets {:run {:m3-1 417, :m4 nil, :m2 420, :m1 nil, :m3-2 416}, :bufs {:b2 [418 419], :b1 [421 422], :b3 []}}, :line 721}
{:clk 767.7281, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 416, :dets {:run {:m3-1 417, :m4 nil, :m2 420, :m1 423, :m3-2 416}, :bufs {:b2 [418 419], :b1 [421 422], :b3 []}}, :line 722}
{:clk 767.7281, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 418, :dets {:run {:m3-1 417, :m4 nil, :m2 420, :m1 423, :m3-2 nil}, :bufs {:b2 [418 419], :b1 [421 422], :b3 [416]}}, :line 723}
{:clk 767.7281, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 417, :m4 nil, :m2 420, :m1 423, :m3-2 418}, :bufs {:b2 [419], :b1 [421 422], :b3 [416]}}, :line 724}
{:clk 767.7281, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 416, :dets {:run {:m3-1 417, :m4 nil, :m2 420, :m1 423, :m3-2 418}, :bufs {:b2 [419], :b1 [421 422], :b3 [416]}}, :line 725}
{:clk 768.1281, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 420, :dets {:run {:m3-1 417, :m4 416, :m2 420, :m1 423, :m3-2 418}, :bufs {:b2 [419], :b1 [421 422], :b3 []}}, :line 726}
{:clk 768.1281, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 421, :dets {:run {:m3-1 417, :m4 416, :m2 nil, :m1 423, :m3-2 418}, :bufs {:b2 [419 420], :b1 [421 422], :b3 []}}, :line 727}
{:clk 768.6591, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 423, :dets {:run {:m3-1 417, :m4 416, :m2 421, :m1 423, :m3-2 418}, :bufs {:b2 [419 420], :b1 [422], :b3 []}}, :line 728}
{:clk 768.6591, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 770.7805, :j 424, :dets {:run {:m3-1 417, :m4 416, :m2 421, :m1 nil, :m3-2 418}, :bufs {:b2 [419 420], :b1 [422 423], :b3 []}}, :line 729}
{:clk 768.7281, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 417, :dets {:run {:m3-1 417, :m4 416, :m2 421, :m1 424, :m3-2 418}, :bufs {:b2 [419 420], :b1 [422 423], :b3 []}}, :line 730}
{:clk 768.7281, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 419, :dets {:run {:m3-1 nil, :m4 416, :m2 421, :m1 424, :m3-2 418}, :bufs {:b2 [419 420], :b1 [422 423], :b3 [417]}}, :line 731}
{:clk 768.9281, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 750.2277, :j 416, :dets {:run {:m3-1 419, :m4 416, :m2 421, :m1 424, :m3-2 418}, :bufs {:b2 [420], :b1 [422 423], :b3 [417]}}, :line 732}
{:clk 768.9281, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 417, :dets {:run {:m3-1 419, :m4 nil, :m2 421, :m1 424, :m3-2 418}, :bufs {:b2 [420], :b1 [422 423], :b3 [417]}}, :line 733}
{:clk 769.1281, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 421, :dets {:run {:m3-1 419, :m4 417, :m2 421, :m1 424, :m3-2 418}, :bufs {:b2 [420], :b1 [422 423], :b3 []}}, :line 734}
{:clk 769.1281, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 422, :dets {:run {:m3-1 419, :m4 417, :m2 nil, :m1 424, :m3-2 418}, :bufs {:b2 [420 421], :b1 [422 423], :b3 []}}, :line 735}
{:clk 770.1281, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 419, :m4 417, :m2 422, :m1 424, :m3-2 418}, :bufs {:b2 [420 421], :b1 [423], :b3 []}}, :line 736}
{:clk 770.1281, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 753.2277, :j 417, :dets {:run {:m3-1 419, :m4 417, :m2 422, :m1 424, :m3-2 418}, :bufs {:b2 [420 421], :b1 [423], :b3 []}}, :line 737}
{:clk 770.1281, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 419, :m4 nil, :m2 422, :m1 424, :m3-2 418}, :bufs {:b2 [420 421], :b1 [423], :b3 []}}, :line 738}
{:clk 770.7281, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 418, :dets {:run {:m3-1 419, :m4 nil, :m2 422, :m1 424, :m3-2 418}, :bufs {:b2 [420 421], :b1 [423], :b3 []}}, :line 739}
{:clk 770.7281, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 420, :dets {:run {:m3-1 419, :m4 nil, :m2 422, :m1 424, :m3-2 nil}, :bufs {:b2 [420 421], :b1 [423], :b3 [418]}}, :line 740}
{:clk 770.7281, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 419, :m4 nil, :m2 422, :m1 424, :m3-2 420}, :bufs {:b2 [421], :b1 [423], :b3 [418]}}, :line 741}
{:clk 770.7281, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 418, :dets {:run {:m3-1 419, :m4 nil, :m2 422, :m1 424, :m3-2 420}, :bufs {:b2 [421], :b1 [423], :b3 [418]}}, :line 742}
{:clk 770.7281, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 419, :m4 418, :m2 422, :m1 424, :m3-2 420}, :bufs {:b2 [421], :b1 [423], :b3 []}}, :line 743}
{:clk 770.7281, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 422, :dets {:run {:m3-1 419, :m4 418, :m2 422, :m1 424, :m3-2 420}, :bufs {:b2 [421], :b1 [423], :b3 []}}, :line 744}
{:clk 770.7281, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 1, :j 423, :dets {:run {:m3-1 419, :m4 418, :m2 nil, :m1 424, :m3-2 420}, :bufs {:b2 [421 422], :b1 [423], :b3 []}}, :line 745}
{:clk 770.7805, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 0, :j 424, :dets {:run {:m3-1 419, :m4 418, :m2 423, :m1 424, :m3-2 420}, :bufs {:b2 [421 422], :b1 [], :b3 []}}, :line 746}
{:clk 770.7805, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 771.7805, :j 425, :dets {:run {:m3-1 419, :m4 418, :m2 423, :m1 nil, :m3-2 420}, :bufs {:b2 [421 422], :b1 [424], :b3 []}}, :line 747}
{:clk 771.7281, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 419, :dets {:run {:m3-1 419, :m4 418, :m2 423, :m1 425, :m3-2 420}, :bufs {:b2 [421 422], :b1 [424], :b3 []}}, :line 748}
{:clk 771.7281, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 754.2746, :j 418, :dets {:run {:m3-1 nil, :m4 418, :m2 423, :m1 425, :m3-2 420}, :bufs {:b2 [421 422], :b1 [424], :b3 [419]}}, :line 749}
{:clk 771.7281, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 419, :dets {:run {:m3-1 nil, :m4 nil, :m2 423, :m1 425, :m3-2 420}, :bufs {:b2 [421 422], :b1 [424], :b3 [419]}}, :line 750}
{:clk 771.7281, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 421, :dets {:run {:m3-1 nil, :m4 419, :m2 423, :m1 425, :m3-2 420}, :bufs {:b2 [421 422], :b1 [424], :b3 []}}, :line 751}
{:clk 771.7281, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 423, :dets {:run {:m3-1 421, :m4 419, :m2 423, :m1 425, :m3-2 420}, :bufs {:b2 [422], :b1 [424], :b3 []}}, :line 752}
{:clk 771.7281, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 1, :j 424, :dets {:run {:m3-1 421, :m4 419, :m2 nil, :m1 425, :m3-2 420}, :bufs {:b2 [422 423], :b1 [424], :b3 []}}, :line 753}
{:clk 771.7805, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 0, :j 425, :dets {:run {:m3-1 421, :m4 419, :m2 424, :m1 425, :m3-2 420}, :bufs {:b2 [422 423], :b1 [], :b3 []}}, :line 754}
{:clk 771.7805, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 772.7805, :j 426, :dets {:run {:m3-1 421, :m4 419, :m2 424, :m1 nil, :m3-2 420}, :bufs {:b2 [422 423], :b1 [425], :b3 []}}, :line 755}
{:clk 772.7281, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 763.6591, :j 419, :dets {:run {:m3-1 421, :m4 419, :m2 424, :m1 426, :m3-2 420}, :bufs {:b2 [422 423], :b1 [425], :b3 []}}, :line 756}
{:clk 772.7281, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 421, :m4 nil, :m2 424, :m1 426, :m3-2 420}, :bufs {:b2 [422 423], :b1 [425], :b3 []}}, :line 757}
{:clk 772.7805, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 426, :dets {:run {:m3-1 421, :m4 nil, :m2 424, :m1 426, :m3-2 420}, :bufs {:b2 [422 423], :b1 [425], :b3 []}}, :line 758}
{:clk 772.7805, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType2, :ends 773.7805, :j 427, :dets {:run {:m3-1 421, :m4 nil, :m2 424, :m1 nil, :m3-2 420}, :bufs {:b2 [422 423], :b1 [425 426], :b3 []}}, :line 759}
{:clk 773.7805, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 421, :m4 nil, :m2 424, :m1 427, :m3-2 420}, :bufs {:b2 [422 423], :b1 [425 426], :b3 []}}, :line 760}
{:clk 774.3281, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 420, :dets {:run {:m3-1 421, :m4 nil, :m2 424, :m1 427, :m3-2 420}, :bufs {:b2 [422 423], :b1 [425 426], :b3 []}}, :line 761}
{:clk 774.3281, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 422, :dets {:run {:m3-1 421, :m4 nil, :m2 424, :m1 427, :m3-2 nil}, :bufs {:b2 [422 423], :b1 [425 426], :b3 [420]}}, :line 762}
{:clk 774.3281, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 421, :m4 nil, :m2 424, :m1 427, :m3-2 422}, :bufs {:b2 [423], :b1 [425 426], :b3 [420]}}, :line 763}
{:clk 774.3281, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 420, :dets {:run {:m3-1 421, :m4 nil, :m2 424, :m1 427, :m3-2 422}, :bufs {:b2 [423], :b1 [425 426], :b3 [420]}}, :line 764}
{:clk 774.7281, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 421, :dets {:run {:m3-1 421, :m4 420, :m2 424, :m1 427, :m3-2 422}, :bufs {:b2 [423], :b1 [425 426], :b3 []}}, :line 765}
{:clk 774.7281, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 1, :j 423, :dets {:run {:m3-1 nil, :m4 420, :m2 424, :m1 427, :m3-2 422}, :bufs {:b2 [423], :b1 [425 426], :b3 [421]}}, :line 766}
{:clk 775.5281, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 764.6591, :j 420, :dets {:run {:m3-1 423, :m4 420, :m2 424, :m1 427, :m3-2 422}, :bufs {:b2 [], :b1 [425 426], :b3 [421]}}, :line 767}
{:clk 775.5281, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 421, :dets {:run {:m3-1 423, :m4 nil, :m2 424, :m1 427, :m3-2 422}, :bufs {:b2 [], :b1 [425 426], :b3 [421]}}, :line 768}
{:clk 775.5293, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 0, :j 424, :dets {:run {:m3-1 423, :m4 421, :m2 424, :m1 427, :m3-2 422}, :bufs {:b2 [], :b1 [425 426], :b3 []}}, :line 769}
{:clk 775.5293, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 425, :dets {:run {:m3-1 423, :m4 421, :m2 nil, :m1 427, :m3-2 422}, :bufs {:b2 [424], :b1 [425 426], :b3 []}}, :line 770}
{:clk 775.5293, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 423, :m4 421, :m2 425, :m1 427, :m3-2 422}, :bufs {:b2 [424], :b1 [426], :b3 []}}, :line 771}
{:clk 775.5293, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 427, :dets {:run {:m3-1 423, :m4 421, :m2 425, :m1 427, :m3-2 422}, :bufs {:b2 [424], :b1 [426], :b3 []}}, :line 772}
{:clk 775.5293, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 776.5293, :j 428, :dets {:run {:m3-1 423, :m4 421, :m2 425, :m1 nil, :m3-2 422}, :bufs {:b2 [424], :b1 [426 427], :b3 []}}, :line 773}
{:clk 776.5281, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 765.6591, :j 421, :dets {:run {:m3-1 423, :m4 421, :m2 425, :m1 428, :m3-2 422}, :bufs {:b2 [424], :b1 [426 427], :b3 []}}, :line 774}
{:clk 776.5281, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 423, :m4 nil, :m2 425, :m1 428, :m3-2 422}, :bufs {:b2 [424], :b1 [426 427], :b3 []}}, :line 775}
{:clk 776.5293, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 425, :dets {:run {:m3-1 423, :m4 nil, :m2 425, :m1 428, :m3-2 422}, :bufs {:b2 [424], :b1 [426 427], :b3 []}}, :line 776}
{:clk 776.5293, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 426, :dets {:run {:m3-1 423, :m4 nil, :m2 nil, :m1 428, :m3-2 422}, :bufs {:b2 [424 425], :b1 [426 427], :b3 []}}, :line 777}
{:clk 776.5293, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 428, :dets {:run {:m3-1 423, :m4 nil, :m2 426, :m1 428, :m3-2 422}, :bufs {:b2 [424 425], :b1 [427], :b3 []}}, :line 778}
{:clk 776.5293, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 777.5293, :j 429, :dets {:run {:m3-1 423, :m4 nil, :m2 426, :m1 nil, :m3-2 422}, :bufs {:b2 [424 425], :b1 [427 428], :b3 []}}, :line 779}
{:clk 777.3281, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 422, :dets {:run {:m3-1 423, :m4 nil, :m2 426, :m1 429, :m3-2 422}, :bufs {:b2 [424 425], :b1 [427 428], :b3 []}}, :line 780}
{:clk 777.3281, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 424, :dets {:run {:m3-1 423, :m4 nil, :m2 426, :m1 429, :m3-2 nil}, :bufs {:b2 [424 425], :b1 [427 428], :b3 [422]}}, :line 781}
{:clk 777.3281, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 423, :m4 nil, :m2 426, :m1 429, :m3-2 424}, :bufs {:b2 [425], :b1 [427 428], :b3 [422]}}, :line 782}
{:clk 777.3281, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 422, :dets {:run {:m3-1 423, :m4 nil, :m2 426, :m1 429, :m3-2 424}, :bufs {:b2 [425], :b1 [427 428], :b3 [422]}}, :line 783}
{:clk 777.5293, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 426, :dets {:run {:m3-1 423, :m4 422, :m2 426, :m1 429, :m3-2 424}, :bufs {:b2 [425], :b1 [427 428], :b3 []}}, :line 784}
{:clk 777.5293, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 427, :dets {:run {:m3-1 423, :m4 422, :m2 nil, :m1 429, :m3-2 424}, :bufs {:b2 [425 426], :b1 [427 428], :b3 []}}, :line 785}
{:clk 777.5293, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 429, :dets {:run {:m3-1 423, :m4 422, :m2 427, :m1 429, :m3-2 424}, :bufs {:b2 [425 426], :b1 [428], :b3 []}}, :line 786}
{:clk 777.5293, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 778.5293, :j 430, :dets {:run {:m3-1 423, :m4 422, :m2 427, :m1 nil, :m3-2 424}, :bufs {:b2 [425 426], :b1 [428 429], :b3 []}}, :line 787}
{:clk 777.9489, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 423, :dets {:run {:m3-1 423, :m4 422, :m2 427, :m1 430, :m3-2 424}, :bufs {:b2 [425 426], :b1 [428 429], :b3 []}}, :line 788}
{:clk 777.9489, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 425, :dets {:run {:m3-1 nil, :m4 422, :m2 427, :m1 430, :m3-2 424}, :bufs {:b2 [425 426], :b1 [428 429], :b3 [423]}}, :line 789}
{:clk 778.3281, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 766.6591, :j 422, :dets {:run {:m3-1 425, :m4 422, :m2 427, :m1 430, :m3-2 424}, :bufs {:b2 [426], :b1 [428 429], :b3 [423]}}, :line 790}
{:clk 778.3281, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 423, :dets {:run {:m3-1 425, :m4 nil, :m2 427, :m1 430, :m3-2 424}, :bufs {:b2 [426], :b1 [428 429], :b3 [423]}}, :line 791}
{:clk 778.5293, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 427, :dets {:run {:m3-1 425, :m4 423, :m2 427, :m1 430, :m3-2 424}, :bufs {:b2 [426], :b1 [428 429], :b3 []}}, :line 792}
{:clk 778.5293, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 428, :dets {:run {:m3-1 425, :m4 423, :m2 nil, :m1 430, :m3-2 424}, :bufs {:b2 [426 427], :b1 [428 429], :b3 []}}, :line 793}
{:clk 778.5293, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 430, :dets {:run {:m3-1 425, :m4 423, :m2 428, :m1 430, :m3-2 424}, :bufs {:b2 [426 427], :b1 [429], :b3 []}}, :line 794}
{:clk 778.5293, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 779.5293, :j 431, :dets {:run {:m3-1 425, :m4 423, :m2 428, :m1 nil, :m3-2 424}, :bufs {:b2 [426 427], :b1 [429 430], :b3 []}}, :line 795}
{:clk 779.3281, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 767.6591, :j 423, :dets {:run {:m3-1 425, :m4 423, :m2 428, :m1 431, :m3-2 424}, :bufs {:b2 [426 427], :b1 [429 430], :b3 []}}, :line 796}
{:clk 779.3281, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 425, :m4 nil, :m2 428, :m1 431, :m3-2 424}, :bufs {:b2 [426 427], :b1 [429 430], :b3 []}}, :line 797}
{:clk 779.5293, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 425, :m4 nil, :m2 428, :m1 431, :m3-2 424}, :bufs {:b2 [426 427], :b1 [429 430], :b3 []}}, :line 798}
{:clk 779.5293, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 425, :m4 nil, :m2 428, :m1 431, :m3-2 424}, :bufs {:b2 [426 427], :b1 [429 430], :b3 []}}, :line 799}
{:clk 780.3281, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 424, :dets {:run {:m3-1 425, :m4 nil, :m2 428, :m1 431, :m3-2 424}, :bufs {:b2 [426 427], :b1 [429 430], :b3 []}}, :line 800}
{:clk 780.3281, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 426, :dets {:run {:m3-1 425, :m4 nil, :m2 428, :m1 431, :m3-2 nil}, :bufs {:b2 [426 427], :b1 [429 430], :b3 [424]}}, :line 801}
{:clk 780.3281, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 425, :m4 nil, :m2 428, :m1 431, :m3-2 426}, :bufs {:b2 [427], :b1 [429 430], :b3 [424]}}, :line 802}
{:clk 780.3281, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 424, :dets {:run {:m3-1 425, :m4 nil, :m2 428, :m1 431, :m3-2 426}, :bufs {:b2 [427], :b1 [429 430], :b3 [424]}}, :line 803}
{:clk 780.3281, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 425, :m4 424, :m2 428, :m1 431, :m3-2 426}, :bufs {:b2 [427], :b1 [429 430], :b3 []}}, :line 804}
{:clk 780.3281, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 428, :dets {:run {:m3-1 425, :m4 424, :m2 428, :m1 431, :m3-2 426}, :bufs {:b2 [427], :b1 [429 430], :b3 []}}, :line 805}
{:clk 780.3281, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 429, :dets {:run {:m3-1 425, :m4 424, :m2 nil, :m1 431, :m3-2 426}, :bufs {:b2 [427 428], :b1 [429 430], :b3 []}}, :line 806}
{:clk 780.3281, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 425, :m4 424, :m2 429, :m1 431, :m3-2 426}, :bufs {:b2 [427 428], :b1 [430], :b3 []}}, :line 807}
{:clk 780.3281, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 431, :dets {:run {:m3-1 425, :m4 424, :m2 429, :m1 431, :m3-2 426}, :bufs {:b2 [427 428], :b1 [430], :b3 []}}, :line 808}
{:clk 780.3281, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 781.3281, :j 432, :dets {:run {:m3-1 425, :m4 424, :m2 429, :m1 nil, :m3-2 426}, :bufs {:b2 [427 428], :b1 [430 431], :b3 []}}, :line 809}
{:clk 780.9489, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 425, :dets {:run {:m3-1 425, :m4 424, :m2 429, :m1 432, :m3-2 426}, :bufs {:b2 [427 428], :b1 [430 431], :b3 []}}, :line 810}
{:clk 780.9489, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 427, :dets {:run {:m3-1 nil, :m4 424, :m2 429, :m1 432, :m3-2 426}, :bufs {:b2 [427 428], :b1 [430 431], :b3 [425]}}, :line 811}
{:clk 781.3281, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 768.6591, :j 424, :dets {:run {:m3-1 427, :m4 424, :m2 429, :m1 432, :m3-2 426}, :bufs {:b2 [428], :b1 [430 431], :b3 [425]}}, :line 812}
{:clk 781.3281, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 429, :dets {:run {:m3-1 427, :m4 nil, :m2 429, :m1 432, :m3-2 426}, :bufs {:b2 [428], :b1 [430 431], :b3 [425]}}, :line 813}
{:clk 781.3281, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 425, :dets {:run {:m3-1 427, :m4 nil, :m2 nil, :m1 432, :m3-2 426}, :bufs {:b2 [428 429], :b1 [430 431], :b3 [425]}}, :line 814}
{:clk 781.3281, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 430, :dets {:run {:m3-1 427, :m4 425, :m2 nil, :m1 432, :m3-2 426}, :bufs {:b2 [428 429], :b1 [430 431], :b3 []}}, :line 815}
{:clk 781.3281, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 432, :dets {:run {:m3-1 427, :m4 425, :m2 430, :m1 432, :m3-2 426}, :bufs {:b2 [428 429], :b1 [431], :b3 []}}, :line 816}
{:clk 781.3281, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 782.3281, :j 433, :dets {:run {:m3-1 427, :m4 425, :m2 430, :m1 nil, :m3-2 426}, :bufs {:b2 [428 429], :b1 [431 432], :b3 []}}, :line 817}
{:clk 782.3281, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 770.7805, :j 425, :dets {:run {:m3-1 427, :m4 425, :m2 430, :m1 433, :m3-2 426}, :bufs {:b2 [428 429], :b1 [431 432], :b3 []}}, :line 818}
{:clk 782.3281, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 427, :m4 nil, :m2 430, :m1 433, :m3-2 426}, :bufs {:b2 [428 429], :b1 [431 432], :b3 []}}, :line 819}
{:clk 782.3281, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 427, :m4 nil, :m2 430, :m1 433, :m3-2 426}, :bufs {:b2 [428 429], :b1 [431 432], :b3 []}}, :line 820}
{:clk 782.3281, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 427, :m4 nil, :m2 430, :m1 433, :m3-2 426}, :bufs {:b2 [428 429], :b1 [431 432], :b3 []}}, :line 821}
{:clk 783.3281, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 426, :dets {:run {:m3-1 427, :m4 nil, :m2 430, :m1 433, :m3-2 426}, :bufs {:b2 [428 429], :b1 [431 432], :b3 []}}, :line 822}
{:clk 783.3281, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 428, :dets {:run {:m3-1 427, :m4 nil, :m2 430, :m1 433, :m3-2 nil}, :bufs {:b2 [428 429], :b1 [431 432], :b3 [426]}}, :line 823}
{:clk 783.3281, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 427, :m4 nil, :m2 430, :m1 433, :m3-2 428}, :bufs {:b2 [429], :b1 [431 432], :b3 [426]}}, :line 824}
{:clk 783.3281, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 426, :dets {:run {:m3-1 427, :m4 nil, :m2 430, :m1 433, :m3-2 428}, :bufs {:b2 [429], :b1 [431 432], :b3 [426]}}, :line 825}
{:clk 783.3281, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 427, :m4 426, :m2 430, :m1 433, :m3-2 428}, :bufs {:b2 [429], :b1 [431 432], :b3 []}}, :line 826}
{:clk 783.3281, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 430, :dets {:run {:m3-1 427, :m4 426, :m2 430, :m1 433, :m3-2 428}, :bufs {:b2 [429], :b1 [431 432], :b3 []}}, :line 827}
{:clk 783.3281, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 431, :dets {:run {:m3-1 427, :m4 426, :m2 nil, :m1 433, :m3-2 428}, :bufs {:b2 [429 430], :b1 [431 432], :b3 []}}, :line 828}
{:clk 783.3281, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 427, :m4 426, :m2 431, :m1 433, :m3-2 428}, :bufs {:b2 [429 430], :b1 [432], :b3 []}}, :line 829}
{:clk 783.3281, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 433, :dets {:run {:m3-1 427, :m4 426, :m2 431, :m1 433, :m3-2 428}, :bufs {:b2 [429 430], :b1 [432], :b3 []}}, :line 830}
{:clk 784.3281, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 771.7805, :j 426, :dets {:run {:m3-1 427, :m4 426, :m2 431, :m1 nil, :m3-2 428}, :bufs {:b2 [429 430], :b1 [432 433], :b3 []}}, :line 831}
{:clk 784.3281, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 427, :m4 nil, :m2 431, :m1 nil, :m3-2 428}, :bufs {:b2 [429 430], :b1 [432 433], :b3 []}}, :line 832}
{:clk 784.5128, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 785.5128, :j 434, :dets {:run {:m3-1 427, :m4 nil, :m2 431, :m1 nil, :m3-2 428}, :bufs {:b2 [429 430], :b1 [432 433], :b3 []}}, :line 833}
{:clk 784.5489, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 427, :dets {:run {:m3-1 427, :m4 nil, :m2 431, :m1 434, :m3-2 428}, :bufs {:b2 [429 430], :b1 [432 433], :b3 []}}, :line 834}
{:clk 784.5489, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 429, :dets {:run {:m3-1 nil, :m4 nil, :m2 431, :m1 434, :m3-2 428}, :bufs {:b2 [429 430], :b1 [432 433], :b3 [427]}}, :line 835}
{:clk 784.5489, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 429, :m4 nil, :m2 431, :m1 434, :m3-2 428}, :bufs {:b2 [430], :b1 [432 433], :b3 [427]}}, :line 836}
{:clk 784.5489, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 427, :dets {:run {:m3-1 429, :m4 nil, :m2 431, :m1 434, :m3-2 428}, :bufs {:b2 [430], :b1 [432 433], :b3 [427]}}, :line 837}
{:clk 785.381, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 431, :dets {:run {:m3-1 429, :m4 427, :m2 431, :m1 434, :m3-2 428}, :bufs {:b2 [430], :b1 [432 433], :b3 []}}, :line 838}
{:clk 785.381, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 432, :dets {:run {:m3-1 429, :m4 427, :m2 nil, :m1 434, :m3-2 428}, :bufs {:b2 [430 431], :b1 [432 433], :b3 []}}, :line 839}
{:clk 785.5128, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 434, :dets {:run {:m3-1 429, :m4 427, :m2 432, :m1 434, :m3-2 428}, :bufs {:b2 [430 431], :b1 [433], :b3 []}}, :line 840}
{:clk 785.5128, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 786.5128, :j 435, :dets {:run {:m3-1 429, :m4 427, :m2 432, :m1 nil, :m3-2 428}, :bufs {:b2 [430 431], :b1 [433 434], :b3 []}}, :line 841}
{:clk 785.7489, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 772.7805, :j 427, :dets {:run {:m3-1 429, :m4 427, :m2 432, :m1 435, :m3-2 428}, :bufs {:b2 [430 431], :b1 [433 434], :b3 []}}, :line 842}
{:clk 785.7489, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 429, :m4 nil, :m2 432, :m1 435, :m3-2 428}, :bufs {:b2 [430 431], :b1 [433 434], :b3 []}}, :line 843}
{:clk 786.381, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 429, :m4 nil, :m2 432, :m1 435, :m3-2 428}, :bufs {:b2 [430 431], :b1 [433 434], :b3 []}}, :line 844}
{:clk 786.5128, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 429, :m4 nil, :m2 432, :m1 435, :m3-2 428}, :bufs {:b2 [430 431], :b1 [433 434], :b3 []}}, :line 845}
{:clk 787.5489, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 429, :dets {:run {:m3-1 429, :m4 nil, :m2 432, :m1 435, :m3-2 428}, :bufs {:b2 [430 431], :b1 [433 434], :b3 []}}, :line 846}
{:clk 787.5489, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 430, :dets {:run {:m3-1 nil, :m4 nil, :m2 432, :m1 435, :m3-2 428}, :bufs {:b2 [430 431], :b1 [433 434], :b3 [429]}}, :line 847}
{:clk 787.5489, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 430, :m4 nil, :m2 432, :m1 435, :m3-2 428}, :bufs {:b2 [431], :b1 [433 434], :b3 [429]}}, :line 848}
{:clk 787.5489, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 429, :dets {:run {:m3-1 430, :m4 nil, :m2 432, :m1 435, :m3-2 428}, :bufs {:b2 [431], :b1 [433 434], :b3 [429]}}, :line 849}
{:clk 787.5489, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 430, :m4 429, :m2 432, :m1 435, :m3-2 428}, :bufs {:b2 [431], :b1 [433 434], :b3 []}}, :line 850}
{:clk 787.5489, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 432, :dets {:run {:m3-1 430, :m4 429, :m2 432, :m1 435, :m3-2 428}, :bufs {:b2 [431], :b1 [433 434], :b3 []}}, :line 851}
{:clk 787.5489, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 433, :dets {:run {:m3-1 430, :m4 429, :m2 nil, :m1 435, :m3-2 428}, :bufs {:b2 [431 432], :b1 [433 434], :b3 []}}, :line 852}
{:clk 787.5489, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 430, :m4 429, :m2 433, :m1 435, :m3-2 428}, :bufs {:b2 [431 432], :b1 [434], :b3 []}}, :line 853}
{:clk 787.5489, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 435, :dets {:run {:m3-1 430, :m4 429, :m2 433, :m1 435, :m3-2 428}, :bufs {:b2 [431 432], :b1 [434], :b3 []}}, :line 854}
{:clk 787.5489, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType2, :ends 788.5489, :j 436, :dets {:run {:m3-1 430, :m4 429, :m2 433, :m1 nil, :m3-2 428}, :bufs {:b2 [431 432], :b1 [434 435], :b3 []}}, :line 855}
{:clk 788.5489, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 430, :m4 429, :m2 433, :m1 436, :m3-2 428}, :bufs {:b2 [431 432], :b1 [434 435], :b3 []}}, :line 856}
{:clk 788.5489, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 430, :m4 429, :m2 433, :m1 436, :m3-2 428}, :bufs {:b2 [431 432], :b1 [434 435], :b3 []}}, :line 857}
{:clk 789.2458, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 428, :dets {:run {:m3-1 430, :m4 429, :m2 433, :m1 436, :m3-2 428}, :bufs {:b2 [431 432], :b1 [434 435], :b3 []}}, :line 858}
{:clk 789.2458, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 431, :dets {:run {:m3-1 430, :m4 429, :m2 433, :m1 436, :m3-2 nil}, :bufs {:b2 [431 432], :b1 [434 435], :b3 [428]}}, :line 859}
{:clk 789.2458, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 430, :m4 429, :m2 433, :m1 436, :m3-2 431}, :bufs {:b2 [432], :b1 [434 435], :b3 [428]}}, :line 860}
{:clk 789.2458, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 433, :dets {:run {:m3-1 430, :m4 429, :m2 433, :m1 436, :m3-2 431}, :bufs {:b2 [432], :b1 [434 435], :b3 [428]}}, :line 861}
{:clk 789.2458, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 434, :dets {:run {:m3-1 430, :m4 429, :m2 nil, :m1 436, :m3-2 431}, :bufs {:b2 [432 433], :b1 [434 435], :b3 [428]}}, :line 862}
{:clk 789.2458, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 430, :m4 429, :m2 434, :m1 436, :m3-2 431}, :bufs {:b2 [432 433], :b1 [435], :b3 [428]}}, :line 863}
{:clk 789.2458, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 436, :dets {:run {:m3-1 430, :m4 429, :m2 434, :m1 436, :m3-2 431}, :bufs {:b2 [432 433], :b1 [435], :b3 [428]}}, :line 864}
{:clk 789.2458, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType2, :ends 790.2458, :j 437, :dets {:run {:m3-1 430, :m4 429, :m2 434, :m1 nil, :m3-2 431}, :bufs {:b2 [432 433], :b1 [435 436], :b3 [428]}}, :line 865}
{:clk 790.2458, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 430, :m4 429, :m2 434, :m1 437, :m3-2 431}, :bufs {:b2 [432 433], :b1 [435 436], :b3 [428]}}, :line 866}
{:clk 790.2458, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 430, :m4 429, :m2 434, :m1 437, :m3-2 431}, :bufs {:b2 [432 433], :b1 [435 436], :b3 [428]}}, :line 867}
{:clk 790.5489, :act :m3-1-blocked, :m :m3-1, :mjpact :bl, :dets {:run {:m3-1 430, :m4 429, :m2 434, :m1 437, :m3-2 431}, :bufs {:b2 [432 433], :b1 [435 436], :b3 [428]}}, :line 868}
{:clk 790.9303, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 776.5293, :j 429, :dets {:run {:m3-1 430, :m4 429, :m2 434, :m1 437, :m3-2 431}, :bufs {:b2 [432 433], :b1 [435 436], :b3 [428]}}, :line 869}
{:clk 790.9303, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 428, :dets {:run {:m3-1 430, :m4 nil, :m2 434, :m1 437, :m3-2 431}, :bufs {:b2 [432 433], :b1 [435 436], :b3 [428]}}, :line 870}
{:clk 790.9303, :act :m3-1-unblocked, :m :m3-1, :mjpact :ub, :dets {:run {:m3-1 430, :m4 428, :m2 434, :m1 437, :m3-2 431}, :bufs {:b2 [432 433], :b1 [435 436], :b3 []}}, :line 871}
{:clk 790.9303, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 430, :dets {:run {:m3-1 430, :m4 428, :m2 434, :m1 437, :m3-2 431}, :bufs {:b2 [432 433], :b1 [435 436], :b3 []}}, :line 872}
{:clk 790.9303, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 432, :dets {:run {:m3-1 nil, :m4 428, :m2 434, :m1 437, :m3-2 431}, :bufs {:b2 [432 433], :b1 [435 436], :b3 [430]}}, :line 873}
{:clk 790.9303, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 432, :m4 428, :m2 434, :m1 437, :m3-2 431}, :bufs {:b2 [433], :b1 [435 436], :b3 [430]}}, :line 874}
{:clk 790.9303, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 434, :dets {:run {:m3-1 432, :m4 428, :m2 434, :m1 437, :m3-2 431}, :bufs {:b2 [433], :b1 [435 436], :b3 [430]}}, :line 875}
{:clk 790.9303, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 435, :dets {:run {:m3-1 432, :m4 428, :m2 nil, :m1 437, :m3-2 431}, :bufs {:b2 [433 434], :b1 [435 436], :b3 [430]}}, :line 876}
{:clk 790.9303, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 432, :m4 428, :m2 435, :m1 437, :m3-2 431}, :bufs {:b2 [433 434], :b1 [436], :b3 [430]}}, :line 877}
{:clk 790.9303, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 437, :dets {:run {:m3-1 432, :m4 428, :m2 435, :m1 437, :m3-2 431}, :bufs {:b2 [433 434], :b1 [436], :b3 [430]}}, :line 878}
{:clk 790.9303, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 791.9303, :j 438, :dets {:run {:m3-1 432, :m4 428, :m2 435, :m1 nil, :m3-2 431}, :bufs {:b2 [433 434], :b1 [436 437], :b3 [430]}}, :line 879}
{:clk 791.9303, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 775.5293, :j 428, :dets {:run {:m3-1 432, :m4 428, :m2 435, :m1 438, :m3-2 431}, :bufs {:b2 [433 434], :b1 [436 437], :b3 [430]}}, :line 880}
{:clk 791.9303, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 432, :m4 nil, :m2 435, :m1 438, :m3-2 431}, :bufs {:b2 [433 434], :b1 [436 437], :b3 [430]}}, :line 881}
{:clk 791.9303, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 432, :m4 nil, :m2 435, :m1 438, :m3-2 431}, :bufs {:b2 [433 434], :b1 [436 437], :b3 [430]}}, :line 882}
{:clk 791.9303, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 430, :dets {:run {:m3-1 432, :m4 nil, :m2 435, :m1 438, :m3-2 431}, :bufs {:b2 [433 434], :b1 [436 437], :b3 [430]}}, :line 883}
{:clk 792.2458, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 431, :dets {:run {:m3-1 432, :m4 430, :m2 435, :m1 438, :m3-2 431}, :bufs {:b2 [433 434], :b1 [436 437], :b3 []}}, :line 884}
{:clk 792.2458, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 433, :dets {:run {:m3-1 432, :m4 430, :m2 435, :m1 438, :m3-2 nil}, :bufs {:b2 [433 434], :b1 [436 437], :b3 [431]}}, :line 885}
{:clk 792.2458, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 432, :m4 430, :m2 435, :m1 438, :m3-2 433}, :bufs {:b2 [434], :b1 [436 437], :b3 [431]}}, :line 886}
{:clk 792.2458, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 435, :dets {:run {:m3-1 432, :m4 430, :m2 435, :m1 438, :m3-2 433}, :bufs {:b2 [434], :b1 [436 437], :b3 [431]}}, :line 887}
{:clk 792.2458, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 436, :dets {:run {:m3-1 432, :m4 430, :m2 nil, :m1 438, :m3-2 433}, :bufs {:b2 [434 435], :b1 [436 437], :b3 [431]}}, :line 888}
{:clk 792.2458, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 432, :m4 430, :m2 436, :m1 438, :m3-2 433}, :bufs {:b2 [434 435], :b1 [437], :b3 [431]}}, :line 889}
{:clk 792.2458, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 438, :dets {:run {:m3-1 432, :m4 430, :m2 436, :m1 438, :m3-2 433}, :bufs {:b2 [434 435], :b1 [437], :b3 [431]}}, :line 890}
{:clk 792.2458, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 793.2458, :j 439, :dets {:run {:m3-1 432, :m4 430, :m2 436, :m1 nil, :m3-2 433}, :bufs {:b2 [434 435], :b1 [437 438], :b3 [431]}}, :line 891}
{:clk 792.9303, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 777.5293, :j 430, :dets {:run {:m3-1 432, :m4 430, :m2 436, :m1 439, :m3-2 433}, :bufs {:b2 [434 435], :b1 [437 438], :b3 [431]}}, :line 892}
{:clk 792.9303, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 431, :dets {:run {:m3-1 432, :m4 nil, :m2 436, :m1 439, :m3-2 433}, :bufs {:b2 [434 435], :b1 [437 438], :b3 [431]}}, :line 893}
{:clk 793.2458, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 432, :m4 431, :m2 436, :m1 439, :m3-2 433}, :bufs {:b2 [434 435], :b1 [437 438], :b3 []}}, :line 894}
{:clk 793.2458, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 432, :m4 431, :m2 436, :m1 439, :m3-2 433}, :bufs {:b2 [434 435], :b1 [437 438], :b3 []}}, :line 895}
{:clk 793.9303, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 432, :dets {:run {:m3-1 432, :m4 431, :m2 436, :m1 439, :m3-2 433}, :bufs {:b2 [434 435], :b1 [437 438], :b3 []}}, :line 896}
{:clk 793.9303, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 778.5293, :j 431, :dets {:run {:m3-1 nil, :m4 431, :m2 436, :m1 439, :m3-2 433}, :bufs {:b2 [434 435], :b1 [437 438], :b3 [432]}}, :line 897}
{:clk 793.9303, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 432, :dets {:run {:m3-1 nil, :m4 nil, :m2 436, :m1 439, :m3-2 433}, :bufs {:b2 [434 435], :b1 [437 438], :b3 [432]}}, :line 898}
{:clk 793.9303, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 434, :dets {:run {:m3-1 nil, :m4 432, :m2 436, :m1 439, :m3-2 433}, :bufs {:b2 [434 435], :b1 [437 438], :b3 []}}, :line 899}
{:clk 793.9303, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 434, :m4 432, :m2 436, :m1 439, :m3-2 433}, :bufs {:b2 [435], :b1 [437 438], :b3 []}}, :line 900}
{:clk 793.9303, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 436, :dets {:run {:m3-1 434, :m4 432, :m2 436, :m1 439, :m3-2 433}, :bufs {:b2 [435], :b1 [437 438], :b3 []}}, :line 901}
{:clk 793.9303, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 437, :dets {:run {:m3-1 434, :m4 432, :m2 nil, :m1 439, :m3-2 433}, :bufs {:b2 [435 436], :b1 [437 438], :b3 []}}, :line 902}
{:clk 793.9303, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 434, :m4 432, :m2 437, :m1 439, :m3-2 433}, :bufs {:b2 [435 436], :b1 [438], :b3 []}}, :line 903}
{:clk 793.9303, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 439, :dets {:run {:m3-1 434, :m4 432, :m2 437, :m1 439, :m3-2 433}, :bufs {:b2 [435 436], :b1 [438], :b3 []}}, :line 904}
{:clk 793.9303, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 794.9303, :j 440, :dets {:run {:m3-1 434, :m4 432, :m2 437, :m1 nil, :m3-2 433}, :bufs {:b2 [435 436], :b1 [438 439], :b3 []}}, :line 905}
{:clk 794.9303, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 780.3281, :j 432, :dets {:run {:m3-1 434, :m4 432, :m2 437, :m1 440, :m3-2 433}, :bufs {:b2 [435 436], :b1 [438 439], :b3 []}}, :line 906}
{:clk 794.9303, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 434, :m4 nil, :m2 437, :m1 440, :m3-2 433}, :bufs {:b2 [435 436], :b1 [438 439], :b3 []}}, :line 907}
{:clk 794.9303, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 434, :m4 nil, :m2 437, :m1 440, :m3-2 433}, :bufs {:b2 [435 436], :b1 [438 439], :b3 []}}, :line 908}
{:clk 795.2458, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 433, :dets {:run {:m3-1 434, :m4 nil, :m2 437, :m1 440, :m3-2 433}, :bufs {:b2 [435 436], :b1 [438 439], :b3 []}}, :line 909}
{:clk 795.2458, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 435, :dets {:run {:m3-1 434, :m4 nil, :m2 437, :m1 440, :m3-2 nil}, :bufs {:b2 [435 436], :b1 [438 439], :b3 [433]}}, :line 910}
{:clk 795.2458, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 434, :m4 nil, :m2 437, :m1 440, :m3-2 435}, :bufs {:b2 [436], :b1 [438 439], :b3 [433]}}, :line 911}
{:clk 795.2458, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 433, :dets {:run {:m3-1 434, :m4 nil, :m2 437, :m1 440, :m3-2 435}, :bufs {:b2 [436], :b1 [438 439], :b3 [433]}}, :line 912}
{:clk 796.2458, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 781.3281, :j 433, :dets {:run {:m3-1 434, :m4 433, :m2 437, :m1 440, :m3-2 435}, :bufs {:b2 [436], :b1 [438 439], :b3 []}}, :line 913}
{:clk 796.2458, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 434, :m4 nil, :m2 437, :m1 440, :m3-2 435}, :bufs {:b2 [436], :b1 [438 439], :b3 []}}, :line 914}
{:clk 796.3442, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 437, :dets {:run {:m3-1 434, :m4 nil, :m2 437, :m1 440, :m3-2 435}, :bufs {:b2 [436], :b1 [438 439], :b3 []}}, :line 915}
{:clk 796.3442, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 438, :dets {:run {:m3-1 434, :m4 nil, :m2 nil, :m1 440, :m3-2 435}, :bufs {:b2 [436 437], :b1 [438 439], :b3 []}}, :line 916}
{:clk 796.3442, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 434, :m4 nil, :m2 438, :m1 440, :m3-2 435}, :bufs {:b2 [436 437], :b1 [439], :b3 []}}, :line 917}
{:clk 796.3442, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 440, :dets {:run {:m3-1 434, :m4 nil, :m2 438, :m1 440, :m3-2 435}, :bufs {:b2 [436 437], :b1 [439], :b3 []}}, :line 918}
{:clk 796.9303, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 434, :dets {:run {:m3-1 434, :m4 nil, :m2 438, :m1 nil, :m3-2 435}, :bufs {:b2 [436 437], :b1 [439 440], :b3 []}}, :line 919}
{:clk 796.9303, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 436, :dets {:run {:m3-1 nil, :m4 nil, :m2 438, :m1 nil, :m3-2 435}, :bufs {:b2 [436 437], :b1 [439 440], :b3 [434]}}, :line 920}
{:clk 796.9303, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 436, :m4 nil, :m2 438, :m1 nil, :m3-2 435}, :bufs {:b2 [437], :b1 [439 440], :b3 [434]}}, :line 921}
{:clk 796.9303, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 434, :dets {:run {:m3-1 436, :m4 nil, :m2 438, :m1 nil, :m3-2 435}, :bufs {:b2 [437], :b1 [439 440], :b3 [434]}}, :line 922}
{:clk 797.0186, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 798.0186, :j 441, :dets {:run {:m3-1 436, :m4 434, :m2 438, :m1 nil, :m3-2 435}, :bufs {:b2 [437], :b1 [439 440], :b3 []}}, :line 923}
{:clk 797.3442, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 438, :dets {:run {:m3-1 436, :m4 434, :m2 438, :m1 441, :m3-2 435}, :bufs {:b2 [437], :b1 [439 440], :b3 []}}, :line 924}
{:clk 797.3442, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 439, :dets {:run {:m3-1 436, :m4 434, :m2 nil, :m1 441, :m3-2 435}, :bufs {:b2 [437 438], :b1 [439 440], :b3 []}}, :line 925}
{:clk 797.9303, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 784.5128, :j 434, :dets {:run {:m3-1 436, :m4 434, :m2 439, :m1 441, :m3-2 435}, :bufs {:b2 [437 438], :b1 [440], :b3 []}}, :line 926}
{:clk 797.9303, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 436, :m4 nil, :m2 439, :m1 441, :m3-2 435}, :bufs {:b2 [437 438], :b1 [440], :b3 []}}, :line 927}
{:clk 798.0186, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 441, :dets {:run {:m3-1 436, :m4 nil, :m2 439, :m1 441, :m3-2 435}, :bufs {:b2 [437 438], :b1 [440], :b3 []}}, :line 928}
{:clk 798.0186, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 799.0186, :j 442, :dets {:run {:m3-1 436, :m4 nil, :m2 439, :m1 nil, :m3-2 435}, :bufs {:b2 [437 438], :b1 [440 441], :b3 []}}, :line 929}
{:clk 798.2458, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 435, :dets {:run {:m3-1 436, :m4 nil, :m2 439, :m1 442, :m3-2 435}, :bufs {:b2 [437 438], :b1 [440 441], :b3 []}}, :line 930}
{:clk 798.2458, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 437, :dets {:run {:m3-1 436, :m4 nil, :m2 439, :m1 442, :m3-2 nil}, :bufs {:b2 [437 438], :b1 [440 441], :b3 [435]}}, :line 931}
{:clk 798.2458, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 436, :m4 nil, :m2 439, :m1 442, :m3-2 437}, :bufs {:b2 [438], :b1 [440 441], :b3 [435]}}, :line 932}
{:clk 798.2458, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 435, :dets {:run {:m3-1 436, :m4 nil, :m2 439, :m1 442, :m3-2 437}, :bufs {:b2 [438], :b1 [440 441], :b3 [435]}}, :line 933}
{:clk 798.3442, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 439, :dets {:run {:m3-1 436, :m4 435, :m2 439, :m1 442, :m3-2 437}, :bufs {:b2 [438], :b1 [440 441], :b3 []}}, :line 934}
{:clk 798.3442, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 440, :dets {:run {:m3-1 436, :m4 435, :m2 nil, :m1 442, :m3-2 437}, :bufs {:b2 [438 439], :b1 [440 441], :b3 []}}, :line 935}
{:clk 799.0186, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 442, :dets {:run {:m3-1 436, :m4 435, :m2 440, :m1 442, :m3-2 437}, :bufs {:b2 [438 439], :b1 [441], :b3 []}}, :line 936}
{:clk 799.0186, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 800.0186, :j 443, :dets {:run {:m3-1 436, :m4 435, :m2 440, :m1 nil, :m3-2 437}, :bufs {:b2 [438 439], :b1 [441 442], :b3 []}}, :line 937}
{:clk 799.2458, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 785.5128, :j 435, :dets {:run {:m3-1 436, :m4 435, :m2 440, :m1 443, :m3-2 437}, :bufs {:b2 [438 439], :b1 [441 442], :b3 []}}, :line 938}
{:clk 799.2458, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 436, :m4 nil, :m2 440, :m1 443, :m3-2 437}, :bufs {:b2 [438 439], :b1 [441 442], :b3 []}}, :line 939}
{:clk 800.0186, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 436, :m4 nil, :m2 440, :m1 443, :m3-2 437}, :bufs {:b2 [438 439], :b1 [441 442], :b3 []}}, :line 940}
{:clk 800.5303, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 436, :dets {:run {:m3-1 436, :m4 nil, :m2 440, :m1 443, :m3-2 437}, :bufs {:b2 [438 439], :b1 [441 442], :b3 []}}, :line 941}
{:clk 800.5303, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 438, :dets {:run {:m3-1 nil, :m4 nil, :m2 440, :m1 443, :m3-2 437}, :bufs {:b2 [438 439], :b1 [441 442], :b3 [436]}}, :line 942}
{:clk 800.5303, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 438, :m4 nil, :m2 440, :m1 443, :m3-2 437}, :bufs {:b2 [439], :b1 [441 442], :b3 [436]}}, :line 943}
{:clk 800.5303, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 436, :dets {:run {:m3-1 438, :m4 nil, :m2 440, :m1 443, :m3-2 437}, :bufs {:b2 [439], :b1 [441 442], :b3 [436]}}, :line 944}
{:clk 801.7303, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 787.5489, :j 436, :dets {:run {:m3-1 438, :m4 436, :m2 440, :m1 443, :m3-2 437}, :bufs {:b2 [439], :b1 [441 442], :b3 []}}, :line 945}
{:clk 801.7303, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 438, :m4 nil, :m2 440, :m1 443, :m3-2 437}, :bufs {:b2 [439], :b1 [441 442], :b3 []}}, :line 946}
{:clk 801.8458, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 437, :dets {:run {:m3-1 438, :m4 nil, :m2 440, :m1 443, :m3-2 437}, :bufs {:b2 [439], :b1 [441 442], :b3 []}}, :line 947}
{:clk 801.8458, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 1, :j 439, :dets {:run {:m3-1 438, :m4 nil, :m2 440, :m1 443, :m3-2 nil}, :bufs {:b2 [439], :b1 [441 442], :b3 [437]}}, :line 948}
{:clk 801.8458, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 438, :m4 nil, :m2 440, :m1 443, :m3-2 439}, :bufs {:b2 [], :b1 [441 442], :b3 [437]}}, :line 949}
{:clk 801.8458, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 437, :dets {:run {:m3-1 438, :m4 nil, :m2 440, :m1 443, :m3-2 439}, :bufs {:b2 [], :b1 [441 442], :b3 [437]}}, :line 950}
{:clk 802.2927, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 0, :j 440, :dets {:run {:m3-1 438, :m4 437, :m2 440, :m1 443, :m3-2 439}, :bufs {:b2 [], :b1 [441 442], :b3 []}}, :line 951}
{:clk 802.2927, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 441, :dets {:run {:m3-1 438, :m4 437, :m2 nil, :m1 443, :m3-2 439}, :bufs {:b2 [440], :b1 [441 442], :b3 []}}, :line 952}
{:clk 802.2927, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 438, :m4 437, :m2 441, :m1 443, :m3-2 439}, :bufs {:b2 [440], :b1 [442], :b3 []}}, :line 953}
{:clk 802.2927, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 443, :dets {:run {:m3-1 438, :m4 437, :m2 441, :m1 443, :m3-2 439}, :bufs {:b2 [440], :b1 [442], :b3 []}}, :line 954}
{:clk 802.2927, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType2, :ends 803.2927, :j 444, :dets {:run {:m3-1 438, :m4 437, :m2 441, :m1 nil, :m3-2 439}, :bufs {:b2 [440], :b1 [442 443], :b3 []}}, :line 955}
{:clk 803.0458, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 789.2458, :j 437, :dets {:run {:m3-1 438, :m4 437, :m2 441, :m1 444, :m3-2 439}, :bufs {:b2 [440], :b1 [442 443], :b3 []}}, :line 956}
{:clk 803.0458, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 438, :m4 nil, :m2 441, :m1 444, :m3-2 439}, :bufs {:b2 [440], :b1 [442 443], :b3 []}}, :line 957}
{:clk 803.2927, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 441, :dets {:run {:m3-1 438, :m4 nil, :m2 441, :m1 444, :m3-2 439}, :bufs {:b2 [440], :b1 [442 443], :b3 []}}, :line 958}
{:clk 803.2927, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 442, :dets {:run {:m3-1 438, :m4 nil, :m2 nil, :m1 444, :m3-2 439}, :bufs {:b2 [440 441], :b1 [442 443], :b3 []}}, :line 959}
{:clk 803.2927, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 444, :dets {:run {:m3-1 438, :m4 nil, :m2 442, :m1 444, :m3-2 439}, :bufs {:b2 [440 441], :b1 [443], :b3 []}}, :line 960}
{:clk 803.2927, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 804.2927, :j 445, :dets {:run {:m3-1 438, :m4 nil, :m2 442, :m1 nil, :m3-2 439}, :bufs {:b2 [440 441], :b1 [443 444], :b3 []}}, :line 961}
{:clk 803.5303, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 438, :dets {:run {:m3-1 438, :m4 nil, :m2 442, :m1 445, :m3-2 439}, :bufs {:b2 [440 441], :b1 [443 444], :b3 []}}, :line 962}
{:clk 803.5303, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 440, :dets {:run {:m3-1 nil, :m4 nil, :m2 442, :m1 445, :m3-2 439}, :bufs {:b2 [440 441], :b1 [443 444], :b3 [438]}}, :line 963}
{:clk 803.5303, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 440, :m4 nil, :m2 442, :m1 445, :m3-2 439}, :bufs {:b2 [441], :b1 [443 444], :b3 [438]}}, :line 964}
{:clk 803.5303, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 438, :dets {:run {:m3-1 440, :m4 nil, :m2 442, :m1 445, :m3-2 439}, :bufs {:b2 [441], :b1 [443 444], :b3 [438]}}, :line 965}
{:clk 804.2927, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 442, :dets {:run {:m3-1 440, :m4 438, :m2 442, :m1 445, :m3-2 439}, :bufs {:b2 [441], :b1 [443 444], :b3 []}}, :line 966}
{:clk 804.2927, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 443, :dets {:run {:m3-1 440, :m4 438, :m2 nil, :m1 445, :m3-2 439}, :bufs {:b2 [441 442], :b1 [443 444], :b3 []}}, :line 967}
{:clk 804.2927, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 445, :dets {:run {:m3-1 440, :m4 438, :m2 443, :m1 445, :m3-2 439}, :bufs {:b2 [441 442], :b1 [444], :b3 []}}, :line 968}
{:clk 804.2927, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 805.2927, :j 446, :dets {:run {:m3-1 440, :m4 438, :m2 443, :m1 nil, :m3-2 439}, :bufs {:b2 [441 442], :b1 [444 445], :b3 []}}, :line 969}
{:clk 804.5303, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 790.9303, :j 438, :dets {:run {:m3-1 440, :m4 438, :m2 443, :m1 446, :m3-2 439}, :bufs {:b2 [441 442], :b1 [444 445], :b3 []}}, :line 970}
{:clk 804.5303, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 440, :m4 nil, :m2 443, :m1 446, :m3-2 439}, :bufs {:b2 [441 442], :b1 [444 445], :b3 []}}, :line 971}
{:clk 804.8458, :act :m3-2-complete-job, :m :m3-2, :mjpact :bj, :bf :b3, :n 0, :j 439, :dets {:run {:m3-1 440, :m4 nil, :m2 443, :m1 446, :m3-2 439}, :bufs {:b2 [441 442], :b1 [444 445], :b3 []}}, :line 972}
{:clk 804.8458, :act :m3-2-start-job, :m :m3-2, :mjpact :sm, :bf :b2, :n 2, :j 441, :dets {:run {:m3-1 440, :m4 nil, :m2 443, :m1 446, :m3-2 nil}, :bufs {:b2 [441 442], :b1 [444 445], :b3 [439]}}, :line 973}
{:clk 804.8458, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 440, :m4 nil, :m2 443, :m1 446, :m3-2 441}, :bufs {:b2 [442], :b1 [444 445], :b3 [439]}}, :line 974}
{:clk 804.8458, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 439, :dets {:run {:m3-1 440, :m4 nil, :m2 443, :m1 446, :m3-2 441}, :bufs {:b2 [442], :b1 [444 445], :b3 [439]}}, :line 975}
{:clk 805.2927, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 443, :dets {:run {:m3-1 440, :m4 439, :m2 443, :m1 446, :m3-2 441}, :bufs {:b2 [442], :b1 [444 445], :b3 []}}, :line 976}
{:clk 805.2927, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 444, :dets {:run {:m3-1 440, :m4 439, :m2 nil, :m1 446, :m3-2 441}, :bufs {:b2 [442 443], :b1 [444 445], :b3 []}}, :line 977}
{:clk 805.2927, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 446, :dets {:run {:m3-1 440, :m4 439, :m2 444, :m1 446, :m3-2 441}, :bufs {:b2 [442 443], :b1 [445], :b3 []}}, :line 978}
{:clk 805.2927, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 806.2927, :j 447, :dets {:run {:m3-1 440, :m4 439, :m2 444, :m1 nil, :m3-2 441}, :bufs {:b2 [442 443], :b1 [445 446], :b3 []}}, :line 979}
{:clk 805.8458, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 792.2458, :j 439, :dets {:run {:m3-1 440, :m4 439, :m2 444, :m1 447, :m3-2 441}, :bufs {:b2 [442 443], :b1 [445 446], :b3 []}}, :line 980}
{:clk 805.8458, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 440, :m4 nil, :m2 444, :m1 447, :m3-2 441}, :bufs {:b2 [442 443], :b1 [445 446], :b3 []}}, :line 981}
{:clk 806.2927, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 440, :m4 nil, :m2 444, :m1 447, :m3-2 441}, :bufs {:b2 [442 443], :b1 [445 446], :b3 []}}, :line 982}
{:clk 806.2927, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 440, :m4 nil, :m2 444, :m1 447, :m3-2 441}, :bufs {:b2 [442 443], :b1 [445 446], :b3 []}}, :line 983}
{:clk 806.5303, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 440, :dets {:run {:m3-1 440, :m4 nil, :m2 444, :m1 447, :m3-2 441}, :bufs {:b2 [442 443], :b1 [445 446], :b3 []}}, :line 984}
{:clk 806.5303, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 442, :dets {:run {:m3-1 nil, :m4 nil, :m2 444, :m1 447, :m3-2 441}, :bufs {:b2 [442 443], :b1 [445 446], :b3 [440]}}, :line 985}
{:clk 806.5303, :act :m4-unstarved, :m :m4, :mjpact :us, :dets {:run {:m3-1 442, :m4 nil, :m2 444, :m1 447, :m3-2 441}, :bufs {:b2 [443], :b1 [445 446], :b3 [440]}}, :line 986}
{:clk 806.5303, :act :m4-start-job, :m :m4, :mjpact :sm, :bf :b3, :n 1, :j 440, :dets {:run {:m3-1 442, :m4 nil, :m2 444, :m1 447, :m3-2 441}, :bufs {:b2 [443], :b1 [445 446], :b3 [440]}}, :line 987}
{:clk 806.5303, :act :m2-unblocked, :m :m2, :mjpact :ub, :dets {:run {:m3-1 442, :m4 440, :m2 444, :m1 447, :m3-2 441}, :bufs {:b2 [443], :b1 [445 446], :b3 []}}, :line 988}
{:clk 806.5303, :act :m2-complete-job, :m :m2, :mjpact :bj, :bf :b2, :n 1, :j 444, :dets {:run {:m3-1 442, :m4 440, :m2 444, :m1 447, :m3-2 441}, :bufs {:b2 [443], :b1 [445 446], :b3 []}}, :line 989}
{:clk 806.5303, :act :m2-start-job, :m :m2, :mjpact :sm, :bf :b1, :n 2, :j 445, :dets {:run {:m3-1 442, :m4 440, :m2 nil, :m1 447, :m3-2 441}, :bufs {:b2 [443 444], :b1 [445 446], :b3 []}}, :line 990}
{:clk 806.5303, :act :m1-unblocked, :m :m1, :mjpact :ub, :dets {:run {:m3-1 442, :m4 440, :m2 445, :m1 447, :m3-2 441}, :bufs {:b2 [443 444], :b1 [446], :b3 []}}, :line 991}
{:clk 806.5303, :act :m1-complete-job, :m :m1, :mjpact :bj, :bf :b1, :n 1, :j 447, :dets {:run {:m3-1 442, :m4 440, :m2 445, :m1 447, :m3-2 441}, :bufs {:b2 [443 444], :b1 [446], :b3 []}}, :line 992}
{:clk 806.5303, :act :m1-start-job, :m :m1, :mjpact :aj, :jt :jobType1, :ends 807.5303, :j 448, :dets {:run {:m3-1 442, :m4 440, :m2 445, :m1 nil, :m3-2 441}, :bufs {:b2 [443 444], :b1 [446 447], :b3 []}}, :line 993}
{:clk 807.5303, :act :m4-complete-job, :m :m4, :mjpact :ej, :ent 793.9303, :j 440, :dets {:run {:m3-1 442, :m4 440, :m2 445, :m1 448, :m3-2 441}, :bufs {:b2 [443 444], :b1 [446 447], :b3 []}}, :line 994}
{:clk 807.5303, :act :m2-blocked, :m :m2, :mjpact :bl, :dets {:run {:m3-1 442, :m4 nil, :m2 445, :m1 448, :m3-2 441}, :bufs {:b2 [443 444], :b1 [446 447], :b3 []}}, :line 995}
{:clk 807.5303, :act :m1-blocked, :m :m1, :mjpact :bl, :dets {:run {:m3-1 442, :m4 nil, :m2 445, :m1 448, :m3-2 441}, :bufs {:b2 [443 444], :b1 [446 447], :b3 []}}, :line 996}
{:clk 807.5303, :act :m4-starved, :m :m4, :mjpact :st, :dets {:run {:m3-1 442, :m4 nil, :m2 445, :m1 448, :m3-2 441}, :bufs {:b2 [443 444], :b1 [446 447], :b3 []}}, :line 997}
{:clk 809.5303, :act :m3-1-complete-job, :m :m3-1, :mjpact :bj, :bf :b3, :n 0, :j 442, :dets {:run {:m3-1 442, :m4 nil, :m2 445, :m1 448, :m3-2 441}, :bufs {:b2 [443 444], :b1 [446 447], :b3 []}}, :line 998}
{:clk 809.5303, :act :m3-1-start-job, :m :m3-1, :mjpact :sm, :bf :b2, :n 2, :j 443, :dets {:run {:m3-1 nil, :m4 nil, :m2 445, :m1 448, :m3-2 441}, :bufs {:b2 [443 444], :b1 [446 447], :b3 [442]}}, :line 999}

