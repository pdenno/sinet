#_{:line
 {:m1 {:lambda 0.1, :mu 0.9, :W 1.0},
  :b1 {:N 2},
  :m2 {:lambda 0.1, :mu 0.9, :W 1.0},
  :b2 {:N 2},
  :m3 {:lambda 0.1, :mu 0.9, :W 1.0}},
 :entry-point :m1,
 :jobmix
 {:jobType1 {:w {:m1 1.0, :m2 1.0, :m3 1.0}, :portion 0.5},
  :jobType2 {:w {:m1 1.5, :m2 1.5, :m3 1.5}, :portion 0.5}},
 :params {:warm-up-time 2000, :run-to-time 10000},
 :topology [:m1 :b1 :m2 :b2 :m3],
 :print nil,
 :number-of-simulations 1,
 :report {:log? true, :max-lines 3000}}

{:clk 1999.8745 :act :m3-complete-job :m :m3 :mjpact :ej :ent 1990.8793 :j 1307 :dets {:run {:m1 1313, :m2 1310, :m3 1307}, :bufs {:b1 [1311 1312], :b2 [1308 1309]}} :line 0}
{:clk 1999.8745 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1308 :dets {:run {:m1 1313, :m2 1310, :m3 nil}, :bufs {:b1 [1311 1312], :b2 [1308 1309]}} :line 1}
{:clk 2000.8233 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1313, :m2 1310, :m3 1308}, :bufs {:b1 [1311 1312], :b2 [1309]}} :line 2}
{:clk 2001.3233 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1310 :dets {:run {:m1 1313, :m2 1310, :m3 1308}, :bufs {:b1 [1311 1312], :b2 [1309]}} :line 3}
{:clk 2001.3233 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1311 :dets {:run {:m1 1313, :m2 nil, :m3 1308}, :bufs {:b1 [1311 1312], :b2 [1309 1310]}} :line 4}
{:clk 2001.3233 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1311, :m3 1308}, :bufs {:b1 [1312 1313], :b2 [1309 1310]}} :line 5}
{:clk 2001.3233 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1313 :dets {:run {:m1 1313, :m2 1311, :m3 1308}, :bufs {:b1 [1312], :b2 [1309 1310]}} :line 6}
{:clk 2001.3233 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2002.8233 :j 1314 :dets {:run {:m1 nil, :m2 1311, :m3 1308}, :bufs {:b1 [1312 1313], :b2 [1309 1310]}} :line 7}
{:clk 2001.3745 :act :m3-complete-job :m :m3 :mjpact :ej :ent 1992.2235 :j 1308 :dets {:run {:m1 1314, :m2 1311, :m3 1308}, :bufs {:b1 [1312 1313], :b2 [1309 1310]}} :line 8}
{:clk 2001.3745 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1309 :dets {:run {:m1 1314, :m2 1311, :m3 nil}, :bufs {:b1 [1312 1313], :b2 [1309 1310]}} :line 9}
{:clk 2002.3233 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1311 :dets {:run {:m1 1314, :m2 1311, :m3 1309}, :bufs {:b1 [1312 1313], :b2 [1310]}} :line 10}
{:clk 2002.3233 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1312 :dets {:run {:m1 1314, :m2 nil, :m3 1309}, :bufs {:b1 [1312 1313], :b2 [1310 1311]}} :line 11}
{:clk 2002.3745 :act :m3-complete-job :m :m3 :mjpact :ej :ent 1993.7235 :j 1309 :dets {:run {:m1 1314, :m2 1312, :m3 1309}, :bufs {:b1 [1313], :b2 [1310 1311]}} :line 12}
{:clk 2002.3745 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1310 :dets {:run {:m1 1314, :m2 1312, :m3 nil}, :bufs {:b1 [1313], :b2 [1310 1311]}} :line 13}
{:clk 2002.8233 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1314 :dets {:run {:m1 1314, :m2 1312, :m3 1310}, :bufs {:b1 [1313], :b2 [1311]}} :line 14}
{:clk 2002.8233 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2003.8233 :j 1315 :dets {:run {:m1 nil, :m2 1312, :m3 1310}, :bufs {:b1 [1313 1314], :b2 [1311]}} :line 15}
{:clk 2003.3233 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1312 :dets {:run {:m1 1315, :m2 1312, :m3 1310}, :bufs {:b1 [1313 1314], :b2 [1311]}} :line 16}
{:clk 2003.3233 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1313 :dets {:run {:m1 1315, :m2 nil, :m3 1310}, :bufs {:b1 [1313 1314], :b2 [1311 1312]}} :line 17}
{:clk 2003.8233 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1315 :dets {:run {:m1 1315, :m2 1313, :m3 1310}, :bufs {:b1 [1314], :b2 [1311 1312]}} :line 18}
{:clk 2003.8233 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2005.3233 :j 1316 :dets {:run {:m1 nil, :m2 1313, :m3 1310}, :bufs {:b1 [1314 1315], :b2 [1311 1312]}} :line 19}
{:clk 2003.8745 :act :m3-complete-job :m :m3 :mjpact :ej :ent 1994.7235 :j 1310 :dets {:run {:m1 1316, :m2 1313, :m3 1310}, :bufs {:b1 [1314 1315], :b2 [1311 1312]}} :line 20}
{:clk 2003.8745 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1311 :dets {:run {:m1 1316, :m2 1313, :m3 nil}, :bufs {:b1 [1314 1315], :b2 [1311 1312]}} :line 21}
{:clk 2004.3233 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1313 :dets {:run {:m1 1316, :m2 1313, :m3 1311}, :bufs {:b1 [1314 1315], :b2 [1312]}} :line 22}
{:clk 2004.3233 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1314 :dets {:run {:m1 1316, :m2 nil, :m3 1311}, :bufs {:b1 [1314 1315], :b2 [1312 1313]}} :line 23}
{:clk 2004.8745 :act :m3-complete-job :m :m3 :mjpact :ej :ent 1997.3233 :j 1311 :dets {:run {:m1 1316, :m2 1314, :m3 1311}, :bufs {:b1 [1315], :b2 [1312 1313]}} :line 24}
{:clk 2004.8745 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1312 :dets {:run {:m1 1316, :m2 1314, :m3 nil}, :bufs {:b1 [1315], :b2 [1312 1313]}} :line 25}
{:clk 2005.3233 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1316 :dets {:run {:m1 1316, :m2 1314, :m3 1312}, :bufs {:b1 [1315], :b2 [1313]}} :line 26}
{:clk 2005.3233 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2006.8233 :j 1317 :dets {:run {:m1 nil, :m2 1314, :m3 1312}, :bufs {:b1 [1315 1316], :b2 [1313]}} :line 27}
{:clk 2005.8233 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1314 :dets {:run {:m1 1317, :m2 1314, :m3 1312}, :bufs {:b1 [1315 1316], :b2 [1313]}} :line 28}
{:clk 2005.8233 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1315 :dets {:run {:m1 1317, :m2 nil, :m3 1312}, :bufs {:b1 [1315 1316], :b2 [1313 1314]}} :line 29}
{:clk 2005.8745 :act :m3-complete-job :m :m3 :mjpact :ej :ent 1998.8233 :j 1312 :dets {:run {:m1 1317, :m2 1315, :m3 1312}, :bufs {:b1 [1316], :b2 [1313 1314]}} :line 30}
{:clk 2005.8745 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1313 :dets {:run {:m1 1317, :m2 1315, :m3 nil}, :bufs {:b1 [1316], :b2 [1313 1314]}} :line 31}
{:clk 2006.8233 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1317 :dets {:run {:m1 1317, :m2 1315, :m3 1313}, :bufs {:b1 [1316], :b2 [1314]}} :line 32}
{:clk 2006.8233 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2008.3233 :j 1318 :dets {:run {:m1 nil, :m2 nil, :m3 1313}, :bufs {:b1 [1316 1317], :b2 [1314 1315]}} :line 33}
{:clk 2006.8233 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1315 :dets {:run {:m1 nil, :m2 1315, :m3 1313}, :bufs {:b1 [1316 1317], :b2 [1314]}} :line 34}
{:clk 2006.8233 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1316 :dets {:run {:m1 1318, :m2 nil, :m3 1313}, :bufs {:b1 [1316 1317], :b2 [1314 1315]}} :line 35}
{:clk 2006.8745 :act :m3-complete-job :m :m3 :mjpact :ej :ent 1999.8233 :j 1313 :dets {:run {:m1 1318, :m2 1316, :m3 1313}, :bufs {:b1 [1317], :b2 [1314 1315]}} :line 36}
{:clk 2006.8745 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1314 :dets {:run {:m1 1318, :m2 1316, :m3 nil}, :bufs {:b1 [1317], :b2 [1314 1315]}} :line 37}
{:clk 2008.3233 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1318 :dets {:run {:m1 1318, :m2 1316, :m3 1314}, :bufs {:b1 [1317], :b2 [1315]}} :line 38}
{:clk 2008.3233 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2009.8233 :j 1319 :dets {:run {:m1 nil, :m2 nil, :m3 1314}, :bufs {:b1 [1317 1318], :b2 [1315 1316]}} :line 39}
{:clk 2008.3233 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1316 :dets {:run {:m1 nil, :m2 1316, :m3 1314}, :bufs {:b1 [1317 1318], :b2 [1315]}} :line 40}
{:clk 2008.3233 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1317 :dets {:run {:m1 1319, :m2 nil, :m3 1314}, :bufs {:b1 [1317 1318], :b2 [1315 1316]}} :line 41}
{:clk 2008.3745 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2001.3233 :j 1314 :dets {:run {:m1 1319, :m2 1317, :m3 1314}, :bufs {:b1 [1318], :b2 [1315 1316]}} :line 42}
{:clk 2008.3745 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1315 :dets {:run {:m1 1319, :m2 1317, :m3 nil}, :bufs {:b1 [1318], :b2 [1315 1316]}} :line 43}
{:clk 2009.8233 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1319 :dets {:run {:m1 1319, :m2 1317, :m3 1315}, :bufs {:b1 [1318], :b2 [1316]}} :line 44}
{:clk 2009.8233 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2011.3233 :j 1320 :dets {:run {:m1 nil, :m2 1317, :m3 1315}, :bufs {:b1 [1318 1319], :b2 [1316]}} :line 45}
{:clk 2011.3233 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1320, :m2 1317, :m3 1315}, :bufs {:b1 [1318 1319], :b2 [1316]}} :line 46}
{:clk 2012.0242 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1317 :dets {:run {:m1 1320, :m2 1317, :m3 1315}, :bufs {:b1 [1318 1319], :b2 [1316]}} :line 47}
{:clk 2012.0242 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1318 :dets {:run {:m1 1320, :m2 nil, :m3 1315}, :bufs {:b1 [1318 1319], :b2 [1316 1317]}} :line 48}
{:clk 2012.0242 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1318, :m3 1315}, :bufs {:b1 [1319 1320], :b2 [1316 1317]}} :line 49}
{:clk 2012.0242 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1320 :dets {:run {:m1 1320, :m2 1318, :m3 1315}, :bufs {:b1 [1319], :b2 [1316 1317]}} :line 50}
{:clk 2012.0242 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2013.0242 :j 1321 :dets {:run {:m1 nil, :m2 1318, :m3 1315}, :bufs {:b1 [1319 1320], :b2 [1316 1317]}} :line 51}
{:clk 2012.3460 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2002.8233 :j 1315 :dets {:run {:m1 1321, :m2 1318, :m3 1315}, :bufs {:b1 [1319 1320], :b2 [1316 1317]}} :line 52}
{:clk 2012.3460 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1316 :dets {:run {:m1 1321, :m2 1318, :m3 nil}, :bufs {:b1 [1319 1320], :b2 [1316 1317]}} :line 53}
{:clk 2013.0242 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1321, :m2 1318, :m3 1316}, :bufs {:b1 [1319 1320], :b2 [1317]}} :line 54}
{:clk 2013.8460 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2003.8233 :j 1316 :dets {:run {:m1 1321, :m2 1318, :m3 1316}, :bufs {:b1 [1319 1320], :b2 [1317]}} :line 55}
{:clk 2013.8460 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1317 :dets {:run {:m1 1321, :m2 1318, :m3 nil}, :bufs {:b1 [1319 1320], :b2 [1317]}} :line 56}
{:clk 2015.3460 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2005.3233 :j 1317 :dets {:run {:m1 1321, :m2 1318, :m3 1317}, :bufs {:b1 [1319 1320], :b2 []}} :line 57}
{:clk 2015.3460 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1321, :m2 1318, :m3 nil}, :bufs {:b1 [1319 1320], :b2 []}} :line 58}
{:clk 2016.2446 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1318 :dets {:run {:m1 1321, :m2 1318, :m3 nil}, :bufs {:b1 [1319 1320], :b2 []}} :line 59}
{:clk 2016.2446 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1319 :dets {:run {:m1 1321, :m2 nil, :m3 nil}, :bufs {:b1 [1319 1320], :b2 [1318]}} :line 60}
{:clk 2016.2446 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1321, :m2 1319, :m3 nil}, :bufs {:b1 [1320], :b2 [1318]}} :line 61}
{:clk 2016.2446 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1319, :m3 nil}, :bufs {:b1 [1320 1321], :b2 [1318]}} :line 62}
{:clk 2016.2446 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1321 :dets {:run {:m1 1321, :m2 1319, :m3 nil}, :bufs {:b1 [1320], :b2 [1318]}} :line 63}
{:clk 2016.2446 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2017.7446 :j 1322 :dets {:run {:m1 nil, :m2 1319, :m3 nil}, :bufs {:b1 [1320 1321], :b2 [1318]}} :line 64}
{:clk 2016.9388 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1318 :dets {:run {:m1 1322, :m2 1319, :m3 nil}, :bufs {:b1 [1320 1321], :b2 [1318]}} :line 65}
{:clk 2017.7446 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1322 :dets {:run {:m1 1322, :m2 1320, :m3 1318}, :bufs {:b1 [1321], :b2 [1319]}} :line 66}
{:clk 2017.7446 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2021.3328 :j 1323 :dets {:run {:m1 nil, :m2 1320, :m3 1318}, :bufs {:b1 [1321 1322], :b2 [1319]}} :line 67}
{:clk 2017.7446 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1319 :dets {:run {:m1 1322, :m2 1319, :m3 1318}, :bufs {:b1 [1320 1321], :b2 []}} :line 68}
{:clk 2017.7446 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1320 :dets {:run {:m1 1322, :m2 nil, :m3 1318}, :bufs {:b1 [1320 1321], :b2 [1319]}} :line 69}
{:clk 2018.4388 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2006.8233 :j 1318 :dets {:run {:m1 1323, :m2 1320, :m3 1318}, :bufs {:b1 [1321 1322], :b2 [1319]}} :line 70}
{:clk 2018.4388 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1319 :dets {:run {:m1 1323, :m2 1320, :m3 nil}, :bufs {:b1 [1321 1322], :b2 [1319]}} :line 71}
{:clk 2019.9388 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2008.3233 :j 1319 :dets {:run {:m1 1323, :m2 1320, :m3 1319}, :bufs {:b1 [1321 1322], :b2 []}} :line 72}
{:clk 2019.9388 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1323, :m2 1320, :m3 nil}, :bufs {:b1 [1321 1322], :b2 []}} :line 73}
{:clk 2021.0157 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1320 :dets {:run {:m1 1323, :m2 1320, :m3 nil}, :bufs {:b1 [1321 1322], :b2 []}} :line 74}
{:clk 2021.0157 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1321 :dets {:run {:m1 1323, :m2 nil, :m3 nil}, :bufs {:b1 [1321 1322], :b2 [1320]}} :line 75}
{:clk 2021.0157 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1323, :m2 1321, :m3 1320}, :bufs {:b1 [1322], :b2 []}} :line 76}
{:clk 2021.0157 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1320 :dets {:run {:m1 1323, :m2 1321, :m3 nil}, :bufs {:b1 [1322], :b2 [1320]}} :line 77}
{:clk 2021.3328 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1323 :dets {:run {:m1 1323, :m2 1321, :m3 1320}, :bufs {:b1 [1322], :b2 []}} :line 78}
{:clk 2021.3328 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2022.8328 :j 1324 :dets {:run {:m1 nil, :m2 1321, :m3 1320}, :bufs {:b1 [1322 1323], :b2 []}} :line 79}
{:clk 2022.0157 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1321 :dets {:run {:m1 1324, :m2 1321, :m3 1320}, :bufs {:b1 [1322 1323], :b2 []}} :line 80}
{:clk 2022.0157 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1322 :dets {:run {:m1 1324, :m2 nil, :m3 1320}, :bufs {:b1 [1322 1323], :b2 [1321]}} :line 81}
{:clk 2022.5157 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2009.8233 :j 1320 :dets {:run {:m1 1324, :m2 1322, :m3 1320}, :bufs {:b1 [1323], :b2 [1321]}} :line 82}
{:clk 2022.5157 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1321 :dets {:run {:m1 1324, :m2 1322, :m3 nil}, :bufs {:b1 [1323], :b2 [1321]}} :line 83}
{:clk 2022.8328 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1324 :dets {:run {:m1 1324, :m2 1322, :m3 1321}, :bufs {:b1 [1323], :b2 []}} :line 84}
{:clk 2022.8328 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2024.3328 :j 1325 :dets {:run {:m1 nil, :m2 1322, :m3 1321}, :bufs {:b1 [1323 1324], :b2 []}} :line 85}
{:clk 2023.5157 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1322 :dets {:run {:m1 1325, :m2 1322, :m3 1321}, :bufs {:b1 [1323 1324], :b2 []}} :line 86}
{:clk 2023.5157 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1323 :dets {:run {:m1 1325, :m2 nil, :m3 nil}, :bufs {:b1 [1323 1324], :b2 [1322]}} :line 87}
{:clk 2023.5157 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2012.0242 :j 1321 :dets {:run {:m1 1325, :m2 nil, :m3 1321}, :bufs {:b1 [1323 1324], :b2 [1322]}} :line 88}
{:clk 2023.5157 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1322 :dets {:run {:m1 1325, :m2 1323, :m3 nil}, :bufs {:b1 [1324], :b2 [1322]}} :line 89}
{:clk 2024.3328 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1325 :dets {:run {:m1 1325, :m2 1323, :m3 1322}, :bufs {:b1 [1324], :b2 []}} :line 90}
{:clk 2024.3328 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2025.3328 :j 1326 :dets {:run {:m1 nil, :m2 1323, :m3 1322}, :bufs {:b1 [1324 1325], :b2 []}} :line 91}
{:clk 2024.5157 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1323 :dets {:run {:m1 1326, :m2 1323, :m3 1322}, :bufs {:b1 [1324 1325], :b2 []}} :line 92}
{:clk 2024.5157 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1324 :dets {:run {:m1 1326, :m2 nil, :m3 1322}, :bufs {:b1 [1324 1325], :b2 [1323]}} :line 93}
{:clk 2025.0157 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2016.2446 :j 1322 :dets {:run {:m1 1326, :m2 1324, :m3 1322}, :bufs {:b1 [1325], :b2 [1323]}} :line 94}
{:clk 2025.0157 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1323 :dets {:run {:m1 1326, :m2 1324, :m3 nil}, :bufs {:b1 [1325], :b2 [1323]}} :line 95}
{:clk 2025.3328 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1326 :dets {:run {:m1 1326, :m2 1324, :m3 1323}, :bufs {:b1 [1325], :b2 []}} :line 96}
{:clk 2025.3328 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2026.8328 :j 1327 :dets {:run {:m1 nil, :m2 1324, :m3 1323}, :bufs {:b1 [1325 1326], :b2 []}} :line 97}
{:clk 2026.0157 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1324 :dets {:run {:m1 1327, :m2 1324, :m3 1323}, :bufs {:b1 [1325 1326], :b2 []}} :line 98}
{:clk 2026.0157 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1325 :dets {:run {:m1 1327, :m2 nil, :m3 nil}, :bufs {:b1 [1325 1326], :b2 [1324]}} :line 99}
{:clk 2026.0157 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2017.7446 :j 1323 :dets {:run {:m1 1327, :m2 nil, :m3 1323}, :bufs {:b1 [1325 1326], :b2 [1324]}} :line 100}
{:clk 2026.0157 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1324 :dets {:run {:m1 1327, :m2 1325, :m3 nil}, :bufs {:b1 [1326], :b2 [1324]}} :line 101}
{:clk 2026.8328 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1327 :dets {:run {:m1 1327, :m2 1325, :m3 1324}, :bufs {:b1 [1326], :b2 []}} :line 102}
{:clk 2026.8328 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2028.3328 :j 1328 :dets {:run {:m1 nil, :m2 1325, :m3 1324}, :bufs {:b1 [1326 1327], :b2 []}} :line 103}
{:clk 2027.5157 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1325 :dets {:run {:m1 1328, :m2 1325, :m3 1324}, :bufs {:b1 [1326 1327], :b2 []}} :line 104}
{:clk 2027.5157 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1326 :dets {:run {:m1 1328, :m2 nil, :m3 nil}, :bufs {:b1 [1326 1327], :b2 [1325]}} :line 105}
{:clk 2027.5157 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2021.3328 :j 1324 :dets {:run {:m1 1328, :m2 nil, :m3 1324}, :bufs {:b1 [1326 1327], :b2 [1325]}} :line 106}
{:clk 2027.5157 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1325 :dets {:run {:m1 1328, :m2 1326, :m3 nil}, :bufs {:b1 [1327], :b2 [1325]}} :line 107}
{:clk 2028.3328 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1328 :dets {:run {:m1 1328, :m2 1326, :m3 1325}, :bufs {:b1 [1327], :b2 []}} :line 108}
{:clk 2028.3328 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2029.3328 :j 1329 :dets {:run {:m1 nil, :m2 1326, :m3 1325}, :bufs {:b1 [1327 1328], :b2 []}} :line 109}
{:clk 2028.5157 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1326 :dets {:run {:m1 1329, :m2 1326, :m3 1325}, :bufs {:b1 [1327 1328], :b2 []}} :line 110}
{:clk 2028.5157 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1327 :dets {:run {:m1 1329, :m2 nil, :m3 1325}, :bufs {:b1 [1327 1328], :b2 [1326]}} :line 111}
{:clk 2029.1566 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2022.8328 :j 1325 :dets {:run {:m1 1329, :m2 1327, :m3 1325}, :bufs {:b1 [1328], :b2 [1326]}} :line 112}
{:clk 2029.1566 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1326 :dets {:run {:m1 1329, :m2 1327, :m3 nil}, :bufs {:b1 [1328], :b2 [1326]}} :line 113}
{:clk 2029.3328 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1329 :dets {:run {:m1 1329, :m2 1327, :m3 1326}, :bufs {:b1 [1328], :b2 []}} :line 114}
{:clk 2029.3328 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2030.8328 :j 1330 :dets {:run {:m1 nil, :m2 1327, :m3 1326}, :bufs {:b1 [1328 1329], :b2 []}} :line 115}
{:clk 2030.0157 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1327 :dets {:run {:m1 1330, :m2 1327, :m3 1326}, :bufs {:b1 [1328 1329], :b2 []}} :line 116}
{:clk 2030.0157 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1328 :dets {:run {:m1 1330, :m2 nil, :m3 1326}, :bufs {:b1 [1328 1329], :b2 [1327]}} :line 117}
{:clk 2030.1566 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2024.3328 :j 1326 :dets {:run {:m1 1330, :m2 1328, :m3 1326}, :bufs {:b1 [1329], :b2 [1327]}} :line 118}
{:clk 2030.1566 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1327 :dets {:run {:m1 1330, :m2 1328, :m3 nil}, :bufs {:b1 [1329], :b2 [1327]}} :line 119}
{:clk 2030.8328 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1330 :dets {:run {:m1 1330, :m2 1328, :m3 1327}, :bufs {:b1 [1329], :b2 []}} :line 120}
{:clk 2030.8328 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2032.3328 :j 1331 :dets {:run {:m1 nil, :m2 1328, :m3 1327}, :bufs {:b1 [1329 1330], :b2 []}} :line 121}
{:clk 2031.5157 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1328 :dets {:run {:m1 1331, :m2 1328, :m3 1327}, :bufs {:b1 [1329 1330], :b2 []}} :line 122}
{:clk 2031.5157 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1329 :dets {:run {:m1 1331, :m2 nil, :m3 1327}, :bufs {:b1 [1329 1330], :b2 [1328]}} :line 123}
{:clk 2031.6566 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2025.3328 :j 1327 :dets {:run {:m1 1331, :m2 1329, :m3 1327}, :bufs {:b1 [1330], :b2 [1328]}} :line 124}
{:clk 2031.6566 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1328 :dets {:run {:m1 1331, :m2 1329, :m3 nil}, :bufs {:b1 [1330], :b2 [1328]}} :line 125}
{:clk 2032.3328 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1331 :dets {:run {:m1 1331, :m2 1329, :m3 1328}, :bufs {:b1 [1330], :b2 []}} :line 126}
{:clk 2032.3328 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2033.3328 :j 1332 :dets {:run {:m1 nil, :m2 1329, :m3 1328}, :bufs {:b1 [1330 1331], :b2 []}} :line 127}
{:clk 2032.5157 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1329 :dets {:run {:m1 1332, :m2 1329, :m3 1328}, :bufs {:b1 [1330 1331], :b2 []}} :line 128}
{:clk 2032.5157 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1330 :dets {:run {:m1 1332, :m2 nil, :m3 1328}, :bufs {:b1 [1330 1331], :b2 [1329]}} :line 129}
{:clk 2033.1566 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2026.8328 :j 1328 :dets {:run {:m1 1332, :m2 1330, :m3 1328}, :bufs {:b1 [1331], :b2 [1329]}} :line 130}
{:clk 2033.1566 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1329 :dets {:run {:m1 1332, :m2 1330, :m3 nil}, :bufs {:b1 [1331], :b2 [1329]}} :line 131}
{:clk 2033.3328 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1332 :dets {:run {:m1 1332, :m2 1330, :m3 1329}, :bufs {:b1 [1331], :b2 []}} :line 132}
{:clk 2033.3328 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2034.8328 :j 1333 :dets {:run {:m1 nil, :m2 1330, :m3 1329}, :bufs {:b1 [1331 1332], :b2 []}} :line 133}
{:clk 2034.0157 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1330 :dets {:run {:m1 1333, :m2 1330, :m3 1329}, :bufs {:b1 [1331 1332], :b2 []}} :line 134}
{:clk 2034.0157 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1331 :dets {:run {:m1 1333, :m2 nil, :m3 1329}, :bufs {:b1 [1331 1332], :b2 [1330]}} :line 135}
{:clk 2034.1566 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2028.3328 :j 1329 :dets {:run {:m1 1333, :m2 1331, :m3 1329}, :bufs {:b1 [1332], :b2 [1330]}} :line 136}
{:clk 2034.1566 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1330 :dets {:run {:m1 1333, :m2 1331, :m3 nil}, :bufs {:b1 [1332], :b2 [1330]}} :line 137}
{:clk 2034.8328 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1333 :dets {:run {:m1 1333, :m2 1331, :m3 1330}, :bufs {:b1 [1332], :b2 []}} :line 138}
{:clk 2034.8328 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2036.3328 :j 1334 :dets {:run {:m1 nil, :m2 1331, :m3 1330}, :bufs {:b1 [1332 1333], :b2 []}} :line 139}
{:clk 2035.5157 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1331 :dets {:run {:m1 1334, :m2 1331, :m3 1330}, :bufs {:b1 [1332 1333], :b2 []}} :line 140}
{:clk 2035.5157 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1332 :dets {:run {:m1 1334, :m2 nil, :m3 1330}, :bufs {:b1 [1332 1333], :b2 [1331]}} :line 141}
{:clk 2035.6566 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2029.3328 :j 1330 :dets {:run {:m1 1334, :m2 1332, :m3 1330}, :bufs {:b1 [1333], :b2 [1331]}} :line 142}
{:clk 2035.6566 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1331 :dets {:run {:m1 1334, :m2 1332, :m3 nil}, :bufs {:b1 [1333], :b2 [1331]}} :line 143}
{:clk 2036.3328 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1334 :dets {:run {:m1 1334, :m2 1332, :m3 1331}, :bufs {:b1 [1333], :b2 []}} :line 144}
{:clk 2036.3328 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2037.3328 :j 1335 :dets {:run {:m1 nil, :m2 1332, :m3 1331}, :bufs {:b1 [1333 1334], :b2 []}} :line 145}
{:clk 2036.5157 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1332 :dets {:run {:m1 1335, :m2 1332, :m3 1331}, :bufs {:b1 [1333 1334], :b2 []}} :line 146}
{:clk 2036.5157 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1333 :dets {:run {:m1 1335, :m2 nil, :m3 1331}, :bufs {:b1 [1333 1334], :b2 [1332]}} :line 147}
{:clk 2037.1566 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2030.8328 :j 1331 :dets {:run {:m1 1335, :m2 1333, :m3 1331}, :bufs {:b1 [1334], :b2 [1332]}} :line 148}
{:clk 2037.1566 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1332 :dets {:run {:m1 1335, :m2 1333, :m3 nil}, :bufs {:b1 [1334], :b2 [1332]}} :line 149}
{:clk 2037.3328 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1335 :dets {:run {:m1 1335, :m2 1333, :m3 1332}, :bufs {:b1 [1334], :b2 []}} :line 150}
{:clk 2037.3328 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2038.3328 :j 1336 :dets {:run {:m1 nil, :m2 1333, :m3 1332}, :bufs {:b1 [1334 1335], :b2 []}} :line 151}
{:clk 2038.0157 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1333 :dets {:run {:m1 1336, :m2 1333, :m3 1332}, :bufs {:b1 [1334 1335], :b2 []}} :line 152}
{:clk 2038.0157 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1334 :dets {:run {:m1 1336, :m2 nil, :m3 1332}, :bufs {:b1 [1334 1335], :b2 [1333]}} :line 153}
{:clk 2038.1566 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2032.3328 :j 1332 :dets {:run {:m1 1336, :m2 1334, :m3 1332}, :bufs {:b1 [1335], :b2 [1333]}} :line 154}
{:clk 2038.1566 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1333 :dets {:run {:m1 1336, :m2 1334, :m3 nil}, :bufs {:b1 [1335], :b2 [1333]}} :line 155}
{:clk 2038.3328 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1336 :dets {:run {:m1 1336, :m2 1334, :m3 1333}, :bufs {:b1 [1335], :b2 []}} :line 156}
{:clk 2038.3328 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2039.3328 :j 1337 :dets {:run {:m1 nil, :m2 1334, :m3 1333}, :bufs {:b1 [1335 1336], :b2 []}} :line 157}
{:clk 2039.3328 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1337, :m2 1334, :m3 1333}, :bufs {:b1 [1335 1336], :b2 []}} :line 158}
{:clk 2039.5157 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1334 :dets {:run {:m1 1337, :m2 1334, :m3 1333}, :bufs {:b1 [1335 1336], :b2 []}} :line 159}
{:clk 2039.5157 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1335 :dets {:run {:m1 1337, :m2 nil, :m3 1333}, :bufs {:b1 [1335 1336], :b2 [1334]}} :line 160}
{:clk 2039.5157 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1335, :m3 1333}, :bufs {:b1 [1336 1337], :b2 [1334]}} :line 161}
{:clk 2039.5157 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1337 :dets {:run {:m1 1337, :m2 1335, :m3 1333}, :bufs {:b1 [1336], :b2 [1334]}} :line 162}
{:clk 2039.5157 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2041.0157 :j 1338 :dets {:run {:m1 nil, :m2 1335, :m3 1333}, :bufs {:b1 [1336 1337], :b2 [1334]}} :line 163}
{:clk 2039.6566 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2033.3328 :j 1333 :dets {:run {:m1 1338, :m2 1335, :m3 1333}, :bufs {:b1 [1336 1337], :b2 [1334]}} :line 164}
{:clk 2039.6566 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1334 :dets {:run {:m1 1338, :m2 1335, :m3 nil}, :bufs {:b1 [1336 1337], :b2 [1334]}} :line 165}
{:clk 2040.5157 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1335 :dets {:run {:m1 1338, :m2 1335, :m3 1334}, :bufs {:b1 [1336 1337], :b2 []}} :line 166}
{:clk 2040.5157 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1336 :dets {:run {:m1 1338, :m2 nil, :m3 1334}, :bufs {:b1 [1336 1337], :b2 [1335]}} :line 167}
{:clk 2041.0157 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1338 :dets {:run {:m1 1338, :m2 1336, :m3 1334}, :bufs {:b1 [1337], :b2 [1335]}} :line 168}
{:clk 2041.0157 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2042.5157 :j 1339 :dets {:run {:m1 nil, :m2 1336, :m3 1334}, :bufs {:b1 [1337 1338], :b2 [1335]}} :line 169}
{:clk 2041.1566 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2034.8328 :j 1334 :dets {:run {:m1 1339, :m2 1336, :m3 1334}, :bufs {:b1 [1337 1338], :b2 [1335]}} :line 170}
{:clk 2041.1566 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1335 :dets {:run {:m1 1339, :m2 1336, :m3 nil}, :bufs {:b1 [1337 1338], :b2 [1335]}} :line 171}
{:clk 2041.5157 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1336 :dets {:run {:m1 1339, :m2 1336, :m3 1335}, :bufs {:b1 [1337 1338], :b2 []}} :line 172}
{:clk 2041.5157 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1337 :dets {:run {:m1 1339, :m2 nil, :m3 1335}, :bufs {:b1 [1337 1338], :b2 [1336]}} :line 173}
{:clk 2042.1566 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2036.3328 :j 1335 :dets {:run {:m1 1339, :m2 1337, :m3 1335}, :bufs {:b1 [1338], :b2 [1336]}} :line 174}
{:clk 2042.1566 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1336 :dets {:run {:m1 1339, :m2 1337, :m3 nil}, :bufs {:b1 [1338], :b2 [1336]}} :line 175}
{:clk 2042.5157 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1339 :dets {:run {:m1 1339, :m2 1337, :m3 1336}, :bufs {:b1 [1338], :b2 []}} :line 176}
{:clk 2042.5157 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2044.0157 :j 1340 :dets {:run {:m1 nil, :m2 nil, :m3 1336}, :bufs {:b1 [1338 1339], :b2 [1337]}} :line 177}
{:clk 2042.5157 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1337 :dets {:run {:m1 nil, :m2 1337, :m3 1336}, :bufs {:b1 [1338 1339], :b2 []}} :line 178}
{:clk 2042.5157 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1338 :dets {:run {:m1 1340, :m2 nil, :m3 1336}, :bufs {:b1 [1338 1339], :b2 [1337]}} :line 179}
{:clk 2044.0157 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1340 :dets {:run {:m1 1340, :m2 1338, :m3 1336}, :bufs {:b1 [1339], :b2 [1337]}} :line 180}
{:clk 2044.0157 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2045.5157 :j 1341 :dets {:run {:m1 nil, :m2 nil, :m3 1336}, :bufs {:b1 [1339 1340], :b2 [1337 1338]}} :line 181}
{:clk 2044.0157 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1338 :dets {:run {:m1 nil, :m2 1338, :m3 1336}, :bufs {:b1 [1339 1340], :b2 [1337]}} :line 182}
{:clk 2044.0157 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1339 :dets {:run {:m1 1341, :m2 nil, :m3 1336}, :bufs {:b1 [1339 1340], :b2 [1337 1338]}} :line 183}
{:clk 2045.5157 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2046.5157 :j 1342 :dets {:run {:m1 nil, :m2 1339, :m3 1336}, :bufs {:b1 [1340 1341], :b2 [1337 1338]}} :line 184}
{:clk 2045.5157 :act :m2-blocked :m :m2 :mjpact :bl :dets {:run {:m1 nil, :m2 1339, :m3 1336}, :bufs {:b1 [1340 1341], :b2 [1337 1338]}} :line 185}
{:clk 2045.5157 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1341 :dets {:run {:m1 1341, :m2 1339, :m3 1336}, :bufs {:b1 [1340], :b2 [1337 1338]}} :line 186}
{:clk 2046.5157 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1342, :m2 1339, :m3 1336}, :bufs {:b1 [1340 1341], :b2 [1337 1338]}} :line 187}
{:clk 2048.7705 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2037.3328 :j 1336 :dets {:run {:m1 1342, :m2 1339, :m3 1336}, :bufs {:b1 [1340 1341], :b2 [1337 1338]}} :line 188}
{:clk 2048.7705 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1337 :dets {:run {:m1 1342, :m2 1339, :m3 nil}, :bufs {:b1 [1340 1341], :b2 [1337 1338]}} :line 189}
{:clk 2048.7705 :act :m2-unblocked :m :m2 :mjpact :ub :dets {:run {:m1 1342, :m2 nil, :m3 1337}, :bufs {:b1 [1340 1341], :b2 [1338 1339]}} :line 190}
{:clk 2048.7705 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1339 :dets {:run {:m1 1342, :m2 1339, :m3 1337}, :bufs {:b1 [1340 1341], :b2 [1338]}} :line 191}
{:clk 2048.7705 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1340 :dets {:run {:m1 1342, :m2 nil, :m3 1337}, :bufs {:b1 [1340 1341], :b2 [1338 1339]}} :line 192}
{:clk 2048.7705 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1340, :m3 1337}, :bufs {:b1 [1341 1342], :b2 [1338 1339]}} :line 193}
{:clk 2048.7705 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1342 :dets {:run {:m1 1342, :m2 1340, :m3 1337}, :bufs {:b1 [1341], :b2 [1338 1339]}} :line 194}
{:clk 2048.7705 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2049.7705 :j 1343 :dets {:run {:m1 nil, :m2 1340, :m3 1337}, :bufs {:b1 [1341 1342], :b2 [1338 1339]}} :line 195}
{:clk 2049.7705 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1338 :dets {:run {:m1 1343, :m2 1340, :m3 nil}, :bufs {:b1 [1341 1342], :b2 [1338 1339]}} :line 196}
{:clk 2049.7705 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1343, :m2 1340, :m3 nil}, :bufs {:b1 [1341 1342], :b2 [1338 1339]}} :line 197}
{:clk 2049.7705 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2038.3328 :j 1337 :dets {:run {:m1 1343, :m2 1340, :m3 1337}, :bufs {:b1 [1341 1342], :b2 [1338 1339]}} :line 198}
{:clk 2050.6349 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1340 :dets {:run {:m1 1343, :m2 1340, :m3 1338}, :bufs {:b1 [1341 1342], :b2 [1339]}} :line 199}
{:clk 2050.6349 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1341 :dets {:run {:m1 1343, :m2 nil, :m3 1338}, :bufs {:b1 [1341 1342], :b2 [1339 1340]}} :line 200}
{:clk 2050.6349 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1341, :m3 1338}, :bufs {:b1 [1342 1343], :b2 [1339 1340]}} :line 201}
{:clk 2050.6349 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1343 :dets {:run {:m1 1343, :m2 1341, :m3 1338}, :bufs {:b1 [1342], :b2 [1339 1340]}} :line 202}
{:clk 2050.6349 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2052.1349 :j 1344 :dets {:run {:m1 nil, :m2 1341, :m3 1338}, :bufs {:b1 [1342 1343], :b2 [1339 1340]}} :line 203}
{:clk 2051.2705 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2039.5157 :j 1338 :dets {:run {:m1 1344, :m2 1341, :m3 1338}, :bufs {:b1 [1342 1343], :b2 [1339 1340]}} :line 204}
{:clk 2051.2705 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1339 :dets {:run {:m1 1344, :m2 1341, :m3 nil}, :bufs {:b1 [1342 1343], :b2 [1339 1340]}} :line 205}
{:clk 2052.1349 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1344, :m2 1341, :m3 1339}, :bufs {:b1 [1342 1343], :b2 [1340]}} :line 206}
{:clk 2052.3844 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1341 :dets {:run {:m1 1344, :m2 1341, :m3 1339}, :bufs {:b1 [1342 1343], :b2 [1340]}} :line 207}
{:clk 2052.3844 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1342 :dets {:run {:m1 1344, :m2 nil, :m3 1339}, :bufs {:b1 [1342 1343], :b2 [1340 1341]}} :line 208}
{:clk 2052.3844 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1342, :m3 1339}, :bufs {:b1 [1343 1344], :b2 [1340 1341]}} :line 209}
{:clk 2052.3844 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1344 :dets {:run {:m1 1344, :m2 1342, :m3 1339}, :bufs {:b1 [1343], :b2 [1340 1341]}} :line 210}
{:clk 2052.3844 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2053.4766 :j 1345 :dets {:run {:m1 nil, :m2 1342, :m3 1339}, :bufs {:b1 [1343 1344], :b2 [1340 1341]}} :line 211}
{:clk 2052.7705 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2041.0157 :j 1339 :dets {:run {:m1 1345, :m2 1342, :m3 1339}, :bufs {:b1 [1343 1344], :b2 [1340 1341]}} :line 212}
{:clk 2052.7705 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1340 :dets {:run {:m1 1345, :m2 1342, :m3 nil}, :bufs {:b1 [1343 1344], :b2 [1340 1341]}} :line 213}
{:clk 2053.3844 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1342 :dets {:run {:m1 1345, :m2 1342, :m3 1340}, :bufs {:b1 [1343 1344], :b2 [1341]}} :line 214}
{:clk 2053.3844 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1343 :dets {:run {:m1 1345, :m2 nil, :m3 1340}, :bufs {:b1 [1343 1344], :b2 [1341 1342]}} :line 215}
{:clk 2053.4766 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1345 :dets {:run {:m1 1345, :m2 1343, :m3 1340}, :bufs {:b1 [1344], :b2 [1341 1342]}} :line 216}
{:clk 2053.4766 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2057.0896 :j 1346 :dets {:run {:m1 nil, :m2 1343, :m3 1340}, :bufs {:b1 [1344 1345], :b2 [1341 1342]}} :line 217}
{:clk 2054.2705 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2042.5157 :j 1340 :dets {:run {:m1 1346, :m2 1343, :m3 1340}, :bufs {:b1 [1344 1345], :b2 [1341 1342]}} :line 218}
{:clk 2054.2705 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1341 :dets {:run {:m1 1346, :m2 1343, :m3 nil}, :bufs {:b1 [1344 1345], :b2 [1341 1342]}} :line 219}
{:clk 2054.3844 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1343 :dets {:run {:m1 1346, :m2 1343, :m3 1341}, :bufs {:b1 [1344 1345], :b2 [1342]}} :line 220}
{:clk 2054.3844 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1344 :dets {:run {:m1 1346, :m2 nil, :m3 1341}, :bufs {:b1 [1344 1345], :b2 [1342 1343]}} :line 221}
{:clk 2055.7705 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2044.0157 :j 1341 :dets {:run {:m1 1346, :m2 1344, :m3 1341}, :bufs {:b1 [1345], :b2 [1342 1343]}} :line 222}
{:clk 2055.7705 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1342 :dets {:run {:m1 1346, :m2 1344, :m3 nil}, :bufs {:b1 [1345], :b2 [1342 1343]}} :line 223}
{:clk 2055.8844 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1344 :dets {:run {:m1 1346, :m2 1344, :m3 1342}, :bufs {:b1 [1345], :b2 [1343]}} :line 224}
{:clk 2055.8844 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1345 :dets {:run {:m1 1346, :m2 nil, :m3 1342}, :bufs {:b1 [1345], :b2 [1343 1344]}} :line 225}
{:clk 2056.7705 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2045.5157 :j 1342 :dets {:run {:m1 1346, :m2 1345, :m3 1342}, :bufs {:b1 [], :b2 [1343 1344]}} :line 226}
{:clk 2056.7705 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1343 :dets {:run {:m1 1346, :m2 1345, :m3 nil}, :bufs {:b1 [], :b2 [1343 1344]}} :line 227}
{:clk 2056.8844 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1345 :dets {:run {:m1 1346, :m2 1345, :m3 1343}, :bufs {:b1 [], :b2 [1344]}} :line 228}
{:clk 2056.8844 :act :m2-starved :m :m2 :mjpact :st :dets {:run {:m1 1346, :m2 nil, :m3 1343}, :bufs {:b1 [], :b2 [1344 1345]}} :line 229}
{:clk 2057.0896 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1346 :dets {:run {:m1 1346, :m2 nil, :m3 1343}, :bufs {:b1 [], :b2 [1344 1345]}} :line 230}
{:clk 2057.0896 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2058.0896 :j 1347 :dets {:run {:m1 nil, :m2 nil, :m3 1343}, :bufs {:b1 [1346], :b2 [1344 1345]}} :line 231}
{:clk 2057.0896 :act :m2-unstarved :m :m2 :mjpact :us :dets {:run {:m1 1347, :m2 1346, :m3 1343}, :bufs {:b1 [], :b2 [1344 1345]}} :line 232}
{:clk 2057.0896 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1346 :dets {:run {:m1 1347, :m2 nil, :m3 1343}, :bufs {:b1 [1346], :b2 [1344 1345]}} :line 233}
{:clk 2057.7705 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2048.7705 :j 1343 :dets {:run {:m1 1347, :m2 1346, :m3 1343}, :bufs {:b1 [], :b2 [1344 1345]}} :line 234}
{:clk 2057.7705 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1344 :dets {:run {:m1 1347, :m2 1346, :m3 nil}, :bufs {:b1 [], :b2 [1344 1345]}} :line 235}
{:clk 2058.0896 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1347 :dets {:run {:m1 1347, :m2 1346, :m3 1344}, :bufs {:b1 [], :b2 [1345]}} :line 236}
{:clk 2058.0896 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2059.5896 :j 1348 :dets {:run {:m1 nil, :m2 nil, :m3 1344}, :bufs {:b1 [1347], :b2 [1345 1346]}} :line 237}
{:clk 2058.0896 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1346 :dets {:run {:m1 nil, :m2 1346, :m3 1344}, :bufs {:b1 [1347], :b2 [1345]}} :line 238}
{:clk 2058.0896 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1347 :dets {:run {:m1 1348, :m2 nil, :m3 1344}, :bufs {:b1 [1347], :b2 [1345 1346]}} :line 239}
{:clk 2059.0896 :act :m2-starved :m :m2 :mjpact :st :dets {:run {:m1 1348, :m2 1347, :m3 1344}, :bufs {:b1 [], :b2 [1345 1346]}} :line 240}
{:clk 2059.0896 :act :m2-blocked :m :m2 :mjpact :bl :dets {:run {:m1 1348, :m2 1347, :m3 1344}, :bufs {:b1 [], :b2 [1345 1346]}} :line 241}
{:clk 2059.2705 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2050.6349 :j 1344 :dets {:run {:m1 1348, :m2 1347, :m3 1344}, :bufs {:b1 [], :b2 [1345 1346]}} :line 242}
{:clk 2059.2705 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1345 :dets {:run {:m1 1348, :m2 1347, :m3 nil}, :bufs {:b1 [], :b2 [1345 1346]}} :line 243}
{:clk 2059.2705 :act :m2-unblocked :m :m2 :mjpact :ub :dets {:run {:m1 1348, :m2 nil, :m3 1345}, :bufs {:b1 [], :b2 [1346 1347]}} :line 244}
{:clk 2059.2705 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1347 :dets {:run {:m1 1348, :m2 1347, :m3 1345}, :bufs {:b1 [], :b2 [1346]}} :line 245}
{:clk 2059.5896 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1348 :dets {:run {:m1 1348, :m2 nil, :m3 1345}, :bufs {:b1 [], :b2 [1346 1347]}} :line 246}
{:clk 2059.5896 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2062.0436 :j 1349 :dets {:run {:m1 nil, :m2 nil, :m3 1345}, :bufs {:b1 [1348], :b2 [1346 1347]}} :line 247}
{:clk 2059.5896 :act :m2-unstarved :m :m2 :mjpact :us :dets {:run {:m1 1349, :m2 1348, :m3 1345}, :bufs {:b1 [], :b2 [1346 1347]}} :line 248}
{:clk 2059.5896 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1348 :dets {:run {:m1 1349, :m2 nil, :m3 1345}, :bufs {:b1 [1348], :b2 [1346 1347]}} :line 249}
{:clk 2060.2705 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2052.3844 :j 1345 :dets {:run {:m1 1349, :m2 1348, :m3 1345}, :bufs {:b1 [], :b2 [1346 1347]}} :line 250}
{:clk 2060.2705 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1346 :dets {:run {:m1 1349, :m2 1348, :m3 nil}, :bufs {:b1 [], :b2 [1346 1347]}} :line 251}
{:clk 2061.2705 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2053.4766 :j 1346 :dets {:run {:m1 1349, :m2 1348, :m3 1346}, :bufs {:b1 [], :b2 [1347]}} :line 252}
{:clk 2061.2705 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1347 :dets {:run {:m1 1349, :m2 1348, :m3 nil}, :bufs {:b1 [], :b2 [1347]}} :line 253}
{:clk 2061.7181 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1348 :dets {:run {:m1 1349, :m2 1348, :m3 1347}, :bufs {:b1 [], :b2 []}} :line 254}
{:clk 2061.7181 :act :m2-starved :m :m2 :mjpact :st :dets {:run {:m1 1349, :m2 nil, :m3 1347}, :bufs {:b1 [], :b2 [1348]}} :line 255}
{:clk 2062.0436 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1349 :dets {:run {:m1 1349, :m2 nil, :m3 1347}, :bufs {:b1 [], :b2 [1348]}} :line 256}
{:clk 2062.0436 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2063.5436 :j 1350 :dets {:run {:m1 nil, :m2 nil, :m3 1347}, :bufs {:b1 [1349], :b2 [1348]}} :line 257}
{:clk 2062.0436 :act :m2-unstarved :m :m2 :mjpact :us :dets {:run {:m1 1350, :m2 1349, :m3 1347}, :bufs {:b1 [], :b2 [1348]}} :line 258}
{:clk 2062.0436 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1349 :dets {:run {:m1 1350, :m2 nil, :m3 1347}, :bufs {:b1 [1349], :b2 [1348]}} :line 259}
{:clk 2062.2705 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2057.0896 :j 1347 :dets {:run {:m1 1350, :m2 1349, :m3 1347}, :bufs {:b1 [], :b2 [1348]}} :line 260}
{:clk 2062.2705 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1348 :dets {:run {:m1 1350, :m2 1349, :m3 nil}, :bufs {:b1 [], :b2 [1348]}} :line 261}
{:clk 2063.0436 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1349 :dets {:run {:m1 1350, :m2 1349, :m3 1348}, :bufs {:b1 [], :b2 []}} :line 262}
{:clk 2063.0436 :act :m2-starved :m :m2 :mjpact :st :dets {:run {:m1 1350, :m2 nil, :m3 1348}, :bufs {:b1 [], :b2 [1349]}} :line 263}
{:clk 2063.5436 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1350 :dets {:run {:m1 1350, :m2 nil, :m3 1348}, :bufs {:b1 [], :b2 [1349]}} :line 264}
{:clk 2063.5436 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2064.5436 :j 1351 :dets {:run {:m1 nil, :m2 nil, :m3 1348}, :bufs {:b1 [1350], :b2 [1349]}} :line 265}
{:clk 2063.5436 :act :m2-unstarved :m :m2 :mjpact :us :dets {:run {:m1 1351, :m2 1350, :m3 1348}, :bufs {:b1 [], :b2 [1349]}} :line 266}
{:clk 2063.5436 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1350 :dets {:run {:m1 1351, :m2 nil, :m3 1348}, :bufs {:b1 [1350], :b2 [1349]}} :line 267}
{:clk 2063.7705 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2058.0896 :j 1348 :dets {:run {:m1 1351, :m2 1350, :m3 1348}, :bufs {:b1 [], :b2 [1349]}} :line 268}
{:clk 2063.7705 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1349 :dets {:run {:m1 1351, :m2 1350, :m3 nil}, :bufs {:b1 [], :b2 [1349]}} :line 269}
{:clk 2064.5436 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1351 :dets {:run {:m1 1351, :m2 1350, :m3 1349}, :bufs {:b1 [], :b2 []}} :line 270}
{:clk 2064.5436 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2066.0436 :j 1352 :dets {:run {:m1 nil, :m2 1350, :m3 1349}, :bufs {:b1 [1351], :b2 []}} :line 271}
{:clk 2064.7705 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2059.5896 :j 1349 :dets {:run {:m1 1352, :m2 1350, :m3 1349}, :bufs {:b1 [1351], :b2 []}} :line 272}
{:clk 2064.7705 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1352, :m2 1350, :m3 nil}, :bufs {:b1 [1351], :b2 []}} :line 273}
{:clk 2065.0436 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1350 :dets {:run {:m1 1352, :m2 1350, :m3 nil}, :bufs {:b1 [1351], :b2 []}} :line 274}
{:clk 2065.0436 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1351 :dets {:run {:m1 1352, :m2 nil, :m3 nil}, :bufs {:b1 [1351], :b2 [1350]}} :line 275}
{:clk 2065.0436 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1352, :m2 1351, :m3 1350}, :bufs {:b1 [], :b2 []}} :line 276}
{:clk 2065.0436 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1350 :dets {:run {:m1 1352, :m2 1351, :m3 nil}, :bufs {:b1 [], :b2 [1350]}} :line 277}
{:clk 2066.0436 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1352 :dets {:run {:m1 1352, :m2 1351, :m3 1350}, :bufs {:b1 [], :b2 []}} :line 278}
{:clk 2066.0436 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2067.0436 :j 1353 :dets {:run {:m1 nil, :m2 nil, :m3 1350}, :bufs {:b1 [1352], :b2 [1351]}} :line 279}
{:clk 2066.0436 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1351 :dets {:run {:m1 nil, :m2 1351, :m3 1350}, :bufs {:b1 [1352], :b2 []}} :line 280}
{:clk 2066.0436 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1352 :dets {:run {:m1 1353, :m2 nil, :m3 1350}, :bufs {:b1 [1352], :b2 [1351]}} :line 281}
{:clk 2066.5436 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2062.0436 :j 1350 :dets {:run {:m1 1353, :m2 1352, :m3 1350}, :bufs {:b1 [], :b2 [1351]}} :line 282}
{:clk 2066.5436 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1351 :dets {:run {:m1 1353, :m2 1352, :m3 nil}, :bufs {:b1 [], :b2 [1351]}} :line 283}
{:clk 2067.0436 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1353 :dets {:run {:m1 1353, :m2 1352, :m3 1351}, :bufs {:b1 [], :b2 []}} :line 284}
{:clk 2067.0436 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2068.5436 :j 1354 :dets {:run {:m1 nil, :m2 1352, :m3 1351}, :bufs {:b1 [1353], :b2 []}} :line 285}
{:clk 2067.5436 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1352 :dets {:run {:m1 1354, :m2 1352, :m3 1351}, :bufs {:b1 [1353], :b2 []}} :line 286}
{:clk 2067.5436 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1353 :dets {:run {:m1 1354, :m2 nil, :m3 nil}, :bufs {:b1 [1353], :b2 [1352]}} :line 287}
{:clk 2067.5436 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2063.5436 :j 1351 :dets {:run {:m1 1354, :m2 nil, :m3 1351}, :bufs {:b1 [1353], :b2 [1352]}} :line 288}
{:clk 2067.5436 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1352 :dets {:run {:m1 1354, :m2 1353, :m3 nil}, :bufs {:b1 [], :b2 [1352]}} :line 289}
{:clk 2068.5436 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1354 :dets {:run {:m1 1354, :m2 1353, :m3 1352}, :bufs {:b1 [], :b2 []}} :line 290}
{:clk 2068.5436 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2070.0436 :j 1355 :dets {:run {:m1 nil, :m2 nil, :m3 1352}, :bufs {:b1 [1354], :b2 [1353]}} :line 291}
{:clk 2068.5436 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1353 :dets {:run {:m1 nil, :m2 1353, :m3 1352}, :bufs {:b1 [1354], :b2 []}} :line 292}
{:clk 2068.5436 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1354 :dets {:run {:m1 1355, :m2 nil, :m3 1352}, :bufs {:b1 [1354], :b2 [1353]}} :line 293}
{:clk 2069.0436 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2064.5436 :j 1352 :dets {:run {:m1 1355, :m2 1354, :m3 1352}, :bufs {:b1 [], :b2 [1353]}} :line 294}
{:clk 2069.0436 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1353 :dets {:run {:m1 1355, :m2 1354, :m3 nil}, :bufs {:b1 [], :b2 [1353]}} :line 295}
{:clk 2070.0436 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1355 :dets {:run {:m1 1355, :m2 1354, :m3 1353}, :bufs {:b1 [], :b2 []}} :line 296}
{:clk 2070.0436 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2071.5436 :j 1356 :dets {:run {:m1 nil, :m2 nil, :m3 nil}, :bufs {:b1 [1355], :b2 [1354]}} :line 297}
{:clk 2070.0436 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1354 :dets {:run {:m1 nil, :m2 1354, :m3 1353}, :bufs {:b1 [1355], :b2 []}} :line 298}
{:clk 2070.0436 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1355 :dets {:run {:m1 1356, :m2 nil, :m3 nil}, :bufs {:b1 [1355], :b2 [1354]}} :line 299}
{:clk 2070.0436 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2066.0436 :j 1353 :dets {:run {:m1 nil, :m2 nil, :m3 1353}, :bufs {:b1 [1355], :b2 [1354]}} :line 300}
{:clk 2070.0436 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1354 :dets {:run {:m1 1356, :m2 1355, :m3 nil}, :bufs {:b1 [], :b2 [1354]}} :line 301}
{:clk 2071.5436 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1356 :dets {:run {:m1 1356, :m2 1355, :m3 1354}, :bufs {:b1 [], :b2 []}} :line 302}
{:clk 2071.5436 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2073.0436 :j 1357 :dets {:run {:m1 nil, :m2 nil, :m3 nil}, :bufs {:b1 [1356], :b2 [1355]}} :line 303}
{:clk 2071.5436 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1355 :dets {:run {:m1 nil, :m2 1355, :m3 1354}, :bufs {:b1 [1356], :b2 []}} :line 304}
{:clk 2071.5436 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1356 :dets {:run {:m1 1357, :m2 nil, :m3 nil}, :bufs {:b1 [1356], :b2 [1355]}} :line 305}
{:clk 2071.5436 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2067.0436 :j 1354 :dets {:run {:m1 nil, :m2 nil, :m3 1354}, :bufs {:b1 [1356], :b2 [1355]}} :line 306}
{:clk 2071.5436 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1355 :dets {:run {:m1 1357, :m2 1356, :m3 nil}, :bufs {:b1 [], :b2 [1355]}} :line 307}
{:clk 2073.0436 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1357 :dets {:run {:m1 1357, :m2 1356, :m3 1355}, :bufs {:b1 [], :b2 []}} :line 308}
{:clk 2073.0436 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2075.8304 :j 1358 :dets {:run {:m1 nil, :m2 nil, :m3 nil}, :bufs {:b1 [1357], :b2 [1356]}} :line 309}
{:clk 2073.0436 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1356 :dets {:run {:m1 nil, :m2 1356, :m3 1355}, :bufs {:b1 [1357], :b2 []}} :line 310}
{:clk 2073.0436 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1357 :dets {:run {:m1 1358, :m2 nil, :m3 nil}, :bufs {:b1 [1357], :b2 [1356]}} :line 311}
{:clk 2073.0436 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2068.5436 :j 1355 :dets {:run {:m1 nil, :m2 nil, :m3 1355}, :bufs {:b1 [1357], :b2 [1356]}} :line 312}
{:clk 2073.0436 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1356 :dets {:run {:m1 1358, :m2 1357, :m3 nil}, :bufs {:b1 [], :b2 [1356]}} :line 313}
{:clk 2074.5436 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1357 :dets {:run {:m1 1358, :m2 1357, :m3 1356}, :bufs {:b1 [], :b2 []}} :line 314}
{:clk 2074.5436 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2070.0436 :j 1356 :dets {:run {:m1 1358, :m2 nil, :m3 1356}, :bufs {:b1 [], :b2 [1357]}} :line 315}
{:clk 2074.5436 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1357 :dets {:run {:m1 1358, :m2 nil, :m3 nil}, :bufs {:b1 [], :b2 [1357]}} :line 316}
{:clk 2074.5436 :act :m2-starved :m :m2 :mjpact :st :dets {:run {:m1 1358, :m2 nil, :m3 1357}, :bufs {:b1 [], :b2 []}} :line 317}
{:clk 2075.8304 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1358 :dets {:run {:m1 1358, :m2 nil, :m3 1357}, :bufs {:b1 [], :b2 []}} :line 318}
{:clk 2075.8304 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2076.8304 :j 1359 :dets {:run {:m1 nil, :m2 nil, :m3 1357}, :bufs {:b1 [1358], :b2 []}} :line 319}
{:clk 2075.8304 :act :m2-unstarved :m :m2 :mjpact :us :dets {:run {:m1 1359, :m2 1358, :m3 1357}, :bufs {:b1 [], :b2 []}} :line 320}
{:clk 2075.8304 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1358 :dets {:run {:m1 1359, :m2 nil, :m3 1357}, :bufs {:b1 [1358], :b2 []}} :line 321}
{:clk 2076.0436 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2071.5436 :j 1357 :dets {:run {:m1 1359, :m2 1358, :m3 1357}, :bufs {:b1 [], :b2 []}} :line 322}
{:clk 2076.0436 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1359, :m2 1358, :m3 nil}, :bufs {:b1 [], :b2 []}} :line 323}
{:clk 2076.8304 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1359 :dets {:run {:m1 1359, :m2 1358, :m3 nil}, :bufs {:b1 [], :b2 []}} :line 324}
{:clk 2076.8304 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2078.3304 :j 1360 :dets {:run {:m1 nil, :m2 nil, :m3 nil}, :bufs {:b1 [1359], :b2 [1358]}} :line 325}
{:clk 2076.8304 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1358 :dets {:run {:m1 nil, :m2 1358, :m3 nil}, :bufs {:b1 [1359], :b2 []}} :line 326}
{:clk 2076.8304 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1359 :dets {:run {:m1 1360, :m2 nil, :m3 nil}, :bufs {:b1 [1359], :b2 [1358]}} :line 327}
{:clk 2076.8304 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1360, :m2 1359, :m3 1358}, :bufs {:b1 [], :b2 []}} :line 328}
{:clk 2076.8304 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1358 :dets {:run {:m1 1360, :m2 1359, :m3 nil}, :bufs {:b1 [], :b2 [1358]}} :line 329}
{:clk 2077.8304 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2073.0436 :j 1358 :dets {:run {:m1 1360, :m2 1359, :m3 1358}, :bufs {:b1 [], :b2 []}} :line 330}
{:clk 2077.8304 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1360, :m2 1359, :m3 nil}, :bufs {:b1 [], :b2 []}} :line 331}
{:clk 2078.3304 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1360 :dets {:run {:m1 1360, :m2 1359, :m3 nil}, :bufs {:b1 [], :b2 []}} :line 332}
{:clk 2078.3304 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2079.8304 :j 1361 :dets {:run {:m1 nil, :m2 1359, :m3 nil}, :bufs {:b1 [1360], :b2 []}} :line 333}
{:clk 2079.8304 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1361 :dets {:run {:m1 1361, :m2 1359, :m3 nil}, :bufs {:b1 [1360], :b2 []}} :line 334}
{:clk 2079.8304 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2080.8304 :j 1362 :dets {:run {:m1 nil, :m2 1359, :m3 nil}, :bufs {:b1 [1360 1361], :b2 []}} :line 335}
{:clk 2080.8304 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1362, :m2 1359, :m3 nil}, :bufs {:b1 [1360 1361], :b2 []}} :line 336}
{:clk 2081.8954 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1359 :dets {:run {:m1 1362, :m2 1360, :m3 nil}, :bufs {:b1 [1361], :b2 [1359]}} :line 337}
{:clk 2081.8954 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1359 :dets {:run {:m1 1362, :m2 1359, :m3 nil}, :bufs {:b1 [1360 1361], :b2 []}} :line 338}
{:clk 2081.8954 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1360 :dets {:run {:m1 1362, :m2 nil, :m3 nil}, :bufs {:b1 [1360 1361], :b2 [1359]}} :line 339}
{:clk 2081.8954 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1362, :m2 1360, :m3 1359}, :bufs {:b1 [1361], :b2 []}} :line 340}
{:clk 2081.8954 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1360, :m3 1359}, :bufs {:b1 [1361 1362], :b2 []}} :line 341}
{:clk 2081.8954 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1362 :dets {:run {:m1 1362, :m2 1360, :m3 1359}, :bufs {:b1 [1361], :b2 []}} :line 342}
{:clk 2081.8954 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2082.8954 :j 1363 :dets {:run {:m1 nil, :m2 1360, :m3 1359}, :bufs {:b1 [1361 1362], :b2 []}} :line 343}
{:clk 2082.8954 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1363, :m2 1360, :m3 nil}, :bufs {:b1 [1361 1362], :b2 []}} :line 344}
{:clk 2082.8954 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1363, :m2 1360, :m3 nil}, :bufs {:b1 [1361 1362], :b2 []}} :line 345}
{:clk 2082.8954 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2075.8304 :j 1359 :dets {:run {:m1 1363, :m2 1360, :m3 1359}, :bufs {:b1 [1361 1362], :b2 []}} :line 346}
{:clk 2083.3954 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1360 :dets {:run {:m1 1363, :m2 1361, :m3 nil}, :bufs {:b1 [1362], :b2 [1360]}} :line 347}
{:clk 2083.3954 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1360 :dets {:run {:m1 1363, :m2 1360, :m3 nil}, :bufs {:b1 [1361 1362], :b2 []}} :line 348}
{:clk 2083.3954 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1361 :dets {:run {:m1 1363, :m2 nil, :m3 nil}, :bufs {:b1 [1361 1362], :b2 [1360]}} :line 349}
{:clk 2083.3954 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1363, :m2 1361, :m3 1360}, :bufs {:b1 [1362], :b2 []}} :line 350}
{:clk 2083.3954 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1361, :m3 1360}, :bufs {:b1 [1362 1363], :b2 []}} :line 351}
{:clk 2083.3954 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1363 :dets {:run {:m1 1363, :m2 1361, :m3 1360}, :bufs {:b1 [1362], :b2 []}} :line 352}
{:clk 2083.3954 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2084.3954 :j 1364 :dets {:run {:m1 nil, :m2 1361, :m3 1360}, :bufs {:b1 [1362 1363], :b2 []}} :line 353}
{:clk 2084.3954 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1364, :m2 1361, :m3 1360}, :bufs {:b1 [1362 1363], :b2 []}} :line 354}
{:clk 2084.8954 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2076.8304 :j 1360 :dets {:run {:m1 1364, :m2 nil, :m3 1360}, :bufs {:b1 [1362 1363], :b2 [1361]}} :line 355}
{:clk 2084.8954 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1361 :dets {:run {:m1 1364, :m2 1362, :m3 nil}, :bufs {:b1 [1363], :b2 [1361]}} :line 356}
{:clk 2084.8954 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1361 :dets {:run {:m1 1364, :m2 1361, :m3 1360}, :bufs {:b1 [1362 1363], :b2 []}} :line 357}
{:clk 2084.8954 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1362 :dets {:run {:m1 1364, :m2 nil, :m3 nil}, :bufs {:b1 [1362 1363], :b2 [1361]}} :line 358}
{:clk 2084.8954 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1362, :m3 1361}, :bufs {:b1 [1363 1364], :b2 []}} :line 359}
{:clk 2084.8954 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1364 :dets {:run {:m1 1364, :m2 1362, :m3 1361}, :bufs {:b1 [1363], :b2 []}} :line 360}
{:clk 2084.8954 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2085.8954 :j 1365 :dets {:run {:m1 nil, :m2 1362, :m3 1361}, :bufs {:b1 [1363 1364], :b2 []}} :line 361}
{:clk 2085.8954 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1365 :dets {:run {:m1 1365, :m2 1363, :m3 1361}, :bufs {:b1 [1364], :b2 [1362]}} :line 362}
{:clk 2085.8954 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2086.8954 :j 1366 :dets {:run {:m1 nil, :m2 1363, :m3 1361}, :bufs {:b1 [1364 1365], :b2 [1362]}} :line 363}
{:clk 2085.8954 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1362 :dets {:run {:m1 1365, :m2 1362, :m3 1361}, :bufs {:b1 [1363 1364], :b2 []}} :line 364}
{:clk 2085.8954 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1363 :dets {:run {:m1 1365, :m2 nil, :m3 1361}, :bufs {:b1 [1363 1364], :b2 [1362]}} :line 365}
{:clk 2086.3954 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2078.3304 :j 1361 :dets {:run {:m1 1366, :m2 1363, :m3 1361}, :bufs {:b1 [1364 1365], :b2 [1362]}} :line 366}
{:clk 2086.3954 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1362 :dets {:run {:m1 1366, :m2 1363, :m3 nil}, :bufs {:b1 [1364 1365], :b2 [1362]}} :line 367}
{:clk 2086.8954 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1366 :dets {:run {:m1 1366, :m2 1364, :m3 1362}, :bufs {:b1 [1365], :b2 [1363]}} :line 368}
{:clk 2086.8954 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2087.8954 :j 1367 :dets {:run {:m1 nil, :m2 1364, :m3 1362}, :bufs {:b1 [1365 1366], :b2 [1363]}} :line 369}
{:clk 2086.8954 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1363 :dets {:run {:m1 1366, :m2 1363, :m3 1362}, :bufs {:b1 [1364 1365], :b2 []}} :line 370}
{:clk 2086.8954 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1364 :dets {:run {:m1 1366, :m2 nil, :m3 1362}, :bufs {:b1 [1364 1365], :b2 [1363]}} :line 371}
{:clk 2087.3954 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2079.8304 :j 1362 :dets {:run {:m1 1367, :m2 1364, :m3 1362}, :bufs {:b1 [1365 1366], :b2 [1363]}} :line 372}
{:clk 2087.3954 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1363 :dets {:run {:m1 1367, :m2 1364, :m3 nil}, :bufs {:b1 [1365 1366], :b2 [1363]}} :line 373}
{:clk 2087.8954 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1367, :m2 1364, :m3 1363}, :bufs {:b1 [1365 1366], :b2 []}} :line 374}
{:clk 2088.3954 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2081.8954 :j 1363 :dets {:run {:m1 1367, :m2 1364, :m3 1363}, :bufs {:b1 [1365 1366], :b2 []}} :line 375}
{:clk 2088.3954 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1367, :m2 1364, :m3 nil}, :bufs {:b1 [1365 1366], :b2 []}} :line 376}
{:clk 2088.7128 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1364 :dets {:run {:m1 1367, :m2 1365, :m3 nil}, :bufs {:b1 [1366], :b2 [1364]}} :line 377}
{:clk 2088.7128 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1364 :dets {:run {:m1 1367, :m2 1364, :m3 nil}, :bufs {:b1 [1365 1366], :b2 []}} :line 378}
{:clk 2088.7128 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1365 :dets {:run {:m1 1367, :m2 nil, :m3 nil}, :bufs {:b1 [1365 1366], :b2 [1364]}} :line 379}
{:clk 2088.7128 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1367, :m2 1365, :m3 1364}, :bufs {:b1 [1366], :b2 []}} :line 380}
{:clk 2088.7128 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1365, :m3 1364}, :bufs {:b1 [1366 1367], :b2 []}} :line 381}
{:clk 2088.7128 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1367 :dets {:run {:m1 1367, :m2 1365, :m3 1364}, :bufs {:b1 [1366], :b2 []}} :line 382}
{:clk 2088.7128 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2089.7128 :j 1368 :dets {:run {:m1 nil, :m2 1365, :m3 1364}, :bufs {:b1 [1366 1367], :b2 []}} :line 383}
{:clk 2089.7128 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1368 :dets {:run {:m1 1368, :m2 1366, :m3 1365}, :bufs {:b1 [1367], :b2 []}} :line 384}
{:clk 2089.7128 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2091.2128 :j 1369 :dets {:run {:m1 nil, :m2 1366, :m3 1365}, :bufs {:b1 [1367 1368], :b2 []}} :line 385}
{:clk 2089.7128 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1365 :dets {:run {:m1 1368, :m2 1365, :m3 1364}, :bufs {:b1 [1366 1367], :b2 []}} :line 386}
{:clk 2089.7128 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1366 :dets {:run {:m1 1368, :m2 nil, :m3 nil}, :bufs {:b1 [1366 1367], :b2 [1365]}} :line 387}
{:clk 2089.7128 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2083.3954 :j 1364 :dets {:run {:m1 1368, :m2 nil, :m3 1364}, :bufs {:b1 [1366 1367], :b2 [1365]}} :line 388}
{:clk 2089.7128 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1365 :dets {:run {:m1 1368, :m2 1366, :m3 nil}, :bufs {:b1 [1367], :b2 [1365]}} :line 389}
{:clk 2090.7128 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1366 :dets {:run {:m1 1369, :m2 1366, :m3 1365}, :bufs {:b1 [1367 1368], :b2 []}} :line 390}
{:clk 2090.7128 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1367 :dets {:run {:m1 1369, :m2 nil, :m3 nil}, :bufs {:b1 [1367 1368], :b2 [1366]}} :line 391}
{:clk 2090.7128 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2084.8954 :j 1365 :dets {:run {:m1 1369, :m2 nil, :m3 1365}, :bufs {:b1 [1367 1368], :b2 [1366]}} :line 392}
{:clk 2090.7128 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1366 :dets {:run {:m1 1369, :m2 1367, :m3 nil}, :bufs {:b1 [1368], :b2 [1366]}} :line 393}
{:clk 2091.2128 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1369 :dets {:run {:m1 1369, :m2 1367, :m3 1366}, :bufs {:b1 [1368], :b2 []}} :line 394}
{:clk 2091.2128 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2092.2128 :j 1370 :dets {:run {:m1 nil, :m2 1367, :m3 1366}, :bufs {:b1 [1368 1369], :b2 []}} :line 395}
{:clk 2091.7128 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1367 :dets {:run {:m1 1370, :m2 1367, :m3 1366}, :bufs {:b1 [1368 1369], :b2 []}} :line 396}
{:clk 2091.7128 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1368 :dets {:run {:m1 1370, :m2 nil, :m3 nil}, :bufs {:b1 [1368 1369], :b2 [1367]}} :line 397}
{:clk 2091.7128 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2085.8954 :j 1366 :dets {:run {:m1 1370, :m2 nil, :m3 1366}, :bufs {:b1 [1368 1369], :b2 [1367]}} :line 398}
{:clk 2091.7128 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1367 :dets {:run {:m1 1370, :m2 1368, :m3 nil}, :bufs {:b1 [1369], :b2 [1367]}} :line 399}
{:clk 2092.2128 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1370 :dets {:run {:m1 1370, :m2 1368, :m3 1367}, :bufs {:b1 [1369], :b2 []}} :line 400}
{:clk 2092.2128 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2093.2128 :j 1371 :dets {:run {:m1 nil, :m2 1368, :m3 1367}, :bufs {:b1 [1369 1370], :b2 []}} :line 401}
{:clk 2092.7128 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1368 :dets {:run {:m1 1371, :m2 1368, :m3 1367}, :bufs {:b1 [1369 1370], :b2 []}} :line 402}
{:clk 2092.7128 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1369 :dets {:run {:m1 1371, :m2 nil, :m3 nil}, :bufs {:b1 [1369 1370], :b2 [1368]}} :line 403}
{:clk 2092.7128 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2086.8954 :j 1367 :dets {:run {:m1 1371, :m2 nil, :m3 1367}, :bufs {:b1 [1369 1370], :b2 [1368]}} :line 404}
{:clk 2092.7128 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1368 :dets {:run {:m1 1371, :m2 1369, :m3 nil}, :bufs {:b1 [1370], :b2 [1368]}} :line 405}
{:clk 2093.2128 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1371 :dets {:run {:m1 1371, :m2 1369, :m3 1368}, :bufs {:b1 [1370], :b2 []}} :line 406}
{:clk 2093.2128 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2094.7128 :j 1372 :dets {:run {:m1 nil, :m2 1369, :m3 1368}, :bufs {:b1 [1370 1371], :b2 []}} :line 407}
{:clk 2093.7128 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2088.7128 :j 1368 :dets {:run {:m1 1372, :m2 1369, :m3 1368}, :bufs {:b1 [1370 1371], :b2 []}} :line 408}
{:clk 2093.7128 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1372, :m2 1369, :m3 nil}, :bufs {:b1 [1370 1371], :b2 []}} :line 409}
{:clk 2094.7128 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1372, :m2 1369, :m3 nil}, :bufs {:b1 [1370 1371], :b2 []}} :line 410}
{:clk 2096.3173 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1369 :dets {:run {:m1 1372, :m2 1370, :m3 nil}, :bufs {:b1 [1371], :b2 [1369]}} :line 411}
{:clk 2096.3173 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1369 :dets {:run {:m1 1372, :m2 1369, :m3 nil}, :bufs {:b1 [1370 1371], :b2 []}} :line 412}
{:clk 2096.3173 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1370 :dets {:run {:m1 1372, :m2 nil, :m3 nil}, :bufs {:b1 [1370 1371], :b2 [1369]}} :line 413}
{:clk 2096.3173 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1372, :m2 1370, :m3 1369}, :bufs {:b1 [1371], :b2 []}} :line 414}
{:clk 2096.3173 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1370, :m3 1369}, :bufs {:b1 [1371 1372], :b2 []}} :line 415}
{:clk 2096.3173 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1372 :dets {:run {:m1 1372, :m2 1370, :m3 1369}, :bufs {:b1 [1371], :b2 []}} :line 416}
{:clk 2096.3173 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2097.3173 :j 1373 :dets {:run {:m1 nil, :m2 1370, :m3 1369}, :bufs {:b1 [1371 1372], :b2 []}} :line 417}
{:clk 2097.3173 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1373 :dets {:run {:m1 1373, :m2 1371, :m3 1369}, :bufs {:b1 [1372], :b2 [1370]}} :line 418}
{:clk 2097.3173 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2098.3173 :j 1374 :dets {:run {:m1 nil, :m2 1371, :m3 1369}, :bufs {:b1 [1372 1373], :b2 [1370]}} :line 419}
{:clk 2097.3173 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1370 :dets {:run {:m1 1373, :m2 1370, :m3 1369}, :bufs {:b1 [1371 1372], :b2 []}} :line 420}
{:clk 2097.3173 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1371 :dets {:run {:m1 1373, :m2 nil, :m3 1369}, :bufs {:b1 [1371 1372], :b2 [1370]}} :line 421}
{:clk 2097.8173 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2089.7128 :j 1369 :dets {:run {:m1 1374, :m2 1371, :m3 1369}, :bufs {:b1 [1372 1373], :b2 [1370]}} :line 422}
{:clk 2097.8173 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1370 :dets {:run {:m1 1374, :m2 1371, :m3 nil}, :bufs {:b1 [1372 1373], :b2 [1370]}} :line 423}
{:clk 2098.3173 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1374 :dets {:run {:m1 1374, :m2 1372, :m3 1370}, :bufs {:b1 [1373], :b2 [1371]}} :line 424}
{:clk 2098.3173 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2099.3173 :j 1375 :dets {:run {:m1 nil, :m2 1372, :m3 1370}, :bufs {:b1 [1373 1374], :b2 [1371]}} :line 425}
{:clk 2098.3173 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1371 :dets {:run {:m1 1374, :m2 1371, :m3 1370}, :bufs {:b1 [1372 1373], :b2 []}} :line 426}
{:clk 2098.3173 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1372 :dets {:run {:m1 1374, :m2 nil, :m3 1370}, :bufs {:b1 [1372 1373], :b2 [1371]}} :line 427}
{:clk 2098.8173 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2091.2128 :j 1370 :dets {:run {:m1 1375, :m2 1372, :m3 1370}, :bufs {:b1 [1373 1374], :b2 [1371]}} :line 428}
{:clk 2098.8173 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1371 :dets {:run {:m1 1375, :m2 1372, :m3 nil}, :bufs {:b1 [1373 1374], :b2 [1371]}} :line 429}
{:clk 2099.3173 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1375, :m2 1372, :m3 1371}, :bufs {:b1 [1373 1374], :b2 []}} :line 430}
{:clk 2099.8173 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2092.2128 :j 1371 :dets {:run {:m1 1375, :m2 nil, :m3 1371}, :bufs {:b1 [1373 1374], :b2 [1372]}} :line 431}
{:clk 2099.8173 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1372 :dets {:run {:m1 1375, :m2 1373, :m3 nil}, :bufs {:b1 [1374], :b2 [1372]}} :line 432}
{:clk 2099.8173 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1372 :dets {:run {:m1 1375, :m2 1372, :m3 1371}, :bufs {:b1 [1373 1374], :b2 []}} :line 433}
{:clk 2099.8173 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1373 :dets {:run {:m1 1375, :m2 nil, :m3 nil}, :bufs {:b1 [1373 1374], :b2 [1372]}} :line 434}
{:clk 2099.8173 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1373, :m3 1372}, :bufs {:b1 [1374 1375], :b2 []}} :line 435}
{:clk 2099.8173 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1375 :dets {:run {:m1 1375, :m2 1373, :m3 1372}, :bufs {:b1 [1374], :b2 []}} :line 436}
{:clk 2099.8173 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2100.8173 :j 1376 :dets {:run {:m1 nil, :m2 1373, :m3 1372}, :bufs {:b1 [1374 1375], :b2 []}} :line 437}
{:clk 2100.8173 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1376 :dets {:run {:m1 1376, :m2 1374, :m3 1372}, :bufs {:b1 [1375], :b2 [1373]}} :line 438}
{:clk 2100.8173 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2102.3173 :j 1377 :dets {:run {:m1 nil, :m2 1374, :m3 1372}, :bufs {:b1 [1375 1376], :b2 [1373]}} :line 439}
{:clk 2100.8173 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1373 :dets {:run {:m1 1376, :m2 1373, :m3 1372}, :bufs {:b1 [1374 1375], :b2 []}} :line 440}
{:clk 2100.8173 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1374 :dets {:run {:m1 1376, :m2 nil, :m3 1372}, :bufs {:b1 [1374 1375], :b2 [1373]}} :line 441}
{:clk 2101.3173 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2093.2128 :j 1372 :dets {:run {:m1 1377, :m2 1374, :m3 1372}, :bufs {:b1 [1375 1376], :b2 [1373]}} :line 442}
{:clk 2101.3173 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1373 :dets {:run {:m1 1377, :m2 1374, :m3 nil}, :bufs {:b1 [1375 1376], :b2 [1373]}} :line 443}
{:clk 2102.2063 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1374 :dets {:run {:m1 1377, :m2 1374, :m3 1373}, :bufs {:b1 [1375 1376], :b2 []}} :line 444}
{:clk 2102.2063 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1375 :dets {:run {:m1 1377, :m2 nil, :m3 1373}, :bufs {:b1 [1375 1376], :b2 [1374]}} :line 445}
{:clk 2102.3173 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1377 :dets {:run {:m1 1377, :m2 1375, :m3 1373}, :bufs {:b1 [1376], :b2 [1374]}} :line 446}
{:clk 2102.3173 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2103.8173 :j 1378 :dets {:run {:m1 nil, :m2 1375, :m3 nil}, :bufs {:b1 [1376 1377], :b2 [1374]}} :line 447}
{:clk 2102.3173 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2096.3173 :j 1373 :dets {:run {:m1 nil, :m2 1375, :m3 1373}, :bufs {:b1 [1376 1377], :b2 [1374]}} :line 448}
{:clk 2102.3173 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1374 :dets {:run {:m1 1378, :m2 1375, :m3 nil}, :bufs {:b1 [1376 1377], :b2 [1374]}} :line 449}
{:clk 2103.2063 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1375 :dets {:run {:m1 1378, :m2 1375, :m3 1374}, :bufs {:b1 [1376 1377], :b2 []}} :line 450}
{:clk 2103.2063 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1376 :dets {:run {:m1 1378, :m2 nil, :m3 1374}, :bufs {:b1 [1376 1377], :b2 [1375]}} :line 451}
{:clk 2103.3173 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2097.3173 :j 1374 :dets {:run {:m1 1378, :m2 1376, :m3 1374}, :bufs {:b1 [1377], :b2 [1375]}} :line 452}
{:clk 2103.3173 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1375 :dets {:run {:m1 1378, :m2 1376, :m3 nil}, :bufs {:b1 [1377], :b2 [1375]}} :line 453}
{:clk 2103.8173 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1378 :dets {:run {:m1 1378, :m2 1376, :m3 1375}, :bufs {:b1 [1377], :b2 []}} :line 454}
{:clk 2103.8173 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2104.8173 :j 1379 :dets {:run {:m1 nil, :m2 1376, :m3 1375}, :bufs {:b1 [1377 1378], :b2 []}} :line 455}
{:clk 2104.2170 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1376 :dets {:run {:m1 1379, :m2 1376, :m3 1375}, :bufs {:b1 [1377 1378], :b2 []}} :line 456}
{:clk 2104.2170 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1377 :dets {:run {:m1 1379, :m2 nil, :m3 1375}, :bufs {:b1 [1377 1378], :b2 [1376]}} :line 457}
{:clk 2104.3173 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2098.3173 :j 1375 :dets {:run {:m1 1379, :m2 1377, :m3 1375}, :bufs {:b1 [1378], :b2 [1376]}} :line 458}
{:clk 2104.3173 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1376 :dets {:run {:m1 1379, :m2 1377, :m3 nil}, :bufs {:b1 [1378], :b2 [1376]}} :line 459}
{:clk 2104.8173 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1379 :dets {:run {:m1 1379, :m2 1377, :m3 1376}, :bufs {:b1 [1378], :b2 []}} :line 460}
{:clk 2104.8173 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2106.3173 :j 1380 :dets {:run {:m1 nil, :m2 1377, :m3 1376}, :bufs {:b1 [1378 1379], :b2 []}} :line 461}
{:clk 2105.3173 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2099.8173 :j 1376 :dets {:run {:m1 1380, :m2 1377, :m3 1376}, :bufs {:b1 [1378 1379], :b2 []}} :line 462}
{:clk 2105.3173 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1380, :m2 1377, :m3 nil}, :bufs {:b1 [1378 1379], :b2 []}} :line 463}
{:clk 2105.7170 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1377 :dets {:run {:m1 1380, :m2 1377, :m3 nil}, :bufs {:b1 [1378 1379], :b2 []}} :line 464}
{:clk 2105.7170 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1378 :dets {:run {:m1 1380, :m2 nil, :m3 nil}, :bufs {:b1 [1378 1379], :b2 [1377]}} :line 465}
{:clk 2105.7170 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1380, :m2 1378, :m3 1377}, :bufs {:b1 [1379], :b2 []}} :line 466}
{:clk 2105.7170 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1377 :dets {:run {:m1 1380, :m2 1378, :m3 nil}, :bufs {:b1 [1379], :b2 [1377]}} :line 467}
{:clk 2106.3173 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1380 :dets {:run {:m1 1380, :m2 1378, :m3 1377}, :bufs {:b1 [1379], :b2 []}} :line 468}
{:clk 2106.3173 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2107.3173 :j 1381 :dets {:run {:m1 nil, :m2 1378, :m3 1377}, :bufs {:b1 [1379 1380], :b2 []}} :line 469}
{:clk 2107.2170 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1378 :dets {:run {:m1 1381, :m2 1378, :m3 1377}, :bufs {:b1 [1379 1380], :b2 []}} :line 470}
{:clk 2107.2170 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1379 :dets {:run {:m1 1381, :m2 nil, :m3 nil}, :bufs {:b1 [1379 1380], :b2 [1378]}} :line 471}
{:clk 2107.2170 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2100.8173 :j 1377 :dets {:run {:m1 1381, :m2 nil, :m3 1377}, :bufs {:b1 [1379 1380], :b2 [1378]}} :line 472}
{:clk 2107.2170 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1378 :dets {:run {:m1 1381, :m2 1379, :m3 nil}, :bufs {:b1 [1380], :b2 [1378]}} :line 473}
{:clk 2107.3173 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1381 :dets {:run {:m1 1381, :m2 1379, :m3 1378}, :bufs {:b1 [1380], :b2 []}} :line 474}
{:clk 2107.3173 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2108.8173 :j 1382 :dets {:run {:m1 nil, :m2 1379, :m3 1378}, :bufs {:b1 [1380 1381], :b2 []}} :line 475}
{:clk 2108.2170 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1379 :dets {:run {:m1 1382, :m2 1379, :m3 1378}, :bufs {:b1 [1380 1381], :b2 []}} :line 476}
{:clk 2108.2170 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1380 :dets {:run {:m1 1382, :m2 nil, :m3 1378}, :bufs {:b1 [1380 1381], :b2 [1379]}} :line 477}
{:clk 2108.7170 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2102.3173 :j 1378 :dets {:run {:m1 1382, :m2 1380, :m3 1378}, :bufs {:b1 [1381], :b2 [1379]}} :line 478}
{:clk 2108.7170 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1379 :dets {:run {:m1 1382, :m2 1380, :m3 nil}, :bufs {:b1 [1381], :b2 [1379]}} :line 479}
{:clk 2108.8173 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1382 :dets {:run {:m1 1382, :m2 1380, :m3 1379}, :bufs {:b1 [1381], :b2 []}} :line 480}
{:clk 2108.8173 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2109.8173 :j 1383 :dets {:run {:m1 nil, :m2 1380, :m3 1379}, :bufs {:b1 [1381 1382], :b2 []}} :line 481}
{:clk 2109.7170 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1380 :dets {:run {:m1 1383, :m2 1380, :m3 1379}, :bufs {:b1 [1381 1382], :b2 []}} :line 482}
{:clk 2109.7170 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1381 :dets {:run {:m1 1383, :m2 nil, :m3 nil}, :bufs {:b1 [1381 1382], :b2 [1380]}} :line 483}
{:clk 2109.7170 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2103.8173 :j 1379 :dets {:run {:m1 1383, :m2 nil, :m3 1379}, :bufs {:b1 [1381 1382], :b2 [1380]}} :line 484}
{:clk 2109.7170 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1380 :dets {:run {:m1 1383, :m2 1381, :m3 nil}, :bufs {:b1 [1382], :b2 [1380]}} :line 485}
{:clk 2109.8173 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1383 :dets {:run {:m1 1383, :m2 1381, :m3 1380}, :bufs {:b1 [1382], :b2 []}} :line 486}
{:clk 2109.8173 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2110.8173 :j 1384 :dets {:run {:m1 nil, :m2 1381, :m3 1380}, :bufs {:b1 [1382 1383], :b2 []}} :line 487}
{:clk 2110.7170 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1381 :dets {:run {:m1 1384, :m2 1381, :m3 1380}, :bufs {:b1 [1382 1383], :b2 []}} :line 488}
{:clk 2110.7170 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1382 :dets {:run {:m1 1384, :m2 nil, :m3 1380}, :bufs {:b1 [1382 1383], :b2 [1381]}} :line 489}
{:clk 2110.8173 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1384 :dets {:run {:m1 1384, :m2 1382, :m3 1380}, :bufs {:b1 [1383], :b2 [1381]}} :line 490}
{:clk 2110.8173 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2111.8173 :j 1385 :dets {:run {:m1 nil, :m2 1382, :m3 1380}, :bufs {:b1 [1383 1384], :b2 [1381]}} :line 491}
{:clk 2111.2170 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2104.8173 :j 1380 :dets {:run {:m1 1385, :m2 1382, :m3 1380}, :bufs {:b1 [1383 1384], :b2 [1381]}} :line 492}
{:clk 2111.2170 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1381 :dets {:run {:m1 1385, :m2 1382, :m3 nil}, :bufs {:b1 [1383 1384], :b2 [1381]}} :line 493}
{:clk 2111.8173 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1385, :m2 1382, :m3 1381}, :bufs {:b1 [1383 1384], :b2 []}} :line 494}
{:clk 2112.2170 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2106.3173 :j 1381 :dets {:run {:m1 1385, :m2 nil, :m3 1381}, :bufs {:b1 [1383 1384], :b2 [1382]}} :line 495}
{:clk 2112.2170 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1382 :dets {:run {:m1 1385, :m2 1383, :m3 nil}, :bufs {:b1 [1384], :b2 [1382]}} :line 496}
{:clk 2112.2170 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1382 :dets {:run {:m1 1385, :m2 1382, :m3 1381}, :bufs {:b1 [1383 1384], :b2 []}} :line 497}
{:clk 2112.2170 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1383 :dets {:run {:m1 1385, :m2 nil, :m3 nil}, :bufs {:b1 [1383 1384], :b2 [1382]}} :line 498}
{:clk 2112.2170 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1383, :m3 1382}, :bufs {:b1 [1384 1385], :b2 []}} :line 499}
{:clk 2112.2170 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1385 :dets {:run {:m1 1385, :m2 1383, :m3 1382}, :bufs {:b1 [1384], :b2 []}} :line 500}
{:clk 2112.2170 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2115.9322 :j 1386 :dets {:run {:m1 nil, :m2 1383, :m3 1382}, :bufs {:b1 [1384 1385], :b2 []}} :line 501}
{:clk 2113.2170 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1383 :dets {:run {:m1 1386, :m2 1383, :m3 1382}, :bufs {:b1 [1384 1385], :b2 []}} :line 502}
{:clk 2113.2170 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1384 :dets {:run {:m1 1386, :m2 nil, :m3 1382}, :bufs {:b1 [1384 1385], :b2 [1383]}} :line 503}
{:clk 2113.7430 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2107.3173 :j 1382 :dets {:run {:m1 1386, :m2 1384, :m3 1382}, :bufs {:b1 [1385], :b2 [1383]}} :line 504}
{:clk 2113.7430 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1383 :dets {:run {:m1 1386, :m2 1384, :m3 nil}, :bufs {:b1 [1385], :b2 [1383]}} :line 505}
{:clk 2114.2170 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1384 :dets {:run {:m1 1386, :m2 1384, :m3 1383}, :bufs {:b1 [1385], :b2 []}} :line 506}
{:clk 2114.2170 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1385 :dets {:run {:m1 1386, :m2 nil, :m3 1383}, :bufs {:b1 [1385], :b2 [1384]}} :line 507}
{:clk 2114.7430 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2108.8173 :j 1383 :dets {:run {:m1 1386, :m2 1385, :m3 1383}, :bufs {:b1 [], :b2 [1384]}} :line 508}
{:clk 2114.7430 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1384 :dets {:run {:m1 1386, :m2 1385, :m3 nil}, :bufs {:b1 [], :b2 [1384]}} :line 509}
{:clk 2115.2170 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1385 :dets {:run {:m1 1386, :m2 1385, :m3 1384}, :bufs {:b1 [], :b2 []}} :line 510}
{:clk 2115.2170 :act :m2-starved :m :m2 :mjpact :st :dets {:run {:m1 1386, :m2 nil, :m3 1384}, :bufs {:b1 [], :b2 [1385]}} :line 511}
{:clk 2115.7430 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2109.8173 :j 1384 :dets {:run {:m1 1386, :m2 nil, :m3 1384}, :bufs {:b1 [], :b2 [1385]}} :line 512}
{:clk 2115.7430 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1385 :dets {:run {:m1 1386, :m2 nil, :m3 nil}, :bufs {:b1 [], :b2 [1385]}} :line 513}
{:clk 2115.9322 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1386 :dets {:run {:m1 1386, :m2 nil, :m3 1385}, :bufs {:b1 [], :b2 []}} :line 514}
{:clk 2115.9322 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2117.4322 :j 1387 :dets {:run {:m1 nil, :m2 nil, :m3 1385}, :bufs {:b1 [1386], :b2 []}} :line 515}
{:clk 2115.9322 :act :m2-unstarved :m :m2 :mjpact :us :dets {:run {:m1 1387, :m2 1386, :m3 1385}, :bufs {:b1 [], :b2 []}} :line 516}
{:clk 2115.9322 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1386 :dets {:run {:m1 1387, :m2 nil, :m3 1385}, :bufs {:b1 [1386], :b2 []}} :line 517}
{:clk 2117.4322 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1387 :dets {:run {:m1 1387, :m2 1386, :m3 1385}, :bufs {:b1 [], :b2 []}} :line 518}
{:clk 2117.4322 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2118.9322 :j 1388 :dets {:run {:m1 nil, :m2 nil, :m3 1385}, :bufs {:b1 [1387], :b2 [1386]}} :line 519}
{:clk 2117.4322 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1386 :dets {:run {:m1 nil, :m2 1386, :m3 1385}, :bufs {:b1 [1387], :b2 []}} :line 520}
{:clk 2117.4322 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1387 :dets {:run {:m1 1388, :m2 nil, :m3 1385}, :bufs {:b1 [1387], :b2 [1386]}} :line 521}
{:clk 2117.4771 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2110.8173 :j 1385 :dets {:run {:m1 1388, :m2 1387, :m3 1385}, :bufs {:b1 [], :b2 [1386]}} :line 522}
{:clk 2117.4771 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1386 :dets {:run {:m1 1388, :m2 1387, :m3 nil}, :bufs {:b1 [], :b2 [1386]}} :line 523}
{:clk 2118.9322 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1388 :dets {:run {:m1 1388, :m2 1387, :m3 1386}, :bufs {:b1 [], :b2 []}} :line 524}
{:clk 2118.9322 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2120.4322 :j 1389 :dets {:run {:m1 nil, :m2 nil, :m3 1386}, :bufs {:b1 [1388], :b2 [1387]}} :line 525}
{:clk 2118.9322 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1387 :dets {:run {:m1 nil, :m2 1387, :m3 1386}, :bufs {:b1 [1388], :b2 []}} :line 526}
{:clk 2118.9322 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1388 :dets {:run {:m1 1389, :m2 nil, :m3 1386}, :bufs {:b1 [1388], :b2 [1387]}} :line 527}
{:clk 2119.3383 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2112.217 :j 1386 :dets {:run {:m1 1389, :m2 1388, :m3 1386}, :bufs {:b1 [], :b2 [1387]}} :line 528}
{:clk 2119.3383 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1387 :dets {:run {:m1 1389, :m2 1388, :m3 nil}, :bufs {:b1 [], :b2 [1387]}} :line 529}
{:clk 2120.4322 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1389 :dets {:run {:m1 1389, :m2 1388, :m3 1387}, :bufs {:b1 [], :b2 []}} :line 530}
{:clk 2120.4322 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2121.4322 :j 1390 :dets {:run {:m1 nil, :m2 nil, :m3 1387}, :bufs {:b1 [1389], :b2 [1388]}} :line 531}
{:clk 2120.4322 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1388 :dets {:run {:m1 nil, :m2 1388, :m3 1387}, :bufs {:b1 [1389], :b2 []}} :line 532}
{:clk 2120.4322 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1389 :dets {:run {:m1 1390, :m2 nil, :m3 1387}, :bufs {:b1 [1389], :b2 [1388]}} :line 533}
{:clk 2120.8383 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2115.9322 :j 1387 :dets {:run {:m1 1390, :m2 1389, :m3 1387}, :bufs {:b1 [], :b2 [1388]}} :line 534}
{:clk 2120.8383 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1388 :dets {:run {:m1 1390, :m2 1389, :m3 nil}, :bufs {:b1 [], :b2 [1388]}} :line 535}
{:clk 2121.4322 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1390 :dets {:run {:m1 1390, :m2 1389, :m3 1388}, :bufs {:b1 [], :b2 []}} :line 536}
{:clk 2121.4322 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2122.9322 :j 1391 :dets {:run {:m1 nil, :m2 1389, :m3 1388}, :bufs {:b1 [1390], :b2 []}} :line 537}
{:clk 2121.9322 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1389 :dets {:run {:m1 1391, :m2 1389, :m3 1388}, :bufs {:b1 [1390], :b2 []}} :line 538}
{:clk 2121.9322 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1390 :dets {:run {:m1 1391, :m2 nil, :m3 1388}, :bufs {:b1 [1390], :b2 [1389]}} :line 539}
{:clk 2122.3383 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2117.4322 :j 1388 :dets {:run {:m1 1391, :m2 1390, :m3 1388}, :bufs {:b1 [], :b2 [1389]}} :line 540}
{:clk 2122.3383 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1389 :dets {:run {:m1 1391, :m2 1390, :m3 nil}, :bufs {:b1 [], :b2 [1389]}} :line 541}
{:clk 2122.9322 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1391 :dets {:run {:m1 1391, :m2 1390, :m3 1389}, :bufs {:b1 [], :b2 []}} :line 542}
{:clk 2122.9322 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2123.9322 :j 1392 :dets {:run {:m1 nil, :m2 nil, :m3 1389}, :bufs {:b1 [1391], :b2 [1390]}} :line 543}
{:clk 2122.9322 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1390 :dets {:run {:m1 nil, :m2 1390, :m3 1389}, :bufs {:b1 [1391], :b2 []}} :line 544}
{:clk 2122.9322 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1391 :dets {:run {:m1 1392, :m2 nil, :m3 1389}, :bufs {:b1 [1391], :b2 [1390]}} :line 545}
{:clk 2123.8383 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2118.9322 :j 1389 :dets {:run {:m1 1392, :m2 1391, :m3 1389}, :bufs {:b1 [], :b2 [1390]}} :line 546}
{:clk 2123.8383 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1390 :dets {:run {:m1 1392, :m2 1391, :m3 nil}, :bufs {:b1 [], :b2 [1390]}} :line 547}
{:clk 2123.9322 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1392 :dets {:run {:m1 1392, :m2 1391, :m3 1390}, :bufs {:b1 [], :b2 []}} :line 548}
{:clk 2123.9322 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2124.9322 :j 1393 :dets {:run {:m1 nil, :m2 1391, :m3 1390}, :bufs {:b1 [1392], :b2 []}} :line 549}
{:clk 2124.4322 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1391 :dets {:run {:m1 1393, :m2 1391, :m3 1390}, :bufs {:b1 [1392], :b2 []}} :line 550}
{:clk 2124.4322 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1392 :dets {:run {:m1 1393, :m2 nil, :m3 1390}, :bufs {:b1 [1392], :b2 [1391]}} :line 551}
{:clk 2124.8383 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2120.4322 :j 1390 :dets {:run {:m1 1393, :m2 1392, :m3 1390}, :bufs {:b1 [], :b2 [1391]}} :line 552}
{:clk 2124.8383 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1391 :dets {:run {:m1 1393, :m2 1392, :m3 nil}, :bufs {:b1 [], :b2 [1391]}} :line 553}
{:clk 2124.9322 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1393 :dets {:run {:m1 1393, :m2 1392, :m3 1391}, :bufs {:b1 [], :b2 []}} :line 554}
{:clk 2124.9322 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2126.4322 :j 1394 :dets {:run {:m1 nil, :m2 1392, :m3 1391}, :bufs {:b1 [1393], :b2 []}} :line 555}
{:clk 2125.4322 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1392 :dets {:run {:m1 1394, :m2 1392, :m3 1391}, :bufs {:b1 [1393], :b2 []}} :line 556}
{:clk 2125.4322 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1393 :dets {:run {:m1 1394, :m2 nil, :m3 1391}, :bufs {:b1 [1393], :b2 [1392]}} :line 557}
{:clk 2126.3383 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2121.4322 :j 1391 :dets {:run {:m1 1394, :m2 1393, :m3 1391}, :bufs {:b1 [], :b2 [1392]}} :line 558}
{:clk 2126.3383 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1392 :dets {:run {:m1 1394, :m2 1393, :m3 nil}, :bufs {:b1 [], :b2 [1392]}} :line 559}
{:clk 2126.4322 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1394 :dets {:run {:m1 1394, :m2 1393, :m3 1392}, :bufs {:b1 [], :b2 []}} :line 560}
{:clk 2126.4322 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2127.4322 :j 1395 :dets {:run {:m1 nil, :m2 nil, :m3 1392}, :bufs {:b1 [1394], :b2 [1393]}} :line 561}
{:clk 2126.4322 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1393 :dets {:run {:m1 nil, :m2 1393, :m3 1392}, :bufs {:b1 [1394], :b2 []}} :line 562}
{:clk 2126.4322 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1394 :dets {:run {:m1 1395, :m2 nil, :m3 1392}, :bufs {:b1 [1394], :b2 [1393]}} :line 563}
{:clk 2127.3383 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2122.9322 :j 1392 :dets {:run {:m1 1395, :m2 1394, :m3 1392}, :bufs {:b1 [], :b2 [1393]}} :line 564}
{:clk 2127.3383 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1393 :dets {:run {:m1 1395, :m2 1394, :m3 nil}, :bufs {:b1 [], :b2 [1393]}} :line 565}
{:clk 2127.4322 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1395 :dets {:run {:m1 1395, :m2 1394, :m3 1393}, :bufs {:b1 [], :b2 []}} :line 566}
{:clk 2127.4322 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2128.4322 :j 1396 :dets {:run {:m1 nil, :m2 1394, :m3 1393}, :bufs {:b1 [1395], :b2 []}} :line 567}
{:clk 2127.9322 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1394 :dets {:run {:m1 1396, :m2 1394, :m3 1393}, :bufs {:b1 [1395], :b2 []}} :line 568}
{:clk 2127.9322 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1395 :dets {:run {:m1 1396, :m2 nil, :m3 1393}, :bufs {:b1 [1395], :b2 [1394]}} :line 569}
{:clk 2128.3383 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2123.9322 :j 1393 :dets {:run {:m1 1396, :m2 1395, :m3 1393}, :bufs {:b1 [], :b2 [1394]}} :line 570}
{:clk 2128.3383 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1394 :dets {:run {:m1 1396, :m2 1395, :m3 nil}, :bufs {:b1 [], :b2 [1394]}} :line 571}
{:clk 2128.4322 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1396 :dets {:run {:m1 1396, :m2 1395, :m3 1394}, :bufs {:b1 [], :b2 []}} :line 572}
{:clk 2128.4322 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2129.4322 :j 1397 :dets {:run {:m1 nil, :m2 1395, :m3 1394}, :bufs {:b1 [1396], :b2 []}} :line 573}
{:clk 2128.9322 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1395 :dets {:run {:m1 1397, :m2 1395, :m3 1394}, :bufs {:b1 [1396], :b2 []}} :line 574}
{:clk 2128.9322 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1396 :dets {:run {:m1 1397, :m2 nil, :m3 1394}, :bufs {:b1 [1396], :b2 [1395]}} :line 575}
{:clk 2129.4322 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1397 :dets {:run {:m1 1397, :m2 1396, :m3 1394}, :bufs {:b1 [], :b2 [1395]}} :line 576}
{:clk 2129.4322 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2130.4322 :j 1398 :dets {:run {:m1 nil, :m2 1396, :m3 1394}, :bufs {:b1 [1397], :b2 [1395]}} :line 577}
{:clk 2129.8383 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2124.9322 :j 1394 :dets {:run {:m1 1398, :m2 1396, :m3 1394}, :bufs {:b1 [1397], :b2 [1395]}} :line 578}
{:clk 2129.8383 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1395 :dets {:run {:m1 1398, :m2 1396, :m3 nil}, :bufs {:b1 [1397], :b2 [1395]}} :line 579}
{:clk 2129.9322 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1396 :dets {:run {:m1 1398, :m2 1396, :m3 1395}, :bufs {:b1 [1397], :b2 []}} :line 580}
{:clk 2129.9322 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1397 :dets {:run {:m1 1398, :m2 nil, :m3 1395}, :bufs {:b1 [1397], :b2 [1396]}} :line 581}
{:clk 2130.4322 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1398 :dets {:run {:m1 1398, :m2 1397, :m3 1395}, :bufs {:b1 [], :b2 [1396]}} :line 582}
{:clk 2130.4322 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2131.4322 :j 1399 :dets {:run {:m1 nil, :m2 1397, :m3 1395}, :bufs {:b1 [1398], :b2 [1396]}} :line 583}
{:clk 2130.8383 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2126.4322 :j 1395 :dets {:run {:m1 1399, :m2 1397, :m3 1395}, :bufs {:b1 [1398], :b2 [1396]}} :line 584}
{:clk 2130.8383 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1396 :dets {:run {:m1 1399, :m2 1397, :m3 nil}, :bufs {:b1 [1398], :b2 [1396]}} :line 585}
{:clk 2130.9322 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1397 :dets {:run {:m1 1399, :m2 1397, :m3 1396}, :bufs {:b1 [1398], :b2 []}} :line 586}
{:clk 2130.9322 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1398 :dets {:run {:m1 1399, :m2 nil, :m3 1396}, :bufs {:b1 [1398], :b2 [1397]}} :line 587}
{:clk 2131.4322 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1399 :dets {:run {:m1 1399, :m2 1398, :m3 1396}, :bufs {:b1 [], :b2 [1397]}} :line 588}
{:clk 2131.4322 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2132.9322 :j 1400 :dets {:run {:m1 nil, :m2 1398, :m3 1396}, :bufs {:b1 [1399], :b2 [1397]}} :line 589}
{:clk 2131.8383 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2127.4322 :j 1396 :dets {:run {:m1 1400, :m2 1398, :m3 1396}, :bufs {:b1 [1399], :b2 [1397]}} :line 590}
{:clk 2131.8383 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1397 :dets {:run {:m1 1400, :m2 1398, :m3 nil}, :bufs {:b1 [1399], :b2 [1397]}} :line 591}
{:clk 2131.9322 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1398 :dets {:run {:m1 1400, :m2 1398, :m3 1397}, :bufs {:b1 [1399], :b2 []}} :line 592}
{:clk 2131.9322 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1399 :dets {:run {:m1 1400, :m2 nil, :m3 1397}, :bufs {:b1 [1399], :b2 [1398]}} :line 593}
{:clk 2132.8383 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2128.4322 :j 1397 :dets {:run {:m1 1400, :m2 1399, :m3 1397}, :bufs {:b1 [], :b2 [1398]}} :line 594}
{:clk 2132.8383 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1398 :dets {:run {:m1 1400, :m2 1399, :m3 nil}, :bufs {:b1 [], :b2 [1398]}} :line 595}
{:clk 2132.9322 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1400 :dets {:run {:m1 1400, :m2 1399, :m3 1398}, :bufs {:b1 [], :b2 []}} :line 596}
{:clk 2132.9322 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2134.4322 :j 1401 :dets {:run {:m1 nil, :m2 nil, :m3 1398}, :bufs {:b1 [1400], :b2 [1399]}} :line 597}
{:clk 2132.9322 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1399 :dets {:run {:m1 nil, :m2 1399, :m3 1398}, :bufs {:b1 [1400], :b2 []}} :line 598}
{:clk 2132.9322 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1400 :dets {:run {:m1 1401, :m2 nil, :m3 1398}, :bufs {:b1 [1400], :b2 [1399]}} :line 599}
{:clk 2133.8383 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2129.4322 :j 1398 :dets {:run {:m1 1401, :m2 1400, :m3 1398}, :bufs {:b1 [], :b2 [1399]}} :line 600}
{:clk 2133.8383 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1399 :dets {:run {:m1 1401, :m2 1400, :m3 nil}, :bufs {:b1 [], :b2 [1399]}} :line 601}
{:clk 2134.4322 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1401 :dets {:run {:m1 1401, :m2 1400, :m3 1399}, :bufs {:b1 [], :b2 []}} :line 602}
{:clk 2134.4322 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2135.4322 :j 1402 :dets {:run {:m1 nil, :m2 1400, :m3 1399}, :bufs {:b1 [1401], :b2 []}} :line 603}
{:clk 2134.5824 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1400 :dets {:run {:m1 1402, :m2 1400, :m3 1399}, :bufs {:b1 [1401], :b2 []}} :line 604}
{:clk 2134.5824 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1401 :dets {:run {:m1 1402, :m2 nil, :m3 1399}, :bufs {:b1 [1401], :b2 [1400]}} :line 605}
{:clk 2134.8383 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2130.4322 :j 1399 :dets {:run {:m1 1402, :m2 1401, :m3 1399}, :bufs {:b1 [], :b2 [1400]}} :line 606}
{:clk 2134.8383 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1400 :dets {:run {:m1 1402, :m2 1401, :m3 nil}, :bufs {:b1 [], :b2 [1400]}} :line 607}
{:clk 2135.4322 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1402 :dets {:run {:m1 1402, :m2 1401, :m3 1400}, :bufs {:b1 [], :b2 []}} :line 608}
{:clk 2135.4322 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2136.4322 :j 1403 :dets {:run {:m1 nil, :m2 1401, :m3 1400}, :bufs {:b1 [1402], :b2 []}} :line 609}
{:clk 2136.0824 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1401 :dets {:run {:m1 1403, :m2 1401, :m3 1400}, :bufs {:b1 [1402], :b2 []}} :line 610}
{:clk 2136.0824 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1402 :dets {:run {:m1 1403, :m2 nil, :m3 1400}, :bufs {:b1 [1402], :b2 [1401]}} :line 611}
{:clk 2136.3383 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2131.4322 :j 1400 :dets {:run {:m1 1403, :m2 1402, :m3 1400}, :bufs {:b1 [], :b2 [1401]}} :line 612}
{:clk 2136.3383 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1401 :dets {:run {:m1 1403, :m2 1402, :m3 nil}, :bufs {:b1 [], :b2 [1401]}} :line 613}
{:clk 2136.4322 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1403 :dets {:run {:m1 1403, :m2 1402, :m3 1401}, :bufs {:b1 [], :b2 []}} :line 614}
{:clk 2136.4322 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2137.4322 :j 1404 :dets {:run {:m1 nil, :m2 1402, :m3 1401}, :bufs {:b1 [1403], :b2 []}} :line 615}
{:clk 2137.0824 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1402 :dets {:run {:m1 1404, :m2 1402, :m3 1401}, :bufs {:b1 [1403], :b2 []}} :line 616}
{:clk 2137.0824 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1403 :dets {:run {:m1 1404, :m2 nil, :m3 1401}, :bufs {:b1 [1403], :b2 [1402]}} :line 617}
{:clk 2137.4322 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1404 :dets {:run {:m1 1404, :m2 1403, :m3 1401}, :bufs {:b1 [], :b2 [1402]}} :line 618}
{:clk 2137.4322 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2138.4322 :j 1405 :dets {:run {:m1 nil, :m2 1403, :m3 1401}, :bufs {:b1 [1404], :b2 [1402]}} :line 619}
{:clk 2137.8383 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2132.9322 :j 1401 :dets {:run {:m1 1405, :m2 1403, :m3 1401}, :bufs {:b1 [1404], :b2 [1402]}} :line 620}
{:clk 2137.8383 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1402 :dets {:run {:m1 1405, :m2 1403, :m3 nil}, :bufs {:b1 [1404], :b2 [1402]}} :line 621}
{:clk 2138.0824 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1403 :dets {:run {:m1 1405, :m2 1403, :m3 1402}, :bufs {:b1 [1404], :b2 []}} :line 622}
{:clk 2138.0824 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1404 :dets {:run {:m1 1405, :m2 nil, :m3 1402}, :bufs {:b1 [1404], :b2 [1403]}} :line 623}
{:clk 2138.4322 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1405 :dets {:run {:m1 1405, :m2 1404, :m3 1402}, :bufs {:b1 [], :b2 [1403]}} :line 624}
{:clk 2138.4322 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2139.4322 :j 1406 :dets {:run {:m1 nil, :m2 1404, :m3 1402}, :bufs {:b1 [1405], :b2 [1403]}} :line 625}
{:clk 2138.8383 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2134.4322 :j 1402 :dets {:run {:m1 1406, :m2 1404, :m3 1402}, :bufs {:b1 [1405], :b2 [1403]}} :line 626}
{:clk 2138.8383 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1403 :dets {:run {:m1 1406, :m2 1404, :m3 nil}, :bufs {:b1 [1405], :b2 [1403]}} :line 627}
{:clk 2139.0824 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1404 :dets {:run {:m1 1406, :m2 1404, :m3 1403}, :bufs {:b1 [1405], :b2 []}} :line 628}
{:clk 2139.0824 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1405 :dets {:run {:m1 1406, :m2 nil, :m3 1403}, :bufs {:b1 [1405], :b2 [1404]}} :line 629}
{:clk 2139.4322 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1406 :dets {:run {:m1 1406, :m2 1405, :m3 1403}, :bufs {:b1 [], :b2 [1404]}} :line 630}
{:clk 2139.4322 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2140.904 :j 1407 :dets {:run {:m1 nil, :m2 1405, :m3 1403}, :bufs {:b1 [1406], :b2 [1404]}} :line 631}
{:clk 2139.8383 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2135.4322 :j 1403 :dets {:run {:m1 1407, :m2 1405, :m3 1403}, :bufs {:b1 [1406], :b2 [1404]}} :line 632}
{:clk 2139.8383 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1404 :dets {:run {:m1 1407, :m2 1405, :m3 nil}, :bufs {:b1 [1406], :b2 [1404]}} :line 633}
{:clk 2140.0824 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1405 :dets {:run {:m1 1407, :m2 1405, :m3 1404}, :bufs {:b1 [1406], :b2 []}} :line 634}
{:clk 2140.0824 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1406 :dets {:run {:m1 1407, :m2 nil, :m3 1404}, :bufs {:b1 [1406], :b2 [1405]}} :line 635}
{:clk 2140.8383 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2136.4322 :j 1404 :dets {:run {:m1 1407, :m2 1406, :m3 1404}, :bufs {:b1 [], :b2 [1405]}} :line 636}
{:clk 2140.8383 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1405 :dets {:run {:m1 1407, :m2 1406, :m3 nil}, :bufs {:b1 [], :b2 [1405]}} :line 637}
{:clk 2140.9040 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1407 :dets {:run {:m1 1407, :m2 1406, :m3 1405}, :bufs {:b1 [], :b2 []}} :line 638}
{:clk 2140.9040 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2142.404 :j 1408 :dets {:run {:m1 nil, :m2 1406, :m3 1405}, :bufs {:b1 [1407], :b2 []}} :line 639}
{:clk 2141.0824 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1406 :dets {:run {:m1 1408, :m2 1406, :m3 1405}, :bufs {:b1 [1407], :b2 []}} :line 640}
{:clk 2141.0824 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1407 :dets {:run {:m1 1408, :m2 nil, :m3 1405}, :bufs {:b1 [1407], :b2 [1406]}} :line 641}
{:clk 2141.8383 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2137.4322 :j 1405 :dets {:run {:m1 1408, :m2 1407, :m3 1405}, :bufs {:b1 [], :b2 [1406]}} :line 642}
{:clk 2141.8383 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1406 :dets {:run {:m1 1408, :m2 1407, :m3 nil}, :bufs {:b1 [], :b2 [1406]}} :line 643}
{:clk 2142.0824 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1407 :dets {:run {:m1 1408, :m2 1407, :m3 1406}, :bufs {:b1 [], :b2 []}} :line 644}
{:clk 2142.0824 :act :m2-starved :m :m2 :mjpact :st :dets {:run {:m1 1408, :m2 nil, :m3 1406}, :bufs {:b1 [], :b2 [1407]}} :line 645}
{:clk 2142.4040 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1408 :dets {:run {:m1 1408, :m2 nil, :m3 1406}, :bufs {:b1 [], :b2 [1407]}} :line 646}
{:clk 2142.4040 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2143.404 :j 1409 :dets {:run {:m1 nil, :m2 nil, :m3 1406}, :bufs {:b1 [1408], :b2 [1407]}} :line 647}
{:clk 2142.4040 :act :m2-unstarved :m :m2 :mjpact :us :dets {:run {:m1 1409, :m2 1408, :m3 1406}, :bufs {:b1 [], :b2 [1407]}} :line 648}
{:clk 2142.4040 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1408 :dets {:run {:m1 1409, :m2 nil, :m3 1406}, :bufs {:b1 [1408], :b2 [1407]}} :line 649}
{:clk 2143.2275 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2138.4322 :j 1406 :dets {:run {:m1 1409, :m2 1408, :m3 1406}, :bufs {:b1 [], :b2 [1407]}} :line 650}
{:clk 2143.2275 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1407 :dets {:run {:m1 1409, :m2 1408, :m3 nil}, :bufs {:b1 [], :b2 [1407]}} :line 651}
{:clk 2143.4040 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1409 :dets {:run {:m1 1409, :m2 1408, :m3 1407}, :bufs {:b1 [], :b2 []}} :line 652}
{:clk 2143.4040 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2145.5908 :j 1410 :dets {:run {:m1 nil, :m2 1408, :m3 1407}, :bufs {:b1 [1409], :b2 []}} :line 653}
{:clk 2143.9040 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1408 :dets {:run {:m1 1410, :m2 1408, :m3 1407}, :bufs {:b1 [1409], :b2 []}} :line 654}
{:clk 2143.9040 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1409 :dets {:run {:m1 1410, :m2 nil, :m3 1407}, :bufs {:b1 [1409], :b2 [1408]}} :line 655}
{:clk 2144.2275 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2139.4322 :j 1407 :dets {:run {:m1 1410, :m2 1409, :m3 1407}, :bufs {:b1 [], :b2 [1408]}} :line 656}
{:clk 2144.2275 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1408 :dets {:run {:m1 1410, :m2 1409, :m3 nil}, :bufs {:b1 [], :b2 [1408]}} :line 657}
{:clk 2145.5908 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1410 :dets {:run {:m1 1410, :m2 1409, :m3 1408}, :bufs {:b1 [], :b2 []}} :line 658}
{:clk 2145.5908 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2146.5908 :j 1411 :dets {:run {:m1 nil, :m2 1409, :m3 1408}, :bufs {:b1 [1410], :b2 []}} :line 659}
{:clk 2145.7275 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2140.904 :j 1408 :dets {:run {:m1 1411, :m2 1409, :m3 1408}, :bufs {:b1 [1410], :b2 []}} :line 660}
{:clk 2145.7275 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1411, :m2 1409, :m3 nil}, :bufs {:b1 [1410], :b2 []}} :line 661}
{:clk 2146.2413 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1409 :dets {:run {:m1 1411, :m2 1409, :m3 nil}, :bufs {:b1 [1410], :b2 []}} :line 662}
{:clk 2146.2413 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1410 :dets {:run {:m1 1411, :m2 nil, :m3 nil}, :bufs {:b1 [1410], :b2 [1409]}} :line 663}
{:clk 2146.2413 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1411, :m2 1410, :m3 1409}, :bufs {:b1 [], :b2 []}} :line 664}
{:clk 2146.2413 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1409 :dets {:run {:m1 1411, :m2 1410, :m3 nil}, :bufs {:b1 [], :b2 [1409]}} :line 665}
{:clk 2146.5908 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1411 :dets {:run {:m1 1411, :m2 1410, :m3 1409}, :bufs {:b1 [], :b2 []}} :line 666}
{:clk 2146.5908 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2147.5908 :j 1412 :dets {:run {:m1 nil, :m2 1410, :m3 1409}, :bufs {:b1 [1411], :b2 []}} :line 667}
{:clk 2147.2413 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2142.404 :j 1409 :dets {:run {:m1 1412, :m2 1410, :m3 1409}, :bufs {:b1 [1411], :b2 []}} :line 668}
{:clk 2147.2413 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1412, :m2 1410, :m3 nil}, :bufs {:b1 [1411], :b2 []}} :line 669}
{:clk 2147.5908 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1412 :dets {:run {:m1 1412, :m2 1410, :m3 nil}, :bufs {:b1 [1411], :b2 []}} :line 670}
{:clk 2147.5908 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2148.5908 :j 1413 :dets {:run {:m1 nil, :m2 1410, :m3 nil}, :bufs {:b1 [1411 1412], :b2 []}} :line 671}
{:clk 2147.7413 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1410 :dets {:run {:m1 1413, :m2 1410, :m3 nil}, :bufs {:b1 [1411 1412], :b2 []}} :line 672}
{:clk 2147.7413 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1411 :dets {:run {:m1 1413, :m2 nil, :m3 nil}, :bufs {:b1 [1411 1412], :b2 [1410]}} :line 673}
{:clk 2147.7413 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1413, :m2 1411, :m3 1410}, :bufs {:b1 [1412], :b2 []}} :line 674}
{:clk 2147.7413 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1410 :dets {:run {:m1 1413, :m2 1411, :m3 nil}, :bufs {:b1 [1412], :b2 [1410]}} :line 675}
{:clk 2148.5908 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1413 :dets {:run {:m1 1413, :m2 1411, :m3 1410}, :bufs {:b1 [1412], :b2 []}} :line 676}
{:clk 2148.5908 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2150.0908 :j 1414 :dets {:run {:m1 nil, :m2 1411, :m3 1410}, :bufs {:b1 [1412 1413], :b2 []}} :line 677}
{:clk 2148.7413 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1411 :dets {:run {:m1 1414, :m2 1411, :m3 1410}, :bufs {:b1 [1412 1413], :b2 []}} :line 678}
{:clk 2148.7413 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1412 :dets {:run {:m1 1414, :m2 nil, :m3 1410}, :bufs {:b1 [1412 1413], :b2 [1411]}} :line 679}
{:clk 2149.2413 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2143.404 :j 1410 :dets {:run {:m1 1414, :m2 1412, :m3 1410}, :bufs {:b1 [1413], :b2 [1411]}} :line 680}
{:clk 2149.2413 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1411 :dets {:run {:m1 1414, :m2 1412, :m3 nil}, :bufs {:b1 [1413], :b2 [1411]}} :line 681}
{:clk 2149.7413 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1412 :dets {:run {:m1 1414, :m2 1412, :m3 1411}, :bufs {:b1 [1413], :b2 []}} :line 682}
{:clk 2149.7413 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1413 :dets {:run {:m1 1414, :m2 nil, :m3 1411}, :bufs {:b1 [1413], :b2 [1412]}} :line 683}
{:clk 2150.0908 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1414 :dets {:run {:m1 1414, :m2 1413, :m3 1411}, :bufs {:b1 [], :b2 [1412]}} :line 684}
{:clk 2150.0908 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2151.5908 :j 1415 :dets {:run {:m1 nil, :m2 1413, :m3 1411}, :bufs {:b1 [1414], :b2 [1412]}} :line 685}
{:clk 2150.2413 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2145.5908 :j 1411 :dets {:run {:m1 1415, :m2 1413, :m3 1411}, :bufs {:b1 [1414], :b2 [1412]}} :line 686}
{:clk 2150.2413 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1412 :dets {:run {:m1 1415, :m2 1413, :m3 nil}, :bufs {:b1 [1414], :b2 [1412]}} :line 687}
{:clk 2150.7413 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1413 :dets {:run {:m1 1415, :m2 1413, :m3 1412}, :bufs {:b1 [1414], :b2 []}} :line 688}
{:clk 2150.7413 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1414 :dets {:run {:m1 1415, :m2 nil, :m3 1412}, :bufs {:b1 [1414], :b2 [1413]}} :line 689}
{:clk 2151.5908 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1415 :dets {:run {:m1 1415, :m2 1414, :m3 1412}, :bufs {:b1 [], :b2 [1413]}} :line 690}
{:clk 2151.5908 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2152.5974 :j 1416 :dets {:run {:m1 nil, :m2 1414, :m3 1412}, :bufs {:b1 [1415], :b2 [1413]}} :line 691}
{:clk 2152.1813 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2146.5908 :j 1412 :dets {:run {:m1 1416, :m2 1414, :m3 1412}, :bufs {:b1 [1415], :b2 [1413]}} :line 692}
{:clk 2152.1813 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1413 :dets {:run {:m1 1416, :m2 1414, :m3 nil}, :bufs {:b1 [1415], :b2 [1413]}} :line 693}
{:clk 2152.2413 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1414 :dets {:run {:m1 1416, :m2 1414, :m3 1413}, :bufs {:b1 [1415], :b2 []}} :line 694}
{:clk 2152.2413 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1415 :dets {:run {:m1 1416, :m2 nil, :m3 1413}, :bufs {:b1 [1415], :b2 [1414]}} :line 695}
{:clk 2152.5974 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1416 :dets {:run {:m1 1416, :m2 1415, :m3 1413}, :bufs {:b1 [], :b2 [1414]}} :line 696}
{:clk 2152.5974 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2154.0974 :j 1417 :dets {:run {:m1 nil, :m2 1415, :m3 1413}, :bufs {:b1 [1416], :b2 [1414]}} :line 697}
{:clk 2153.1813 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2147.5908 :j 1413 :dets {:run {:m1 1417, :m2 1415, :m3 1413}, :bufs {:b1 [1416], :b2 [1414]}} :line 698}
{:clk 2153.1813 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1414 :dets {:run {:m1 1417, :m2 1415, :m3 nil}, :bufs {:b1 [1416], :b2 [1414]}} :line 699}
{:clk 2153.7413 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1415 :dets {:run {:m1 1417, :m2 1415, :m3 1414}, :bufs {:b1 [1416], :b2 []}} :line 700}
{:clk 2153.7413 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1416 :dets {:run {:m1 1417, :m2 nil, :m3 1414}, :bufs {:b1 [1416], :b2 [1415]}} :line 701}
{:clk 2154.0974 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1417 :dets {:run {:m1 1417, :m2 1416, :m3 1414}, :bufs {:b1 [], :b2 [1415]}} :line 702}
{:clk 2154.0974 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2155.5974 :j 1418 :dets {:run {:m1 nil, :m2 1416, :m3 1414}, :bufs {:b1 [1417], :b2 [1415]}} :line 703}
{:clk 2154.7413 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1416 :dets {:run {:m1 1418, :m2 1416, :m3 1414}, :bufs {:b1 [1417], :b2 [1415]}} :line 704}
{:clk 2154.7413 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1417 :dets {:run {:m1 1418, :m2 nil, :m3 1414}, :bufs {:b1 [1417], :b2 [1415 1416]}} :line 705}
{:clk 2155.5974 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1418 :dets {:run {:m1 1418, :m2 1417, :m3 1414}, :bufs {:b1 [], :b2 [1415 1416]}} :line 706}
{:clk 2155.5974 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2156.5974 :j 1419 :dets {:run {:m1 nil, :m2 1417, :m3 1414}, :bufs {:b1 [1418], :b2 [1415 1416]}} :line 707}
{:clk 2156.2413 :act :m2-blocked :m :m2 :mjpact :bl :dets {:run {:m1 1419, :m2 1417, :m3 1414}, :bufs {:b1 [1418], :b2 [1415 1416]}} :line 708}
{:clk 2156.4240 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2148.5908 :j 1414 :dets {:run {:m1 1419, :m2 1417, :m3 1414}, :bufs {:b1 [1418], :b2 [1415 1416]}} :line 709}
{:clk 2156.4240 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1415 :dets {:run {:m1 1419, :m2 1417, :m3 nil}, :bufs {:b1 [1418], :b2 [1415 1416]}} :line 710}
{:clk 2156.4240 :act :m2-unblocked :m :m2 :mjpact :ub :dets {:run {:m1 1419, :m2 nil, :m3 1415}, :bufs {:b1 [1418], :b2 [1416 1417]}} :line 711}
{:clk 2156.4240 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1417 :dets {:run {:m1 1419, :m2 1417, :m3 1415}, :bufs {:b1 [1418], :b2 [1416]}} :line 712}
{:clk 2156.4240 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1418 :dets {:run {:m1 1419, :m2 nil, :m3 1415}, :bufs {:b1 [1418], :b2 [1416 1417]}} :line 713}
{:clk 2156.5974 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1419 :dets {:run {:m1 1419, :m2 1418, :m3 1415}, :bufs {:b1 [], :b2 [1416 1417]}} :line 714}
{:clk 2156.5974 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2157.5974 :j 1420 :dets {:run {:m1 nil, :m2 1418, :m3 1415}, :bufs {:b1 [1419], :b2 [1416 1417]}} :line 715}
{:clk 2157.5974 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1420 :dets {:run {:m1 1420, :m2 1418, :m3 1415}, :bufs {:b1 [1419], :b2 [1416 1417]}} :line 716}
{:clk 2157.5974 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2159.0974 :j 1421 :dets {:run {:m1 nil, :m2 1418, :m3 1415}, :bufs {:b1 [1419 1420], :b2 [1416 1417]}} :line 717}
{:clk 2157.9240 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1418 :dets {:run {:m1 1421, :m2 1418, :m3 1416}, :bufs {:b1 [1419 1420], :b2 [1417]}} :line 718}
{:clk 2157.9240 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1419 :dets {:run {:m1 1421, :m2 nil, :m3 1416}, :bufs {:b1 [1419 1420], :b2 [1417 1418]}} :line 719}
{:clk 2157.9240 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2150.0908 :j 1415 :dets {:run {:m1 1421, :m2 1418, :m3 1415}, :bufs {:b1 [1419 1420], :b2 [1416 1417]}} :line 720}
{:clk 2157.9240 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1416 :dets {:run {:m1 1421, :m2 1418, :m3 nil}, :bufs {:b1 [1419 1420], :b2 [1416 1417]}} :line 721}
{:clk 2158.9240 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1419 :dets {:run {:m1 1421, :m2 1419, :m3 1417}, :bufs {:b1 [1420], :b2 [1418]}} :line 722}
{:clk 2158.9240 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1420 :dets {:run {:m1 1421, :m2 nil, :m3 1417}, :bufs {:b1 [1420], :b2 [1418 1419]}} :line 723}
{:clk 2158.9240 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2151.5908 :j 1416 :dets {:run {:m1 1421, :m2 1419, :m3 1416}, :bufs {:b1 [1420], :b2 [1417 1418]}} :line 724}
{:clk 2158.9240 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1417 :dets {:run {:m1 1421, :m2 1419, :m3 nil}, :bufs {:b1 [1420], :b2 [1417 1418]}} :line 725}
{:clk 2159.0974 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1421 :dets {:run {:m1 1421, :m2 1420, :m3 1417}, :bufs {:b1 [], :b2 [1418 1419]}} :line 726}
{:clk 2159.0974 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2160.5974 :j 1422 :dets {:run {:m1 nil, :m2 1420, :m3 1417}, :bufs {:b1 [1421], :b2 [1418 1419]}} :line 727}
{:clk 2159.9240 :act :m2-blocked :m :m2 :mjpact :bl :dets {:run {:m1 1422, :m2 1420, :m3 1417}, :bufs {:b1 [1421], :b2 [1418 1419]}} :line 728}
{:clk 2160.4240 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2152.5974 :j 1417 :dets {:run {:m1 1422, :m2 1420, :m3 1417}, :bufs {:b1 [1421], :b2 [1418 1419]}} :line 729}
{:clk 2160.4240 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1418 :dets {:run {:m1 1422, :m2 1420, :m3 nil}, :bufs {:b1 [1421], :b2 [1418 1419]}} :line 730}
{:clk 2160.4240 :act :m2-unblocked :m :m2 :mjpact :ub :dets {:run {:m1 1422, :m2 nil, :m3 1418}, :bufs {:b1 [1421], :b2 [1419 1420]}} :line 731}
{:clk 2160.4240 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1420 :dets {:run {:m1 1422, :m2 1420, :m3 1418}, :bufs {:b1 [1421], :b2 [1419]}} :line 732}
{:clk 2160.4240 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1421 :dets {:run {:m1 1422, :m2 nil, :m3 1418}, :bufs {:b1 [1421], :b2 [1419 1420]}} :line 733}
{:clk 2160.5974 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1422 :dets {:run {:m1 1422, :m2 1421, :m3 1418}, :bufs {:b1 [], :b2 [1419 1420]}} :line 734}
{:clk 2160.5974 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2162.0484 :j 1423 :dets {:run {:m1 nil, :m2 1421, :m3 1418}, :bufs {:b1 [1422], :b2 [1419 1420]}} :line 735}
{:clk 2161.9240 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1421 :dets {:run {:m1 1423, :m2 1421, :m3 1419}, :bufs {:b1 [1422], :b2 [1420]}} :line 736}
{:clk 2161.9240 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1422 :dets {:run {:m1 1423, :m2 nil, :m3 1419}, :bufs {:b1 [1422], :b2 [1420 1421]}} :line 737}
{:clk 2161.9240 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2154.0974 :j 1418 :dets {:run {:m1 1423, :m2 1421, :m3 1418}, :bufs {:b1 [1422], :b2 [1419 1420]}} :line 738}
{:clk 2161.9240 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1419 :dets {:run {:m1 1423, :m2 1421, :m3 nil}, :bufs {:b1 [1422], :b2 [1419 1420]}} :line 739}
{:clk 2162.0484 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1423 :dets {:run {:m1 1423, :m2 1422, :m3 1419}, :bufs {:b1 [], :b2 [1420 1421]}} :line 740}
{:clk 2162.0484 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2165.4376 :j 1424 :dets {:run {:m1 nil, :m2 1422, :m3 1419}, :bufs {:b1 [1423], :b2 [1420 1421]}} :line 741}
{:clk 2162.9240 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2155.5974 :j 1419 :dets {:run {:m1 1424, :m2 1422, :m3 1419}, :bufs {:b1 [1423], :b2 [1420 1421]}} :line 742}
{:clk 2162.9240 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1420 :dets {:run {:m1 1424, :m2 1422, :m3 nil}, :bufs {:b1 [1423], :b2 [1420 1421]}} :line 743}
{:clk 2163.4240 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1422 :dets {:run {:m1 1424, :m2 1422, :m3 1420}, :bufs {:b1 [1423], :b2 [1421]}} :line 744}
{:clk 2163.4240 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1423 :dets {:run {:m1 1424, :m2 nil, :m3 1420}, :bufs {:b1 [1423], :b2 [1421 1422]}} :line 745}
{:clk 2163.9240 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2156.5974 :j 1420 :dets {:run {:m1 1424, :m2 1423, :m3 1420}, :bufs {:b1 [], :b2 [1421 1422]}} :line 746}
{:clk 2163.9240 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1421 :dets {:run {:m1 1424, :m2 1423, :m3 nil}, :bufs {:b1 [], :b2 [1421 1422]}} :line 747}
{:clk 2164.4240 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1423 :dets {:run {:m1 1424, :m2 1423, :m3 1421}, :bufs {:b1 [], :b2 [1422]}} :line 748}
{:clk 2164.4240 :act :m2-starved :m :m2 :mjpact :st :dets {:run {:m1 1424, :m2 nil, :m3 1421}, :bufs {:b1 [], :b2 [1422 1423]}} :line 749}
{:clk 2165.4240 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2157.5974 :j 1421 :dets {:run {:m1 1424, :m2 nil, :m3 1421}, :bufs {:b1 [], :b2 [1422 1423]}} :line 750}
{:clk 2165.4240 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1422 :dets {:run {:m1 1424, :m2 nil, :m3 nil}, :bufs {:b1 [], :b2 [1422 1423]}} :line 751}
{:clk 2165.4376 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1424 :dets {:run {:m1 1424, :m2 nil, :m3 1422}, :bufs {:b1 [], :b2 [1423]}} :line 752}
{:clk 2165.4376 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2166.9376 :j 1425 :dets {:run {:m1 nil, :m2 nil, :m3 1422}, :bufs {:b1 [1424], :b2 [1423]}} :line 753}
{:clk 2165.4376 :act :m2-unstarved :m :m2 :mjpact :us :dets {:run {:m1 1425, :m2 1424, :m3 1422}, :bufs {:b1 [], :b2 [1423]}} :line 754}
{:clk 2165.4376 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1424 :dets {:run {:m1 1425, :m2 nil, :m3 1422}, :bufs {:b1 [1424], :b2 [1423]}} :line 755}
{:clk 2166.4376 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1424 :dets {:run {:m1 1425, :m2 1424, :m3 1422}, :bufs {:b1 [], :b2 [1423]}} :line 756}
{:clk 2166.4376 :act :m2-starved :m :m2 :mjpact :st :dets {:run {:m1 1425, :m2 nil, :m3 1422}, :bufs {:b1 [], :b2 [1423 1424]}} :line 757}
{:clk 2166.9240 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2159.0974 :j 1422 :dets {:run {:m1 1425, :m2 nil, :m3 1422}, :bufs {:b1 [], :b2 [1423 1424]}} :line 758}
{:clk 2166.9240 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1423 :dets {:run {:m1 1425, :m2 nil, :m3 nil}, :bufs {:b1 [], :b2 [1423 1424]}} :line 759}
{:clk 2166.9376 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1425 :dets {:run {:m1 1425, :m2 nil, :m3 1423}, :bufs {:b1 [], :b2 [1424]}} :line 760}
{:clk 2166.9376 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2168.0866 :j 1426 :dets {:run {:m1 nil, :m2 nil, :m3 1423}, :bufs {:b1 [1425], :b2 [1424]}} :line 761}
{:clk 2166.9376 :act :m2-unstarved :m :m2 :mjpact :us :dets {:run {:m1 1426, :m2 1425, :m3 1423}, :bufs {:b1 [], :b2 [1424]}} :line 762}
{:clk 2166.9376 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1425 :dets {:run {:m1 1426, :m2 nil, :m3 1423}, :bufs {:b1 [1425], :b2 [1424]}} :line 763}
{:clk 2167.9240 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2160.5974 :j 1423 :dets {:run {:m1 1426, :m2 1425, :m3 1423}, :bufs {:b1 [], :b2 [1424]}} :line 764}
{:clk 2167.9240 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1424 :dets {:run {:m1 1426, :m2 1425, :m3 nil}, :bufs {:b1 [], :b2 [1424]}} :line 765}
{:clk 2168.0866 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1426 :dets {:run {:m1 1426, :m2 1425, :m3 1424}, :bufs {:b1 [], :b2 []}} :line 766}
{:clk 2168.0866 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2169.0866 :j 1427 :dets {:run {:m1 nil, :m2 1425, :m3 1424}, :bufs {:b1 [1426], :b2 []}} :line 767}
{:clk 2168.4376 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1425 :dets {:run {:m1 1427, :m2 1425, :m3 1424}, :bufs {:b1 [1426], :b2 []}} :line 768}
{:clk 2168.4376 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1426 :dets {:run {:m1 1427, :m2 nil, :m3 1424}, :bufs {:b1 [1426], :b2 [1425]}} :line 769}
{:clk 2168.9240 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2162.0484 :j 1424 :dets {:run {:m1 1427, :m2 1426, :m3 1424}, :bufs {:b1 [], :b2 [1425]}} :line 770}
{:clk 2168.9240 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1425 :dets {:run {:m1 1427, :m2 1426, :m3 nil}, :bufs {:b1 [], :b2 [1425]}} :line 771}
{:clk 2169.0866 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1427 :dets {:run {:m1 1427, :m2 1426, :m3 1425}, :bufs {:b1 [], :b2 []}} :line 772}
{:clk 2169.0866 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2170.0866 :j 1428 :dets {:run {:m1 nil, :m2 1426, :m3 1425}, :bufs {:b1 [1427], :b2 []}} :line 773}
{:clk 2170.0866 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1428 :dets {:run {:m1 1428, :m2 1426, :m3 1425}, :bufs {:b1 [1427], :b2 []}} :line 774}
{:clk 2170.0866 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2171.5866 :j 1429 :dets {:run {:m1 nil, :m2 1426, :m3 1425}, :bufs {:b1 [1427 1428], :b2 []}} :line 775}
{:clk 2170.5772 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1426 :dets {:run {:m1 1429, :m2 1426, :m3 1425}, :bufs {:b1 [1427 1428], :b2 []}} :line 776}
{:clk 2170.5772 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1427 :dets {:run {:m1 1429, :m2 nil, :m3 1425}, :bufs {:b1 [1427 1428], :b2 [1426]}} :line 777}
{:clk 2171.0210 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2165.4376 :j 1425 :dets {:run {:m1 1429, :m2 1427, :m3 1425}, :bufs {:b1 [1428], :b2 [1426]}} :line 778}
{:clk 2171.0210 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1426 :dets {:run {:m1 1429, :m2 1427, :m3 nil}, :bufs {:b1 [1428], :b2 [1426]}} :line 779}
{:clk 2171.5772 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1427 :dets {:run {:m1 1429, :m2 1427, :m3 1426}, :bufs {:b1 [1428], :b2 []}} :line 780}
{:clk 2171.5772 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1428 :dets {:run {:m1 1429, :m2 nil, :m3 1426}, :bufs {:b1 [1428], :b2 [1427]}} :line 781}
{:clk 2171.5866 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1429 :dets {:run {:m1 1429, :m2 1428, :m3 1426}, :bufs {:b1 [], :b2 [1427]}} :line 782}
{:clk 2171.5866 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2172.5866 :j 1430 :dets {:run {:m1 nil, :m2 1428, :m3 1426}, :bufs {:b1 [1429], :b2 [1427]}} :line 783}
{:clk 2172.5772 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1428 :dets {:run {:m1 1430, :m2 1428, :m3 1426}, :bufs {:b1 [1429], :b2 [1427]}} :line 784}
{:clk 2172.5772 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1429 :dets {:run {:m1 1430, :m2 nil, :m3 1426}, :bufs {:b1 [1429], :b2 [1427 1428]}} :line 785}
{:clk 2172.5866 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1430 :dets {:run {:m1 1430, :m2 1429, :m3 1426}, :bufs {:b1 [], :b2 [1427 1428]}} :line 786}
{:clk 2172.5866 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2174.0866 :j 1431 :dets {:run {:m1 nil, :m2 1429, :m3 1426}, :bufs {:b1 [1430], :b2 [1427 1428]}} :line 787}
{:clk 2173.3398 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2166.9376 :j 1426 :dets {:run {:m1 1431, :m2 1429, :m3 1426}, :bufs {:b1 [1430], :b2 [1427 1428]}} :line 788}
{:clk 2173.3398 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1427 :dets {:run {:m1 1431, :m2 1429, :m3 nil}, :bufs {:b1 [1430], :b2 [1427 1428]}} :line 789}
{:clk 2174.0772 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1429 :dets {:run {:m1 1431, :m2 1429, :m3 1427}, :bufs {:b1 [1430], :b2 [1428]}} :line 790}
{:clk 2174.0772 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1430 :dets {:run {:m1 1431, :m2 nil, :m3 1427}, :bufs {:b1 [1430], :b2 [1428 1429]}} :line 791}
{:clk 2174.0866 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1431 :dets {:run {:m1 1431, :m2 1430, :m3 1427}, :bufs {:b1 [], :b2 [1428 1429]}} :line 792}
{:clk 2174.0866 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2176.0777 :j 1432 :dets {:run {:m1 nil, :m2 1430, :m3 1427}, :bufs {:b1 [1431], :b2 [1428 1429]}} :line 793}
{:clk 2174.3398 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2168.0866 :j 1427 :dets {:run {:m1 1432, :m2 1430, :m3 1427}, :bufs {:b1 [1431], :b2 [1428 1429]}} :line 794}
{:clk 2174.3398 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1428 :dets {:run {:m1 1432, :m2 1430, :m3 nil}, :bufs {:b1 [1431], :b2 [1428 1429]}} :line 795}
{:clk 2175.0772 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1430 :dets {:run {:m1 1432, :m2 1430, :m3 1428}, :bufs {:b1 [1431], :b2 [1429]}} :line 796}
{:clk 2175.0772 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1431 :dets {:run {:m1 1432, :m2 nil, :m3 1428}, :bufs {:b1 [1431], :b2 [1429 1430]}} :line 797}
{:clk 2175.3398 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2169.0866 :j 1428 :dets {:run {:m1 1432, :m2 1431, :m3 1428}, :bufs {:b1 [], :b2 [1429 1430]}} :line 798}
{:clk 2175.3398 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1429 :dets {:run {:m1 1432, :m2 1431, :m3 nil}, :bufs {:b1 [], :b2 [1429 1430]}} :line 799}
{:clk 2176.0777 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1432 :dets {:run {:m1 1432, :m2 1431, :m3 1429}, :bufs {:b1 [], :b2 [1430]}} :line 800}
{:clk 2176.0777 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2177.5777 :j 1433 :dets {:run {:m1 nil, :m2 1431, :m3 1429}, :bufs {:b1 [1432], :b2 [1430]}} :line 801}
{:clk 2176.8398 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2170.0866 :j 1429 :dets {:run {:m1 1433, :m2 1431, :m3 1429}, :bufs {:b1 [1432], :b2 [1430]}} :line 802}
{:clk 2176.8398 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1430 :dets {:run {:m1 1433, :m2 1431, :m3 nil}, :bufs {:b1 [1432], :b2 [1430]}} :line 803}
{:clk 2177.2057 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1431 :dets {:run {:m1 1433, :m2 1431, :m3 1430}, :bufs {:b1 [1432], :b2 []}} :line 804}
{:clk 2177.2057 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1432 :dets {:run {:m1 1433, :m2 nil, :m3 1430}, :bufs {:b1 [1432], :b2 [1431]}} :line 805}
{:clk 2177.5777 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1433 :dets {:run {:m1 1433, :m2 1432, :m3 1430}, :bufs {:b1 [], :b2 [1431]}} :line 806}
{:clk 2177.5777 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2179.0777 :j 1434 :dets {:run {:m1 nil, :m2 1432, :m3 1430}, :bufs {:b1 [1433], :b2 [1431]}} :line 807}
{:clk 2177.8398 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2171.5866 :j 1430 :dets {:run {:m1 1434, :m2 1432, :m3 1430}, :bufs {:b1 [1433], :b2 [1431]}} :line 808}
{:clk 2177.8398 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1431 :dets {:run {:m1 1434, :m2 1432, :m3 nil}, :bufs {:b1 [1433], :b2 [1431]}} :line 809}
{:clk 2178.7057 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1432 :dets {:run {:m1 1434, :m2 1432, :m3 1431}, :bufs {:b1 [1433], :b2 []}} :line 810}
{:clk 2178.7057 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1433 :dets {:run {:m1 1434, :m2 nil, :m3 1431}, :bufs {:b1 [1433], :b2 [1432]}} :line 811}
{:clk 2179.0777 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1434 :dets {:run {:m1 1434, :m2 1433, :m3 1431}, :bufs {:b1 [], :b2 [1432]}} :line 812}
{:clk 2179.0777 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2180.0777 :j 1435 :dets {:run {:m1 nil, :m2 1433, :m3 1431}, :bufs {:b1 [1434], :b2 [1432]}} :line 813}
{:clk 2179.3398 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2172.5866 :j 1431 :dets {:run {:m1 1435, :m2 1433, :m3 1431}, :bufs {:b1 [1434], :b2 [1432]}} :line 814}
{:clk 2179.3398 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1432 :dets {:run {:m1 1435, :m2 1433, :m3 nil}, :bufs {:b1 [1434], :b2 [1432]}} :line 815}
{:clk 2180.0777 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1435 :dets {:run {:m1 1435, :m2 1433, :m3 1432}, :bufs {:b1 [1434], :b2 []}} :line 816}
{:clk 2180.0777 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2181.0777 :j 1436 :dets {:run {:m1 nil, :m2 1433, :m3 1432}, :bufs {:b1 [1434 1435], :b2 []}} :line 817}
{:clk 2180.2057 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1433 :dets {:run {:m1 1436, :m2 1433, :m3 1432}, :bufs {:b1 [1434 1435], :b2 []}} :line 818}
{:clk 2180.2057 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1434 :dets {:run {:m1 1436, :m2 nil, :m3 1432}, :bufs {:b1 [1434 1435], :b2 [1433]}} :line 819}
{:clk 2180.8398 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2174.0866 :j 1432 :dets {:run {:m1 1436, :m2 1434, :m3 1432}, :bufs {:b1 [1435], :b2 [1433]}} :line 820}
{:clk 2180.8398 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1433 :dets {:run {:m1 1436, :m2 1434, :m3 nil}, :bufs {:b1 [1435], :b2 [1433]}} :line 821}
{:clk 2181.0777 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1436 :dets {:run {:m1 1436, :m2 1434, :m3 1433}, :bufs {:b1 [1435], :b2 []}} :line 822}
{:clk 2181.0777 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2182.0777 :j 1437 :dets {:run {:m1 nil, :m2 1434, :m3 1433}, :bufs {:b1 [1435 1436], :b2 []}} :line 823}
{:clk 2181.7057 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1434 :dets {:run {:m1 1437, :m2 1434, :m3 1433}, :bufs {:b1 [1435 1436], :b2 []}} :line 824}
{:clk 2181.7057 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1435 :dets {:run {:m1 1437, :m2 nil, :m3 1433}, :bufs {:b1 [1435 1436], :b2 [1434]}} :line 825}
{:clk 2182.0777 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1437 :dets {:run {:m1 1437, :m2 1435, :m3 1433}, :bufs {:b1 [1436], :b2 [1434]}} :line 826}
{:clk 2182.0777 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2185.6082 :j 1438 :dets {:run {:m1 nil, :m2 1435, :m3 1433}, :bufs {:b1 [1436 1437], :b2 [1434]}} :line 827}
{:clk 2182.3398 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2176.0777 :j 1433 :dets {:run {:m1 1438, :m2 1435, :m3 1433}, :bufs {:b1 [1436 1437], :b2 [1434]}} :line 828}
{:clk 2182.3398 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1434 :dets {:run {:m1 1438, :m2 1435, :m3 nil}, :bufs {:b1 [1436 1437], :b2 [1434]}} :line 829}
{:clk 2182.7057 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1435 :dets {:run {:m1 1438, :m2 1435, :m3 1434}, :bufs {:b1 [1436 1437], :b2 []}} :line 830}
{:clk 2182.7057 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1436 :dets {:run {:m1 1438, :m2 nil, :m3 1434}, :bufs {:b1 [1436 1437], :b2 [1435]}} :line 831}
{:clk 2183.7057 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1436 :dets {:run {:m1 1438, :m2 1436, :m3 1434}, :bufs {:b1 [1437], :b2 [1435]}} :line 832}
{:clk 2183.7057 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1437 :dets {:run {:m1 1438, :m2 nil, :m3 1434}, :bufs {:b1 [1437], :b2 [1435 1436]}} :line 833}
{:clk 2183.8398 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2177.5777 :j 1434 :dets {:run {:m1 1438, :m2 1437, :m3 1434}, :bufs {:b1 [], :b2 [1435 1436]}} :line 834}
{:clk 2183.8398 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1435 :dets {:run {:m1 1438, :m2 1437, :m3 nil}, :bufs {:b1 [], :b2 [1435 1436]}} :line 835}
{:clk 2184.7057 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1437 :dets {:run {:m1 1438, :m2 1437, :m3 1435}, :bufs {:b1 [], :b2 [1436]}} :line 836}
{:clk 2184.7057 :act :m2-starved :m :m2 :mjpact :st :dets {:run {:m1 1438, :m2 nil, :m3 1435}, :bufs {:b1 [], :b2 [1436 1437]}} :line 837}
{:clk 2184.8398 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2179.0777 :j 1435 :dets {:run {:m1 1438, :m2 nil, :m3 1435}, :bufs {:b1 [], :b2 [1436 1437]}} :line 838}
{:clk 2184.8398 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1436 :dets {:run {:m1 1438, :m2 nil, :m3 nil}, :bufs {:b1 [], :b2 [1436 1437]}} :line 839}
{:clk 2185.6082 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1438 :dets {:run {:m1 1438, :m2 nil, :m3 1436}, :bufs {:b1 [], :b2 [1437]}} :line 840}
{:clk 2185.6082 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2186.6082 :j 1439 :dets {:run {:m1 nil, :m2 nil, :m3 1436}, :bufs {:b1 [1438], :b2 [1437]}} :line 841}
{:clk 2185.6082 :act :m2-unstarved :m :m2 :mjpact :us :dets {:run {:m1 1439, :m2 1438, :m3 1436}, :bufs {:b1 [], :b2 [1437]}} :line 842}
{:clk 2185.6082 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1438 :dets {:run {:m1 1439, :m2 nil, :m3 1436}, :bufs {:b1 [1438], :b2 [1437]}} :line 843}
{:clk 2185.8398 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2180.0777 :j 1436 :dets {:run {:m1 1439, :m2 1438, :m3 1436}, :bufs {:b1 [], :b2 [1437]}} :line 844}
{:clk 2185.8398 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1437 :dets {:run {:m1 1439, :m2 1438, :m3 nil}, :bufs {:b1 [], :b2 [1437]}} :line 845}
{:clk 2186.6082 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1439 :dets {:run {:m1 1439, :m2 1438, :m3 1437}, :bufs {:b1 [], :b2 []}} :line 846}
{:clk 2186.6082 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2188.1082 :j 1440 :dets {:run {:m1 nil, :m2 1438, :m3 1437}, :bufs {:b1 [1439], :b2 []}} :line 847}
{:clk 2186.8398 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2181.0777 :j 1437 :dets {:run {:m1 1440, :m2 1438, :m3 1437}, :bufs {:b1 [1439], :b2 []}} :line 848}
{:clk 2186.8398 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1440, :m2 1438, :m3 nil}, :bufs {:b1 [1439], :b2 []}} :line 849}
{:clk 2187.1082 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1438 :dets {:run {:m1 1440, :m2 1438, :m3 nil}, :bufs {:b1 [1439], :b2 []}} :line 850}
{:clk 2187.1082 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1439 :dets {:run {:m1 1440, :m2 nil, :m3 nil}, :bufs {:b1 [1439], :b2 [1438]}} :line 851}
{:clk 2187.1082 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1440, :m2 1439, :m3 1438}, :bufs {:b1 [], :b2 []}} :line 852}
{:clk 2187.1082 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1438 :dets {:run {:m1 1440, :m2 1439, :m3 nil}, :bufs {:b1 [], :b2 [1438]}} :line 853}
{:clk 2188.1082 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1440 :dets {:run {:m1 1440, :m2 1439, :m3 1438}, :bufs {:b1 [], :b2 []}} :line 854}
{:clk 2188.1082 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2189.1082 :j 1441 :dets {:run {:m1 nil, :m2 nil, :m3 1438}, :bufs {:b1 [1440], :b2 [1439]}} :line 855}
{:clk 2188.1082 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1439 :dets {:run {:m1 nil, :m2 1439, :m3 1438}, :bufs {:b1 [1440], :b2 []}} :line 856}
{:clk 2188.1082 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1440 :dets {:run {:m1 1441, :m2 nil, :m3 1438}, :bufs {:b1 [1440], :b2 [1439]}} :line 857}
{:clk 2188.6082 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2182.0777 :j 1438 :dets {:run {:m1 1441, :m2 1440, :m3 1438}, :bufs {:b1 [], :b2 [1439]}} :line 858}
{:clk 2188.6082 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1439 :dets {:run {:m1 1441, :m2 1440, :m3 nil}, :bufs {:b1 [], :b2 [1439]}} :line 859}
{:clk 2189.1082 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1441 :dets {:run {:m1 1441, :m2 1440, :m3 1439}, :bufs {:b1 [], :b2 []}} :line 860}
{:clk 2189.1082 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2190.6082 :j 1442 :dets {:run {:m1 nil, :m2 1440, :m3 1439}, :bufs {:b1 [1441], :b2 []}} :line 861}
{:clk 2189.6082 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1440 :dets {:run {:m1 1442, :m2 1440, :m3 1439}, :bufs {:b1 [1441], :b2 []}} :line 862}
{:clk 2189.6082 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1441 :dets {:run {:m1 1442, :m2 nil, :m3 nil}, :bufs {:b1 [1441], :b2 [1440]}} :line 863}
{:clk 2189.6082 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2185.6082 :j 1439 :dets {:run {:m1 1442, :m2 nil, :m3 1439}, :bufs {:b1 [1441], :b2 [1440]}} :line 864}
{:clk 2189.6082 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1440 :dets {:run {:m1 1442, :m2 1441, :m3 nil}, :bufs {:b1 [], :b2 [1440]}} :line 865}
{:clk 2190.6082 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1442 :dets {:run {:m1 1442, :m2 1441, :m3 1440}, :bufs {:b1 [], :b2 []}} :line 866}
{:clk 2190.6082 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2191.6082 :j 1443 :dets {:run {:m1 nil, :m2 nil, :m3 1440}, :bufs {:b1 [1442], :b2 [1441]}} :line 867}
{:clk 2190.6082 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1441 :dets {:run {:m1 nil, :m2 1441, :m3 1440}, :bufs {:b1 [1442], :b2 []}} :line 868}
{:clk 2190.6082 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1442 :dets {:run {:m1 1443, :m2 nil, :m3 1440}, :bufs {:b1 [1442], :b2 [1441]}} :line 869}
{:clk 2191.1082 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2186.6082 :j 1440 :dets {:run {:m1 1443, :m2 1442, :m3 1440}, :bufs {:b1 [], :b2 [1441]}} :line 870}
{:clk 2191.1082 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1441 :dets {:run {:m1 1443, :m2 1442, :m3 nil}, :bufs {:b1 [], :b2 [1441]}} :line 871}
{:clk 2191.6082 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1443 :dets {:run {:m1 1443, :m2 1442, :m3 1441}, :bufs {:b1 [], :b2 []}} :line 872}
{:clk 2191.6082 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2192.6082 :j 1444 :dets {:run {:m1 nil, :m2 1442, :m3 1441}, :bufs {:b1 [1443], :b2 []}} :line 873}
{:clk 2192.1082 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1442 :dets {:run {:m1 1444, :m2 1442, :m3 1441}, :bufs {:b1 [1443], :b2 []}} :line 874}
{:clk 2192.1082 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1443 :dets {:run {:m1 1444, :m2 nil, :m3 nil}, :bufs {:b1 [1443], :b2 [1442]}} :line 875}
{:clk 2192.1082 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2188.1082 :j 1441 :dets {:run {:m1 1444, :m2 nil, :m3 1441}, :bufs {:b1 [1443], :b2 [1442]}} :line 876}
{:clk 2192.1082 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1442 :dets {:run {:m1 1444, :m2 1443, :m3 nil}, :bufs {:b1 [], :b2 [1442]}} :line 877}
{:clk 2192.6082 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1444 :dets {:run {:m1 1444, :m2 1443, :m3 1442}, :bufs {:b1 [], :b2 []}} :line 878}
{:clk 2192.6082 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2193.6082 :j 1445 :dets {:run {:m1 nil, :m2 1443, :m3 1442}, :bufs {:b1 [1444], :b2 []}} :line 879}
{:clk 2193.6082 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1445 :dets {:run {:m1 1445, :m2 1443, :m3 1442}, :bufs {:b1 [1444], :b2 []}} :line 880}
{:clk 2193.6082 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2189.1082 :j 1442 :dets {:run {:m1 nil, :m2 1443, :m3 1442}, :bufs {:b1 [1444 1445], :b2 []}} :line 881}
{:clk 2193.6082 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2196.2677 :j 1446 :dets {:run {:m1 nil, :m2 1443, :m3 nil}, :bufs {:b1 [1444 1445], :b2 []}} :line 882}
{:clk 2193.6082 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1446, :m2 1443, :m3 nil}, :bufs {:b1 [1444 1445], :b2 []}} :line 883}
{:clk 2195.2146 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1443 :dets {:run {:m1 1446, :m2 1443, :m3 nil}, :bufs {:b1 [1444 1445], :b2 []}} :line 884}
{:clk 2195.2146 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1444 :dets {:run {:m1 1446, :m2 nil, :m3 nil}, :bufs {:b1 [1444 1445], :b2 [1443]}} :line 885}
{:clk 2195.2146 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1446, :m2 1444, :m3 nil}, :bufs {:b1 [1445], :b2 [1443]}} :line 886}
{:clk 2196.2146 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1444 :dets {:run {:m1 1446, :m2 1444, :m3 nil}, :bufs {:b1 [1445], :b2 [1443]}} :line 887}
{:clk 2196.2146 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1445 :dets {:run {:m1 1446, :m2 nil, :m3 nil}, :bufs {:b1 [1445], :b2 [1443 1444]}} :line 888}
{:clk 2196.2677 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1446 :dets {:run {:m1 1446, :m2 1445, :m3 nil}, :bufs {:b1 [], :b2 [1443 1444]}} :line 889}
{:clk 2196.2677 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2197.7677 :j 1447 :dets {:run {:m1 nil, :m2 1445, :m3 nil}, :bufs {:b1 [1446], :b2 [1443 1444]}} :line 890}
{:clk 2197.2146 :act :m2-blocked :m :m2 :mjpact :bl :dets {:run {:m1 1447, :m2 1445, :m3 nil}, :bufs {:b1 [1446], :b2 [1443 1444]}} :line 891}
{:clk 2197.7677 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1447 :dets {:run {:m1 1447, :m2 1445, :m3 nil}, :bufs {:b1 [1446], :b2 [1443 1444]}} :line 892}
{:clk 2197.7677 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2199.2677 :j 1448 :dets {:run {:m1 nil, :m2 1445, :m3 nil}, :bufs {:b1 [1446 1447], :b2 [1443 1444]}} :line 893}
{:clk 2199.2677 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1448, :m2 1445, :m3 nil}, :bufs {:b1 [1446 1447], :b2 [1443 1444]}} :line 894}
{:clk 2200.1719 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1443 :dets {:run {:m1 1448, :m2 1445, :m3 nil}, :bufs {:b1 [1446 1447], :b2 [1443 1444]}} :line 895}
{:clk 2200.1719 :act :m2-unblocked :m :m2 :mjpact :ub :dets {:run {:m1 1448, :m2 nil, :m3 1443}, :bufs {:b1 [1446 1447], :b2 [1444 1445]}} :line 896}
{:clk 2200.1719 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1445 :dets {:run {:m1 1448, :m2 1445, :m3 1443}, :bufs {:b1 [1446 1447], :b2 [1444]}} :line 897}
{:clk 2201.7325 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1446 :dets {:run {:m1 1448, :m2 nil, :m3 1443}, :bufs {:b1 [1446 1447], :b2 [1444 1445]}} :line 898}
{:clk 2201.7325 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1446, :m3 1443}, :bufs {:b1 [1447 1448], :b2 [1444 1445]}} :line 899}
{:clk 2201.7325 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1448 :dets {:run {:m1 1448, :m2 1446, :m3 1443}, :bufs {:b1 [1447], :b2 [1444 1445]}} :line 900}
{:clk 2201.7325 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2208.4653 :j 1449 :dets {:run {:m1 nil, :m2 1446, :m3 1443}, :bufs {:b1 [1447 1448], :b2 [1444 1445]}} :line 901}
{:clk 2202.0433 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2190.6082 :j 1443 :dets {:run {:m1 1449, :m2 1446, :m3 1443}, :bufs {:b1 [1447 1448], :b2 [1444 1445]}} :line 902}
{:clk 2202.0433 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1444 :dets {:run {:m1 1449, :m2 1446, :m3 nil}, :bufs {:b1 [1447 1448], :b2 [1444 1445]}} :line 903}
{:clk 2202.7325 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1446 :dets {:run {:m1 1449, :m2 1446, :m3 1444}, :bufs {:b1 [1447 1448], :b2 [1445]}} :line 904}
{:clk 2202.7325 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1447 :dets {:run {:m1 1449, :m2 nil, :m3 1444}, :bufs {:b1 [1447 1448], :b2 [1445 1446]}} :line 905}
{:clk 2203.0433 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2191.6082 :j 1444 :dets {:run {:m1 1449, :m2 1447, :m3 1444}, :bufs {:b1 [1448], :b2 [1445 1446]}} :line 906}
{:clk 2203.0433 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1445 :dets {:run {:m1 1449, :m2 1447, :m3 nil}, :bufs {:b1 [1448], :b2 [1445 1446]}} :line 907}
{:clk 2204.0433 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2192.6082 :j 1445 :dets {:run {:m1 1449, :m2 1447, :m3 1445}, :bufs {:b1 [1448], :b2 [1446]}} :line 908}
{:clk 2204.0433 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1446 :dets {:run {:m1 1449, :m2 1447, :m3 nil}, :bufs {:b1 [1448], :b2 [1446]}} :line 909}
{:clk 2204.2325 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1447 :dets {:run {:m1 1449, :m2 1447, :m3 1446}, :bufs {:b1 [1448], :b2 []}} :line 910}
{:clk 2204.2325 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1448 :dets {:run {:m1 1449, :m2 nil, :m3 1446}, :bufs {:b1 [1448], :b2 [1447]}} :line 911}
{:clk 2205.0433 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2193.6082 :j 1446 :dets {:run {:m1 1449, :m2 1448, :m3 1446}, :bufs {:b1 [], :b2 [1447]}} :line 912}
{:clk 2205.0433 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1447 :dets {:run {:m1 1449, :m2 1448, :m3 nil}, :bufs {:b1 [], :b2 [1447]}} :line 913}
{:clk 2205.7325 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1448 :dets {:run {:m1 1449, :m2 1448, :m3 1447}, :bufs {:b1 [], :b2 []}} :line 914}
{:clk 2205.7325 :act :m2-starved :m :m2 :mjpact :st :dets {:run {:m1 1449, :m2 nil, :m3 1447}, :bufs {:b1 [], :b2 [1448]}} :line 915}
{:clk 2206.5433 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2196.2677 :j 1447 :dets {:run {:m1 1449, :m2 nil, :m3 1447}, :bufs {:b1 [], :b2 [1448]}} :line 916}
{:clk 2206.5433 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1448 :dets {:run {:m1 1449, :m2 nil, :m3 nil}, :bufs {:b1 [], :b2 [1448]}} :line 917}
{:clk 2208.0433 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2197.7677 :j 1448 :dets {:run {:m1 1449, :m2 nil, :m3 1448}, :bufs {:b1 [], :b2 []}} :line 918}
{:clk 2208.0433 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1449, :m2 nil, :m3 nil}, :bufs {:b1 [], :b2 []}} :line 919}
{:clk 2208.4653 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1449 :dets {:run {:m1 1449, :m2 nil, :m3 nil}, :bufs {:b1 [], :b2 []}} :line 920}
{:clk 2208.4653 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2209.9653 :j 1450 :dets {:run {:m1 nil, :m2 nil, :m3 nil}, :bufs {:b1 [1449], :b2 []}} :line 921}
{:clk 2208.4653 :act :m2-unstarved :m :m2 :mjpact :us :dets {:run {:m1 1450, :m2 1449, :m3 nil}, :bufs {:b1 [], :b2 []}} :line 922}
{:clk 2208.4653 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1449 :dets {:run {:m1 1450, :m2 nil, :m3 nil}, :bufs {:b1 [1449], :b2 []}} :line 923}
{:clk 2209.9653 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1450 :dets {:run {:m1 1450, :m2 1449, :m3 nil}, :bufs {:b1 [], :b2 []}} :line 924}
{:clk 2209.9653 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2211.4653 :j 1451 :dets {:run {:m1 nil, :m2 nil, :m3 nil}, :bufs {:b1 [1450], :b2 [1449]}} :line 925}
{:clk 2209.9653 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1449 :dets {:run {:m1 nil, :m2 1449, :m3 nil}, :bufs {:b1 [1450], :b2 []}} :line 926}
{:clk 2209.9653 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1450 :dets {:run {:m1 1451, :m2 nil, :m3 nil}, :bufs {:b1 [1450], :b2 [1449]}} :line 927}
{:clk 2209.9653 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1451, :m2 1450, :m3 1449}, :bufs {:b1 [], :b2 []}} :line 928}
{:clk 2209.9653 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1449 :dets {:run {:m1 1451, :m2 1450, :m3 nil}, :bufs {:b1 [], :b2 [1449]}} :line 929}
{:clk 2211.4653 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1451 :dets {:run {:m1 1451, :m2 1450, :m3 1449}, :bufs {:b1 [], :b2 []}} :line 930}
{:clk 2211.4653 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2212.4653 :j 1452 :dets {:run {:m1 nil, :m2 1450, :m3 1449}, :bufs {:b1 [1451], :b2 []}} :line 931}
{:clk 2211.5064 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2201.7325 :j 1449 :dets {:run {:m1 1452, :m2 1450, :m3 1449}, :bufs {:b1 [1451], :b2 []}} :line 932}
{:clk 2211.5064 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1452, :m2 1450, :m3 nil}, :bufs {:b1 [1451], :b2 []}} :line 933}
{:clk 2212.4653 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1452 :dets {:run {:m1 1452, :m2 1450, :m3 nil}, :bufs {:b1 [1451], :b2 []}} :line 934}
{:clk 2212.4653 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2213.4653 :j 1453 :dets {:run {:m1 nil, :m2 1450, :m3 nil}, :bufs {:b1 [1451 1452], :b2 []}} :line 935}
{:clk 2213.4653 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1453, :m2 1450, :m3 nil}, :bufs {:b1 [1451 1452], :b2 []}} :line 936}
{:clk 2213.6832 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1450 :dets {:run {:m1 1453, :m2 1451, :m3 nil}, :bufs {:b1 [1452], :b2 [1450]}} :line 937}
{:clk 2213.6832 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1450 :dets {:run {:m1 1453, :m2 1450, :m3 nil}, :bufs {:b1 [1451 1452], :b2 []}} :line 938}
{:clk 2213.6832 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1451 :dets {:run {:m1 1453, :m2 nil, :m3 nil}, :bufs {:b1 [1451 1452], :b2 [1450]}} :line 939}
{:clk 2213.6832 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1453, :m2 1451, :m3 1450}, :bufs {:b1 [1452], :b2 []}} :line 940}
{:clk 2213.6832 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1451, :m3 1450}, :bufs {:b1 [1452 1453], :b2 []}} :line 941}
{:clk 2213.6832 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1453 :dets {:run {:m1 1453, :m2 1451, :m3 1450}, :bufs {:b1 [1452], :b2 []}} :line 942}
{:clk 2213.6832 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2215.1832 :j 1454 :dets {:run {:m1 nil, :m2 1451, :m3 1450}, :bufs {:b1 [1452 1453], :b2 []}} :line 943}
{:clk 2215.1832 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1454 :dets {:run {:m1 1454, :m2 1452, :m3 1451}, :bufs {:b1 [1453], :b2 []}} :line 944}
{:clk 2215.1832 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2216.1832 :j 1455 :dets {:run {:m1 nil, :m2 1452, :m3 1451}, :bufs {:b1 [1453 1454], :b2 []}} :line 945}
{:clk 2215.1832 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1451 :dets {:run {:m1 1454, :m2 1451, :m3 1450}, :bufs {:b1 [1452 1453], :b2 []}} :line 946}
{:clk 2215.1832 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1452 :dets {:run {:m1 1454, :m2 nil, :m3 nil}, :bufs {:b1 [1452 1453], :b2 [1451]}} :line 947}
{:clk 2215.1832 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2208.4653 :j 1450 :dets {:run {:m1 1454, :m2 nil, :m3 1450}, :bufs {:b1 [1452 1453], :b2 [1451]}} :line 948}
{:clk 2215.1832 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1451 :dets {:run {:m1 1454, :m2 1452, :m3 nil}, :bufs {:b1 [1453], :b2 [1451]}} :line 949}
{:clk 2216.1832 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1455 :dets {:run {:m1 1455, :m2 1453, :m3 1451}, :bufs {:b1 [1454], :b2 [1452]}} :line 950}
{:clk 2216.1832 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2217.1832 :j 1456 :dets {:run {:m1 nil, :m2 1453, :m3 1451}, :bufs {:b1 [1454 1455], :b2 [1452]}} :line 951}
{:clk 2216.1832 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1452 :dets {:run {:m1 1455, :m2 1452, :m3 1451}, :bufs {:b1 [1453 1454], :b2 []}} :line 952}
{:clk 2216.1832 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1453 :dets {:run {:m1 1455, :m2 nil, :m3 1451}, :bufs {:b1 [1453 1454], :b2 [1452]}} :line 953}
{:clk 2216.6832 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2209.9653 :j 1451 :dets {:run {:m1 1456, :m2 1453, :m3 1451}, :bufs {:b1 [1454 1455], :b2 [1452]}} :line 954}
{:clk 2216.6832 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1452 :dets {:run {:m1 1456, :m2 1453, :m3 nil}, :bufs {:b1 [1454 1455], :b2 [1452]}} :line 955}
{:clk 2217.1832 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1456 :dets {:run {:m1 1456, :m2 1454, :m3 1452}, :bufs {:b1 [1455], :b2 [1453]}} :line 956}
{:clk 2217.1832 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2218.7952 :j 1457 :dets {:run {:m1 nil, :m2 1454, :m3 1452}, :bufs {:b1 [1455 1456], :b2 [1453]}} :line 957}
{:clk 2217.1832 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1453 :dets {:run {:m1 1456, :m2 1453, :m3 1452}, :bufs {:b1 [1454 1455], :b2 []}} :line 958}
{:clk 2217.1832 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1454 :dets {:run {:m1 1456, :m2 nil, :m3 1452}, :bufs {:b1 [1454 1455], :b2 [1453]}} :line 959}
{:clk 2217.6832 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2211.4653 :j 1452 :dets {:run {:m1 1457, :m2 1454, :m3 1452}, :bufs {:b1 [1455 1456], :b2 [1453]}} :line 960}
{:clk 2217.6832 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1453 :dets {:run {:m1 1457, :m2 1454, :m3 nil}, :bufs {:b1 [1455 1456], :b2 [1453]}} :line 961}
{:clk 2218.6832 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1454 :dets {:run {:m1 1457, :m2 1454, :m3 1453}, :bufs {:b1 [1455 1456], :b2 []}} :line 962}
{:clk 2218.6832 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1455 :dets {:run {:m1 1457, :m2 nil, :m3 nil}, :bufs {:b1 [1455 1456], :b2 [1454]}} :line 963}
{:clk 2218.6832 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2212.4653 :j 1453 :dets {:run {:m1 1457, :m2 nil, :m3 1453}, :bufs {:b1 [1455 1456], :b2 [1454]}} :line 964}
{:clk 2218.6832 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1454 :dets {:run {:m1 1457, :m2 1455, :m3 nil}, :bufs {:b1 [1456], :b2 [1454]}} :line 965}
{:clk 2218.7952 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1457 :dets {:run {:m1 1457, :m2 1455, :m3 1454}, :bufs {:b1 [1456], :b2 []}} :line 966}
{:clk 2218.7952 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2220.2952 :j 1458 :dets {:run {:m1 nil, :m2 1455, :m3 1454}, :bufs {:b1 [1456 1457], :b2 []}} :line 967}
{:clk 2219.6832 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1455 :dets {:run {:m1 1458, :m2 1455, :m3 1454}, :bufs {:b1 [1456 1457], :b2 []}} :line 968}
{:clk 2219.6832 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1456 :dets {:run {:m1 1458, :m2 nil, :m3 1454}, :bufs {:b1 [1456 1457], :b2 [1455]}} :line 969}
{:clk 2220.1832 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2213.6832 :j 1454 :dets {:run {:m1 1458, :m2 1456, :m3 1454}, :bufs {:b1 [1457], :b2 [1455]}} :line 970}
{:clk 2220.1832 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1455 :dets {:run {:m1 1458, :m2 1456, :m3 nil}, :bufs {:b1 [1457], :b2 [1455]}} :line 971}
{:clk 2220.2952 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1458 :dets {:run {:m1 1458, :m2 1456, :m3 1455}, :bufs {:b1 [1457], :b2 []}} :line 972}
{:clk 2220.2952 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2221.7952 :j 1459 :dets {:run {:m1 nil, :m2 1456, :m3 1455}, :bufs {:b1 [1457 1458], :b2 []}} :line 973}
{:clk 2220.6832 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1456 :dets {:run {:m1 1459, :m2 1456, :m3 1455}, :bufs {:b1 [1457 1458], :b2 []}} :line 974}
{:clk 2220.6832 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1457 :dets {:run {:m1 1459, :m2 nil, :m3 1455}, :bufs {:b1 [1457 1458], :b2 [1456]}} :line 975}
{:clk 2221.1832 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2215.1832 :j 1455 :dets {:run {:m1 1459, :m2 1457, :m3 1455}, :bufs {:b1 [1458], :b2 [1456]}} :line 976}
{:clk 2221.1832 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1456 :dets {:run {:m1 1459, :m2 1457, :m3 nil}, :bufs {:b1 [1458], :b2 [1456]}} :line 977}
{:clk 2221.6832 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1457 :dets {:run {:m1 1459, :m2 1457, :m3 1456}, :bufs {:b1 [1458], :b2 []}} :line 978}
{:clk 2221.6832 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1458 :dets {:run {:m1 1459, :m2 nil, :m3 1456}, :bufs {:b1 [1458], :b2 [1457]}} :line 979}
{:clk 2221.7952 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1459 :dets {:run {:m1 1459, :m2 1458, :m3 1456}, :bufs {:b1 [], :b2 [1457]}} :line 980}
{:clk 2221.7952 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2223.2952 :j 1460 :dets {:run {:m1 nil, :m2 1458, :m3 1456}, :bufs {:b1 [1459], :b2 [1457]}} :line 981}
{:clk 2222.1832 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2216.1832 :j 1456 :dets {:run {:m1 1460, :m2 1458, :m3 1456}, :bufs {:b1 [1459], :b2 [1457]}} :line 982}
{:clk 2222.1832 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1457 :dets {:run {:m1 1460, :m2 1458, :m3 nil}, :bufs {:b1 [1459], :b2 [1457]}} :line 983}
{:clk 2223.1832 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1458 :dets {:run {:m1 1460, :m2 1458, :m3 1457}, :bufs {:b1 [1459], :b2 []}} :line 984}
{:clk 2223.1832 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1459 :dets {:run {:m1 1460, :m2 nil, :m3 nil}, :bufs {:b1 [1459], :b2 [1458]}} :line 985}
{:clk 2223.1832 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2217.1832 :j 1457 :dets {:run {:m1 1460, :m2 nil, :m3 1457}, :bufs {:b1 [1459], :b2 [1458]}} :line 986}
{:clk 2223.1832 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1458 :dets {:run {:m1 1460, :m2 1459, :m3 nil}, :bufs {:b1 [], :b2 [1458]}} :line 987}
{:clk 2223.2952 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1460 :dets {:run {:m1 1460, :m2 1459, :m3 1458}, :bufs {:b1 [], :b2 []}} :line 988}
{:clk 2223.2952 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2224.2952 :j 1461 :dets {:run {:m1 nil, :m2 1459, :m3 1458}, :bufs {:b1 [1460], :b2 []}} :line 989}
{:clk 2224.2952 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1461 :dets {:run {:m1 1461, :m2 1459, :m3 1458}, :bufs {:b1 [1460], :b2 []}} :line 990}
{:clk 2224.2952 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2225.7952 :j 1462 :dets {:run {:m1 nil, :m2 1459, :m3 1458}, :bufs {:b1 [1460 1461], :b2 []}} :line 991}
{:clk 2224.6832 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1459 :dets {:run {:m1 1462, :m2 1459, :m3 1458}, :bufs {:b1 [1460 1461], :b2 []}} :line 992}
{:clk 2224.6832 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1460 :dets {:run {:m1 1462, :m2 nil, :m3 1458}, :bufs {:b1 [1460 1461], :b2 [1459]}} :line 993}
{:clk 2225.7952 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1462 :dets {:run {:m1 1462, :m2 1460, :m3 1458}, :bufs {:b1 [1461], :b2 [1459]}} :line 994}
{:clk 2225.7952 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2227.2952 :j 1463 :dets {:run {:m1 nil, :m2 1460, :m3 1458}, :bufs {:b1 [1461 1462], :b2 [1459]}} :line 995}
{:clk 2226.1832 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1460 :dets {:run {:m1 1463, :m2 1460, :m3 1458}, :bufs {:b1 [1461 1462], :b2 [1459]}} :line 996}
{:clk 2226.1832 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1461 :dets {:run {:m1 1463, :m2 nil, :m3 1458}, :bufs {:b1 [1461 1462], :b2 [1459 1460]}} :line 997}
{:clk 2226.4689 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2218.7952 :j 1458 :dets {:run {:m1 1463, :m2 1461, :m3 1458}, :bufs {:b1 [1462], :b2 [1459 1460]}} :line 998}
{:clk 2226.4689 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1459 :dets {:run {:m1 1463, :m2 1461, :m3 nil}, :bufs {:b1 [1462], :b2 [1459 1460]}} :line 999}
{:clk 2227.1832 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1461 :dets {:run {:m1 1463, :m2 1461, :m3 1459}, :bufs {:b1 [1462], :b2 [1460]}} :line 1000}
{:clk 2227.1832 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1462 :dets {:run {:m1 1463, :m2 nil, :m3 1459}, :bufs {:b1 [1462], :b2 [1460 1461]}} :line 1001}
{:clk 2227.2952 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1463 :dets {:run {:m1 1463, :m2 1462, :m3 1459}, :bufs {:b1 [], :b2 [1460 1461]}} :line 1002}
{:clk 2227.2952 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2228.2952 :j 1464 :dets {:run {:m1 nil, :m2 1462, :m3 1459}, :bufs {:b1 [1463], :b2 [1460 1461]}} :line 1003}
{:clk 2227.9689 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2220.2952 :j 1459 :dets {:run {:m1 1464, :m2 1462, :m3 1459}, :bufs {:b1 [1463], :b2 [1460 1461]}} :line 1004}
{:clk 2227.9689 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1460 :dets {:run {:m1 1464, :m2 1462, :m3 nil}, :bufs {:b1 [1463], :b2 [1460 1461]}} :line 1005}
{:clk 2228.2952 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1464 :dets {:run {:m1 1464, :m2 1462, :m3 1460}, :bufs {:b1 [1463], :b2 [1461]}} :line 1006}
{:clk 2228.2952 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2229.2952 :j 1465 :dets {:run {:m1 nil, :m2 1462, :m3 1460}, :bufs {:b1 [1463 1464], :b2 [1461]}} :line 1007}
{:clk 2229.2952 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1465, :m2 1462, :m3 1460}, :bufs {:b1 [1463 1464], :b2 [1461]}} :line 1008}
{:clk 2229.4689 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2221.7952 :j 1460 :dets {:run {:m1 1465, :m2 1462, :m3 1460}, :bufs {:b1 [1463 1464], :b2 [1461]}} :line 1009}
{:clk 2229.4689 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1461 :dets {:run {:m1 1465, :m2 1462, :m3 nil}, :bufs {:b1 [1463 1464], :b2 [1461]}} :line 1010}
{:clk 2230.4689 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2223.2952 :j 1461 :dets {:run {:m1 1465, :m2 1462, :m3 1461}, :bufs {:b1 [1463 1464], :b2 []}} :line 1011}
{:clk 2230.4689 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1465, :m2 1462, :m3 nil}, :bufs {:b1 [1463 1464], :b2 []}} :line 1012}
{:clk 2230.5165 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1462 :dets {:run {:m1 1465, :m2 1463, :m3 nil}, :bufs {:b1 [1464], :b2 [1462]}} :line 1013}
{:clk 2230.5165 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1462 :dets {:run {:m1 1465, :m2 1462, :m3 nil}, :bufs {:b1 [1463 1464], :b2 []}} :line 1014}
{:clk 2230.5165 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1463 :dets {:run {:m1 1465, :m2 nil, :m3 nil}, :bufs {:b1 [1463 1464], :b2 [1462]}} :line 1015}
{:clk 2230.5165 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1465, :m2 1463, :m3 1462}, :bufs {:b1 [1464], :b2 []}} :line 1016}
{:clk 2230.5165 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1463, :m3 1462}, :bufs {:b1 [1464 1465], :b2 []}} :line 1017}
{:clk 2230.5165 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1465 :dets {:run {:m1 1465, :m2 1463, :m3 1462}, :bufs {:b1 [1464], :b2 []}} :line 1018}
{:clk 2230.5165 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2232.2991 :j 1466 :dets {:run {:m1 nil, :m2 1463, :m3 1462}, :bufs {:b1 [1464 1465], :b2 []}} :line 1019}
{:clk 2232.0165 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1463 :dets {:run {:m1 1466, :m2 1463, :m3 1462}, :bufs {:b1 [1464 1465], :b2 []}} :line 1020}
{:clk 2232.0165 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1464 :dets {:run {:m1 1466, :m2 nil, :m3 nil}, :bufs {:b1 [1464 1465], :b2 [1463]}} :line 1021}
{:clk 2232.0165 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2224.2952 :j 1462 :dets {:run {:m1 1466, :m2 nil, :m3 1462}, :bufs {:b1 [1464 1465], :b2 [1463]}} :line 1022}
{:clk 2232.0165 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1463 :dets {:run {:m1 1466, :m2 1464, :m3 nil}, :bufs {:b1 [1465], :b2 [1463]}} :line 1023}
{:clk 2232.2991 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1466 :dets {:run {:m1 1466, :m2 1464, :m3 1463}, :bufs {:b1 [1465], :b2 []}} :line 1024}
{:clk 2232.2991 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2233.7991 :j 1467 :dets {:run {:m1 nil, :m2 1464, :m3 1463}, :bufs {:b1 [1465 1466], :b2 []}} :line 1025}
{:clk 2233.0165 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1464 :dets {:run {:m1 1467, :m2 1464, :m3 1463}, :bufs {:b1 [1465 1466], :b2 []}} :line 1026}
{:clk 2233.0165 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1465 :dets {:run {:m1 1467, :m2 nil, :m3 1463}, :bufs {:b1 [1465 1466], :b2 [1464]}} :line 1027}
{:clk 2233.5165 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2225.7952 :j 1463 :dets {:run {:m1 1467, :m2 1465, :m3 1463}, :bufs {:b1 [1466], :b2 [1464]}} :line 1028}
{:clk 2233.5165 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1464 :dets {:run {:m1 1467, :m2 1465, :m3 nil}, :bufs {:b1 [1466], :b2 [1464]}} :line 1029}
{:clk 2233.7991 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1467 :dets {:run {:m1 1467, :m2 1465, :m3 1464}, :bufs {:b1 [1466], :b2 []}} :line 1030}
{:clk 2233.7991 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2235.2991 :j 1468 :dets {:run {:m1 nil, :m2 1465, :m3 1464}, :bufs {:b1 [1466 1467], :b2 []}} :line 1031}
{:clk 2234.0165 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1465 :dets {:run {:m1 1468, :m2 1465, :m3 1464}, :bufs {:b1 [1466 1467], :b2 []}} :line 1032}
{:clk 2234.0165 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1466 :dets {:run {:m1 1468, :m2 nil, :m3 1464}, :bufs {:b1 [1466 1467], :b2 [1465]}} :line 1033}
{:clk 2235.2991 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1468 :dets {:run {:m1 1468, :m2 1466, :m3 1464}, :bufs {:b1 [1467], :b2 [1465]}} :line 1034}
{:clk 2235.2991 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2236.2991 :j 1469 :dets {:run {:m1 nil, :m2 1466, :m3 1464}, :bufs {:b1 [1467 1468], :b2 [1465]}} :line 1035}
{:clk 2235.5165 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1466 :dets {:run {:m1 1469, :m2 1466, :m3 1464}, :bufs {:b1 [1467 1468], :b2 [1465]}} :line 1036}
{:clk 2235.5165 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1467 :dets {:run {:m1 1469, :m2 nil, :m3 1464}, :bufs {:b1 [1467 1468], :b2 [1465 1466]}} :line 1037}
{:clk 2235.9224 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2227.2952 :j 1464 :dets {:run {:m1 1469, :m2 1467, :m3 1464}, :bufs {:b1 [1468], :b2 [1465 1466]}} :line 1038}
{:clk 2235.9224 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1465 :dets {:run {:m1 1469, :m2 1467, :m3 nil}, :bufs {:b1 [1468], :b2 [1465 1466]}} :line 1039}
{:clk 2236.2991 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1469 :dets {:run {:m1 1469, :m2 1467, :m3 1465}, :bufs {:b1 [1468], :b2 [1466]}} :line 1040}
{:clk 2236.2991 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2237.2991 :j 1470 :dets {:run {:m1 nil, :m2 1467, :m3 1465}, :bufs {:b1 [1468 1469], :b2 [1466]}} :line 1041}
{:clk 2236.9224 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2228.2952 :j 1465 :dets {:run {:m1 1470, :m2 1467, :m3 1465}, :bufs {:b1 [1468 1469], :b2 [1466]}} :line 1042}
{:clk 2236.9224 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1466 :dets {:run {:m1 1470, :m2 1467, :m3 nil}, :bufs {:b1 [1468 1469], :b2 [1466]}} :line 1043}
{:clk 2237.0165 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1467 :dets {:run {:m1 1470, :m2 1467, :m3 1466}, :bufs {:b1 [1468 1469], :b2 []}} :line 1044}
{:clk 2237.0165 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1468 :dets {:run {:m1 1470, :m2 nil, :m3 1466}, :bufs {:b1 [1468 1469], :b2 [1467]}} :line 1045}
{:clk 2237.2991 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1470 :dets {:run {:m1 1470, :m2 1468, :m3 1466}, :bufs {:b1 [1469], :b2 [1467]}} :line 1046}
{:clk 2237.2991 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2238.7991 :j 1471 :dets {:run {:m1 nil, :m2 1468, :m3 1466}, :bufs {:b1 [1469 1470], :b2 [1467]}} :line 1047}
{:clk 2238.5165 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1468 :dets {:run {:m1 1471, :m2 1468, :m3 1466}, :bufs {:b1 [1469 1470], :b2 [1467]}} :line 1048}
{:clk 2238.5165 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1469 :dets {:run {:m1 1471, :m2 nil, :m3 1466}, :bufs {:b1 [1469 1470], :b2 [1467 1468]}} :line 1049}
{:clk 2238.7991 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1471 :dets {:run {:m1 1471, :m2 1469, :m3 1466}, :bufs {:b1 [1470], :b2 [1467 1468]}} :line 1050}
{:clk 2238.7991 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2240.2991 :j 1472 :dets {:run {:m1 nil, :m2 1469, :m3 1466}, :bufs {:b1 [1470 1471], :b2 [1467 1468]}} :line 1051}
{:clk 2239.5165 :act :m2-blocked :m :m2 :mjpact :bl :dets {:run {:m1 1472, :m2 1469, :m3 1466}, :bufs {:b1 [1470 1471], :b2 [1467 1468]}} :line 1052}
{:clk 2239.6031 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2230.5165 :j 1466 :dets {:run {:m1 1472, :m2 1469, :m3 1466}, :bufs {:b1 [1470 1471], :b2 [1467 1468]}} :line 1053}
{:clk 2239.6031 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1467 :dets {:run {:m1 1472, :m2 1469, :m3 nil}, :bufs {:b1 [1470 1471], :b2 [1467 1468]}} :line 1054}
{:clk 2239.6031 :act :m2-unblocked :m :m2 :mjpact :ub :dets {:run {:m1 1472, :m2 nil, :m3 1467}, :bufs {:b1 [1470 1471], :b2 [1468 1469]}} :line 1055}
{:clk 2239.6031 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1469 :dets {:run {:m1 1472, :m2 1469, :m3 1467}, :bufs {:b1 [1470 1471], :b2 [1468]}} :line 1056}
{:clk 2239.6031 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1470 :dets {:run {:m1 1472, :m2 nil, :m3 1467}, :bufs {:b1 [1470 1471], :b2 [1468 1469]}} :line 1057}
{:clk 2240.2991 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1472 :dets {:run {:m1 1472, :m2 1470, :m3 1467}, :bufs {:b1 [1471], :b2 [1468 1469]}} :line 1058}
{:clk 2240.2991 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2241.7991 :j 1473 :dets {:run {:m1 nil, :m2 1470, :m3 1467}, :bufs {:b1 [1471 1472], :b2 [1468 1469]}} :line 1059}
{:clk 2240.6031 :act :m2-blocked :m :m2 :mjpact :bl :dets {:run {:m1 1473, :m2 1470, :m3 1467}, :bufs {:b1 [1471 1472], :b2 [1468 1469]}} :line 1060}
{:clk 2241.7110 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2232.2991 :j 1467 :dets {:run {:m1 1473, :m2 1470, :m3 1467}, :bufs {:b1 [1471 1472], :b2 [1468 1469]}} :line 1061}
{:clk 2241.7110 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1468 :dets {:run {:m1 1473, :m2 1470, :m3 nil}, :bufs {:b1 [1471 1472], :b2 [1468 1469]}} :line 1062}
{:clk 2241.7110 :act :m2-unblocked :m :m2 :mjpact :ub :dets {:run {:m1 1473, :m2 nil, :m3 1468}, :bufs {:b1 [1471 1472], :b2 [1469 1470]}} :line 1063}
{:clk 2241.7110 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1470 :dets {:run {:m1 1473, :m2 1470, :m3 1468}, :bufs {:b1 [1471 1472], :b2 [1469]}} :line 1064}
{:clk 2241.7991 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1473, :m2 nil, :m3 1468}, :bufs {:b1 [1471 1472], :b2 [1469 1470]}} :line 1065}
{:clk 2243.2110 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2233.7991 :j 1468 :dets {:run {:m1 1473, :m2 nil, :m3 1468}, :bufs {:b1 [1471 1472], :b2 [1469 1470]}} :line 1066}
{:clk 2243.2110 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1469 :dets {:run {:m1 1473, :m2 nil, :m3 nil}, :bufs {:b1 [1471 1472], :b2 [1469 1470]}} :line 1067}
{:clk 2244.2110 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2235.2991 :j 1469 :dets {:run {:m1 1473, :m2 nil, :m3 1469}, :bufs {:b1 [1471 1472], :b2 [1470]}} :line 1068}
{:clk 2244.2110 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1470 :dets {:run {:m1 1473, :m2 nil, :m3 nil}, :bufs {:b1 [1471 1472], :b2 [1470]}} :line 1069}
{:clk 2245.2110 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2236.2991 :j 1470 :dets {:run {:m1 1473, :m2 nil, :m3 1470}, :bufs {:b1 [1471 1472], :b2 []}} :line 1070}
{:clk 2245.2110 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1473, :m2 nil, :m3 nil}, :bufs {:b1 [1471 1472], :b2 []}} :line 1071}
{:clk 2245.3898 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1471 :dets {:run {:m1 1473, :m2 nil, :m3 nil}, :bufs {:b1 [1471 1472], :b2 []}} :line 1072}
{:clk 2245.3898 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1471, :m3 nil}, :bufs {:b1 [1472 1473], :b2 []}} :line 1073}
{:clk 2245.3898 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1473 :dets {:run {:m1 1473, :m2 1471, :m3 nil}, :bufs {:b1 [1472], :b2 []}} :line 1074}
{:clk 2245.3898 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2246.3898 :j 1474 :dets {:run {:m1 nil, :m2 1471, :m3 nil}, :bufs {:b1 [1472 1473], :b2 []}} :line 1075}
{:clk 2246.3898 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1474, :m2 1471, :m3 nil}, :bufs {:b1 [1472 1473], :b2 []}} :line 1076}
{:clk 2246.8898 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1471 :dets {:run {:m1 1474, :m2 1472, :m3 nil}, :bufs {:b1 [1473], :b2 [1471]}} :line 1077}
{:clk 2246.8898 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1471 :dets {:run {:m1 1474, :m2 1471, :m3 nil}, :bufs {:b1 [1472 1473], :b2 []}} :line 1078}
{:clk 2246.8898 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1472 :dets {:run {:m1 1474, :m2 nil, :m3 nil}, :bufs {:b1 [1472 1473], :b2 [1471]}} :line 1079}
{:clk 2246.8898 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1474, :m2 1472, :m3 1471}, :bufs {:b1 [1473], :b2 []}} :line 1080}
{:clk 2246.8898 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1472, :m3 1471}, :bufs {:b1 [1473 1474], :b2 []}} :line 1081}
{:clk 2246.8898 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1474 :dets {:run {:m1 1474, :m2 1472, :m3 1471}, :bufs {:b1 [1473], :b2 []}} :line 1082}
{:clk 2246.8898 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2248.8657 :j 1475 :dets {:run {:m1 nil, :m2 1472, :m3 1471}, :bufs {:b1 [1473 1474], :b2 []}} :line 1083}
{:clk 2248.3898 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1472 :dets {:run {:m1 1475, :m2 1472, :m3 1471}, :bufs {:b1 [1473 1474], :b2 []}} :line 1084}
{:clk 2248.3898 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1473 :dets {:run {:m1 1475, :m2 nil, :m3 1471}, :bufs {:b1 [1473 1474], :b2 [1472]}} :line 1085}
{:clk 2248.8571 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2237.2991 :j 1471 :dets {:run {:m1 1475, :m2 1473, :m3 1471}, :bufs {:b1 [1474], :b2 [1472]}} :line 1086}
{:clk 2248.8571 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1472 :dets {:run {:m1 1475, :m2 1473, :m3 nil}, :bufs {:b1 [1474], :b2 [1472]}} :line 1087}
{:clk 2248.8657 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1475 :dets {:run {:m1 1475, :m2 1473, :m3 1472}, :bufs {:b1 [1474], :b2 []}} :line 1088}
{:clk 2248.8657 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2250.81 :j 1476 :dets {:run {:m1 nil, :m2 1473, :m3 1472}, :bufs {:b1 [1474 1475], :b2 []}} :line 1089}
{:clk 2249.8898 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1473 :dets {:run {:m1 1476, :m2 1473, :m3 1472}, :bufs {:b1 [1474 1475], :b2 []}} :line 1090}
{:clk 2249.8898 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1474 :dets {:run {:m1 1476, :m2 nil, :m3 1472}, :bufs {:b1 [1474 1475], :b2 [1473]}} :line 1091}
{:clk 2250.8100 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1476 :dets {:run {:m1 1476, :m2 1474, :m3 1472}, :bufs {:b1 [1475], :b2 [1473]}} :line 1092}
{:clk 2250.8100 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2251.81 :j 1477 :dets {:run {:m1 nil, :m2 1474, :m3 1472}, :bufs {:b1 [1475 1476], :b2 [1473]}} :line 1093}
{:clk 2250.8898 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1474 :dets {:run {:m1 1477, :m2 1474, :m3 1472}, :bufs {:b1 [1475 1476], :b2 [1473]}} :line 1094}
{:clk 2250.8898 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1475 :dets {:run {:m1 1477, :m2 nil, :m3 1472}, :bufs {:b1 [1475 1476], :b2 [1473 1474]}} :line 1095}
{:clk 2251.0133 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2238.7991 :j 1472 :dets {:run {:m1 1477, :m2 1475, :m3 1472}, :bufs {:b1 [1476], :b2 [1473 1474]}} :line 1096}
{:clk 2251.0133 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1473 :dets {:run {:m1 1477, :m2 1475, :m3 nil}, :bufs {:b1 [1476], :b2 [1473 1474]}} :line 1097}
{:clk 2251.8100 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1477 :dets {:run {:m1 1477, :m2 1475, :m3 1473}, :bufs {:b1 [1476], :b2 [1474]}} :line 1098}
{:clk 2251.8100 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2253.31 :j 1478 :dets {:run {:m1 nil, :m2 1475, :m3 1473}, :bufs {:b1 [1476 1477], :b2 [1474]}} :line 1099}
{:clk 2251.8898 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1475 :dets {:run {:m1 1478, :m2 1475, :m3 1473}, :bufs {:b1 [1476 1477], :b2 [1474]}} :line 1100}
{:clk 2251.8898 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1476 :dets {:run {:m1 1478, :m2 nil, :m3 1473}, :bufs {:b1 [1476 1477], :b2 [1474 1475]}} :line 1101}
{:clk 2252.5133 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2240.2991 :j 1473 :dets {:run {:m1 1478, :m2 1476, :m3 1473}, :bufs {:b1 [1477], :b2 [1474 1475]}} :line 1102}
{:clk 2252.5133 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1474 :dets {:run {:m1 1478, :m2 1476, :m3 nil}, :bufs {:b1 [1477], :b2 [1474 1475]}} :line 1103}
{:clk 2253.3100 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1478 :dets {:run {:m1 1478, :m2 1476, :m3 1474}, :bufs {:b1 [1477], :b2 [1475]}} :line 1104}
{:clk 2253.3100 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2254.31 :j 1479 :dets {:run {:m1 nil, :m2 1476, :m3 1474}, :bufs {:b1 [1477 1478], :b2 [1475]}} :line 1105}
{:clk 2253.3898 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1476 :dets {:run {:m1 1479, :m2 1476, :m3 1474}, :bufs {:b1 [1477 1478], :b2 [1475]}} :line 1106}
{:clk 2253.3898 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1477 :dets {:run {:m1 1479, :m2 nil, :m3 1474}, :bufs {:b1 [1477 1478], :b2 [1475 1476]}} :line 1107}
{:clk 2253.5133 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2245.3898 :j 1474 :dets {:run {:m1 1479, :m2 1477, :m3 1474}, :bufs {:b1 [1478], :b2 [1475 1476]}} :line 1108}
{:clk 2253.5133 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1475 :dets {:run {:m1 1479, :m2 1477, :m3 nil}, :bufs {:b1 [1478], :b2 [1475 1476]}} :line 1109}
{:clk 2254.3100 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1479 :dets {:run {:m1 1479, :m2 1477, :m3 1475}, :bufs {:b1 [1478], :b2 [1476]}} :line 1110}
{:clk 2254.3100 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2255.31 :j 1480 :dets {:run {:m1 nil, :m2 1477, :m3 1475}, :bufs {:b1 [1478 1479], :b2 [1476]}} :line 1111}
{:clk 2254.3898 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1477 :dets {:run {:m1 1480, :m2 1477, :m3 1475}, :bufs {:b1 [1478 1479], :b2 [1476]}} :line 1112}
{:clk 2254.3898 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1478 :dets {:run {:m1 1480, :m2 nil, :m3 1475}, :bufs {:b1 [1478 1479], :b2 [1476 1477]}} :line 1113}
{:clk 2254.5133 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2246.8898 :j 1475 :dets {:run {:m1 1480, :m2 1478, :m3 1475}, :bufs {:b1 [1479], :b2 [1476 1477]}} :line 1114}
{:clk 2254.5133 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1476 :dets {:run {:m1 1480, :m2 1478, :m3 nil}, :bufs {:b1 [1479], :b2 [1476 1477]}} :line 1115}
{:clk 2255.3100 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1480 :dets {:run {:m1 1480, :m2 1478, :m3 1476}, :bufs {:b1 [1479], :b2 [1477]}} :line 1116}
{:clk 2255.3100 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2256.81 :j 1481 :dets {:run {:m1 nil, :m2 1478, :m3 1476}, :bufs {:b1 [1479 1480], :b2 [1477]}} :line 1117}
{:clk 2255.8898 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1478 :dets {:run {:m1 1481, :m2 1478, :m3 1476}, :bufs {:b1 [1479 1480], :b2 [1477]}} :line 1118}
{:clk 2255.8898 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1479 :dets {:run {:m1 1481, :m2 nil, :m3 1476}, :bufs {:b1 [1479 1480], :b2 [1477 1478]}} :line 1119}
{:clk 2256.0133 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2248.8657 :j 1476 :dets {:run {:m1 1481, :m2 1479, :m3 1476}, :bufs {:b1 [1480], :b2 [1477 1478]}} :line 1120}
{:clk 2256.0133 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1477 :dets {:run {:m1 1481, :m2 1479, :m3 nil}, :bufs {:b1 [1480], :b2 [1477 1478]}} :line 1121}
{:clk 2256.8100 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1481 :dets {:run {:m1 1481, :m2 1479, :m3 1477}, :bufs {:b1 [1480], :b2 [1478]}} :line 1122}
{:clk 2256.8100 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2258.31 :j 1482 :dets {:run {:m1 nil, :m2 1479, :m3 1477}, :bufs {:b1 [1480 1481], :b2 [1478]}} :line 1123}
{:clk 2256.8898 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1479 :dets {:run {:m1 1482, :m2 1479, :m3 1477}, :bufs {:b1 [1480 1481], :b2 [1478]}} :line 1124}
{:clk 2256.8898 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1480 :dets {:run {:m1 1482, :m2 nil, :m3 1477}, :bufs {:b1 [1480 1481], :b2 [1478 1479]}} :line 1125}
{:clk 2257.0133 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2250.81 :j 1477 :dets {:run {:m1 1482, :m2 1480, :m3 1477}, :bufs {:b1 [1481], :b2 [1478 1479]}} :line 1126}
{:clk 2257.0133 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1478 :dets {:run {:m1 1482, :m2 1480, :m3 nil}, :bufs {:b1 [1481], :b2 [1478 1479]}} :line 1127}
{:clk 2258.3100 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1482 :dets {:run {:m1 1482, :m2 1480, :m3 1478}, :bufs {:b1 [1481], :b2 [1479]}} :line 1128}
{:clk 2258.3100 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2262.3993 :j 1483 :dets {:run {:m1 nil, :m2 1480, :m3 1478}, :bufs {:b1 [1481 1482], :b2 [1479]}} :line 1129}
{:clk 2258.5133 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2251.81 :j 1478 :dets {:run {:m1 1483, :m2 1480, :m3 1478}, :bufs {:b1 [1481 1482], :b2 [1479]}} :line 1130}
{:clk 2258.5133 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1479 :dets {:run {:m1 1483, :m2 1480, :m3 nil}, :bufs {:b1 [1481 1482], :b2 [1479]}} :line 1131}
{:clk 2259.5133 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2253.31 :j 1479 :dets {:run {:m1 1483, :m2 1480, :m3 1479}, :bufs {:b1 [1481 1482], :b2 []}} :line 1132}
{:clk 2259.5133 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1483, :m2 1480, :m3 nil}, :bufs {:b1 [1481 1482], :b2 []}} :line 1133}
{:clk 2260.4628 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1480 :dets {:run {:m1 1483, :m2 1480, :m3 nil}, :bufs {:b1 [1481 1482], :b2 []}} :line 1134}
{:clk 2260.4628 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1481 :dets {:run {:m1 1483, :m2 nil, :m3 nil}, :bufs {:b1 [1481 1482], :b2 [1480]}} :line 1135}
{:clk 2260.4628 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1483, :m2 1481, :m3 1480}, :bufs {:b1 [1482], :b2 []}} :line 1136}
{:clk 2260.4628 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1480 :dets {:run {:m1 1483, :m2 1481, :m3 nil}, :bufs {:b1 [1482], :b2 [1480]}} :line 1137}
{:clk 2261.4628 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2254.31 :j 1480 :dets {:run {:m1 1483, :m2 1481, :m3 1480}, :bufs {:b1 [1482], :b2 []}} :line 1138}
{:clk 2261.4628 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1483, :m2 1481, :m3 nil}, :bufs {:b1 [1482], :b2 []}} :line 1139}
{:clk 2262.0855 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1481 :dets {:run {:m1 1483, :m2 1481, :m3 nil}, :bufs {:b1 [1482], :b2 []}} :line 1140}
{:clk 2262.0855 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1482 :dets {:run {:m1 1483, :m2 nil, :m3 nil}, :bufs {:b1 [1482], :b2 [1481]}} :line 1141}
{:clk 2262.0855 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1483, :m2 1482, :m3 1481}, :bufs {:b1 [], :b2 []}} :line 1142}
{:clk 2262.0855 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1481 :dets {:run {:m1 1483, :m2 1482, :m3 nil}, :bufs {:b1 [], :b2 [1481]}} :line 1143}
{:clk 2262.3993 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1483 :dets {:run {:m1 1483, :m2 1482, :m3 1481}, :bufs {:b1 [], :b2 []}} :line 1144}
{:clk 2262.3993 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2263.8993 :j 1484 :dets {:run {:m1 nil, :m2 1482, :m3 1481}, :bufs {:b1 [1483], :b2 []}} :line 1145}
{:clk 2263.5855 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2255.31 :j 1481 :dets {:run {:m1 1484, :m2 1482, :m3 1481}, :bufs {:b1 [1483], :b2 []}} :line 1146}
{:clk 2263.5855 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1484, :m2 1482, :m3 nil}, :bufs {:b1 [1483], :b2 []}} :line 1147}
{:clk 2263.8993 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1484 :dets {:run {:m1 1484, :m2 1482, :m3 nil}, :bufs {:b1 [1483], :b2 []}} :line 1148}
{:clk 2263.8993 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2265.3993 :j 1485 :dets {:run {:m1 nil, :m2 1482, :m3 nil}, :bufs {:b1 [1483 1484], :b2 []}} :line 1149}
{:clk 2264.3758 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1482 :dets {:run {:m1 1485, :m2 1482, :m3 nil}, :bufs {:b1 [1483 1484], :b2 []}} :line 1150}
{:clk 2264.3758 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1483 :dets {:run {:m1 1485, :m2 nil, :m3 nil}, :bufs {:b1 [1483 1484], :b2 [1482]}} :line 1151}
{:clk 2264.3758 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1485, :m2 1483, :m3 1482}, :bufs {:b1 [1484], :b2 []}} :line 1152}
{:clk 2264.3758 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1482 :dets {:run {:m1 1485, :m2 1483, :m3 nil}, :bufs {:b1 [1484], :b2 [1482]}} :line 1153}
{:clk 2265.3993 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1485 :dets {:run {:m1 1485, :m2 1483, :m3 1482}, :bufs {:b1 [1484], :b2 []}} :line 1154}
{:clk 2265.3993 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2266.8993 :j 1486 :dets {:run {:m1 nil, :m2 1483, :m3 1482}, :bufs {:b1 [1484 1485], :b2 []}} :line 1155}
{:clk 2265.8758 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1483 :dets {:run {:m1 1486, :m2 1483, :m3 1482}, :bufs {:b1 [1484 1485], :b2 []}} :line 1156}
{:clk 2265.8758 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1484 :dets {:run {:m1 1486, :m2 nil, :m3 nil}, :bufs {:b1 [1484 1485], :b2 [1483]}} :line 1157}
{:clk 2265.8758 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2256.81 :j 1482 :dets {:run {:m1 1486, :m2 nil, :m3 1482}, :bufs {:b1 [1484 1485], :b2 [1483]}} :line 1158}
{:clk 2265.8758 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1483 :dets {:run {:m1 1486, :m2 1484, :m3 nil}, :bufs {:b1 [1485], :b2 [1483]}} :line 1159}
{:clk 2266.8993 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1486 :dets {:run {:m1 1486, :m2 1484, :m3 1483}, :bufs {:b1 [1485], :b2 []}} :line 1160}
{:clk 2266.8993 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2268.3993 :j 1487 :dets {:run {:m1 nil, :m2 1484, :m3 1483}, :bufs {:b1 [1485 1486], :b2 []}} :line 1161}
{:clk 2267.3758 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1484 :dets {:run {:m1 1487, :m2 1484, :m3 1483}, :bufs {:b1 [1485 1486], :b2 []}} :line 1162}
{:clk 2267.3758 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1485 :dets {:run {:m1 1487, :m2 nil, :m3 nil}, :bufs {:b1 [1485 1486], :b2 [1484]}} :line 1163}
{:clk 2267.3758 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2258.31 :j 1483 :dets {:run {:m1 1487, :m2 nil, :m3 1483}, :bufs {:b1 [1485 1486], :b2 [1484]}} :line 1164}
{:clk 2267.3758 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1484 :dets {:run {:m1 1487, :m2 1485, :m3 nil}, :bufs {:b1 [1486], :b2 [1484]}} :line 1165}
{:clk 2268.3993 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1487 :dets {:run {:m1 1487, :m2 1485, :m3 1484}, :bufs {:b1 [1486], :b2 []}} :line 1166}
{:clk 2268.3993 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2269.3993 :j 1488 :dets {:run {:m1 nil, :m2 1485, :m3 1484}, :bufs {:b1 [1486 1487], :b2 []}} :line 1167}
{:clk 2268.8758 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1485 :dets {:run {:m1 1488, :m2 1485, :m3 1484}, :bufs {:b1 [1486 1487], :b2 []}} :line 1168}
{:clk 2268.8758 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1486 :dets {:run {:m1 1488, :m2 nil, :m3 nil}, :bufs {:b1 [1486 1487], :b2 [1485]}} :line 1169}
{:clk 2268.8758 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2262.3993 :j 1484 :dets {:run {:m1 1488, :m2 nil, :m3 1484}, :bufs {:b1 [1486 1487], :b2 [1485]}} :line 1170}
{:clk 2268.8758 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1485 :dets {:run {:m1 1488, :m2 1486, :m3 nil}, :bufs {:b1 [1487], :b2 [1485]}} :line 1171}
{:clk 2269.3993 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1488 :dets {:run {:m1 1488, :m2 1486, :m3 1485}, :bufs {:b1 [1487], :b2 []}} :line 1172}
{:clk 2269.3993 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2270.8993 :j 1489 :dets {:run {:m1 nil, :m2 1486, :m3 1485}, :bufs {:b1 [1487 1488], :b2 []}} :line 1173}
{:clk 2270.3758 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1486 :dets {:run {:m1 1489, :m2 1486, :m3 1485}, :bufs {:b1 [1487 1488], :b2 []}} :line 1174}
{:clk 2270.3758 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1487 :dets {:run {:m1 1489, :m2 nil, :m3 nil}, :bufs {:b1 [1487 1488], :b2 [1486]}} :line 1175}
{:clk 2270.3758 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2263.8993 :j 1485 :dets {:run {:m1 1489, :m2 nil, :m3 1485}, :bufs {:b1 [1487 1488], :b2 [1486]}} :line 1176}
{:clk 2270.3758 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1486 :dets {:run {:m1 1489, :m2 1487, :m3 nil}, :bufs {:b1 [1488], :b2 [1486]}} :line 1177}
{:clk 2270.8993 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1489 :dets {:run {:m1 1489, :m2 1487, :m3 1486}, :bufs {:b1 [1488], :b2 []}} :line 1178}
{:clk 2270.8993 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2272.3993 :j 1490 :dets {:run {:m1 nil, :m2 1487, :m3 1486}, :bufs {:b1 [1488 1489], :b2 []}} :line 1179}
{:clk 2271.8758 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1487 :dets {:run {:m1 1490, :m2 1487, :m3 1486}, :bufs {:b1 [1488 1489], :b2 []}} :line 1180}
{:clk 2271.8758 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1488 :dets {:run {:m1 1490, :m2 nil, :m3 nil}, :bufs {:b1 [1488 1489], :b2 [1487]}} :line 1181}
{:clk 2271.8758 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2265.3993 :j 1486 :dets {:run {:m1 1490, :m2 nil, :m3 1486}, :bufs {:b1 [1488 1489], :b2 [1487]}} :line 1182}
{:clk 2271.8758 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1487 :dets {:run {:m1 1490, :m2 1488, :m3 nil}, :bufs {:b1 [1489], :b2 [1487]}} :line 1183}
{:clk 2272.3993 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1490 :dets {:run {:m1 1490, :m2 1488, :m3 1487}, :bufs {:b1 [1489], :b2 []}} :line 1184}
{:clk 2272.3993 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2273.3993 :j 1491 :dets {:run {:m1 nil, :m2 1488, :m3 1487}, :bufs {:b1 [1489 1490], :b2 []}} :line 1185}
{:clk 2272.8758 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1488 :dets {:run {:m1 1491, :m2 1488, :m3 1487}, :bufs {:b1 [1489 1490], :b2 []}} :line 1186}
{:clk 2272.8758 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1489 :dets {:run {:m1 1491, :m2 nil, :m3 1487}, :bufs {:b1 [1489 1490], :b2 [1488]}} :line 1187}
{:clk 2273.3758 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2266.8993 :j 1487 :dets {:run {:m1 1491, :m2 1489, :m3 1487}, :bufs {:b1 [1490], :b2 [1488]}} :line 1188}
{:clk 2273.3758 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1488 :dets {:run {:m1 1491, :m2 1489, :m3 nil}, :bufs {:b1 [1490], :b2 [1488]}} :line 1189}
{:clk 2273.3993 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1491 :dets {:run {:m1 1491, :m2 1489, :m3 1488}, :bufs {:b1 [1490], :b2 []}} :line 1190}
{:clk 2273.3993 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2274.3993 :j 1492 :dets {:run {:m1 nil, :m2 1489, :m3 1488}, :bufs {:b1 [1490 1491], :b2 []}} :line 1191}
{:clk 2274.3758 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1489 :dets {:run {:m1 1492, :m2 1489, :m3 1488}, :bufs {:b1 [1490 1491], :b2 []}} :line 1192}
{:clk 2274.3758 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1490 :dets {:run {:m1 1492, :m2 nil, :m3 nil}, :bufs {:b1 [1490 1491], :b2 [1489]}} :line 1193}
{:clk 2274.3758 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2268.3993 :j 1488 :dets {:run {:m1 1492, :m2 nil, :m3 1488}, :bufs {:b1 [1490 1491], :b2 [1489]}} :line 1194}
{:clk 2274.3758 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1489 :dets {:run {:m1 1492, :m2 1490, :m3 nil}, :bufs {:b1 [1491], :b2 [1489]}} :line 1195}
{:clk 2274.3993 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1492 :dets {:run {:m1 1492, :m2 1490, :m3 1489}, :bufs {:b1 [1491], :b2 []}} :line 1196}
{:clk 2274.3993 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2275.8993 :j 1493 :dets {:run {:m1 nil, :m2 1490, :m3 1489}, :bufs {:b1 [1491 1492], :b2 []}} :line 1197}
{:clk 2275.8758 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1490 :dets {:run {:m1 1493, :m2 1490, :m3 1489}, :bufs {:b1 [1491 1492], :b2 []}} :line 1198}
{:clk 2275.8758 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1491 :dets {:run {:m1 1493, :m2 nil, :m3 nil}, :bufs {:b1 [1491 1492], :b2 [1490]}} :line 1199}
{:clk 2275.8758 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2269.3993 :j 1489 :dets {:run {:m1 1493, :m2 nil, :m3 1489}, :bufs {:b1 [1491 1492], :b2 [1490]}} :line 1200}
{:clk 2275.8758 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1490 :dets {:run {:m1 1493, :m2 1491, :m3 nil}, :bufs {:b1 [1492], :b2 [1490]}} :line 1201}
{:clk 2275.8993 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1493 :dets {:run {:m1 1493, :m2 1491, :m3 1490}, :bufs {:b1 [1492], :b2 []}} :line 1202}
{:clk 2275.8993 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2276.8993 :j 1494 :dets {:run {:m1 nil, :m2 1491, :m3 1490}, :bufs {:b1 [1492 1493], :b2 []}} :line 1203}
{:clk 2276.8758 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1491 :dets {:run {:m1 1494, :m2 1491, :m3 1490}, :bufs {:b1 [1492 1493], :b2 []}} :line 1204}
{:clk 2276.8758 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1492 :dets {:run {:m1 1494, :m2 nil, :m3 1490}, :bufs {:b1 [1492 1493], :b2 [1491]}} :line 1205}
{:clk 2276.8993 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1494 :dets {:run {:m1 1494, :m2 1492, :m3 1490}, :bufs {:b1 [1493], :b2 [1491]}} :line 1206}
{:clk 2276.8993 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2278.3993 :j 1495 :dets {:run {:m1 nil, :m2 1492, :m3 1490}, :bufs {:b1 [1493 1494], :b2 [1491]}} :line 1207}
{:clk 2277.3758 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2270.8993 :j 1490 :dets {:run {:m1 1495, :m2 1492, :m3 1490}, :bufs {:b1 [1493 1494], :b2 [1491]}} :line 1208}
{:clk 2277.3758 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1491 :dets {:run {:m1 1495, :m2 1492, :m3 nil}, :bufs {:b1 [1493 1494], :b2 [1491]}} :line 1209}
{:clk 2277.8758 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1492 :dets {:run {:m1 1495, :m2 1492, :m3 1491}, :bufs {:b1 [1493 1494], :b2 []}} :line 1210}
{:clk 2277.8758 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1493 :dets {:run {:m1 1495, :m2 nil, :m3 1491}, :bufs {:b1 [1493 1494], :b2 [1492]}} :line 1211}
{:clk 2278.3758 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2272.3993 :j 1491 :dets {:run {:m1 1495, :m2 1493, :m3 1491}, :bufs {:b1 [1494], :b2 [1492]}} :line 1212}
{:clk 2278.3758 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1492 :dets {:run {:m1 1495, :m2 1493, :m3 nil}, :bufs {:b1 [1494], :b2 [1492]}} :line 1213}
{:clk 2278.3993 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1495 :dets {:run {:m1 1495, :m2 1493, :m3 1492}, :bufs {:b1 [1494], :b2 []}} :line 1214}
{:clk 2278.3993 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2279.8993 :j 1496 :dets {:run {:m1 nil, :m2 1493, :m3 1492}, :bufs {:b1 [1494 1495], :b2 []}} :line 1215}
{:clk 2279.3758 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1493 :dets {:run {:m1 1496, :m2 1493, :m3 1492}, :bufs {:b1 [1494 1495], :b2 []}} :line 1216}
{:clk 2279.3758 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1494 :dets {:run {:m1 1496, :m2 nil, :m3 nil}, :bufs {:b1 [1494 1495], :b2 [1493]}} :line 1217}
{:clk 2279.3758 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2273.3993 :j 1492 :dets {:run {:m1 1496, :m2 nil, :m3 1492}, :bufs {:b1 [1494 1495], :b2 [1493]}} :line 1218}
{:clk 2279.3758 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1493 :dets {:run {:m1 1496, :m2 1494, :m3 nil}, :bufs {:b1 [1495], :b2 [1493]}} :line 1219}
{:clk 2279.8993 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1496 :dets {:run {:m1 1496, :m2 1494, :m3 1493}, :bufs {:b1 [1495], :b2 []}} :line 1220}
{:clk 2279.8993 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2280.8993 :j 1497 :dets {:run {:m1 nil, :m2 1494, :m3 1493}, :bufs {:b1 [1495 1496], :b2 []}} :line 1221}
{:clk 2280.3758 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1494 :dets {:run {:m1 1497, :m2 1494, :m3 1493}, :bufs {:b1 [1495 1496], :b2 []}} :line 1222}
{:clk 2280.3758 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1495 :dets {:run {:m1 1497, :m2 nil, :m3 1493}, :bufs {:b1 [1495 1496], :b2 [1494]}} :line 1223}
{:clk 2280.8758 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2274.3993 :j 1493 :dets {:run {:m1 1497, :m2 1495, :m3 1493}, :bufs {:b1 [1496], :b2 [1494]}} :line 1224}
{:clk 2280.8758 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1494 :dets {:run {:m1 1497, :m2 1495, :m3 nil}, :bufs {:b1 [1496], :b2 [1494]}} :line 1225}
{:clk 2280.8993 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1497 :dets {:run {:m1 1497, :m2 1495, :m3 1494}, :bufs {:b1 [1496], :b2 []}} :line 1226}
{:clk 2280.8993 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2281.8993 :j 1498 :dets {:run {:m1 nil, :m2 1495, :m3 1494}, :bufs {:b1 [1496 1497], :b2 []}} :line 1227}
{:clk 2281.8758 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1495 :dets {:run {:m1 1498, :m2 1495, :m3 1494}, :bufs {:b1 [1496 1497], :b2 []}} :line 1228}
{:clk 2281.8758 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1496 :dets {:run {:m1 1498, :m2 nil, :m3 nil}, :bufs {:b1 [1496 1497], :b2 [1495]}} :line 1229}
{:clk 2281.8758 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2275.8993 :j 1494 :dets {:run {:m1 1498, :m2 nil, :m3 1494}, :bufs {:b1 [1496 1497], :b2 [1495]}} :line 1230}
{:clk 2281.8758 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1495 :dets {:run {:m1 1498, :m2 1496, :m3 nil}, :bufs {:b1 [1497], :b2 [1495]}} :line 1231}
{:clk 2281.8993 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1498 :dets {:run {:m1 1498, :m2 1496, :m3 1495}, :bufs {:b1 [1497], :b2 []}} :line 1232}
{:clk 2281.8993 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2283.3993 :j 1499 :dets {:run {:m1 nil, :m2 1496, :m3 1495}, :bufs {:b1 [1497 1498], :b2 []}} :line 1233}
{:clk 2283.3758 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1496 :dets {:run {:m1 1499, :m2 1496, :m3 1495}, :bufs {:b1 [1497 1498], :b2 []}} :line 1234}
{:clk 2283.3758 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1497 :dets {:run {:m1 1499, :m2 nil, :m3 1495}, :bufs {:b1 [1497 1498], :b2 [1496]}} :line 1235}
{:clk 2283.3993 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1499 :dets {:run {:m1 1499, :m2 1497, :m3 1495}, :bufs {:b1 [1498], :b2 [1496]}} :line 1236}
{:clk 2283.3993 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2284.8993 :j 1500 :dets {:run {:m1 nil, :m2 1497, :m3 1495}, :bufs {:b1 [1498 1499], :b2 [1496]}} :line 1237}
{:clk 2283.9851 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2276.8993 :j 1495 :dets {:run {:m1 1500, :m2 1497, :m3 1495}, :bufs {:b1 [1498 1499], :b2 [1496]}} :line 1238}
{:clk 2283.9851 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1496 :dets {:run {:m1 1500, :m2 1497, :m3 nil}, :bufs {:b1 [1498 1499], :b2 [1496]}} :line 1239}
{:clk 2284.3758 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1497 :dets {:run {:m1 1500, :m2 1497, :m3 1496}, :bufs {:b1 [1498 1499], :b2 []}} :line 1240}
{:clk 2284.3758 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1498 :dets {:run {:m1 1500, :m2 nil, :m3 1496}, :bufs {:b1 [1498 1499], :b2 [1497]}} :line 1241}
{:clk 2284.8993 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1500 :dets {:run {:m1 1500, :m2 1498, :m3 1496}, :bufs {:b1 [1499], :b2 [1497]}} :line 1242}
{:clk 2284.8993 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2285.8993 :j 1501 :dets {:run {:m1 nil, :m2 1498, :m3 1496}, :bufs {:b1 [1499 1500], :b2 [1497]}} :line 1243}
{:clk 2285.3758 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1498 :dets {:run {:m1 1501, :m2 1498, :m3 1496}, :bufs {:b1 [1499 1500], :b2 [1497]}} :line 1244}
{:clk 2285.3758 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1499 :dets {:run {:m1 1501, :m2 nil, :m3 1496}, :bufs {:b1 [1499 1500], :b2 [1497 1498]}} :line 1245}
{:clk 2285.4851 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2278.3993 :j 1496 :dets {:run {:m1 1501, :m2 1499, :m3 1496}, :bufs {:b1 [1500], :b2 [1497 1498]}} :line 1246}
{:clk 2285.4851 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1497 :dets {:run {:m1 1501, :m2 1499, :m3 nil}, :bufs {:b1 [1500], :b2 [1497 1498]}} :line 1247}
{:clk 2285.8993 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1501 :dets {:run {:m1 1501, :m2 1499, :m3 1497}, :bufs {:b1 [1500], :b2 [1498]}} :line 1248}
{:clk 2285.8993 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2287.3993 :j 1502 :dets {:run {:m1 nil, :m2 1499, :m3 1497}, :bufs {:b1 [1500 1501], :b2 [1498]}} :line 1249}
{:clk 2286.4851 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2279.8993 :j 1497 :dets {:run {:m1 1502, :m2 1499, :m3 1497}, :bufs {:b1 [1500 1501], :b2 [1498]}} :line 1250}
{:clk 2286.4851 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1498 :dets {:run {:m1 1502, :m2 1499, :m3 nil}, :bufs {:b1 [1500 1501], :b2 [1498]}} :line 1251}
{:clk 2286.8758 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1499 :dets {:run {:m1 1502, :m2 1499, :m3 1498}, :bufs {:b1 [1500 1501], :b2 []}} :line 1252}
{:clk 2286.8758 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1500 :dets {:run {:m1 1502, :m2 nil, :m3 1498}, :bufs {:b1 [1500 1501], :b2 [1499]}} :line 1253}
{:clk 2287.3993 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1502 :dets {:run {:m1 1502, :m2 1500, :m3 1498}, :bufs {:b1 [1501], :b2 [1499]}} :line 1254}
{:clk 2287.3993 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2290.2691 :j 1503 :dets {:run {:m1 nil, :m2 1500, :m3 1498}, :bufs {:b1 [1501 1502], :b2 [1499]}} :line 1255}
{:clk 2287.4851 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2280.8993 :j 1498 :dets {:run {:m1 1503, :m2 1500, :m3 1498}, :bufs {:b1 [1501 1502], :b2 [1499]}} :line 1256}
{:clk 2287.4851 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1499 :dets {:run {:m1 1503, :m2 1500, :m3 nil}, :bufs {:b1 [1501 1502], :b2 [1499]}} :line 1257}
{:clk 2288.3758 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1500 :dets {:run {:m1 1503, :m2 1500, :m3 1499}, :bufs {:b1 [1501 1502], :b2 []}} :line 1258}
{:clk 2288.3758 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1501 :dets {:run {:m1 1503, :m2 nil, :m3 1499}, :bufs {:b1 [1501 1502], :b2 [1500]}} :line 1259}
{:clk 2289.0492 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2281.8993 :j 1499 :dets {:run {:m1 1503, :m2 1501, :m3 1499}, :bufs {:b1 [1502], :b2 [1500]}} :line 1260}
{:clk 2289.0492 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1500 :dets {:run {:m1 1503, :m2 1501, :m3 nil}, :bufs {:b1 [1502], :b2 [1500]}} :line 1261}
{:clk 2290.1216 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1501 :dets {:run {:m1 1503, :m2 1501, :m3 1500}, :bufs {:b1 [1502], :b2 []}} :line 1262}
{:clk 2290.1216 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1502 :dets {:run {:m1 1503, :m2 nil, :m3 1500}, :bufs {:b1 [1502], :b2 [1501]}} :line 1263}
{:clk 2290.2691 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1503 :dets {:run {:m1 1503, :m2 1502, :m3 1500}, :bufs {:b1 [], :b2 [1501]}} :line 1264}
{:clk 2290.2691 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2291.2691 :j 1504 :dets {:run {:m1 nil, :m2 1502, :m3 1500}, :bufs {:b1 [1503], :b2 [1501]}} :line 1265}
{:clk 2290.5492 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2283.3993 :j 1500 :dets {:run {:m1 1504, :m2 1502, :m3 1500}, :bufs {:b1 [1503], :b2 [1501]}} :line 1266}
{:clk 2290.5492 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1501 :dets {:run {:m1 1504, :m2 1502, :m3 nil}, :bufs {:b1 [1503], :b2 [1501]}} :line 1267}
{:clk 2291.2691 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1504 :dets {:run {:m1 1504, :m2 1502, :m3 1501}, :bufs {:b1 [1503], :b2 []}} :line 1268}
{:clk 2291.2691 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2292.7691 :j 1505 :dets {:run {:m1 nil, :m2 1502, :m3 1501}, :bufs {:b1 [1503 1504], :b2 []}} :line 1269}
{:clk 2291.5492 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2284.8993 :j 1501 :dets {:run {:m1 1505, :m2 1502, :m3 1501}, :bufs {:b1 [1503 1504], :b2 []}} :line 1270}
{:clk 2291.5492 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1505, :m2 1502, :m3 nil}, :bufs {:b1 [1503 1504], :b2 []}} :line 1271}
{:clk 2291.6216 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1502 :dets {:run {:m1 1505, :m2 1502, :m3 nil}, :bufs {:b1 [1503 1504], :b2 []}} :line 1272}
{:clk 2291.6216 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1503 :dets {:run {:m1 1505, :m2 nil, :m3 nil}, :bufs {:b1 [1503 1504], :b2 [1502]}} :line 1273}
{:clk 2291.6216 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1505, :m2 1503, :m3 1502}, :bufs {:b1 [1504], :b2 []}} :line 1274}
{:clk 2291.6216 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1502 :dets {:run {:m1 1505, :m2 1503, :m3 nil}, :bufs {:b1 [1504], :b2 [1502]}} :line 1275}
{:clk 2292.6216 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1503 :dets {:run {:m1 1505, :m2 1503, :m3 1502}, :bufs {:b1 [1504], :b2 []}} :line 1276}
{:clk 2292.6216 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1504 :dets {:run {:m1 1505, :m2 nil, :m3 1502}, :bufs {:b1 [1504], :b2 [1503]}} :line 1277}
{:clk 2292.7691 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1505 :dets {:run {:m1 1505, :m2 1504, :m3 1502}, :bufs {:b1 [], :b2 [1503]}} :line 1278}
{:clk 2292.7691 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2293.7691 :j 1506 :dets {:run {:m1 nil, :m2 1504, :m3 1502}, :bufs {:b1 [1505], :b2 [1503]}} :line 1279}
{:clk 2293.1216 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2285.8993 :j 1502 :dets {:run {:m1 1506, :m2 1504, :m3 1502}, :bufs {:b1 [1505], :b2 [1503]}} :line 1280}
{:clk 2293.1216 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1503 :dets {:run {:m1 1506, :m2 1504, :m3 nil}, :bufs {:b1 [1505], :b2 [1503]}} :line 1281}
{:clk 2293.6216 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1504 :dets {:run {:m1 1506, :m2 1504, :m3 1503}, :bufs {:b1 [1505], :b2 []}} :line 1282}
{:clk 2293.6216 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1505 :dets {:run {:m1 1506, :m2 nil, :m3 1503}, :bufs {:b1 [1505], :b2 [1504]}} :line 1283}
{:clk 2293.7691 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1506 :dets {:run {:m1 1506, :m2 1505, :m3 1503}, :bufs {:b1 [], :b2 [1504]}} :line 1284}
{:clk 2293.7691 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2294.7691 :j 1507 :dets {:run {:m1 nil, :m2 1505, :m3 1503}, :bufs {:b1 [1506], :b2 [1504]}} :line 1285}
{:clk 2294.1216 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2287.3993 :j 1503 :dets {:run {:m1 1507, :m2 1505, :m3 1503}, :bufs {:b1 [1506], :b2 [1504]}} :line 1286}
{:clk 2294.1216 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1504 :dets {:run {:m1 1507, :m2 1505, :m3 nil}, :bufs {:b1 [1506], :b2 [1504]}} :line 1287}
{:clk 2294.7691 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1507 :dets {:run {:m1 1507, :m2 1505, :m3 1504}, :bufs {:b1 [1506], :b2 []}} :line 1288}
{:clk 2294.7691 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2296.2691 :j 1508 :dets {:run {:m1 nil, :m2 1505, :m3 1504}, :bufs {:b1 [1506 1507], :b2 []}} :line 1289}
{:clk 2295.1216 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1505 :dets {:run {:m1 1508, :m2 1505, :m3 1504}, :bufs {:b1 [1506 1507], :b2 []}} :line 1290}
{:clk 2295.1216 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1506 :dets {:run {:m1 1508, :m2 nil, :m3 nil}, :bufs {:b1 [1506 1507], :b2 [1505]}} :line 1291}
{:clk 2295.1216 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2290.2691 :j 1504 :dets {:run {:m1 1508, :m2 nil, :m3 1504}, :bufs {:b1 [1506 1507], :b2 [1505]}} :line 1292}
{:clk 2295.1216 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1505 :dets {:run {:m1 1508, :m2 1506, :m3 nil}, :bufs {:b1 [1507], :b2 [1505]}} :line 1293}
{:clk 2296.1216 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1506 :dets {:run {:m1 1508, :m2 1506, :m3 1505}, :bufs {:b1 [1507], :b2 []}} :line 1294}
{:clk 2296.1216 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1507 :dets {:run {:m1 1508, :m2 nil, :m3 1505}, :bufs {:b1 [1507], :b2 [1506]}} :line 1295}
{:clk 2296.2691 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1508 :dets {:run {:m1 1508, :m2 1507, :m3 1505}, :bufs {:b1 [], :b2 [1506]}} :line 1296}
{:clk 2296.2691 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2297.7691 :j 1509 :dets {:run {:m1 nil, :m2 1507, :m3 1505}, :bufs {:b1 [1508], :b2 [1506]}} :line 1297}
{:clk 2296.6216 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2291.2691 :j 1505 :dets {:run {:m1 1509, :m2 1507, :m3 1505}, :bufs {:b1 [1508], :b2 [1506]}} :line 1298}
{:clk 2296.6216 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1506 :dets {:run {:m1 1509, :m2 1507, :m3 nil}, :bufs {:b1 [1508], :b2 [1506]}} :line 1299}
{:clk 2297.1216 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1507 :dets {:run {:m1 1509, :m2 1507, :m3 1506}, :bufs {:b1 [1508], :b2 []}} :line 1300}
{:clk 2297.1216 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1508 :dets {:run {:m1 1509, :m2 nil, :m3 1506}, :bufs {:b1 [1508], :b2 [1507]}} :line 1301}
{:clk 2297.6216 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2292.7691 :j 1506 :dets {:run {:m1 1509, :m2 1508, :m3 1506}, :bufs {:b1 [], :b2 [1507]}} :line 1302}
{:clk 2297.6216 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1507 :dets {:run {:m1 1509, :m2 1508, :m3 nil}, :bufs {:b1 [], :b2 [1507]}} :line 1303}
{:clk 2297.7691 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1509 :dets {:run {:m1 1509, :m2 1508, :m3 1507}, :bufs {:b1 [], :b2 []}} :line 1304}
{:clk 2297.7691 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2299.2691 :j 1510 :dets {:run {:m1 nil, :m2 1508, :m3 1507}, :bufs {:b1 [1509], :b2 []}} :line 1305}
{:clk 2298.6216 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1508 :dets {:run {:m1 1510, :m2 1508, :m3 1507}, :bufs {:b1 [1509], :b2 []}} :line 1306}
{:clk 2298.6216 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1509 :dets {:run {:m1 1510, :m2 nil, :m3 nil}, :bufs {:b1 [1509], :b2 [1508]}} :line 1307}
{:clk 2298.6216 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2293.7691 :j 1507 :dets {:run {:m1 1510, :m2 nil, :m3 1507}, :bufs {:b1 [1509], :b2 [1508]}} :line 1308}
{:clk 2298.6216 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1508 :dets {:run {:m1 1510, :m2 1509, :m3 nil}, :bufs {:b1 [], :b2 [1508]}} :line 1309}
{:clk 2299.2691 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1510 :dets {:run {:m1 1510, :m2 1509, :m3 1508}, :bufs {:b1 [], :b2 []}} :line 1310}
{:clk 2299.2691 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2300.2691 :j 1511 :dets {:run {:m1 nil, :m2 1509, :m3 1508}, :bufs {:b1 [1510], :b2 []}} :line 1311}
{:clk 2300.1216 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1509 :dets {:run {:m1 1511, :m2 1509, :m3 1508}, :bufs {:b1 [1510], :b2 []}} :line 1312}
{:clk 2300.1216 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1510 :dets {:run {:m1 1511, :m2 nil, :m3 nil}, :bufs {:b1 [1510], :b2 [1509]}} :line 1313}
{:clk 2300.1216 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2294.7691 :j 1508 :dets {:run {:m1 1511, :m2 nil, :m3 1508}, :bufs {:b1 [1510], :b2 [1509]}} :line 1314}
{:clk 2300.1216 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1509 :dets {:run {:m1 1511, :m2 1510, :m3 nil}, :bufs {:b1 [], :b2 [1509]}} :line 1315}
{:clk 2300.2691 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1511 :dets {:run {:m1 1511, :m2 1510, :m3 1509}, :bufs {:b1 [], :b2 []}} :line 1316}
{:clk 2300.2691 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2301.7691 :j 1512 :dets {:run {:m1 nil, :m2 1510, :m3 1509}, :bufs {:b1 [1511], :b2 []}} :line 1317}
{:clk 2301.6216 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1510 :dets {:run {:m1 1512, :m2 1510, :m3 1509}, :bufs {:b1 [1511], :b2 []}} :line 1318}
{:clk 2301.6216 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1511 :dets {:run {:m1 1512, :m2 nil, :m3 nil}, :bufs {:b1 [1511], :b2 [1510]}} :line 1319}
{:clk 2301.6216 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2296.2691 :j 1509 :dets {:run {:m1 1512, :m2 nil, :m3 1509}, :bufs {:b1 [1511], :b2 [1510]}} :line 1320}
{:clk 2301.6216 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1510 :dets {:run {:m1 1512, :m2 1511, :m3 nil}, :bufs {:b1 [], :b2 [1510]}} :line 1321}
{:clk 2301.7691 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1512 :dets {:run {:m1 1512, :m2 1511, :m3 1510}, :bufs {:b1 [], :b2 []}} :line 1322}
{:clk 2301.7691 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2303.2691 :j 1513 :dets {:run {:m1 nil, :m2 1511, :m3 1510}, :bufs {:b1 [1512], :b2 []}} :line 1323}
{:clk 2302.6216 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1511 :dets {:run {:m1 1513, :m2 1511, :m3 1510}, :bufs {:b1 [1512], :b2 []}} :line 1324}
{:clk 2302.6216 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1512 :dets {:run {:m1 1513, :m2 nil, :m3 1510}, :bufs {:b1 [1512], :b2 [1511]}} :line 1325}
{:clk 2303.1216 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2297.7691 :j 1510 :dets {:run {:m1 1513, :m2 1512, :m3 1510}, :bufs {:b1 [], :b2 [1511]}} :line 1326}
{:clk 2303.1216 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1511 :dets {:run {:m1 1513, :m2 1512, :m3 nil}, :bufs {:b1 [], :b2 [1511]}} :line 1327}
{:clk 2303.2691 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1513 :dets {:run {:m1 1513, :m2 1512, :m3 1511}, :bufs {:b1 [], :b2 []}} :line 1328}
{:clk 2303.2691 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2304.7691 :j 1514 :dets {:run {:m1 nil, :m2 1512, :m3 1511}, :bufs {:b1 [1513], :b2 []}} :line 1329}
{:clk 2304.1216 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1512 :dets {:run {:m1 1514, :m2 1512, :m3 1511}, :bufs {:b1 [1513], :b2 []}} :line 1330}
{:clk 2304.1216 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1513 :dets {:run {:m1 1514, :m2 nil, :m3 1511}, :bufs {:b1 [1513], :b2 [1512]}} :line 1331}
{:clk 2304.7691 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1514 :dets {:run {:m1 1514, :m2 1513, :m3 1511}, :bufs {:b1 [], :b2 [1512]}} :line 1332}
{:clk 2304.7691 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2306.2691 :j 1515 :dets {:run {:m1 nil, :m2 1513, :m3 1511}, :bufs {:b1 [1514], :b2 [1512]}} :line 1333}
{:clk 2304.9727 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2299.2691 :j 1511 :dets {:run {:m1 1515, :m2 1513, :m3 1511}, :bufs {:b1 [1514], :b2 [1512]}} :line 1334}
{:clk 2304.9727 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1512 :dets {:run {:m1 1515, :m2 1513, :m3 nil}, :bufs {:b1 [1514], :b2 [1512]}} :line 1335}
{:clk 2305.6216 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1513 :dets {:run {:m1 1515, :m2 1513, :m3 1512}, :bufs {:b1 [1514], :b2 []}} :line 1336}
{:clk 2305.6216 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1514 :dets {:run {:m1 1515, :m2 nil, :m3 1512}, :bufs {:b1 [1514], :b2 [1513]}} :line 1337}
{:clk 2306.2691 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1515 :dets {:run {:m1 1515, :m2 1514, :m3 1512}, :bufs {:b1 [], :b2 [1513]}} :line 1338}
{:clk 2306.2691 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2307.7691 :j 1516 :dets {:run {:m1 nil, :m2 1514, :m3 1512}, :bufs {:b1 [1515], :b2 [1513]}} :line 1339}
{:clk 2306.4727 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2300.2691 :j 1512 :dets {:run {:m1 1516, :m2 1514, :m3 1512}, :bufs {:b1 [1515], :b2 [1513]}} :line 1340}
{:clk 2306.4727 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1513 :dets {:run {:m1 1516, :m2 1514, :m3 nil}, :bufs {:b1 [1515], :b2 [1513]}} :line 1341}
{:clk 2307.1216 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1514 :dets {:run {:m1 1516, :m2 1514, :m3 1513}, :bufs {:b1 [1515], :b2 []}} :line 1342}
{:clk 2307.1216 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1515 :dets {:run {:m1 1516, :m2 nil, :m3 1513}, :bufs {:b1 [1515], :b2 [1514]}} :line 1343}
{:clk 2307.7691 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1516 :dets {:run {:m1 1516, :m2 1515, :m3 1513}, :bufs {:b1 [], :b2 [1514]}} :line 1344}
{:clk 2307.7691 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2308.7691 :j 1517 :dets {:run {:m1 nil, :m2 1515, :m3 1513}, :bufs {:b1 [1516], :b2 [1514]}} :line 1345}
{:clk 2307.9727 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2301.7691 :j 1513 :dets {:run {:m1 1517, :m2 1515, :m3 1513}, :bufs {:b1 [1516], :b2 [1514]}} :line 1346}
{:clk 2307.9727 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1514 :dets {:run {:m1 1517, :m2 1515, :m3 nil}, :bufs {:b1 [1516], :b2 [1514]}} :line 1347}
{:clk 2308.7691 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1517 :dets {:run {:m1 1517, :m2 1515, :m3 1514}, :bufs {:b1 [1516], :b2 []}} :line 1348}
{:clk 2308.7691 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2309.7691 :j 1518 :dets {:run {:m1 nil, :m2 1515, :m3 1514}, :bufs {:b1 [1516 1517], :b2 []}} :line 1349}
{:clk 2309.4727 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2303.2691 :j 1514 :dets {:run {:m1 1518, :m2 1515, :m3 1514}, :bufs {:b1 [1516 1517], :b2 []}} :line 1350}
{:clk 2309.4727 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1518, :m2 1515, :m3 nil}, :bufs {:b1 [1516 1517], :b2 []}} :line 1351}
{:clk 2309.7691 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1518, :m2 1515, :m3 nil}, :bufs {:b1 [1516 1517], :b2 []}} :line 1352}
{:clk 2310.0934 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1515 :dets {:run {:m1 1518, :m2 1516, :m3 nil}, :bufs {:b1 [1517], :b2 [1515]}} :line 1353}
{:clk 2310.0934 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1515 :dets {:run {:m1 1518, :m2 1515, :m3 nil}, :bufs {:b1 [1516 1517], :b2 []}} :line 1354}
{:clk 2310.0934 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1516 :dets {:run {:m1 1518, :m2 nil, :m3 nil}, :bufs {:b1 [1516 1517], :b2 [1515]}} :line 1355}
{:clk 2310.0934 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1518, :m2 1516, :m3 1515}, :bufs {:b1 [1517], :b2 []}} :line 1356}
{:clk 2310.0934 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1516, :m3 1515}, :bufs {:b1 [1517 1518], :b2 []}} :line 1357}
{:clk 2310.0934 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1518 :dets {:run {:m1 1518, :m2 1516, :m3 1515}, :bufs {:b1 [1517], :b2 []}} :line 1358}
{:clk 2310.0934 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2311.5934 :j 1519 :dets {:run {:m1 nil, :m2 1516, :m3 1515}, :bufs {:b1 [1517 1518], :b2 []}} :line 1359}
{:clk 2311.5934 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1519 :dets {:run {:m1 1519, :m2 1517, :m3 1516}, :bufs {:b1 [1518], :b2 []}} :line 1360}
{:clk 2311.5934 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2313.3578 :j 1520 :dets {:run {:m1 nil, :m2 1517, :m3 1516}, :bufs {:b1 [1518 1519], :b2 []}} :line 1361}
{:clk 2311.5934 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1516 :dets {:run {:m1 1519, :m2 1516, :m3 1515}, :bufs {:b1 [1517 1518], :b2 []}} :line 1362}
{:clk 2311.5934 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1517 :dets {:run {:m1 1519, :m2 nil, :m3 nil}, :bufs {:b1 [1517 1518], :b2 [1516]}} :line 1363}
{:clk 2311.5934 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2304.7691 :j 1515 :dets {:run {:m1 1519, :m2 nil, :m3 1515}, :bufs {:b1 [1517 1518], :b2 [1516]}} :line 1364}
{:clk 2311.5934 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1516 :dets {:run {:m1 1519, :m2 1517, :m3 nil}, :bufs {:b1 [1518], :b2 [1516]}} :line 1365}
{:clk 2312.5934 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1517 :dets {:run {:m1 1520, :m2 1517, :m3 1516}, :bufs {:b1 [1518 1519], :b2 []}} :line 1366}
{:clk 2312.5934 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1518 :dets {:run {:m1 1520, :m2 nil, :m3 1516}, :bufs {:b1 [1518 1519], :b2 [1517]}} :line 1367}
{:clk 2313.0934 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2306.2691 :j 1516 :dets {:run {:m1 1520, :m2 1518, :m3 1516}, :bufs {:b1 [1519], :b2 [1517]}} :line 1368}
{:clk 2313.0934 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1517 :dets {:run {:m1 1520, :m2 1518, :m3 nil}, :bufs {:b1 [1519], :b2 [1517]}} :line 1369}
{:clk 2313.3578 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1520 :dets {:run {:m1 1520, :m2 1518, :m3 1517}, :bufs {:b1 [1519], :b2 []}} :line 1370}
{:clk 2313.3578 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2314.8578 :j 1521 :dets {:run {:m1 nil, :m2 1518, :m3 1517}, :bufs {:b1 [1519 1520], :b2 []}} :line 1371}
{:clk 2313.5934 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1518 :dets {:run {:m1 1521, :m2 1518, :m3 1517}, :bufs {:b1 [1519 1520], :b2 []}} :line 1372}
{:clk 2313.5934 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1519 :dets {:run {:m1 1521, :m2 nil, :m3 1517}, :bufs {:b1 [1519 1520], :b2 [1518]}} :line 1373}
{:clk 2314.8578 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1521 :dets {:run {:m1 1521, :m2 1519, :m3 1517}, :bufs {:b1 [1520], :b2 [1518]}} :line 1374}
{:clk 2314.8578 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2316.62 :j 1522 :dets {:run {:m1 nil, :m2 1519, :m3 1517}, :bufs {:b1 [1520 1521], :b2 [1518]}} :line 1375}
{:clk 2314.8942 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2307.7691 :j 1517 :dets {:run {:m1 1522, :m2 1519, :m3 1517}, :bufs {:b1 [1520 1521], :b2 [1518]}} :line 1376}
{:clk 2314.8942 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1518 :dets {:run {:m1 1522, :m2 1519, :m3 nil}, :bufs {:b1 [1520 1521], :b2 [1518]}} :line 1377}
{:clk 2315.0934 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1519 :dets {:run {:m1 1522, :m2 1519, :m3 1518}, :bufs {:b1 [1520 1521], :b2 []}} :line 1378}
{:clk 2315.0934 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1520 :dets {:run {:m1 1522, :m2 nil, :m3 1518}, :bufs {:b1 [1520 1521], :b2 [1519]}} :line 1379}
{:clk 2315.8942 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2308.7691 :j 1518 :dets {:run {:m1 1522, :m2 1520, :m3 1518}, :bufs {:b1 [1521], :b2 [1519]}} :line 1380}
{:clk 2315.8942 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1519 :dets {:run {:m1 1522, :m2 1520, :m3 nil}, :bufs {:b1 [1521], :b2 [1519]}} :line 1381}
{:clk 2316.0934 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1520 :dets {:run {:m1 1522, :m2 1520, :m3 1519}, :bufs {:b1 [1521], :b2 []}} :line 1382}
{:clk 2316.0934 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1521 :dets {:run {:m1 1522, :m2 nil, :m3 1519}, :bufs {:b1 [1521], :b2 [1520]}} :line 1383}
{:clk 2316.6200 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1522 :dets {:run {:m1 1522, :m2 1521, :m3 1519}, :bufs {:b1 [], :b2 [1520]}} :line 1384}
{:clk 2316.6200 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2318.12 :j 1523 :dets {:run {:m1 nil, :m2 1521, :m3 1519}, :bufs {:b1 [1522], :b2 [1520]}} :line 1385}
{:clk 2317.3942 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2310.0934 :j 1519 :dets {:run {:m1 1523, :m2 1521, :m3 1519}, :bufs {:b1 [1522], :b2 [1520]}} :line 1386}
{:clk 2317.3942 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1520 :dets {:run {:m1 1523, :m2 1521, :m3 nil}, :bufs {:b1 [1522], :b2 [1520]}} :line 1387}
{:clk 2317.5934 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1521 :dets {:run {:m1 1523, :m2 1521, :m3 1520}, :bufs {:b1 [1522], :b2 []}} :line 1388}
{:clk 2317.5934 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1522 :dets {:run {:m1 1523, :m2 nil, :m3 1520}, :bufs {:b1 [1522], :b2 [1521]}} :line 1389}
{:clk 2318.1200 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1523 :dets {:run {:m1 1523, :m2 1522, :m3 1520}, :bufs {:b1 [], :b2 [1521]}} :line 1390}
{:clk 2318.1200 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2319.62 :j 1524 :dets {:run {:m1 nil, :m2 1522, :m3 1520}, :bufs {:b1 [1523], :b2 [1521]}} :line 1391}
{:clk 2318.3942 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2311.5934 :j 1520 :dets {:run {:m1 1524, :m2 1522, :m3 1520}, :bufs {:b1 [1523], :b2 [1521]}} :line 1392}
{:clk 2318.3942 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1521 :dets {:run {:m1 1524, :m2 1522, :m3 nil}, :bufs {:b1 [1523], :b2 [1521]}} :line 1393}
{:clk 2318.5934 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1522 :dets {:run {:m1 1524, :m2 1522, :m3 1521}, :bufs {:b1 [1523], :b2 []}} :line 1394}
{:clk 2318.5934 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1523 :dets {:run {:m1 1524, :m2 nil, :m3 1521}, :bufs {:b1 [1523], :b2 [1522]}} :line 1395}
{:clk 2319.6200 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1524 :dets {:run {:m1 1524, :m2 1523, :m3 1521}, :bufs {:b1 [], :b2 [1522]}} :line 1396}
{:clk 2319.6200 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2320.62 :j 1525 :dets {:run {:m1 nil, :m2 1523, :m3 1521}, :bufs {:b1 [1524], :b2 [1522]}} :line 1397}
{:clk 2320.0934 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1523 :dets {:run {:m1 1525, :m2 1523, :m3 1521}, :bufs {:b1 [1524], :b2 [1522]}} :line 1398}
{:clk 2320.0934 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1524 :dets {:run {:m1 1525, :m2 nil, :m3 1521}, :bufs {:b1 [1524], :b2 [1522 1523]}} :line 1399}
{:clk 2320.1375 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2313.3578 :j 1521 :dets {:run {:m1 1525, :m2 1524, :m3 1521}, :bufs {:b1 [], :b2 [1522 1523]}} :line 1400}
{:clk 2320.1375 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1522 :dets {:run {:m1 1525, :m2 1524, :m3 nil}, :bufs {:b1 [], :b2 [1522 1523]}} :line 1401}
{:clk 2320.6200 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1525 :dets {:run {:m1 1525, :m2 1524, :m3 1522}, :bufs {:b1 [], :b2 [1523]}} :line 1402}
{:clk 2320.6200 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2322.4967 :j 1526 :dets {:run {:m1 nil, :m2 1524, :m3 1522}, :bufs {:b1 [1525], :b2 [1523]}} :line 1403}
{:clk 2321.1375 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2314.8578 :j 1522 :dets {:run {:m1 1526, :m2 1524, :m3 1522}, :bufs {:b1 [1525], :b2 [1523]}} :line 1404}
{:clk 2321.1375 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1523 :dets {:run {:m1 1526, :m2 1524, :m3 nil}, :bufs {:b1 [1525], :b2 [1523]}} :line 1405}
{:clk 2322.4967 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1526 :dets {:run {:m1 1526, :m2 1524, :m3 1523}, :bufs {:b1 [1525], :b2 []}} :line 1406}
{:clk 2322.4967 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2323.4967 :j 1527 :dets {:run {:m1 nil, :m2 1524, :m3 1523}, :bufs {:b1 [1525 1526], :b2 []}} :line 1407}
{:clk 2322.6263 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1524 :dets {:run {:m1 1527, :m2 1524, :m3 1523}, :bufs {:b1 [1525 1526], :b2 []}} :line 1408}
{:clk 2322.6263 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1525 :dets {:run {:m1 1527, :m2 nil, :m3 1523}, :bufs {:b1 [1525 1526], :b2 [1524]}} :line 1409}
{:clk 2322.6375 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2316.62 :j 1523 :dets {:run {:m1 1527, :m2 1525, :m3 1523}, :bufs {:b1 [1526], :b2 [1524]}} :line 1410}
{:clk 2322.6375 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1524 :dets {:run {:m1 1527, :m2 1525, :m3 nil}, :bufs {:b1 [1526], :b2 [1524]}} :line 1411}
{:clk 2323.4967 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1527 :dets {:run {:m1 1527, :m2 1525, :m3 1524}, :bufs {:b1 [1526], :b2 []}} :line 1412}
{:clk 2323.4967 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2324.9967 :j 1528 :dets {:run {:m1 nil, :m2 1525, :m3 1524}, :bufs {:b1 [1526 1527], :b2 []}} :line 1413}
{:clk 2323.6263 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1525 :dets {:run {:m1 1528, :m2 1525, :m3 1524}, :bufs {:b1 [1526 1527], :b2 []}} :line 1414}
{:clk 2323.6263 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1526 :dets {:run {:m1 1528, :m2 nil, :m3 1524}, :bufs {:b1 [1526 1527], :b2 [1525]}} :line 1415}
{:clk 2324.4422 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2318.12 :j 1524 :dets {:run {:m1 1528, :m2 1526, :m3 1524}, :bufs {:b1 [1527], :b2 [1525]}} :line 1416}
{:clk 2324.4422 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1525 :dets {:run {:m1 1528, :m2 1526, :m3 nil}, :bufs {:b1 [1527], :b2 [1525]}} :line 1417}
{:clk 2324.9967 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1528 :dets {:run {:m1 1528, :m2 1526, :m3 1525}, :bufs {:b1 [1527], :b2 []}} :line 1418}
{:clk 2324.9967 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2325.9967 :j 1529 :dets {:run {:m1 nil, :m2 1526, :m3 1525}, :bufs {:b1 [1527 1528], :b2 []}} :line 1419}
{:clk 2325.2527 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1526 :dets {:run {:m1 1529, :m2 1526, :m3 1525}, :bufs {:b1 [1527 1528], :b2 []}} :line 1420}
{:clk 2325.2527 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1527 :dets {:run {:m1 1529, :m2 nil, :m3 1525}, :bufs {:b1 [1527 1528], :b2 [1526]}} :line 1421}
{:clk 2325.4422 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2319.62 :j 1525 :dets {:run {:m1 1529, :m2 1527, :m3 1525}, :bufs {:b1 [1528], :b2 [1526]}} :line 1422}
{:clk 2325.4422 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1526 :dets {:run {:m1 1529, :m2 1527, :m3 nil}, :bufs {:b1 [1528], :b2 [1526]}} :line 1423}
{:clk 2325.9967 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1529 :dets {:run {:m1 1529, :m2 1527, :m3 1526}, :bufs {:b1 [1528], :b2 []}} :line 1424}
{:clk 2325.9967 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2327.4967 :j 1530 :dets {:run {:m1 nil, :m2 1527, :m3 1526}, :bufs {:b1 [1528 1529], :b2 []}} :line 1425}
{:clk 2326.2527 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1527 :dets {:run {:m1 1530, :m2 1527, :m3 1526}, :bufs {:b1 [1528 1529], :b2 []}} :line 1426}
{:clk 2326.2527 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1528 :dets {:run {:m1 1530, :m2 nil, :m3 1526}, :bufs {:b1 [1528 1529], :b2 [1527]}} :line 1427}
{:clk 2326.9422 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2320.62 :j 1526 :dets {:run {:m1 1530, :m2 1528, :m3 1526}, :bufs {:b1 [1529], :b2 [1527]}} :line 1428}
{:clk 2326.9422 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1527 :dets {:run {:m1 1530, :m2 1528, :m3 nil}, :bufs {:b1 [1529], :b2 [1527]}} :line 1429}
{:clk 2327.4967 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1530 :dets {:run {:m1 1530, :m2 1528, :m3 1527}, :bufs {:b1 [1529], :b2 []}} :line 1430}
{:clk 2327.4967 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2328.4967 :j 1531 :dets {:run {:m1 nil, :m2 1528, :m3 1527}, :bufs {:b1 [1529 1530], :b2 []}} :line 1431}
{:clk 2327.7527 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1528 :dets {:run {:m1 1531, :m2 1528, :m3 1527}, :bufs {:b1 [1529 1530], :b2 []}} :line 1432}
{:clk 2327.7527 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1529 :dets {:run {:m1 1531, :m2 nil, :m3 1527}, :bufs {:b1 [1529 1530], :b2 [1528]}} :line 1433}
{:clk 2327.9422 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2322.4967 :j 1527 :dets {:run {:m1 1531, :m2 1529, :m3 1527}, :bufs {:b1 [1530], :b2 [1528]}} :line 1434}
{:clk 2327.9422 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1528 :dets {:run {:m1 1531, :m2 1529, :m3 nil}, :bufs {:b1 [1530], :b2 [1528]}} :line 1435}
{:clk 2328.4967 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1531 :dets {:run {:m1 1531, :m2 1529, :m3 1528}, :bufs {:b1 [1530], :b2 []}} :line 1436}
{:clk 2328.4967 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2329.4967 :j 1532 :dets {:run {:m1 nil, :m2 1529, :m3 1528}, :bufs {:b1 [1530 1531], :b2 []}} :line 1437}
{:clk 2328.7527 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1529 :dets {:run {:m1 1532, :m2 1529, :m3 1528}, :bufs {:b1 [1530 1531], :b2 []}} :line 1438}
{:clk 2328.7527 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1530 :dets {:run {:m1 1532, :m2 nil, :m3 1528}, :bufs {:b1 [1530 1531], :b2 [1529]}} :line 1439}
{:clk 2329.4422 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2323.4967 :j 1528 :dets {:run {:m1 1532, :m2 1530, :m3 1528}, :bufs {:b1 [1531], :b2 [1529]}} :line 1440}
{:clk 2329.4422 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1529 :dets {:run {:m1 1532, :m2 1530, :m3 nil}, :bufs {:b1 [1531], :b2 [1529]}} :line 1441}
{:clk 2329.4967 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1532 :dets {:run {:m1 1532, :m2 1530, :m3 1529}, :bufs {:b1 [1531], :b2 []}} :line 1442}
{:clk 2329.4967 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2330.4967 :j 1533 :dets {:run {:m1 nil, :m2 1530, :m3 1529}, :bufs {:b1 [1531 1532], :b2 []}} :line 1443}
{:clk 2330.4422 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2324.9967 :j 1529 :dets {:run {:m1 1533, :m2 1530, :m3 1529}, :bufs {:b1 [1531 1532], :b2 []}} :line 1444}
{:clk 2330.4422 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1533, :m2 1530, :m3 nil}, :bufs {:b1 [1531 1532], :b2 []}} :line 1445}
{:clk 2330.4967 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1533, :m2 1530, :m3 nil}, :bufs {:b1 [1531 1532], :b2 []}} :line 1446}
{:clk 2336.6897 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1530 :dets {:run {:m1 1533, :m2 1531, :m3 nil}, :bufs {:b1 [1532], :b2 [1530]}} :line 1447}
{:clk 2336.6897 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1530 :dets {:run {:m1 1533, :m2 1530, :m3 nil}, :bufs {:b1 [1531 1532], :b2 []}} :line 1448}
{:clk 2336.6897 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1531 :dets {:run {:m1 1533, :m2 nil, :m3 nil}, :bufs {:b1 [1531 1532], :b2 [1530]}} :line 1449}
{:clk 2336.6897 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1533, :m2 1531, :m3 1530}, :bufs {:b1 [1532], :b2 []}} :line 1450}
{:clk 2336.6897 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1531, :m3 1530}, :bufs {:b1 [1532 1533], :b2 []}} :line 1451}
{:clk 2336.6897 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1533 :dets {:run {:m1 1533, :m2 1531, :m3 1530}, :bufs {:b1 [1532], :b2 []}} :line 1452}
{:clk 2336.6897 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2337.6897 :j 1534 :dets {:run {:m1 nil, :m2 1531, :m3 1530}, :bufs {:b1 [1532 1533], :b2 []}} :line 1453}
{:clk 2337.6897 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1534 :dets {:run {:m1 1534, :m2 1532, :m3 1530}, :bufs {:b1 [1533], :b2 [1531]}} :line 1454}
{:clk 2337.6897 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2338.6897 :j 1535 :dets {:run {:m1 nil, :m2 1532, :m3 1530}, :bufs {:b1 [1533 1534], :b2 [1531]}} :line 1455}
{:clk 2337.6897 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1531 :dets {:run {:m1 1534, :m2 1531, :m3 1530}, :bufs {:b1 [1532 1533], :b2 []}} :line 1456}
{:clk 2337.6897 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1532 :dets {:run {:m1 1534, :m2 nil, :m3 1530}, :bufs {:b1 [1532 1533], :b2 [1531]}} :line 1457}
{:clk 2338.1897 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2325.9967 :j 1530 :dets {:run {:m1 1535, :m2 1532, :m3 1530}, :bufs {:b1 [1533 1534], :b2 [1531]}} :line 1458}
{:clk 2338.1897 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1531 :dets {:run {:m1 1535, :m2 1532, :m3 nil}, :bufs {:b1 [1533 1534], :b2 [1531]}} :line 1459}
{:clk 2338.6897 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1535 :dets {:run {:m1 1535, :m2 1533, :m3 1531}, :bufs {:b1 [1534], :b2 [1532]}} :line 1460}
{:clk 2338.6897 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2339.6897 :j 1536 :dets {:run {:m1 nil, :m2 1533, :m3 1531}, :bufs {:b1 [1534 1535], :b2 [1532]}} :line 1461}
{:clk 2338.6897 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1532 :dets {:run {:m1 1535, :m2 1532, :m3 1531}, :bufs {:b1 [1533 1534], :b2 []}} :line 1462}
{:clk 2338.6897 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1533 :dets {:run {:m1 1535, :m2 nil, :m3 1531}, :bufs {:b1 [1533 1534], :b2 [1532]}} :line 1463}
{:clk 2339.1897 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2327.4967 :j 1531 :dets {:run {:m1 1536, :m2 1533, :m3 1531}, :bufs {:b1 [1534 1535], :b2 [1532]}} :line 1464}
{:clk 2339.1897 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1532 :dets {:run {:m1 1536, :m2 1533, :m3 nil}, :bufs {:b1 [1534 1535], :b2 [1532]}} :line 1465}
{:clk 2339.6897 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1536 :dets {:run {:m1 1536, :m2 1534, :m3 1532}, :bufs {:b1 [1535], :b2 [1533]}} :line 1466}
{:clk 2339.6897 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2340.6897 :j 1537 :dets {:run {:m1 nil, :m2 1534, :m3 1532}, :bufs {:b1 [1535 1536], :b2 [1533]}} :line 1467}
{:clk 2339.6897 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1533 :dets {:run {:m1 1536, :m2 1533, :m3 1532}, :bufs {:b1 [1534 1535], :b2 []}} :line 1468}
{:clk 2339.6897 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1534 :dets {:run {:m1 1536, :m2 nil, :m3 1532}, :bufs {:b1 [1534 1535], :b2 [1533]}} :line 1469}
{:clk 2340.1897 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2328.4967 :j 1532 :dets {:run {:m1 1537, :m2 1534, :m3 1532}, :bufs {:b1 [1535 1536], :b2 [1533]}} :line 1470}
{:clk 2340.1897 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1533 :dets {:run {:m1 1537, :m2 1534, :m3 nil}, :bufs {:b1 [1535 1536], :b2 [1533]}} :line 1471}
{:clk 2340.6897 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1537 :dets {:run {:m1 1537, :m2 1535, :m3 1533}, :bufs {:b1 [1536], :b2 [1534]}} :line 1472}
{:clk 2340.6897 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2341.6897 :j 1538 :dets {:run {:m1 nil, :m2 1535, :m3 1533}, :bufs {:b1 [1536 1537], :b2 [1534]}} :line 1473}
{:clk 2340.6897 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1534 :dets {:run {:m1 1537, :m2 1534, :m3 1533}, :bufs {:b1 [1535 1536], :b2 []}} :line 1474}
{:clk 2340.6897 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1535 :dets {:run {:m1 1537, :m2 nil, :m3 1533}, :bufs {:b1 [1535 1536], :b2 [1534]}} :line 1475}
{:clk 2341.1897 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2329.4967 :j 1533 :dets {:run {:m1 1538, :m2 1535, :m3 1533}, :bufs {:b1 [1536 1537], :b2 [1534]}} :line 1476}
{:clk 2341.1897 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1534 :dets {:run {:m1 1538, :m2 1535, :m3 nil}, :bufs {:b1 [1536 1537], :b2 [1534]}} :line 1477}
{:clk 2341.6897 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1538 :dets {:run {:m1 1538, :m2 1536, :m3 1534}, :bufs {:b1 [1537], :b2 [1535]}} :line 1478}
{:clk 2341.6897 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2343.1897 :j 1539 :dets {:run {:m1 nil, :m2 1536, :m3 1534}, :bufs {:b1 [1537 1538], :b2 [1535]}} :line 1479}
{:clk 2341.6897 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1535 :dets {:run {:m1 1538, :m2 1535, :m3 1534}, :bufs {:b1 [1536 1537], :b2 []}} :line 1480}
{:clk 2341.6897 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1536 :dets {:run {:m1 1538, :m2 nil, :m3 1534}, :bufs {:b1 [1536 1537], :b2 [1535]}} :line 1481}
{:clk 2342.1897 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2336.6897 :j 1534 :dets {:run {:m1 1539, :m2 1536, :m3 1534}, :bufs {:b1 [1537 1538], :b2 [1535]}} :line 1482}
{:clk 2342.1897 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1535 :dets {:run {:m1 1539, :m2 1536, :m3 nil}, :bufs {:b1 [1537 1538], :b2 [1535]}} :line 1483}
{:clk 2342.6897 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1536 :dets {:run {:m1 1539, :m2 1536, :m3 1535}, :bufs {:b1 [1537 1538], :b2 []}} :line 1484}
{:clk 2342.6897 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1537 :dets {:run {:m1 1539, :m2 nil, :m3 1535}, :bufs {:b1 [1537 1538], :b2 [1536]}} :line 1485}
{:clk 2343.1897 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1539 :dets {:run {:m1 1539, :m2 1537, :m3 1535}, :bufs {:b1 [1538], :b2 [1536]}} :line 1486}
{:clk 2343.1897 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2345.1385 :j 1540 :dets {:run {:m1 nil, :m2 1537, :m3 1535}, :bufs {:b1 [1538 1539], :b2 [1536]}} :line 1487}
{:clk 2343.4592 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2337.6897 :j 1535 :dets {:run {:m1 1540, :m2 1537, :m3 1535}, :bufs {:b1 [1538 1539], :b2 [1536]}} :line 1488}
{:clk 2343.4592 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1536 :dets {:run {:m1 1540, :m2 1537, :m3 nil}, :bufs {:b1 [1538 1539], :b2 [1536]}} :line 1489}
{:clk 2343.6897 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1537 :dets {:run {:m1 1540, :m2 1537, :m3 1536}, :bufs {:b1 [1538 1539], :b2 []}} :line 1490}
{:clk 2343.6897 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1538 :dets {:run {:m1 1540, :m2 nil, :m3 1536}, :bufs {:b1 [1538 1539], :b2 [1537]}} :line 1491}
{:clk 2344.6897 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1538 :dets {:run {:m1 1540, :m2 1538, :m3 1536}, :bufs {:b1 [1539], :b2 [1537]}} :line 1492}
{:clk 2344.6897 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1539 :dets {:run {:m1 1540, :m2 nil, :m3 1536}, :bufs {:b1 [1539], :b2 [1537 1538]}} :line 1493}
{:clk 2345.1047 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2338.6897 :j 1536 :dets {:run {:m1 1540, :m2 1539, :m3 1536}, :bufs {:b1 [], :b2 [1537 1538]}} :line 1494}
{:clk 2345.1047 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1537 :dets {:run {:m1 1540, :m2 1539, :m3 nil}, :bufs {:b1 [], :b2 [1537 1538]}} :line 1495}
{:clk 2345.1385 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1540 :dets {:run {:m1 1540, :m2 1539, :m3 1537}, :bufs {:b1 [], :b2 [1538]}} :line 1496}
{:clk 2345.1385 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2346.6385 :j 1541 :dets {:run {:m1 nil, :m2 1539, :m3 1537}, :bufs {:b1 [1540], :b2 [1538]}} :line 1497}
{:clk 2346.1047 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2339.6897 :j 1537 :dets {:run {:m1 1541, :m2 1539, :m3 1537}, :bufs {:b1 [1540], :b2 [1538]}} :line 1498}
{:clk 2346.1047 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1538 :dets {:run {:m1 1541, :m2 1539, :m3 nil}, :bufs {:b1 [1540], :b2 [1538]}} :line 1499}
{:clk 2346.1897 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1539 :dets {:run {:m1 1541, :m2 1539, :m3 1538}, :bufs {:b1 [1540], :b2 []}} :line 1500}
{:clk 2346.1897 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1540 :dets {:run {:m1 1541, :m2 nil, :m3 1538}, :bufs {:b1 [1540], :b2 [1539]}} :line 1501}
{:clk 2346.6385 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1541 :dets {:run {:m1 1541, :m2 1540, :m3 1538}, :bufs {:b1 [], :b2 [1539]}} :line 1502}
{:clk 2346.6385 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2348.1385 :j 1542 :dets {:run {:m1 nil, :m2 1540, :m3 1538}, :bufs {:b1 [1541], :b2 [1539]}} :line 1503}
{:clk 2347.1047 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2340.6897 :j 1538 :dets {:run {:m1 1542, :m2 1540, :m3 1538}, :bufs {:b1 [1541], :b2 [1539]}} :line 1504}
{:clk 2347.1047 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1539 :dets {:run {:m1 1542, :m2 1540, :m3 nil}, :bufs {:b1 [1541], :b2 [1539]}} :line 1505}
{:clk 2347.6897 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1540 :dets {:run {:m1 1542, :m2 1540, :m3 1539}, :bufs {:b1 [1541], :b2 []}} :line 1506}
{:clk 2347.6897 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1541 :dets {:run {:m1 1542, :m2 nil, :m3 1539}, :bufs {:b1 [1541], :b2 [1540]}} :line 1507}
{:clk 2348.1385 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1542 :dets {:run {:m1 1542, :m2 1541, :m3 1539}, :bufs {:b1 [], :b2 [1540]}} :line 1508}
{:clk 2348.1385 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2349.1385 :j 1543 :dets {:run {:m1 nil, :m2 1541, :m3 1539}, :bufs {:b1 [1542], :b2 [1540]}} :line 1509}
{:clk 2348.6994 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2341.6897 :j 1539 :dets {:run {:m1 1543, :m2 1541, :m3 1539}, :bufs {:b1 [1542], :b2 [1540]}} :line 1510}
{:clk 2348.6994 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1540 :dets {:run {:m1 1543, :m2 1541, :m3 nil}, :bufs {:b1 [1542], :b2 [1540]}} :line 1511}
{:clk 2349.1385 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1543 :dets {:run {:m1 1543, :m2 1541, :m3 1540}, :bufs {:b1 [1542], :b2 []}} :line 1512}
{:clk 2349.1385 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2350.6385 :j 1544 :dets {:run {:m1 nil, :m2 1541, :m3 1540}, :bufs {:b1 [1542 1543], :b2 []}} :line 1513}
{:clk 2349.1897 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1541 :dets {:run {:m1 1544, :m2 1541, :m3 1540}, :bufs {:b1 [1542 1543], :b2 []}} :line 1514}
{:clk 2349.1897 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1542 :dets {:run {:m1 1544, :m2 nil, :m3 1540}, :bufs {:b1 [1542 1543], :b2 [1541]}} :line 1515}
{:clk 2350.1994 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2343.1897 :j 1540 :dets {:run {:m1 1544, :m2 1542, :m3 1540}, :bufs {:b1 [1543], :b2 [1541]}} :line 1516}
{:clk 2350.1994 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1541 :dets {:run {:m1 1544, :m2 1542, :m3 nil}, :bufs {:b1 [1543], :b2 [1541]}} :line 1517}
{:clk 2350.6385 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1544 :dets {:run {:m1 1544, :m2 1542, :m3 1541}, :bufs {:b1 [1543], :b2 []}} :line 1518}
{:clk 2350.6385 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2352.1385 :j 1545 :dets {:run {:m1 nil, :m2 1542, :m3 1541}, :bufs {:b1 [1543 1544], :b2 []}} :line 1519}
{:clk 2350.6897 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1542 :dets {:run {:m1 1545, :m2 1542, :m3 1541}, :bufs {:b1 [1543 1544], :b2 []}} :line 1520}
{:clk 2350.6897 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1543 :dets {:run {:m1 1545, :m2 nil, :m3 1541}, :bufs {:b1 [1543 1544], :b2 [1542]}} :line 1521}
{:clk 2351.6897 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1543 :dets {:run {:m1 1545, :m2 1543, :m3 1541}, :bufs {:b1 [1544], :b2 [1542]}} :line 1522}
{:clk 2351.6897 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1544 :dets {:run {:m1 1545, :m2 nil, :m3 1541}, :bufs {:b1 [1544], :b2 [1542 1543]}} :line 1523}
{:clk 2351.6994 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2345.1385 :j 1541 :dets {:run {:m1 1545, :m2 1544, :m3 1541}, :bufs {:b1 [], :b2 [1542 1543]}} :line 1524}
{:clk 2351.6994 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1542 :dets {:run {:m1 1545, :m2 1544, :m3 nil}, :bufs {:b1 [], :b2 [1542 1543]}} :line 1525}
{:clk 2352.1385 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1545 :dets {:run {:m1 1545, :m2 1544, :m3 1542}, :bufs {:b1 [], :b2 [1543]}} :line 1526}
{:clk 2352.1385 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2353.6385 :j 1546 :dets {:run {:m1 nil, :m2 1544, :m3 1542}, :bufs {:b1 [1545], :b2 [1543]}} :line 1527}
{:clk 2353.1994 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2346.6385 :j 1542 :dets {:run {:m1 1546, :m2 1544, :m3 1542}, :bufs {:b1 [1545], :b2 [1543]}} :line 1528}
{:clk 2353.1994 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1543 :dets {:run {:m1 1546, :m2 1544, :m3 nil}, :bufs {:b1 [1545], :b2 [1543]}} :line 1529}
{:clk 2353.6385 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1546 :dets {:run {:m1 1546, :m2 1544, :m3 1543}, :bufs {:b1 [1545], :b2 []}} :line 1530}
{:clk 2353.6385 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2355.1385 :j 1547 :dets {:run {:m1 nil, :m2 1544, :m3 1543}, :bufs {:b1 [1545 1546], :b2 []}} :line 1531}
{:clk 2354.1994 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2348.1385 :j 1543 :dets {:run {:m1 1547, :m2 1544, :m3 1543}, :bufs {:b1 [1545 1546], :b2 []}} :line 1532}
{:clk 2354.1994 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1547, :m2 1544, :m3 nil}, :bufs {:b1 [1545 1546], :b2 []}} :line 1533}
{:clk 2354.2684 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1544 :dets {:run {:m1 1547, :m2 1544, :m3 nil}, :bufs {:b1 [1545 1546], :b2 []}} :line 1534}
{:clk 2354.2684 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1545 :dets {:run {:m1 1547, :m2 nil, :m3 nil}, :bufs {:b1 [1545 1546], :b2 [1544]}} :line 1535}
{:clk 2354.2684 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1547, :m2 1545, :m3 1544}, :bufs {:b1 [1546], :b2 []}} :line 1536}
{:clk 2354.2684 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1544 :dets {:run {:m1 1547, :m2 1545, :m3 nil}, :bufs {:b1 [1546], :b2 [1544]}} :line 1537}
{:clk 2355.1385 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1547 :dets {:run {:m1 1547, :m2 1545, :m3 1544}, :bufs {:b1 [1546], :b2 []}} :line 1538}
{:clk 2355.1385 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2356.1385 :j 1548 :dets {:run {:m1 nil, :m2 1545, :m3 1544}, :bufs {:b1 [1546 1547], :b2 []}} :line 1539}
{:clk 2355.7684 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1545 :dets {:run {:m1 1548, :m2 1545, :m3 1544}, :bufs {:b1 [1546 1547], :b2 []}} :line 1540}
{:clk 2355.7684 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1546 :dets {:run {:m1 1548, :m2 nil, :m3 1544}, :bufs {:b1 [1546 1547], :b2 [1545]}} :line 1541}
{:clk 2356.1385 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1548 :dets {:run {:m1 1548, :m2 1546, :m3 1544}, :bufs {:b1 [1547], :b2 [1545]}} :line 1542}
{:clk 2356.1385 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2357.6385 :j 1549 :dets {:run {:m1 nil, :m2 1546, :m3 1544}, :bufs {:b1 [1547 1548], :b2 [1545]}} :line 1543}
{:clk 2357.0355 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2349.1385 :j 1544 :dets {:run {:m1 1549, :m2 1546, :m3 1544}, :bufs {:b1 [1547 1548], :b2 [1545]}} :line 1544}
{:clk 2357.0355 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1545 :dets {:run {:m1 1549, :m2 1546, :m3 nil}, :bufs {:b1 [1547 1548], :b2 [1545]}} :line 1545}
{:clk 2357.2684 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1546 :dets {:run {:m1 1549, :m2 1546, :m3 1545}, :bufs {:b1 [1547 1548], :b2 []}} :line 1546}
{:clk 2357.2684 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1547 :dets {:run {:m1 1549, :m2 nil, :m3 1545}, :bufs {:b1 [1547 1548], :b2 [1546]}} :line 1547}
{:clk 2357.6385 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1549 :dets {:run {:m1 1549, :m2 1547, :m3 1545}, :bufs {:b1 [1548], :b2 [1546]}} :line 1548}
{:clk 2357.6385 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2358.6385 :j 1550 :dets {:run {:m1 nil, :m2 1547, :m3 1545}, :bufs {:b1 [1548 1549], :b2 [1546]}} :line 1549}
{:clk 2358.5355 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2350.6385 :j 1545 :dets {:run {:m1 1550, :m2 1547, :m3 1545}, :bufs {:b1 [1548 1549], :b2 [1546]}} :line 1550}
{:clk 2358.5355 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1546 :dets {:run {:m1 1550, :m2 1547, :m3 nil}, :bufs {:b1 [1548 1549], :b2 [1546]}} :line 1551}
{:clk 2358.6385 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1550, :m2 1547, :m3 1546}, :bufs {:b1 [1548 1549], :b2 []}} :line 1552}
{:clk 2358.7684 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1547 :dets {:run {:m1 1550, :m2 1547, :m3 1546}, :bufs {:b1 [1548 1549], :b2 []}} :line 1553}
{:clk 2358.7684 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1548 :dets {:run {:m1 1550, :m2 nil, :m3 1546}, :bufs {:b1 [1548 1549], :b2 [1547]}} :line 1554}
{:clk 2358.7684 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1548, :m3 1546}, :bufs {:b1 [1549 1550], :b2 [1547]}} :line 1555}
{:clk 2358.7684 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1550 :dets {:run {:m1 1550, :m2 1548, :m3 1546}, :bufs {:b1 [1549], :b2 [1547]}} :line 1556}
{:clk 2358.7684 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2360.3146 :j 1551 :dets {:run {:m1 nil, :m2 1548, :m3 1546}, :bufs {:b1 [1549 1550], :b2 [1547]}} :line 1557}
{:clk 2360.0355 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2352.1385 :j 1546 :dets {:run {:m1 1551, :m2 1548, :m3 1546}, :bufs {:b1 [1549 1550], :b2 [1547]}} :line 1558}
{:clk 2360.0355 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1547 :dets {:run {:m1 1551, :m2 1548, :m3 nil}, :bufs {:b1 [1549 1550], :b2 [1547]}} :line 1559}
{:clk 2360.3146 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1551, :m2 1548, :m3 1547}, :bufs {:b1 [1549 1550], :b2 []}} :line 1560}
{:clk 2360.5058 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1548 :dets {:run {:m1 1551, :m2 1548, :m3 1547}, :bufs {:b1 [1549 1550], :b2 []}} :line 1561}
{:clk 2360.5058 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1549 :dets {:run {:m1 1551, :m2 nil, :m3 1547}, :bufs {:b1 [1549 1550], :b2 [1548]}} :line 1562}
{:clk 2360.5058 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1549, :m3 1547}, :bufs {:b1 [1550 1551], :b2 [1548]}} :line 1563}
{:clk 2360.5058 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1551 :dets {:run {:m1 1551, :m2 1549, :m3 1547}, :bufs {:b1 [1550], :b2 [1548]}} :line 1564}
{:clk 2360.5058 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2361.5058 :j 1552 :dets {:run {:m1 nil, :m2 1549, :m3 1547}, :bufs {:b1 [1550 1551], :b2 [1548]}} :line 1565}
{:clk 2361.5058 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1552, :m2 1549, :m3 1547}, :bufs {:b1 [1550 1551], :b2 [1548]}} :line 1566}
{:clk 2361.5355 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2353.6385 :j 1547 :dets {:run {:m1 1552, :m2 1549, :m3 1547}, :bufs {:b1 [1550 1551], :b2 [1548]}} :line 1567}
{:clk 2361.5355 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1548 :dets {:run {:m1 1552, :m2 1549, :m3 nil}, :bufs {:b1 [1550 1551], :b2 [1548]}} :line 1568}
{:clk 2362.0058 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1549 :dets {:run {:m1 1552, :m2 1549, :m3 1548}, :bufs {:b1 [1550 1551], :b2 []}} :line 1569}
{:clk 2362.0058 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1550 :dets {:run {:m1 1552, :m2 nil, :m3 1548}, :bufs {:b1 [1550 1551], :b2 [1549]}} :line 1570}
{:clk 2362.0058 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1550, :m3 1548}, :bufs {:b1 [1551 1552], :b2 [1549]}} :line 1571}
{:clk 2362.0058 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1552 :dets {:run {:m1 1552, :m2 1550, :m3 1548}, :bufs {:b1 [1551], :b2 [1549]}} :line 1572}
{:clk 2362.0058 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2363.0058 :j 1553 :dets {:run {:m1 nil, :m2 1550, :m3 1548}, :bufs {:b1 [1551 1552], :b2 [1549]}} :line 1573}
{:clk 2362.5355 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2355.1385 :j 1548 :dets {:run {:m1 1553, :m2 1550, :m3 1548}, :bufs {:b1 [1551 1552], :b2 [1549]}} :line 1574}
{:clk 2362.5355 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1549 :dets {:run {:m1 1553, :m2 1550, :m3 nil}, :bufs {:b1 [1551 1552], :b2 [1549]}} :line 1575}
{:clk 2363.0058 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1553 :dets {:run {:m1 1553, :m2 1551, :m3 1549}, :bufs {:b1 [1552], :b2 [1550]}} :line 1576}
{:clk 2363.0058 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2364.0058 :j 1554 :dets {:run {:m1 nil, :m2 1551, :m3 1549}, :bufs {:b1 [1552 1553], :b2 [1550]}} :line 1577}
{:clk 2363.0058 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1550 :dets {:run {:m1 1553, :m2 1550, :m3 1549}, :bufs {:b1 [1551 1552], :b2 []}} :line 1578}
{:clk 2363.0058 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1551 :dets {:run {:m1 1553, :m2 nil, :m3 1549}, :bufs {:b1 [1551 1552], :b2 [1550]}} :line 1579}
{:clk 2364.0058 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1554, :m2 1551, :m3 1549}, :bufs {:b1 [1552 1553], :b2 [1550]}} :line 1580}
{:clk 2364.5058 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1551 :dets {:run {:m1 1554, :m2 1551, :m3 1549}, :bufs {:b1 [1552 1553], :b2 [1550]}} :line 1581}
{:clk 2364.5058 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1552 :dets {:run {:m1 1554, :m2 nil, :m3 1549}, :bufs {:b1 [1552 1553], :b2 [1550 1551]}} :line 1582}
{:clk 2364.5058 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1552, :m3 1549}, :bufs {:b1 [1553 1554], :b2 [1550 1551]}} :line 1583}
{:clk 2364.5058 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1554 :dets {:run {:m1 1554, :m2 1552, :m3 1549}, :bufs {:b1 [1553], :b2 [1550 1551]}} :line 1584}
{:clk 2364.5058 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2366.0058 :j 1555 :dets {:run {:m1 nil, :m2 1552, :m3 1549}, :bufs {:b1 [1553 1554], :b2 [1550 1551]}} :line 1585}
{:clk 2364.8974 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2356.1385 :j 1549 :dets {:run {:m1 1555, :m2 1552, :m3 1549}, :bufs {:b1 [1553 1554], :b2 [1550 1551]}} :line 1586}
{:clk 2364.8974 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1550 :dets {:run {:m1 1555, :m2 1552, :m3 nil}, :bufs {:b1 [1553 1554], :b2 [1550 1551]}} :line 1587}
{:clk 2365.5058 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1552 :dets {:run {:m1 1555, :m2 1552, :m3 1550}, :bufs {:b1 [1553 1554], :b2 [1551]}} :line 1588}
{:clk 2365.5058 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1553 :dets {:run {:m1 1555, :m2 nil, :m3 1550}, :bufs {:b1 [1553 1554], :b2 [1551 1552]}} :line 1589}
{:clk 2365.8974 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2357.6385 :j 1550 :dets {:run {:m1 1555, :m2 1553, :m3 1550}, :bufs {:b1 [1554], :b2 [1551 1552]}} :line 1590}
{:clk 2365.8974 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1551 :dets {:run {:m1 1555, :m2 1553, :m3 nil}, :bufs {:b1 [1554], :b2 [1551 1552]}} :line 1591}
{:clk 2366.0058 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1555 :dets {:run {:m1 1555, :m2 1553, :m3 1551}, :bufs {:b1 [1554], :b2 [1552]}} :line 1592}
{:clk 2366.0058 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2367.0058 :j 1556 :dets {:run {:m1 nil, :m2 1553, :m3 1551}, :bufs {:b1 [1554 1555], :b2 [1552]}} :line 1593}
{:clk 2366.5058 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1553 :dets {:run {:m1 1556, :m2 1553, :m3 1551}, :bufs {:b1 [1554 1555], :b2 [1552]}} :line 1594}
{:clk 2366.5058 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1554 :dets {:run {:m1 1556, :m2 nil, :m3 1551}, :bufs {:b1 [1554 1555], :b2 [1552 1553]}} :line 1595}
{:clk 2367.0058 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1556 :dets {:run {:m1 1556, :m2 1554, :m3 1551}, :bufs {:b1 [1555], :b2 [1552 1553]}} :line 1596}
{:clk 2367.0058 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2368.0058 :j 1557 :dets {:run {:m1 nil, :m2 1554, :m3 1551}, :bufs {:b1 [1555 1556], :b2 [1552 1553]}} :line 1597}
{:clk 2367.3974 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2358.7684 :j 1551 :dets {:run {:m1 1557, :m2 1554, :m3 1551}, :bufs {:b1 [1555 1556], :b2 [1552 1553]}} :line 1598}
{:clk 2367.3974 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1552 :dets {:run {:m1 1557, :m2 1554, :m3 nil}, :bufs {:b1 [1555 1556], :b2 [1552 1553]}} :line 1599}
{:clk 2367.5058 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1554 :dets {:run {:m1 1557, :m2 1554, :m3 1552}, :bufs {:b1 [1555 1556], :b2 [1553]}} :line 1600}
{:clk 2367.5058 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1555 :dets {:run {:m1 1557, :m2 nil, :m3 1552}, :bufs {:b1 [1555 1556], :b2 [1553 1554]}} :line 1601}
{:clk 2368.0058 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1557 :dets {:run {:m1 1557, :m2 1555, :m3 1552}, :bufs {:b1 [1556], :b2 [1553 1554]}} :line 1602}
{:clk 2368.0058 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2369.0058 :j 1558 :dets {:run {:m1 nil, :m2 1555, :m3 1552}, :bufs {:b1 [1556 1557], :b2 [1553 1554]}} :line 1603}
{:clk 2368.3974 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2360.5058 :j 1552 :dets {:run {:m1 1558, :m2 1555, :m3 1552}, :bufs {:b1 [1556 1557], :b2 [1553 1554]}} :line 1604}
{:clk 2368.3974 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1553 :dets {:run {:m1 1558, :m2 1555, :m3 nil}, :bufs {:b1 [1556 1557], :b2 [1553 1554]}} :line 1605}
{:clk 2369.0058 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1558 :dets {:run {:m1 1558, :m2 1556, :m3 1553}, :bufs {:b1 [1557], :b2 [1554 1555]}} :line 1606}
{:clk 2369.0058 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2370.5058 :j 1559 :dets {:run {:m1 nil, :m2 1556, :m3 1553}, :bufs {:b1 [1557 1558], :b2 [1554 1555]}} :line 1607}
{:clk 2369.0058 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1555 :dets {:run {:m1 1558, :m2 1555, :m3 1553}, :bufs {:b1 [1556 1557], :b2 [1554]}} :line 1608}
{:clk 2369.0058 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1556 :dets {:run {:m1 1558, :m2 nil, :m3 1553}, :bufs {:b1 [1556 1557], :b2 [1554 1555]}} :line 1609}
{:clk 2369.4361 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2362.0058 :j 1553 :dets {:run {:m1 1559, :m2 1556, :m3 1553}, :bufs {:b1 [1557 1558], :b2 [1554 1555]}} :line 1610}
{:clk 2369.4361 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1554 :dets {:run {:m1 1559, :m2 1556, :m3 nil}, :bufs {:b1 [1557 1558], :b2 [1554 1555]}} :line 1611}
{:clk 2370.0058 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1556 :dets {:run {:m1 1559, :m2 1556, :m3 1554}, :bufs {:b1 [1557 1558], :b2 [1555]}} :line 1612}
{:clk 2370.0058 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1557 :dets {:run {:m1 1559, :m2 nil, :m3 1554}, :bufs {:b1 [1557 1558], :b2 [1555 1556]}} :line 1613}
{:clk 2370.4361 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2363.0058 :j 1554 :dets {:run {:m1 1559, :m2 1557, :m3 1554}, :bufs {:b1 [1558], :b2 [1555 1556]}} :line 1614}
{:clk 2370.4361 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1555 :dets {:run {:m1 1559, :m2 1557, :m3 nil}, :bufs {:b1 [1558], :b2 [1555 1556]}} :line 1615}
{:clk 2370.5058 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1559 :dets {:run {:m1 1559, :m2 1557, :m3 1555}, :bufs {:b1 [1558], :b2 [1556]}} :line 1616}
{:clk 2370.5058 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2372.6109 :j 1560 :dets {:run {:m1 nil, :m2 1557, :m3 1555}, :bufs {:b1 [1558 1559], :b2 [1556]}} :line 1617}
{:clk 2371.0058 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1557 :dets {:run {:m1 1560, :m2 1557, :m3 1555}, :bufs {:b1 [1558 1559], :b2 [1556]}} :line 1618}
{:clk 2371.0058 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1558 :dets {:run {:m1 1560, :m2 nil, :m3 1555}, :bufs {:b1 [1558 1559], :b2 [1556 1557]}} :line 1619}
{:clk 2371.9361 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2364.5058 :j 1555 :dets {:run {:m1 1560, :m2 1558, :m3 1555}, :bufs {:b1 [1559], :b2 [1556 1557]}} :line 1620}
{:clk 2371.9361 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1556 :dets {:run {:m1 1560, :m2 1558, :m3 nil}, :bufs {:b1 [1559], :b2 [1556 1557]}} :line 1621}
{:clk 2372.0058 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1558 :dets {:run {:m1 1560, :m2 1558, :m3 1556}, :bufs {:b1 [1559], :b2 [1557]}} :line 1622}
{:clk 2372.0058 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1559 :dets {:run {:m1 1560, :m2 nil, :m3 1556}, :bufs {:b1 [1559], :b2 [1557 1558]}} :line 1623}
{:clk 2372.6109 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1560 :dets {:run {:m1 1560, :m2 1559, :m3 1556}, :bufs {:b1 [], :b2 [1557 1558]}} :line 1624}
{:clk 2372.6109 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2375.5357 :j 1561 :dets {:run {:m1 nil, :m2 1559, :m3 1556}, :bufs {:b1 [1560], :b2 [1557 1558]}} :line 1625}
{:clk 2372.9361 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2366.0058 :j 1556 :dets {:run {:m1 1561, :m2 1559, :m3 1556}, :bufs {:b1 [1560], :b2 [1557 1558]}} :line 1626}
{:clk 2372.9361 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1557 :dets {:run {:m1 1561, :m2 1559, :m3 nil}, :bufs {:b1 [1560], :b2 [1557 1558]}} :line 1627}
{:clk 2373.9361 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2367.0058 :j 1557 :dets {:run {:m1 1561, :m2 1559, :m3 1557}, :bufs {:b1 [1560], :b2 [1558]}} :line 1628}
{:clk 2373.9361 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1558 :dets {:run {:m1 1561, :m2 1559, :m3 nil}, :bufs {:b1 [1560], :b2 [1558]}} :line 1629}
{:clk 2374.9361 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2368.0058 :j 1558 :dets {:run {:m1 1561, :m2 1559, :m3 1558}, :bufs {:b1 [1560], :b2 []}} :line 1630}
{:clk 2374.9361 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1561, :m2 1559, :m3 nil}, :bufs {:b1 [1560], :b2 []}} :line 1631}
{:clk 2375.1125 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1559 :dets {:run {:m1 1561, :m2 1559, :m3 nil}, :bufs {:b1 [1560], :b2 []}} :line 1632}
{:clk 2375.1125 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1560 :dets {:run {:m1 1561, :m2 nil, :m3 nil}, :bufs {:b1 [1560], :b2 [1559]}} :line 1633}
{:clk 2375.1125 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1561, :m2 1560, :m3 1559}, :bufs {:b1 [], :b2 []}} :line 1634}
{:clk 2375.1125 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1559 :dets {:run {:m1 1561, :m2 1560, :m3 nil}, :bufs {:b1 [], :b2 [1559]}} :line 1635}
{:clk 2375.5357 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1561 :dets {:run {:m1 1561, :m2 1560, :m3 1559}, :bufs {:b1 [], :b2 []}} :line 1636}
{:clk 2375.5357 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2376.775 :j 1562 :dets {:run {:m1 nil, :m2 1560, :m3 1559}, :bufs {:b1 [1561], :b2 []}} :line 1637}
{:clk 2376.6125 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1560 :dets {:run {:m1 1562, :m2 1560, :m3 1559}, :bufs {:b1 [1561], :b2 []}} :line 1638}
{:clk 2376.6125 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1561 :dets {:run {:m1 1562, :m2 nil, :m3 nil}, :bufs {:b1 [1561], :b2 [1560]}} :line 1639}
{:clk 2376.6125 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2369.0058 :j 1559 :dets {:run {:m1 1562, :m2 nil, :m3 1559}, :bufs {:b1 [1561], :b2 [1560]}} :line 1640}
{:clk 2376.6125 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1560 :dets {:run {:m1 1562, :m2 1561, :m3 nil}, :bufs {:b1 [], :b2 [1560]}} :line 1641}
{:clk 2376.7750 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1562 :dets {:run {:m1 1562, :m2 1561, :m3 1560}, :bufs {:b1 [], :b2 []}} :line 1642}
{:clk 2376.7750 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2377.775 :j 1563 :dets {:run {:m1 nil, :m2 1561, :m3 1560}, :bufs {:b1 [1562], :b2 []}} :line 1643}
{:clk 2377.7750 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1563 :dets {:run {:m1 1563, :m2 1561, :m3 1560}, :bufs {:b1 [1562], :b2 []}} :line 1644}
{:clk 2377.7750 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2378.775 :j 1564 :dets {:run {:m1 nil, :m2 1561, :m3 1560}, :bufs {:b1 [1562 1563], :b2 []}} :line 1645}
{:clk 2378.1125 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1561 :dets {:run {:m1 1564, :m2 1561, :m3 1560}, :bufs {:b1 [1562 1563], :b2 []}} :line 1646}
{:clk 2378.1125 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1562 :dets {:run {:m1 1564, :m2 nil, :m3 nil}, :bufs {:b1 [1562 1563], :b2 [1561]}} :line 1647}
{:clk 2378.1125 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2370.5058 :j 1560 :dets {:run {:m1 1564, :m2 nil, :m3 1560}, :bufs {:b1 [1562 1563], :b2 [1561]}} :line 1648}
{:clk 2378.1125 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1561 :dets {:run {:m1 1564, :m2 1562, :m3 nil}, :bufs {:b1 [1563], :b2 [1561]}} :line 1649}
{:clk 2378.7750 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1564 :dets {:run {:m1 1564, :m2 1562, :m3 1561}, :bufs {:b1 [1563], :b2 []}} :line 1650}
{:clk 2378.7750 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2379.775 :j 1565 :dets {:run {:m1 nil, :m2 1562, :m3 1561}, :bufs {:b1 [1563 1564], :b2 []}} :line 1651}
{:clk 2379.1125 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1562 :dets {:run {:m1 1565, :m2 1562, :m3 1561}, :bufs {:b1 [1563 1564], :b2 []}} :line 1652}
{:clk 2379.1125 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1563 :dets {:run {:m1 1565, :m2 nil, :m3 1561}, :bufs {:b1 [1563 1564], :b2 [1562]}} :line 1653}
{:clk 2379.6125 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2372.6109 :j 1561 :dets {:run {:m1 1565, :m2 1563, :m3 1561}, :bufs {:b1 [1564], :b2 [1562]}} :line 1654}
{:clk 2379.6125 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1562 :dets {:run {:m1 1565, :m2 1563, :m3 nil}, :bufs {:b1 [1564], :b2 [1562]}} :line 1655}
{:clk 2379.7750 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1565 :dets {:run {:m1 1565, :m2 1563, :m3 1562}, :bufs {:b1 [1564], :b2 []}} :line 1656}
{:clk 2379.7750 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2380.775 :j 1566 :dets {:run {:m1 nil, :m2 1563, :m3 1562}, :bufs {:b1 [1564 1565], :b2 []}} :line 1657}
{:clk 2380.4249 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1563 :dets {:run {:m1 1566, :m2 1563, :m3 1562}, :bufs {:b1 [1564 1565], :b2 []}} :line 1658}
{:clk 2380.4249 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1564 :dets {:run {:m1 1566, :m2 nil, :m3 1562}, :bufs {:b1 [1564 1565], :b2 [1563]}} :line 1659}
{:clk 2380.6125 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2375.5357 :j 1562 :dets {:run {:m1 1566, :m2 1564, :m3 1562}, :bufs {:b1 [1565], :b2 [1563]}} :line 1660}
{:clk 2380.6125 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1563 :dets {:run {:m1 1566, :m2 1564, :m3 nil}, :bufs {:b1 [1565], :b2 [1563]}} :line 1661}
{:clk 2380.7750 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1566 :dets {:run {:m1 1566, :m2 1564, :m3 1563}, :bufs {:b1 [1565], :b2 []}} :line 1662}
{:clk 2380.7750 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2382.275 :j 1567 :dets {:run {:m1 nil, :m2 1564, :m3 1563}, :bufs {:b1 [1565 1566], :b2 []}} :line 1663}
{:clk 2381.4249 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1564 :dets {:run {:m1 1567, :m2 1564, :m3 1563}, :bufs {:b1 [1565 1566], :b2 []}} :line 1664}
{:clk 2381.4249 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1565 :dets {:run {:m1 1567, :m2 nil, :m3 1563}, :bufs {:b1 [1565 1566], :b2 [1564]}} :line 1665}
{:clk 2381.6125 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2376.775 :j 1563 :dets {:run {:m1 1567, :m2 1565, :m3 1563}, :bufs {:b1 [1566], :b2 [1564]}} :line 1666}
{:clk 2381.6125 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1564 :dets {:run {:m1 1567, :m2 1565, :m3 nil}, :bufs {:b1 [1566], :b2 [1564]}} :line 1667}
{:clk 2382.2750 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1567 :dets {:run {:m1 1567, :m2 1565, :m3 1564}, :bufs {:b1 [1566], :b2 []}} :line 1668}
{:clk 2382.2750 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2383.275 :j 1568 :dets {:run {:m1 nil, :m2 1565, :m3 1564}, :bufs {:b1 [1566 1567], :b2 []}} :line 1669}
{:clk 2382.4249 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1565 :dets {:run {:m1 1568, :m2 1565, :m3 1564}, :bufs {:b1 [1566 1567], :b2 []}} :line 1670}
{:clk 2382.4249 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1566 :dets {:run {:m1 1568, :m2 nil, :m3 1564}, :bufs {:b1 [1566 1567], :b2 [1565]}} :line 1671}
{:clk 2382.6125 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2377.775 :j 1564 :dets {:run {:m1 1568, :m2 1566, :m3 1564}, :bufs {:b1 [1567], :b2 [1565]}} :line 1672}
{:clk 2382.6125 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1565 :dets {:run {:m1 1568, :m2 1566, :m3 nil}, :bufs {:b1 [1567], :b2 [1565]}} :line 1673}
{:clk 2383.2750 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1568 :dets {:run {:m1 1568, :m2 1566, :m3 1565}, :bufs {:b1 [1567], :b2 []}} :line 1674}
{:clk 2383.2750 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2384.2858 :j 1569 :dets {:run {:m1 nil, :m2 1566, :m3 1565}, :bufs {:b1 [1567 1568], :b2 []}} :line 1675}
{:clk 2383.4249 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1566 :dets {:run {:m1 1569, :m2 1566, :m3 1565}, :bufs {:b1 [1567 1568], :b2 []}} :line 1676}
{:clk 2383.4249 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1567 :dets {:run {:m1 1569, :m2 nil, :m3 1565}, :bufs {:b1 [1567 1568], :b2 [1566]}} :line 1677}
{:clk 2383.6125 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2378.775 :j 1565 :dets {:run {:m1 1569, :m2 1567, :m3 1565}, :bufs {:b1 [1568], :b2 [1566]}} :line 1678}
{:clk 2383.6125 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1566 :dets {:run {:m1 1569, :m2 1567, :m3 nil}, :bufs {:b1 [1568], :b2 [1566]}} :line 1679}
{:clk 2384.2858 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1569 :dets {:run {:m1 1569, :m2 1567, :m3 1566}, :bufs {:b1 [1568], :b2 []}} :line 1680}
{:clk 2384.2858 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2385.2858 :j 1570 :dets {:run {:m1 nil, :m2 1567, :m3 1566}, :bufs {:b1 [1568 1569], :b2 []}} :line 1681}
{:clk 2384.6125 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2379.775 :j 1566 :dets {:run {:m1 1570, :m2 1567, :m3 1566}, :bufs {:b1 [1568 1569], :b2 []}} :line 1682}
{:clk 2384.6125 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1570, :m2 1567, :m3 nil}, :bufs {:b1 [1568 1569], :b2 []}} :line 1683}
{:clk 2384.9249 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1567 :dets {:run {:m1 1570, :m2 1567, :m3 nil}, :bufs {:b1 [1568 1569], :b2 []}} :line 1684}
{:clk 2384.9249 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1568 :dets {:run {:m1 1570, :m2 nil, :m3 nil}, :bufs {:b1 [1568 1569], :b2 [1567]}} :line 1685}
{:clk 2384.9249 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1570, :m2 1568, :m3 1567}, :bufs {:b1 [1569], :b2 []}} :line 1686}
{:clk 2384.9249 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1567 :dets {:run {:m1 1570, :m2 1568, :m3 nil}, :bufs {:b1 [1569], :b2 [1567]}} :line 1687}
{:clk 2385.2858 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1570 :dets {:run {:m1 1570, :m2 1568, :m3 1567}, :bufs {:b1 [1569], :b2 []}} :line 1688}
{:clk 2385.2858 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2387.3978 :j 1571 :dets {:run {:m1 nil, :m2 1568, :m3 1567}, :bufs {:b1 [1569 1570], :b2 []}} :line 1689}
{:clk 2385.9249 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1568 :dets {:run {:m1 1571, :m2 1568, :m3 1567}, :bufs {:b1 [1569 1570], :b2 []}} :line 1690}
{:clk 2385.9249 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1569 :dets {:run {:m1 1571, :m2 nil, :m3 1567}, :bufs {:b1 [1569 1570], :b2 [1568]}} :line 1691}
{:clk 2386.4249 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2380.775 :j 1567 :dets {:run {:m1 1571, :m2 1569, :m3 1567}, :bufs {:b1 [1570], :b2 [1568]}} :line 1692}
{:clk 2386.4249 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1568 :dets {:run {:m1 1571, :m2 1569, :m3 nil}, :bufs {:b1 [1570], :b2 [1568]}} :line 1693}
{:clk 2386.9249 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1569 :dets {:run {:m1 1571, :m2 1569, :m3 1568}, :bufs {:b1 [1570], :b2 []}} :line 1694}
{:clk 2386.9249 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1570 :dets {:run {:m1 1571, :m2 nil, :m3 1568}, :bufs {:b1 [1570], :b2 [1569]}} :line 1695}
{:clk 2387.3978 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1571 :dets {:run {:m1 1571, :m2 1570, :m3 1568}, :bufs {:b1 [], :b2 [1569]}} :line 1696}
{:clk 2387.3978 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2389.3629 :j 1572 :dets {:run {:m1 nil, :m2 1570, :m3 1568}, :bufs {:b1 [1571], :b2 [1569]}} :line 1697}
{:clk 2387.4249 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2382.275 :j 1568 :dets {:run {:m1 1572, :m2 1570, :m3 1568}, :bufs {:b1 [1571], :b2 [1569]}} :line 1698}
{:clk 2387.4249 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1569 :dets {:run {:m1 1572, :m2 1570, :m3 nil}, :bufs {:b1 [1571], :b2 [1569]}} :line 1699}
{:clk 2387.9249 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1570 :dets {:run {:m1 1572, :m2 1570, :m3 1569}, :bufs {:b1 [1571], :b2 []}} :line 1700}
{:clk 2387.9249 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1571 :dets {:run {:m1 1572, :m2 nil, :m3 1569}, :bufs {:b1 [1571], :b2 [1570]}} :line 1701}
{:clk 2388.4249 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2383.275 :j 1569 :dets {:run {:m1 1572, :m2 1571, :m3 1569}, :bufs {:b1 [], :b2 [1570]}} :line 1702}
{:clk 2388.4249 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1570 :dets {:run {:m1 1572, :m2 1571, :m3 nil}, :bufs {:b1 [], :b2 [1570]}} :line 1703}
{:clk 2389.3629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1572 :dets {:run {:m1 1572, :m2 1571, :m3 1570}, :bufs {:b1 [], :b2 []}} :line 1704}
{:clk 2389.3629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2390.8629 :j 1573 :dets {:run {:m1 nil, :m2 1571, :m3 1570}, :bufs {:b1 [1572], :b2 []}} :line 1705}
{:clk 2389.4249 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1571 :dets {:run {:m1 1573, :m2 1571, :m3 1570}, :bufs {:b1 [1572], :b2 []}} :line 1706}
{:clk 2389.4249 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1572 :dets {:run {:m1 1573, :m2 nil, :m3 nil}, :bufs {:b1 [1572], :b2 [1571]}} :line 1707}
{:clk 2389.4249 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2384.2858 :j 1570 :dets {:run {:m1 1573, :m2 nil, :m3 1570}, :bufs {:b1 [1572], :b2 [1571]}} :line 1708}
{:clk 2389.4249 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1571 :dets {:run {:m1 1573, :m2 1572, :m3 nil}, :bufs {:b1 [], :b2 [1571]}} :line 1709}
{:clk 2390.8629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1573 :dets {:run {:m1 1573, :m2 1572, :m3 1571}, :bufs {:b1 [], :b2 []}} :line 1710}
{:clk 2390.8629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2391.8629 :j 1574 :dets {:run {:m1 nil, :m2 1572, :m3 1571}, :bufs {:b1 [1573], :b2 []}} :line 1711}
{:clk 2390.9249 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1572 :dets {:run {:m1 1574, :m2 1572, :m3 1571}, :bufs {:b1 [1573], :b2 []}} :line 1712}
{:clk 2390.9249 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1573 :dets {:run {:m1 1574, :m2 nil, :m3 nil}, :bufs {:b1 [1573], :b2 [1572]}} :line 1713}
{:clk 2390.9249 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2385.2858 :j 1571 :dets {:run {:m1 1574, :m2 nil, :m3 1571}, :bufs {:b1 [1573], :b2 [1572]}} :line 1714}
{:clk 2390.9249 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1572 :dets {:run {:m1 1574, :m2 1573, :m3 nil}, :bufs {:b1 [], :b2 [1572]}} :line 1715}
{:clk 2391.8629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1574 :dets {:run {:m1 1574, :m2 1573, :m3 1572}, :bufs {:b1 [], :b2 []}} :line 1716}
{:clk 2391.8629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2392.8629 :j 1575 :dets {:run {:m1 nil, :m2 1573, :m3 1572}, :bufs {:b1 [1574], :b2 []}} :line 1717}
{:clk 2392.4249 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1573 :dets {:run {:m1 1575, :m2 1573, :m3 1572}, :bufs {:b1 [1574], :b2 []}} :line 1718}
{:clk 2392.4249 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1574 :dets {:run {:m1 1575, :m2 nil, :m3 1572}, :bufs {:b1 [1574], :b2 [1573]}} :line 1719}
{:clk 2392.8629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1575 :dets {:run {:m1 1575, :m2 1574, :m3 1572}, :bufs {:b1 [], :b2 [1573]}} :line 1720}
{:clk 2392.8629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2394.3629 :j 1576 :dets {:run {:m1 nil, :m2 1574, :m3 1572}, :bufs {:b1 [1575], :b2 [1573]}} :line 1721}
{:clk 2393.4249 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1574 :dets {:run {:m1 1576, :m2 1574, :m3 1572}, :bufs {:b1 [1575], :b2 [1573]}} :line 1722}
{:clk 2393.4249 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1575 :dets {:run {:m1 1576, :m2 nil, :m3 1572}, :bufs {:b1 [1575], :b2 [1573 1574]}} :line 1723}
{:clk 2393.5640 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2387.3978 :j 1572 :dets {:run {:m1 1576, :m2 1575, :m3 1572}, :bufs {:b1 [], :b2 [1573 1574]}} :line 1724}
{:clk 2393.5640 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1573 :dets {:run {:m1 1576, :m2 1575, :m3 nil}, :bufs {:b1 [], :b2 [1573 1574]}} :line 1725}
{:clk 2394.3629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1576 :dets {:run {:m1 1576, :m2 1575, :m3 1573}, :bufs {:b1 [], :b2 [1574]}} :line 1726}
{:clk 2394.3629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2395.3629 :j 1577 :dets {:run {:m1 nil, :m2 1575, :m3 1573}, :bufs {:b1 [1576], :b2 [1574]}} :line 1727}
{:clk 2394.4249 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1575 :dets {:run {:m1 1577, :m2 1575, :m3 1573}, :bufs {:b1 [1576], :b2 [1574]}} :line 1728}
{:clk 2394.4249 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1576 :dets {:run {:m1 1577, :m2 nil, :m3 1573}, :bufs {:b1 [1576], :b2 [1574 1575]}} :line 1729}
{:clk 2395.0640 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2389.3629 :j 1573 :dets {:run {:m1 1577, :m2 1576, :m3 1573}, :bufs {:b1 [], :b2 [1574 1575]}} :line 1730}
{:clk 2395.0640 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1574 :dets {:run {:m1 1577, :m2 1576, :m3 nil}, :bufs {:b1 [], :b2 [1574 1575]}} :line 1731}
{:clk 2395.3629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1577 :dets {:run {:m1 1577, :m2 1576, :m3 1574}, :bufs {:b1 [], :b2 [1575]}} :line 1732}
{:clk 2395.3629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2396.3629 :j 1578 :dets {:run {:m1 nil, :m2 1576, :m3 1574}, :bufs {:b1 [1577], :b2 [1575]}} :line 1733}
{:clk 2395.9249 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1576 :dets {:run {:m1 1578, :m2 1576, :m3 1574}, :bufs {:b1 [1577], :b2 [1575]}} :line 1734}
{:clk 2395.9249 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1577 :dets {:run {:m1 1578, :m2 nil, :m3 1574}, :bufs {:b1 [1577], :b2 [1575 1576]}} :line 1735}
{:clk 2396.3629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1578 :dets {:run {:m1 1578, :m2 1577, :m3 1574}, :bufs {:b1 [], :b2 [1575 1576]}} :line 1736}
{:clk 2396.3629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2397.8629 :j 1579 :dets {:run {:m1 nil, :m2 1577, :m3 1574}, :bufs {:b1 [1578], :b2 [1575 1576]}} :line 1737}
{:clk 2396.4684 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2390.8629 :j 1574 :dets {:run {:m1 1579, :m2 1577, :m3 1574}, :bufs {:b1 [1578], :b2 [1575 1576]}} :line 1738}
{:clk 2396.4684 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1575 :dets {:run {:m1 1579, :m2 1577, :m3 nil}, :bufs {:b1 [1578], :b2 [1575 1576]}} :line 1739}
{:clk 2396.9249 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1577 :dets {:run {:m1 1579, :m2 1577, :m3 1575}, :bufs {:b1 [1578], :b2 [1576]}} :line 1740}
{:clk 2396.9249 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1578 :dets {:run {:m1 1579, :m2 nil, :m3 1575}, :bufs {:b1 [1578], :b2 [1576 1577]}} :line 1741}
{:clk 2397.4684 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2391.8629 :j 1575 :dets {:run {:m1 1579, :m2 1578, :m3 1575}, :bufs {:b1 [], :b2 [1576 1577]}} :line 1742}
{:clk 2397.4684 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1576 :dets {:run {:m1 1579, :m2 1578, :m3 nil}, :bufs {:b1 [], :b2 [1576 1577]}} :line 1743}
{:clk 2397.8629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1579 :dets {:run {:m1 1579, :m2 1578, :m3 1576}, :bufs {:b1 [], :b2 [1577]}} :line 1744}
{:clk 2397.8629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2399.3629 :j 1580 :dets {:run {:m1 nil, :m2 1578, :m3 1576}, :bufs {:b1 [1579], :b2 [1577]}} :line 1745}
{:clk 2398.9684 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2392.8629 :j 1576 :dets {:run {:m1 1580, :m2 1578, :m3 1576}, :bufs {:b1 [1579], :b2 [1577]}} :line 1746}
{:clk 2398.9684 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1577 :dets {:run {:m1 1580, :m2 1578, :m3 nil}, :bufs {:b1 [1579], :b2 [1577]}} :line 1747}
{:clk 2399.0310 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1578 :dets {:run {:m1 1580, :m2 1578, :m3 1577}, :bufs {:b1 [1579], :b2 []}} :line 1748}
{:clk 2399.0310 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1579 :dets {:run {:m1 1580, :m2 nil, :m3 1577}, :bufs {:b1 [1579], :b2 [1578]}} :line 1749}
{:clk 2399.3629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1580 :dets {:run {:m1 1580, :m2 1579, :m3 1577}, :bufs {:b1 [], :b2 [1578]}} :line 1750}
{:clk 2399.3629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2400.8629 :j 1581 :dets {:run {:m1 nil, :m2 1579, :m3 1577}, :bufs {:b1 [1580], :b2 [1578]}} :line 1751}
{:clk 2399.9684 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2394.3629 :j 1577 :dets {:run {:m1 1581, :m2 1579, :m3 1577}, :bufs {:b1 [1580], :b2 [1578]}} :line 1752}
{:clk 2399.9684 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1578 :dets {:run {:m1 1581, :m2 1579, :m3 nil}, :bufs {:b1 [1580], :b2 [1578]}} :line 1753}
{:clk 2400.5310 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1579 :dets {:run {:m1 1581, :m2 1579, :m3 1578}, :bufs {:b1 [1580], :b2 []}} :line 1754}
{:clk 2400.5310 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1580 :dets {:run {:m1 1581, :m2 nil, :m3 1578}, :bufs {:b1 [1580], :b2 [1579]}} :line 1755}
{:clk 2400.8629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1581 :dets {:run {:m1 1581, :m2 1580, :m3 1578}, :bufs {:b1 [], :b2 [1579]}} :line 1756}
{:clk 2400.8629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2402.3629 :j 1582 :dets {:run {:m1 nil, :m2 1580, :m3 1578}, :bufs {:b1 [1581], :b2 [1579]}} :line 1757}
{:clk 2400.9684 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2395.3629 :j 1578 :dets {:run {:m1 1582, :m2 1580, :m3 1578}, :bufs {:b1 [1581], :b2 [1579]}} :line 1758}
{:clk 2400.9684 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1579 :dets {:run {:m1 1582, :m2 1580, :m3 nil}, :bufs {:b1 [1581], :b2 [1579]}} :line 1759}
{:clk 2402.0310 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1580 :dets {:run {:m1 1582, :m2 1580, :m3 1579}, :bufs {:b1 [1581], :b2 []}} :line 1760}
{:clk 2402.0310 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1581 :dets {:run {:m1 1582, :m2 nil, :m3 1579}, :bufs {:b1 [1581], :b2 [1580]}} :line 1761}
{:clk 2402.3629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1582 :dets {:run {:m1 1582, :m2 1581, :m3 1579}, :bufs {:b1 [], :b2 [1580]}} :line 1762}
{:clk 2402.3629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2403.8629 :j 1583 :dets {:run {:m1 nil, :m2 1581, :m3 1579}, :bufs {:b1 [1582], :b2 [1580]}} :line 1763}
{:clk 2402.4684 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2396.3629 :j 1579 :dets {:run {:m1 1583, :m2 1581, :m3 1579}, :bufs {:b1 [1582], :b2 [1580]}} :line 1764}
{:clk 2402.4684 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1580 :dets {:run {:m1 1583, :m2 1581, :m3 nil}, :bufs {:b1 [1582], :b2 [1580]}} :line 1765}
{:clk 2403.5310 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1581 :dets {:run {:m1 1583, :m2 1581, :m3 1580}, :bufs {:b1 [1582], :b2 []}} :line 1766}
{:clk 2403.5310 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1582 :dets {:run {:m1 1583, :m2 nil, :m3 1580}, :bufs {:b1 [1582], :b2 [1581]}} :line 1767}
{:clk 2403.8629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1583 :dets {:run {:m1 1583, :m2 1582, :m3 1580}, :bufs {:b1 [], :b2 [1581]}} :line 1768}
{:clk 2403.8629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2404.8629 :j 1584 :dets {:run {:m1 nil, :m2 1582, :m3 1580}, :bufs {:b1 [1583], :b2 [1581]}} :line 1769}
{:clk 2403.9684 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2397.8629 :j 1580 :dets {:run {:m1 1584, :m2 1582, :m3 1580}, :bufs {:b1 [1583], :b2 [1581]}} :line 1770}
{:clk 2403.9684 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1581 :dets {:run {:m1 1584, :m2 1582, :m3 nil}, :bufs {:b1 [1583], :b2 [1581]}} :line 1771}
{:clk 2404.8629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1584 :dets {:run {:m1 1584, :m2 1582, :m3 1581}, :bufs {:b1 [1583], :b2 []}} :line 1772}
{:clk 2404.8629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2406.3629 :j 1585 :dets {:run {:m1 nil, :m2 1582, :m3 1581}, :bufs {:b1 [1583 1584], :b2 []}} :line 1773}
{:clk 2405.0310 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1582 :dets {:run {:m1 1585, :m2 1582, :m3 1581}, :bufs {:b1 [1583 1584], :b2 []}} :line 1774}
{:clk 2405.0310 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1583 :dets {:run {:m1 1585, :m2 nil, :m3 1581}, :bufs {:b1 [1583 1584], :b2 [1582]}} :line 1775}
{:clk 2405.4684 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2399.3629 :j 1581 :dets {:run {:m1 1585, :m2 1583, :m3 1581}, :bufs {:b1 [1584], :b2 [1582]}} :line 1776}
{:clk 2405.4684 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1582 :dets {:run {:m1 1585, :m2 1583, :m3 nil}, :bufs {:b1 [1584], :b2 [1582]}} :line 1777}
{:clk 2406.3629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1585 :dets {:run {:m1 1585, :m2 1583, :m3 1582}, :bufs {:b1 [1584], :b2 []}} :line 1778}
{:clk 2406.3629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2407.8629 :j 1586 :dets {:run {:m1 nil, :m2 1583, :m3 1582}, :bufs {:b1 [1584 1585], :b2 []}} :line 1779}
{:clk 2406.5310 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1583 :dets {:run {:m1 1586, :m2 1583, :m3 1582}, :bufs {:b1 [1584 1585], :b2 []}} :line 1780}
{:clk 2406.5310 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1584 :dets {:run {:m1 1586, :m2 nil, :m3 1582}, :bufs {:b1 [1584 1585], :b2 [1583]}} :line 1781}
{:clk 2406.9684 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2400.8629 :j 1582 :dets {:run {:m1 1586, :m2 1584, :m3 1582}, :bufs {:b1 [1585], :b2 [1583]}} :line 1782}
{:clk 2406.9684 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1583 :dets {:run {:m1 1586, :m2 1584, :m3 nil}, :bufs {:b1 [1585], :b2 [1583]}} :line 1783}
{:clk 2407.5310 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1584 :dets {:run {:m1 1586, :m2 1584, :m3 1583}, :bufs {:b1 [1585], :b2 []}} :line 1784}
{:clk 2407.5310 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1585 :dets {:run {:m1 1586, :m2 nil, :m3 1583}, :bufs {:b1 [1585], :b2 [1584]}} :line 1785}
{:clk 2407.8629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1586 :dets {:run {:m1 1586, :m2 1585, :m3 1583}, :bufs {:b1 [], :b2 [1584]}} :line 1786}
{:clk 2407.8629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2409.3629 :j 1587 :dets {:run {:m1 nil, :m2 1585, :m3 1583}, :bufs {:b1 [1586], :b2 [1584]}} :line 1787}
{:clk 2408.4684 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2402.3629 :j 1583 :dets {:run {:m1 1587, :m2 1585, :m3 1583}, :bufs {:b1 [1586], :b2 [1584]}} :line 1788}
{:clk 2408.4684 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1584 :dets {:run {:m1 1587, :m2 1585, :m3 nil}, :bufs {:b1 [1586], :b2 [1584]}} :line 1789}
{:clk 2409.0310 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1585 :dets {:run {:m1 1587, :m2 1585, :m3 1584}, :bufs {:b1 [1586], :b2 []}} :line 1790}
{:clk 2409.0310 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1586 :dets {:run {:m1 1587, :m2 nil, :m3 1584}, :bufs {:b1 [1586], :b2 [1585]}} :line 1791}
{:clk 2409.3629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1587 :dets {:run {:m1 1587, :m2 1586, :m3 1584}, :bufs {:b1 [], :b2 [1585]}} :line 1792}
{:clk 2409.3629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2410.3629 :j 1588 :dets {:run {:m1 nil, :m2 1586, :m3 1584}, :bufs {:b1 [1587], :b2 [1585]}} :line 1793}
{:clk 2409.4684 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2403.8629 :j 1584 :dets {:run {:m1 1588, :m2 1586, :m3 1584}, :bufs {:b1 [1587], :b2 [1585]}} :line 1794}
{:clk 2409.4684 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1585 :dets {:run {:m1 1588, :m2 1586, :m3 nil}, :bufs {:b1 [1587], :b2 [1585]}} :line 1795}
{:clk 2410.3629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1588 :dets {:run {:m1 1588, :m2 1586, :m3 1585}, :bufs {:b1 [1587], :b2 []}} :line 1796}
{:clk 2410.3629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2411.8629 :j 1589 :dets {:run {:m1 nil, :m2 1586, :m3 1585}, :bufs {:b1 [1587 1588], :b2 []}} :line 1797}
{:clk 2410.5310 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1586 :dets {:run {:m1 1589, :m2 1586, :m3 1585}, :bufs {:b1 [1587 1588], :b2 []}} :line 1798}
{:clk 2410.5310 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1587 :dets {:run {:m1 1589, :m2 nil, :m3 1585}, :bufs {:b1 [1587 1588], :b2 [1586]}} :line 1799}
{:clk 2410.9684 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2404.8629 :j 1585 :dets {:run {:m1 1589, :m2 1587, :m3 1585}, :bufs {:b1 [1588], :b2 [1586]}} :line 1800}
{:clk 2410.9684 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1586 :dets {:run {:m1 1589, :m2 1587, :m3 nil}, :bufs {:b1 [1588], :b2 [1586]}} :line 1801}
{:clk 2411.8629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1589 :dets {:run {:m1 1589, :m2 1587, :m3 1586}, :bufs {:b1 [1588], :b2 []}} :line 1802}
{:clk 2411.8629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2412.8629 :j 1590 :dets {:run {:m1 nil, :m2 1587, :m3 1586}, :bufs {:b1 [1588 1589], :b2 []}} :line 1803}
{:clk 2412.2189 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1587 :dets {:run {:m1 1590, :m2 1587, :m3 1586}, :bufs {:b1 [1588 1589], :b2 []}} :line 1804}
{:clk 2412.2189 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1588 :dets {:run {:m1 1590, :m2 nil, :m3 1586}, :bufs {:b1 [1588 1589], :b2 [1587]}} :line 1805}
{:clk 2412.8629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1590 :dets {:run {:m1 1590, :m2 1588, :m3 1586}, :bufs {:b1 [1589], :b2 [1587]}} :line 1806}
{:clk 2412.8629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2413.8629 :j 1591 :dets {:run {:m1 nil, :m2 1588, :m3 1586}, :bufs {:b1 [1589 1590], :b2 [1587]}} :line 1807}
{:clk 2413.2189 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1588 :dets {:run {:m1 1591, :m2 1588, :m3 1586}, :bufs {:b1 [1589 1590], :b2 [1587]}} :line 1808}
{:clk 2413.2189 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1589 :dets {:run {:m1 1591, :m2 nil, :m3 1586}, :bufs {:b1 [1589 1590], :b2 [1587 1588]}} :line 1809}
{:clk 2413.8629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1591 :dets {:run {:m1 1591, :m2 1589, :m3 1586}, :bufs {:b1 [1590], :b2 [1587 1588]}} :line 1810}
{:clk 2413.8629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2415.3629 :j 1592 :dets {:run {:m1 nil, :m2 1589, :m3 1586}, :bufs {:b1 [1590 1591], :b2 [1587 1588]}} :line 1811}
{:clk 2413.9227 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2406.3629 :j 1586 :dets {:run {:m1 1592, :m2 1589, :m3 1586}, :bufs {:b1 [1590 1591], :b2 [1587 1588]}} :line 1812}
{:clk 2413.9227 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1587 :dets {:run {:m1 1592, :m2 1589, :m3 nil}, :bufs {:b1 [1590 1591], :b2 [1587 1588]}} :line 1813}
{:clk 2414.7189 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1589 :dets {:run {:m1 1592, :m2 1589, :m3 1587}, :bufs {:b1 [1590 1591], :b2 [1588]}} :line 1814}
{:clk 2414.7189 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1590 :dets {:run {:m1 1592, :m2 nil, :m3 1587}, :bufs {:b1 [1590 1591], :b2 [1588 1589]}} :line 1815}
{:clk 2415.3629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1592 :dets {:run {:m1 1592, :m2 1590, :m3 1587}, :bufs {:b1 [1591], :b2 [1588 1589]}} :line 1816}
{:clk 2415.3629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2416.3629 :j 1593 :dets {:run {:m1 nil, :m2 1590, :m3 1587}, :bufs {:b1 [1591 1592], :b2 [1588 1589]}} :line 1817}
{:clk 2415.4227 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2407.8629 :j 1587 :dets {:run {:m1 1593, :m2 1590, :m3 1587}, :bufs {:b1 [1591 1592], :b2 [1588 1589]}} :line 1818}
{:clk 2415.4227 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1588 :dets {:run {:m1 1593, :m2 1590, :m3 nil}, :bufs {:b1 [1591 1592], :b2 [1588 1589]}} :line 1819}
{:clk 2415.7189 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1590 :dets {:run {:m1 1593, :m2 1590, :m3 1588}, :bufs {:b1 [1591 1592], :b2 [1589]}} :line 1820}
{:clk 2415.7189 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1591 :dets {:run {:m1 1593, :m2 nil, :m3 1588}, :bufs {:b1 [1591 1592], :b2 [1589 1590]}} :line 1821}
{:clk 2416.3629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1593 :dets {:run {:m1 1593, :m2 1591, :m3 1588}, :bufs {:b1 [1592], :b2 [1589 1590]}} :line 1822}
{:clk 2416.3629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2417.8629 :j 1594 :dets {:run {:m1 nil, :m2 1591, :m3 1588}, :bufs {:b1 [1592 1593], :b2 [1589 1590]}} :line 1823}
{:clk 2416.4227 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2409.3629 :j 1588 :dets {:run {:m1 1594, :m2 1591, :m3 1588}, :bufs {:b1 [1592 1593], :b2 [1589 1590]}} :line 1824}
{:clk 2416.4227 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1589 :dets {:run {:m1 1594, :m2 1591, :m3 nil}, :bufs {:b1 [1592 1593], :b2 [1589 1590]}} :line 1825}
{:clk 2416.7189 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1591 :dets {:run {:m1 1594, :m2 1591, :m3 1589}, :bufs {:b1 [1592 1593], :b2 [1590]}} :line 1826}
{:clk 2416.7189 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1592 :dets {:run {:m1 1594, :m2 nil, :m3 1589}, :bufs {:b1 [1592 1593], :b2 [1590 1591]}} :line 1827}
{:clk 2417.8629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1594 :dets {:run {:m1 1594, :m2 1592, :m3 1589}, :bufs {:b1 [1593], :b2 [1590 1591]}} :line 1828}
{:clk 2417.8629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2419.3629 :j 1595 :dets {:run {:m1 nil, :m2 1592, :m3 1589}, :bufs {:b1 [1593 1594], :b2 [1590 1591]}} :line 1829}
{:clk 2417.9227 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2410.3629 :j 1589 :dets {:run {:m1 1595, :m2 1592, :m3 1589}, :bufs {:b1 [1593 1594], :b2 [1590 1591]}} :line 1830}
{:clk 2417.9227 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1590 :dets {:run {:m1 1595, :m2 1592, :m3 nil}, :bufs {:b1 [1593 1594], :b2 [1590 1591]}} :line 1831}
{:clk 2418.2189 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1592 :dets {:run {:m1 1595, :m2 1592, :m3 1590}, :bufs {:b1 [1593 1594], :b2 [1591]}} :line 1832}
{:clk 2418.2189 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1593 :dets {:run {:m1 1595, :m2 nil, :m3 1590}, :bufs {:b1 [1593 1594], :b2 [1591 1592]}} :line 1833}
{:clk 2418.9227 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2411.8629 :j 1590 :dets {:run {:m1 1595, :m2 1593, :m3 1590}, :bufs {:b1 [1594], :b2 [1591 1592]}} :line 1834}
{:clk 2418.9227 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1591 :dets {:run {:m1 1595, :m2 1593, :m3 nil}, :bufs {:b1 [1594], :b2 [1591 1592]}} :line 1835}
{:clk 2419.2189 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1593 :dets {:run {:m1 1595, :m2 1593, :m3 1591}, :bufs {:b1 [1594], :b2 [1592]}} :line 1836}
{:clk 2419.2189 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1594 :dets {:run {:m1 1595, :m2 nil, :m3 1591}, :bufs {:b1 [1594], :b2 [1592 1593]}} :line 1837}
{:clk 2419.3629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1595 :dets {:run {:m1 1595, :m2 1594, :m3 1591}, :bufs {:b1 [], :b2 [1592 1593]}} :line 1838}
{:clk 2419.3629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2420.8629 :j 1596 :dets {:run {:m1 nil, :m2 1594, :m3 1591}, :bufs {:b1 [1595], :b2 [1592 1593]}} :line 1839}
{:clk 2419.9938 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2412.8629 :j 1591 :dets {:run {:m1 1596, :m2 1594, :m3 1591}, :bufs {:b1 [1595], :b2 [1592 1593]}} :line 1840}
{:clk 2419.9938 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1592 :dets {:run {:m1 1596, :m2 1594, :m3 nil}, :bufs {:b1 [1595], :b2 [1592 1593]}} :line 1841}
{:clk 2420.7189 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1594 :dets {:run {:m1 1596, :m2 1594, :m3 1592}, :bufs {:b1 [1595], :b2 [1593]}} :line 1842}
{:clk 2420.7189 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1595 :dets {:run {:m1 1596, :m2 nil, :m3 1592}, :bufs {:b1 [1595], :b2 [1593 1594]}} :line 1843}
{:clk 2420.8629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1596 :dets {:run {:m1 1596, :m2 1595, :m3 1592}, :bufs {:b1 [], :b2 [1593 1594]}} :line 1844}
{:clk 2420.8629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2421.8629 :j 1597 :dets {:run {:m1 nil, :m2 1595, :m3 1592}, :bufs {:b1 [1596], :b2 [1593 1594]}} :line 1845}
{:clk 2421.4938 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2413.8629 :j 1592 :dets {:run {:m1 1597, :m2 1595, :m3 1592}, :bufs {:b1 [1596], :b2 [1593 1594]}} :line 1846}
{:clk 2421.4938 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1593 :dets {:run {:m1 1597, :m2 1595, :m3 nil}, :bufs {:b1 [1596], :b2 [1593 1594]}} :line 1847}
{:clk 2421.8629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1597 :dets {:run {:m1 1597, :m2 1595, :m3 1593}, :bufs {:b1 [1596], :b2 [1594]}} :line 1848}
{:clk 2421.8629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2423.3629 :j 1598 :dets {:run {:m1 nil, :m2 1595, :m3 1593}, :bufs {:b1 [1596 1597], :b2 [1594]}} :line 1849}
{:clk 2422.2189 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1595 :dets {:run {:m1 1598, :m2 1595, :m3 1593}, :bufs {:b1 [1596 1597], :b2 [1594]}} :line 1850}
{:clk 2422.2189 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1596 :dets {:run {:m1 1598, :m2 nil, :m3 1593}, :bufs {:b1 [1596 1597], :b2 [1594 1595]}} :line 1851}
{:clk 2422.4938 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2415.3629 :j 1593 :dets {:run {:m1 1598, :m2 1596, :m3 1593}, :bufs {:b1 [1597], :b2 [1594 1595]}} :line 1852}
{:clk 2422.4938 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1594 :dets {:run {:m1 1598, :m2 1596, :m3 nil}, :bufs {:b1 [1597], :b2 [1594 1595]}} :line 1853}
{:clk 2423.3629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1598 :dets {:run {:m1 1598, :m2 1596, :m3 1594}, :bufs {:b1 [1597], :b2 [1595]}} :line 1854}
{:clk 2423.3629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2424.8629 :j 1599 :dets {:run {:m1 nil, :m2 1596, :m3 1594}, :bufs {:b1 [1597 1598], :b2 [1595]}} :line 1855}
{:clk 2423.9938 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2416.3629 :j 1594 :dets {:run {:m1 1599, :m2 1596, :m3 1594}, :bufs {:b1 [1597 1598], :b2 [1595]}} :line 1856}
{:clk 2423.9938 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1595 :dets {:run {:m1 1599, :m2 1596, :m3 nil}, :bufs {:b1 [1597 1598], :b2 [1595]}} :line 1857}
{:clk 2424.0234 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1596 :dets {:run {:m1 1599, :m2 1596, :m3 1595}, :bufs {:b1 [1597 1598], :b2 []}} :line 1858}
{:clk 2424.0234 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1597 :dets {:run {:m1 1599, :m2 nil, :m3 1595}, :bufs {:b1 [1597 1598], :b2 [1596]}} :line 1859}
{:clk 2424.8629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1599 :dets {:run {:m1 1599, :m2 1597, :m3 1595}, :bufs {:b1 [1598], :b2 [1596]}} :line 1860}
{:clk 2424.8629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2425.8629 :j 1600 :dets {:run {:m1 nil, :m2 1597, :m3 1595}, :bufs {:b1 [1598 1599], :b2 [1596]}} :line 1861}
{:clk 2425.0234 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1597 :dets {:run {:m1 1600, :m2 1597, :m3 1595}, :bufs {:b1 [1598 1599], :b2 [1596]}} :line 1862}
{:clk 2425.0234 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1598 :dets {:run {:m1 1600, :m2 nil, :m3 1595}, :bufs {:b1 [1598 1599], :b2 [1596 1597]}} :line 1863}
{:clk 2425.4938 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2417.8629 :j 1595 :dets {:run {:m1 1600, :m2 1598, :m3 1595}, :bufs {:b1 [1599], :b2 [1596 1597]}} :line 1864}
{:clk 2425.4938 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1596 :dets {:run {:m1 1600, :m2 1598, :m3 nil}, :bufs {:b1 [1599], :b2 [1596 1597]}} :line 1865}
{:clk 2425.8629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1600 :dets {:run {:m1 1600, :m2 1598, :m3 1596}, :bufs {:b1 [1599], :b2 [1597]}} :line 1866}
{:clk 2425.8629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2427.3629 :j 1601 :dets {:run {:m1 nil, :m2 1598, :m3 1596}, :bufs {:b1 [1599 1600], :b2 [1597]}} :line 1867}
{:clk 2426.5234 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1598 :dets {:run {:m1 1601, :m2 1598, :m3 1596}, :bufs {:b1 [1599 1600], :b2 [1597]}} :line 1868}
{:clk 2426.5234 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1599 :dets {:run {:m1 1601, :m2 nil, :m3 1596}, :bufs {:b1 [1599 1600], :b2 [1597 1598]}} :line 1869}
{:clk 2426.9938 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2419.3629 :j 1596 :dets {:run {:m1 1601, :m2 1599, :m3 1596}, :bufs {:b1 [1600], :b2 [1597 1598]}} :line 1870}
{:clk 2426.9938 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1597 :dets {:run {:m1 1601, :m2 1599, :m3 nil}, :bufs {:b1 [1600], :b2 [1597 1598]}} :line 1871}
{:clk 2427.3629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1601 :dets {:run {:m1 1601, :m2 1599, :m3 1597}, :bufs {:b1 [1600], :b2 [1598]}} :line 1872}
{:clk 2427.3629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2428.3629 :j 1602 :dets {:run {:m1 nil, :m2 1599, :m3 1597}, :bufs {:b1 [1600 1601], :b2 [1598]}} :line 1873}
{:clk 2427.9938 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2420.8629 :j 1597 :dets {:run {:m1 1602, :m2 1599, :m3 1597}, :bufs {:b1 [1600 1601], :b2 [1598]}} :line 1874}
{:clk 2427.9938 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1598 :dets {:run {:m1 1602, :m2 1599, :m3 nil}, :bufs {:b1 [1600 1601], :b2 [1598]}} :line 1875}
{:clk 2428.0234 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1599 :dets {:run {:m1 1602, :m2 1599, :m3 1598}, :bufs {:b1 [1600 1601], :b2 []}} :line 1876}
{:clk 2428.0234 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1600 :dets {:run {:m1 1602, :m2 nil, :m3 1598}, :bufs {:b1 [1600 1601], :b2 [1599]}} :line 1877}
{:clk 2428.3629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1602 :dets {:run {:m1 1602, :m2 1600, :m3 1598}, :bufs {:b1 [1601], :b2 [1599]}} :line 1878}
{:clk 2428.3629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2429.3629 :j 1603 :dets {:run {:m1 nil, :m2 1600, :m3 1598}, :bufs {:b1 [1601 1602], :b2 [1599]}} :line 1879}
{:clk 2429.0234 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1600 :dets {:run {:m1 1603, :m2 1600, :m3 1598}, :bufs {:b1 [1601 1602], :b2 [1599]}} :line 1880}
{:clk 2429.0234 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1601 :dets {:run {:m1 1603, :m2 nil, :m3 1598}, :bufs {:b1 [1601 1602], :b2 [1599 1600]}} :line 1881}
{:clk 2429.3629 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1603 :dets {:run {:m1 1603, :m2 1601, :m3 1598}, :bufs {:b1 [1602], :b2 [1599 1600]}} :line 1882}
{:clk 2429.3629 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2430.3629 :j 1604 :dets {:run {:m1 nil, :m2 1601, :m3 1598}, :bufs {:b1 [1602 1603], :b2 [1599 1600]}} :line 1883}
{:clk 2429.4938 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2421.8629 :j 1598 :dets {:run {:m1 1604, :m2 1601, :m3 1598}, :bufs {:b1 [1602 1603], :b2 [1599 1600]}} :line 1884}
{:clk 2429.4938 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1599 :dets {:run {:m1 1604, :m2 1601, :m3 nil}, :bufs {:b1 [1602 1603], :b2 [1599 1600]}} :line 1885}
{:clk 2430.3629 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1604, :m2 1601, :m3 1599}, :bufs {:b1 [1602 1603], :b2 [1600]}} :line 1886}
{:clk 2430.8000 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1601 :dets {:run {:m1 1604, :m2 1601, :m3 1599}, :bufs {:b1 [1602 1603], :b2 [1600]}} :line 1887}
{:clk 2430.8000 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1602 :dets {:run {:m1 1604, :m2 nil, :m3 1599}, :bufs {:b1 [1602 1603], :b2 [1600 1601]}} :line 1888}
{:clk 2430.8000 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1602, :m3 1599}, :bufs {:b1 [1603 1604], :b2 [1600 1601]}} :line 1889}
{:clk 2430.8000 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1604 :dets {:run {:m1 1604, :m2 1602, :m3 1599}, :bufs {:b1 [1603], :b2 [1600 1601]}} :line 1890}
{:clk 2430.8000 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2432.3 :j 1605 :dets {:run {:m1 nil, :m2 1602, :m3 1599}, :bufs {:b1 [1603 1604], :b2 [1600 1601]}} :line 1891}
{:clk 2430.9938 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2423.3629 :j 1599 :dets {:run {:m1 1605, :m2 1602, :m3 1599}, :bufs {:b1 [1603 1604], :b2 [1600 1601]}} :line 1892}
{:clk 2430.9938 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1600 :dets {:run {:m1 1605, :m2 1602, :m3 nil}, :bufs {:b1 [1603 1604], :b2 [1600 1601]}} :line 1893}
{:clk 2431.8000 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1602 :dets {:run {:m1 1605, :m2 1602, :m3 1600}, :bufs {:b1 [1603 1604], :b2 [1601]}} :line 1894}
{:clk 2431.8000 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1603 :dets {:run {:m1 1605, :m2 nil, :m3 1600}, :bufs {:b1 [1603 1604], :b2 [1601 1602]}} :line 1895}
{:clk 2431.9938 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2424.8629 :j 1600 :dets {:run {:m1 1605, :m2 1603, :m3 1600}, :bufs {:b1 [1604], :b2 [1601 1602]}} :line 1896}
{:clk 2431.9938 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1601 :dets {:run {:m1 1605, :m2 1603, :m3 nil}, :bufs {:b1 [1604], :b2 [1601 1602]}} :line 1897}
{:clk 2432.3000 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1605 :dets {:run {:m1 1605, :m2 1603, :m3 1601}, :bufs {:b1 [1604], :b2 [1602]}} :line 1898}
{:clk 2432.3000 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2433.3 :j 1606 :dets {:run {:m1 nil, :m2 1603, :m3 1601}, :bufs {:b1 [1604 1605], :b2 [1602]}} :line 1899}
{:clk 2432.8000 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1603 :dets {:run {:m1 1606, :m2 1603, :m3 1601}, :bufs {:b1 [1604 1605], :b2 [1602]}} :line 1900}
{:clk 2432.8000 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1604 :dets {:run {:m1 1606, :m2 nil, :m3 1601}, :bufs {:b1 [1604 1605], :b2 [1602 1603]}} :line 1901}
{:clk 2433.3000 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1606 :dets {:run {:m1 1606, :m2 1604, :m3 1601}, :bufs {:b1 [1605], :b2 [1602 1603]}} :line 1902}
{:clk 2433.3000 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2434.8 :j 1607 :dets {:run {:m1 nil, :m2 1604, :m3 1601}, :bufs {:b1 [1605 1606], :b2 [1602 1603]}} :line 1903}
{:clk 2433.4938 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2425.8629 :j 1601 :dets {:run {:m1 1607, :m2 1604, :m3 1601}, :bufs {:b1 [1605 1606], :b2 [1602 1603]}} :line 1904}
{:clk 2433.4938 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1602 :dets {:run {:m1 1607, :m2 1604, :m3 nil}, :bufs {:b1 [1605 1606], :b2 [1602 1603]}} :line 1905}
{:clk 2434.8000 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1607, :m2 1604, :m3 1602}, :bufs {:b1 [1605 1606], :b2 [1603]}} :line 1906}
{:clk 2437.6939 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2427.3629 :j 1602 :dets {:run {:m1 1607, :m2 1604, :m3 1602}, :bufs {:b1 [1605 1606], :b2 [1603]}} :line 1907}
{:clk 2437.6939 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1603 :dets {:run {:m1 1607, :m2 1604, :m3 nil}, :bufs {:b1 [1605 1606], :b2 [1603]}} :line 1908}
{:clk 2438.2739 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1604 :dets {:run {:m1 1607, :m2 1604, :m3 1603}, :bufs {:b1 [1605 1606], :b2 []}} :line 1909}
{:clk 2438.2739 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1605 :dets {:run {:m1 1607, :m2 nil, :m3 1603}, :bufs {:b1 [1605 1606], :b2 [1604]}} :line 1910}
{:clk 2438.2739 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1605, :m3 1603}, :bufs {:b1 [1606 1607], :b2 [1604]}} :line 1911}
{:clk 2438.2739 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1607 :dets {:run {:m1 1607, :m2 1605, :m3 1603}, :bufs {:b1 [1606], :b2 [1604]}} :line 1912}
{:clk 2438.2739 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2439.2739 :j 1608 :dets {:run {:m1 nil, :m2 1605, :m3 1603}, :bufs {:b1 [1606 1607], :b2 [1604]}} :line 1913}
{:clk 2438.6939 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2428.3629 :j 1603 :dets {:run {:m1 1608, :m2 1605, :m3 1603}, :bufs {:b1 [1606 1607], :b2 [1604]}} :line 1914}
{:clk 2438.6939 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1604 :dets {:run {:m1 1608, :m2 1605, :m3 nil}, :bufs {:b1 [1606 1607], :b2 [1604]}} :line 1915}
{:clk 2439.2739 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1608, :m2 1605, :m3 1604}, :bufs {:b1 [1606 1607], :b2 []}} :line 1916}
{:clk 2439.6939 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2429.3629 :j 1604 :dets {:run {:m1 1608, :m2 1605, :m3 1604}, :bufs {:b1 [1606 1607], :b2 []}} :line 1917}
{:clk 2439.6939 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1608, :m2 1605, :m3 nil}, :bufs {:b1 [1606 1607], :b2 []}} :line 1918}
{:clk 2439.7739 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1605 :dets {:run {:m1 1608, :m2 1606, :m3 nil}, :bufs {:b1 [1607], :b2 [1605]}} :line 1919}
{:clk 2439.7739 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1605 :dets {:run {:m1 1608, :m2 1605, :m3 nil}, :bufs {:b1 [1606 1607], :b2 []}} :line 1920}
{:clk 2439.7739 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1606 :dets {:run {:m1 1608, :m2 nil, :m3 nil}, :bufs {:b1 [1606 1607], :b2 [1605]}} :line 1921}
{:clk 2439.7739 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1608, :m2 1606, :m3 1605}, :bufs {:b1 [1607], :b2 []}} :line 1922}
{:clk 2439.7739 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1606, :m3 1605}, :bufs {:b1 [1607 1608], :b2 []}} :line 1923}
{:clk 2439.7739 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1608 :dets {:run {:m1 1608, :m2 1606, :m3 1605}, :bufs {:b1 [1607], :b2 []}} :line 1924}
{:clk 2439.7739 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2441.2739 :j 1609 :dets {:run {:m1 nil, :m2 1606, :m3 1605}, :bufs {:b1 [1607 1608], :b2 []}} :line 1925}
{:clk 2440.7739 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1606 :dets {:run {:m1 1609, :m2 1606, :m3 1605}, :bufs {:b1 [1607 1608], :b2 []}} :line 1926}
{:clk 2440.7739 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1607 :dets {:run {:m1 1609, :m2 nil, :m3 1605}, :bufs {:b1 [1607 1608], :b2 [1606]}} :line 1927}
{:clk 2441.2739 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1609 :dets {:run {:m1 1609, :m2 1607, :m3 1605}, :bufs {:b1 [1608], :b2 [1606]}} :line 1928}
{:clk 2441.2739 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2442.2739 :j 1610 :dets {:run {:m1 nil, :m2 1607, :m3 nil}, :bufs {:b1 [1608 1609], :b2 [1606]}} :line 1929}
{:clk 2441.2739 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2430.8 :j 1605 :dets {:run {:m1 nil, :m2 1607, :m3 1605}, :bufs {:b1 [1608 1609], :b2 [1606]}} :line 1930}
{:clk 2441.2739 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1606 :dets {:run {:m1 1610, :m2 1607, :m3 nil}, :bufs {:b1 [1608 1609], :b2 [1606]}} :line 1931}
{:clk 2442.2739 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1610 :dets {:run {:m1 1610, :m2 1608, :m3 1607}, :bufs {:b1 [1609], :b2 []}} :line 1932}
{:clk 2442.2739 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2443.2739 :j 1611 :dets {:run {:m1 nil, :m2 1608, :m3 1607}, :bufs {:b1 [1609 1610], :b2 []}} :line 1933}
{:clk 2442.2739 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1607 :dets {:run {:m1 1610, :m2 1607, :m3 1606}, :bufs {:b1 [1608 1609], :b2 []}} :line 1934}
{:clk 2442.2739 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1608 :dets {:run {:m1 1610, :m2 nil, :m3 nil}, :bufs {:b1 [1608 1609], :b2 [1607]}} :line 1935}
{:clk 2442.2739 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2432.3 :j 1606 :dets {:run {:m1 1610, :m2 nil, :m3 1606}, :bufs {:b1 [1608 1609], :b2 [1607]}} :line 1936}
{:clk 2442.2739 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1607 :dets {:run {:m1 1610, :m2 1608, :m3 nil}, :bufs {:b1 [1609], :b2 [1607]}} :line 1937}
{:clk 2443.2739 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1611 :dets {:run {:m1 1611, :m2 1609, :m3 1607}, :bufs {:b1 [1610], :b2 [1608]}} :line 1938}
{:clk 2443.2739 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2444.2739 :j 1612 :dets {:run {:m1 nil, :m2 1609, :m3 1607}, :bufs {:b1 [1610 1611], :b2 [1608]}} :line 1939}
{:clk 2443.2739 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1608 :dets {:run {:m1 1611, :m2 1608, :m3 1607}, :bufs {:b1 [1609 1610], :b2 []}} :line 1940}
{:clk 2443.2739 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1609 :dets {:run {:m1 1611, :m2 nil, :m3 1607}, :bufs {:b1 [1609 1610], :b2 [1608]}} :line 1941}
{:clk 2443.7739 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2433.3 :j 1607 :dets {:run {:m1 1612, :m2 1609, :m3 1607}, :bufs {:b1 [1610 1611], :b2 [1608]}} :line 1942}
{:clk 2443.7739 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1608 :dets {:run {:m1 1612, :m2 1609, :m3 nil}, :bufs {:b1 [1610 1611], :b2 [1608]}} :line 1943}
{:clk 2444.2739 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1612, :m2 1609, :m3 1608}, :bufs {:b1 [1610 1611], :b2 []}} :line 1944}
{:clk 2444.7739 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2438.2739 :j 1608 :dets {:run {:m1 1612, :m2 nil, :m3 1608}, :bufs {:b1 [1610 1611], :b2 [1609]}} :line 1945}
{:clk 2444.7739 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1609 :dets {:run {:m1 1612, :m2 1610, :m3 nil}, :bufs {:b1 [1611], :b2 [1609]}} :line 1946}
{:clk 2444.7739 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1609 :dets {:run {:m1 1612, :m2 1609, :m3 1608}, :bufs {:b1 [1610 1611], :b2 []}} :line 1947}
{:clk 2444.7739 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1610 :dets {:run {:m1 1612, :m2 nil, :m3 nil}, :bufs {:b1 [1610 1611], :b2 [1609]}} :line 1948}
{:clk 2444.7739 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1610, :m3 1609}, :bufs {:b1 [1611 1612], :b2 []}} :line 1949}
{:clk 2444.7739 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1612 :dets {:run {:m1 1612, :m2 1610, :m3 1609}, :bufs {:b1 [1611], :b2 []}} :line 1950}
{:clk 2444.7739 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2445.7739 :j 1613 :dets {:run {:m1 nil, :m2 1610, :m3 1609}, :bufs {:b1 [1611 1612], :b2 []}} :line 1951}
{:clk 2445.7739 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1613 :dets {:run {:m1 1613, :m2 1611, :m3 1609}, :bufs {:b1 [1612], :b2 [1610]}} :line 1952}
{:clk 2445.7739 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2446.7739 :j 1614 :dets {:run {:m1 nil, :m2 1611, :m3 1609}, :bufs {:b1 [1612 1613], :b2 [1610]}} :line 1953}
{:clk 2445.7739 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1610 :dets {:run {:m1 1613, :m2 1610, :m3 1609}, :bufs {:b1 [1611 1612], :b2 []}} :line 1954}
{:clk 2445.7739 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1611 :dets {:run {:m1 1613, :m2 nil, :m3 1609}, :bufs {:b1 [1611 1612], :b2 [1610]}} :line 1955}
{:clk 2446.2739 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2439.7739 :j 1609 :dets {:run {:m1 1614, :m2 1611, :m3 1609}, :bufs {:b1 [1612 1613], :b2 [1610]}} :line 1956}
{:clk 2446.2739 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1610 :dets {:run {:m1 1614, :m2 1611, :m3 nil}, :bufs {:b1 [1612 1613], :b2 [1610]}} :line 1957}
{:clk 2446.7739 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1614 :dets {:run {:m1 1614, :m2 1612, :m3 1610}, :bufs {:b1 [1613], :b2 [1611]}} :line 1958}
{:clk 2446.7739 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2447.7739 :j 1615 :dets {:run {:m1 nil, :m2 1612, :m3 1610}, :bufs {:b1 [1613 1614], :b2 [1611]}} :line 1959}
{:clk 2446.7739 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1611 :dets {:run {:m1 1614, :m2 1611, :m3 1610}, :bufs {:b1 [1612 1613], :b2 []}} :line 1960}
{:clk 2446.7739 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1612 :dets {:run {:m1 1614, :m2 nil, :m3 1610}, :bufs {:b1 [1612 1613], :b2 [1611]}} :line 1961}
{:clk 2447.2739 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2441.2739 :j 1610 :dets {:run {:m1 1615, :m2 1612, :m3 1610}, :bufs {:b1 [1613 1614], :b2 [1611]}} :line 1962}
{:clk 2447.2739 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1611 :dets {:run {:m1 1615, :m2 1612, :m3 nil}, :bufs {:b1 [1613 1614], :b2 [1611]}} :line 1963}
{:clk 2447.7739 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1615, :m2 1612, :m3 1611}, :bufs {:b1 [1613 1614], :b2 []}} :line 1964}
{:clk 2448.2739 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2442.2739 :j 1611 :dets {:run {:m1 1615, :m2 1612, :m3 1611}, :bufs {:b1 [1613 1614], :b2 []}} :line 1965}
{:clk 2448.2739 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1615, :m2 1612, :m3 nil}, :bufs {:b1 [1613 1614], :b2 []}} :line 1966}
{:clk 2449.4705 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1612 :dets {:run {:m1 1615, :m2 1613, :m3 nil}, :bufs {:b1 [1614], :b2 [1612]}} :line 1967}
{:clk 2449.4705 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1612 :dets {:run {:m1 1615, :m2 1612, :m3 nil}, :bufs {:b1 [1613 1614], :b2 []}} :line 1968}
{:clk 2449.4705 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1613 :dets {:run {:m1 1615, :m2 nil, :m3 nil}, :bufs {:b1 [1613 1614], :b2 [1612]}} :line 1969}
{:clk 2449.4705 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1615, :m2 1613, :m3 1612}, :bufs {:b1 [1614], :b2 []}} :line 1970}
{:clk 2449.4705 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1613, :m3 1612}, :bufs {:b1 [1614 1615], :b2 []}} :line 1971}
{:clk 2449.4705 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1615 :dets {:run {:m1 1615, :m2 1613, :m3 1612}, :bufs {:b1 [1614], :b2 []}} :line 1972}
{:clk 2449.4705 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2454.4463 :j 1616 :dets {:run {:m1 nil, :m2 1613, :m3 1612}, :bufs {:b1 [1614 1615], :b2 []}} :line 1973}
{:clk 2450.4705 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1613 :dets {:run {:m1 1616, :m2 1613, :m3 1612}, :bufs {:b1 [1614 1615], :b2 []}} :line 1974}
{:clk 2450.4705 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1614 :dets {:run {:m1 1616, :m2 nil, :m3 nil}, :bufs {:b1 [1614 1615], :b2 [1613]}} :line 1975}
{:clk 2450.4705 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2443.2739 :j 1612 :dets {:run {:m1 1616, :m2 nil, :m3 1612}, :bufs {:b1 [1614 1615], :b2 [1613]}} :line 1976}
{:clk 2450.4705 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1613 :dets {:run {:m1 1616, :m2 1614, :m3 nil}, :bufs {:b1 [1615], :b2 [1613]}} :line 1977}
{:clk 2451.4705 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1614 :dets {:run {:m1 1616, :m2 1614, :m3 1613}, :bufs {:b1 [1615], :b2 []}} :line 1978}
{:clk 2451.4705 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1615 :dets {:run {:m1 1616, :m2 nil, :m3 nil}, :bufs {:b1 [1615], :b2 [1614]}} :line 1979}
{:clk 2451.4705 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2444.7739 :j 1613 :dets {:run {:m1 1616, :m2 nil, :m3 1613}, :bufs {:b1 [1615], :b2 [1614]}} :line 1980}
{:clk 2451.4705 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1614 :dets {:run {:m1 1616, :m2 1615, :m3 nil}, :bufs {:b1 [], :b2 [1614]}} :line 1981}
{:clk 2452.4705 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1615 :dets {:run {:m1 1616, :m2 1615, :m3 1614}, :bufs {:b1 [], :b2 []}} :line 1982}
{:clk 2452.4705 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2445.7739 :j 1614 :dets {:run {:m1 1616, :m2 nil, :m3 1614}, :bufs {:b1 [], :b2 [1615]}} :line 1983}
{:clk 2452.4705 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1615 :dets {:run {:m1 1616, :m2 nil, :m3 nil}, :bufs {:b1 [], :b2 [1615]}} :line 1984}
{:clk 2452.4705 :act :m2-starved :m :m2 :mjpact :st :dets {:run {:m1 1616, :m2 nil, :m3 1615}, :bufs {:b1 [], :b2 []}} :line 1985}
{:clk 2453.4705 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2446.7739 :j 1615 :dets {:run {:m1 1616, :m2 nil, :m3 1615}, :bufs {:b1 [], :b2 []}} :line 1986}
{:clk 2453.4705 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1616, :m2 nil, :m3 nil}, :bufs {:b1 [], :b2 []}} :line 1987}
{:clk 2454.4463 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1616 :dets {:run {:m1 1616, :m2 nil, :m3 nil}, :bufs {:b1 [], :b2 []}} :line 1988}
{:clk 2454.4463 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2455.9463 :j 1617 :dets {:run {:m1 nil, :m2 nil, :m3 nil}, :bufs {:b1 [1616], :b2 []}} :line 1989}
{:clk 2454.4463 :act :m2-unstarved :m :m2 :mjpact :us :dets {:run {:m1 1617, :m2 1616, :m3 nil}, :bufs {:b1 [], :b2 []}} :line 1990}
{:clk 2454.4463 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1616 :dets {:run {:m1 1617, :m2 nil, :m3 nil}, :bufs {:b1 [1616], :b2 []}} :line 1991}
{:clk 2455.9463 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1617 :dets {:run {:m1 1617, :m2 1616, :m3 nil}, :bufs {:b1 [], :b2 []}} :line 1992}
{:clk 2455.9463 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2457.4463 :j 1618 :dets {:run {:m1 nil, :m2 nil, :m3 nil}, :bufs {:b1 [1617], :b2 [1616]}} :line 1993}
{:clk 2455.9463 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1616 :dets {:run {:m1 nil, :m2 1616, :m3 nil}, :bufs {:b1 [1617], :b2 []}} :line 1994}
{:clk 2455.9463 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1617 :dets {:run {:m1 1618, :m2 nil, :m3 nil}, :bufs {:b1 [1617], :b2 [1616]}} :line 1995}
{:clk 2455.9463 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1618, :m2 1617, :m3 1616}, :bufs {:b1 [], :b2 []}} :line 1996}
{:clk 2455.9463 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1616 :dets {:run {:m1 1618, :m2 1617, :m3 nil}, :bufs {:b1 [], :b2 [1616]}} :line 1997}
{:clk 2457.4463 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1618 :dets {:run {:m1 1618, :m2 1617, :m3 1616}, :bufs {:b1 [], :b2 []}} :line 1998}
{:clk 2457.4463 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2458.4463 :j 1619 :dets {:run {:m1 nil, :m2 nil, :m3 nil}, :bufs {:b1 [1618], :b2 [1617]}} :line 1999}
{:clk 2457.4463 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1617 :dets {:run {:m1 nil, :m2 1617, :m3 1616}, :bufs {:b1 [1618], :b2 []}} :line 2000}
{:clk 2457.4463 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1618 :dets {:run {:m1 1619, :m2 nil, :m3 nil}, :bufs {:b1 [1618], :b2 [1617]}} :line 2001}
{:clk 2457.4463 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2449.4705 :j 1616 :dets {:run {:m1 nil, :m2 nil, :m3 1616}, :bufs {:b1 [1618], :b2 [1617]}} :line 2002}
{:clk 2457.4463 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1617 :dets {:run {:m1 1619, :m2 1618, :m3 nil}, :bufs {:b1 [], :b2 [1617]}} :line 2003}
{:clk 2458.4463 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1619 :dets {:run {:m1 1619, :m2 1618, :m3 1617}, :bufs {:b1 [], :b2 []}} :line 2004}
{:clk 2458.4463 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2459.9463 :j 1620 :dets {:run {:m1 nil, :m2 1618, :m3 1617}, :bufs {:b1 [1619], :b2 []}} :line 2005}
{:clk 2458.9463 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1618 :dets {:run {:m1 1620, :m2 1618, :m3 1617}, :bufs {:b1 [1619], :b2 []}} :line 2006}
{:clk 2458.9463 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1619 :dets {:run {:m1 1620, :m2 nil, :m3 nil}, :bufs {:b1 [1619], :b2 [1618]}} :line 2007}
{:clk 2458.9463 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2454.4463 :j 1617 :dets {:run {:m1 1620, :m2 nil, :m3 1617}, :bufs {:b1 [1619], :b2 [1618]}} :line 2008}
{:clk 2458.9463 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1618 :dets {:run {:m1 1620, :m2 1619, :m3 nil}, :bufs {:b1 [], :b2 [1618]}} :line 2009}
{:clk 2459.9463 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1620 :dets {:run {:m1 1620, :m2 1619, :m3 1618}, :bufs {:b1 [], :b2 []}} :line 2010}
{:clk 2459.9463 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2461.4463 :j 1621 :dets {:run {:m1 nil, :m2 nil, :m3 1618}, :bufs {:b1 [1620], :b2 [1619]}} :line 2011}
{:clk 2459.9463 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1619 :dets {:run {:m1 nil, :m2 1619, :m3 1618}, :bufs {:b1 [1620], :b2 []}} :line 2012}
{:clk 2459.9463 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1620 :dets {:run {:m1 1621, :m2 nil, :m3 1618}, :bufs {:b1 [1620], :b2 [1619]}} :line 2013}
{:clk 2461.4463 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1621 :dets {:run {:m1 1621, :m2 1620, :m3 1618}, :bufs {:b1 [], :b2 [1619]}} :line 2014}
{:clk 2461.4463 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2462.9463 :j 1622 :dets {:run {:m1 nil, :m2 1620, :m3 1618}, :bufs {:b1 [1621], :b2 [1619]}} :line 2015}
{:clk 2461.9027 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2455.9463 :j 1618 :dets {:run {:m1 1622, :m2 1620, :m3 1618}, :bufs {:b1 [1621], :b2 [1619]}} :line 2016}
{:clk 2461.9027 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1619 :dets {:run {:m1 1622, :m2 1620, :m3 nil}, :bufs {:b1 [1621], :b2 [1619]}} :line 2017}
{:clk 2462.9027 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2457.4463 :j 1619 :dets {:run {:m1 1622, :m2 1620, :m3 1619}, :bufs {:b1 [1621], :b2 []}} :line 2018}
{:clk 2462.9027 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1622, :m2 1620, :m3 nil}, :bufs {:b1 [1621], :b2 []}} :line 2019}
{:clk 2462.9463 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1622 :dets {:run {:m1 1622, :m2 1620, :m3 nil}, :bufs {:b1 [1621], :b2 []}} :line 2020}
{:clk 2462.9463 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2463.9463 :j 1623 :dets {:run {:m1 nil, :m2 1620, :m3 nil}, :bufs {:b1 [1621 1622], :b2 []}} :line 2021}
{:clk 2463.8040 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1620 :dets {:run {:m1 1623, :m2 1620, :m3 nil}, :bufs {:b1 [1621 1622], :b2 []}} :line 2022}
{:clk 2463.8040 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1621 :dets {:run {:m1 1623, :m2 nil, :m3 nil}, :bufs {:b1 [1621 1622], :b2 [1620]}} :line 2023}
{:clk 2463.8040 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1623, :m2 1621, :m3 1620}, :bufs {:b1 [1622], :b2 []}} :line 2024}
{:clk 2463.8040 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1620 :dets {:run {:m1 1623, :m2 1621, :m3 nil}, :bufs {:b1 [1622], :b2 [1620]}} :line 2025}
{:clk 2463.9463 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1623 :dets {:run {:m1 1623, :m2 1621, :m3 1620}, :bufs {:b1 [1622], :b2 []}} :line 2026}
{:clk 2463.9463 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2464.9463 :j 1624 :dets {:run {:m1 nil, :m2 1621, :m3 1620}, :bufs {:b1 [1622 1623], :b2 []}} :line 2027}
{:clk 2464.9463 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1624, :m2 1621, :m3 1620}, :bufs {:b1 [1622 1623], :b2 []}} :line 2028}
{:clk 2465.3040 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2458.4463 :j 1620 :dets {:run {:m1 1624, :m2 nil, :m3 1620}, :bufs {:b1 [1622 1623], :b2 [1621]}} :line 2029}
{:clk 2465.3040 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1621 :dets {:run {:m1 1624, :m2 1622, :m3 nil}, :bufs {:b1 [1623], :b2 [1621]}} :line 2030}
{:clk 2465.3040 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1621 :dets {:run {:m1 1624, :m2 1621, :m3 1620}, :bufs {:b1 [1622 1623], :b2 []}} :line 2031}
{:clk 2465.3040 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1622 :dets {:run {:m1 1624, :m2 nil, :m3 nil}, :bufs {:b1 [1622 1623], :b2 [1621]}} :line 2032}
{:clk 2465.3040 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1622, :m3 1621}, :bufs {:b1 [1623 1624], :b2 []}} :line 2033}
{:clk 2465.3040 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1624 :dets {:run {:m1 1624, :m2 1622, :m3 1621}, :bufs {:b1 [1623], :b2 []}} :line 2034}
{:clk 2465.3040 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2466.804 :j 1625 :dets {:run {:m1 nil, :m2 1622, :m3 1621}, :bufs {:b1 [1623 1624], :b2 []}} :line 2035}
{:clk 2466.8040 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1625 :dets {:run {:m1 1625, :m2 1623, :m3 1622}, :bufs {:b1 [1624], :b2 []}} :line 2036}
{:clk 2466.8040 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2467.804 :j 1626 :dets {:run {:m1 nil, :m2 1623, :m3 1622}, :bufs {:b1 [1624 1625], :b2 []}} :line 2037}
{:clk 2466.8040 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1622 :dets {:run {:m1 1625, :m2 1622, :m3 1621}, :bufs {:b1 [1623 1624], :b2 []}} :line 2038}
{:clk 2466.8040 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1623 :dets {:run {:m1 1625, :m2 nil, :m3 nil}, :bufs {:b1 [1623 1624], :b2 [1622]}} :line 2039}
{:clk 2466.8040 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2459.9463 :j 1621 :dets {:run {:m1 1625, :m2 nil, :m3 1621}, :bufs {:b1 [1623 1624], :b2 [1622]}} :line 2040}
{:clk 2466.8040 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1622 :dets {:run {:m1 1625, :m2 1623, :m3 nil}, :bufs {:b1 [1624], :b2 [1622]}} :line 2041}
{:clk 2467.8040 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1626 :dets {:run {:m1 1626, :m2 1624, :m3 1622}, :bufs {:b1 [1625], :b2 [1623]}} :line 2042}
{:clk 2467.8040 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2470.0019 :j 1627 :dets {:run {:m1 nil, :m2 1624, :m3 1622}, :bufs {:b1 [1625 1626], :b2 [1623]}} :line 2043}
{:clk 2467.8040 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1623 :dets {:run {:m1 1626, :m2 1623, :m3 1622}, :bufs {:b1 [1624 1625], :b2 []}} :line 2044}
{:clk 2467.8040 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1624 :dets {:run {:m1 1626, :m2 nil, :m3 1622}, :bufs {:b1 [1624 1625], :b2 [1623]}} :line 2045}
{:clk 2468.3040 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2461.4463 :j 1622 :dets {:run {:m1 1627, :m2 1624, :m3 1622}, :bufs {:b1 [1625 1626], :b2 [1623]}} :line 2046}
{:clk 2468.3040 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1623 :dets {:run {:m1 1627, :m2 1624, :m3 nil}, :bufs {:b1 [1625 1626], :b2 [1623]}} :line 2047}
{:clk 2469.3040 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2462.9463 :j 1623 :dets {:run {:m1 1627, :m2 1624, :m3 1623}, :bufs {:b1 [1625 1626], :b2 []}} :line 2048}
{:clk 2469.3040 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1627, :m2 1624, :m3 nil}, :bufs {:b1 [1625 1626], :b2 []}} :line 2049}
{:clk 2470.0019 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1627, :m2 1624, :m3 nil}, :bufs {:b1 [1625 1626], :b2 []}} :line 2050}
{:clk 2473.7279 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1624 :dets {:run {:m1 1627, :m2 1625, :m3 nil}, :bufs {:b1 [1626], :b2 [1624]}} :line 2051}
{:clk 2473.7279 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1624 :dets {:run {:m1 1627, :m2 1624, :m3 nil}, :bufs {:b1 [1625 1626], :b2 []}} :line 2052}
{:clk 2473.7279 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1625 :dets {:run {:m1 1627, :m2 nil, :m3 nil}, :bufs {:b1 [1625 1626], :b2 [1624]}} :line 2053}
{:clk 2473.7279 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1627, :m2 1625, :m3 1624}, :bufs {:b1 [1626], :b2 []}} :line 2054}
{:clk 2473.7279 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1625, :m3 1624}, :bufs {:b1 [1626 1627], :b2 []}} :line 2055}
{:clk 2473.7279 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1627 :dets {:run {:m1 1627, :m2 1625, :m3 1624}, :bufs {:b1 [1626], :b2 []}} :line 2056}
{:clk 2473.7279 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2474.7279 :j 1628 :dets {:run {:m1 nil, :m2 1625, :m3 1624}, :bufs {:b1 [1626 1627], :b2 []}} :line 2057}
{:clk 2474.7279 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1628, :m2 1625, :m3 nil}, :bufs {:b1 [1626 1627], :b2 []}} :line 2058}
{:clk 2474.7279 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1628, :m2 1625, :m3 nil}, :bufs {:b1 [1626 1627], :b2 []}} :line 2059}
{:clk 2474.7279 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2463.9463 :j 1624 :dets {:run {:m1 1628, :m2 1625, :m3 1624}, :bufs {:b1 [1626 1627], :b2 []}} :line 2060}
{:clk 2475.2279 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1625 :dets {:run {:m1 1628, :m2 1626, :m3 nil}, :bufs {:b1 [1627], :b2 [1625]}} :line 2061}
{:clk 2475.2279 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1625 :dets {:run {:m1 1628, :m2 1625, :m3 nil}, :bufs {:b1 [1626 1627], :b2 []}} :line 2062}
{:clk 2475.2279 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1626 :dets {:run {:m1 1628, :m2 nil, :m3 nil}, :bufs {:b1 [1626 1627], :b2 [1625]}} :line 2063}
{:clk 2475.2279 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1628, :m2 1626, :m3 1625}, :bufs {:b1 [1627], :b2 []}} :line 2064}
{:clk 2475.2279 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1626, :m3 1625}, :bufs {:b1 [1627 1628], :b2 []}} :line 2065}
{:clk 2475.2279 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1628 :dets {:run {:m1 1628, :m2 1626, :m3 1625}, :bufs {:b1 [1627], :b2 []}} :line 2066}
{:clk 2475.2279 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2476.7279 :j 1629 :dets {:run {:m1 nil, :m2 1626, :m3 1625}, :bufs {:b1 [1627 1628], :b2 []}} :line 2067}
{:clk 2476.2279 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1626 :dets {:run {:m1 1629, :m2 1626, :m3 1625}, :bufs {:b1 [1627 1628], :b2 []}} :line 2068}
{:clk 2476.2279 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1627 :dets {:run {:m1 1629, :m2 nil, :m3 1625}, :bufs {:b1 [1627 1628], :b2 [1626]}} :line 2069}
{:clk 2476.7279 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1629 :dets {:run {:m1 1629, :m2 1627, :m3 1625}, :bufs {:b1 [1628], :b2 [1626]}} :line 2070}
{:clk 2476.7279 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2478.2279 :j 1630 :dets {:run {:m1 nil, :m2 1627, :m3 nil}, :bufs {:b1 [1628 1629], :b2 [1626]}} :line 2071}
{:clk 2476.7279 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2465.304 :j 1625 :dets {:run {:m1 nil, :m2 1627, :m3 1625}, :bufs {:b1 [1628 1629], :b2 [1626]}} :line 2072}
{:clk 2476.7279 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1626 :dets {:run {:m1 1630, :m2 1627, :m3 nil}, :bufs {:b1 [1628 1629], :b2 [1626]}} :line 2073}
{:clk 2477.7279 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1627 :dets {:run {:m1 1630, :m2 1627, :m3 1626}, :bufs {:b1 [1628 1629], :b2 []}} :line 2074}
{:clk 2477.7279 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1628 :dets {:run {:m1 1630, :m2 nil, :m3 nil}, :bufs {:b1 [1628 1629], :b2 [1627]}} :line 2075}
{:clk 2477.7279 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2466.804 :j 1626 :dets {:run {:m1 1630, :m2 nil, :m3 1626}, :bufs {:b1 [1628 1629], :b2 [1627]}} :line 2076}
{:clk 2477.7279 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1627 :dets {:run {:m1 1630, :m2 1628, :m3 nil}, :bufs {:b1 [1629], :b2 [1627]}} :line 2077}
{:clk 2478.2279 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1630 :dets {:run {:m1 1630, :m2 1628, :m3 1627}, :bufs {:b1 [1629], :b2 []}} :line 2078}
{:clk 2478.2279 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2479.7279 :j 1631 :dets {:run {:m1 nil, :m2 1628, :m3 1627}, :bufs {:b1 [1629 1630], :b2 []}} :line 2079}
{:clk 2478.7279 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1628 :dets {:run {:m1 1631, :m2 1628, :m3 1627}, :bufs {:b1 [1629 1630], :b2 []}} :line 2080}
{:clk 2478.7279 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1629 :dets {:run {:m1 1631, :m2 nil, :m3 1627}, :bufs {:b1 [1629 1630], :b2 [1628]}} :line 2081}
{:clk 2479.2279 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2467.804 :j 1627 :dets {:run {:m1 1631, :m2 1629, :m3 1627}, :bufs {:b1 [1630], :b2 [1628]}} :line 2082}
{:clk 2479.2279 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1628 :dets {:run {:m1 1631, :m2 1629, :m3 nil}, :bufs {:b1 [1630], :b2 [1628]}} :line 2083}
{:clk 2479.7279 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1631 :dets {:run {:m1 1631, :m2 1629, :m3 1628}, :bufs {:b1 [1630], :b2 []}} :line 2084}
{:clk 2479.7279 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2480.7279 :j 1632 :dets {:run {:m1 nil, :m2 1629, :m3 1628}, :bufs {:b1 [1630 1631], :b2 []}} :line 2085}
{:clk 2480.2279 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1629 :dets {:run {:m1 1632, :m2 1629, :m3 1628}, :bufs {:b1 [1630 1631], :b2 []}} :line 2086}
{:clk 2480.2279 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1630 :dets {:run {:m1 1632, :m2 nil, :m3 nil}, :bufs {:b1 [1630 1631], :b2 [1629]}} :line 2087}
{:clk 2480.2279 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2473.7279 :j 1628 :dets {:run {:m1 1632, :m2 nil, :m3 1628}, :bufs {:b1 [1630 1631], :b2 [1629]}} :line 2088}
{:clk 2480.2279 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1629 :dets {:run {:m1 1632, :m2 1630, :m3 nil}, :bufs {:b1 [1631], :b2 [1629]}} :line 2089}
{:clk 2480.7279 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1632 :dets {:run {:m1 1632, :m2 1630, :m3 1629}, :bufs {:b1 [1631], :b2 []}} :line 2090}
{:clk 2480.7279 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2481.7279 :j 1633 :dets {:run {:m1 nil, :m2 1630, :m3 1629}, :bufs {:b1 [1631 1632], :b2 []}} :line 2091}
{:clk 2481.7279 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1633 :dets {:run {:m1 1633, :m2 1631, :m3 1630}, :bufs {:b1 [1632], :b2 []}} :line 2092}
{:clk 2481.7279 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2482.7279 :j 1634 :dets {:run {:m1 nil, :m2 1631, :m3 1630}, :bufs {:b1 [1632 1633], :b2 []}} :line 2093}
{:clk 2481.7279 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1630 :dets {:run {:m1 1633, :m2 1630, :m3 1629}, :bufs {:b1 [1631 1632], :b2 []}} :line 2094}
{:clk 2481.7279 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1631 :dets {:run {:m1 1633, :m2 nil, :m3 nil}, :bufs {:b1 [1631 1632], :b2 [1630]}} :line 2095}
{:clk 2481.7279 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2475.2279 :j 1629 :dets {:run {:m1 1633, :m2 nil, :m3 1629}, :bufs {:b1 [1631 1632], :b2 [1630]}} :line 2096}
{:clk 2481.7279 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1630 :dets {:run {:m1 1633, :m2 1631, :m3 nil}, :bufs {:b1 [1632], :b2 [1630]}} :line 2097}
{:clk 2482.7279 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1634, :m2 1631, :m3 1630}, :bufs {:b1 [1632 1633], :b2 []}} :line 2098}
{:clk 2483.2279 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2476.7279 :j 1630 :dets {:run {:m1 1634, :m2 nil, :m3 1630}, :bufs {:b1 [1632 1633], :b2 [1631]}} :line 2099}
{:clk 2483.2279 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1631 :dets {:run {:m1 1634, :m2 1632, :m3 nil}, :bufs {:b1 [1633], :b2 [1631]}} :line 2100}
{:clk 2483.2279 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1631 :dets {:run {:m1 1634, :m2 1631, :m3 1630}, :bufs {:b1 [1632 1633], :b2 []}} :line 2101}
{:clk 2483.2279 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1632 :dets {:run {:m1 1634, :m2 nil, :m3 nil}, :bufs {:b1 [1632 1633], :b2 [1631]}} :line 2102}
{:clk 2483.2279 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1632, :m3 1631}, :bufs {:b1 [1633 1634], :b2 []}} :line 2103}
{:clk 2483.2279 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1634 :dets {:run {:m1 1634, :m2 1632, :m3 1631}, :bufs {:b1 [1633], :b2 []}} :line 2104}
{:clk 2483.2279 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2484.2279 :j 1635 :dets {:run {:m1 nil, :m2 1632, :m3 1631}, :bufs {:b1 [1633 1634], :b2 []}} :line 2105}
{:clk 2484.2279 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1635 :dets {:run {:m1 1635, :m2 1633, :m3 1631}, :bufs {:b1 [1634], :b2 [1632]}} :line 2106}
{:clk 2484.2279 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2486.4785 :j 1636 :dets {:run {:m1 nil, :m2 1633, :m3 1631}, :bufs {:b1 [1634 1635], :b2 [1632]}} :line 2107}
{:clk 2484.2279 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1632 :dets {:run {:m1 1635, :m2 1632, :m3 1631}, :bufs {:b1 [1633 1634], :b2 []}} :line 2108}
{:clk 2484.2279 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1633 :dets {:run {:m1 1635, :m2 nil, :m3 1631}, :bufs {:b1 [1633 1634], :b2 [1632]}} :line 2109}
{:clk 2484.7279 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2478.2279 :j 1631 :dets {:run {:m1 1636, :m2 1633, :m3 1631}, :bufs {:b1 [1634 1635], :b2 [1632]}} :line 2110}
{:clk 2484.7279 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1632 :dets {:run {:m1 1636, :m2 1633, :m3 nil}, :bufs {:b1 [1634 1635], :b2 [1632]}} :line 2111}
{:clk 2485.2279 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1633 :dets {:run {:m1 1636, :m2 1633, :m3 1632}, :bufs {:b1 [1634 1635], :b2 []}} :line 2112}
{:clk 2485.2279 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1634 :dets {:run {:m1 1636, :m2 nil, :m3 1632}, :bufs {:b1 [1634 1635], :b2 [1633]}} :line 2113}
{:clk 2485.7279 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2479.7279 :j 1632 :dets {:run {:m1 1636, :m2 1634, :m3 1632}, :bufs {:b1 [1635], :b2 [1633]}} :line 2114}
{:clk 2485.7279 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1633 :dets {:run {:m1 1636, :m2 1634, :m3 nil}, :bufs {:b1 [1635], :b2 [1633]}} :line 2115}
{:clk 2486.2279 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1634 :dets {:run {:m1 1636, :m2 1634, :m3 1633}, :bufs {:b1 [1635], :b2 []}} :line 2116}
{:clk 2486.2279 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1635 :dets {:run {:m1 1636, :m2 nil, :m3 1633}, :bufs {:b1 [1635], :b2 [1634]}} :line 2117}
{:clk 2486.4785 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1636 :dets {:run {:m1 1636, :m2 1635, :m3 1633}, :bufs {:b1 [], :b2 [1634]}} :line 2118}
{:clk 2486.4785 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2487.9785 :j 1637 :dets {:run {:m1 nil, :m2 1635, :m3 1633}, :bufs {:b1 [1636], :b2 [1634]}} :line 2119}
{:clk 2486.7279 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2480.7279 :j 1633 :dets {:run {:m1 1637, :m2 1635, :m3 1633}, :bufs {:b1 [1636], :b2 [1634]}} :line 2120}
{:clk 2486.7279 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1634 :dets {:run {:m1 1637, :m2 1635, :m3 nil}, :bufs {:b1 [1636], :b2 [1634]}} :line 2121}
{:clk 2487.2279 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1635 :dets {:run {:m1 1637, :m2 1635, :m3 1634}, :bufs {:b1 [1636], :b2 []}} :line 2122}
{:clk 2487.2279 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1636 :dets {:run {:m1 1637, :m2 nil, :m3 1634}, :bufs {:b1 [1636], :b2 [1635]}} :line 2123}
{:clk 2487.7279 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2481.7279 :j 1634 :dets {:run {:m1 1637, :m2 1636, :m3 1634}, :bufs {:b1 [], :b2 [1635]}} :line 2124}
{:clk 2487.7279 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1635 :dets {:run {:m1 1637, :m2 1636, :m3 nil}, :bufs {:b1 [], :b2 [1635]}} :line 2125}
{:clk 2487.9785 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1637 :dets {:run {:m1 1637, :m2 1636, :m3 1635}, :bufs {:b1 [], :b2 []}} :line 2126}
{:clk 2487.9785 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2489.1914 :j 1638 :dets {:run {:m1 nil, :m2 1636, :m3 1635}, :bufs {:b1 [1637], :b2 []}} :line 2127}
{:clk 2489.1914 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1638 :dets {:run {:m1 1638, :m2 1636, :m3 1635}, :bufs {:b1 [1637], :b2 []}} :line 2128}
{:clk 2489.1914 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2490.1914 :j 1639 :dets {:run {:m1 nil, :m2 1636, :m3 1635}, :bufs {:b1 [1637 1638], :b2 []}} :line 2129}
{:clk 2489.2149 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2483.2279 :j 1635 :dets {:run {:m1 1639, :m2 1636, :m3 1635}, :bufs {:b1 [1637 1638], :b2 []}} :line 2130}
{:clk 2489.2149 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1639, :m2 1636, :m3 nil}, :bufs {:b1 [1637 1638], :b2 []}} :line 2131}
{:clk 2489.3839 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1636 :dets {:run {:m1 1639, :m2 1636, :m3 nil}, :bufs {:b1 [1637 1638], :b2 []}} :line 2132}
{:clk 2489.3839 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1637 :dets {:run {:m1 1639, :m2 nil, :m3 nil}, :bufs {:b1 [1637 1638], :b2 [1636]}} :line 2133}
{:clk 2489.3839 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1639, :m2 1637, :m3 1636}, :bufs {:b1 [1638], :b2 []}} :line 2134}
{:clk 2489.3839 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1636 :dets {:run {:m1 1639, :m2 1637, :m3 nil}, :bufs {:b1 [1638], :b2 [1636]}} :line 2135}
{:clk 2490.1914 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1639 :dets {:run {:m1 1639, :m2 1637, :m3 1636}, :bufs {:b1 [1638], :b2 []}} :line 2136}
{:clk 2490.1914 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2491.1914 :j 1640 :dets {:run {:m1 nil, :m2 1637, :m3 1636}, :bufs {:b1 [1638 1639], :b2 []}} :line 2137}
{:clk 2490.3839 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2484.2279 :j 1636 :dets {:run {:m1 1640, :m2 1637, :m3 1636}, :bufs {:b1 [1638 1639], :b2 []}} :line 2138}
{:clk 2490.3839 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1640, :m2 1637, :m3 nil}, :bufs {:b1 [1638 1639], :b2 []}} :line 2139}
{:clk 2490.8839 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1637 :dets {:run {:m1 1640, :m2 1637, :m3 nil}, :bufs {:b1 [1638 1639], :b2 []}} :line 2140}
{:clk 2490.8839 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1638 :dets {:run {:m1 1640, :m2 nil, :m3 nil}, :bufs {:b1 [1638 1639], :b2 [1637]}} :line 2141}
{:clk 2490.8839 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1640, :m2 1638, :m3 1637}, :bufs {:b1 [1639], :b2 []}} :line 2142}
{:clk 2490.8839 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1637 :dets {:run {:m1 1640, :m2 1638, :m3 nil}, :bufs {:b1 [1639], :b2 [1637]}} :line 2143}
{:clk 2491.1914 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1640 :dets {:run {:m1 1640, :m2 1638, :m3 1637}, :bufs {:b1 [1639], :b2 []}} :line 2144}
{:clk 2491.1914 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2492.6914 :j 1641 :dets {:run {:m1 nil, :m2 1638, :m3 1637}, :bufs {:b1 [1639 1640], :b2 []}} :line 2145}
{:clk 2491.8839 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1638 :dets {:run {:m1 1641, :m2 1638, :m3 1637}, :bufs {:b1 [1639 1640], :b2 []}} :line 2146}
{:clk 2491.8839 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1639 :dets {:run {:m1 1641, :m2 nil, :m3 1637}, :bufs {:b1 [1639 1640], :b2 [1638]}} :line 2147}
{:clk 2492.3839 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2486.4785 :j 1637 :dets {:run {:m1 1641, :m2 1639, :m3 1637}, :bufs {:b1 [1640], :b2 [1638]}} :line 2148}
{:clk 2492.3839 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1638 :dets {:run {:m1 1641, :m2 1639, :m3 nil}, :bufs {:b1 [1640], :b2 [1638]}} :line 2149}
{:clk 2492.6914 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1641 :dets {:run {:m1 1641, :m2 1639, :m3 1638}, :bufs {:b1 [1640], :b2 []}} :line 2150}
{:clk 2492.6914 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2494.1914 :j 1642 :dets {:run {:m1 nil, :m2 1639, :m3 1638}, :bufs {:b1 [1640 1641], :b2 []}} :line 2151}
{:clk 2492.8839 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1639 :dets {:run {:m1 1642, :m2 1639, :m3 1638}, :bufs {:b1 [1640 1641], :b2 []}} :line 2152}
{:clk 2492.8839 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1640 :dets {:run {:m1 1642, :m2 nil, :m3 1638}, :bufs {:b1 [1640 1641], :b2 [1639]}} :line 2153}
{:clk 2493.3839 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2487.9785 :j 1638 :dets {:run {:m1 1642, :m2 1640, :m3 1638}, :bufs {:b1 [1641], :b2 [1639]}} :line 2154}
{:clk 2493.3839 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1639 :dets {:run {:m1 1642, :m2 1640, :m3 nil}, :bufs {:b1 [1641], :b2 [1639]}} :line 2155}
{:clk 2493.8839 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1640 :dets {:run {:m1 1642, :m2 1640, :m3 1639}, :bufs {:b1 [1641], :b2 []}} :line 2156}
{:clk 2493.8839 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1641 :dets {:run {:m1 1642, :m2 nil, :m3 1639}, :bufs {:b1 [1641], :b2 [1640]}} :line 2157}
{:clk 2494.1914 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1642 :dets {:run {:m1 1642, :m2 1641, :m3 1639}, :bufs {:b1 [], :b2 [1640]}} :line 2158}
{:clk 2494.1914 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2495.1914 :j 1643 :dets {:run {:m1 nil, :m2 1641, :m3 1639}, :bufs {:b1 [1642], :b2 [1640]}} :line 2159}
{:clk 2495.0503 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2489.1914 :j 1639 :dets {:run {:m1 1643, :m2 1641, :m3 1639}, :bufs {:b1 [1642], :b2 [1640]}} :line 2160}
{:clk 2495.0503 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1640 :dets {:run {:m1 1643, :m2 1641, :m3 nil}, :bufs {:b1 [1642], :b2 [1640]}} :line 2161}
{:clk 2495.1914 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1643 :dets {:run {:m1 1643, :m2 1641, :m3 1640}, :bufs {:b1 [1642], :b2 []}} :line 2162}
{:clk 2495.1914 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2496.6914 :j 1644 :dets {:run {:m1 nil, :m2 1641, :m3 1640}, :bufs {:b1 [1642 1643], :b2 []}} :line 2163}
{:clk 2495.3839 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1641 :dets {:run {:m1 1644, :m2 1641, :m3 1640}, :bufs {:b1 [1642 1643], :b2 []}} :line 2164}
{:clk 2495.3839 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1642 :dets {:run {:m1 1644, :m2 nil, :m3 1640}, :bufs {:b1 [1642 1643], :b2 [1641]}} :line 2165}
{:clk 2496.0503 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2490.1914 :j 1640 :dets {:run {:m1 1644, :m2 1642, :m3 1640}, :bufs {:b1 [1643], :b2 [1641]}} :line 2166}
{:clk 2496.0503 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1641 :dets {:run {:m1 1644, :m2 1642, :m3 nil}, :bufs {:b1 [1643], :b2 [1641]}} :line 2167}
{:clk 2496.6914 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1644 :dets {:run {:m1 1644, :m2 1642, :m3 1641}, :bufs {:b1 [1643], :b2 []}} :line 2168}
{:clk 2496.6914 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2497.6914 :j 1645 :dets {:run {:m1 nil, :m2 1642, :m3 1641}, :bufs {:b1 [1643 1644], :b2 []}} :line 2169}
{:clk 2496.8839 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1642 :dets {:run {:m1 1645, :m2 1642, :m3 1641}, :bufs {:b1 [1643 1644], :b2 []}} :line 2170}
{:clk 2496.8839 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1643 :dets {:run {:m1 1645, :m2 nil, :m3 1641}, :bufs {:b1 [1643 1644], :b2 [1642]}} :line 2171}
{:clk 2497.5503 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2491.1914 :j 1641 :dets {:run {:m1 1645, :m2 1643, :m3 1641}, :bufs {:b1 [1644], :b2 [1642]}} :line 2172}
{:clk 2497.5503 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1642 :dets {:run {:m1 1645, :m2 1643, :m3 nil}, :bufs {:b1 [1644], :b2 [1642]}} :line 2173}
{:clk 2497.6914 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1645 :dets {:run {:m1 1645, :m2 1643, :m3 1642}, :bufs {:b1 [1644], :b2 []}} :line 2174}
{:clk 2497.6914 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2499.1914 :j 1646 :dets {:run {:m1 nil, :m2 1643, :m3 1642}, :bufs {:b1 [1644 1645], :b2 []}} :line 2175}
{:clk 2497.8839 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1643 :dets {:run {:m1 1646, :m2 1643, :m3 1642}, :bufs {:b1 [1644 1645], :b2 []}} :line 2176}
{:clk 2497.8839 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1644 :dets {:run {:m1 1646, :m2 nil, :m3 1642}, :bufs {:b1 [1644 1645], :b2 [1643]}} :line 2177}
{:clk 2499.1914 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1646 :dets {:run {:m1 1646, :m2 1644, :m3 1642}, :bufs {:b1 [1645], :b2 [1643]}} :line 2178}
{:clk 2499.1914 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2500.6914 :j 1647 :dets {:run {:m1 nil, :m2 1644, :m3 1642}, :bufs {:b1 [1645 1646], :b2 [1643]}} :line 2179}
{:clk 2499.3839 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1644 :dets {:run {:m1 1647, :m2 1644, :m3 1642}, :bufs {:b1 [1645 1646], :b2 [1643]}} :line 2180}
{:clk 2499.3839 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1645 :dets {:run {:m1 1647, :m2 nil, :m3 1642}, :bufs {:b1 [1645 1646], :b2 [1643 1644]}} :line 2181}
{:clk 2500.3839 :act :m2-blocked :m :m2 :mjpact :bl :dets {:run {:m1 1647, :m2 1645, :m3 1642}, :bufs {:b1 [1646], :b2 [1643 1644]}} :line 2182}
{:clk 2500.6772 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2492.6914 :j 1642 :dets {:run {:m1 1647, :m2 1645, :m3 1642}, :bufs {:b1 [1646], :b2 [1643 1644]}} :line 2183}
{:clk 2500.6772 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1643 :dets {:run {:m1 1647, :m2 1645, :m3 nil}, :bufs {:b1 [1646], :b2 [1643 1644]}} :line 2184}
{:clk 2500.6772 :act :m2-unblocked :m :m2 :mjpact :ub :dets {:run {:m1 1647, :m2 nil, :m3 1643}, :bufs {:b1 [1646], :b2 [1644 1645]}} :line 2185}
{:clk 2500.6772 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1645 :dets {:run {:m1 1647, :m2 1645, :m3 1643}, :bufs {:b1 [1646], :b2 [1644]}} :line 2186}
{:clk 2500.6772 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1646 :dets {:run {:m1 1647, :m2 nil, :m3 1643}, :bufs {:b1 [1646], :b2 [1644 1645]}} :line 2187}
{:clk 2500.6914 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1647 :dets {:run {:m1 1647, :m2 1646, :m3 1643}, :bufs {:b1 [], :b2 [1644 1645]}} :line 2188}
{:clk 2500.6914 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2502.1914 :j 1648 :dets {:run {:m1 nil, :m2 1646, :m3 1643}, :bufs {:b1 [1647], :b2 [1644 1645]}} :line 2189}
{:clk 2501.6772 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2494.1914 :j 1643 :dets {:run {:m1 1648, :m2 1646, :m3 1643}, :bufs {:b1 [1647], :b2 [1644 1645]}} :line 2190}
{:clk 2501.6772 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1644 :dets {:run {:m1 1648, :m2 1646, :m3 nil}, :bufs {:b1 [1647], :b2 [1644 1645]}} :line 2191}
{:clk 2502.1772 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1646 :dets {:run {:m1 1648, :m2 1646, :m3 1644}, :bufs {:b1 [1647], :b2 [1645]}} :line 2192}
{:clk 2502.1772 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1647 :dets {:run {:m1 1648, :m2 nil, :m3 1644}, :bufs {:b1 [1647], :b2 [1645 1646]}} :line 2193}
{:clk 2502.1914 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1648 :dets {:run {:m1 1648, :m2 1647, :m3 1644}, :bufs {:b1 [], :b2 [1645 1646]}} :line 2194}
{:clk 2502.1914 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2503.6914 :j 1649 :dets {:run {:m1 nil, :m2 1647, :m3 1644}, :bufs {:b1 [1648], :b2 [1645 1646]}} :line 2195}
{:clk 2503.1772 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2495.1914 :j 1644 :dets {:run {:m1 1649, :m2 1647, :m3 1644}, :bufs {:b1 [1648], :b2 [1645 1646]}} :line 2196}
{:clk 2503.1772 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1645 :dets {:run {:m1 1649, :m2 1647, :m3 nil}, :bufs {:b1 [1648], :b2 [1645 1646]}} :line 2197}
{:clk 2503.6772 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1647 :dets {:run {:m1 1649, :m2 1647, :m3 1645}, :bufs {:b1 [1648], :b2 [1646]}} :line 2198}
{:clk 2503.6772 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1648 :dets {:run {:m1 1649, :m2 nil, :m3 1645}, :bufs {:b1 [1648], :b2 [1646 1647]}} :line 2199}
{:clk 2503.6914 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1649 :dets {:run {:m1 1649, :m2 1648, :m3 1645}, :bufs {:b1 [], :b2 [1646 1647]}} :line 2200}
{:clk 2503.6914 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2504.6914 :j 1650 :dets {:run {:m1 nil, :m2 1648, :m3 1645}, :bufs {:b1 [1649], :b2 [1646 1647]}} :line 2201}
{:clk 2504.1772 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2496.6914 :j 1645 :dets {:run {:m1 1650, :m2 1648, :m3 1645}, :bufs {:b1 [1649], :b2 [1646 1647]}} :line 2202}
{:clk 2504.1772 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1646 :dets {:run {:m1 1650, :m2 1648, :m3 nil}, :bufs {:b1 [1649], :b2 [1646 1647]}} :line 2203}
{:clk 2504.6914 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1650 :dets {:run {:m1 1650, :m2 1648, :m3 1646}, :bufs {:b1 [1649], :b2 [1647]}} :line 2204}
{:clk 2504.6914 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2505.6914 :j 1651 :dets {:run {:m1 nil, :m2 1648, :m3 1646}, :bufs {:b1 [1649 1650], :b2 [1647]}} :line 2205}
{:clk 2505.1772 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1648 :dets {:run {:m1 1651, :m2 1648, :m3 1646}, :bufs {:b1 [1649 1650], :b2 [1647]}} :line 2206}
{:clk 2505.1772 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1649 :dets {:run {:m1 1651, :m2 nil, :m3 1646}, :bufs {:b1 [1649 1650], :b2 [1647 1648]}} :line 2207}
{:clk 2505.6772 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2497.6914 :j 1646 :dets {:run {:m1 1651, :m2 1649, :m3 1646}, :bufs {:b1 [1650], :b2 [1647 1648]}} :line 2208}
{:clk 2505.6772 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1647 :dets {:run {:m1 1651, :m2 1649, :m3 nil}, :bufs {:b1 [1650], :b2 [1647 1648]}} :line 2209}
{:clk 2505.6914 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1651 :dets {:run {:m1 1651, :m2 1649, :m3 1647}, :bufs {:b1 [1650], :b2 [1648]}} :line 2210}
{:clk 2505.6914 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2507.1914 :j 1652 :dets {:run {:m1 nil, :m2 1649, :m3 1647}, :bufs {:b1 [1650 1651], :b2 [1648]}} :line 2211}
{:clk 2506.6772 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1649 :dets {:run {:m1 1652, :m2 1649, :m3 1647}, :bufs {:b1 [1650 1651], :b2 [1648]}} :line 2212}
{:clk 2506.6772 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1650 :dets {:run {:m1 1652, :m2 nil, :m3 1647}, :bufs {:b1 [1650 1651], :b2 [1648 1649]}} :line 2213}
{:clk 2507.1772 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2499.1914 :j 1647 :dets {:run {:m1 1652, :m2 1650, :m3 1647}, :bufs {:b1 [1651], :b2 [1648 1649]}} :line 2214}
{:clk 2507.1772 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1648 :dets {:run {:m1 1652, :m2 1650, :m3 nil}, :bufs {:b1 [1651], :b2 [1648 1649]}} :line 2215}
{:clk 2507.1914 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1652 :dets {:run {:m1 1652, :m2 1650, :m3 1648}, :bufs {:b1 [1651], :b2 [1649]}} :line 2216}
{:clk 2507.1914 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2508.942 :j 1653 :dets {:run {:m1 nil, :m2 1650, :m3 1648}, :bufs {:b1 [1651 1652], :b2 [1649]}} :line 2217}
{:clk 2507.6772 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1650 :dets {:run {:m1 1653, :m2 1650, :m3 1648}, :bufs {:b1 [1651 1652], :b2 [1649]}} :line 2218}
{:clk 2507.6772 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1651 :dets {:run {:m1 1653, :m2 nil, :m3 1648}, :bufs {:b1 [1651 1652], :b2 [1649 1650]}} :line 2219}
{:clk 2508.6772 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1651 :dets {:run {:m1 1653, :m2 1651, :m3 1649}, :bufs {:b1 [1652], :b2 [1650]}} :line 2220}
{:clk 2508.6772 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1652 :dets {:run {:m1 1653, :m2 nil, :m3 1649}, :bufs {:b1 [1652], :b2 [1650 1651]}} :line 2221}
{:clk 2508.6772 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2500.6914 :j 1648 :dets {:run {:m1 1653, :m2 1651, :m3 1648}, :bufs {:b1 [1652], :b2 [1649 1650]}} :line 2222}
{:clk 2508.6772 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1649 :dets {:run {:m1 1653, :m2 1651, :m3 nil}, :bufs {:b1 [1652], :b2 [1649 1650]}} :line 2223}
{:clk 2508.9420 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1653 :dets {:run {:m1 1653, :m2 1652, :m3 1649}, :bufs {:b1 [], :b2 [1650 1651]}} :line 2224}
{:clk 2508.9420 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2510.442 :j 1654 :dets {:run {:m1 nil, :m2 1652, :m3 1649}, :bufs {:b1 [1653], :b2 [1650 1651]}} :line 2225}
{:clk 2510.1772 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1652 :dets {:run {:m1 1654, :m2 1652, :m3 1650}, :bufs {:b1 [1653], :b2 [1651]}} :line 2226}
{:clk 2510.1772 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1653 :dets {:run {:m1 1654, :m2 nil, :m3 1650}, :bufs {:b1 [1653], :b2 [1651 1652]}} :line 2227}
{:clk 2510.1772 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2502.1914 :j 1649 :dets {:run {:m1 1654, :m2 1652, :m3 1649}, :bufs {:b1 [1653], :b2 [1650 1651]}} :line 2228}
{:clk 2510.1772 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1650 :dets {:run {:m1 1654, :m2 1652, :m3 nil}, :bufs {:b1 [1653], :b2 [1650 1651]}} :line 2229}
{:clk 2510.4420 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1654 :dets {:run {:m1 1654, :m2 1653, :m3 1650}, :bufs {:b1 [], :b2 [1651 1652]}} :line 2230}
{:clk 2510.4420 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2511.442 :j 1655 :dets {:run {:m1 nil, :m2 1653, :m3 1650}, :bufs {:b1 [1654], :b2 [1651 1652]}} :line 2231}
{:clk 2511.1772 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2503.6914 :j 1650 :dets {:run {:m1 1655, :m2 1653, :m3 1650}, :bufs {:b1 [1654], :b2 [1651 1652]}} :line 2232}
{:clk 2511.1772 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1651 :dets {:run {:m1 1655, :m2 1653, :m3 nil}, :bufs {:b1 [1654], :b2 [1651 1652]}} :line 2233}
{:clk 2511.4420 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1655 :dets {:run {:m1 1655, :m2 1653, :m3 1651}, :bufs {:b1 [1654], :b2 [1652]}} :line 2234}
{:clk 2511.4420 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2512.8558 :j 1656 :dets {:run {:m1 nil, :m2 1653, :m3 1651}, :bufs {:b1 [1654 1655], :b2 [1652]}} :line 2235}
{:clk 2511.6772 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1653 :dets {:run {:m1 1656, :m2 1653, :m3 1651}, :bufs {:b1 [1654 1655], :b2 [1652]}} :line 2236}
{:clk 2511.6772 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1654 :dets {:run {:m1 1656, :m2 nil, :m3 1651}, :bufs {:b1 [1654 1655], :b2 [1652 1653]}} :line 2237}
{:clk 2512.1772 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2504.6914 :j 1651 :dets {:run {:m1 1656, :m2 1654, :m3 1651}, :bufs {:b1 [1655], :b2 [1652 1653]}} :line 2238}
{:clk 2512.1772 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1652 :dets {:run {:m1 1656, :m2 1654, :m3 nil}, :bufs {:b1 [1655], :b2 [1652 1653]}} :line 2239}
{:clk 2512.8558 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1656 :dets {:run {:m1 1656, :m2 1654, :m3 1652}, :bufs {:b1 [1655], :b2 [1653]}} :line 2240}
{:clk 2512.8558 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2514.3558 :j 1657 :dets {:run {:m1 nil, :m2 1654, :m3 1652}, :bufs {:b1 [1655 1656], :b2 [1653]}} :line 2241}
{:clk 2513.1772 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1654 :dets {:run {:m1 1657, :m2 1654, :m3 1652}, :bufs {:b1 [1655 1656], :b2 [1653]}} :line 2242}
{:clk 2513.1772 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1655 :dets {:run {:m1 1657, :m2 nil, :m3 1652}, :bufs {:b1 [1655 1656], :b2 [1653 1654]}} :line 2243}
{:clk 2513.6772 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2505.6914 :j 1652 :dets {:run {:m1 1657, :m2 1655, :m3 1652}, :bufs {:b1 [1656], :b2 [1653 1654]}} :line 2244}
{:clk 2513.6772 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1653 :dets {:run {:m1 1657, :m2 1655, :m3 nil}, :bufs {:b1 [1656], :b2 [1653 1654]}} :line 2245}
{:clk 2514.1772 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1655 :dets {:run {:m1 1657, :m2 1655, :m3 1653}, :bufs {:b1 [1656], :b2 [1654]}} :line 2246}
{:clk 2514.1772 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1656 :dets {:run {:m1 1657, :m2 nil, :m3 1653}, :bufs {:b1 [1656], :b2 [1654 1655]}} :line 2247}
{:clk 2514.3558 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1657 :dets {:run {:m1 1657, :m2 1656, :m3 1653}, :bufs {:b1 [], :b2 [1654 1655]}} :line 2248}
{:clk 2514.3558 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2520.289 :j 1658 :dets {:run {:m1 nil, :m2 1656, :m3 1653}, :bufs {:b1 [1657], :b2 [1654 1655]}} :line 2249}
{:clk 2515.1772 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1656 :dets {:run {:m1 1658, :m2 1656, :m3 1654}, :bufs {:b1 [1657], :b2 [1655]}} :line 2250}
{:clk 2515.1772 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1657 :dets {:run {:m1 1658, :m2 nil, :m3 1654}, :bufs {:b1 [1657], :b2 [1655 1656]}} :line 2251}
{:clk 2515.1772 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2507.1914 :j 1653 :dets {:run {:m1 1658, :m2 1656, :m3 1653}, :bufs {:b1 [1657], :b2 [1654 1655]}} :line 2252}
{:clk 2515.1772 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1654 :dets {:run {:m1 1658, :m2 1656, :m3 nil}, :bufs {:b1 [1657], :b2 [1654 1655]}} :line 2253}
{:clk 2516.6772 :act :m2-starved :m :m2 :mjpact :st :dets {:run {:m1 1658, :m2 1657, :m3 1654}, :bufs {:b1 [], :b2 [1655 1656]}} :line 2254}
{:clk 2516.6772 :act :m2-blocked :m :m2 :mjpact :bl :dets {:run {:m1 1658, :m2 1657, :m3 1654}, :bufs {:b1 [], :b2 [1655 1656]}} :line 2255}
{:clk 2517.6543 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2508.942 :j 1654 :dets {:run {:m1 1658, :m2 1657, :m3 1654}, :bufs {:b1 [], :b2 [1655 1656]}} :line 2256}
{:clk 2517.6543 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1655 :dets {:run {:m1 1658, :m2 1657, :m3 nil}, :bufs {:b1 [], :b2 [1655 1656]}} :line 2257}
{:clk 2517.6543 :act :m2-unblocked :m :m2 :mjpact :ub :dets {:run {:m1 1658, :m2 nil, :m3 1655}, :bufs {:b1 [], :b2 [1656 1657]}} :line 2258}
{:clk 2517.6543 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1657 :dets {:run {:m1 1658, :m2 1657, :m3 1655}, :bufs {:b1 [], :b2 [1656]}} :line 2259}
{:clk 2518.6543 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2510.442 :j 1655 :dets {:run {:m1 1658, :m2 nil, :m3 1655}, :bufs {:b1 [], :b2 [1656 1657]}} :line 2260}
{:clk 2518.6543 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1656 :dets {:run {:m1 1658, :m2 nil, :m3 nil}, :bufs {:b1 [], :b2 [1656 1657]}} :line 2261}
{:clk 2519.6543 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2511.442 :j 1656 :dets {:run {:m1 1658, :m2 nil, :m3 1656}, :bufs {:b1 [], :b2 [1657]}} :line 2262}
{:clk 2519.6543 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1657 :dets {:run {:m1 1658, :m2 nil, :m3 nil}, :bufs {:b1 [], :b2 [1657]}} :line 2263}
{:clk 2520.2890 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1658 :dets {:run {:m1 1658, :m2 nil, :m3 1657}, :bufs {:b1 [], :b2 []}} :line 2264}
{:clk 2520.2890 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2521.789 :j 1659 :dets {:run {:m1 nil, :m2 nil, :m3 1657}, :bufs {:b1 [1658], :b2 []}} :line 2265}
{:clk 2520.2890 :act :m2-unstarved :m :m2 :mjpact :us :dets {:run {:m1 1659, :m2 1658, :m3 1657}, :bufs {:b1 [], :b2 []}} :line 2266}
{:clk 2520.2890 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1658 :dets {:run {:m1 1659, :m2 nil, :m3 1657}, :bufs {:b1 [1658], :b2 []}} :line 2267}
{:clk 2521.2378 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2512.8558 :j 1657 :dets {:run {:m1 1659, :m2 1658, :m3 1657}, :bufs {:b1 [], :b2 []}} :line 2268}
{:clk 2521.2378 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1659, :m2 1658, :m3 nil}, :bufs {:b1 [], :b2 []}} :line 2269}
{:clk 2521.7890 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1659 :dets {:run {:m1 1659, :m2 1658, :m3 nil}, :bufs {:b1 [], :b2 []}} :line 2270}
{:clk 2521.7890 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2522.789 :j 1660 :dets {:run {:m1 nil, :m2 1658, :m3 nil}, :bufs {:b1 [1659], :b2 []}} :line 2271}
{:clk 2522.7890 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1660 :dets {:run {:m1 1660, :m2 1658, :m3 nil}, :bufs {:b1 [1659], :b2 []}} :line 2272}
{:clk 2522.7890 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2523.789 :j 1661 :dets {:run {:m1 nil, :m2 1658, :m3 nil}, :bufs {:b1 [1659 1660], :b2 []}} :line 2273}
{:clk 2523.7890 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1661, :m2 1658, :m3 nil}, :bufs {:b1 [1659 1660], :b2 []}} :line 2274}
{:clk 2524.2202 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1658 :dets {:run {:m1 1661, :m2 1659, :m3 nil}, :bufs {:b1 [1660], :b2 [1658]}} :line 2275}
{:clk 2524.2202 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1658 :dets {:run {:m1 1661, :m2 1658, :m3 nil}, :bufs {:b1 [1659 1660], :b2 []}} :line 2276}
{:clk 2524.2202 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1659 :dets {:run {:m1 1661, :m2 nil, :m3 nil}, :bufs {:b1 [1659 1660], :b2 [1658]}} :line 2277}
{:clk 2524.2202 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1661, :m2 1659, :m3 1658}, :bufs {:b1 [1660], :b2 []}} :line 2278}
{:clk 2524.2202 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1659, :m3 1658}, :bufs {:b1 [1660 1661], :b2 []}} :line 2279}
{:clk 2524.2202 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1661 :dets {:run {:m1 1661, :m2 1659, :m3 1658}, :bufs {:b1 [1660], :b2 []}} :line 2280}
{:clk 2524.2202 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2525.2202 :j 1662 :dets {:run {:m1 nil, :m2 1659, :m3 1658}, :bufs {:b1 [1660 1661], :b2 []}} :line 2281}
{:clk 2525.2202 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1662, :m2 1659, :m3 nil}, :bufs {:b1 [1660 1661], :b2 []}} :line 2282}
{:clk 2525.2202 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1662, :m2 1659, :m3 nil}, :bufs {:b1 [1660 1661], :b2 []}} :line 2283}
{:clk 2525.2202 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2514.3558 :j 1658 :dets {:run {:m1 1662, :m2 1659, :m3 1658}, :bufs {:b1 [1660 1661], :b2 []}} :line 2284}
{:clk 2525.7202 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1659 :dets {:run {:m1 1662, :m2 1660, :m3 nil}, :bufs {:b1 [1661], :b2 [1659]}} :line 2285}
{:clk 2525.7202 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1659 :dets {:run {:m1 1662, :m2 1659, :m3 nil}, :bufs {:b1 [1660 1661], :b2 []}} :line 2286}
{:clk 2525.7202 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1660 :dets {:run {:m1 1662, :m2 nil, :m3 nil}, :bufs {:b1 [1660 1661], :b2 [1659]}} :line 2287}
{:clk 2525.7202 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1662, :m2 1660, :m3 1659}, :bufs {:b1 [1661], :b2 []}} :line 2288}
{:clk 2525.7202 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1660, :m3 1659}, :bufs {:b1 [1661 1662], :b2 []}} :line 2289}
{:clk 2525.7202 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1662 :dets {:run {:m1 1662, :m2 1660, :m3 1659}, :bufs {:b1 [1661], :b2 []}} :line 2290}
{:clk 2525.7202 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2526.7202 :j 1663 :dets {:run {:m1 nil, :m2 1660, :m3 1659}, :bufs {:b1 [1661 1662], :b2 []}} :line 2291}
{:clk 2526.7202 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1663 :dets {:run {:m1 1663, :m2 1661, :m3 1659}, :bufs {:b1 [1662], :b2 [1660]}} :line 2292}
{:clk 2526.7202 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2528.2202 :j 1664 :dets {:run {:m1 nil, :m2 1661, :m3 1659}, :bufs {:b1 [1662 1663], :b2 [1660]}} :line 2293}
{:clk 2526.7202 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1660 :dets {:run {:m1 1663, :m2 1660, :m3 1659}, :bufs {:b1 [1661 1662], :b2 []}} :line 2294}
{:clk 2526.7202 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1661 :dets {:run {:m1 1663, :m2 nil, :m3 1659}, :bufs {:b1 [1661 1662], :b2 [1660]}} :line 2295}
{:clk 2527.2202 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2520.289 :j 1659 :dets {:run {:m1 1664, :m2 1661, :m3 1659}, :bufs {:b1 [1662 1663], :b2 [1660]}} :line 2296}
{:clk 2527.2202 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1660 :dets {:run {:m1 1664, :m2 1661, :m3 nil}, :bufs {:b1 [1662 1663], :b2 [1660]}} :line 2297}
{:clk 2527.7202 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1661 :dets {:run {:m1 1664, :m2 1661, :m3 1660}, :bufs {:b1 [1662 1663], :b2 []}} :line 2298}
{:clk 2527.7202 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1662 :dets {:run {:m1 1664, :m2 nil, :m3 1660}, :bufs {:b1 [1662 1663], :b2 [1661]}} :line 2299}
{:clk 2528.2202 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1664 :dets {:run {:m1 1664, :m2 1662, :m3 1660}, :bufs {:b1 [1663], :b2 [1661]}} :line 2300}
{:clk 2528.2202 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2529.7202 :j 1665 :dets {:run {:m1 nil, :m2 1662, :m3 nil}, :bufs {:b1 [1663 1664], :b2 [1661]}} :line 2301}
{:clk 2528.2202 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2521.789 :j 1660 :dets {:run {:m1 nil, :m2 1662, :m3 1660}, :bufs {:b1 [1663 1664], :b2 [1661]}} :line 2302}
{:clk 2528.2202 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1661 :dets {:run {:m1 1665, :m2 1662, :m3 nil}, :bufs {:b1 [1663 1664], :b2 [1661]}} :line 2303}
{:clk 2528.7202 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1662 :dets {:run {:m1 1665, :m2 1662, :m3 1661}, :bufs {:b1 [1663 1664], :b2 []}} :line 2304}
{:clk 2528.7202 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1663 :dets {:run {:m1 1665, :m2 nil, :m3 1661}, :bufs {:b1 [1663 1664], :b2 [1662]}} :line 2305}
{:clk 2529.2202 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2522.789 :j 1661 :dets {:run {:m1 1665, :m2 1663, :m3 1661}, :bufs {:b1 [1664], :b2 [1662]}} :line 2306}
{:clk 2529.2202 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1662 :dets {:run {:m1 1665, :m2 1663, :m3 nil}, :bufs {:b1 [1664], :b2 [1662]}} :line 2307}
{:clk 2529.7202 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1665 :dets {:run {:m1 1665, :m2 1663, :m3 1662}, :bufs {:b1 [1664], :b2 []}} :line 2308}
{:clk 2529.7202 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2531.6014 :j 1666 :dets {:run {:m1 nil, :m2 nil, :m3 1662}, :bufs {:b1 [1664 1665], :b2 [1663]}} :line 2309}
{:clk 2529.7202 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1663 :dets {:run {:m1 nil, :m2 1663, :m3 1662}, :bufs {:b1 [1664 1665], :b2 []}} :line 2310}
{:clk 2529.7202 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1664 :dets {:run {:m1 1666, :m2 nil, :m3 1662}, :bufs {:b1 [1664 1665], :b2 [1663]}} :line 2311}
{:clk 2531.6014 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1666 :dets {:run {:m1 1666, :m2 1664, :m3 1662}, :bufs {:b1 [1665], :b2 [1663]}} :line 2312}
{:clk 2531.6014 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2533.0497 :j 1667 :dets {:run {:m1 nil, :m2 1664, :m3 1662}, :bufs {:b1 [1665 1666], :b2 [1663]}} :line 2313}
{:clk 2532.2194 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2524.2202 :j 1662 :dets {:run {:m1 1667, :m2 1664, :m3 1662}, :bufs {:b1 [1665 1666], :b2 [1663]}} :line 2314}
{:clk 2532.2194 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1663 :dets {:run {:m1 1667, :m2 1664, :m3 nil}, :bufs {:b1 [1665 1666], :b2 [1663]}} :line 2315}
{:clk 2532.5894 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1664 :dets {:run {:m1 1667, :m2 1664, :m3 1663}, :bufs {:b1 [1665 1666], :b2 []}} :line 2316}
{:clk 2532.5894 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1665 :dets {:run {:m1 1667, :m2 nil, :m3 1663}, :bufs {:b1 [1665 1666], :b2 [1664]}} :line 2317}
{:clk 2533.0497 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1667 :dets {:run {:m1 1667, :m2 1665, :m3 1663}, :bufs {:b1 [1666], :b2 [1664]}} :line 2318}
{:clk 2533.0497 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2535.5771 :j 1668 :dets {:run {:m1 nil, :m2 1665, :m3 1663}, :bufs {:b1 [1666 1667], :b2 [1664]}} :line 2319}
{:clk 2533.2194 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2525.7202 :j 1663 :dets {:run {:m1 1668, :m2 1665, :m3 1663}, :bufs {:b1 [1666 1667], :b2 [1664]}} :line 2320}
{:clk 2533.2194 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1664 :dets {:run {:m1 1668, :m2 1665, :m3 nil}, :bufs {:b1 [1666 1667], :b2 [1664]}} :line 2321}
{:clk 2534.0894 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1665 :dets {:run {:m1 1668, :m2 1665, :m3 1664}, :bufs {:b1 [1666 1667], :b2 []}} :line 2322}
{:clk 2534.0894 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1666 :dets {:run {:m1 1668, :m2 nil, :m3 1664}, :bufs {:b1 [1666 1667], :b2 [1665]}} :line 2323}
{:clk 2535.0243 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2526.7202 :j 1664 :dets {:run {:m1 1668, :m2 1666, :m3 1664}, :bufs {:b1 [1667], :b2 [1665]}} :line 2324}
{:clk 2535.0243 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1665 :dets {:run {:m1 1668, :m2 1666, :m3 nil}, :bufs {:b1 [1667], :b2 [1665]}} :line 2325}
{:clk 2535.5771 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1668 :dets {:run {:m1 1668, :m2 1666, :m3 1665}, :bufs {:b1 [1667], :b2 []}} :line 2326}
{:clk 2535.5771 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2536.5771 :j 1669 :dets {:run {:m1 nil, :m2 1666, :m3 1665}, :bufs {:b1 [1667 1668], :b2 []}} :line 2327}
{:clk 2535.5894 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1666 :dets {:run {:m1 1669, :m2 1666, :m3 1665}, :bufs {:b1 [1667 1668], :b2 []}} :line 2328}
{:clk 2535.5894 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1667 :dets {:run {:m1 1669, :m2 nil, :m3 1665}, :bufs {:b1 [1667 1668], :b2 [1666]}} :line 2329}
{:clk 2536.5771 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1669 :dets {:run {:m1 1669, :m2 1667, :m3 1665}, :bufs {:b1 [1668], :b2 [1666]}} :line 2330}
{:clk 2536.5771 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2538.2702 :j 1670 :dets {:run {:m1 nil, :m2 1667, :m3 1665}, :bufs {:b1 [1668 1669], :b2 [1666]}} :line 2331}
{:clk 2536.5894 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1667 :dets {:run {:m1 1670, :m2 1667, :m3 1665}, :bufs {:b1 [1668 1669], :b2 [1666]}} :line 2332}
{:clk 2536.5894 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1668 :dets {:run {:m1 1670, :m2 nil, :m3 1665}, :bufs {:b1 [1668 1669], :b2 [1666 1667]}} :line 2333}
{:clk 2538.2702 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1670 :dets {:run {:m1 1670, :m2 1668, :m3 1665}, :bufs {:b1 [1669], :b2 [1666 1667]}} :line 2334}
{:clk 2538.2702 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2539.2702 :j 1671 :dets {:run {:m1 nil, :m2 1668, :m3 1665}, :bufs {:b1 [1669 1670], :b2 [1666 1667]}} :line 2335}
{:clk 2538.4994 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2528.2202 :j 1665 :dets {:run {:m1 1671, :m2 1668, :m3 1665}, :bufs {:b1 [1669 1670], :b2 [1666 1667]}} :line 2336}
{:clk 2538.4994 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1666 :dets {:run {:m1 1671, :m2 1668, :m3 nil}, :bufs {:b1 [1669 1670], :b2 [1666 1667]}} :line 2337}
{:clk 2538.6440 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1668 :dets {:run {:m1 1671, :m2 1668, :m3 1666}, :bufs {:b1 [1669 1670], :b2 [1667]}} :line 2338}
{:clk 2538.6440 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1669 :dets {:run {:m1 1671, :m2 nil, :m3 1666}, :bufs {:b1 [1669 1670], :b2 [1667 1668]}} :line 2339}
{:clk 2539.2702 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1671 :dets {:run {:m1 1671, :m2 1669, :m3 1666}, :bufs {:b1 [1670], :b2 [1667 1668]}} :line 2340}
{:clk 2539.2702 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2540.2702 :j 1672 :dets {:run {:m1 nil, :m2 1669, :m3 1666}, :bufs {:b1 [1670 1671], :b2 [1667 1668]}} :line 2341}
{:clk 2539.6440 :act :m2-blocked :m :m2 :mjpact :bl :dets {:run {:m1 1672, :m2 1669, :m3 1666}, :bufs {:b1 [1670 1671], :b2 [1667 1668]}} :line 2342}
{:clk 2540.2702 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1672, :m2 1669, :m3 1666}, :bufs {:b1 [1670 1671], :b2 [1667 1668]}} :line 2343}
{:clk 2540.3227 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2529.7202 :j 1666 :dets {:run {:m1 1672, :m2 1669, :m3 1666}, :bufs {:b1 [1670 1671], :b2 [1667 1668]}} :line 2344}
{:clk 2540.3227 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1667 :dets {:run {:m1 1672, :m2 1669, :m3 nil}, :bufs {:b1 [1670 1671], :b2 [1667 1668]}} :line 2345}
{:clk 2540.3227 :act :m2-unblocked :m :m2 :mjpact :ub :dets {:run {:m1 1672, :m2 nil, :m3 1667}, :bufs {:b1 [1670 1671], :b2 [1668 1669]}} :line 2346}
{:clk 2540.3227 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1669 :dets {:run {:m1 1672, :m2 1669, :m3 1667}, :bufs {:b1 [1670 1671], :b2 [1668]}} :line 2347}
{:clk 2541.3227 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2531.6014 :j 1667 :dets {:run {:m1 1672, :m2 nil, :m3 1667}, :bufs {:b1 [1670 1671], :b2 [1668 1669]}} :line 2348}
{:clk 2541.3227 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1668 :dets {:run {:m1 1672, :m2 nil, :m3 nil}, :bufs {:b1 [1670 1671], :b2 [1668 1669]}} :line 2349}
{:clk 2542.8227 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2533.0497 :j 1668 :dets {:run {:m1 1672, :m2 nil, :m3 1668}, :bufs {:b1 [1670 1671], :b2 [1669]}} :line 2350}
{:clk 2542.8227 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1669 :dets {:run {:m1 1672, :m2 nil, :m3 nil}, :bufs {:b1 [1670 1671], :b2 [1669]}} :line 2351}
{:clk 2543.2089 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1670 :dets {:run {:m1 1672, :m2 nil, :m3 1669}, :bufs {:b1 [1670 1671], :b2 []}} :line 2352}
{:clk 2543.2089 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1670, :m3 1669}, :bufs {:b1 [1671 1672], :b2 []}} :line 2353}
{:clk 2543.2089 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1672 :dets {:run {:m1 1672, :m2 1670, :m3 1669}, :bufs {:b1 [1671], :b2 []}} :line 2354}
{:clk 2543.2089 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2544.7089 :j 1673 :dets {:run {:m1 nil, :m2 1670, :m3 1669}, :bufs {:b1 [1671 1672], :b2 []}} :line 2355}
{:clk 2543.8227 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2535.5771 :j 1669 :dets {:run {:m1 1673, :m2 1670, :m3 1669}, :bufs {:b1 [1671 1672], :b2 []}} :line 2356}
{:clk 2543.8227 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1673, :m2 1670, :m3 nil}, :bufs {:b1 [1671 1672], :b2 []}} :line 2357}
{:clk 2544.2089 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1670 :dets {:run {:m1 1673, :m2 1670, :m3 nil}, :bufs {:b1 [1671 1672], :b2 []}} :line 2358}
{:clk 2544.2089 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1671 :dets {:run {:m1 1673, :m2 nil, :m3 nil}, :bufs {:b1 [1671 1672], :b2 [1670]}} :line 2359}
{:clk 2544.2089 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1673, :m2 1671, :m3 1670}, :bufs {:b1 [1672], :b2 []}} :line 2360}
{:clk 2544.2089 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1670 :dets {:run {:m1 1673, :m2 1671, :m3 nil}, :bufs {:b1 [1672], :b2 [1670]}} :line 2361}
{:clk 2544.7089 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1673 :dets {:run {:m1 1673, :m2 1671, :m3 1670}, :bufs {:b1 [1672], :b2 []}} :line 2362}
{:clk 2544.7089 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2545.7089 :j 1674 :dets {:run {:m1 nil, :m2 1671, :m3 1670}, :bufs {:b1 [1672 1673], :b2 []}} :line 2363}
{:clk 2545.2089 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1671 :dets {:run {:m1 1674, :m2 1671, :m3 1670}, :bufs {:b1 [1672 1673], :b2 []}} :line 2364}
{:clk 2545.2089 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1672 :dets {:run {:m1 1674, :m2 nil, :m3 nil}, :bufs {:b1 [1672 1673], :b2 [1671]}} :line 2365}
{:clk 2545.2089 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2536.5771 :j 1670 :dets {:run {:m1 1674, :m2 nil, :m3 1670}, :bufs {:b1 [1672 1673], :b2 [1671]}} :line 2366}
{:clk 2545.2089 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1671 :dets {:run {:m1 1674, :m2 1672, :m3 nil}, :bufs {:b1 [1673], :b2 [1671]}} :line 2367}
{:clk 2545.7089 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1674 :dets {:run {:m1 1674, :m2 1672, :m3 1671}, :bufs {:b1 [1673], :b2 []}} :line 2368}
{:clk 2545.7089 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2546.7089 :j 1675 :dets {:run {:m1 nil, :m2 1672, :m3 1671}, :bufs {:b1 [1673 1674], :b2 []}} :line 2369}
{:clk 2546.2089 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1672 :dets {:run {:m1 1675, :m2 1672, :m3 1671}, :bufs {:b1 [1673 1674], :b2 []}} :line 2370}
{:clk 2546.2089 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1673 :dets {:run {:m1 1675, :m2 nil, :m3 nil}, :bufs {:b1 [1673 1674], :b2 [1672]}} :line 2371}
{:clk 2546.2089 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2538.2702 :j 1671 :dets {:run {:m1 1675, :m2 nil, :m3 1671}, :bufs {:b1 [1673 1674], :b2 [1672]}} :line 2372}
{:clk 2546.2089 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1672 :dets {:run {:m1 1675, :m2 1673, :m3 nil}, :bufs {:b1 [1674], :b2 [1672]}} :line 2373}
{:clk 2546.7089 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1675 :dets {:run {:m1 1675, :m2 1673, :m3 1672}, :bufs {:b1 [1674], :b2 []}} :line 2374}
{:clk 2546.7089 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2547.7089 :j 1676 :dets {:run {:m1 nil, :m2 1673, :m3 1672}, :bufs {:b1 [1674 1675], :b2 []}} :line 2375}
{:clk 2547.2089 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2539.2702 :j 1672 :dets {:run {:m1 1676, :m2 1673, :m3 1672}, :bufs {:b1 [1674 1675], :b2 []}} :line 2376}
{:clk 2547.2089 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1676, :m2 1673, :m3 nil}, :bufs {:b1 [1674 1675], :b2 []}} :line 2377}
{:clk 2547.7089 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1676 :dets {:run {:m1 1676, :m2 1674, :m3 1673}, :bufs {:b1 [1675], :b2 []}} :line 2378}
{:clk 2547.7089 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2549.2089 :j 1677 :dets {:run {:m1 nil, :m2 1674, :m3 1673}, :bufs {:b1 [1675 1676], :b2 []}} :line 2379}
{:clk 2547.7089 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1673 :dets {:run {:m1 1676, :m2 1673, :m3 nil}, :bufs {:b1 [1674 1675], :b2 []}} :line 2380}
{:clk 2547.7089 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1674 :dets {:run {:m1 1676, :m2 nil, :m3 nil}, :bufs {:b1 [1674 1675], :b2 [1673]}} :line 2381}
{:clk 2547.7089 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1676, :m2 1674, :m3 1673}, :bufs {:b1 [1675], :b2 []}} :line 2382}
{:clk 2547.7089 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1673 :dets {:run {:m1 1676, :m2 1674, :m3 nil}, :bufs {:b1 [1675], :b2 [1673]}} :line 2383}
{:clk 2548.7089 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1674 :dets {:run {:m1 1677, :m2 1674, :m3 1673}, :bufs {:b1 [1675 1676], :b2 []}} :line 2384}
{:clk 2548.7089 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1675 :dets {:run {:m1 1677, :m2 nil, :m3 1673}, :bufs {:b1 [1675 1676], :b2 [1674]}} :line 2385}
{:clk 2549.2089 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1677 :dets {:run {:m1 1677, :m2 1675, :m3 1673}, :bufs {:b1 [1676], :b2 [1674]}} :line 2386}
{:clk 2549.2089 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2550.2089 :j 1678 :dets {:run {:m1 nil, :m2 1675, :m3 nil}, :bufs {:b1 [1676 1677], :b2 [1674]}} :line 2387}
{:clk 2549.2089 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2543.2089 :j 1673 :dets {:run {:m1 nil, :m2 1675, :m3 1673}, :bufs {:b1 [1676 1677], :b2 [1674]}} :line 2388}
{:clk 2549.2089 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1674 :dets {:run {:m1 1678, :m2 1675, :m3 nil}, :bufs {:b1 [1676 1677], :b2 [1674]}} :line 2389}
{:clk 2549.7089 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1675 :dets {:run {:m1 1678, :m2 1675, :m3 1674}, :bufs {:b1 [1676 1677], :b2 []}} :line 2390}
{:clk 2549.7089 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1676 :dets {:run {:m1 1678, :m2 nil, :m3 1674}, :bufs {:b1 [1676 1677], :b2 [1675]}} :line 2391}
{:clk 2550.2089 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1678 :dets {:run {:m1 1678, :m2 1676, :m3 1674}, :bufs {:b1 [1677], :b2 [1675]}} :line 2392}
{:clk 2550.2089 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2551.7089 :j 1679 :dets {:run {:m1 nil, :m2 1676, :m3 nil}, :bufs {:b1 [1677 1678], :b2 [1675]}} :line 2393}
{:clk 2550.2089 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2544.7089 :j 1674 :dets {:run {:m1 nil, :m2 1676, :m3 1674}, :bufs {:b1 [1677 1678], :b2 [1675]}} :line 2394}
{:clk 2550.2089 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1675 :dets {:run {:m1 1679, :m2 1676, :m3 nil}, :bufs {:b1 [1677 1678], :b2 [1675]}} :line 2395}
{:clk 2550.7089 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1676 :dets {:run {:m1 1679, :m2 1676, :m3 1675}, :bufs {:b1 [1677 1678], :b2 []}} :line 2396}
{:clk 2550.7089 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1677 :dets {:run {:m1 1679, :m2 nil, :m3 1675}, :bufs {:b1 [1677 1678], :b2 [1676]}} :line 2397}
{:clk 2551.2089 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2545.7089 :j 1675 :dets {:run {:m1 1679, :m2 1677, :m3 1675}, :bufs {:b1 [1678], :b2 [1676]}} :line 2398}
{:clk 2551.2089 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1676 :dets {:run {:m1 1679, :m2 1677, :m3 nil}, :bufs {:b1 [1678], :b2 [1676]}} :line 2399}
{:clk 2551.7089 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1679 :dets {:run {:m1 1679, :m2 1677, :m3 1676}, :bufs {:b1 [1678], :b2 []}} :line 2400}
{:clk 2551.7089 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2553.2089 :j 1680 :dets {:run {:m1 nil, :m2 1677, :m3 1676}, :bufs {:b1 [1678 1679], :b2 []}} :line 2401}
{:clk 2552.2089 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1677 :dets {:run {:m1 1680, :m2 1677, :m3 1676}, :bufs {:b1 [1678 1679], :b2 []}} :line 2402}
{:clk 2552.2089 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1678 :dets {:run {:m1 1680, :m2 nil, :m3 nil}, :bufs {:b1 [1678 1679], :b2 [1677]}} :line 2403}
{:clk 2552.2089 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2546.7089 :j 1676 :dets {:run {:m1 1680, :m2 nil, :m3 1676}, :bufs {:b1 [1678 1679], :b2 [1677]}} :line 2404}
{:clk 2552.2089 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1677 :dets {:run {:m1 1680, :m2 1678, :m3 nil}, :bufs {:b1 [1679], :b2 [1677]}} :line 2405}
{:clk 2553.2089 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1680 :dets {:run {:m1 1680, :m2 1678, :m3 1677}, :bufs {:b1 [1679], :b2 []}} :line 2406}
{:clk 2553.2089 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2554.2089 :j 1681 :dets {:run {:m1 nil, :m2 nil, :m3 1677}, :bufs {:b1 [1679 1680], :b2 [1678]}} :line 2407}
{:clk 2553.2089 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1678 :dets {:run {:m1 nil, :m2 1678, :m3 1677}, :bufs {:b1 [1679 1680], :b2 []}} :line 2408}
{:clk 2553.2089 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1679 :dets {:run {:m1 1681, :m2 nil, :m3 1677}, :bufs {:b1 [1679 1680], :b2 [1678]}} :line 2409}
{:clk 2554.1256 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2547.7089 :j 1677 :dets {:run {:m1 1681, :m2 1679, :m3 1677}, :bufs {:b1 [1680], :b2 [1678]}} :line 2410}
{:clk 2554.1256 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1678 :dets {:run {:m1 1681, :m2 1679, :m3 nil}, :bufs {:b1 [1680], :b2 [1678]}} :line 2411}
{:clk 2554.2089 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1681 :dets {:run {:m1 1681, :m2 1679, :m3 1678}, :bufs {:b1 [1680], :b2 []}} :line 2412}
{:clk 2554.2089 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2555.2089 :j 1682 :dets {:run {:m1 nil, :m2 1679, :m3 1678}, :bufs {:b1 [1680 1681], :b2 []}} :line 2413}
{:clk 2554.7089 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1679 :dets {:run {:m1 1682, :m2 1679, :m3 1678}, :bufs {:b1 [1680 1681], :b2 []}} :line 2414}
{:clk 2554.7089 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1680 :dets {:run {:m1 1682, :m2 nil, :m3 1678}, :bufs {:b1 [1680 1681], :b2 [1679]}} :line 2415}
{:clk 2555.1256 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2549.2089 :j 1678 :dets {:run {:m1 1682, :m2 1680, :m3 1678}, :bufs {:b1 [1681], :b2 [1679]}} :line 2416}
{:clk 2555.1256 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1679 :dets {:run {:m1 1682, :m2 1680, :m3 nil}, :bufs {:b1 [1681], :b2 [1679]}} :line 2417}
{:clk 2555.2089 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1682 :dets {:run {:m1 1682, :m2 1680, :m3 1679}, :bufs {:b1 [1681], :b2 []}} :line 2418}
{:clk 2555.2089 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2556.7089 :j 1683 :dets {:run {:m1 nil, :m2 1680, :m3 1679}, :bufs {:b1 [1681 1682], :b2 []}} :line 2419}
{:clk 2556.2089 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1680 :dets {:run {:m1 1683, :m2 1680, :m3 1679}, :bufs {:b1 [1681 1682], :b2 []}} :line 2420}
{:clk 2556.2089 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1681 :dets {:run {:m1 1683, :m2 nil, :m3 1679}, :bufs {:b1 [1681 1682], :b2 [1680]}} :line 2421}
{:clk 2556.6256 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2550.2089 :j 1679 :dets {:run {:m1 1683, :m2 1681, :m3 1679}, :bufs {:b1 [1682], :b2 [1680]}} :line 2422}
{:clk 2556.6256 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1680 :dets {:run {:m1 1683, :m2 1681, :m3 nil}, :bufs {:b1 [1682], :b2 [1680]}} :line 2423}
{:clk 2556.7089 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1683 :dets {:run {:m1 1683, :m2 1681, :m3 1680}, :bufs {:b1 [1682], :b2 []}} :line 2424}
{:clk 2556.7089 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2557.7089 :j 1684 :dets {:run {:m1 nil, :m2 1681, :m3 1680}, :bufs {:b1 [1682 1683], :b2 []}} :line 2425}
{:clk 2557.2089 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1681 :dets {:run {:m1 1684, :m2 1681, :m3 1680}, :bufs {:b1 [1682 1683], :b2 []}} :line 2426}
{:clk 2557.2089 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1682 :dets {:run {:m1 1684, :m2 nil, :m3 1680}, :bufs {:b1 [1682 1683], :b2 [1681]}} :line 2427}
{:clk 2557.7089 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1684 :dets {:run {:m1 1684, :m2 1682, :m3 1680}, :bufs {:b1 [1683], :b2 [1681]}} :line 2428}
{:clk 2557.7089 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2559.2089 :j 1685 :dets {:run {:m1 nil, :m2 1682, :m3 1680}, :bufs {:b1 [1683 1684], :b2 [1681]}} :line 2429}
{:clk 2558.1256 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2551.7089 :j 1680 :dets {:run {:m1 1685, :m2 1682, :m3 1680}, :bufs {:b1 [1683 1684], :b2 [1681]}} :line 2430}
{:clk 2558.1256 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1681 :dets {:run {:m1 1685, :m2 1682, :m3 nil}, :bufs {:b1 [1683 1684], :b2 [1681]}} :line 2431}
{:clk 2558.2089 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1682 :dets {:run {:m1 1685, :m2 1682, :m3 1681}, :bufs {:b1 [1683 1684], :b2 []}} :line 2432}
{:clk 2558.2089 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1683 :dets {:run {:m1 1685, :m2 nil, :m3 1681}, :bufs {:b1 [1683 1684], :b2 [1682]}} :line 2433}
{:clk 2559.1256 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2553.2089 :j 1681 :dets {:run {:m1 1685, :m2 1683, :m3 1681}, :bufs {:b1 [1684], :b2 [1682]}} :line 2434}
{:clk 2559.1256 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1682 :dets {:run {:m1 1685, :m2 1683, :m3 nil}, :bufs {:b1 [1684], :b2 [1682]}} :line 2435}
{:clk 2559.2089 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1685 :dets {:run {:m1 1685, :m2 1683, :m3 1682}, :bufs {:b1 [1684], :b2 []}} :line 2436}
{:clk 2559.2089 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2560.2089 :j 1686 :dets {:run {:m1 nil, :m2 1683, :m3 1682}, :bufs {:b1 [1684 1685], :b2 []}} :line 2437}
{:clk 2559.7089 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1683 :dets {:run {:m1 1686, :m2 1683, :m3 1682}, :bufs {:b1 [1684 1685], :b2 []}} :line 2438}
{:clk 2559.7089 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1684 :dets {:run {:m1 1686, :m2 nil, :m3 1682}, :bufs {:b1 [1684 1685], :b2 [1683]}} :line 2439}
{:clk 2560.1256 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2554.2089 :j 1682 :dets {:run {:m1 1686, :m2 1684, :m3 1682}, :bufs {:b1 [1685], :b2 [1683]}} :line 2440}
{:clk 2560.1256 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1683 :dets {:run {:m1 1686, :m2 1684, :m3 nil}, :bufs {:b1 [1685], :b2 [1683]}} :line 2441}
{:clk 2560.2089 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1686 :dets {:run {:m1 1686, :m2 1684, :m3 1683}, :bufs {:b1 [1685], :b2 []}} :line 2442}
{:clk 2560.2089 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2561.7089 :j 1687 :dets {:run {:m1 nil, :m2 1684, :m3 1683}, :bufs {:b1 [1685 1686], :b2 []}} :line 2443}
{:clk 2560.7089 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1684 :dets {:run {:m1 1687, :m2 1684, :m3 1683}, :bufs {:b1 [1685 1686], :b2 []}} :line 2444}
{:clk 2560.7089 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1685 :dets {:run {:m1 1687, :m2 nil, :m3 1683}, :bufs {:b1 [1685 1686], :b2 [1684]}} :line 2445}
{:clk 2561.6256 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2555.2089 :j 1683 :dets {:run {:m1 1687, :m2 1685, :m3 1683}, :bufs {:b1 [1686], :b2 [1684]}} :line 2446}
{:clk 2561.6256 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1684 :dets {:run {:m1 1687, :m2 1685, :m3 nil}, :bufs {:b1 [1686], :b2 [1684]}} :line 2447}
{:clk 2561.7089 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1687 :dets {:run {:m1 1687, :m2 1685, :m3 1684}, :bufs {:b1 [1686], :b2 []}} :line 2448}
{:clk 2561.7089 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2562.7089 :j 1688 :dets {:run {:m1 nil, :m2 1685, :m3 1684}, :bufs {:b1 [1686 1687], :b2 []}} :line 2449}
{:clk 2562.2089 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1685 :dets {:run {:m1 1688, :m2 1685, :m3 1684}, :bufs {:b1 [1686 1687], :b2 []}} :line 2450}
{:clk 2562.2089 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1686 :dets {:run {:m1 1688, :m2 nil, :m3 1684}, :bufs {:b1 [1686 1687], :b2 [1685]}} :line 2451}
{:clk 2562.6256 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2556.7089 :j 1684 :dets {:run {:m1 1688, :m2 1686, :m3 1684}, :bufs {:b1 [1687], :b2 [1685]}} :line 2452}
{:clk 2562.6256 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1685 :dets {:run {:m1 1688, :m2 1686, :m3 nil}, :bufs {:b1 [1687], :b2 [1685]}} :line 2453}
{:clk 2562.7089 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1688 :dets {:run {:m1 1688, :m2 1686, :m3 1685}, :bufs {:b1 [1687], :b2 []}} :line 2454}
{:clk 2562.7089 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2564.2089 :j 1689 :dets {:run {:m1 nil, :m2 1686, :m3 1685}, :bufs {:b1 [1687 1688], :b2 []}} :line 2455}
{:clk 2563.2089 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1686 :dets {:run {:m1 1689, :m2 1686, :m3 1685}, :bufs {:b1 [1687 1688], :b2 []}} :line 2456}
{:clk 2563.2089 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1687 :dets {:run {:m1 1689, :m2 nil, :m3 1685}, :bufs {:b1 [1687 1688], :b2 [1686]}} :line 2457}
{:clk 2564.1256 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2557.7089 :j 1685 :dets {:run {:m1 1689, :m2 1687, :m3 1685}, :bufs {:b1 [1688], :b2 [1686]}} :line 2458}
{:clk 2564.1256 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1686 :dets {:run {:m1 1689, :m2 1687, :m3 nil}, :bufs {:b1 [1688], :b2 [1686]}} :line 2459}
{:clk 2564.2089 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1689 :dets {:run {:m1 1689, :m2 1687, :m3 1686}, :bufs {:b1 [1688], :b2 []}} :line 2460}
{:clk 2564.2089 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2565.2089 :j 1690 :dets {:run {:m1 nil, :m2 1687, :m3 1686}, :bufs {:b1 [1688 1689], :b2 []}} :line 2461}
{:clk 2564.7089 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1687 :dets {:run {:m1 1690, :m2 1687, :m3 1686}, :bufs {:b1 [1688 1689], :b2 []}} :line 2462}
{:clk 2564.7089 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1688 :dets {:run {:m1 1690, :m2 nil, :m3 1686}, :bufs {:b1 [1688 1689], :b2 [1687]}} :line 2463}
{:clk 2565.1256 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2559.2089 :j 1686 :dets {:run {:m1 1690, :m2 1688, :m3 1686}, :bufs {:b1 [1689], :b2 [1687]}} :line 2464}
{:clk 2565.1256 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1687 :dets {:run {:m1 1690, :m2 1688, :m3 nil}, :bufs {:b1 [1689], :b2 [1687]}} :line 2465}
{:clk 2565.2089 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1690 :dets {:run {:m1 1690, :m2 1688, :m3 1687}, :bufs {:b1 [1689], :b2 []}} :line 2466}
{:clk 2565.2089 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2566.7089 :j 1691 :dets {:run {:m1 nil, :m2 1688, :m3 1687}, :bufs {:b1 [1689 1690], :b2 []}} :line 2467}
{:clk 2565.7089 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1688 :dets {:run {:m1 1691, :m2 1688, :m3 1687}, :bufs {:b1 [1689 1690], :b2 []}} :line 2468}
{:clk 2565.7089 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1689 :dets {:run {:m1 1691, :m2 nil, :m3 1687}, :bufs {:b1 [1689 1690], :b2 [1688]}} :line 2469}
{:clk 2566.6256 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2560.2089 :j 1687 :dets {:run {:m1 1691, :m2 1689, :m3 1687}, :bufs {:b1 [1690], :b2 [1688]}} :line 2470}
{:clk 2566.6256 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1688 :dets {:run {:m1 1691, :m2 1689, :m3 nil}, :bufs {:b1 [1690], :b2 [1688]}} :line 2471}
{:clk 2566.7089 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1691 :dets {:run {:m1 1691, :m2 1689, :m3 1688}, :bufs {:b1 [1690], :b2 []}} :line 2472}
{:clk 2566.7089 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2567.7089 :j 1692 :dets {:run {:m1 nil, :m2 1689, :m3 1688}, :bufs {:b1 [1690 1691], :b2 []}} :line 2473}
{:clk 2567.2089 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1689 :dets {:run {:m1 1692, :m2 1689, :m3 1688}, :bufs {:b1 [1690 1691], :b2 []}} :line 2474}
{:clk 2567.2089 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1690 :dets {:run {:m1 1692, :m2 nil, :m3 1688}, :bufs {:b1 [1690 1691], :b2 [1689]}} :line 2475}
{:clk 2567.6256 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2561.7089 :j 1688 :dets {:run {:m1 1692, :m2 1690, :m3 1688}, :bufs {:b1 [1691], :b2 [1689]}} :line 2476}
{:clk 2567.6256 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1689 :dets {:run {:m1 1692, :m2 1690, :m3 nil}, :bufs {:b1 [1691], :b2 [1689]}} :line 2477}
{:clk 2567.7089 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1692 :dets {:run {:m1 1692, :m2 1690, :m3 1689}, :bufs {:b1 [1691], :b2 []}} :line 2478}
{:clk 2567.7089 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2568.7089 :j 1693 :dets {:run {:m1 nil, :m2 1690, :m3 1689}, :bufs {:b1 [1691 1692], :b2 []}} :line 2479}
{:clk 2568.2089 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1690 :dets {:run {:m1 1693, :m2 1690, :m3 1689}, :bufs {:b1 [1691 1692], :b2 []}} :line 2480}
{:clk 2568.2089 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1691 :dets {:run {:m1 1693, :m2 nil, :m3 1689}, :bufs {:b1 [1691 1692], :b2 [1690]}} :line 2481}
{:clk 2568.7089 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1693 :dets {:run {:m1 1693, :m2 1691, :m3 1689}, :bufs {:b1 [1692], :b2 [1690]}} :line 2482}
{:clk 2568.7089 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2570.2089 :j 1694 :dets {:run {:m1 nil, :m2 1691, :m3 1689}, :bufs {:b1 [1692 1693], :b2 [1690]}} :line 2483}
{:clk 2569.1256 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2562.7089 :j 1689 :dets {:run {:m1 1694, :m2 1691, :m3 1689}, :bufs {:b1 [1692 1693], :b2 [1690]}} :line 2484}
{:clk 2569.1256 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1690 :dets {:run {:m1 1694, :m2 1691, :m3 nil}, :bufs {:b1 [1692 1693], :b2 [1690]}} :line 2485}
{:clk 2569.7089 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1691 :dets {:run {:m1 1694, :m2 1691, :m3 1690}, :bufs {:b1 [1692 1693], :b2 []}} :line 2486}
{:clk 2569.7089 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1692 :dets {:run {:m1 1694, :m2 nil, :m3 1690}, :bufs {:b1 [1692 1693], :b2 [1691]}} :line 2487}
{:clk 2570.1256 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2564.2089 :j 1690 :dets {:run {:m1 1694, :m2 1692, :m3 1690}, :bufs {:b1 [1693], :b2 [1691]}} :line 2488}
{:clk 2570.1256 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1691 :dets {:run {:m1 1694, :m2 1692, :m3 nil}, :bufs {:b1 [1693], :b2 [1691]}} :line 2489}
{:clk 2570.2089 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1694 :dets {:run {:m1 1694, :m2 1692, :m3 1691}, :bufs {:b1 [1693], :b2 []}} :line 2490}
{:clk 2570.2089 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2575.0851 :j 1695 :dets {:run {:m1 nil, :m2 1692, :m3 1691}, :bufs {:b1 [1693 1694], :b2 []}} :line 2491}
{:clk 2570.7089 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1692 :dets {:run {:m1 1695, :m2 1692, :m3 1691}, :bufs {:b1 [1693 1694], :b2 []}} :line 2492}
{:clk 2570.7089 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1693 :dets {:run {:m1 1695, :m2 nil, :m3 1691}, :bufs {:b1 [1693 1694], :b2 [1692]}} :line 2493}
{:clk 2571.6256 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2565.2089 :j 1691 :dets {:run {:m1 1695, :m2 1693, :m3 1691}, :bufs {:b1 [1694], :b2 [1692]}} :line 2494}
{:clk 2571.6256 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1692 :dets {:run {:m1 1695, :m2 1693, :m3 nil}, :bufs {:b1 [1694], :b2 [1692]}} :line 2495}
{:clk 2571.7089 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1693 :dets {:run {:m1 1695, :m2 1693, :m3 1692}, :bufs {:b1 [1694], :b2 []}} :line 2496}
{:clk 2571.7089 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1694 :dets {:run {:m1 1695, :m2 nil, :m3 1692}, :bufs {:b1 [1694], :b2 [1693]}} :line 2497}
{:clk 2572.6256 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2566.7089 :j 1692 :dets {:run {:m1 1695, :m2 1694, :m3 1692}, :bufs {:b1 [], :b2 [1693]}} :line 2498}
{:clk 2572.6256 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1693 :dets {:run {:m1 1695, :m2 1694, :m3 nil}, :bufs {:b1 [], :b2 [1693]}} :line 2499}
{:clk 2573.2089 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1694 :dets {:run {:m1 1695, :m2 1694, :m3 1693}, :bufs {:b1 [], :b2 []}} :line 2500}
{:clk 2573.2089 :act :m2-starved :m :m2 :mjpact :st :dets {:run {:m1 1695, :m2 nil, :m3 1693}, :bufs {:b1 [], :b2 [1694]}} :line 2501}
{:clk 2573.6256 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2567.7089 :j 1693 :dets {:run {:m1 1695, :m2 nil, :m3 1693}, :bufs {:b1 [], :b2 [1694]}} :line 2502}
{:clk 2573.6256 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1694 :dets {:run {:m1 1695, :m2 nil, :m3 nil}, :bufs {:b1 [], :b2 [1694]}} :line 2503}
{:clk 2575.0851 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1695 :dets {:run {:m1 1695, :m2 nil, :m3 1694}, :bufs {:b1 [], :b2 []}} :line 2504}
{:clk 2575.0851 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2576.0851 :j 1696 :dets {:run {:m1 nil, :m2 nil, :m3 1694}, :bufs {:b1 [1695], :b2 []}} :line 2505}
{:clk 2575.0851 :act :m2-unstarved :m :m2 :mjpact :us :dets {:run {:m1 1696, :m2 1695, :m3 1694}, :bufs {:b1 [], :b2 []}} :line 2506}
{:clk 2575.0851 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1695 :dets {:run {:m1 1696, :m2 nil, :m3 1694}, :bufs {:b1 [1695], :b2 []}} :line 2507}
{:clk 2575.1256 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2568.7089 :j 1694 :dets {:run {:m1 1696, :m2 1695, :m3 1694}, :bufs {:b1 [], :b2 []}} :line 2508}
{:clk 2575.1256 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1696, :m2 1695, :m3 nil}, :bufs {:b1 [], :b2 []}} :line 2509}
{:clk 2576.0851 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1696 :dets {:run {:m1 1696, :m2 1695, :m3 nil}, :bufs {:b1 [], :b2 []}} :line 2510}
{:clk 2576.0851 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2577.5851 :j 1697 :dets {:run {:m1 nil, :m2 1695, :m3 nil}, :bufs {:b1 [1696], :b2 []}} :line 2511}
{:clk 2576.5851 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1695 :dets {:run {:m1 1697, :m2 1695, :m3 nil}, :bufs {:b1 [1696], :b2 []}} :line 2512}
{:clk 2576.5851 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1696 :dets {:run {:m1 1697, :m2 nil, :m3 nil}, :bufs {:b1 [1696], :b2 [1695]}} :line 2513}
{:clk 2576.5851 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1697, :m2 1696, :m3 1695}, :bufs {:b1 [], :b2 []}} :line 2514}
{:clk 2576.5851 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1695 :dets {:run {:m1 1697, :m2 1696, :m3 nil}, :bufs {:b1 [], :b2 [1695]}} :line 2515}
{:clk 2577.5851 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1697 :dets {:run {:m1 1697, :m2 1696, :m3 1695}, :bufs {:b1 [], :b2 []}} :line 2516}
{:clk 2577.5851 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2578.5851 :j 1698 :dets {:run {:m1 nil, :m2 nil, :m3 1695}, :bufs {:b1 [1697], :b2 [1696]}} :line 2517}
{:clk 2577.5851 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1696 :dets {:run {:m1 nil, :m2 1696, :m3 1695}, :bufs {:b1 [1697], :b2 []}} :line 2518}
{:clk 2577.5851 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1697 :dets {:run {:m1 1698, :m2 nil, :m3 1695}, :bufs {:b1 [1697], :b2 [1696]}} :line 2519}
{:clk 2578.0851 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2570.2089 :j 1695 :dets {:run {:m1 1698, :m2 1697, :m3 1695}, :bufs {:b1 [], :b2 [1696]}} :line 2520}
{:clk 2578.0851 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1696 :dets {:run {:m1 1698, :m2 1697, :m3 nil}, :bufs {:b1 [], :b2 [1696]}} :line 2521}
{:clk 2578.5851 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1698 :dets {:run {:m1 1698, :m2 1697, :m3 1696}, :bufs {:b1 [], :b2 []}} :line 2522}
{:clk 2578.5851 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2579.5851 :j 1699 :dets {:run {:m1 nil, :m2 1697, :m3 1696}, :bufs {:b1 [1698], :b2 []}} :line 2523}
{:clk 2579.0851 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1697 :dets {:run {:m1 1699, :m2 1697, :m3 1696}, :bufs {:b1 [1698], :b2 []}} :line 2524}
{:clk 2579.0851 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1698 :dets {:run {:m1 1699, :m2 nil, :m3 1696}, :bufs {:b1 [1698], :b2 [1697]}} :line 2525}
{:clk 2579.5851 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1699 :dets {:run {:m1 1699, :m2 1698, :m3 1696}, :bufs {:b1 [], :b2 [1697]}} :line 2526}
{:clk 2579.5851 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2583.5786 :j 1700 :dets {:run {:m1 nil, :m2 1698, :m3 1696}, :bufs {:b1 [1699], :b2 [1697]}} :line 2527}
{:clk 2580.0851 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1698 :dets {:run {:m1 1700, :m2 1698, :m3 1696}, :bufs {:b1 [1699], :b2 [1697]}} :line 2528}
{:clk 2580.0851 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1699 :dets {:run {:m1 1700, :m2 nil, :m3 1696}, :bufs {:b1 [1699], :b2 [1697 1698]}} :line 2529}
{:clk 2580.3675 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2575.0851 :j 1696 :dets {:run {:m1 1700, :m2 1699, :m3 1696}, :bufs {:b1 [], :b2 [1697 1698]}} :line 2530}
{:clk 2580.3675 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1697 :dets {:run {:m1 1700, :m2 1699, :m3 nil}, :bufs {:b1 [], :b2 [1697 1698]}} :line 2531}
{:clk 2581.0851 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1699 :dets {:run {:m1 1700, :m2 1699, :m3 1697}, :bufs {:b1 [], :b2 [1698]}} :line 2532}
{:clk 2581.0851 :act :m2-starved :m :m2 :mjpact :st :dets {:run {:m1 1700, :m2 nil, :m3 1697}, :bufs {:b1 [], :b2 [1698 1699]}} :line 2533}
{:clk 2581.8675 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2576.0851 :j 1697 :dets {:run {:m1 1700, :m2 nil, :m3 1697}, :bufs {:b1 [], :b2 [1698 1699]}} :line 2534}
{:clk 2581.8675 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1698 :dets {:run {:m1 1700, :m2 nil, :m3 nil}, :bufs {:b1 [], :b2 [1698 1699]}} :line 2535}
{:clk 2582.8675 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2577.5851 :j 1698 :dets {:run {:m1 1700, :m2 nil, :m3 1698}, :bufs {:b1 [], :b2 [1699]}} :line 2536}
{:clk 2582.8675 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1699 :dets {:run {:m1 1700, :m2 nil, :m3 nil}, :bufs {:b1 [], :b2 [1699]}} :line 2537}
{:clk 2583.5786 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1700 :dets {:run {:m1 1700, :m2 nil, :m3 1699}, :bufs {:b1 [], :b2 []}} :line 2538}
{:clk 2583.5786 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2585.3117 :j 1701 :dets {:run {:m1 nil, :m2 nil, :m3 1699}, :bufs {:b1 [1700], :b2 []}} :line 2539}
{:clk 2583.5786 :act :m2-unstarved :m :m2 :mjpact :us :dets {:run {:m1 1701, :m2 nil, :m3 1699}, :bufs {:b1 [1700], :b2 []}} :line 2540}
{:clk 2585.3117 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1701 :dets {:run {:m1 1701, :m2 nil, :m3 1699}, :bufs {:b1 [1700], :b2 []}} :line 2541}
{:clk 2585.3117 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2586.8117 :j 1702 :dets {:run {:m1 nil, :m2 nil, :m3 1699}, :bufs {:b1 [1700 1701], :b2 []}} :line 2542}
{:clk 2585.6419 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1700 :dets {:run {:m1 1702, :m2 nil, :m3 1699}, :bufs {:b1 [1700 1701], :b2 []}} :line 2543}
{:clk 2586.4848 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2578.5851 :j 1699 :dets {:run {:m1 1702, :m2 1700, :m3 1699}, :bufs {:b1 [1701], :b2 []}} :line 2544}
{:clk 2586.4848 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1702, :m2 1700, :m3 nil}, :bufs {:b1 [1701], :b2 []}} :line 2545}
{:clk 2586.8117 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1702 :dets {:run {:m1 1702, :m2 1700, :m3 nil}, :bufs {:b1 [1701], :b2 []}} :line 2546}
{:clk 2586.8117 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2588.3117 :j 1703 :dets {:run {:m1 nil, :m2 1700, :m3 nil}, :bufs {:b1 [1701 1702], :b2 []}} :line 2547}
{:clk 2587.5887 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1700 :dets {:run {:m1 1703, :m2 1700, :m3 nil}, :bufs {:b1 [1701 1702], :b2 []}} :line 2548}
{:clk 2587.5887 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1701 :dets {:run {:m1 1703, :m2 nil, :m3 nil}, :bufs {:b1 [1701 1702], :b2 [1700]}} :line 2549}
{:clk 2587.5887 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1703, :m2 1701, :m3 1700}, :bufs {:b1 [1702], :b2 []}} :line 2550}
{:clk 2587.5887 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1700 :dets {:run {:m1 1703, :m2 1701, :m3 nil}, :bufs {:b1 [1702], :b2 [1700]}} :line 2551}
{:clk 2588.3117 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1703 :dets {:run {:m1 1703, :m2 1701, :m3 1700}, :bufs {:b1 [1702], :b2 []}} :line 2552}
{:clk 2588.3117 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2589.3117 :j 1704 :dets {:run {:m1 nil, :m2 1701, :m3 1700}, :bufs {:b1 [1702 1703], :b2 []}} :line 2553}
{:clk 2588.5887 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1701 :dets {:run {:m1 1704, :m2 1701, :m3 1700}, :bufs {:b1 [1702 1703], :b2 []}} :line 2554}
{:clk 2588.5887 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1702 :dets {:run {:m1 1704, :m2 nil, :m3 1700}, :bufs {:b1 [1702 1703], :b2 [1701]}} :line 2555}
{:clk 2589.0887 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2579.5851 :j 1700 :dets {:run {:m1 1704, :m2 1702, :m3 1700}, :bufs {:b1 [1703], :b2 [1701]}} :line 2556}
{:clk 2589.0887 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1701 :dets {:run {:m1 1704, :m2 1702, :m3 nil}, :bufs {:b1 [1703], :b2 [1701]}} :line 2557}
{:clk 2589.3117 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1704 :dets {:run {:m1 1704, :m2 1702, :m3 1701}, :bufs {:b1 [1703], :b2 []}} :line 2558}
{:clk 2589.3117 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2590.3117 :j 1705 :dets {:run {:m1 nil, :m2 1702, :m3 1701}, :bufs {:b1 [1703 1704], :b2 []}} :line 2559}
{:clk 2590.0887 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1702 :dets {:run {:m1 1705, :m2 1702, :m3 1701}, :bufs {:b1 [1703 1704], :b2 []}} :line 2560}
{:clk 2590.0887 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1703 :dets {:run {:m1 1705, :m2 nil, :m3 nil}, :bufs {:b1 [1703 1704], :b2 [1702]}} :line 2561}
{:clk 2590.0887 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2583.5786 :j 1701 :dets {:run {:m1 1705, :m2 nil, :m3 1701}, :bufs {:b1 [1703 1704], :b2 [1702]}} :line 2562}
{:clk 2590.0887 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1702 :dets {:run {:m1 1705, :m2 1703, :m3 nil}, :bufs {:b1 [1704], :b2 [1702]}} :line 2563}
{:clk 2590.3117 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1705 :dets {:run {:m1 1705, :m2 1703, :m3 1702}, :bufs {:b1 [1704], :b2 []}} :line 2564}
{:clk 2590.3117 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2591.8117 :j 1706 :dets {:run {:m1 nil, :m2 1703, :m3 1702}, :bufs {:b1 [1704 1705], :b2 []}} :line 2565}
{:clk 2591.5887 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1703 :dets {:run {:m1 1706, :m2 1703, :m3 1702}, :bufs {:b1 [1704 1705], :b2 []}} :line 2566}
{:clk 2591.5887 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1704 :dets {:run {:m1 1706, :m2 nil, :m3 nil}, :bufs {:b1 [1704 1705], :b2 [1703]}} :line 2567}
{:clk 2591.5887 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2585.3117 :j 1702 :dets {:run {:m1 1706, :m2 nil, :m3 1702}, :bufs {:b1 [1704 1705], :b2 [1703]}} :line 2568}
{:clk 2591.5887 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1703 :dets {:run {:m1 1706, :m2 1704, :m3 nil}, :bufs {:b1 [1705], :b2 [1703]}} :line 2569}
{:clk 2591.8117 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1706 :dets {:run {:m1 1706, :m2 1704, :m3 1703}, :bufs {:b1 [1705], :b2 []}} :line 2570}
{:clk 2591.8117 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2592.8117 :j 1707 :dets {:run {:m1 nil, :m2 1704, :m3 1703}, :bufs {:b1 [1705 1706], :b2 []}} :line 2571}
{:clk 2592.5887 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1704 :dets {:run {:m1 1707, :m2 1704, :m3 1703}, :bufs {:b1 [1705 1706], :b2 []}} :line 2572}
{:clk 2592.5887 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1705 :dets {:run {:m1 1707, :m2 nil, :m3 1703}, :bufs {:b1 [1705 1706], :b2 [1704]}} :line 2573}
{:clk 2592.8117 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1707 :dets {:run {:m1 1707, :m2 1705, :m3 1703}, :bufs {:b1 [1706], :b2 [1704]}} :line 2574}
{:clk 2592.8117 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2594.5389 :j 1708 :dets {:run {:m1 nil, :m2 1705, :m3 1703}, :bufs {:b1 [1706 1707], :b2 [1704]}} :line 2575}
{:clk 2593.0887 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2586.8117 :j 1703 :dets {:run {:m1 1708, :m2 1705, :m3 1703}, :bufs {:b1 [1706 1707], :b2 [1704]}} :line 2576}
{:clk 2593.0887 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1704 :dets {:run {:m1 1708, :m2 1705, :m3 nil}, :bufs {:b1 [1706 1707], :b2 [1704]}} :line 2577}
{:clk 2593.5887 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1705 :dets {:run {:m1 1708, :m2 1705, :m3 1704}, :bufs {:b1 [1706 1707], :b2 []}} :line 2578}
{:clk 2593.5887 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1706 :dets {:run {:m1 1708, :m2 nil, :m3 1704}, :bufs {:b1 [1706 1707], :b2 [1705]}} :line 2579}
{:clk 2594.0887 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2588.3117 :j 1704 :dets {:run {:m1 1708, :m2 1706, :m3 1704}, :bufs {:b1 [1707], :b2 [1705]}} :line 2580}
{:clk 2594.0887 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1705 :dets {:run {:m1 1708, :m2 1706, :m3 nil}, :bufs {:b1 [1707], :b2 [1705]}} :line 2581}
{:clk 2594.5389 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1708 :dets {:run {:m1 1708, :m2 1706, :m3 1705}, :bufs {:b1 [1707], :b2 []}} :line 2582}
{:clk 2594.5389 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2595.5389 :j 1709 :dets {:run {:m1 nil, :m2 1706, :m3 1705}, :bufs {:b1 [1707 1708], :b2 []}} :line 2583}
{:clk 2595.0887 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1706 :dets {:run {:m1 1709, :m2 1706, :m3 1705}, :bufs {:b1 [1707 1708], :b2 []}} :line 2584}
{:clk 2595.0887 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1707 :dets {:run {:m1 1709, :m2 nil, :m3 nil}, :bufs {:b1 [1707 1708], :b2 [1706]}} :line 2585}
{:clk 2595.0887 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2589.3117 :j 1705 :dets {:run {:m1 1709, :m2 nil, :m3 1705}, :bufs {:b1 [1707 1708], :b2 [1706]}} :line 2586}
{:clk 2595.0887 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1706 :dets {:run {:m1 1709, :m2 1707, :m3 nil}, :bufs {:b1 [1708], :b2 [1706]}} :line 2587}
{:clk 2595.5389 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1709 :dets {:run {:m1 1709, :m2 1707, :m3 1706}, :bufs {:b1 [1708], :b2 []}} :line 2588}
{:clk 2595.5389 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2597.0389 :j 1710 :dets {:run {:m1 nil, :m2 1707, :m3 1706}, :bufs {:b1 [1708 1709], :b2 []}} :line 2589}
{:clk 2596.0887 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1707 :dets {:run {:m1 1710, :m2 1707, :m3 1706}, :bufs {:b1 [1708 1709], :b2 []}} :line 2590}
{:clk 2596.0887 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1708 :dets {:run {:m1 1710, :m2 nil, :m3 1706}, :bufs {:b1 [1708 1709], :b2 [1707]}} :line 2591}
{:clk 2596.5887 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2590.3117 :j 1706 :dets {:run {:m1 1710, :m2 1708, :m3 1706}, :bufs {:b1 [1709], :b2 [1707]}} :line 2592}
{:clk 2596.5887 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1707 :dets {:run {:m1 1710, :m2 1708, :m3 nil}, :bufs {:b1 [1709], :b2 [1707]}} :line 2593}
{:clk 2597.0389 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1710 :dets {:run {:m1 1710, :m2 1708, :m3 1707}, :bufs {:b1 [1709], :b2 []}} :line 2594}
{:clk 2597.0389 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2598.0389 :j 1711 :dets {:run {:m1 nil, :m2 1708, :m3 1707}, :bufs {:b1 [1709 1710], :b2 []}} :line 2595}
{:clk 2597.5887 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1708 :dets {:run {:m1 1711, :m2 1708, :m3 1707}, :bufs {:b1 [1709 1710], :b2 []}} :line 2596}
{:clk 2597.5887 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1709 :dets {:run {:m1 1711, :m2 nil, :m3 nil}, :bufs {:b1 [1709 1710], :b2 [1708]}} :line 2597}
{:clk 2597.5887 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2591.8117 :j 1707 :dets {:run {:m1 1711, :m2 nil, :m3 1707}, :bufs {:b1 [1709 1710], :b2 [1708]}} :line 2598}
{:clk 2597.5887 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1708 :dets {:run {:m1 1711, :m2 1709, :m3 nil}, :bufs {:b1 [1710], :b2 [1708]}} :line 2599}
{:clk 2598.0389 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1711 :dets {:run {:m1 1711, :m2 1709, :m3 1708}, :bufs {:b1 [1710], :b2 []}} :line 2600}
{:clk 2598.0389 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2599.6555 :j 1712 :dets {:run {:m1 nil, :m2 1709, :m3 1708}, :bufs {:b1 [1710 1711], :b2 []}} :line 2601}
{:clk 2598.5887 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1709 :dets {:run {:m1 1712, :m2 1709, :m3 1708}, :bufs {:b1 [1710 1711], :b2 []}} :line 2602}
{:clk 2598.5887 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1710 :dets {:run {:m1 1712, :m2 nil, :m3 1708}, :bufs {:b1 [1710 1711], :b2 [1709]}} :line 2603}
{:clk 2599.0887 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2592.8117 :j 1708 :dets {:run {:m1 1712, :m2 1710, :m3 1708}, :bufs {:b1 [1711], :b2 [1709]}} :line 2604}
{:clk 2599.0887 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1709 :dets {:run {:m1 1712, :m2 1710, :m3 nil}, :bufs {:b1 [1711], :b2 [1709]}} :line 2605}
{:clk 2599.6555 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1712 :dets {:run {:m1 1712, :m2 1710, :m3 1709}, :bufs {:b1 [1711], :b2 []}} :line 2606}
{:clk 2599.6555 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2600.6555 :j 1713 :dets {:run {:m1 nil, :m2 1710, :m3 1709}, :bufs {:b1 [1711 1712], :b2 []}} :line 2607}
{:clk 2600.0887 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1710 :dets {:run {:m1 1713, :m2 1710, :m3 1709}, :bufs {:b1 [1711 1712], :b2 []}} :line 2608}
{:clk 2600.0887 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1711 :dets {:run {:m1 1713, :m2 nil, :m3 nil}, :bufs {:b1 [1711 1712], :b2 [1710]}} :line 2609}
{:clk 2600.0887 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2594.5389 :j 1709 :dets {:run {:m1 1713, :m2 nil, :m3 1709}, :bufs {:b1 [1711 1712], :b2 [1710]}} :line 2610}
{:clk 2600.0887 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1710 :dets {:run {:m1 1713, :m2 1711, :m3 nil}, :bufs {:b1 [1712], :b2 [1710]}} :line 2611}
{:clk 2600.6555 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1713 :dets {:run {:m1 1713, :m2 1711, :m3 1710}, :bufs {:b1 [1712], :b2 []}} :line 2612}
{:clk 2600.6555 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2601.6555 :j 1714 :dets {:run {:m1 nil, :m2 1711, :m3 1710}, :bufs {:b1 [1712 1713], :b2 []}} :line 2613}
{:clk 2601.0887 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1711 :dets {:run {:m1 1714, :m2 1711, :m3 1710}, :bufs {:b1 [1712 1713], :b2 []}} :line 2614}
{:clk 2601.0887 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1712 :dets {:run {:m1 1714, :m2 nil, :m3 1710}, :bufs {:b1 [1712 1713], :b2 [1711]}} :line 2615}
{:clk 2601.5887 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2595.5389 :j 1710 :dets {:run {:m1 1714, :m2 1712, :m3 1710}, :bufs {:b1 [1713], :b2 [1711]}} :line 2616}
{:clk 2601.5887 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1711 :dets {:run {:m1 1714, :m2 1712, :m3 nil}, :bufs {:b1 [1713], :b2 [1711]}} :line 2617}
{:clk 2601.6555 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1714 :dets {:run {:m1 1714, :m2 1712, :m3 1711}, :bufs {:b1 [1713], :b2 []}} :line 2618}
{:clk 2601.6555 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2602.6555 :j 1715 :dets {:run {:m1 nil, :m2 1712, :m3 1711}, :bufs {:b1 [1713 1714], :b2 []}} :line 2619}
{:clk 2602.0887 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1712 :dets {:run {:m1 1715, :m2 1712, :m3 1711}, :bufs {:b1 [1713 1714], :b2 []}} :line 2620}
{:clk 2602.0887 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1713 :dets {:run {:m1 1715, :m2 nil, :m3 1711}, :bufs {:b1 [1713 1714], :b2 [1712]}} :line 2621}
{:clk 2602.5887 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2597.0389 :j 1711 :dets {:run {:m1 1715, :m2 1713, :m3 1711}, :bufs {:b1 [1714], :b2 [1712]}} :line 2622}
{:clk 2602.5887 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1712 :dets {:run {:m1 1715, :m2 1713, :m3 nil}, :bufs {:b1 [1714], :b2 [1712]}} :line 2623}
{:clk 2602.6555 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1715 :dets {:run {:m1 1715, :m2 1713, :m3 1712}, :bufs {:b1 [1714], :b2 []}} :line 2624}
{:clk 2602.6555 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2604.1555 :j 1716 :dets {:run {:m1 nil, :m2 1713, :m3 1712}, :bufs {:b1 [1714 1715], :b2 []}} :line 2625}
{:clk 2603.0887 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1713 :dets {:run {:m1 1716, :m2 1713, :m3 1712}, :bufs {:b1 [1714 1715], :b2 []}} :line 2626}
{:clk 2603.0887 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1714 :dets {:run {:m1 1716, :m2 nil, :m3 1712}, :bufs {:b1 [1714 1715], :b2 [1713]}} :line 2627}
{:clk 2603.5887 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2598.0389 :j 1712 :dets {:run {:m1 1716, :m2 1714, :m3 1712}, :bufs {:b1 [1715], :b2 [1713]}} :line 2628}
{:clk 2603.5887 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1713 :dets {:run {:m1 1716, :m2 1714, :m3 nil}, :bufs {:b1 [1715], :b2 [1713]}} :line 2629}
{:clk 2604.0887 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1714 :dets {:run {:m1 1716, :m2 1714, :m3 1713}, :bufs {:b1 [1715], :b2 []}} :line 2630}
{:clk 2604.0887 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1715 :dets {:run {:m1 1716, :m2 nil, :m3 1713}, :bufs {:b1 [1715], :b2 [1714]}} :line 2631}
{:clk 2604.1555 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1716 :dets {:run {:m1 1716, :m2 1715, :m3 1713}, :bufs {:b1 [], :b2 [1714]}} :line 2632}
{:clk 2604.1555 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2605.1555 :j 1717 :dets {:run {:m1 nil, :m2 1715, :m3 1713}, :bufs {:b1 [1716], :b2 [1714]}} :line 2633}
{:clk 2604.5887 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2599.6555 :j 1713 :dets {:run {:m1 1717, :m2 1715, :m3 1713}, :bufs {:b1 [1716], :b2 [1714]}} :line 2634}
{:clk 2604.5887 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1714 :dets {:run {:m1 1717, :m2 1715, :m3 nil}, :bufs {:b1 [1716], :b2 [1714]}} :line 2635}
{:clk 2605.0887 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1715 :dets {:run {:m1 1717, :m2 1715, :m3 1714}, :bufs {:b1 [1716], :b2 []}} :line 2636}
{:clk 2605.0887 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1716 :dets {:run {:m1 1717, :m2 nil, :m3 1714}, :bufs {:b1 [1716], :b2 [1715]}} :line 2637}
{:clk 2605.1555 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1717 :dets {:run {:m1 1717, :m2 1716, :m3 1714}, :bufs {:b1 [], :b2 [1715]}} :line 2638}
{:clk 2605.1555 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2606.1555 :j 1718 :dets {:run {:m1 nil, :m2 1716, :m3 1714}, :bufs {:b1 [1717], :b2 [1715]}} :line 2639}
{:clk 2605.5887 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2600.6555 :j 1714 :dets {:run {:m1 1718, :m2 1716, :m3 1714}, :bufs {:b1 [1717], :b2 [1715]}} :line 2640}
{:clk 2605.5887 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1715 :dets {:run {:m1 1718, :m2 1716, :m3 nil}, :bufs {:b1 [1717], :b2 [1715]}} :line 2641}
{:clk 2606.1555 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1718 :dets {:run {:m1 1718, :m2 1716, :m3 1715}, :bufs {:b1 [1717], :b2 []}} :line 2642}
{:clk 2606.1555 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2607.6555 :j 1719 :dets {:run {:m1 nil, :m2 1716, :m3 1715}, :bufs {:b1 [1717 1718], :b2 []}} :line 2643}
{:clk 2606.5887 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1716 :dets {:run {:m1 1719, :m2 1716, :m3 1715}, :bufs {:b1 [1717 1718], :b2 []}} :line 2644}
{:clk 2606.5887 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1717 :dets {:run {:m1 1719, :m2 nil, :m3 1715}, :bufs {:b1 [1717 1718], :b2 [1716]}} :line 2645}
{:clk 2606.7274 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2601.6555 :j 1715 :dets {:run {:m1 1719, :m2 1717, :m3 1715}, :bufs {:b1 [1718], :b2 [1716]}} :line 2646}
{:clk 2606.7274 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1716 :dets {:run {:m1 1719, :m2 1717, :m3 nil}, :bufs {:b1 [1718], :b2 [1716]}} :line 2647}
{:clk 2607.6555 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1719 :dets {:run {:m1 1719, :m2 1717, :m3 1716}, :bufs {:b1 [1718], :b2 []}} :line 2648}
{:clk 2607.6555 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2609.1555 :j 1720 :dets {:run {:m1 nil, :m2 1717, :m3 1716}, :bufs {:b1 [1718 1719], :b2 []}} :line 2649}
{:clk 2608.1711 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1717 :dets {:run {:m1 1720, :m2 1717, :m3 1716}, :bufs {:b1 [1718 1719], :b2 []}} :line 2650}
{:clk 2608.1711 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1718 :dets {:run {:m1 1720, :m2 nil, :m3 1716}, :bufs {:b1 [1718 1719], :b2 [1717]}} :line 2651}
{:clk 2608.2274 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2602.6555 :j 1716 :dets {:run {:m1 1720, :m2 1718, :m3 1716}, :bufs {:b1 [1719], :b2 [1717]}} :line 2652}
{:clk 2608.2274 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1717 :dets {:run {:m1 1720, :m2 1718, :m3 nil}, :bufs {:b1 [1719], :b2 [1717]}} :line 2653}
{:clk 2609.1555 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1720 :dets {:run {:m1 1720, :m2 1718, :m3 1717}, :bufs {:b1 [1719], :b2 []}} :line 2654}
{:clk 2609.1555 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2610.6555 :j 1721 :dets {:run {:m1 nil, :m2 1718, :m3 1717}, :bufs {:b1 [1719 1720], :b2 []}} :line 2655}
{:clk 2609.1711 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1718 :dets {:run {:m1 1721, :m2 1718, :m3 1717}, :bufs {:b1 [1719 1720], :b2 []}} :line 2656}
{:clk 2609.1711 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1719 :dets {:run {:m1 1721, :m2 nil, :m3 1717}, :bufs {:b1 [1719 1720], :b2 [1718]}} :line 2657}
{:clk 2610.4832 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2604.1555 :j 1717 :dets {:run {:m1 1721, :m2 1719, :m3 1717}, :bufs {:b1 [1720], :b2 [1718]}} :line 2658}
{:clk 2610.4832 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1718 :dets {:run {:m1 1721, :m2 1719, :m3 nil}, :bufs {:b1 [1720], :b2 [1718]}} :line 2659}
{:clk 2610.6555 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1721 :dets {:run {:m1 1721, :m2 1719, :m3 1718}, :bufs {:b1 [1720], :b2 []}} :line 2660}
{:clk 2610.6555 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2611.6555 :j 1722 :dets {:run {:m1 nil, :m2 1719, :m3 1718}, :bufs {:b1 [1720 1721], :b2 []}} :line 2661}
{:clk 2610.6711 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1719 :dets {:run {:m1 1722, :m2 1719, :m3 1718}, :bufs {:b1 [1720 1721], :b2 []}} :line 2662}
{:clk 2610.6711 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1720 :dets {:run {:m1 1722, :m2 nil, :m3 1718}, :bufs {:b1 [1720 1721], :b2 [1719]}} :line 2663}
{:clk 2611.4832 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2605.1555 :j 1718 :dets {:run {:m1 1722, :m2 1720, :m3 1718}, :bufs {:b1 [1721], :b2 [1719]}} :line 2664}
{:clk 2611.4832 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1719 :dets {:run {:m1 1722, :m2 1720, :m3 nil}, :bufs {:b1 [1721], :b2 [1719]}} :line 2665}
{:clk 2611.6555 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1722 :dets {:run {:m1 1722, :m2 1720, :m3 1719}, :bufs {:b1 [1721], :b2 []}} :line 2666}
{:clk 2611.6555 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2613.1555 :j 1723 :dets {:run {:m1 nil, :m2 1720, :m3 1719}, :bufs {:b1 [1721 1722], :b2 []}} :line 2667}
{:clk 2612.1711 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1720 :dets {:run {:m1 1723, :m2 1720, :m3 1719}, :bufs {:b1 [1721 1722], :b2 []}} :line 2668}
{:clk 2612.1711 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1721 :dets {:run {:m1 1723, :m2 nil, :m3 1719}, :bufs {:b1 [1721 1722], :b2 [1720]}} :line 2669}
{:clk 2612.9832 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2606.1555 :j 1719 :dets {:run {:m1 1723, :m2 1721, :m3 1719}, :bufs {:b1 [1722], :b2 [1720]}} :line 2670}
{:clk 2612.9832 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1720 :dets {:run {:m1 1723, :m2 1721, :m3 nil}, :bufs {:b1 [1722], :b2 [1720]}} :line 2671}
{:clk 2613.1555 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1723 :dets {:run {:m1 1723, :m2 1721, :m3 1720}, :bufs {:b1 [1722], :b2 []}} :line 2672}
{:clk 2613.1555 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2614.6555 :j 1724 :dets {:run {:m1 nil, :m2 1721, :m3 1720}, :bufs {:b1 [1722 1723], :b2 []}} :line 2673}
{:clk 2613.6711 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1721 :dets {:run {:m1 1724, :m2 1721, :m3 1720}, :bufs {:b1 [1722 1723], :b2 []}} :line 2674}
{:clk 2613.6711 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1722 :dets {:run {:m1 1724, :m2 nil, :m3 1720}, :bufs {:b1 [1722 1723], :b2 [1721]}} :line 2675}
{:clk 2614.4832 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2607.6555 :j 1720 :dets {:run {:m1 1724, :m2 1722, :m3 1720}, :bufs {:b1 [1723], :b2 [1721]}} :line 2676}
{:clk 2614.4832 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1721 :dets {:run {:m1 1724, :m2 1722, :m3 nil}, :bufs {:b1 [1723], :b2 [1721]}} :line 2677}
{:clk 2614.6555 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1724 :dets {:run {:m1 1724, :m2 1722, :m3 1721}, :bufs {:b1 [1723], :b2 []}} :line 2678}
{:clk 2614.6555 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2616.1555 :j 1725 :dets {:run {:m1 nil, :m2 1722, :m3 1721}, :bufs {:b1 [1723 1724], :b2 []}} :line 2679}
{:clk 2614.6711 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1722 :dets {:run {:m1 1725, :m2 1722, :m3 1721}, :bufs {:b1 [1723 1724], :b2 []}} :line 2680}
{:clk 2614.6711 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1723 :dets {:run {:m1 1725, :m2 nil, :m3 1721}, :bufs {:b1 [1723 1724], :b2 [1722]}} :line 2681}
{:clk 2615.9832 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2609.1555 :j 1721 :dets {:run {:m1 1725, :m2 1723, :m3 1721}, :bufs {:b1 [1724], :b2 [1722]}} :line 2682}
{:clk 2615.9832 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1722 :dets {:run {:m1 1725, :m2 1723, :m3 nil}, :bufs {:b1 [1724], :b2 [1722]}} :line 2683}
{:clk 2616.1555 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1725 :dets {:run {:m1 1725, :m2 1723, :m3 1722}, :bufs {:b1 [1724], :b2 []}} :line 2684}
{:clk 2616.1555 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2617.6555 :j 1726 :dets {:run {:m1 nil, :m2 1723, :m3 1722}, :bufs {:b1 [1724 1725], :b2 []}} :line 2685}
{:clk 2616.1711 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1723 :dets {:run {:m1 1726, :m2 1723, :m3 1722}, :bufs {:b1 [1724 1725], :b2 []}} :line 2686}
{:clk 2616.1711 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1724 :dets {:run {:m1 1726, :m2 nil, :m3 1722}, :bufs {:b1 [1724 1725], :b2 [1723]}} :line 2687}
{:clk 2616.9832 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2610.6555 :j 1722 :dets {:run {:m1 1726, :m2 1724, :m3 1722}, :bufs {:b1 [1725], :b2 [1723]}} :line 2688}
{:clk 2616.9832 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1723 :dets {:run {:m1 1726, :m2 1724, :m3 nil}, :bufs {:b1 [1725], :b2 [1723]}} :line 2689}
{:clk 2617.6555 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1726 :dets {:run {:m1 1726, :m2 1724, :m3 1723}, :bufs {:b1 [1725], :b2 []}} :line 2690}
{:clk 2617.6555 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2618.6555 :j 1727 :dets {:run {:m1 nil, :m2 1724, :m3 1723}, :bufs {:b1 [1725 1726], :b2 []}} :line 2691}
{:clk 2617.6711 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1724 :dets {:run {:m1 1727, :m2 1724, :m3 1723}, :bufs {:b1 [1725 1726], :b2 []}} :line 2692}
{:clk 2617.6711 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1725 :dets {:run {:m1 1727, :m2 nil, :m3 1723}, :bufs {:b1 [1725 1726], :b2 [1724]}} :line 2693}
{:clk 2618.6555 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1727 :dets {:run {:m1 1727, :m2 1725, :m3 1723}, :bufs {:b1 [1726], :b2 [1724]}} :line 2694}
{:clk 2618.6555 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2620.1555 :j 1728 :dets {:run {:m1 nil, :m2 1725, :m3 1723}, :bufs {:b1 [1726 1727], :b2 [1724]}} :line 2695}
{:clk 2618.8092 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2611.6555 :j 1723 :dets {:run {:m1 1728, :m2 1725, :m3 1723}, :bufs {:b1 [1726 1727], :b2 [1724]}} :line 2696}
{:clk 2618.8092 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1724 :dets {:run {:m1 1728, :m2 1725, :m3 nil}, :bufs {:b1 [1726 1727], :b2 [1724]}} :line 2697}
{:clk 2619.1711 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1725 :dets {:run {:m1 1728, :m2 1725, :m3 1724}, :bufs {:b1 [1726 1727], :b2 []}} :line 2698}
{:clk 2619.1711 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1726 :dets {:run {:m1 1728, :m2 nil, :m3 1724}, :bufs {:b1 [1726 1727], :b2 [1725]}} :line 2699}
{:clk 2620.1555 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1728 :dets {:run {:m1 1728, :m2 1726, :m3 1724}, :bufs {:b1 [1727], :b2 [1725]}} :line 2700}
{:clk 2620.1555 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2621.6555 :j 1729 :dets {:run {:m1 nil, :m2 1726, :m3 1724}, :bufs {:b1 [1727 1728], :b2 [1725]}} :line 2701}
{:clk 2620.3092 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2613.1555 :j 1724 :dets {:run {:m1 1729, :m2 1726, :m3 1724}, :bufs {:b1 [1727 1728], :b2 [1725]}} :line 2702}
{:clk 2620.3092 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1725 :dets {:run {:m1 1729, :m2 1726, :m3 nil}, :bufs {:b1 [1727 1728], :b2 [1725]}} :line 2703}
{:clk 2620.6711 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1726 :dets {:run {:m1 1729, :m2 1726, :m3 1725}, :bufs {:b1 [1727 1728], :b2 []}} :line 2704}
{:clk 2620.6711 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1727 :dets {:run {:m1 1729, :m2 nil, :m3 1725}, :bufs {:b1 [1727 1728], :b2 [1726]}} :line 2705}
{:clk 2621.6555 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1729 :dets {:run {:m1 1729, :m2 1727, :m3 1725}, :bufs {:b1 [1728], :b2 [1726]}} :line 2706}
{:clk 2621.6555 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2623.1555 :j 1730 :dets {:run {:m1 nil, :m2 1727, :m3 1725}, :bufs {:b1 [1728 1729], :b2 [1726]}} :line 2707}
{:clk 2621.6711 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1727 :dets {:run {:m1 1730, :m2 1727, :m3 1725}, :bufs {:b1 [1728 1729], :b2 [1726]}} :line 2708}
{:clk 2621.6711 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1728 :dets {:run {:m1 1730, :m2 nil, :m3 1725}, :bufs {:b1 [1728 1729], :b2 [1726 1727]}} :line 2709}
{:clk 2621.8092 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2614.6555 :j 1725 :dets {:run {:m1 1730, :m2 1728, :m3 1725}, :bufs {:b1 [1729], :b2 [1726 1727]}} :line 2710}
{:clk 2621.8092 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1726 :dets {:run {:m1 1730, :m2 1728, :m3 nil}, :bufs {:b1 [1729], :b2 [1726 1727]}} :line 2711}
{:clk 2623.1555 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1730 :dets {:run {:m1 1730, :m2 1728, :m3 1726}, :bufs {:b1 [1729], :b2 [1727]}} :line 2712}
{:clk 2623.1555 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2626.2741 :j 1731 :dets {:run {:m1 nil, :m2 1728, :m3 1726}, :bufs {:b1 [1729 1730], :b2 [1727]}} :line 2713}
{:clk 2623.1711 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1728 :dets {:run {:m1 1731, :m2 1728, :m3 1726}, :bufs {:b1 [1729 1730], :b2 [1727]}} :line 2714}
{:clk 2623.1711 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1729 :dets {:run {:m1 1731, :m2 nil, :m3 1726}, :bufs {:b1 [1729 1730], :b2 [1727 1728]}} :line 2715}
{:clk 2624.4402 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2616.1555 :j 1726 :dets {:run {:m1 1731, :m2 1729, :m3 1726}, :bufs {:b1 [1730], :b2 [1727 1728]}} :line 2716}
{:clk 2624.4402 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1727 :dets {:run {:m1 1731, :m2 1729, :m3 nil}, :bufs {:b1 [1730], :b2 [1727 1728]}} :line 2717}
{:clk 2624.6711 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1729 :dets {:run {:m1 1731, :m2 1729, :m3 1727}, :bufs {:b1 [1730], :b2 [1728]}} :line 2718}
{:clk 2624.6711 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1730 :dets {:run {:m1 1731, :m2 nil, :m3 1727}, :bufs {:b1 [1730], :b2 [1728 1729]}} :line 2719}
{:clk 2625.4402 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2617.6555 :j 1727 :dets {:run {:m1 1731, :m2 1730, :m3 1727}, :bufs {:b1 [], :b2 [1728 1729]}} :line 2720}
{:clk 2625.4402 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1728 :dets {:run {:m1 1731, :m2 1730, :m3 nil}, :bufs {:b1 [], :b2 [1728 1729]}} :line 2721}
{:clk 2626.1711 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1730 :dets {:run {:m1 1731, :m2 1730, :m3 1728}, :bufs {:b1 [], :b2 [1729]}} :line 2722}
{:clk 2626.1711 :act :m2-starved :m :m2 :mjpact :st :dets {:run {:m1 1731, :m2 nil, :m3 1728}, :bufs {:b1 [], :b2 [1729 1730]}} :line 2723}
{:clk 2626.2741 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1731 :dets {:run {:m1 1731, :m2 nil, :m3 1728}, :bufs {:b1 [], :b2 [1729 1730]}} :line 2724}
{:clk 2626.2741 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2627.7741 :j 1732 :dets {:run {:m1 nil, :m2 nil, :m3 1728}, :bufs {:b1 [1731], :b2 [1729 1730]}} :line 2725}
{:clk 2626.2741 :act :m2-unstarved :m :m2 :mjpact :us :dets {:run {:m1 1732, :m2 1731, :m3 1728}, :bufs {:b1 [], :b2 [1729 1730]}} :line 2726}
{:clk 2626.2741 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1731 :dets {:run {:m1 1732, :m2 nil, :m3 1728}, :bufs {:b1 [1731], :b2 [1729 1730]}} :line 2727}
{:clk 2627.6862 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2618.6555 :j 1728 :dets {:run {:m1 1732, :m2 1731, :m3 1728}, :bufs {:b1 [], :b2 [1729 1730]}} :line 2728}
{:clk 2627.6862 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1729 :dets {:run {:m1 1732, :m2 1731, :m3 nil}, :bufs {:b1 [], :b2 [1729 1730]}} :line 2729}
{:clk 2627.7741 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1732 :dets {:run {:m1 1732, :m2 1731, :m3 1729}, :bufs {:b1 [], :b2 [1730]}} :line 2730}
{:clk 2627.7741 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2629.2741 :j 1733 :dets {:run {:m1 nil, :m2 nil, :m3 1729}, :bufs {:b1 [1732], :b2 [1730 1731]}} :line 2731}
{:clk 2627.7741 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1731 :dets {:run {:m1 nil, :m2 1731, :m3 1729}, :bufs {:b1 [1732], :b2 [1730]}} :line 2732}
{:clk 2627.7741 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1732 :dets {:run {:m1 1733, :m2 nil, :m3 1729}, :bufs {:b1 [1732], :b2 [1730 1731]}} :line 2733}
{:clk 2629.1862 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2620.1555 :j 1729 :dets {:run {:m1 1733, :m2 1732, :m3 1729}, :bufs {:b1 [], :b2 [1730 1731]}} :line 2734}
{:clk 2629.1862 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1730 :dets {:run {:m1 1733, :m2 1732, :m3 nil}, :bufs {:b1 [], :b2 [1730 1731]}} :line 2735}
{:clk 2629.2741 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1733 :dets {:run {:m1 1733, :m2 1732, :m3 1730}, :bufs {:b1 [], :b2 [1731]}} :line 2736}
{:clk 2629.2741 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2630.7741 :j 1734 :dets {:run {:m1 nil, :m2 nil, :m3 1730}, :bufs {:b1 [1733], :b2 [1731 1732]}} :line 2737}
{:clk 2629.2741 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1732 :dets {:run {:m1 nil, :m2 1732, :m3 1730}, :bufs {:b1 [1733], :b2 [1731]}} :line 2738}
{:clk 2629.2741 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1733 :dets {:run {:m1 1734, :m2 nil, :m3 1730}, :bufs {:b1 [1733], :b2 [1731 1732]}} :line 2739}
{:clk 2630.7741 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2632.2741 :j 1735 :dets {:run {:m1 nil, :m2 1733, :m3 1730}, :bufs {:b1 [1734], :b2 [1731 1732]}} :line 2740}
{:clk 2630.7741 :act :m2-blocked :m :m2 :mjpact :bl :dets {:run {:m1 nil, :m2 1733, :m3 1730}, :bufs {:b1 [1734], :b2 [1731 1732]}} :line 2741}
{:clk 2630.7741 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1734 :dets {:run {:m1 1734, :m2 1733, :m3 1730}, :bufs {:b1 [], :b2 [1731 1732]}} :line 2742}
{:clk 2632.2741 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1735 :dets {:run {:m1 1735, :m2 1733, :m3 1730}, :bufs {:b1 [1734], :b2 [1731 1732]}} :line 2743}
{:clk 2632.2741 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2633.2741 :j 1736 :dets {:run {:m1 nil, :m2 1733, :m3 1730}, :bufs {:b1 [1734 1735], :b2 [1731 1732]}} :line 2744}
{:clk 2632.8988 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2621.6555 :j 1730 :dets {:run {:m1 1736, :m2 1733, :m3 1730}, :bufs {:b1 [1734 1735], :b2 [1731 1732]}} :line 2745}
{:clk 2632.8988 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1731 :dets {:run {:m1 1736, :m2 1733, :m3 nil}, :bufs {:b1 [1734 1735], :b2 [1731 1732]}} :line 2746}
{:clk 2632.8988 :act :m2-unblocked :m :m2 :mjpact :ub :dets {:run {:m1 1736, :m2 nil, :m3 1731}, :bufs {:b1 [1734 1735], :b2 [1732 1733]}} :line 2747}
{:clk 2632.8988 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1733 :dets {:run {:m1 1736, :m2 1733, :m3 1731}, :bufs {:b1 [1734 1735], :b2 [1732]}} :line 2748}
{:clk 2632.8988 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1734 :dets {:run {:m1 1736, :m2 nil, :m3 1731}, :bufs {:b1 [1734 1735], :b2 [1732 1733]}} :line 2749}
{:clk 2633.2741 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1736 :dets {:run {:m1 1736, :m2 1734, :m3 1731}, :bufs {:b1 [1735], :b2 [1732 1733]}} :line 2750}
{:clk 2633.2741 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2634.9631 :j 1737 :dets {:run {:m1 nil, :m2 1734, :m3 1731}, :bufs {:b1 [1735 1736], :b2 [1732 1733]}} :line 2751}
{:clk 2634.3988 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1734 :dets {:run {:m1 1737, :m2 1734, :m3 1732}, :bufs {:b1 [1735 1736], :b2 [1733]}} :line 2752}
{:clk 2634.3988 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1735 :dets {:run {:m1 1737, :m2 nil, :m3 1732}, :bufs {:b1 [1735 1736], :b2 [1733 1734]}} :line 2753}
{:clk 2634.3988 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2623.1555 :j 1731 :dets {:run {:m1 1737, :m2 1734, :m3 1731}, :bufs {:b1 [1735 1736], :b2 [1732 1733]}} :line 2754}
{:clk 2634.3988 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1732 :dets {:run {:m1 1737, :m2 1734, :m3 nil}, :bufs {:b1 [1735 1736], :b2 [1732 1733]}} :line 2755}
{:clk 2634.9631 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1737 :dets {:run {:m1 1737, :m2 1735, :m3 1732}, :bufs {:b1 [1736], :b2 [1733 1734]}} :line 2756}
{:clk 2634.9631 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2635.9631 :j 1738 :dets {:run {:m1 nil, :m2 1735, :m3 1732}, :bufs {:b1 [1736 1737], :b2 [1733 1734]}} :line 2757}
{:clk 2635.8988 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1735 :dets {:run {:m1 1738, :m2 1735, :m3 1733}, :bufs {:b1 [1736 1737], :b2 [1734]}} :line 2758}
{:clk 2635.8988 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1736 :dets {:run {:m1 1738, :m2 nil, :m3 1733}, :bufs {:b1 [1736 1737], :b2 [1734 1735]}} :line 2759}
{:clk 2635.8988 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2626.2741 :j 1732 :dets {:run {:m1 1738, :m2 1735, :m3 1732}, :bufs {:b1 [1736 1737], :b2 [1733 1734]}} :line 2760}
{:clk 2635.8988 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1733 :dets {:run {:m1 1738, :m2 1735, :m3 nil}, :bufs {:b1 [1736 1737], :b2 [1733 1734]}} :line 2761}
{:clk 2635.9631 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1738 :dets {:run {:m1 1738, :m2 1736, :m3 1733}, :bufs {:b1 [1737], :b2 [1734 1735]}} :line 2762}
{:clk 2635.9631 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2636.9631 :j 1739 :dets {:run {:m1 nil, :m2 1736, :m3 1733}, :bufs {:b1 [1737 1738], :b2 [1734 1735]}} :line 2763}
{:clk 2636.9631 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1739, :m2 1736, :m3 1733}, :bufs {:b1 [1737 1738], :b2 [1734 1735]}} :line 2764}
{:clk 2637.3988 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2627.7741 :j 1733 :dets {:run {:m1 1739, :m2 1736, :m3 1733}, :bufs {:b1 [1737 1738], :b2 [1734 1735]}} :line 2765}
{:clk 2637.3988 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1734 :dets {:run {:m1 1739, :m2 1736, :m3 nil}, :bufs {:b1 [1737 1738], :b2 [1734 1735]}} :line 2766}
{:clk 2638.2259 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1736 :dets {:run {:m1 1739, :m2 1736, :m3 1734}, :bufs {:b1 [1737 1738], :b2 [1735]}} :line 2767}
{:clk 2638.2259 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1737 :dets {:run {:m1 1739, :m2 nil, :m3 1734}, :bufs {:b1 [1737 1738], :b2 [1735 1736]}} :line 2768}
{:clk 2638.2259 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1737, :m3 1734}, :bufs {:b1 [1738 1739], :b2 [1735 1736]}} :line 2769}
{:clk 2638.2259 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1739 :dets {:run {:m1 1739, :m2 1737, :m3 1734}, :bufs {:b1 [1738], :b2 [1735 1736]}} :line 2770}
{:clk 2638.2259 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2639.7259 :j 1740 :dets {:run {:m1 nil, :m2 1737, :m3 1734}, :bufs {:b1 [1738 1739], :b2 [1735 1736]}} :line 2771}
{:clk 2638.8988 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2629.2741 :j 1734 :dets {:run {:m1 1740, :m2 1737, :m3 1734}, :bufs {:b1 [1738 1739], :b2 [1735 1736]}} :line 2772}
{:clk 2638.8988 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1735 :dets {:run {:m1 1740, :m2 1737, :m3 nil}, :bufs {:b1 [1738 1739], :b2 [1735 1736]}} :line 2773}
{:clk 2639.7259 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1740 :dets {:run {:m1 1740, :m2 1738, :m3 1735}, :bufs {:b1 [1739], :b2 [1736 1737]}} :line 2774}
{:clk 2639.7259 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2640.7259 :j 1741 :dets {:run {:m1 nil, :m2 1738, :m3 1735}, :bufs {:b1 [1739 1740], :b2 [1736 1737]}} :line 2775}
{:clk 2639.7259 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1737 :dets {:run {:m1 1740, :m2 1737, :m3 1735}, :bufs {:b1 [1738 1739], :b2 [1736]}} :line 2776}
{:clk 2639.7259 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1738 :dets {:run {:m1 1740, :m2 nil, :m3 1735}, :bufs {:b1 [1738 1739], :b2 [1736 1737]}} :line 2777}
{:clk 2640.7259 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1741, :m2 1738, :m3 1735}, :bufs {:b1 [1739 1740], :b2 [1736 1737]}} :line 2778}
{:clk 2642.0838 :act :m2-blocked :m :m2 :mjpact :bl :dets {:run {:m1 1741, :m2 1738, :m3 1735}, :bufs {:b1 [1739 1740], :b2 [1736 1737]}} :line 2779}
{:clk 2644.7223 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2630.7741 :j 1735 :dets {:run {:m1 1741, :m2 1738, :m3 1735}, :bufs {:b1 [1739 1740], :b2 [1736 1737]}} :line 2780}
{:clk 2644.7223 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1736 :dets {:run {:m1 1741, :m2 1738, :m3 nil}, :bufs {:b1 [1739 1740], :b2 [1736 1737]}} :line 2781}
{:clk 2644.7223 :act :m2-unblocked :m :m2 :mjpact :ub :dets {:run {:m1 1741, :m2 nil, :m3 1736}, :bufs {:b1 [1739 1740], :b2 [1737 1738]}} :line 2782}
{:clk 2644.7223 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1738 :dets {:run {:m1 1741, :m2 1738, :m3 1736}, :bufs {:b1 [1739 1740], :b2 [1737]}} :line 2783}
{:clk 2644.7223 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1739 :dets {:run {:m1 1741, :m2 nil, :m3 1736}, :bufs {:b1 [1739 1740], :b2 [1737 1738]}} :line 2784}
{:clk 2644.7223 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1739, :m3 1736}, :bufs {:b1 [1740 1741], :b2 [1737 1738]}} :line 2785}
{:clk 2644.7223 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1741 :dets {:run {:m1 1741, :m2 1739, :m3 1736}, :bufs {:b1 [1740], :b2 [1737 1738]}} :line 2786}
{:clk 2644.7223 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2645.7223 :j 1742 :dets {:run {:m1 nil, :m2 1739, :m3 1736}, :bufs {:b1 [1740 1741], :b2 [1737 1738]}} :line 2787}
{:clk 2645.7223 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1742 :dets {:run {:m1 1742, :m2 1740, :m3 1737}, :bufs {:b1 [1741], :b2 [1738 1739]}} :line 2788}
{:clk 2645.7223 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2646.7223 :j 1743 :dets {:run {:m1 nil, :m2 1740, :m3 1737}, :bufs {:b1 [1741 1742], :b2 [1738 1739]}} :line 2789}
{:clk 2645.7223 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1739 :dets {:run {:m1 1742, :m2 1739, :m3 1737}, :bufs {:b1 [1740 1741], :b2 [1738]}} :line 2790}
{:clk 2645.7223 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1740 :dets {:run {:m1 1742, :m2 nil, :m3 1737}, :bufs {:b1 [1740 1741], :b2 [1738 1739]}} :line 2791}
{:clk 2645.7223 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2632.2741 :j 1736 :dets {:run {:m1 1742, :m2 1739, :m3 1736}, :bufs {:b1 [1740 1741], :b2 [1737 1738]}} :line 2792}
{:clk 2645.7223 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1737 :dets {:run {:m1 1742, :m2 1739, :m3 nil}, :bufs {:b1 [1740 1741], :b2 [1737 1738]}} :line 2793}
{:clk 2646.7223 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1743, :m2 1740, :m3 1737}, :bufs {:b1 [1741 1742], :b2 [1738 1739]}} :line 2794}
{:clk 2647.2223 :act :m2-blocked :m :m2 :mjpact :bl :dets {:run {:m1 1743, :m2 1740, :m3 1737}, :bufs {:b1 [1741 1742], :b2 [1738 1739]}} :line 2795}
{:clk 2648.2103 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2633.2741 :j 1737 :dets {:run {:m1 1743, :m2 1740, :m3 1737}, :bufs {:b1 [1741 1742], :b2 [1738 1739]}} :line 2796}
{:clk 2648.2103 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1738 :dets {:run {:m1 1743, :m2 1740, :m3 nil}, :bufs {:b1 [1741 1742], :b2 [1738 1739]}} :line 2797}
{:clk 2648.2103 :act :m2-unblocked :m :m2 :mjpact :ub :dets {:run {:m1 1743, :m2 nil, :m3 1738}, :bufs {:b1 [1741 1742], :b2 [1739 1740]}} :line 2798}
{:clk 2648.2103 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1740 :dets {:run {:m1 1743, :m2 1740, :m3 1738}, :bufs {:b1 [1741 1742], :b2 [1739]}} :line 2799}
{:clk 2648.2103 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1741 :dets {:run {:m1 1743, :m2 nil, :m3 1738}, :bufs {:b1 [1741 1742], :b2 [1739 1740]}} :line 2800}
{:clk 2648.2103 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1741, :m3 1738}, :bufs {:b1 [1742 1743], :b2 [1739 1740]}} :line 2801}
{:clk 2648.2103 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1743 :dets {:run {:m1 1743, :m2 1741, :m3 1738}, :bufs {:b1 [1742], :b2 [1739 1740]}} :line 2802}
{:clk 2648.2103 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2649.2103 :j 1744 :dets {:run {:m1 nil, :m2 1741, :m3 1738}, :bufs {:b1 [1742 1743], :b2 [1739 1740]}} :line 2803}
{:clk 2649.2103 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1744 :dets {:run {:m1 1744, :m2 1742, :m3 1739}, :bufs {:b1 [1743], :b2 [1740 1741]}} :line 2804}
{:clk 2649.2103 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2650.7103 :j 1745 :dets {:run {:m1 nil, :m2 1742, :m3 1739}, :bufs {:b1 [1743 1744], :b2 [1740 1741]}} :line 2805}
{:clk 2649.2103 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1741 :dets {:run {:m1 1744, :m2 1741, :m3 1739}, :bufs {:b1 [1742 1743], :b2 [1740]}} :line 2806}
{:clk 2649.2103 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1742 :dets {:run {:m1 1744, :m2 nil, :m3 1739}, :bufs {:b1 [1742 1743], :b2 [1740 1741]}} :line 2807}
{:clk 2649.2103 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2634.9631 :j 1738 :dets {:run {:m1 1744, :m2 1741, :m3 1738}, :bufs {:b1 [1742 1743], :b2 [1739 1740]}} :line 2808}
{:clk 2649.2103 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1739 :dets {:run {:m1 1744, :m2 1741, :m3 nil}, :bufs {:b1 [1742 1743], :b2 [1739 1740]}} :line 2809}
{:clk 2650.2103 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1742 :dets {:run {:m1 1745, :m2 1742, :m3 1740}, :bufs {:b1 [1743 1744], :b2 [1741]}} :line 2810}
{:clk 2650.2103 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1743 :dets {:run {:m1 1745, :m2 nil, :m3 1740}, :bufs {:b1 [1743 1744], :b2 [1741 1742]}} :line 2811}
{:clk 2650.2103 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2635.9631 :j 1739 :dets {:run {:m1 1745, :m2 1742, :m3 1739}, :bufs {:b1 [1743 1744], :b2 [1740 1741]}} :line 2812}
{:clk 2650.2103 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1740 :dets {:run {:m1 1745, :m2 1742, :m3 nil}, :bufs {:b1 [1743 1744], :b2 [1740 1741]}} :line 2813}
{:clk 2650.7103 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1745 :dets {:run {:m1 1745, :m2 1743, :m3 1740}, :bufs {:b1 [1744], :b2 [1741 1742]}} :line 2814}
{:clk 2650.7103 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2652.3352 :j 1746 :dets {:run {:m1 nil, :m2 1743, :m3 1740}, :bufs {:b1 [1744 1745], :b2 [1741 1742]}} :line 2815}
{:clk 2651.2103 :act :m2-blocked :m :m2 :mjpact :bl :dets {:run {:m1 1746, :m2 1743, :m3 1740}, :bufs {:b1 [1744 1745], :b2 [1741 1742]}} :line 2816}
{:clk 2651.7103 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2638.2259 :j 1740 :dets {:run {:m1 1746, :m2 1743, :m3 1740}, :bufs {:b1 [1744 1745], :b2 [1741 1742]}} :line 2817}
{:clk 2651.7103 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1741 :dets {:run {:m1 1746, :m2 1743, :m3 nil}, :bufs {:b1 [1744 1745], :b2 [1741 1742]}} :line 2818}
{:clk 2651.7103 :act :m2-unblocked :m :m2 :mjpact :ub :dets {:run {:m1 1746, :m2 nil, :m3 1741}, :bufs {:b1 [1744 1745], :b2 [1742 1743]}} :line 2819}
{:clk 2651.7103 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1743 :dets {:run {:m1 1746, :m2 1743, :m3 1741}, :bufs {:b1 [1744 1745], :b2 [1742]}} :line 2820}
{:clk 2651.7103 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1744 :dets {:run {:m1 1746, :m2 nil, :m3 1741}, :bufs {:b1 [1744 1745], :b2 [1742 1743]}} :line 2821}
{:clk 2652.3352 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1746 :dets {:run {:m1 1746, :m2 1744, :m3 1741}, :bufs {:b1 [1745], :b2 [1742 1743]}} :line 2822}
{:clk 2652.3352 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2653.3352 :j 1747 :dets {:run {:m1 nil, :m2 1744, :m3 1741}, :bufs {:b1 [1745 1746], :b2 [1742 1743]}} :line 2823}
{:clk 2652.7103 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1744 :dets {:run {:m1 1747, :m2 1744, :m3 1742}, :bufs {:b1 [1745 1746], :b2 [1743]}} :line 2824}
{:clk 2652.7103 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1745 :dets {:run {:m1 1747, :m2 nil, :m3 1742}, :bufs {:b1 [1745 1746], :b2 [1743 1744]}} :line 2825}
{:clk 2652.7103 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2639.7259 :j 1741 :dets {:run {:m1 1747, :m2 1744, :m3 1741}, :bufs {:b1 [1745 1746], :b2 [1742 1743]}} :line 2826}
{:clk 2652.7103 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1742 :dets {:run {:m1 1747, :m2 1744, :m3 nil}, :bufs {:b1 [1745 1746], :b2 [1742 1743]}} :line 2827}
{:clk 2653.3352 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1747 :dets {:run {:m1 1747, :m2 1745, :m3 1742}, :bufs {:b1 [1746], :b2 [1743 1744]}} :line 2828}
{:clk 2653.3352 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2655.9438 :j 1748 :dets {:run {:m1 nil, :m2 1745, :m3 1742}, :bufs {:b1 [1746 1747], :b2 [1743 1744]}} :line 2829}
{:clk 2653.7103 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2644.7223 :j 1742 :dets {:run {:m1 1748, :m2 1745, :m3 1742}, :bufs {:b1 [1746 1747], :b2 [1743 1744]}} :line 2830}
{:clk 2653.7103 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1743 :dets {:run {:m1 1748, :m2 1745, :m3 nil}, :bufs {:b1 [1746 1747], :b2 [1743 1744]}} :line 2831}
{:clk 2654.2103 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1745 :dets {:run {:m1 1748, :m2 1745, :m3 1743}, :bufs {:b1 [1746 1747], :b2 [1744]}} :line 2832}
{:clk 2654.2103 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1746 :dets {:run {:m1 1748, :m2 nil, :m3 1743}, :bufs {:b1 [1746 1747], :b2 [1744 1745]}} :line 2833}
{:clk 2654.7103 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2645.7223 :j 1743 :dets {:run {:m1 1748, :m2 1746, :m3 1743}, :bufs {:b1 [1747], :b2 [1744 1745]}} :line 2834}
{:clk 2654.7103 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1744 :dets {:run {:m1 1748, :m2 1746, :m3 nil}, :bufs {:b1 [1747], :b2 [1744 1745]}} :line 2835}
{:clk 2655.7103 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 1 :j 1746 :dets {:run {:m1 1748, :m2 1746, :m3 1744}, :bufs {:b1 [1747], :b2 [1745]}} :line 2836}
{:clk 2655.7103 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1747 :dets {:run {:m1 1748, :m2 nil, :m3 nil}, :bufs {:b1 [1747], :b2 [1745 1746]}} :line 2837}
{:clk 2655.7103 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2648.2103 :j 1744 :dets {:run {:m1 1748, :m2 nil, :m3 1744}, :bufs {:b1 [1747], :b2 [1745 1746]}} :line 2838}
{:clk 2655.7103 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 2 :j 1745 :dets {:run {:m1 1748, :m2 1747, :m3 nil}, :bufs {:b1 [], :b2 [1745 1746]}} :line 2839}
{:clk 2655.9438 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1748 :dets {:run {:m1 1748, :m2 1747, :m3 1745}, :bufs {:b1 [], :b2 [1746]}} :line 2840}
{:clk 2655.9438 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2657.4438 :j 1749 :dets {:run {:m1 nil, :m2 1747, :m3 1745}, :bufs {:b1 [1748], :b2 [1746]}} :line 2841}
{:clk 2657.2103 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2649.2103 :j 1745 :dets {:run {:m1 1749, :m2 1747, :m3 1745}, :bufs {:b1 [1748], :b2 [1746]}} :line 2842}
{:clk 2657.2103 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1746 :dets {:run {:m1 1749, :m2 1747, :m3 nil}, :bufs {:b1 [1748], :b2 [1746]}} :line 2843}
{:clk 2657.4438 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1749 :dets {:run {:m1 1749, :m2 1747, :m3 1746}, :bufs {:b1 [1748], :b2 []}} :line 2844}
{:clk 2657.4438 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2660.7024 :j 1750 :dets {:run {:m1 nil, :m2 1747, :m3 1746}, :bufs {:b1 [1748 1749], :b2 []}} :line 2845}
{:clk 2658.4737 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1747 :dets {:run {:m1 1750, :m2 1747, :m3 1746}, :bufs {:b1 [1748 1749], :b2 []}} :line 2846}
{:clk 2658.4737 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1748 :dets {:run {:m1 1750, :m2 nil, :m3 1746}, :bufs {:b1 [1748 1749], :b2 [1747]}} :line 2847}
{:clk 2658.7103 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2650.7103 :j 1746 :dets {:run {:m1 1750, :m2 1748, :m3 1746}, :bufs {:b1 [1749], :b2 [1747]}} :line 2848}
{:clk 2658.7103 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1747 :dets {:run {:m1 1750, :m2 1748, :m3 nil}, :bufs {:b1 [1749], :b2 [1747]}} :line 2849}
{:clk 2659.4737 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1748 :dets {:run {:m1 1750, :m2 1748, :m3 1747}, :bufs {:b1 [1749], :b2 []}} :line 2850}
{:clk 2659.4737 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1749 :dets {:run {:m1 1750, :m2 nil, :m3 1747}, :bufs {:b1 [1749], :b2 [1748]}} :line 2851}
{:clk 2659.7103 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2652.3352 :j 1747 :dets {:run {:m1 1750, :m2 1749, :m3 1747}, :bufs {:b1 [], :b2 [1748]}} :line 2852}
{:clk 2659.7103 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1748 :dets {:run {:m1 1750, :m2 1749, :m3 nil}, :bufs {:b1 [], :b2 [1748]}} :line 2853}
{:clk 2660.7024 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1750 :dets {:run {:m1 1750, :m2 1749, :m3 1748}, :bufs {:b1 [], :b2 []}} :line 2854}
{:clk 2660.7024 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2661.7024 :j 1751 :dets {:run {:m1 nil, :m2 1749, :m3 1748}, :bufs {:b1 [1750], :b2 []}} :line 2855}
{:clk 2660.7103 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2653.3352 :j 1748 :dets {:run {:m1 1751, :m2 1749, :m3 1748}, :bufs {:b1 [1750], :b2 []}} :line 2856}
{:clk 2660.7103 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1751, :m2 1749, :m3 nil}, :bufs {:b1 [1750], :b2 []}} :line 2857}
{:clk 2660.9737 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1749 :dets {:run {:m1 1751, :m2 1749, :m3 nil}, :bufs {:b1 [1750], :b2 []}} :line 2858}
{:clk 2660.9737 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1750 :dets {:run {:m1 1751, :m2 nil, :m3 nil}, :bufs {:b1 [1750], :b2 [1749]}} :line 2859}
{:clk 2660.9737 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1751, :m2 1750, :m3 1749}, :bufs {:b1 [], :b2 []}} :line 2860}
{:clk 2660.9737 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1749 :dets {:run {:m1 1751, :m2 1750, :m3 nil}, :bufs {:b1 [], :b2 [1749]}} :line 2861}
{:clk 2661.7024 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1751 :dets {:run {:m1 1751, :m2 1750, :m3 1749}, :bufs {:b1 [], :b2 []}} :line 2862}
{:clk 2661.7024 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2664.0235 :j 1752 :dets {:run {:m1 nil, :m2 1750, :m3 1749}, :bufs {:b1 [1751], :b2 []}} :line 2863}
{:clk 2662.4737 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1750 :dets {:run {:m1 1752, :m2 1750, :m3 1749}, :bufs {:b1 [1751], :b2 []}} :line 2864}
{:clk 2662.4737 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1751 :dets {:run {:m1 1752, :m2 nil, :m3 nil}, :bufs {:b1 [1751], :b2 [1750]}} :line 2865}
{:clk 2662.4737 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2655.9438 :j 1749 :dets {:run {:m1 1752, :m2 nil, :m3 1749}, :bufs {:b1 [1751], :b2 [1750]}} :line 2866}
{:clk 2662.4737 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1750 :dets {:run {:m1 1752, :m2 1751, :m3 nil}, :bufs {:b1 [], :b2 [1750]}} :line 2867}
{:clk 2663.4737 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1751 :dets {:run {:m1 1752, :m2 1751, :m3 1750}, :bufs {:b1 [], :b2 []}} :line 2868}
{:clk 2663.4737 :act :m2-starved :m :m2 :mjpact :st :dets {:run {:m1 1752, :m2 nil, :m3 1750}, :bufs {:b1 [], :b2 [1751]}} :line 2869}
{:clk 2664.0235 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1752 :dets {:run {:m1 1752, :m2 nil, :m3 1750}, :bufs {:b1 [], :b2 [1751]}} :line 2870}
{:clk 2664.0235 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2665.0235 :j 1753 :dets {:run {:m1 nil, :m2 nil, :m3 1750}, :bufs {:b1 [1752], :b2 [1751]}} :line 2871}
{:clk 2664.0235 :act :m2-unstarved :m :m2 :mjpact :us :dets {:run {:m1 1753, :m2 1752, :m3 1750}, :bufs {:b1 [], :b2 [1751]}} :line 2872}
{:clk 2664.0235 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1752 :dets {:run {:m1 1753, :m2 nil, :m3 1750}, :bufs {:b1 [1752], :b2 [1751]}} :line 2873}
{:clk 2665.0235 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1753 :dets {:run {:m1 1753, :m2 1752, :m3 1750}, :bufs {:b1 [], :b2 [1751]}} :line 2874}
{:clk 2665.0235 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2666.5235 :j 1754 :dets {:run {:m1 nil, :m2 1752, :m3 1750}, :bufs {:b1 [1753], :b2 [1751]}} :line 2875}
{:clk 2665.1422 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2657.4438 :j 1750 :dets {:run {:m1 1754, :m2 1752, :m3 1750}, :bufs {:b1 [1753], :b2 [1751]}} :line 2876}
{:clk 2665.1422 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1751 :dets {:run {:m1 1754, :m2 1752, :m3 nil}, :bufs {:b1 [1753], :b2 [1751]}} :line 2877}
{:clk 2665.5235 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1752 :dets {:run {:m1 1754, :m2 1752, :m3 1751}, :bufs {:b1 [1753], :b2 []}} :line 2878}
{:clk 2665.5235 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1753 :dets {:run {:m1 1754, :m2 nil, :m3 1751}, :bufs {:b1 [1753], :b2 [1752]}} :line 2879}
{:clk 2666.1422 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2660.7024 :j 1751 :dets {:run {:m1 1754, :m2 1753, :m3 1751}, :bufs {:b1 [], :b2 [1752]}} :line 2880}
{:clk 2666.1422 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1752 :dets {:run {:m1 1754, :m2 1753, :m3 nil}, :bufs {:b1 [], :b2 [1752]}} :line 2881}
{:clk 2666.5235 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1754 :dets {:run {:m1 1754, :m2 1753, :m3 1752}, :bufs {:b1 [], :b2 []}} :line 2882}
{:clk 2666.5235 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2667.5235 :j 1755 :dets {:run {:m1 nil, :m2 1753, :m3 1752}, :bufs {:b1 [1754], :b2 []}} :line 2883}
{:clk 2666.9583 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1753 :dets {:run {:m1 1755, :m2 1753, :m3 1752}, :bufs {:b1 [1754], :b2 []}} :line 2884}
{:clk 2666.9583 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1754 :dets {:run {:m1 1755, :m2 nil, :m3 1752}, :bufs {:b1 [1754], :b2 [1753]}} :line 2885}
{:clk 2667.5235 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1755 :dets {:run {:m1 1755, :m2 1754, :m3 1752}, :bufs {:b1 [], :b2 [1753]}} :line 2886}
{:clk 2667.5235 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2668.5235 :j 1756 :dets {:run {:m1 nil, :m2 1754, :m3 1752}, :bufs {:b1 [1755], :b2 [1753]}} :line 2887}
{:clk 2667.6422 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2661.7024 :j 1752 :dets {:run {:m1 1756, :m2 1754, :m3 1752}, :bufs {:b1 [1755], :b2 [1753]}} :line 2888}
{:clk 2667.6422 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1753 :dets {:run {:m1 1756, :m2 1754, :m3 nil}, :bufs {:b1 [1755], :b2 [1753]}} :line 2889}
{:clk 2668.4583 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1754 :dets {:run {:m1 1756, :m2 1754, :m3 1753}, :bufs {:b1 [1755], :b2 []}} :line 2890}
{:clk 2668.4583 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1755 :dets {:run {:m1 1756, :m2 nil, :m3 1753}, :bufs {:b1 [1755], :b2 [1754]}} :line 2891}
{:clk 2668.5235 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1756 :dets {:run {:m1 1756, :m2 1755, :m3 1753}, :bufs {:b1 [], :b2 [1754]}} :line 2892}
{:clk 2668.5235 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2670.0235 :j 1757 :dets {:run {:m1 nil, :m2 1755, :m3 1753}, :bufs {:b1 [1756], :b2 [1754]}} :line 2893}
{:clk 2668.6422 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2664.0235 :j 1753 :dets {:run {:m1 1757, :m2 1755, :m3 1753}, :bufs {:b1 [1756], :b2 [1754]}} :line 2894}
{:clk 2668.6422 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1754 :dets {:run {:m1 1757, :m2 1755, :m3 nil}, :bufs {:b1 [1756], :b2 [1754]}} :line 2895}
{:clk 2669.4583 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1755 :dets {:run {:m1 1757, :m2 1755, :m3 1754}, :bufs {:b1 [1756], :b2 []}} :line 2896}
{:clk 2669.4583 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1756 :dets {:run {:m1 1757, :m2 nil, :m3 1754}, :bufs {:b1 [1756], :b2 [1755]}} :line 2897}
{:clk 2670.0235 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1757 :dets {:run {:m1 1757, :m2 1756, :m3 1754}, :bufs {:b1 [], :b2 [1755]}} :line 2898}
{:clk 2670.0235 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2671.0235 :j 1758 :dets {:run {:m1 nil, :m2 1756, :m3 1754}, :bufs {:b1 [1757], :b2 [1755]}} :line 2899}
{:clk 2670.1422 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2665.0235 :j 1754 :dets {:run {:m1 1758, :m2 1756, :m3 1754}, :bufs {:b1 [1757], :b2 [1755]}} :line 2900}
{:clk 2670.1422 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1755 :dets {:run {:m1 1758, :m2 1756, :m3 nil}, :bufs {:b1 [1757], :b2 [1755]}} :line 2901}
{:clk 2670.4583 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1756 :dets {:run {:m1 1758, :m2 1756, :m3 1755}, :bufs {:b1 [1757], :b2 []}} :line 2902}
{:clk 2670.4583 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1757 :dets {:run {:m1 1758, :m2 nil, :m3 1755}, :bufs {:b1 [1757], :b2 [1756]}} :line 2903}
{:clk 2671.0235 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1758 :dets {:run {:m1 1758, :m2 1757, :m3 1755}, :bufs {:b1 [], :b2 [1756]}} :line 2904}
{:clk 2671.0235 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2672.5235 :j 1759 :dets {:run {:m1 nil, :m2 1757, :m3 1755}, :bufs {:b1 [1758], :b2 [1756]}} :line 2905}
{:clk 2671.1422 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2666.5235 :j 1755 :dets {:run {:m1 1759, :m2 1757, :m3 1755}, :bufs {:b1 [1758], :b2 [1756]}} :line 2906}
{:clk 2671.1422 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1756 :dets {:run {:m1 1759, :m2 1757, :m3 nil}, :bufs {:b1 [1758], :b2 [1756]}} :line 2907}
{:clk 2671.9583 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1757 :dets {:run {:m1 1759, :m2 1757, :m3 1756}, :bufs {:b1 [1758], :b2 []}} :line 2908}
{:clk 2671.9583 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1758 :dets {:run {:m1 1759, :m2 nil, :m3 1756}, :bufs {:b1 [1758], :b2 [1757]}} :line 2909}
{:clk 2672.1422 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2667.5235 :j 1756 :dets {:run {:m1 1759, :m2 1758, :m3 1756}, :bufs {:b1 [], :b2 [1757]}} :line 2910}
{:clk 2672.1422 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1757 :dets {:run {:m1 1759, :m2 1758, :m3 nil}, :bufs {:b1 [], :b2 [1757]}} :line 2911}
{:clk 2672.5235 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1759 :dets {:run {:m1 1759, :m2 1758, :m3 1757}, :bufs {:b1 [], :b2 []}} :line 2912}
{:clk 2672.5235 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2674.0235 :j 1760 :dets {:run {:m1 nil, :m2 1758, :m3 1757}, :bufs {:b1 [1759], :b2 []}} :line 2913}
{:clk 2672.9583 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1758 :dets {:run {:m1 1760, :m2 1758, :m3 1757}, :bufs {:b1 [1759], :b2 []}} :line 2914}
{:clk 2672.9583 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1759 :dets {:run {:m1 1760, :m2 nil, :m3 1757}, :bufs {:b1 [1759], :b2 [1758]}} :line 2915}
{:clk 2673.6422 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2668.5235 :j 1757 :dets {:run {:m1 1760, :m2 1759, :m3 1757}, :bufs {:b1 [], :b2 [1758]}} :line 2916}
{:clk 2673.6422 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1758 :dets {:run {:m1 1760, :m2 1759, :m3 nil}, :bufs {:b1 [], :b2 [1758]}} :line 2917}
{:clk 2674.0235 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1760 :dets {:run {:m1 1760, :m2 1759, :m3 1758}, :bufs {:b1 [], :b2 []}} :line 2918}
{:clk 2674.0235 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2675.5235 :j 1761 :dets {:run {:m1 nil, :m2 1759, :m3 1758}, :bufs {:b1 [1760], :b2 []}} :line 2919}
{:clk 2674.4583 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1759 :dets {:run {:m1 1761, :m2 1759, :m3 1758}, :bufs {:b1 [1760], :b2 []}} :line 2920}
{:clk 2674.4583 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1760 :dets {:run {:m1 1761, :m2 nil, :m3 1758}, :bufs {:b1 [1760], :b2 [1759]}} :line 2921}
{:clk 2674.6422 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2670.0235 :j 1758 :dets {:run {:m1 1761, :m2 1760, :m3 1758}, :bufs {:b1 [], :b2 [1759]}} :line 2922}
{:clk 2674.6422 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1759 :dets {:run {:m1 1761, :m2 1760, :m3 nil}, :bufs {:b1 [], :b2 [1759]}} :line 2923}
{:clk 2675.5235 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1761 :dets {:run {:m1 1761, :m2 1760, :m3 1759}, :bufs {:b1 [], :b2 []}} :line 2924}
{:clk 2675.5235 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2677.0235 :j 1762 :dets {:run {:m1 nil, :m2 1760, :m3 1759}, :bufs {:b1 [1761], :b2 []}} :line 2925}
{:clk 2675.9583 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1760 :dets {:run {:m1 1762, :m2 1760, :m3 1759}, :bufs {:b1 [1761], :b2 []}} :line 2926}
{:clk 2675.9583 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1761 :dets {:run {:m1 1762, :m2 nil, :m3 1759}, :bufs {:b1 [1761], :b2 [1760]}} :line 2927}
{:clk 2676.1422 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2671.0235 :j 1759 :dets {:run {:m1 1762, :m2 1761, :m3 1759}, :bufs {:b1 [], :b2 [1760]}} :line 2928}
{:clk 2676.1422 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1760 :dets {:run {:m1 1762, :m2 1761, :m3 nil}, :bufs {:b1 [], :b2 [1760]}} :line 2929}
{:clk 2677.0235 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1762 :dets {:run {:m1 1762, :m2 1761, :m3 1760}, :bufs {:b1 [], :b2 []}} :line 2930}
{:clk 2677.0235 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2678.5235 :j 1763 :dets {:run {:m1 nil, :m2 1761, :m3 1760}, :bufs {:b1 [1762], :b2 []}} :line 2931}
{:clk 2677.6422 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2672.5235 :j 1760 :dets {:run {:m1 1763, :m2 1761, :m3 1760}, :bufs {:b1 [1762], :b2 []}} :line 2932}
{:clk 2677.6422 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1763, :m2 1761, :m3 nil}, :bufs {:b1 [1762], :b2 []}} :line 2933}
{:clk 2677.7419 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1761 :dets {:run {:m1 1763, :m2 1761, :m3 nil}, :bufs {:b1 [1762], :b2 []}} :line 2934}
{:clk 2677.7419 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1762 :dets {:run {:m1 1763, :m2 nil, :m3 nil}, :bufs {:b1 [1762], :b2 [1761]}} :line 2935}
{:clk 2677.7419 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1763, :m2 1762, :m3 1761}, :bufs {:b1 [], :b2 []}} :line 2936}
{:clk 2677.7419 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1761 :dets {:run {:m1 1763, :m2 1762, :m3 nil}, :bufs {:b1 [], :b2 [1761]}} :line 2937}
{:clk 2678.5235 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1763 :dets {:run {:m1 1763, :m2 1762, :m3 1761}, :bufs {:b1 [], :b2 []}} :line 2938}
{:clk 2678.5235 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2680.0235 :j 1764 :dets {:run {:m1 nil, :m2 1762, :m3 1761}, :bufs {:b1 [1763], :b2 []}} :line 2939}
{:clk 2679.2419 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1762 :dets {:run {:m1 1764, :m2 1762, :m3 1761}, :bufs {:b1 [1763], :b2 []}} :line 2940}
{:clk 2679.2419 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 1 :j 1763 :dets {:run {:m1 1764, :m2 nil, :m3 nil}, :bufs {:b1 [1763], :b2 [1762]}} :line 2941}
{:clk 2679.2419 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2674.0235 :j 1761 :dets {:run {:m1 1764, :m2 nil, :m3 1761}, :bufs {:b1 [1763], :b2 [1762]}} :line 2942}
{:clk 2679.2419 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1762 :dets {:run {:m1 1764, :m2 1763, :m3 nil}, :bufs {:b1 [], :b2 [1762]}} :line 2943}
{:clk 2680.0235 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 0 :j 1764 :dets {:run {:m1 1764, :m2 1763, :m3 1762}, :bufs {:b1 [], :b2 []}} :line 2944}
{:clk 2680.0235 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2681.5235 :j 1765 :dets {:run {:m1 nil, :m2 1763, :m3 1762}, :bufs {:b1 [1764], :b2 []}} :line 2945}
{:clk 2680.7419 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2675.5235 :j 1762 :dets {:run {:m1 1765, :m2 1763, :m3 1762}, :bufs {:b1 [1764], :b2 []}} :line 2946}
{:clk 2680.7419 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1765, :m2 1763, :m3 nil}, :bufs {:b1 [1764], :b2 []}} :line 2947}
{:clk 2681.5235 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1765 :dets {:run {:m1 1765, :m2 1763, :m3 nil}, :bufs {:b1 [1764], :b2 []}} :line 2948}
{:clk 2681.5235 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2683.0235 :j 1766 :dets {:run {:m1 nil, :m2 1763, :m3 nil}, :bufs {:b1 [1764 1765], :b2 []}} :line 2949}
{:clk 2681.7568 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1763 :dets {:run {:m1 1766, :m2 1763, :m3 nil}, :bufs {:b1 [1764 1765], :b2 []}} :line 2950}
{:clk 2681.7568 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1764 :dets {:run {:m1 1766, :m2 nil, :m3 nil}, :bufs {:b1 [1764 1765], :b2 [1763]}} :line 2951}
{:clk 2681.7568 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1766, :m2 1764, :m3 1763}, :bufs {:b1 [1765], :b2 []}} :line 2952}
{:clk 2681.7568 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1763 :dets {:run {:m1 1766, :m2 1764, :m3 nil}, :bufs {:b1 [1765], :b2 [1763]}} :line 2953}
{:clk 2683.0235 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1766 :dets {:run {:m1 1766, :m2 1764, :m3 1763}, :bufs {:b1 [1765], :b2 []}} :line 2954}
{:clk 2683.0235 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2684.0235 :j 1767 :dets {:run {:m1 nil, :m2 1764, :m3 1763}, :bufs {:b1 [1765 1766], :b2 []}} :line 2955}
{:clk 2683.2568 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1764 :dets {:run {:m1 1767, :m2 1764, :m3 1763}, :bufs {:b1 [1765 1766], :b2 []}} :line 2956}
{:clk 2683.2568 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1765 :dets {:run {:m1 1767, :m2 nil, :m3 nil}, :bufs {:b1 [1765 1766], :b2 [1764]}} :line 2957}
{:clk 2683.2568 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2677.0235 :j 1763 :dets {:run {:m1 1767, :m2 nil, :m3 1763}, :bufs {:b1 [1765 1766], :b2 [1764]}} :line 2958}
{:clk 2683.2568 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1764 :dets {:run {:m1 1767, :m2 1765, :m3 nil}, :bufs {:b1 [1766], :b2 [1764]}} :line 2959}
{:clk 2684.0235 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1767 :dets {:run {:m1 1767, :m2 1765, :m3 1764}, :bufs {:b1 [1766], :b2 []}} :line 2960}
{:clk 2684.0235 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2686.171 :j 1768 :dets {:run {:m1 nil, :m2 1765, :m3 1764}, :bufs {:b1 [1766 1767], :b2 []}} :line 2961}
{:clk 2684.7568 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1765 :dets {:run {:m1 1768, :m2 1765, :m3 1764}, :bufs {:b1 [1766 1767], :b2 []}} :line 2962}
{:clk 2684.7568 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1766 :dets {:run {:m1 1768, :m2 nil, :m3 nil}, :bufs {:b1 [1766 1767], :b2 [1765]}} :line 2963}
{:clk 2684.7568 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2678.5235 :j 1764 :dets {:run {:m1 1768, :m2 nil, :m3 1764}, :bufs {:b1 [1766 1767], :b2 [1765]}} :line 2964}
{:clk 2684.7568 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1765 :dets {:run {:m1 1768, :m2 1766, :m3 nil}, :bufs {:b1 [1767], :b2 [1765]}} :line 2965}
{:clk 2686.1710 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1768 :dets {:run {:m1 1768, :m2 1766, :m3 1765}, :bufs {:b1 [1767], :b2 []}} :line 2966}
{:clk 2686.1710 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2687.171 :j 1769 :dets {:run {:m1 nil, :m2 1766, :m3 1765}, :bufs {:b1 [1767 1768], :b2 []}} :line 2967}
{:clk 2686.2568 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1766 :dets {:run {:m1 1769, :m2 1766, :m3 1765}, :bufs {:b1 [1767 1768], :b2 []}} :line 2968}
{:clk 2686.2568 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1767 :dets {:run {:m1 1769, :m2 nil, :m3 nil}, :bufs {:b1 [1767 1768], :b2 [1766]}} :line 2969}
{:clk 2686.2568 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2680.0235 :j 1765 :dets {:run {:m1 1769, :m2 nil, :m3 1765}, :bufs {:b1 [1767 1768], :b2 [1766]}} :line 2970}
{:clk 2686.2568 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1766 :dets {:run {:m1 1769, :m2 1767, :m3 nil}, :bufs {:b1 [1768], :b2 [1766]}} :line 2971}
{:clk 2687.1710 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1769 :dets {:run {:m1 1769, :m2 1767, :m3 1766}, :bufs {:b1 [1768], :b2 []}} :line 2972}
{:clk 2687.1710 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2688.171 :j 1770 :dets {:run {:m1 nil, :m2 1767, :m3 1766}, :bufs {:b1 [1768 1769], :b2 []}} :line 2973}
{:clk 2687.2568 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1767 :dets {:run {:m1 1770, :m2 1767, :m3 1766}, :bufs {:b1 [1768 1769], :b2 []}} :line 2974}
{:clk 2687.2568 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1768 :dets {:run {:m1 1770, :m2 nil, :m3 1766}, :bufs {:b1 [1768 1769], :b2 [1767]}} :line 2975}
{:clk 2687.7568 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2681.5235 :j 1766 :dets {:run {:m1 1770, :m2 1768, :m3 1766}, :bufs {:b1 [1769], :b2 [1767]}} :line 2976}
{:clk 2687.7568 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1767 :dets {:run {:m1 1770, :m2 1768, :m3 nil}, :bufs {:b1 [1769], :b2 [1767]}} :line 2977}
{:clk 2688.1710 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1770 :dets {:run {:m1 1770, :m2 1768, :m3 1767}, :bufs {:b1 [1769], :b2 []}} :line 2978}
{:clk 2688.1710 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2689.171 :j 1771 :dets {:run {:m1 nil, :m2 1768, :m3 1767}, :bufs {:b1 [1769 1770], :b2 []}} :line 2979}
{:clk 2688.7568 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2683.0235 :j 1767 :dets {:run {:m1 1771, :m2 1768, :m3 1767}, :bufs {:b1 [1769 1770], :b2 []}} :line 2980}
{:clk 2688.7568 :act :m3-starved :m :m3 :mjpact :st :dets {:run {:m1 1771, :m2 1768, :m3 nil}, :bufs {:b1 [1769 1770], :b2 []}} :line 2981}
{:clk 2689.1710 :act :m1-blocked :m :m1 :mjpact :bl :dets {:run {:m1 1771, :m2 1768, :m3 nil}, :bufs {:b1 [1769 1770], :b2 []}} :line 2982}
{:clk 2689.5568 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1768 :dets {:run {:m1 1771, :m2 1769, :m3 nil}, :bufs {:b1 [1770], :b2 [1768]}} :line 2983}
{:clk 2689.5568 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1768 :dets {:run {:m1 1771, :m2 1768, :m3 nil}, :bufs {:b1 [1769 1770], :b2 []}} :line 2984}
{:clk 2689.5568 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1769 :dets {:run {:m1 1771, :m2 nil, :m3 nil}, :bufs {:b1 [1769 1770], :b2 [1768]}} :line 2985}
{:clk 2689.5568 :act :m3-unstarved :m :m3 :mjpact :us :dets {:run {:m1 1771, :m2 1769, :m3 1768}, :bufs {:b1 [1770], :b2 []}} :line 2986}
{:clk 2689.5568 :act :m1-unblocked :m :m1 :mjpact :ub :dets {:run {:m1 nil, :m2 1769, :m3 1768}, :bufs {:b1 [1770 1771], :b2 []}} :line 2987}
{:clk 2689.5568 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1771 :dets {:run {:m1 1771, :m2 1769, :m3 1768}, :bufs {:b1 [1770], :b2 []}} :line 2988}
{:clk 2689.5568 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType2 :ends 2691.0568 :j 1772 :dets {:run {:m1 nil, :m2 1769, :m3 1768}, :bufs {:b1 [1770 1771], :b2 []}} :line 2989}
{:clk 2690.5568 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1769 :dets {:run {:m1 1772, :m2 1769, :m3 1768}, :bufs {:b1 [1770 1771], :b2 []}} :line 2990}
{:clk 2690.5568 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1770 :dets {:run {:m1 1772, :m2 nil, :m3 1768}, :bufs {:b1 [1770 1771], :b2 [1769]}} :line 2991}
{:clk 2691.0568 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1772 :dets {:run {:m1 1772, :m2 1770, :m3 1768}, :bufs {:b1 [1771], :b2 [1769]}} :line 2992}
{:clk 2691.0568 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2692.0568 :j 1773 :dets {:run {:m1 nil, :m2 1770, :m3 nil}, :bufs {:b1 [1771 1772], :b2 [1769]}} :line 2993}
{:clk 2691.0568 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2684.0235 :j 1768 :dets {:run {:m1 nil, :m2 1770, :m3 1768}, :bufs {:b1 [1771 1772], :b2 [1769]}} :line 2994}
{:clk 2691.0568 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1769 :dets {:run {:m1 1773, :m2 1770, :m3 nil}, :bufs {:b1 [1771 1772], :b2 [1769]}} :line 2995}
{:clk 2691.5568 :act :m2-complete-job :m :m2 :mjpact :bj :bf :b2 :n 0 :j 1770 :dets {:run {:m1 1773, :m2 1770, :m3 1769}, :bufs {:b1 [1771 1772], :b2 []}} :line 2996}
{:clk 2691.5568 :act :m2-start-job :m :m2 :mjpact :sm :bf :b1 :n 2 :j 1771 :dets {:run {:m1 1773, :m2 nil, :m3 1769}, :bufs {:b1 [1771 1772], :b2 [1770]}} :line 2997}
{:clk 2692.0568 :act :m1-complete-job :m :m1 :mjpact :bj :bf :b1 :n 1 :j 1773 :dets {:run {:m1 1773, :m2 1771, :m3 1769}, :bufs {:b1 [1772], :b2 [1770]}} :line 2998}
{:clk 2692.0568 :act :m1-start-job :m :m1 :mjpact :aj :jt :jobType1 :ends 2693.0568 :j 1774 :dets {:run {:m1 nil, :m2 1771, :m3 nil}, :bufs {:b1 [1772 1773], :b2 [1770]}} :line 2999}
{:clk 2692.0568 :act :m3-complete-job :m :m3 :mjpact :ej :ent 2686.171 :j 1769 :dets {:run {:m1 nil, :m2 1771, :m3 1769}, :bufs {:b1 [1772 1773], :b2 [1770]}} :line 3000}
{:clk 2692.0568 :act :m3-start-job :m :m3 :mjpact :sm :bf :b2 :n 1 :j 1770 :dets {:run {:m1 1774, :m2 1771, :m3 nil}, :bufs {:b1 [1772 1773], :b2 [1770]}} :line 3001}

#_{:TP 0.6665,
 :number-of-jobs 5332,
 :avg-buffer-occupancy
 {:b1 1.1496741290659538, :b2 0.7673757545305988},
 :status nil,
 :runtime 6.89,
 :starved {:m1 0.0, :m2 0.03924542203905702, :m3 0.06900661609153332},
 :observed-residence-time 7.202023971307889,
 :blocked {:m1 0.07272576369113304, :m2 0.0357492965750734, :m3 0.0},
 :bottleneck-machine :m2,
 :process-id 0}
