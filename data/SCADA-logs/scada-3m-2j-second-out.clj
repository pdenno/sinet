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
{:clk 1999.8745, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 1990.8793, :j 1307, :line 0}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1308, :line 1, :clk 1999.8745}
 {:clk 2000.8233, :act :m1-blocked, :m :m1, :mjpact :bl, :line 2}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1310, :line 3, :clk 2001.3233}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1311, :line 4, :clk 2001.3233}
 {:clk 2001.3233, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 5}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1313, :line 6, :clk 2001.3233}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1314, :line 7, :clk 2001.3233, :ends 2002.8233}
 {:clk 2001.3745, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 1992.2235, :j 1308, :line 8}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1309, :line 9, :clk 2001.3745}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1311, :line 10, :clk 2002.3233}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1312, :line 11, :clk 2002.3233}
 {:clk 2002.3745, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 1993.7235, :j 1309, :line 12}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1310, :line 13, :clk 2002.3745}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1314, :line 14, :clk 2002.8233}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1315, :line 15, :clk 2002.8233, :ends 2003.8233}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1312, :line 16, :clk 2003.3233}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1313, :line 17, :clk 2003.3233}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1315, :line 18, :clk 2003.8233}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1316, :line 19, :clk 2003.8233, :ends 2005.3233}
 {:clk 2003.8745, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 1994.7235, :j 1310, :line 20}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1311, :line 21, :clk 2003.8745}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1313, :line 22, :clk 2004.3233}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1314, :line 23, :clk 2004.3233}
 {:clk 2004.8745, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 1997.3233, :j 1311, :line 24}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1312, :line 25, :clk 2004.8745}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1316, :line 26, :clk 2005.3233}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1317, :line 27, :clk 2005.3233, :ends 2006.8233}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1314, :line 28, :clk 2005.8233}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1315, :line 29, :clk 2005.8233}
 {:clk 2005.8745, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 1998.8233, :j 1312, :line 30}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1313, :line 31, :clk 2005.8745}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1317, :line 32, :clk 2006.8233}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1318, :line 33, :clk 2006.8233, :ends 2008.3233}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1315, :line 34, :clk 2006.8233}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1316, :line 35, :clk 2006.8233}
 {:clk 2006.8745, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 1999.8233, :j 1313, :line 36}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1314, :line 37, :clk 2006.8745}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1318, :line 38, :clk 2008.3233}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1319, :line 39, :clk 2008.3233, :ends 2009.8233}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1316, :line 40, :clk 2008.3233}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1317, :line 41, :clk 2008.3233}
 {:clk 2008.3745, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2001.3233, :j 1314, :line 42}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1315, :line 43, :clk 2008.3745}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1319, :line 44, :clk 2009.8233}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1320, :line 45, :clk 2009.8233, :ends 2011.3233}
 {:clk 2011.3233, :act :m1-blocked, :m :m1, :mjpact :bl, :line 46}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1317, :line 47, :clk 2012.0242}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1318, :line 48, :clk 2012.0242}
 {:clk 2012.0242, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 49}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1320, :line 50, :clk 2012.0242}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1321, :line 51, :clk 2012.0242, :ends 2013.0242}
 {:clk 2012.346, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2002.8233, :j 1315, :line 52}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1316, :line 53, :clk 2012.346}
 {:clk 2013.0242, :act :m1-blocked, :m :m1, :mjpact :bl, :line 54}
 {:clk 2013.846, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2003.8233, :j 1316, :line 55}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1317, :line 56, :clk 2013.846}
 {:clk 2015.346, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2005.3233, :j 1317, :line 57}
 {:clk 2015.346, :act :m3-starved, :m :m3, :mjpact :st, :line 58}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1318, :line 59, :clk 2016.2446}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1319, :line 60, :clk 2016.2446}
 {:clk 2016.2446, :act :m3-unstarved, :m :m3, :mjpact :us, :line 61}
 {:clk 2016.2446, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 62}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1321, :line 63, :clk 2016.2446}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1322, :line 64, :clk 2016.2446, :ends 2017.7446}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1318, :line 65, :clk 2016.9388}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1322, :line 66, :clk 2017.7446}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1323, :line 67, :clk 2017.7446, :ends 2021.3328}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1319, :line 68, :clk 2017.7446}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1320, :line 69, :clk 2017.7446}
 {:clk 2018.4388, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2006.8233, :j 1318, :line 70}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1319, :line 71, :clk 2018.4388}
 {:clk 2019.9388, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2008.3233, :j 1319, :line 72}
 {:clk 2019.9388, :act :m3-starved, :m :m3, :mjpact :st, :line 73}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1320, :line 74, :clk 2021.0157}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1321, :line 75, :clk 2021.0157}
 {:clk 2021.0157, :act :m3-unstarved, :m :m3, :mjpact :us, :line 76}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1320, :line 77, :clk 2021.0157}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1323, :line 78, :clk 2021.3328}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1324, :line 79, :clk 2021.3328, :ends 2022.8328}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1321, :line 80, :clk 2022.0157}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1322, :line 81, :clk 2022.0157}
 {:clk 2022.5157, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2009.8233, :j 1320, :line 82}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1321, :line 83, :clk 2022.5157}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1324, :line 84, :clk 2022.8328}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1325, :line 85, :clk 2022.8328, :ends 2024.3328}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1322, :line 86, :clk 2023.5157}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1323, :line 87, :clk 2023.5157}
 {:clk 2023.5157, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2012.0242, :j 1321, :line 88}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1322, :line 89, :clk 2023.5157}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1325, :line 90, :clk 2024.3328}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1326, :line 91, :clk 2024.3328, :ends 2025.3328}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1323, :line 92, :clk 2024.5157}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1324, :line 93, :clk 2024.5157}
 {:clk 2025.0157, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2016.2446, :j 1322, :line 94}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1323, :line 95, :clk 2025.0157}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1326, :line 96, :clk 2025.3328}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1327, :line 97, :clk 2025.3328, :ends 2026.8328}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1324, :line 98, :clk 2026.0157}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1325, :line 99, :clk 2026.0157}
 {:clk 2026.0157, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2017.7446, :j 1323, :line 100}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1324, :line 101, :clk 2026.0157}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1327, :line 102, :clk 2026.8328}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1328, :line 103, :clk 2026.8328, :ends 2028.3328}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1325, :line 104, :clk 2027.5157}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1326, :line 105, :clk 2027.5157}
 {:clk 2027.5157, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2021.3328, :j 1324, :line 106}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1325, :line 107, :clk 2027.5157}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1328, :line 108, :clk 2028.3328}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1329, :line 109, :clk 2028.3328, :ends 2029.3328}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1326, :line 110, :clk 2028.5157}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1327, :line 111, :clk 2028.5157}
 {:clk 2029.1566, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2022.8328, :j 1325, :line 112}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1326, :line 113, :clk 2029.1566}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1329, :line 114, :clk 2029.3328}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1330, :line 115, :clk 2029.3328, :ends 2030.8328}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1327, :line 116, :clk 2030.0157}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1328, :line 117, :clk 2030.0157}
 {:clk 2030.1566, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2024.3328, :j 1326, :line 118}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1327, :line 119, :clk 2030.1566}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1330, :line 120, :clk 2030.8328}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1331, :line 121, :clk 2030.8328, :ends 2032.3328}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1328, :line 122, :clk 2031.5157}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1329, :line 123, :clk 2031.5157}
 {:clk 2031.6566, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2025.3328, :j 1327, :line 124}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1328, :line 125, :clk 2031.6566}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1331, :line 126, :clk 2032.3328}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1332, :line 127, :clk 2032.3328, :ends 2033.3328}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1329, :line 128, :clk 2032.5157}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1330, :line 129, :clk 2032.5157}
 {:clk 2033.1566, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2026.8328, :j 1328, :line 130}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1329, :line 131, :clk 2033.1566}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1332, :line 132, :clk 2033.3328}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1333, :line 133, :clk 2033.3328, :ends 2034.8328}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1330, :line 134, :clk 2034.0157}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1331, :line 135, :clk 2034.0157}
 {:clk 2034.1566, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2028.3328, :j 1329, :line 136}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1330, :line 137, :clk 2034.1566}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1333, :line 138, :clk 2034.8328}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1334, :line 139, :clk 2034.8328, :ends 2036.3328}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1331, :line 140, :clk 2035.5157}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1332, :line 141, :clk 2035.5157}
 {:clk 2035.6566, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2029.3328, :j 1330, :line 142}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1331, :line 143, :clk 2035.6566}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1334, :line 144, :clk 2036.3328}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1335, :line 145, :clk 2036.3328, :ends 2037.3328}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1332, :line 146, :clk 2036.5157}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1333, :line 147, :clk 2036.5157}
 {:clk 2037.1566, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2030.8328, :j 1331, :line 148}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1332, :line 149, :clk 2037.1566}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1335, :line 150, :clk 2037.3328}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1336, :line 151, :clk 2037.3328, :ends 2038.3328}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1333, :line 152, :clk 2038.0157}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1334, :line 153, :clk 2038.0157}
 {:clk 2038.1566, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2032.3328, :j 1332, :line 154}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1333, :line 155, :clk 2038.1566}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1336, :line 156, :clk 2038.3328}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1337, :line 157, :clk 2038.3328, :ends 2039.3328}
 {:clk 2039.3328, :act :m1-blocked, :m :m1, :mjpact :bl, :line 158}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1334, :line 159, :clk 2039.5157}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1335, :line 160, :clk 2039.5157}
 {:clk 2039.5157, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 161}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1337, :line 162, :clk 2039.5157}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1338, :line 163, :clk 2039.5157, :ends 2041.0157}
 {:clk 2039.6566, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2033.3328, :j 1333, :line 164}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1334, :line 165, :clk 2039.6566}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1335, :line 166, :clk 2040.5157}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1336, :line 167, :clk 2040.5157}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1338, :line 168, :clk 2041.0157}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1339, :line 169, :clk 2041.0157, :ends 2042.5157}
 {:clk 2041.1566, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2034.8328, :j 1334, :line 170}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1335, :line 171, :clk 2041.1566}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1336, :line 172, :clk 2041.5157}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1337, :line 173, :clk 2041.5157}
 {:clk 2042.1566, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2036.3328, :j 1335, :line 174}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1336, :line 175, :clk 2042.1566}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1339, :line 176, :clk 2042.5157}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1340, :line 177, :clk 2042.5157, :ends 2044.0157}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1337, :line 178, :clk 2042.5157}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1338, :line 179, :clk 2042.5157}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1340, :line 180, :clk 2044.0157}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1341, :line 181, :clk 2044.0157, :ends 2045.5157}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1338, :line 182, :clk 2044.0157}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1339, :line 183, :clk 2044.0157}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1342, :line 184, :clk 2045.5157, :ends 2046.5157}
 {:clk 2045.5157, :act :m2-blocked, :m :m2, :mjpact :bl, :line 185}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1341, :line 186, :clk 2045.5157}
 {:clk 2046.5157, :act :m1-blocked, :m :m1, :mjpact :bl, :line 187}
 {:clk 2048.7705, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2037.3328, :j 1336, :line 188}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1337, :line 189, :clk 2048.7705}
 {:clk 2048.7705, :act :m2-unblocked, :m :m2, :mjpact :ub, :line 190}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1339, :line 191, :clk 2048.7705}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1340, :line 192, :clk 2048.7705}
 {:clk 2048.7705, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 193}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1342, :line 194, :clk 2048.7705}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1343, :line 195, :clk 2048.7705, :ends 2049.7705}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1338, :line 196, :clk 2049.7705}
 {:clk 2049.7705, :act :m1-blocked, :m :m1, :mjpact :bl, :line 197}
 {:clk 2049.7705, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2038.3328, :j 1337, :line 198}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1340, :line 199, :clk 2050.6349}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1341, :line 200, :clk 2050.6349}
 {:clk 2050.6349, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 201}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1343, :line 202, :clk 2050.6349}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1344, :line 203, :clk 2050.6349, :ends 2052.1349}
 {:clk 2051.2705, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2039.5157, :j 1338, :line 204}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1339, :line 205, :clk 2051.2705}
 {:clk 2052.1349, :act :m1-blocked, :m :m1, :mjpact :bl, :line 206}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1341, :line 207, :clk 2052.3844}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1342, :line 208, :clk 2052.3844}
 {:clk 2052.3844, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 209}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1344, :line 210, :clk 2052.3844}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1345, :line 211, :clk 2052.3844, :ends 2053.4766}
 {:clk 2052.7705, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2041.0157, :j 1339, :line 212}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1340, :line 213, :clk 2052.7705}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1342, :line 214, :clk 2053.3844}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1343, :line 215, :clk 2053.3844}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1345, :line 216, :clk 2053.4766}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1346, :line 217, :clk 2053.4766, :ends 2057.0896}
 {:clk 2054.2705, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2042.5157, :j 1340, :line 218}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1341, :line 219, :clk 2054.2705}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1343, :line 220, :clk 2054.3844}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1344, :line 221, :clk 2054.3844}
 {:clk 2055.7705, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2044.0157, :j 1341, :line 222}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1342, :line 223, :clk 2055.7705}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1344, :line 224, :clk 2055.8844}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1345, :line 225, :clk 2055.8844}
 {:clk 2056.7705, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2045.5157, :j 1342, :line 226}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1343, :line 227, :clk 2056.7705}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1345, :line 228, :clk 2056.8844}
 {:clk 2056.8844, :act :m2-starved, :m :m2, :mjpact :st, :line 229}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1346, :line 230, :clk 2057.0896}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1347, :line 231, :clk 2057.0896, :ends 2058.0896}
 {:clk 2057.0896, :act :m2-unstarved, :m :m2, :mjpact :us, :line 232}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1346, :line 233, :clk 2057.0896}
 {:clk 2057.7705, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2048.7705, :j 1343, :line 234}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1344, :line 235, :clk 2057.7705}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1347, :line 236, :clk 2058.0896}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1348, :line 237, :clk 2058.0896, :ends 2059.5896}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1346, :line 238, :clk 2058.0896}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1347, :line 239, :clk 2058.0896}
 {:clk 2059.0896, :act :m2-starved, :m :m2, :mjpact :st, :line 240}
 {:clk 2059.0896, :act :m2-blocked, :m :m2, :mjpact :bl, :line 241}
 {:clk 2059.2705, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2050.6349, :j 1344, :line 242}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1345, :line 243, :clk 2059.2705}
 {:clk 2059.2705, :act :m2-unblocked, :m :m2, :mjpact :ub, :line 244}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1347, :line 245, :clk 2059.2705}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1348, :line 246, :clk 2059.5896}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1349, :line 247, :clk 2059.5896, :ends 2062.0436}
 {:clk 2059.5896, :act :m2-unstarved, :m :m2, :mjpact :us, :line 248}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1348, :line 249, :clk 2059.5896}
 {:clk 2060.2705, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2052.3844, :j 1345, :line 250}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1346, :line 251, :clk 2060.2705}
 {:clk 2061.2705, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2053.4766, :j 1346, :line 252}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1347, :line 253, :clk 2061.2705}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1348, :line 254, :clk 2061.7181}
 {:clk 2061.7181, :act :m2-starved, :m :m2, :mjpact :st, :line 255}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1349, :line 256, :clk 2062.0436}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1350, :line 257, :clk 2062.0436, :ends 2063.5436}
 {:clk 2062.0436, :act :m2-unstarved, :m :m2, :mjpact :us, :line 258}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1349, :line 259, :clk 2062.0436}
 {:clk 2062.2705, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2057.0896, :j 1347, :line 260}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1348, :line 261, :clk 2062.2705}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1349, :line 262, :clk 2063.0436}
 {:clk 2063.0436, :act :m2-starved, :m :m2, :mjpact :st, :line 263}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1350, :line 264, :clk 2063.5436}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1351, :line 265, :clk 2063.5436, :ends 2064.5436}
 {:clk 2063.5436, :act :m2-unstarved, :m :m2, :mjpact :us, :line 266}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1350, :line 267, :clk 2063.5436}
 {:clk 2063.7705, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2058.0896, :j 1348, :line 268}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1349, :line 269, :clk 2063.7705}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1351, :line 270, :clk 2064.5436}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1352, :line 271, :clk 2064.5436, :ends 2066.0436}
 {:clk 2064.7705, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2059.5896, :j 1349, :line 272}
 {:clk 2064.7705, :act :m3-starved, :m :m3, :mjpact :st, :line 273}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1350, :line 274, :clk 2065.0436}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1351, :line 275, :clk 2065.0436}
 {:clk 2065.0436, :act :m3-unstarved, :m :m3, :mjpact :us, :line 276}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1350, :line 277, :clk 2065.0436}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1352, :line 278, :clk 2066.0436}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1353, :line 279, :clk 2066.0436, :ends 2067.0436}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1351, :line 280, :clk 2066.0436}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1352, :line 281, :clk 2066.0436}
 {:clk 2066.5436, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2062.0436, :j 1350, :line 282}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1351, :line 283, :clk 2066.5436}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1353, :line 284, :clk 2067.0436}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1354, :line 285, :clk 2067.0436, :ends 2068.5436}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1352, :line 286, :clk 2067.5436}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1353, :line 287, :clk 2067.5436}
 {:clk 2067.5436, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2063.5436, :j 1351, :line 288}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1352, :line 289, :clk 2067.5436}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1354, :line 290, :clk 2068.5436}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1355, :line 291, :clk 2068.5436, :ends 2070.0436}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1353, :line 292, :clk 2068.5436}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1354, :line 293, :clk 2068.5436}
 {:clk 2069.0436, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2064.5436, :j 1352, :line 294}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1353, :line 295, :clk 2069.0436}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1355, :line 296, :clk 2070.0436}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1356, :line 297, :clk 2070.0436, :ends 2071.5436}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1354, :line 298, :clk 2070.0436}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1355, :line 299, :clk 2070.0436}
 {:clk 2070.0436, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2066.0436, :j 1353, :line 300}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1354, :line 301, :clk 2070.0436}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1356, :line 302, :clk 2071.5436}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1357, :line 303, :clk 2071.5436, :ends 2073.0436}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1355, :line 304, :clk 2071.5436}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1356, :line 305, :clk 2071.5436}
 {:clk 2071.5436, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2067.0436, :j 1354, :line 306}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1355, :line 307, :clk 2071.5436}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1357, :line 308, :clk 2073.0436}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1358, :line 309, :clk 2073.0436, :ends 2075.8304}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1356, :line 310, :clk 2073.0436}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1357, :line 311, :clk 2073.0436}
 {:clk 2073.0436, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2068.5436, :j 1355, :line 312}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1356, :line 313, :clk 2073.0436}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1357, :line 314, :clk 2074.5436}
 {:clk 2074.5436, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2070.0436, :j 1356, :line 315}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1357, :line 316, :clk 2074.5436}
 {:clk 2074.5436, :act :m2-starved, :m :m2, :mjpact :st, :line 317}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1358, :line 318, :clk 2075.8304}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1359, :line 319, :clk 2075.8304, :ends 2076.8304}
 {:clk 2075.8304, :act :m2-unstarved, :m :m2, :mjpact :us, :line 320}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1358, :line 321, :clk 2075.8304}
 {:clk 2076.0436, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2071.5436, :j 1357, :line 322}
 {:clk 2076.0436, :act :m3-starved, :m :m3, :mjpact :st, :line 323}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1359, :line 324, :clk 2076.8304}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1360, :line 325, :clk 2076.8304, :ends 2078.3304}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1358, :line 326, :clk 2076.8304}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1359, :line 327, :clk 2076.8304}
 {:clk 2076.8304, :act :m3-unstarved, :m :m3, :mjpact :us, :line 328}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1358, :line 329, :clk 2076.8304}
 {:clk 2077.8304, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2073.0436, :j 1358, :line 330}
 {:clk 2077.8304, :act :m3-starved, :m :m3, :mjpact :st, :line 331}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1360, :line 332, :clk 2078.3304}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1361, :line 333, :clk 2078.3304, :ends 2079.8304}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1361, :line 334, :clk 2079.8304}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1362, :line 335, :clk 2079.8304, :ends 2080.8304}
 {:clk 2080.8304, :act :m1-blocked, :m :m1, :mjpact :bl, :line 336}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1359, :line 337, :clk 2081.8954}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1359, :line 338, :clk 2081.8954}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1360, :line 339, :clk 2081.8954}
 {:clk 2081.8954, :act :m3-unstarved, :m :m3, :mjpact :us, :line 340}
 {:clk 2081.8954, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 341}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1362, :line 342, :clk 2081.8954}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1363, :line 343, :clk 2081.8954, :ends 2082.8954}
 {:clk 2082.8954, :act :m3-starved, :m :m3, :mjpact :st, :line 344}
 {:clk 2082.8954, :act :m1-blocked, :m :m1, :mjpact :bl, :line 345}
 {:clk 2082.8954, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2075.8304, :j 1359, :line 346}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1360, :line 347, :clk 2083.3954}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1360, :line 348, :clk 2083.3954}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1361, :line 349, :clk 2083.3954}
 {:clk 2083.3954, :act :m3-unstarved, :m :m3, :mjpact :us, :line 350}
 {:clk 2083.3954, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 351}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1363, :line 352, :clk 2083.3954}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1364, :line 353, :clk 2083.3954, :ends 2084.3954}
 {:clk 2084.3954, :act :m1-blocked, :m :m1, :mjpact :bl, :line 354}
 {:clk 2084.8954, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2076.8304, :j 1360, :line 355}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1361, :line 356, :clk 2084.8954}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1361, :line 357, :clk 2084.8954}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1362, :line 358, :clk 2084.8954}
 {:clk 2084.8954, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 359}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1364, :line 360, :clk 2084.8954}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1365, :line 361, :clk 2084.8954, :ends 2085.8954}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1365, :line 362, :clk 2085.8954}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1366, :line 363, :clk 2085.8954, :ends 2086.8954}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1362, :line 364, :clk 2085.8954}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1363, :line 365, :clk 2085.8954}
 {:clk 2086.3954, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2078.3304, :j 1361, :line 366}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1362, :line 367, :clk 2086.3954}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1366, :line 368, :clk 2086.8954}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1367, :line 369, :clk 2086.8954, :ends 2087.8954}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1363, :line 370, :clk 2086.8954}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1364, :line 371, :clk 2086.8954}
 {:clk 2087.3954, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2079.8304, :j 1362, :line 372}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1363, :line 373, :clk 2087.3954}
 {:clk 2087.8954, :act :m1-blocked, :m :m1, :mjpact :bl, :line 374}
 {:clk 2088.3954, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2081.8954, :j 1363, :line 375}
 {:clk 2088.3954, :act :m3-starved, :m :m3, :mjpact :st, :line 376}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1364, :line 377, :clk 2088.7128}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1364, :line 378, :clk 2088.7128}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1365, :line 379, :clk 2088.7128}
 {:clk 2088.7128, :act :m3-unstarved, :m :m3, :mjpact :us, :line 380}
 {:clk 2088.7128, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 381}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1367, :line 382, :clk 2088.7128}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1368, :line 383, :clk 2088.7128, :ends 2089.7128}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1368, :line 384, :clk 2089.7128}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1369, :line 385, :clk 2089.7128, :ends 2091.2128}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1365, :line 386, :clk 2089.7128}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1366, :line 387, :clk 2089.7128}
 {:clk 2089.7128, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2083.3954, :j 1364, :line 388}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1365, :line 389, :clk 2089.7128}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1366, :line 390, :clk 2090.7128}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1367, :line 391, :clk 2090.7128}
 {:clk 2090.7128, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2084.8954, :j 1365, :line 392}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1366, :line 393, :clk 2090.7128}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1369, :line 394, :clk 2091.2128}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1370, :line 395, :clk 2091.2128, :ends 2092.2128}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1367, :line 396, :clk 2091.7128}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1368, :line 397, :clk 2091.7128}
 {:clk 2091.7128, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2085.8954, :j 1366, :line 398}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1367, :line 399, :clk 2091.7128}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1370, :line 400, :clk 2092.2128}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1371, :line 401, :clk 2092.2128, :ends 2093.2128}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1368, :line 402, :clk 2092.7128}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1369, :line 403, :clk 2092.7128}
 {:clk 2092.7128, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2086.8954, :j 1367, :line 404}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1368, :line 405, :clk 2092.7128}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1371, :line 406, :clk 2093.2128}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1372, :line 407, :clk 2093.2128, :ends 2094.7128}
 {:clk 2093.7128, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2088.7128, :j 1368, :line 408}
 {:clk 2093.7128, :act :m3-starved, :m :m3, :mjpact :st, :line 409}
 {:clk 2094.7128, :act :m1-blocked, :m :m1, :mjpact :bl, :line 410}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1369, :line 411, :clk 2096.3173}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1369, :line 412, :clk 2096.3173}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1370, :line 413, :clk 2096.3173}
 {:clk 2096.3173, :act :m3-unstarved, :m :m3, :mjpact :us, :line 414}
 {:clk 2096.3173, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 415}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1372, :line 416, :clk 2096.3173}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1373, :line 417, :clk 2096.3173, :ends 2097.3173}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1373, :line 418, :clk 2097.3173}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1374, :line 419, :clk 2097.3173, :ends 2098.3173}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1370, :line 420, :clk 2097.3173}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1371, :line 421, :clk 2097.3173}
 {:clk 2097.8173, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2089.7128, :j 1369, :line 422}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1370, :line 423, :clk 2097.8173}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1374, :line 424, :clk 2098.3173}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1375, :line 425, :clk 2098.3173, :ends 2099.3173}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1371, :line 426, :clk 2098.3173}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1372, :line 427, :clk 2098.3173}
 {:clk 2098.8173, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2091.2128, :j 1370, :line 428}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1371, :line 429, :clk 2098.8173}
 {:clk 2099.3173, :act :m1-blocked, :m :m1, :mjpact :bl, :line 430}
 {:clk 2099.8173, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2092.2128, :j 1371, :line 431}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1372, :line 432, :clk 2099.8173}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1372, :line 433, :clk 2099.8173}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1373, :line 434, :clk 2099.8173}
 {:clk 2099.8173, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 435}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1375, :line 436, :clk 2099.8173}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1376, :line 437, :clk 2099.8173, :ends 2100.8173}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1376, :line 438, :clk 2100.8173}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1377, :line 439, :clk 2100.8173, :ends 2102.3173}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1373, :line 440, :clk 2100.8173}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1374, :line 441, :clk 2100.8173}
 {:clk 2101.3173, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2093.2128, :j 1372, :line 442}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1373, :line 443, :clk 2101.3173}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1374, :line 444, :clk 2102.2063}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1375, :line 445, :clk 2102.2063}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1377, :line 446, :clk 2102.3173}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1378, :line 447, :clk 2102.3173, :ends 2103.8173}
 {:clk 2102.3173, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2096.3173, :j 1373, :line 448}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1374, :line 449, :clk 2102.3173}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1375, :line 450, :clk 2103.2063}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1376, :line 451, :clk 2103.2063}
 {:clk 2103.3173, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2097.3173, :j 1374, :line 452}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1375, :line 453, :clk 2103.3173}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1378, :line 454, :clk 2103.8173}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1379, :line 455, :clk 2103.8173, :ends 2104.8173}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1376, :line 456, :clk 2104.217}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1377, :line 457, :clk 2104.217}
 {:clk 2104.3173, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2098.3173, :j 1375, :line 458}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1376, :line 459, :clk 2104.3173}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1379, :line 460, :clk 2104.8173}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1380, :line 461, :clk 2104.8173, :ends 2106.3173}
 {:clk 2105.3173, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2099.8173, :j 1376, :line 462}
 {:clk 2105.3173, :act :m3-starved, :m :m3, :mjpact :st, :line 463}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1377, :line 464, :clk 2105.717}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1378, :line 465, :clk 2105.717}
 {:clk 2105.717, :act :m3-unstarved, :m :m3, :mjpact :us, :line 466}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1377, :line 467, :clk 2105.717}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1380, :line 468, :clk 2106.3173}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1381, :line 469, :clk 2106.3173, :ends 2107.3173}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1378, :line 470, :clk 2107.217}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1379, :line 471, :clk 2107.217}
 {:clk 2107.217, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2100.8173, :j 1377, :line 472}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1378, :line 473, :clk 2107.217}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1381, :line 474, :clk 2107.3173}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1382, :line 475, :clk 2107.3173, :ends 2108.8173}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1379, :line 476, :clk 2108.217}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1380, :line 477, :clk 2108.217}
 {:clk 2108.717, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2102.3173, :j 1378, :line 478}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1379, :line 479, :clk 2108.717}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1382, :line 480, :clk 2108.8173}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1383, :line 481, :clk 2108.8173, :ends 2109.8173}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1380, :line 482, :clk 2109.717}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1381, :line 483, :clk 2109.717}
 {:clk 2109.717, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2103.8173, :j 1379, :line 484}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1380, :line 485, :clk 2109.717}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1383, :line 486, :clk 2109.8173}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1384, :line 487, :clk 2109.8173, :ends 2110.8173}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1381, :line 488, :clk 2110.717}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1382, :line 489, :clk 2110.717}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1384, :line 490, :clk 2110.8173}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1385, :line 491, :clk 2110.8173, :ends 2111.8173}
 {:clk 2111.217, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2104.8173, :j 1380, :line 492}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1381, :line 493, :clk 2111.217}
 {:clk 2111.8173, :act :m1-blocked, :m :m1, :mjpact :bl, :line 494}
 {:clk 2112.217, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2106.3173, :j 1381, :line 495}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1382, :line 496, :clk 2112.217}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1382, :line 497, :clk 2112.217}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1383, :line 498, :clk 2112.217}
 {:clk 2112.217, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 499}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1385, :line 500, :clk 2112.217}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1386, :line 501, :clk 2112.217, :ends 2115.9322}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1383, :line 502, :clk 2113.217}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1384, :line 503, :clk 2113.217}
 {:clk 2113.743, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2107.3173, :j 1382, :line 504}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1383, :line 505, :clk 2113.743}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1384, :line 506, :clk 2114.217}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1385, :line 507, :clk 2114.217}
 {:clk 2114.743, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2108.8173, :j 1383, :line 508}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1384, :line 509, :clk 2114.743}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1385, :line 510, :clk 2115.217}
 {:clk 2115.217, :act :m2-starved, :m :m2, :mjpact :st, :line 511}
 {:clk 2115.743, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2109.8173, :j 1384, :line 512}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1385, :line 513, :clk 2115.743}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1386, :line 514, :clk 2115.9322}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1387, :line 515, :clk 2115.9322, :ends 2117.4322}
 {:clk 2115.9322, :act :m2-unstarved, :m :m2, :mjpact :us, :line 516}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1386, :line 517, :clk 2115.9322}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1387, :line 518, :clk 2117.4322}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1388, :line 519, :clk 2117.4322, :ends 2118.9322}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1386, :line 520, :clk 2117.4322}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1387, :line 521, :clk 2117.4322}
 {:clk 2117.4771, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2110.8173, :j 1385, :line 522}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1386, :line 523, :clk 2117.4771}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1388, :line 524, :clk 2118.9322}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1389, :line 525, :clk 2118.9322, :ends 2120.4322}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1387, :line 526, :clk 2118.9322}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1388, :line 527, :clk 2118.9322}
 {:clk 2119.3383, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2112.217, :j 1386, :line 528}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1387, :line 529, :clk 2119.3383}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1389, :line 530, :clk 2120.4322}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1390, :line 531, :clk 2120.4322, :ends 2121.4322}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1388, :line 532, :clk 2120.4322}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1389, :line 533, :clk 2120.4322}
 {:clk 2120.8383, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2115.9322, :j 1387, :line 534}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1388, :line 535, :clk 2120.8383}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1390, :line 536, :clk 2121.4322}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1391, :line 537, :clk 2121.4322, :ends 2122.9322}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1389, :line 538, :clk 2121.9322}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1390, :line 539, :clk 2121.9322}
 {:clk 2122.3383, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2117.4322, :j 1388, :line 540}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1389, :line 541, :clk 2122.3383}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1391, :line 542, :clk 2122.9322}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1392, :line 543, :clk 2122.9322, :ends 2123.9322}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1390, :line 544, :clk 2122.9322}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1391, :line 545, :clk 2122.9322}
 {:clk 2123.8383, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2118.9322, :j 1389, :line 546}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1390, :line 547, :clk 2123.8383}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1392, :line 548, :clk 2123.9322}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1393, :line 549, :clk 2123.9322, :ends 2124.9322}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1391, :line 550, :clk 2124.4322}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1392, :line 551, :clk 2124.4322}
 {:clk 2124.8383, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2120.4322, :j 1390, :line 552}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1391, :line 553, :clk 2124.8383}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1393, :line 554, :clk 2124.9322}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1394, :line 555, :clk 2124.9322, :ends 2126.4322}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1392, :line 556, :clk 2125.4322}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1393, :line 557, :clk 2125.4322}
 {:clk 2126.3383, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2121.4322, :j 1391, :line 558}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1392, :line 559, :clk 2126.3383}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1394, :line 560, :clk 2126.4322}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1395, :line 561, :clk 2126.4322, :ends 2127.4322}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1393, :line 562, :clk 2126.4322}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1394, :line 563, :clk 2126.4322}
 {:clk 2127.3383, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2122.9322, :j 1392, :line 564}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1393, :line 565, :clk 2127.3383}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1395, :line 566, :clk 2127.4322}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1396, :line 567, :clk 2127.4322, :ends 2128.4322}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1394, :line 568, :clk 2127.9322}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1395, :line 569, :clk 2127.9322}
 {:clk 2128.3383, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2123.9322, :j 1393, :line 570}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1394, :line 571, :clk 2128.3383}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1396, :line 572, :clk 2128.4322}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1397, :line 573, :clk 2128.4322, :ends 2129.4322}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1395, :line 574, :clk 2128.9322}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1396, :line 575, :clk 2128.9322}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1397, :line 576, :clk 2129.4322}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1398, :line 577, :clk 2129.4322, :ends 2130.4322}
 {:clk 2129.8383, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2124.9322, :j 1394, :line 578}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1395, :line 579, :clk 2129.8383}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1396, :line 580, :clk 2129.9322}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1397, :line 581, :clk 2129.9322}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1398, :line 582, :clk 2130.4322}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1399, :line 583, :clk 2130.4322, :ends 2131.4322}
 {:clk 2130.8383, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2126.4322, :j 1395, :line 584}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1396, :line 585, :clk 2130.8383}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1397, :line 586, :clk 2130.9322}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1398, :line 587, :clk 2130.9322}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1399, :line 588, :clk 2131.4322}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1400, :line 589, :clk 2131.4322, :ends 2132.9322}
 {:clk 2131.8383, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2127.4322, :j 1396, :line 590}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1397, :line 591, :clk 2131.8383}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1398, :line 592, :clk 2131.9322}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1399, :line 593, :clk 2131.9322}
 {:clk 2132.8383, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2128.4322, :j 1397, :line 594}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1398, :line 595, :clk 2132.8383}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1400, :line 596, :clk 2132.9322}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1401, :line 597, :clk 2132.9322, :ends 2134.4322}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1399, :line 598, :clk 2132.9322}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1400, :line 599, :clk 2132.9322}
 {:clk 2133.8383, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2129.4322, :j 1398, :line 600}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1399, :line 601, :clk 2133.8383}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1401, :line 602, :clk 2134.4322}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1402, :line 603, :clk 2134.4322, :ends 2135.4322}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1400, :line 604, :clk 2134.5824}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1401, :line 605, :clk 2134.5824}
 {:clk 2134.8383, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2130.4322, :j 1399, :line 606}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1400, :line 607, :clk 2134.8383}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1402, :line 608, :clk 2135.4322}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1403, :line 609, :clk 2135.4322, :ends 2136.4322}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1401, :line 610, :clk 2136.0824}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1402, :line 611, :clk 2136.0824}
 {:clk 2136.3383, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2131.4322, :j 1400, :line 612}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1401, :line 613, :clk 2136.3383}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1403, :line 614, :clk 2136.4322}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1404, :line 615, :clk 2136.4322, :ends 2137.4322}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1402, :line 616, :clk 2137.0824}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1403, :line 617, :clk 2137.0824}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1404, :line 618, :clk 2137.4322}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1405, :line 619, :clk 2137.4322, :ends 2138.4322}
 {:clk 2137.8383, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2132.9322, :j 1401, :line 620}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1402, :line 621, :clk 2137.8383}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1403, :line 622, :clk 2138.0824}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1404, :line 623, :clk 2138.0824}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1405, :line 624, :clk 2138.4322}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1406, :line 625, :clk 2138.4322, :ends 2139.4322}
 {:clk 2138.8383, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2134.4322, :j 1402, :line 626}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1403, :line 627, :clk 2138.8383}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1404, :line 628, :clk 2139.0824}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1405, :line 629, :clk 2139.0824}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1406, :line 630, :clk 2139.4322}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1407, :line 631, :clk 2139.4322, :ends 2140.904}
 {:clk 2139.8383, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2135.4322, :j 1403, :line 632}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1404, :line 633, :clk 2139.8383}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1405, :line 634, :clk 2140.0824}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1406, :line 635, :clk 2140.0824}
 {:clk 2140.8383, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2136.4322, :j 1404, :line 636}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1405, :line 637, :clk 2140.8383}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1407, :line 638, :clk 2140.904}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1408, :line 639, :clk 2140.904, :ends 2142.404}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1406, :line 640, :clk 2141.0824}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1407, :line 641, :clk 2141.0824}
 {:clk 2141.8383, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2137.4322, :j 1405, :line 642}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1406, :line 643, :clk 2141.8383}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1407, :line 644, :clk 2142.0824}
 {:clk 2142.0824, :act :m2-starved, :m :m2, :mjpact :st, :line 645}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1408, :line 646, :clk 2142.404}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1409, :line 647, :clk 2142.404, :ends 2143.404}
 {:clk 2142.404, :act :m2-unstarved, :m :m2, :mjpact :us, :line 648}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1408, :line 649, :clk 2142.404}
 {:clk 2143.2275, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2138.4322, :j 1406, :line 650}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1407, :line 651, :clk 2143.2275}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1409, :line 652, :clk 2143.404}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1410, :line 653, :clk 2143.404, :ends 2145.5908}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1408, :line 654, :clk 2143.904}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1409, :line 655, :clk 2143.904}
 {:clk 2144.2275, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2139.4322, :j 1407, :line 656}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1408, :line 657, :clk 2144.2275}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1410, :line 658, :clk 2145.5908}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1411, :line 659, :clk 2145.5908, :ends 2146.5908}
 {:clk 2145.7275, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2140.904, :j 1408, :line 660}
 {:clk 2145.7275, :act :m3-starved, :m :m3, :mjpact :st, :line 661}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1409, :line 662, :clk 2146.2413}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1410, :line 663, :clk 2146.2413}
 {:clk 2146.2413, :act :m3-unstarved, :m :m3, :mjpact :us, :line 664}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1409, :line 665, :clk 2146.2413}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1411, :line 666, :clk 2146.5908}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1412, :line 667, :clk 2146.5908, :ends 2147.5908}
 {:clk 2147.2413, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2142.404, :j 1409, :line 668}
 {:clk 2147.2413, :act :m3-starved, :m :m3, :mjpact :st, :line 669}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1412, :line 670, :clk 2147.5908}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1413, :line 671, :clk 2147.5908, :ends 2148.5908}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1410, :line 672, :clk 2147.7413}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1411, :line 673, :clk 2147.7413}
 {:clk 2147.7413, :act :m3-unstarved, :m :m3, :mjpact :us, :line 674}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1410, :line 675, :clk 2147.7413}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1413, :line 676, :clk 2148.5908}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1414, :line 677, :clk 2148.5908, :ends 2150.0908}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1411, :line 678, :clk 2148.7413}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1412, :line 679, :clk 2148.7413}
 {:clk 2149.2413, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2143.404, :j 1410, :line 680}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1411, :line 681, :clk 2149.2413}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1412, :line 682, :clk 2149.7413}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1413, :line 683, :clk 2149.7413}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1414, :line 684, :clk 2150.0908}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1415, :line 685, :clk 2150.0908, :ends 2151.5908}
 {:clk 2150.2413, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2145.5908, :j 1411, :line 686}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1412, :line 687, :clk 2150.2413}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1413, :line 688, :clk 2150.7413}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1414, :line 689, :clk 2150.7413}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1415, :line 690, :clk 2151.5908}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1416, :line 691, :clk 2151.5908, :ends 2152.5974}
 {:clk 2152.1813, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2146.5908, :j 1412, :line 692}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1413, :line 693, :clk 2152.1813}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1414, :line 694, :clk 2152.2413}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1415, :line 695, :clk 2152.2413}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1416, :line 696, :clk 2152.5974}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1417, :line 697, :clk 2152.5974, :ends 2154.0974}
 {:clk 2153.1813, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2147.5908, :j 1413, :line 698}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1414, :line 699, :clk 2153.1813}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1415, :line 700, :clk 2153.7413}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1416, :line 701, :clk 2153.7413}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1417, :line 702, :clk 2154.0974}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1418, :line 703, :clk 2154.0974, :ends 2155.5974}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1416, :line 704, :clk 2154.7413}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1417, :line 705, :clk 2154.7413}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1418, :line 706, :clk 2155.5974}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1419, :line 707, :clk 2155.5974, :ends 2156.5974}
 {:clk 2156.2413, :act :m2-blocked, :m :m2, :mjpact :bl, :line 708}
 {:clk 2156.424, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2148.5908, :j 1414, :line 709}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1415, :line 710, :clk 2156.424}
 {:clk 2156.424, :act :m2-unblocked, :m :m2, :mjpact :ub, :line 711}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1417, :line 712, :clk 2156.424}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1418, :line 713, :clk 2156.424}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1419, :line 714, :clk 2156.5974}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1420, :line 715, :clk 2156.5974, :ends 2157.5974}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1420, :line 716, :clk 2157.5974}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1421, :line 717, :clk 2157.5974, :ends 2159.0974}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1418, :line 718, :clk 2157.924}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1419, :line 719, :clk 2157.924}
 {:clk 2157.924, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2150.0908, :j 1415, :line 720}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1416, :line 721, :clk 2157.924}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1419, :line 722, :clk 2158.924}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1420, :line 723, :clk 2158.924}
 {:clk 2158.924, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2151.5908, :j 1416, :line 724}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1417, :line 725, :clk 2158.924}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1421, :line 726, :clk 2159.0974}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1422, :line 727, :clk 2159.0974, :ends 2160.5974}
 {:clk 2159.924, :act :m2-blocked, :m :m2, :mjpact :bl, :line 728}
 {:clk 2160.424, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2152.5974, :j 1417, :line 729}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1418, :line 730, :clk 2160.424}
 {:clk 2160.424, :act :m2-unblocked, :m :m2, :mjpact :ub, :line 731}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1420, :line 732, :clk 2160.424}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1421, :line 733, :clk 2160.424}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1422, :line 734, :clk 2160.5974}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1423, :line 735, :clk 2160.5974, :ends 2162.0484}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1421, :line 736, :clk 2161.924}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1422, :line 737, :clk 2161.924}
 {:clk 2161.924, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2154.0974, :j 1418, :line 738}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1419, :line 739, :clk 2161.924}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1423, :line 740, :clk 2162.0484}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1424, :line 741, :clk 2162.0484, :ends 2165.4376}
 {:clk 2162.924, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2155.5974, :j 1419, :line 742}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1420, :line 743, :clk 2162.924}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1422, :line 744, :clk 2163.424}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1423, :line 745, :clk 2163.424}
 {:clk 2163.924, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2156.5974, :j 1420, :line 746}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1421, :line 747, :clk 2163.924}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1423, :line 748, :clk 2164.424}
 {:clk 2164.424, :act :m2-starved, :m :m2, :mjpact :st, :line 749}
 {:clk 2165.424, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2157.5974, :j 1421, :line 750}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1422, :line 751, :clk 2165.424}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1424, :line 752, :clk 2165.4376}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1425, :line 753, :clk 2165.4376, :ends 2166.9376}
 {:clk 2165.4376, :act :m2-unstarved, :m :m2, :mjpact :us, :line 754}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1424, :line 755, :clk 2165.4376}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1424, :line 756, :clk 2166.4376}
 {:clk 2166.4376, :act :m2-starved, :m :m2, :mjpact :st, :line 757}
 {:clk 2166.924, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2159.0974, :j 1422, :line 758}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1423, :line 759, :clk 2166.924}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1425, :line 760, :clk 2166.9376}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1426, :line 761, :clk 2166.9376, :ends 2168.0866}
 {:clk 2166.9376, :act :m2-unstarved, :m :m2, :mjpact :us, :line 762}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1425, :line 763, :clk 2166.9376}
 {:clk 2167.924, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2160.5974, :j 1423, :line 764}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1424, :line 765, :clk 2167.924}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1426, :line 766, :clk 2168.0866}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1427, :line 767, :clk 2168.0866, :ends 2169.0866}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1425, :line 768, :clk 2168.4376}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1426, :line 769, :clk 2168.4376}
 {:clk 2168.924, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2162.0484, :j 1424, :line 770}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1425, :line 771, :clk 2168.924}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1427, :line 772, :clk 2169.0866}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1428, :line 773, :clk 2169.0866, :ends 2170.0866}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1428, :line 774, :clk 2170.0866}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1429, :line 775, :clk 2170.0866, :ends 2171.5866}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1426, :line 776, :clk 2170.5772}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1427, :line 777, :clk 2170.5772}
 {:clk 2171.021, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2165.4376, :j 1425, :line 778}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1426, :line 779, :clk 2171.021}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1427, :line 780, :clk 2171.5772}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1428, :line 781, :clk 2171.5772}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1429, :line 782, :clk 2171.5866}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1430, :line 783, :clk 2171.5866, :ends 2172.5866}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1428, :line 784, :clk 2172.5772}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1429, :line 785, :clk 2172.5772}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1430, :line 786, :clk 2172.5866}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1431, :line 787, :clk 2172.5866, :ends 2174.0866}
 {:clk 2173.3398, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2166.9376, :j 1426, :line 788}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1427, :line 789, :clk 2173.3398}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1429, :line 790, :clk 2174.0772}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1430, :line 791, :clk 2174.0772}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1431, :line 792, :clk 2174.0866}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1432, :line 793, :clk 2174.0866, :ends 2176.0777}
 {:clk 2174.3398, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2168.0866, :j 1427, :line 794}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1428, :line 795, :clk 2174.3398}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1430, :line 796, :clk 2175.0772}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1431, :line 797, :clk 2175.0772}
 {:clk 2175.3398, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2169.0866, :j 1428, :line 798}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1429, :line 799, :clk 2175.3398}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1432, :line 800, :clk 2176.0777}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1433, :line 801, :clk 2176.0777, :ends 2177.5777}
 {:clk 2176.8398, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2170.0866, :j 1429, :line 802}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1430, :line 803, :clk 2176.8398}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1431, :line 804, :clk 2177.2057}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1432, :line 805, :clk 2177.2057}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1433, :line 806, :clk 2177.5777}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1434, :line 807, :clk 2177.5777, :ends 2179.0777}
 {:clk 2177.8398, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2171.5866, :j 1430, :line 808}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1431, :line 809, :clk 2177.8398}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1432, :line 810, :clk 2178.7057}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1433, :line 811, :clk 2178.7057}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1434, :line 812, :clk 2179.0777}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1435, :line 813, :clk 2179.0777, :ends 2180.0777}
 {:clk 2179.3398, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2172.5866, :j 1431, :line 814}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1432, :line 815, :clk 2179.3398}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1435, :line 816, :clk 2180.0777}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1436, :line 817, :clk 2180.0777, :ends 2181.0777}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1433, :line 818, :clk 2180.2057}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1434, :line 819, :clk 2180.2057}
 {:clk 2180.8398, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2174.0866, :j 1432, :line 820}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1433, :line 821, :clk 2180.8398}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1436, :line 822, :clk 2181.0777}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1437, :line 823, :clk 2181.0777, :ends 2182.0777}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1434, :line 824, :clk 2181.7057}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1435, :line 825, :clk 2181.7057}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1437, :line 826, :clk 2182.0777}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1438, :line 827, :clk 2182.0777, :ends 2185.6082}
 {:clk 2182.3398, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2176.0777, :j 1433, :line 828}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1434, :line 829, :clk 2182.3398}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1435, :line 830, :clk 2182.7057}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1436, :line 831, :clk 2182.7057}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1436, :line 832, :clk 2183.7057}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1437, :line 833, :clk 2183.7057}
 {:clk 2183.8398, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2177.5777, :j 1434, :line 834}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1435, :line 835, :clk 2183.8398}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1437, :line 836, :clk 2184.7057}
 {:clk 2184.7057, :act :m2-starved, :m :m2, :mjpact :st, :line 837}
 {:clk 2184.8398, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2179.0777, :j 1435, :line 838}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1436, :line 839, :clk 2184.8398}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1438, :line 840, :clk 2185.6082}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1439, :line 841, :clk 2185.6082, :ends 2186.6082}
 {:clk 2185.6082, :act :m2-unstarved, :m :m2, :mjpact :us, :line 842}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1438, :line 843, :clk 2185.6082}
 {:clk 2185.8398, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2180.0777, :j 1436, :line 844}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1437, :line 845, :clk 2185.8398}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1439, :line 846, :clk 2186.6082}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1440, :line 847, :clk 2186.6082, :ends 2188.1082}
 {:clk 2186.8398, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2181.0777, :j 1437, :line 848}
 {:clk 2186.8398, :act :m3-starved, :m :m3, :mjpact :st, :line 849}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1438, :line 850, :clk 2187.1082}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1439, :line 851, :clk 2187.1082}
 {:clk 2187.1082, :act :m3-unstarved, :m :m3, :mjpact :us, :line 852}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1438, :line 853, :clk 2187.1082}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1440, :line 854, :clk 2188.1082}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1441, :line 855, :clk 2188.1082, :ends 2189.1082}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1439, :line 856, :clk 2188.1082}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1440, :line 857, :clk 2188.1082}
 {:clk 2188.6082, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2182.0777, :j 1438, :line 858}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1439, :line 859, :clk 2188.6082}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1441, :line 860, :clk 2189.1082}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1442, :line 861, :clk 2189.1082, :ends 2190.6082}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1440, :line 862, :clk 2189.6082}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1441, :line 863, :clk 2189.6082}
 {:clk 2189.6082, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2185.6082, :j 1439, :line 864}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1440, :line 865, :clk 2189.6082}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1442, :line 866, :clk 2190.6082}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1443, :line 867, :clk 2190.6082, :ends 2191.6082}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1441, :line 868, :clk 2190.6082}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1442, :line 869, :clk 2190.6082}
 {:clk 2191.1082, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2186.6082, :j 1440, :line 870}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1441, :line 871, :clk 2191.1082}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1443, :line 872, :clk 2191.6082}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1444, :line 873, :clk 2191.6082, :ends 2192.6082}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1442, :line 874, :clk 2192.1082}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1443, :line 875, :clk 2192.1082}
 {:clk 2192.1082, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2188.1082, :j 1441, :line 876}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1442, :line 877, :clk 2192.1082}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1444, :line 878, :clk 2192.6082}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1445, :line 879, :clk 2192.6082, :ends 2193.6082}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1445, :line 880, :clk 2193.6082}
 {:clk 2193.6082, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2189.1082, :j 1442, :line 881}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1446, :line 882, :clk 2193.6082, :ends 2196.2677}
 {:clk 2193.6082, :act :m3-starved, :m :m3, :mjpact :st, :line 883}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1443, :line 884, :clk 2195.2146}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1444, :line 885, :clk 2195.2146}
 {:clk 2195.2146, :act :m3-unstarved, :m :m3, :mjpact :us, :line 886}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1444, :line 887, :clk 2196.2146}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1445, :line 888, :clk 2196.2146}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1446, :line 889, :clk 2196.2677}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1447, :line 890, :clk 2196.2677, :ends 2197.7677}
 {:clk 2197.2146, :act :m2-blocked, :m :m2, :mjpact :bl, :line 891}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1447, :line 892, :clk 2197.7677}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1448, :line 893, :clk 2197.7677, :ends 2199.2677}
 {:clk 2199.2677, :act :m1-blocked, :m :m1, :mjpact :bl, :line 894}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1443, :line 895, :clk 2200.1719}
 {:clk 2200.1719, :act :m2-unblocked, :m :m2, :mjpact :ub, :line 896}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1445, :line 897, :clk 2200.1719}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1446, :line 898, :clk 2201.7325}
 {:clk 2201.7325, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 899}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1448, :line 900, :clk 2201.7325}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1449, :line 901, :clk 2201.7325, :ends 2208.4653}
 {:clk 2202.0433, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2190.6082, :j 1443, :line 902}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1444, :line 903, :clk 2202.0433}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1446, :line 904, :clk 2202.7325}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1447, :line 905, :clk 2202.7325}
 {:clk 2203.0433, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2191.6082, :j 1444, :line 906}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1445, :line 907, :clk 2203.0433}
 {:clk 2204.0433, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2192.6082, :j 1445, :line 908}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1446, :line 909, :clk 2204.0433}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1447, :line 910, :clk 2204.2325}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1448, :line 911, :clk 2204.2325}
 {:clk 2205.0433, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2193.6082, :j 1446, :line 912}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1447, :line 913, :clk 2205.0433}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1448, :line 914, :clk 2205.7325}
 {:clk 2205.7325, :act :m2-starved, :m :m2, :mjpact :st, :line 915}
 {:clk 2206.5433, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2196.2677, :j 1447, :line 916}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1448, :line 917, :clk 2206.5433}
 {:clk 2208.0433, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2197.7677, :j 1448, :line 918}
 {:clk 2208.0433, :act :m3-starved, :m :m3, :mjpact :st, :line 919}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1449, :line 920, :clk 2208.4653}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1450, :line 921, :clk 2208.4653, :ends 2209.9653}
 {:clk 2208.4653, :act :m2-unstarved, :m :m2, :mjpact :us, :line 922}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1449, :line 923, :clk 2208.4653}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1450, :line 924, :clk 2209.9653}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1451, :line 925, :clk 2209.9653, :ends 2211.4653}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1449, :line 926, :clk 2209.9653}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1450, :line 927, :clk 2209.9653}
 {:clk 2209.9653, :act :m3-unstarved, :m :m3, :mjpact :us, :line 928}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1449, :line 929, :clk 2209.9653}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1451, :line 930, :clk 2211.4653}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1452, :line 931, :clk 2211.4653, :ends 2212.4653}
 {:clk 2211.5064, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2201.7325, :j 1449, :line 932}
 {:clk 2211.5064, :act :m3-starved, :m :m3, :mjpact :st, :line 933}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1452, :line 934, :clk 2212.4653}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1453, :line 935, :clk 2212.4653, :ends 2213.4653}
 {:clk 2213.4653, :act :m1-blocked, :m :m1, :mjpact :bl, :line 936}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1450, :line 937, :clk 2213.6832}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1450, :line 938, :clk 2213.6832}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1451, :line 939, :clk 2213.6832}
 {:clk 2213.6832, :act :m3-unstarved, :m :m3, :mjpact :us, :line 940}
 {:clk 2213.6832, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 941}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1453, :line 942, :clk 2213.6832}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1454, :line 943, :clk 2213.6832, :ends 2215.1832}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1454, :line 944, :clk 2215.1832}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1455, :line 945, :clk 2215.1832, :ends 2216.1832}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1451, :line 946, :clk 2215.1832}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1452, :line 947, :clk 2215.1832}
 {:clk 2215.1832, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2208.4653, :j 1450, :line 948}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1451, :line 949, :clk 2215.1832}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1455, :line 950, :clk 2216.1832}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1456, :line 951, :clk 2216.1832, :ends 2217.1832}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1452, :line 952, :clk 2216.1832}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1453, :line 953, :clk 2216.1832}
 {:clk 2216.6832, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2209.9653, :j 1451, :line 954}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1452, :line 955, :clk 2216.6832}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1456, :line 956, :clk 2217.1832}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1457, :line 957, :clk 2217.1832, :ends 2218.7952}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1453, :line 958, :clk 2217.1832}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1454, :line 959, :clk 2217.1832}
 {:clk 2217.6832, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2211.4653, :j 1452, :line 960}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1453, :line 961, :clk 2217.6832}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1454, :line 962, :clk 2218.6832}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1455, :line 963, :clk 2218.6832}
 {:clk 2218.6832, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2212.4653, :j 1453, :line 964}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1454, :line 965, :clk 2218.6832}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1457, :line 966, :clk 2218.7952}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1458, :line 967, :clk 2218.7952, :ends 2220.2952}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1455, :line 968, :clk 2219.6832}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1456, :line 969, :clk 2219.6832}
 {:clk 2220.1832, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2213.6832, :j 1454, :line 970}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1455, :line 971, :clk 2220.1832}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1458, :line 972, :clk 2220.2952}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1459, :line 973, :clk 2220.2952, :ends 2221.7952}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1456, :line 974, :clk 2220.6832}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1457, :line 975, :clk 2220.6832}
 {:clk 2221.1832, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2215.1832, :j 1455, :line 976}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1456, :line 977, :clk 2221.1832}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1457, :line 978, :clk 2221.6832}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1458, :line 979, :clk 2221.6832}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1459, :line 980, :clk 2221.7952}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1460, :line 981, :clk 2221.7952, :ends 2223.2952}
 {:clk 2222.1832, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2216.1832, :j 1456, :line 982}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1457, :line 983, :clk 2222.1832}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1458, :line 984, :clk 2223.1832}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1459, :line 985, :clk 2223.1832}
 {:clk 2223.1832, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2217.1832, :j 1457, :line 986}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1458, :line 987, :clk 2223.1832}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1460, :line 988, :clk 2223.2952}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1461, :line 989, :clk 2223.2952, :ends 2224.2952}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1461, :line 990, :clk 2224.2952}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1462, :line 991, :clk 2224.2952, :ends 2225.7952}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1459, :line 992, :clk 2224.6832}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1460, :line 993, :clk 2224.6832}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1462, :line 994, :clk 2225.7952}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1463, :line 995, :clk 2225.7952, :ends 2227.2952}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1460, :line 996, :clk 2226.1832}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1461, :line 997, :clk 2226.1832}
 {:clk 2226.4689, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2218.7952, :j 1458, :line 998}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1459, :line 999, :clk 2226.4689}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1461, :line 1000, :clk 2227.1832}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1462, :line 1001, :clk 2227.1832}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1463, :line 1002, :clk 2227.2952}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1464, :line 1003, :clk 2227.2952, :ends 2228.2952}
 {:clk 2227.9689, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2220.2952, :j 1459, :line 1004}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1460, :line 1005, :clk 2227.9689}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1464, :line 1006, :clk 2228.2952}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1465, :line 1007, :clk 2228.2952, :ends 2229.2952}
 {:clk 2229.2952, :act :m1-blocked, :m :m1, :mjpact :bl, :line 1008}
 {:clk 2229.4689, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2221.7952, :j 1460, :line 1009}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1461, :line 1010, :clk 2229.4689}
 {:clk 2230.4689, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2223.2952, :j 1461, :line 1011}
 {:clk 2230.4689, :act :m3-starved, :m :m3, :mjpact :st, :line 1012}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1462, :line 1013, :clk 2230.5165}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1462, :line 1014, :clk 2230.5165}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1463, :line 1015, :clk 2230.5165}
 {:clk 2230.5165, :act :m3-unstarved, :m :m3, :mjpact :us, :line 1016}
 {:clk 2230.5165, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 1017}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1465, :line 1018, :clk 2230.5165}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1466, :line 1019, :clk 2230.5165, :ends 2232.2991}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1463, :line 1020, :clk 2232.0165}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1464, :line 1021, :clk 2232.0165}
 {:clk 2232.0165, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2224.2952, :j 1462, :line 1022}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1463, :line 1023, :clk 2232.0165}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1466, :line 1024, :clk 2232.2991}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1467, :line 1025, :clk 2232.2991, :ends 2233.7991}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1464, :line 1026, :clk 2233.0165}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1465, :line 1027, :clk 2233.0165}
 {:clk 2233.5165, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2225.7952, :j 1463, :line 1028}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1464, :line 1029, :clk 2233.5165}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1467, :line 1030, :clk 2233.7991}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1468, :line 1031, :clk 2233.7991, :ends 2235.2991}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1465, :line 1032, :clk 2234.0165}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1466, :line 1033, :clk 2234.0165}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1468, :line 1034, :clk 2235.2991}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1469, :line 1035, :clk 2235.2991, :ends 2236.2991}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1466, :line 1036, :clk 2235.5165}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1467, :line 1037, :clk 2235.5165}
 {:clk 2235.9224, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2227.2952, :j 1464, :line 1038}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1465, :line 1039, :clk 2235.9224}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1469, :line 1040, :clk 2236.2991}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1470, :line 1041, :clk 2236.2991, :ends 2237.2991}
 {:clk 2236.9224, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2228.2952, :j 1465, :line 1042}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1466, :line 1043, :clk 2236.9224}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1467, :line 1044, :clk 2237.0165}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1468, :line 1045, :clk 2237.0165}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1470, :line 1046, :clk 2237.2991}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1471, :line 1047, :clk 2237.2991, :ends 2238.7991}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1468, :line 1048, :clk 2238.5165}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1469, :line 1049, :clk 2238.5165}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1471, :line 1050, :clk 2238.7991}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1472, :line 1051, :clk 2238.7991, :ends 2240.2991}
 {:clk 2239.5165, :act :m2-blocked, :m :m2, :mjpact :bl, :line 1052}
 {:clk 2239.6031, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2230.5165, :j 1466, :line 1053}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1467, :line 1054, :clk 2239.6031}
 {:clk 2239.6031, :act :m2-unblocked, :m :m2, :mjpact :ub, :line 1055}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1469, :line 1056, :clk 2239.6031}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1470, :line 1057, :clk 2239.6031}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1472, :line 1058, :clk 2240.2991}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1473, :line 1059, :clk 2240.2991, :ends 2241.7991}
 {:clk 2240.6031, :act :m2-blocked, :m :m2, :mjpact :bl, :line 1060}
 {:clk 2241.711, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2232.2991, :j 1467, :line 1061}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1468, :line 1062, :clk 2241.711}
 {:clk 2241.711, :act :m2-unblocked, :m :m2, :mjpact :ub, :line 1063}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1470, :line 1064, :clk 2241.711}
 {:clk 2241.7991, :act :m1-blocked, :m :m1, :mjpact :bl, :line 1065}
 {:clk 2243.211, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2233.7991, :j 1468, :line 1066}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1469, :line 1067, :clk 2243.211}
 {:clk 2244.211, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2235.2991, :j 1469, :line 1068}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1470, :line 1069, :clk 2244.211}
 {:clk 2245.211, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2236.2991, :j 1470, :line 1070}
 {:clk 2245.211, :act :m3-starved, :m :m3, :mjpact :st, :line 1071}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1471, :line 1072, :clk 2245.3898}
 {:clk 2245.3898, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 1073}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1473, :line 1074, :clk 2245.3898}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1474, :line 1075, :clk 2245.3898, :ends 2246.3898}
 {:clk 2246.3898, :act :m1-blocked, :m :m1, :mjpact :bl, :line 1076}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1471, :line 1077, :clk 2246.8898}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1471, :line 1078, :clk 2246.8898}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1472, :line 1079, :clk 2246.8898}
 {:clk 2246.8898, :act :m3-unstarved, :m :m3, :mjpact :us, :line 1080}
 {:clk 2246.8898, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 1081}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1474, :line 1082, :clk 2246.8898}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1475, :line 1083, :clk 2246.8898, :ends 2248.8657}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1472, :line 1084, :clk 2248.3898}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1473, :line 1085, :clk 2248.3898}
 {:clk 2248.8571, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2237.2991, :j 1471, :line 1086}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1472, :line 1087, :clk 2248.8571}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1475, :line 1088, :clk 2248.8657}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1476, :line 1089, :clk 2248.8657, :ends 2250.81}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1473, :line 1090, :clk 2249.8898}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1474, :line 1091, :clk 2249.8898}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1476, :line 1092, :clk 2250.81}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1477, :line 1093, :clk 2250.81, :ends 2251.81}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1474, :line 1094, :clk 2250.8898}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1475, :line 1095, :clk 2250.8898}
 {:clk 2251.0133, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2238.7991, :j 1472, :line 1096}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1473, :line 1097, :clk 2251.0133}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1477, :line 1098, :clk 2251.81}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1478, :line 1099, :clk 2251.81, :ends 2253.31}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1475, :line 1100, :clk 2251.8898}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1476, :line 1101, :clk 2251.8898}
 {:clk 2252.5133, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2240.2991, :j 1473, :line 1102}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1474, :line 1103, :clk 2252.5133}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1478, :line 1104, :clk 2253.31}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1479, :line 1105, :clk 2253.31, :ends 2254.31}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1476, :line 1106, :clk 2253.3898}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1477, :line 1107, :clk 2253.3898}
 {:clk 2253.5133, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2245.3898, :j 1474, :line 1108}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1475, :line 1109, :clk 2253.5133}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1479, :line 1110, :clk 2254.31}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1480, :line 1111, :clk 2254.31, :ends 2255.31}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1477, :line 1112, :clk 2254.3898}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1478, :line 1113, :clk 2254.3898}
 {:clk 2254.5133, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2246.8898, :j 1475, :line 1114}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1476, :line 1115, :clk 2254.5133}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1480, :line 1116, :clk 2255.31}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1481, :line 1117, :clk 2255.31, :ends 2256.81}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1478, :line 1118, :clk 2255.8898}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1479, :line 1119, :clk 2255.8898}
 {:clk 2256.0133, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2248.8657, :j 1476, :line 1120}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1477, :line 1121, :clk 2256.0133}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1481, :line 1122, :clk 2256.81}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1482, :line 1123, :clk 2256.81, :ends 2258.31}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1479, :line 1124, :clk 2256.8898}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1480, :line 1125, :clk 2256.8898}
 {:clk 2257.0133, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2250.81, :j 1477, :line 1126}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1478, :line 1127, :clk 2257.0133}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1482, :line 1128, :clk 2258.31}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1483, :line 1129, :clk 2258.31, :ends 2262.3993}
 {:clk 2258.5133, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2251.81, :j 1478, :line 1130}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1479, :line 1131, :clk 2258.5133}
 {:clk 2259.5133, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2253.31, :j 1479, :line 1132}
 {:clk 2259.5133, :act :m3-starved, :m :m3, :mjpact :st, :line 1133}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1480, :line 1134, :clk 2260.4628}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1481, :line 1135, :clk 2260.4628}
 {:clk 2260.4628, :act :m3-unstarved, :m :m3, :mjpact :us, :line 1136}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1480, :line 1137, :clk 2260.4628}
 {:clk 2261.4628, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2254.31, :j 1480, :line 1138}
 {:clk 2261.4628, :act :m3-starved, :m :m3, :mjpact :st, :line 1139}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1481, :line 1140, :clk 2262.0855}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1482, :line 1141, :clk 2262.0855}
 {:clk 2262.0855, :act :m3-unstarved, :m :m3, :mjpact :us, :line 1142}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1481, :line 1143, :clk 2262.0855}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1483, :line 1144, :clk 2262.3993}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1484, :line 1145, :clk 2262.3993, :ends 2263.8993}
 {:clk 2263.5855, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2255.31, :j 1481, :line 1146}
 {:clk 2263.5855, :act :m3-starved, :m :m3, :mjpact :st, :line 1147}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1484, :line 1148, :clk 2263.8993}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1485, :line 1149, :clk 2263.8993, :ends 2265.3993}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1482, :line 1150, :clk 2264.3758}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1483, :line 1151, :clk 2264.3758}
 {:clk 2264.3758, :act :m3-unstarved, :m :m3, :mjpact :us, :line 1152}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1482, :line 1153, :clk 2264.3758}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1485, :line 1154, :clk 2265.3993}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1486, :line 1155, :clk 2265.3993, :ends 2266.8993}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1483, :line 1156, :clk 2265.8758}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1484, :line 1157, :clk 2265.8758}
 {:clk 2265.8758, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2256.81, :j 1482, :line 1158}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1483, :line 1159, :clk 2265.8758}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1486, :line 1160, :clk 2266.8993}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1487, :line 1161, :clk 2266.8993, :ends 2268.3993}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1484, :line 1162, :clk 2267.3758}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1485, :line 1163, :clk 2267.3758}
 {:clk 2267.3758, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2258.31, :j 1483, :line 1164}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1484, :line 1165, :clk 2267.3758}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1487, :line 1166, :clk 2268.3993}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1488, :line 1167, :clk 2268.3993, :ends 2269.3993}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1485, :line 1168, :clk 2268.8758}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1486, :line 1169, :clk 2268.8758}
 {:clk 2268.8758, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2262.3993, :j 1484, :line 1170}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1485, :line 1171, :clk 2268.8758}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1488, :line 1172, :clk 2269.3993}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1489, :line 1173, :clk 2269.3993, :ends 2270.8993}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1486, :line 1174, :clk 2270.3758}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1487, :line 1175, :clk 2270.3758}
 {:clk 2270.3758, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2263.8993, :j 1485, :line 1176}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1486, :line 1177, :clk 2270.3758}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1489, :line 1178, :clk 2270.8993}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1490, :line 1179, :clk 2270.8993, :ends 2272.3993}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1487, :line 1180, :clk 2271.8758}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1488, :line 1181, :clk 2271.8758}
 {:clk 2271.8758, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2265.3993, :j 1486, :line 1182}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1487, :line 1183, :clk 2271.8758}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1490, :line 1184, :clk 2272.3993}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1491, :line 1185, :clk 2272.3993, :ends 2273.3993}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1488, :line 1186, :clk 2272.8758}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1489, :line 1187, :clk 2272.8758}
 {:clk 2273.3758, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2266.8993, :j 1487, :line 1188}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1488, :line 1189, :clk 2273.3758}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1491, :line 1190, :clk 2273.3993}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1492, :line 1191, :clk 2273.3993, :ends 2274.3993}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1489, :line 1192, :clk 2274.3758}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1490, :line 1193, :clk 2274.3758}
 {:clk 2274.3758, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2268.3993, :j 1488, :line 1194}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1489, :line 1195, :clk 2274.3758}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1492, :line 1196, :clk 2274.3993}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1493, :line 1197, :clk 2274.3993, :ends 2275.8993}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1490, :line 1198, :clk 2275.8758}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1491, :line 1199, :clk 2275.8758}
 {:clk 2275.8758, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2269.3993, :j 1489, :line 1200}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1490, :line 1201, :clk 2275.8758}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1493, :line 1202, :clk 2275.8993}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1494, :line 1203, :clk 2275.8993, :ends 2276.8993}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1491, :line 1204, :clk 2276.8758}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1492, :line 1205, :clk 2276.8758}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1494, :line 1206, :clk 2276.8993}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1495, :line 1207, :clk 2276.8993, :ends 2278.3993}
 {:clk 2277.3758, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2270.8993, :j 1490, :line 1208}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1491, :line 1209, :clk 2277.3758}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1492, :line 1210, :clk 2277.8758}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1493, :line 1211, :clk 2277.8758}
 {:clk 2278.3758, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2272.3993, :j 1491, :line 1212}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1492, :line 1213, :clk 2278.3758}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1495, :line 1214, :clk 2278.3993}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1496, :line 1215, :clk 2278.3993, :ends 2279.8993}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1493, :line 1216, :clk 2279.3758}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1494, :line 1217, :clk 2279.3758}
 {:clk 2279.3758, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2273.3993, :j 1492, :line 1218}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1493, :line 1219, :clk 2279.3758}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1496, :line 1220, :clk 2279.8993}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1497, :line 1221, :clk 2279.8993, :ends 2280.8993}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1494, :line 1222, :clk 2280.3758}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1495, :line 1223, :clk 2280.3758}
 {:clk 2280.8758, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2274.3993, :j 1493, :line 1224}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1494, :line 1225, :clk 2280.8758}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1497, :line 1226, :clk 2280.8993}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1498, :line 1227, :clk 2280.8993, :ends 2281.8993}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1495, :line 1228, :clk 2281.8758}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1496, :line 1229, :clk 2281.8758}
 {:clk 2281.8758, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2275.8993, :j 1494, :line 1230}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1495, :line 1231, :clk 2281.8758}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1498, :line 1232, :clk 2281.8993}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1499, :line 1233, :clk 2281.8993, :ends 2283.3993}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1496, :line 1234, :clk 2283.3758}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1497, :line 1235, :clk 2283.3758}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1499, :line 1236, :clk 2283.3993}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1500, :line 1237, :clk 2283.3993, :ends 2284.8993}
 {:clk 2283.9851, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2276.8993, :j 1495, :line 1238}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1496, :line 1239, :clk 2283.9851}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1497, :line 1240, :clk 2284.3758}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1498, :line 1241, :clk 2284.3758}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1500, :line 1242, :clk 2284.8993}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1501, :line 1243, :clk 2284.8993, :ends 2285.8993}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1498, :line 1244, :clk 2285.3758}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1499, :line 1245, :clk 2285.3758}
 {:clk 2285.4851, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2278.3993, :j 1496, :line 1246}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1497, :line 1247, :clk 2285.4851}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1501, :line 1248, :clk 2285.8993}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1502, :line 1249, :clk 2285.8993, :ends 2287.3993}
 {:clk 2286.4851, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2279.8993, :j 1497, :line 1250}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1498, :line 1251, :clk 2286.4851}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1499, :line 1252, :clk 2286.8758}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1500, :line 1253, :clk 2286.8758}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1502, :line 1254, :clk 2287.3993}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1503, :line 1255, :clk 2287.3993, :ends 2290.2691}
 {:clk 2287.4851, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2280.8993, :j 1498, :line 1256}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1499, :line 1257, :clk 2287.4851}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1500, :line 1258, :clk 2288.3758}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1501, :line 1259, :clk 2288.3758}
 {:clk 2289.0492, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2281.8993, :j 1499, :line 1260}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1500, :line 1261, :clk 2289.0492}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1501, :line 1262, :clk 2290.1216}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1502, :line 1263, :clk 2290.1216}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1503, :line 1264, :clk 2290.2691}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1504, :line 1265, :clk 2290.2691, :ends 2291.2691}
 {:clk 2290.5492, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2283.3993, :j 1500, :line 1266}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1501, :line 1267, :clk 2290.5492}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1504, :line 1268, :clk 2291.2691}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1505, :line 1269, :clk 2291.2691, :ends 2292.7691}
 {:clk 2291.5492, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2284.8993, :j 1501, :line 1270}
 {:clk 2291.5492, :act :m3-starved, :m :m3, :mjpact :st, :line 1271}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1502, :line 1272, :clk 2291.6216}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1503, :line 1273, :clk 2291.6216}
 {:clk 2291.6216, :act :m3-unstarved, :m :m3, :mjpact :us, :line 1274}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1502, :line 1275, :clk 2291.6216}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1503, :line 1276, :clk 2292.6216}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1504, :line 1277, :clk 2292.6216}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1505, :line 1278, :clk 2292.7691}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1506, :line 1279, :clk 2292.7691, :ends 2293.7691}
 {:clk 2293.1216, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2285.8993, :j 1502, :line 1280}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1503, :line 1281, :clk 2293.1216}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1504, :line 1282, :clk 2293.6216}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1505, :line 1283, :clk 2293.6216}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1506, :line 1284, :clk 2293.7691}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1507, :line 1285, :clk 2293.7691, :ends 2294.7691}
 {:clk 2294.1216, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2287.3993, :j 1503, :line 1286}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1504, :line 1287, :clk 2294.1216}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1507, :line 1288, :clk 2294.7691}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1508, :line 1289, :clk 2294.7691, :ends 2296.2691}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1505, :line 1290, :clk 2295.1216}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1506, :line 1291, :clk 2295.1216}
 {:clk 2295.1216, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2290.2691, :j 1504, :line 1292}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1505, :line 1293, :clk 2295.1216}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1506, :line 1294, :clk 2296.1216}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1507, :line 1295, :clk 2296.1216}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1508, :line 1296, :clk 2296.2691}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1509, :line 1297, :clk 2296.2691, :ends 2297.7691}
 {:clk 2296.6216, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2291.2691, :j 1505, :line 1298}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1506, :line 1299, :clk 2296.6216}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1507, :line 1300, :clk 2297.1216}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1508, :line 1301, :clk 2297.1216}
 {:clk 2297.6216, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2292.7691, :j 1506, :line 1302}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1507, :line 1303, :clk 2297.6216}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1509, :line 1304, :clk 2297.7691}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1510, :line 1305, :clk 2297.7691, :ends 2299.2691}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1508, :line 1306, :clk 2298.6216}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1509, :line 1307, :clk 2298.6216}
 {:clk 2298.6216, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2293.7691, :j 1507, :line 1308}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1508, :line 1309, :clk 2298.6216}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1510, :line 1310, :clk 2299.2691}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1511, :line 1311, :clk 2299.2691, :ends 2300.2691}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1509, :line 1312, :clk 2300.1216}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1510, :line 1313, :clk 2300.1216}
 {:clk 2300.1216, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2294.7691, :j 1508, :line 1314}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1509, :line 1315, :clk 2300.1216}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1511, :line 1316, :clk 2300.2691}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1512, :line 1317, :clk 2300.2691, :ends 2301.7691}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1510, :line 1318, :clk 2301.6216}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1511, :line 1319, :clk 2301.6216}
 {:clk 2301.6216, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2296.2691, :j 1509, :line 1320}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1510, :line 1321, :clk 2301.6216}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1512, :line 1322, :clk 2301.7691}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1513, :line 1323, :clk 2301.7691, :ends 2303.2691}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1511, :line 1324, :clk 2302.6216}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1512, :line 1325, :clk 2302.6216}
 {:clk 2303.1216, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2297.7691, :j 1510, :line 1326}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1511, :line 1327, :clk 2303.1216}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1513, :line 1328, :clk 2303.2691}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1514, :line 1329, :clk 2303.2691, :ends 2304.7691}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1512, :line 1330, :clk 2304.1216}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1513, :line 1331, :clk 2304.1216}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1514, :line 1332, :clk 2304.7691}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1515, :line 1333, :clk 2304.7691, :ends 2306.2691}
 {:clk 2304.9727, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2299.2691, :j 1511, :line 1334}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1512, :line 1335, :clk 2304.9727}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1513, :line 1336, :clk 2305.6216}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1514, :line 1337, :clk 2305.6216}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1515, :line 1338, :clk 2306.2691}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1516, :line 1339, :clk 2306.2691, :ends 2307.7691}
 {:clk 2306.4727, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2300.2691, :j 1512, :line 1340}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1513, :line 1341, :clk 2306.4727}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1514, :line 1342, :clk 2307.1216}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1515, :line 1343, :clk 2307.1216}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1516, :line 1344, :clk 2307.7691}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1517, :line 1345, :clk 2307.7691, :ends 2308.7691}
 {:clk 2307.9727, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2301.7691, :j 1513, :line 1346}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1514, :line 1347, :clk 2307.9727}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1517, :line 1348, :clk 2308.7691}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1518, :line 1349, :clk 2308.7691, :ends 2309.7691}
 {:clk 2309.4727, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2303.2691, :j 1514, :line 1350}
 {:clk 2309.4727, :act :m3-starved, :m :m3, :mjpact :st, :line 1351}
 {:clk 2309.7691, :act :m1-blocked, :m :m1, :mjpact :bl, :line 1352}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1515, :line 1353, :clk 2310.0934}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1515, :line 1354, :clk 2310.0934}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1516, :line 1355, :clk 2310.0934}
 {:clk 2310.0934, :act :m3-unstarved, :m :m3, :mjpact :us, :line 1356}
 {:clk 2310.0934, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 1357}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1518, :line 1358, :clk 2310.0934}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1519, :line 1359, :clk 2310.0934, :ends 2311.5934}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1519, :line 1360, :clk 2311.5934}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1520, :line 1361, :clk 2311.5934, :ends 2313.3578}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1516, :line 1362, :clk 2311.5934}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1517, :line 1363, :clk 2311.5934}
 {:clk 2311.5934, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2304.7691, :j 1515, :line 1364}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1516, :line 1365, :clk 2311.5934}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1517, :line 1366, :clk 2312.5934}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1518, :line 1367, :clk 2312.5934}
 {:clk 2313.0934, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2306.2691, :j 1516, :line 1368}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1517, :line 1369, :clk 2313.0934}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1520, :line 1370, :clk 2313.3578}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1521, :line 1371, :clk 2313.3578, :ends 2314.8578}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1518, :line 1372, :clk 2313.5934}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1519, :line 1373, :clk 2313.5934}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1521, :line 1374, :clk 2314.8578}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1522, :line 1375, :clk 2314.8578, :ends 2316.62}
 {:clk 2314.8942, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2307.7691, :j 1517, :line 1376}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1518, :line 1377, :clk 2314.8942}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1519, :line 1378, :clk 2315.0934}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1520, :line 1379, :clk 2315.0934}
 {:clk 2315.8942, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2308.7691, :j 1518, :line 1380}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1519, :line 1381, :clk 2315.8942}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1520, :line 1382, :clk 2316.0934}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1521, :line 1383, :clk 2316.0934}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1522, :line 1384, :clk 2316.62}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1523, :line 1385, :clk 2316.62, :ends 2318.12}
 {:clk 2317.3942, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2310.0934, :j 1519, :line 1386}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1520, :line 1387, :clk 2317.3942}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1521, :line 1388, :clk 2317.5934}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1522, :line 1389, :clk 2317.5934}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1523, :line 1390, :clk 2318.12}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1524, :line 1391, :clk 2318.12, :ends 2319.62}
 {:clk 2318.3942, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2311.5934, :j 1520, :line 1392}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1521, :line 1393, :clk 2318.3942}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1522, :line 1394, :clk 2318.5934}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1523, :line 1395, :clk 2318.5934}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1524, :line 1396, :clk 2319.62}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1525, :line 1397, :clk 2319.62, :ends 2320.62}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1523, :line 1398, :clk 2320.0934}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1524, :line 1399, :clk 2320.0934}
 {:clk 2320.1375, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2313.3578, :j 1521, :line 1400}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1522, :line 1401, :clk 2320.1375}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1525, :line 1402, :clk 2320.62}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1526, :line 1403, :clk 2320.62, :ends 2322.4967}
 {:clk 2321.1375, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2314.8578, :j 1522, :line 1404}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1523, :line 1405, :clk 2321.1375}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1526, :line 1406, :clk 2322.4967}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1527, :line 1407, :clk 2322.4967, :ends 2323.4967}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1524, :line 1408, :clk 2322.6263}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1525, :line 1409, :clk 2322.6263}
 {:clk 2322.6375, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2316.62, :j 1523, :line 1410}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1524, :line 1411, :clk 2322.6375}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1527, :line 1412, :clk 2323.4967}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1528, :line 1413, :clk 2323.4967, :ends 2324.9967}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1525, :line 1414, :clk 2323.6263}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1526, :line 1415, :clk 2323.6263}
 {:clk 2324.4422, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2318.12, :j 1524, :line 1416}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1525, :line 1417, :clk 2324.4422}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1528, :line 1418, :clk 2324.9967}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1529, :line 1419, :clk 2324.9967, :ends 2325.9967}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1526, :line 1420, :clk 2325.2527}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1527, :line 1421, :clk 2325.2527}
 {:clk 2325.4422, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2319.62, :j 1525, :line 1422}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1526, :line 1423, :clk 2325.4422}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1529, :line 1424, :clk 2325.9967}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1530, :line 1425, :clk 2325.9967, :ends 2327.4967}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1527, :line 1426, :clk 2326.2527}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1528, :line 1427, :clk 2326.2527}
 {:clk 2326.9422, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2320.62, :j 1526, :line 1428}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1527, :line 1429, :clk 2326.9422}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1530, :line 1430, :clk 2327.4967}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1531, :line 1431, :clk 2327.4967, :ends 2328.4967}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1528, :line 1432, :clk 2327.7527}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1529, :line 1433, :clk 2327.7527}
 {:clk 2327.9422, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2322.4967, :j 1527, :line 1434}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1528, :line 1435, :clk 2327.9422}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1531, :line 1436, :clk 2328.4967}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1532, :line 1437, :clk 2328.4967, :ends 2329.4967}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1529, :line 1438, :clk 2328.7527}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1530, :line 1439, :clk 2328.7527}
 {:clk 2329.4422, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2323.4967, :j 1528, :line 1440}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1529, :line 1441, :clk 2329.4422}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1532, :line 1442, :clk 2329.4967}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1533, :line 1443, :clk 2329.4967, :ends 2330.4967}
 {:clk 2330.4422, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2324.9967, :j 1529, :line 1444}
 {:clk 2330.4422, :act :m3-starved, :m :m3, :mjpact :st, :line 1445}
 {:clk 2330.4967, :act :m1-blocked, :m :m1, :mjpact :bl, :line 1446}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1530, :line 1447, :clk 2336.6897}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1530, :line 1448, :clk 2336.6897}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1531, :line 1449, :clk 2336.6897}
 {:clk 2336.6897, :act :m3-unstarved, :m :m3, :mjpact :us, :line 1450}
 {:clk 2336.6897, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 1451}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1533, :line 1452, :clk 2336.6897}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1534, :line 1453, :clk 2336.6897, :ends 2337.6897}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1534, :line 1454, :clk 2337.6897}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1535, :line 1455, :clk 2337.6897, :ends 2338.6897}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1531, :line 1456, :clk 2337.6897}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1532, :line 1457, :clk 2337.6897}
 {:clk 2338.1897, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2325.9967, :j 1530, :line 1458}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1531, :line 1459, :clk 2338.1897}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1535, :line 1460, :clk 2338.6897}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1536, :line 1461, :clk 2338.6897, :ends 2339.6897}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1532, :line 1462, :clk 2338.6897}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1533, :line 1463, :clk 2338.6897}
 {:clk 2339.1897, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2327.4967, :j 1531, :line 1464}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1532, :line 1465, :clk 2339.1897}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1536, :line 1466, :clk 2339.6897}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1537, :line 1467, :clk 2339.6897, :ends 2340.6897}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1533, :line 1468, :clk 2339.6897}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1534, :line 1469, :clk 2339.6897}
 {:clk 2340.1897, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2328.4967, :j 1532, :line 1470}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1533, :line 1471, :clk 2340.1897}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1537, :line 1472, :clk 2340.6897}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1538, :line 1473, :clk 2340.6897, :ends 2341.6897}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1534, :line 1474, :clk 2340.6897}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1535, :line 1475, :clk 2340.6897}
 {:clk 2341.1897, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2329.4967, :j 1533, :line 1476}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1534, :line 1477, :clk 2341.1897}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1538, :line 1478, :clk 2341.6897}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1539, :line 1479, :clk 2341.6897, :ends 2343.1897}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1535, :line 1480, :clk 2341.6897}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1536, :line 1481, :clk 2341.6897}
 {:clk 2342.1897, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2336.6897, :j 1534, :line 1482}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1535, :line 1483, :clk 2342.1897}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1536, :line 1484, :clk 2342.6897}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1537, :line 1485, :clk 2342.6897}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1539, :line 1486, :clk 2343.1897}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1540, :line 1487, :clk 2343.1897, :ends 2345.1385}
 {:clk 2343.4592, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2337.6897, :j 1535, :line 1488}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1536, :line 1489, :clk 2343.4592}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1537, :line 1490, :clk 2343.6897}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1538, :line 1491, :clk 2343.6897}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1538, :line 1492, :clk 2344.6897}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1539, :line 1493, :clk 2344.6897}
 {:clk 2345.1047, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2338.6897, :j 1536, :line 1494}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1537, :line 1495, :clk 2345.1047}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1540, :line 1496, :clk 2345.1385}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1541, :line 1497, :clk 2345.1385, :ends 2346.6385}
 {:clk 2346.1047, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2339.6897, :j 1537, :line 1498}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1538, :line 1499, :clk 2346.1047}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1539, :line 1500, :clk 2346.1897}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1540, :line 1501, :clk 2346.1897}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1541, :line 1502, :clk 2346.6385}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1542, :line 1503, :clk 2346.6385, :ends 2348.1385}
 {:clk 2347.1047, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2340.6897, :j 1538, :line 1504}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1539, :line 1505, :clk 2347.1047}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1540, :line 1506, :clk 2347.6897}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1541, :line 1507, :clk 2347.6897}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1542, :line 1508, :clk 2348.1385}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1543, :line 1509, :clk 2348.1385, :ends 2349.1385}
 {:clk 2348.6994, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2341.6897, :j 1539, :line 1510}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1540, :line 1511, :clk 2348.6994}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1543, :line 1512, :clk 2349.1385}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1544, :line 1513, :clk 2349.1385, :ends 2350.6385}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1541, :line 1514, :clk 2349.1897}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1542, :line 1515, :clk 2349.1897}
 {:clk 2350.1994, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2343.1897, :j 1540, :line 1516}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1541, :line 1517, :clk 2350.1994}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1544, :line 1518, :clk 2350.6385}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1545, :line 1519, :clk 2350.6385, :ends 2352.1385}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1542, :line 1520, :clk 2350.6897}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1543, :line 1521, :clk 2350.6897}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1543, :line 1522, :clk 2351.6897}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1544, :line 1523, :clk 2351.6897}
 {:clk 2351.6994, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2345.1385, :j 1541, :line 1524}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1542, :line 1525, :clk 2351.6994}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1545, :line 1526, :clk 2352.1385}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1546, :line 1527, :clk 2352.1385, :ends 2353.6385}
 {:clk 2353.1994, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2346.6385, :j 1542, :line 1528}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1543, :line 1529, :clk 2353.1994}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1546, :line 1530, :clk 2353.6385}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1547, :line 1531, :clk 2353.6385, :ends 2355.1385}
 {:clk 2354.1994, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2348.1385, :j 1543, :line 1532}
 {:clk 2354.1994, :act :m3-starved, :m :m3, :mjpact :st, :line 1533}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1544, :line 1534, :clk 2354.2684}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1545, :line 1535, :clk 2354.2684}
 {:clk 2354.2684, :act :m3-unstarved, :m :m3, :mjpact :us, :line 1536}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1544, :line 1537, :clk 2354.2684}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1547, :line 1538, :clk 2355.1385}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1548, :line 1539, :clk 2355.1385, :ends 2356.1385}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1545, :line 1540, :clk 2355.7684}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1546, :line 1541, :clk 2355.7684}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1548, :line 1542, :clk 2356.1385}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1549, :line 1543, :clk 2356.1385, :ends 2357.6385}
 {:clk 2357.0355, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2349.1385, :j 1544, :line 1544}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1545, :line 1545, :clk 2357.0355}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1546, :line 1546, :clk 2357.2684}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1547, :line 1547, :clk 2357.2684}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1549, :line 1548, :clk 2357.6385}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1550, :line 1549, :clk 2357.6385, :ends 2358.6385}
 {:clk 2358.5355, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2350.6385, :j 1545, :line 1550}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1546, :line 1551, :clk 2358.5355}
 {:clk 2358.6385, :act :m1-blocked, :m :m1, :mjpact :bl, :line 1552}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1547, :line 1553, :clk 2358.7684}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1548, :line 1554, :clk 2358.7684}
 {:clk 2358.7684, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 1555}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1550, :line 1556, :clk 2358.7684}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1551, :line 1557, :clk 2358.7684, :ends 2360.3146}
 {:clk 2360.0355, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2352.1385, :j 1546, :line 1558}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1547, :line 1559, :clk 2360.0355}
 {:clk 2360.3146, :act :m1-blocked, :m :m1, :mjpact :bl, :line 1560}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1548, :line 1561, :clk 2360.5058}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1549, :line 1562, :clk 2360.5058}
 {:clk 2360.5058, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 1563}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1551, :line 1564, :clk 2360.5058}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1552, :line 1565, :clk 2360.5058, :ends 2361.5058}
 {:clk 2361.5058, :act :m1-blocked, :m :m1, :mjpact :bl, :line 1566}
 {:clk 2361.5355, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2353.6385, :j 1547, :line 1567}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1548, :line 1568, :clk 2361.5355}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1549, :line 1569, :clk 2362.0058}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1550, :line 1570, :clk 2362.0058}
 {:clk 2362.0058, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 1571}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1552, :line 1572, :clk 2362.0058}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1553, :line 1573, :clk 2362.0058, :ends 2363.0058}
 {:clk 2362.5355, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2355.1385, :j 1548, :line 1574}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1549, :line 1575, :clk 2362.5355}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1553, :line 1576, :clk 2363.0058}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1554, :line 1577, :clk 2363.0058, :ends 2364.0058}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1550, :line 1578, :clk 2363.0058}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1551, :line 1579, :clk 2363.0058}
 {:clk 2364.0058, :act :m1-blocked, :m :m1, :mjpact :bl, :line 1580}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1551, :line 1581, :clk 2364.5058}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1552, :line 1582, :clk 2364.5058}
 {:clk 2364.5058, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 1583}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1554, :line 1584, :clk 2364.5058}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1555, :line 1585, :clk 2364.5058, :ends 2366.0058}
 {:clk 2364.8974, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2356.1385, :j 1549, :line 1586}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1550, :line 1587, :clk 2364.8974}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1552, :line 1588, :clk 2365.5058}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1553, :line 1589, :clk 2365.5058}
 {:clk 2365.8974, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2357.6385, :j 1550, :line 1590}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1551, :line 1591, :clk 2365.8974}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1555, :line 1592, :clk 2366.0058}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1556, :line 1593, :clk 2366.0058, :ends 2367.0058}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1553, :line 1594, :clk 2366.5058}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1554, :line 1595, :clk 2366.5058}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1556, :line 1596, :clk 2367.0058}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1557, :line 1597, :clk 2367.0058, :ends 2368.0058}
 {:clk 2367.3974, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2358.7684, :j 1551, :line 1598}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1552, :line 1599, :clk 2367.3974}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1554, :line 1600, :clk 2367.5058}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1555, :line 1601, :clk 2367.5058}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1557, :line 1602, :clk 2368.0058}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1558, :line 1603, :clk 2368.0058, :ends 2369.0058}
 {:clk 2368.3974, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2360.5058, :j 1552, :line 1604}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1553, :line 1605, :clk 2368.3974}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1558, :line 1606, :clk 2369.0058}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1559, :line 1607, :clk 2369.0058, :ends 2370.5058}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1555, :line 1608, :clk 2369.0058}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1556, :line 1609, :clk 2369.0058}
 {:clk 2369.4361, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2362.0058, :j 1553, :line 1610}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1554, :line 1611, :clk 2369.4361}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1556, :line 1612, :clk 2370.0058}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1557, :line 1613, :clk 2370.0058}
 {:clk 2370.4361, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2363.0058, :j 1554, :line 1614}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1555, :line 1615, :clk 2370.4361}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1559, :line 1616, :clk 2370.5058}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1560, :line 1617, :clk 2370.5058, :ends 2372.6109}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1557, :line 1618, :clk 2371.0058}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1558, :line 1619, :clk 2371.0058}
 {:clk 2371.9361, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2364.5058, :j 1555, :line 1620}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1556, :line 1621, :clk 2371.9361}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1558, :line 1622, :clk 2372.0058}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1559, :line 1623, :clk 2372.0058}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1560, :line 1624, :clk 2372.6109}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1561, :line 1625, :clk 2372.6109, :ends 2375.5357}
 {:clk 2372.9361, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2366.0058, :j 1556, :line 1626}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1557, :line 1627, :clk 2372.9361}
 {:clk 2373.9361, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2367.0058, :j 1557, :line 1628}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1558, :line 1629, :clk 2373.9361}
 {:clk 2374.9361, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2368.0058, :j 1558, :line 1630}
 {:clk 2374.9361, :act :m3-starved, :m :m3, :mjpact :st, :line 1631}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1559, :line 1632, :clk 2375.1125}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1560, :line 1633, :clk 2375.1125}
 {:clk 2375.1125, :act :m3-unstarved, :m :m3, :mjpact :us, :line 1634}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1559, :line 1635, :clk 2375.1125}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1561, :line 1636, :clk 2375.5357}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1562, :line 1637, :clk 2375.5357, :ends 2376.775}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1560, :line 1638, :clk 2376.6125}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1561, :line 1639, :clk 2376.6125}
 {:clk 2376.6125, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2369.0058, :j 1559, :line 1640}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1560, :line 1641, :clk 2376.6125}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1562, :line 1642, :clk 2376.775}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1563, :line 1643, :clk 2376.775, :ends 2377.775}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1563, :line 1644, :clk 2377.775}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1564, :line 1645, :clk 2377.775, :ends 2378.775}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1561, :line 1646, :clk 2378.1125}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1562, :line 1647, :clk 2378.1125}
 {:clk 2378.1125, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2370.5058, :j 1560, :line 1648}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1561, :line 1649, :clk 2378.1125}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1564, :line 1650, :clk 2378.775}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1565, :line 1651, :clk 2378.775, :ends 2379.775}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1562, :line 1652, :clk 2379.1125}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1563, :line 1653, :clk 2379.1125}
 {:clk 2379.6125, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2372.6109, :j 1561, :line 1654}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1562, :line 1655, :clk 2379.6125}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1565, :line 1656, :clk 2379.775}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1566, :line 1657, :clk 2379.775, :ends 2380.775}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1563, :line 1658, :clk 2380.4249}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1564, :line 1659, :clk 2380.4249}
 {:clk 2380.6125, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2375.5357, :j 1562, :line 1660}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1563, :line 1661, :clk 2380.6125}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1566, :line 1662, :clk 2380.775}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1567, :line 1663, :clk 2380.775, :ends 2382.275}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1564, :line 1664, :clk 2381.4249}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1565, :line 1665, :clk 2381.4249}
 {:clk 2381.6125, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2376.775, :j 1563, :line 1666}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1564, :line 1667, :clk 2381.6125}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1567, :line 1668, :clk 2382.275}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1568, :line 1669, :clk 2382.275, :ends 2383.275}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1565, :line 1670, :clk 2382.4249}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1566, :line 1671, :clk 2382.4249}
 {:clk 2382.6125, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2377.775, :j 1564, :line 1672}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1565, :line 1673, :clk 2382.6125}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1568, :line 1674, :clk 2383.275}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1569, :line 1675, :clk 2383.275, :ends 2384.2858}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1566, :line 1676, :clk 2383.4249}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1567, :line 1677, :clk 2383.4249}
 {:clk 2383.6125, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2378.775, :j 1565, :line 1678}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1566, :line 1679, :clk 2383.6125}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1569, :line 1680, :clk 2384.2858}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1570, :line 1681, :clk 2384.2858, :ends 2385.2858}
 {:clk 2384.6125, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2379.775, :j 1566, :line 1682}
 {:clk 2384.6125, :act :m3-starved, :m :m3, :mjpact :st, :line 1683}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1567, :line 1684, :clk 2384.9249}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1568, :line 1685, :clk 2384.9249}
 {:clk 2384.9249, :act :m3-unstarved, :m :m3, :mjpact :us, :line 1686}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1567, :line 1687, :clk 2384.9249}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1570, :line 1688, :clk 2385.2858}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1571, :line 1689, :clk 2385.2858, :ends 2387.3978}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1568, :line 1690, :clk 2385.9249}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1569, :line 1691, :clk 2385.9249}
 {:clk 2386.4249, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2380.775, :j 1567, :line 1692}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1568, :line 1693, :clk 2386.4249}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1569, :line 1694, :clk 2386.9249}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1570, :line 1695, :clk 2386.9249}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1571, :line 1696, :clk 2387.3978}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1572, :line 1697, :clk 2387.3978, :ends 2389.3629}
 {:clk 2387.4249, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2382.275, :j 1568, :line 1698}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1569, :line 1699, :clk 2387.4249}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1570, :line 1700, :clk 2387.9249}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1571, :line 1701, :clk 2387.9249}
 {:clk 2388.4249, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2383.275, :j 1569, :line 1702}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1570, :line 1703, :clk 2388.4249}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1572, :line 1704, :clk 2389.3629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1573, :line 1705, :clk 2389.3629, :ends 2390.8629}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1571, :line 1706, :clk 2389.4249}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1572, :line 1707, :clk 2389.4249}
 {:clk 2389.4249, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2384.2858, :j 1570, :line 1708}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1571, :line 1709, :clk 2389.4249}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1573, :line 1710, :clk 2390.8629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1574, :line 1711, :clk 2390.8629, :ends 2391.8629}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1572, :line 1712, :clk 2390.9249}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1573, :line 1713, :clk 2390.9249}
 {:clk 2390.9249, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2385.2858, :j 1571, :line 1714}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1572, :line 1715, :clk 2390.9249}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1574, :line 1716, :clk 2391.8629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1575, :line 1717, :clk 2391.8629, :ends 2392.8629}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1573, :line 1718, :clk 2392.4249}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1574, :line 1719, :clk 2392.4249}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1575, :line 1720, :clk 2392.8629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1576, :line 1721, :clk 2392.8629, :ends 2394.3629}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1574, :line 1722, :clk 2393.4249}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1575, :line 1723, :clk 2393.4249}
 {:clk 2393.564, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2387.3978, :j 1572, :line 1724}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1573, :line 1725, :clk 2393.564}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1576, :line 1726, :clk 2394.3629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1577, :line 1727, :clk 2394.3629, :ends 2395.3629}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1575, :line 1728, :clk 2394.4249}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1576, :line 1729, :clk 2394.4249}
 {:clk 2395.064, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2389.3629, :j 1573, :line 1730}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1574, :line 1731, :clk 2395.064}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1577, :line 1732, :clk 2395.3629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1578, :line 1733, :clk 2395.3629, :ends 2396.3629}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1576, :line 1734, :clk 2395.9249}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1577, :line 1735, :clk 2395.9249}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1578, :line 1736, :clk 2396.3629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1579, :line 1737, :clk 2396.3629, :ends 2397.8629}
 {:clk 2396.4684, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2390.8629, :j 1574, :line 1738}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1575, :line 1739, :clk 2396.4684}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1577, :line 1740, :clk 2396.9249}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1578, :line 1741, :clk 2396.9249}
 {:clk 2397.4684, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2391.8629, :j 1575, :line 1742}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1576, :line 1743, :clk 2397.4684}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1579, :line 1744, :clk 2397.8629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1580, :line 1745, :clk 2397.8629, :ends 2399.3629}
 {:clk 2398.9684, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2392.8629, :j 1576, :line 1746}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1577, :line 1747, :clk 2398.9684}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1578, :line 1748, :clk 2399.031}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1579, :line 1749, :clk 2399.031}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1580, :line 1750, :clk 2399.3629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1581, :line 1751, :clk 2399.3629, :ends 2400.8629}
 {:clk 2399.9684, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2394.3629, :j 1577, :line 1752}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1578, :line 1753, :clk 2399.9684}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1579, :line 1754, :clk 2400.531}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1580, :line 1755, :clk 2400.531}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1581, :line 1756, :clk 2400.8629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1582, :line 1757, :clk 2400.8629, :ends 2402.3629}
 {:clk 2400.9684, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2395.3629, :j 1578, :line 1758}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1579, :line 1759, :clk 2400.9684}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1580, :line 1760, :clk 2402.031}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1581, :line 1761, :clk 2402.031}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1582, :line 1762, :clk 2402.3629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1583, :line 1763, :clk 2402.3629, :ends 2403.8629}
 {:clk 2402.4684, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2396.3629, :j 1579, :line 1764}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1580, :line 1765, :clk 2402.4684}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1581, :line 1766, :clk 2403.531}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1582, :line 1767, :clk 2403.531}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1583, :line 1768, :clk 2403.8629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1584, :line 1769, :clk 2403.8629, :ends 2404.8629}
 {:clk 2403.9684, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2397.8629, :j 1580, :line 1770}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1581, :line 1771, :clk 2403.9684}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1584, :line 1772, :clk 2404.8629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1585, :line 1773, :clk 2404.8629, :ends 2406.3629}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1582, :line 1774, :clk 2405.031}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1583, :line 1775, :clk 2405.031}
 {:clk 2405.4684, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2399.3629, :j 1581, :line 1776}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1582, :line 1777, :clk 2405.4684}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1585, :line 1778, :clk 2406.3629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1586, :line 1779, :clk 2406.3629, :ends 2407.8629}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1583, :line 1780, :clk 2406.531}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1584, :line 1781, :clk 2406.531}
 {:clk 2406.9684, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2400.8629, :j 1582, :line 1782}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1583, :line 1783, :clk 2406.9684}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1584, :line 1784, :clk 2407.531}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1585, :line 1785, :clk 2407.531}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1586, :line 1786, :clk 2407.8629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1587, :line 1787, :clk 2407.8629, :ends 2409.3629}
 {:clk 2408.4684, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2402.3629, :j 1583, :line 1788}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1584, :line 1789, :clk 2408.4684}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1585, :line 1790, :clk 2409.031}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1586, :line 1791, :clk 2409.031}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1587, :line 1792, :clk 2409.3629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1588, :line 1793, :clk 2409.3629, :ends 2410.3629}
 {:clk 2409.4684, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2403.8629, :j 1584, :line 1794}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1585, :line 1795, :clk 2409.4684}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1588, :line 1796, :clk 2410.3629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1589, :line 1797, :clk 2410.3629, :ends 2411.8629}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1586, :line 1798, :clk 2410.531}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1587, :line 1799, :clk 2410.531}
 {:clk 2410.9684, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2404.8629, :j 1585, :line 1800}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1586, :line 1801, :clk 2410.9684}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1589, :line 1802, :clk 2411.8629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1590, :line 1803, :clk 2411.8629, :ends 2412.8629}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1587, :line 1804, :clk 2412.2189}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1588, :line 1805, :clk 2412.2189}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1590, :line 1806, :clk 2412.8629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1591, :line 1807, :clk 2412.8629, :ends 2413.8629}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1588, :line 1808, :clk 2413.2189}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1589, :line 1809, :clk 2413.2189}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1591, :line 1810, :clk 2413.8629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1592, :line 1811, :clk 2413.8629, :ends 2415.3629}
 {:clk 2413.9227, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2406.3629, :j 1586, :line 1812}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1587, :line 1813, :clk 2413.9227}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1589, :line 1814, :clk 2414.7189}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1590, :line 1815, :clk 2414.7189}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1592, :line 1816, :clk 2415.3629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1593, :line 1817, :clk 2415.3629, :ends 2416.3629}
 {:clk 2415.4227, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2407.8629, :j 1587, :line 1818}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1588, :line 1819, :clk 2415.4227}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1590, :line 1820, :clk 2415.7189}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1591, :line 1821, :clk 2415.7189}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1593, :line 1822, :clk 2416.3629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1594, :line 1823, :clk 2416.3629, :ends 2417.8629}
 {:clk 2416.4227, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2409.3629, :j 1588, :line 1824}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1589, :line 1825, :clk 2416.4227}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1591, :line 1826, :clk 2416.7189}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1592, :line 1827, :clk 2416.7189}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1594, :line 1828, :clk 2417.8629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1595, :line 1829, :clk 2417.8629, :ends 2419.3629}
 {:clk 2417.9227, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2410.3629, :j 1589, :line 1830}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1590, :line 1831, :clk 2417.9227}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1592, :line 1832, :clk 2418.2189}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1593, :line 1833, :clk 2418.2189}
 {:clk 2418.9227, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2411.8629, :j 1590, :line 1834}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1591, :line 1835, :clk 2418.9227}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1593, :line 1836, :clk 2419.2189}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1594, :line 1837, :clk 2419.2189}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1595, :line 1838, :clk 2419.3629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1596, :line 1839, :clk 2419.3629, :ends 2420.8629}
 {:clk 2419.9938, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2412.8629, :j 1591, :line 1840}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1592, :line 1841, :clk 2419.9938}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1594, :line 1842, :clk 2420.7189}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1595, :line 1843, :clk 2420.7189}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1596, :line 1844, :clk 2420.8629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1597, :line 1845, :clk 2420.8629, :ends 2421.8629}
 {:clk 2421.4938, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2413.8629, :j 1592, :line 1846}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1593, :line 1847, :clk 2421.4938}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1597, :line 1848, :clk 2421.8629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1598, :line 1849, :clk 2421.8629, :ends 2423.3629}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1595, :line 1850, :clk 2422.2189}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1596, :line 1851, :clk 2422.2189}
 {:clk 2422.4938, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2415.3629, :j 1593, :line 1852}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1594, :line 1853, :clk 2422.4938}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1598, :line 1854, :clk 2423.3629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1599, :line 1855, :clk 2423.3629, :ends 2424.8629}
 {:clk 2423.9938, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2416.3629, :j 1594, :line 1856}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1595, :line 1857, :clk 2423.9938}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1596, :line 1858, :clk 2424.0234}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1597, :line 1859, :clk 2424.0234}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1599, :line 1860, :clk 2424.8629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1600, :line 1861, :clk 2424.8629, :ends 2425.8629}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1597, :line 1862, :clk 2425.0234}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1598, :line 1863, :clk 2425.0234}
 {:clk 2425.4938, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2417.8629, :j 1595, :line 1864}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1596, :line 1865, :clk 2425.4938}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1600, :line 1866, :clk 2425.8629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1601, :line 1867, :clk 2425.8629, :ends 2427.3629}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1598, :line 1868, :clk 2426.5234}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1599, :line 1869, :clk 2426.5234}
 {:clk 2426.9938, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2419.3629, :j 1596, :line 1870}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1597, :line 1871, :clk 2426.9938}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1601, :line 1872, :clk 2427.3629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1602, :line 1873, :clk 2427.3629, :ends 2428.3629}
 {:clk 2427.9938, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2420.8629, :j 1597, :line 1874}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1598, :line 1875, :clk 2427.9938}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1599, :line 1876, :clk 2428.0234}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1600, :line 1877, :clk 2428.0234}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1602, :line 1878, :clk 2428.3629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1603, :line 1879, :clk 2428.3629, :ends 2429.3629}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1600, :line 1880, :clk 2429.0234}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1601, :line 1881, :clk 2429.0234}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1603, :line 1882, :clk 2429.3629}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1604, :line 1883, :clk 2429.3629, :ends 2430.3629}
 {:clk 2429.4938, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2421.8629, :j 1598, :line 1884}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1599, :line 1885, :clk 2429.4938}
 {:clk 2430.3629, :act :m1-blocked, :m :m1, :mjpact :bl, :line 1886}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1601, :line 1887, :clk 2430.8}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1602, :line 1888, :clk 2430.8}
 {:clk 2430.8, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 1889}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1604, :line 1890, :clk 2430.8}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1605, :line 1891, :clk 2430.8, :ends 2432.3}
 {:clk 2430.9938, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2423.3629, :j 1599, :line 1892}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1600, :line 1893, :clk 2430.9938}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1602, :line 1894, :clk 2431.8}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1603, :line 1895, :clk 2431.8}
 {:clk 2431.9938, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2424.8629, :j 1600, :line 1896}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1601, :line 1897, :clk 2431.9938}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1605, :line 1898, :clk 2432.3}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1606, :line 1899, :clk 2432.3, :ends 2433.3}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1603, :line 1900, :clk 2432.8}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1604, :line 1901, :clk 2432.8}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1606, :line 1902, :clk 2433.3}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1607, :line 1903, :clk 2433.3, :ends 2434.8}
 {:clk 2433.4938, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2425.8629, :j 1601, :line 1904}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1602, :line 1905, :clk 2433.4938}
 {:clk 2434.8, :act :m1-blocked, :m :m1, :mjpact :bl, :line 1906}
 {:clk 2437.6939, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2427.3629, :j 1602, :line 1907}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1603, :line 1908, :clk 2437.6939}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1604, :line 1909, :clk 2438.2739}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1605, :line 1910, :clk 2438.2739}
 {:clk 2438.2739, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 1911}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1607, :line 1912, :clk 2438.2739}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1608, :line 1913, :clk 2438.2739, :ends 2439.2739}
 {:clk 2438.6939, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2428.3629, :j 1603, :line 1914}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1604, :line 1915, :clk 2438.6939}
 {:clk 2439.2739, :act :m1-blocked, :m :m1, :mjpact :bl, :line 1916}
 {:clk 2439.6939, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2429.3629, :j 1604, :line 1917}
 {:clk 2439.6939, :act :m3-starved, :m :m3, :mjpact :st, :line 1918}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1605, :line 1919, :clk 2439.7739}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1605, :line 1920, :clk 2439.7739}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1606, :line 1921, :clk 2439.7739}
 {:clk 2439.7739, :act :m3-unstarved, :m :m3, :mjpact :us, :line 1922}
 {:clk 2439.7739, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 1923}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1608, :line 1924, :clk 2439.7739}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1609, :line 1925, :clk 2439.7739, :ends 2441.2739}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1606, :line 1926, :clk 2440.7739}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1607, :line 1927, :clk 2440.7739}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1609, :line 1928, :clk 2441.2739}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1610, :line 1929, :clk 2441.2739, :ends 2442.2739}
 {:clk 2441.2739, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2430.8, :j 1605, :line 1930}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1606, :line 1931, :clk 2441.2739}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1610, :line 1932, :clk 2442.2739}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1611, :line 1933, :clk 2442.2739, :ends 2443.2739}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1607, :line 1934, :clk 2442.2739}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1608, :line 1935, :clk 2442.2739}
 {:clk 2442.2739, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2432.3, :j 1606, :line 1936}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1607, :line 1937, :clk 2442.2739}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1611, :line 1938, :clk 2443.2739}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1612, :line 1939, :clk 2443.2739, :ends 2444.2739}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1608, :line 1940, :clk 2443.2739}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1609, :line 1941, :clk 2443.2739}
 {:clk 2443.7739, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2433.3, :j 1607, :line 1942}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1608, :line 1943, :clk 2443.7739}
 {:clk 2444.2739, :act :m1-blocked, :m :m1, :mjpact :bl, :line 1944}
 {:clk 2444.7739, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2438.2739, :j 1608, :line 1945}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1609, :line 1946, :clk 2444.7739}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1609, :line 1947, :clk 2444.7739}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1610, :line 1948, :clk 2444.7739}
 {:clk 2444.7739, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 1949}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1612, :line 1950, :clk 2444.7739}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1613, :line 1951, :clk 2444.7739, :ends 2445.7739}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1613, :line 1952, :clk 2445.7739}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1614, :line 1953, :clk 2445.7739, :ends 2446.7739}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1610, :line 1954, :clk 2445.7739}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1611, :line 1955, :clk 2445.7739}
 {:clk 2446.2739, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2439.7739, :j 1609, :line 1956}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1610, :line 1957, :clk 2446.2739}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1614, :line 1958, :clk 2446.7739}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1615, :line 1959, :clk 2446.7739, :ends 2447.7739}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1611, :line 1960, :clk 2446.7739}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1612, :line 1961, :clk 2446.7739}
 {:clk 2447.2739, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2441.2739, :j 1610, :line 1962}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1611, :line 1963, :clk 2447.2739}
 {:clk 2447.7739, :act :m1-blocked, :m :m1, :mjpact :bl, :line 1964}
 {:clk 2448.2739, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2442.2739, :j 1611, :line 1965}
 {:clk 2448.2739, :act :m3-starved, :m :m3, :mjpact :st, :line 1966}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1612, :line 1967, :clk 2449.4705}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1612, :line 1968, :clk 2449.4705}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1613, :line 1969, :clk 2449.4705}
 {:clk 2449.4705, :act :m3-unstarved, :m :m3, :mjpact :us, :line 1970}
 {:clk 2449.4705, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 1971}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1615, :line 1972, :clk 2449.4705}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1616, :line 1973, :clk 2449.4705, :ends 2454.4463}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1613, :line 1974, :clk 2450.4705}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1614, :line 1975, :clk 2450.4705}
 {:clk 2450.4705, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2443.2739, :j 1612, :line 1976}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1613, :line 1977, :clk 2450.4705}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1614, :line 1978, :clk 2451.4705}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1615, :line 1979, :clk 2451.4705}
 {:clk 2451.4705, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2444.7739, :j 1613, :line 1980}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1614, :line 1981, :clk 2451.4705}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1615, :line 1982, :clk 2452.4705}
 {:clk 2452.4705, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2445.7739, :j 1614, :line 1983}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1615, :line 1984, :clk 2452.4705}
 {:clk 2452.4705, :act :m2-starved, :m :m2, :mjpact :st, :line 1985}
 {:clk 2453.4705, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2446.7739, :j 1615, :line 1986}
 {:clk 2453.4705, :act :m3-starved, :m :m3, :mjpact :st, :line 1987}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1616, :line 1988, :clk 2454.4463}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1617, :line 1989, :clk 2454.4463, :ends 2455.9463}
 {:clk 2454.4463, :act :m2-unstarved, :m :m2, :mjpact :us, :line 1990}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1616, :line 1991, :clk 2454.4463}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1617, :line 1992, :clk 2455.9463}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1618, :line 1993, :clk 2455.9463, :ends 2457.4463}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1616, :line 1994, :clk 2455.9463}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1617, :line 1995, :clk 2455.9463}
 {:clk 2455.9463, :act :m3-unstarved, :m :m3, :mjpact :us, :line 1996}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1616, :line 1997, :clk 2455.9463}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1618, :line 1998, :clk 2457.4463}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1619, :line 1999, :clk 2457.4463, :ends 2458.4463}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1617, :line 2000, :clk 2457.4463}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1618, :line 2001, :clk 2457.4463}
 {:clk 2457.4463, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2449.4705, :j 1616, :line 2002}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1617, :line 2003, :clk 2457.4463}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1619, :line 2004, :clk 2458.4463}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1620, :line 2005, :clk 2458.4463, :ends 2459.9463}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1618, :line 2006, :clk 2458.9463}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1619, :line 2007, :clk 2458.9463}
 {:clk 2458.9463, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2454.4463, :j 1617, :line 2008}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1618, :line 2009, :clk 2458.9463}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1620, :line 2010, :clk 2459.9463}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1621, :line 2011, :clk 2459.9463, :ends 2461.4463}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1619, :line 2012, :clk 2459.9463}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1620, :line 2013, :clk 2459.9463}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1621, :line 2014, :clk 2461.4463}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1622, :line 2015, :clk 2461.4463, :ends 2462.9463}
 {:clk 2461.9027, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2455.9463, :j 1618, :line 2016}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1619, :line 2017, :clk 2461.9027}
 {:clk 2462.9027, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2457.4463, :j 1619, :line 2018}
 {:clk 2462.9027, :act :m3-starved, :m :m3, :mjpact :st, :line 2019}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1622, :line 2020, :clk 2462.9463}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1623, :line 2021, :clk 2462.9463, :ends 2463.9463}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1620, :line 2022, :clk 2463.804}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1621, :line 2023, :clk 2463.804}
 {:clk 2463.804, :act :m3-unstarved, :m :m3, :mjpact :us, :line 2024}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1620, :line 2025, :clk 2463.804}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1623, :line 2026, :clk 2463.9463}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1624, :line 2027, :clk 2463.9463, :ends 2464.9463}
 {:clk 2464.9463, :act :m1-blocked, :m :m1, :mjpact :bl, :line 2028}
 {:clk 2465.304, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2458.4463, :j 1620, :line 2029}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1621, :line 2030, :clk 2465.304}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1621, :line 2031, :clk 2465.304}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1622, :line 2032, :clk 2465.304}
 {:clk 2465.304, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 2033}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1624, :line 2034, :clk 2465.304}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1625, :line 2035, :clk 2465.304, :ends 2466.804}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1625, :line 2036, :clk 2466.804}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1626, :line 2037, :clk 2466.804, :ends 2467.804}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1622, :line 2038, :clk 2466.804}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1623, :line 2039, :clk 2466.804}
 {:clk 2466.804, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2459.9463, :j 1621, :line 2040}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1622, :line 2041, :clk 2466.804}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1626, :line 2042, :clk 2467.804}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1627, :line 2043, :clk 2467.804, :ends 2470.0019}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1623, :line 2044, :clk 2467.804}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1624, :line 2045, :clk 2467.804}
 {:clk 2468.304, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2461.4463, :j 1622, :line 2046}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1623, :line 2047, :clk 2468.304}
 {:clk 2469.304, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2462.9463, :j 1623, :line 2048}
 {:clk 2469.304, :act :m3-starved, :m :m3, :mjpact :st, :line 2049}
 {:clk 2470.0019, :act :m1-blocked, :m :m1, :mjpact :bl, :line 2050}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1624, :line 2051, :clk 2473.7279}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1624, :line 2052, :clk 2473.7279}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1625, :line 2053, :clk 2473.7279}
 {:clk 2473.7279, :act :m3-unstarved, :m :m3, :mjpact :us, :line 2054}
 {:clk 2473.7279, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 2055}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1627, :line 2056, :clk 2473.7279}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1628, :line 2057, :clk 2473.7279, :ends 2474.7279}
 {:clk 2474.7279, :act :m3-starved, :m :m3, :mjpact :st, :line 2058}
 {:clk 2474.7279, :act :m1-blocked, :m :m1, :mjpact :bl, :line 2059}
 {:clk 2474.7279, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2463.9463, :j 1624, :line 2060}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1625, :line 2061, :clk 2475.2279}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1625, :line 2062, :clk 2475.2279}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1626, :line 2063, :clk 2475.2279}
 {:clk 2475.2279, :act :m3-unstarved, :m :m3, :mjpact :us, :line 2064}
 {:clk 2475.2279, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 2065}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1628, :line 2066, :clk 2475.2279}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1629, :line 2067, :clk 2475.2279, :ends 2476.7279}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1626, :line 2068, :clk 2476.2279}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1627, :line 2069, :clk 2476.2279}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1629, :line 2070, :clk 2476.7279}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1630, :line 2071, :clk 2476.7279, :ends 2478.2279}
 {:clk 2476.7279, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2465.304, :j 1625, :line 2072}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1626, :line 2073, :clk 2476.7279}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1627, :line 2074, :clk 2477.7279}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1628, :line 2075, :clk 2477.7279}
 {:clk 2477.7279, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2466.804, :j 1626, :line 2076}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1627, :line 2077, :clk 2477.7279}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1630, :line 2078, :clk 2478.2279}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1631, :line 2079, :clk 2478.2279, :ends 2479.7279}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1628, :line 2080, :clk 2478.7279}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1629, :line 2081, :clk 2478.7279}
 {:clk 2479.2279, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2467.804, :j 1627, :line 2082}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1628, :line 2083, :clk 2479.2279}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1631, :line 2084, :clk 2479.7279}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1632, :line 2085, :clk 2479.7279, :ends 2480.7279}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1629, :line 2086, :clk 2480.2279}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1630, :line 2087, :clk 2480.2279}
 {:clk 2480.2279, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2473.7279, :j 1628, :line 2088}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1629, :line 2089, :clk 2480.2279}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1632, :line 2090, :clk 2480.7279}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1633, :line 2091, :clk 2480.7279, :ends 2481.7279}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1633, :line 2092, :clk 2481.7279}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1634, :line 2093, :clk 2481.7279, :ends 2482.7279}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1630, :line 2094, :clk 2481.7279}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1631, :line 2095, :clk 2481.7279}
 {:clk 2481.7279, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2475.2279, :j 1629, :line 2096}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1630, :line 2097, :clk 2481.7279}
 {:clk 2482.7279, :act :m1-blocked, :m :m1, :mjpact :bl, :line 2098}
 {:clk 2483.2279, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2476.7279, :j 1630, :line 2099}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1631, :line 2100, :clk 2483.2279}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1631, :line 2101, :clk 2483.2279}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1632, :line 2102, :clk 2483.2279}
 {:clk 2483.2279, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 2103}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1634, :line 2104, :clk 2483.2279}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1635, :line 2105, :clk 2483.2279, :ends 2484.2279}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1635, :line 2106, :clk 2484.2279}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1636, :line 2107, :clk 2484.2279, :ends 2486.4785}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1632, :line 2108, :clk 2484.2279}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1633, :line 2109, :clk 2484.2279}
 {:clk 2484.7279, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2478.2279, :j 1631, :line 2110}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1632, :line 2111, :clk 2484.7279}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1633, :line 2112, :clk 2485.2279}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1634, :line 2113, :clk 2485.2279}
 {:clk 2485.7279, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2479.7279, :j 1632, :line 2114}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1633, :line 2115, :clk 2485.7279}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1634, :line 2116, :clk 2486.2279}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1635, :line 2117, :clk 2486.2279}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1636, :line 2118, :clk 2486.4785}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1637, :line 2119, :clk 2486.4785, :ends 2487.9785}
 {:clk 2486.7279, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2480.7279, :j 1633, :line 2120}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1634, :line 2121, :clk 2486.7279}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1635, :line 2122, :clk 2487.2279}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1636, :line 2123, :clk 2487.2279}
 {:clk 2487.7279, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2481.7279, :j 1634, :line 2124}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1635, :line 2125, :clk 2487.7279}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1637, :line 2126, :clk 2487.9785}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1638, :line 2127, :clk 2487.9785, :ends 2489.1914}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1638, :line 2128, :clk 2489.1914}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1639, :line 2129, :clk 2489.1914, :ends 2490.1914}
 {:clk 2489.2149, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2483.2279, :j 1635, :line 2130}
 {:clk 2489.2149, :act :m3-starved, :m :m3, :mjpact :st, :line 2131}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1636, :line 2132, :clk 2489.3839}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1637, :line 2133, :clk 2489.3839}
 {:clk 2489.3839, :act :m3-unstarved, :m :m3, :mjpact :us, :line 2134}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1636, :line 2135, :clk 2489.3839}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1639, :line 2136, :clk 2490.1914}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1640, :line 2137, :clk 2490.1914, :ends 2491.1914}
 {:clk 2490.3839, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2484.2279, :j 1636, :line 2138}
 {:clk 2490.3839, :act :m3-starved, :m :m3, :mjpact :st, :line 2139}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1637, :line 2140, :clk 2490.8839}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1638, :line 2141, :clk 2490.8839}
 {:clk 2490.8839, :act :m3-unstarved, :m :m3, :mjpact :us, :line 2142}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1637, :line 2143, :clk 2490.8839}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1640, :line 2144, :clk 2491.1914}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1641, :line 2145, :clk 2491.1914, :ends 2492.6914}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1638, :line 2146, :clk 2491.8839}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1639, :line 2147, :clk 2491.8839}
 {:clk 2492.3839, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2486.4785, :j 1637, :line 2148}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1638, :line 2149, :clk 2492.3839}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1641, :line 2150, :clk 2492.6914}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1642, :line 2151, :clk 2492.6914, :ends 2494.1914}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1639, :line 2152, :clk 2492.8839}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1640, :line 2153, :clk 2492.8839}
 {:clk 2493.3839, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2487.9785, :j 1638, :line 2154}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1639, :line 2155, :clk 2493.3839}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1640, :line 2156, :clk 2493.8839}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1641, :line 2157, :clk 2493.8839}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1642, :line 2158, :clk 2494.1914}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1643, :line 2159, :clk 2494.1914, :ends 2495.1914}
 {:clk 2495.0503, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2489.1914, :j 1639, :line 2160}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1640, :line 2161, :clk 2495.0503}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1643, :line 2162, :clk 2495.1914}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1644, :line 2163, :clk 2495.1914, :ends 2496.6914}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1641, :line 2164, :clk 2495.3839}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1642, :line 2165, :clk 2495.3839}
 {:clk 2496.0503, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2490.1914, :j 1640, :line 2166}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1641, :line 2167, :clk 2496.0503}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1644, :line 2168, :clk 2496.6914}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1645, :line 2169, :clk 2496.6914, :ends 2497.6914}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1642, :line 2170, :clk 2496.8839}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1643, :line 2171, :clk 2496.8839}
 {:clk 2497.5503, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2491.1914, :j 1641, :line 2172}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1642, :line 2173, :clk 2497.5503}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1645, :line 2174, :clk 2497.6914}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1646, :line 2175, :clk 2497.6914, :ends 2499.1914}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1643, :line 2176, :clk 2497.8839}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1644, :line 2177, :clk 2497.8839}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1646, :line 2178, :clk 2499.1914}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1647, :line 2179, :clk 2499.1914, :ends 2500.6914}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1644, :line 2180, :clk 2499.3839}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1645, :line 2181, :clk 2499.3839}
 {:clk 2500.3839, :act :m2-blocked, :m :m2, :mjpact :bl, :line 2182}
 {:clk 2500.6772, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2492.6914, :j 1642, :line 2183}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1643, :line 2184, :clk 2500.6772}
 {:clk 2500.6772, :act :m2-unblocked, :m :m2, :mjpact :ub, :line 2185}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1645, :line 2186, :clk 2500.6772}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1646, :line 2187, :clk 2500.6772}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1647, :line 2188, :clk 2500.6914}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1648, :line 2189, :clk 2500.6914, :ends 2502.1914}
 {:clk 2501.6772, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2494.1914, :j 1643, :line 2190}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1644, :line 2191, :clk 2501.6772}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1646, :line 2192, :clk 2502.1772}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1647, :line 2193, :clk 2502.1772}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1648, :line 2194, :clk 2502.1914}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1649, :line 2195, :clk 2502.1914, :ends 2503.6914}
 {:clk 2503.1772, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2495.1914, :j 1644, :line 2196}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1645, :line 2197, :clk 2503.1772}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1647, :line 2198, :clk 2503.6772}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1648, :line 2199, :clk 2503.6772}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1649, :line 2200, :clk 2503.6914}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1650, :line 2201, :clk 2503.6914, :ends 2504.6914}
 {:clk 2504.1772, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2496.6914, :j 1645, :line 2202}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1646, :line 2203, :clk 2504.1772}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1650, :line 2204, :clk 2504.6914}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1651, :line 2205, :clk 2504.6914, :ends 2505.6914}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1648, :line 2206, :clk 2505.1772}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1649, :line 2207, :clk 2505.1772}
 {:clk 2505.6772, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2497.6914, :j 1646, :line 2208}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1647, :line 2209, :clk 2505.6772}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1651, :line 2210, :clk 2505.6914}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1652, :line 2211, :clk 2505.6914, :ends 2507.1914}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1649, :line 2212, :clk 2506.6772}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1650, :line 2213, :clk 2506.6772}
 {:clk 2507.1772, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2499.1914, :j 1647, :line 2214}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1648, :line 2215, :clk 2507.1772}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1652, :line 2216, :clk 2507.1914}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1653, :line 2217, :clk 2507.1914, :ends 2508.942}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1650, :line 2218, :clk 2507.6772}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1651, :line 2219, :clk 2507.6772}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1651, :line 2220, :clk 2508.6772}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1652, :line 2221, :clk 2508.6772}
 {:clk 2508.6772, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2500.6914, :j 1648, :line 2222}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1649, :line 2223, :clk 2508.6772}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1653, :line 2224, :clk 2508.942}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1654, :line 2225, :clk 2508.942, :ends 2510.442}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1652, :line 2226, :clk 2510.1772}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1653, :line 2227, :clk 2510.1772}
 {:clk 2510.1772, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2502.1914, :j 1649, :line 2228}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1650, :line 2229, :clk 2510.1772}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1654, :line 2230, :clk 2510.442}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1655, :line 2231, :clk 2510.442, :ends 2511.442}
 {:clk 2511.1772, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2503.6914, :j 1650, :line 2232}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1651, :line 2233, :clk 2511.1772}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1655, :line 2234, :clk 2511.442}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1656, :line 2235, :clk 2511.442, :ends 2512.8558}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1653, :line 2236, :clk 2511.6772}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1654, :line 2237, :clk 2511.6772}
 {:clk 2512.1772, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2504.6914, :j 1651, :line 2238}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1652, :line 2239, :clk 2512.1772}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1656, :line 2240, :clk 2512.8558}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1657, :line 2241, :clk 2512.8558, :ends 2514.3558}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1654, :line 2242, :clk 2513.1772}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1655, :line 2243, :clk 2513.1772}
 {:clk 2513.6772, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2505.6914, :j 1652, :line 2244}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1653, :line 2245, :clk 2513.6772}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1655, :line 2246, :clk 2514.1772}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1656, :line 2247, :clk 2514.1772}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1657, :line 2248, :clk 2514.3558}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1658, :line 2249, :clk 2514.3558, :ends 2520.289}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1656, :line 2250, :clk 2515.1772}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1657, :line 2251, :clk 2515.1772}
 {:clk 2515.1772, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2507.1914, :j 1653, :line 2252}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1654, :line 2253, :clk 2515.1772}
 {:clk 2516.6772, :act :m2-starved, :m :m2, :mjpact :st, :line 2254}
 {:clk 2516.6772, :act :m2-blocked, :m :m2, :mjpact :bl, :line 2255}
 {:clk 2517.6543, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2508.942, :j 1654, :line 2256}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1655, :line 2257, :clk 2517.6543}
 {:clk 2517.6543, :act :m2-unblocked, :m :m2, :mjpact :ub, :line 2258}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1657, :line 2259, :clk 2517.6543}
 {:clk 2518.6543, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2510.442, :j 1655, :line 2260}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1656, :line 2261, :clk 2518.6543}
 {:clk 2519.6543, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2511.442, :j 1656, :line 2262}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1657, :line 2263, :clk 2519.6543}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1658, :line 2264, :clk 2520.289}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1659, :line 2265, :clk 2520.289, :ends 2521.789}
 {:clk 2520.289, :act :m2-unstarved, :m :m2, :mjpact :us, :line 2266}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1658, :line 2267, :clk 2520.289}
 {:clk 2521.2378, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2512.8558, :j 1657, :line 2268}
 {:clk 2521.2378, :act :m3-starved, :m :m3, :mjpact :st, :line 2269}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1659, :line 2270, :clk 2521.789}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1660, :line 2271, :clk 2521.789, :ends 2522.789}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1660, :line 2272, :clk 2522.789}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1661, :line 2273, :clk 2522.789, :ends 2523.789}
 {:clk 2523.789, :act :m1-blocked, :m :m1, :mjpact :bl, :line 2274}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1658, :line 2275, :clk 2524.2202}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1658, :line 2276, :clk 2524.2202}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1659, :line 2277, :clk 2524.2202}
 {:clk 2524.2202, :act :m3-unstarved, :m :m3, :mjpact :us, :line 2278}
 {:clk 2524.2202, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 2279}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1661, :line 2280, :clk 2524.2202}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1662, :line 2281, :clk 2524.2202, :ends 2525.2202}
 {:clk 2525.2202, :act :m3-starved, :m :m3, :mjpact :st, :line 2282}
 {:clk 2525.2202, :act :m1-blocked, :m :m1, :mjpact :bl, :line 2283}
 {:clk 2525.2202, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2514.3558, :j 1658, :line 2284}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1659, :line 2285, :clk 2525.7202}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1659, :line 2286, :clk 2525.7202}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1660, :line 2287, :clk 2525.7202}
 {:clk 2525.7202, :act :m3-unstarved, :m :m3, :mjpact :us, :line 2288}
 {:clk 2525.7202, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 2289}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1662, :line 2290, :clk 2525.7202}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1663, :line 2291, :clk 2525.7202, :ends 2526.7202}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1663, :line 2292, :clk 2526.7202}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1664, :line 2293, :clk 2526.7202, :ends 2528.2202}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1660, :line 2294, :clk 2526.7202}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1661, :line 2295, :clk 2526.7202}
 {:clk 2527.2202, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2520.289, :j 1659, :line 2296}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1660, :line 2297, :clk 2527.2202}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1661, :line 2298, :clk 2527.7202}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1662, :line 2299, :clk 2527.7202}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1664, :line 2300, :clk 2528.2202}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1665, :line 2301, :clk 2528.2202, :ends 2529.7202}
 {:clk 2528.2202, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2521.789, :j 1660, :line 2302}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1661, :line 2303, :clk 2528.2202}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1662, :line 2304, :clk 2528.7202}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1663, :line 2305, :clk 2528.7202}
 {:clk 2529.2202, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2522.789, :j 1661, :line 2306}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1662, :line 2307, :clk 2529.2202}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1665, :line 2308, :clk 2529.7202}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1666, :line 2309, :clk 2529.7202, :ends 2531.6014}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1663, :line 2310, :clk 2529.7202}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1664, :line 2311, :clk 2529.7202}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1666, :line 2312, :clk 2531.6014}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1667, :line 2313, :clk 2531.6014, :ends 2533.0497}
 {:clk 2532.2194, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2524.2202, :j 1662, :line 2314}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1663, :line 2315, :clk 2532.2194}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1664, :line 2316, :clk 2532.5894}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1665, :line 2317, :clk 2532.5894}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1667, :line 2318, :clk 2533.0497}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1668, :line 2319, :clk 2533.0497, :ends 2535.5771}
 {:clk 2533.2194, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2525.7202, :j 1663, :line 2320}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1664, :line 2321, :clk 2533.2194}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1665, :line 2322, :clk 2534.0894}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1666, :line 2323, :clk 2534.0894}
 {:clk 2535.0243, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2526.7202, :j 1664, :line 2324}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1665, :line 2325, :clk 2535.0243}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1668, :line 2326, :clk 2535.5771}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1669, :line 2327, :clk 2535.5771, :ends 2536.5771}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1666, :line 2328, :clk 2535.5894}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1667, :line 2329, :clk 2535.5894}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1669, :line 2330, :clk 2536.5771}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1670, :line 2331, :clk 2536.5771, :ends 2538.2702}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1667, :line 2332, :clk 2536.5894}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1668, :line 2333, :clk 2536.5894}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1670, :line 2334, :clk 2538.2702}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1671, :line 2335, :clk 2538.2702, :ends 2539.2702}
 {:clk 2538.4994, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2528.2202, :j 1665, :line 2336}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1666, :line 2337, :clk 2538.4994}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1668, :line 2338, :clk 2538.644}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1669, :line 2339, :clk 2538.644}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1671, :line 2340, :clk 2539.2702}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1672, :line 2341, :clk 2539.2702, :ends 2540.2702}
 {:clk 2539.644, :act :m2-blocked, :m :m2, :mjpact :bl, :line 2342}
 {:clk 2540.2702, :act :m1-blocked, :m :m1, :mjpact :bl, :line 2343}
 {:clk 2540.3227, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2529.7202, :j 1666, :line 2344}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1667, :line 2345, :clk 2540.3227}
 {:clk 2540.3227, :act :m2-unblocked, :m :m2, :mjpact :ub, :line 2346}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1669, :line 2347, :clk 2540.3227}
 {:clk 2541.3227, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2531.6014, :j 1667, :line 2348}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1668, :line 2349, :clk 2541.3227}
 {:clk 2542.8227, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2533.0497, :j 1668, :line 2350}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1669, :line 2351, :clk 2542.8227}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1670, :line 2352, :clk 2543.2089}
 {:clk 2543.2089, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 2353}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1672, :line 2354, :clk 2543.2089}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1673, :line 2355, :clk 2543.2089, :ends 2544.7089}
 {:clk 2543.8227, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2535.5771, :j 1669, :line 2356}
 {:clk 2543.8227, :act :m3-starved, :m :m3, :mjpact :st, :line 2357}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1670, :line 2358, :clk 2544.2089}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1671, :line 2359, :clk 2544.2089}
 {:clk 2544.2089, :act :m3-unstarved, :m :m3, :mjpact :us, :line 2360}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1670, :line 2361, :clk 2544.2089}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1673, :line 2362, :clk 2544.7089}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1674, :line 2363, :clk 2544.7089, :ends 2545.7089}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1671, :line 2364, :clk 2545.2089}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1672, :line 2365, :clk 2545.2089}
 {:clk 2545.2089, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2536.5771, :j 1670, :line 2366}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1671, :line 2367, :clk 2545.2089}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1674, :line 2368, :clk 2545.7089}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1675, :line 2369, :clk 2545.7089, :ends 2546.7089}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1672, :line 2370, :clk 2546.2089}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1673, :line 2371, :clk 2546.2089}
 {:clk 2546.2089, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2538.2702, :j 1671, :line 2372}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1672, :line 2373, :clk 2546.2089}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1675, :line 2374, :clk 2546.7089}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1676, :line 2375, :clk 2546.7089, :ends 2547.7089}
 {:clk 2547.2089, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2539.2702, :j 1672, :line 2376}
 {:clk 2547.2089, :act :m3-starved, :m :m3, :mjpact :st, :line 2377}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1676, :line 2378, :clk 2547.7089}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1677, :line 2379, :clk 2547.7089, :ends 2549.2089}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1673, :line 2380, :clk 2547.7089}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1674, :line 2381, :clk 2547.7089}
 {:clk 2547.7089, :act :m3-unstarved, :m :m3, :mjpact :us, :line 2382}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1673, :line 2383, :clk 2547.7089}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1674, :line 2384, :clk 2548.7089}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1675, :line 2385, :clk 2548.7089}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1677, :line 2386, :clk 2549.2089}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1678, :line 2387, :clk 2549.2089, :ends 2550.2089}
 {:clk 2549.2089, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2543.2089, :j 1673, :line 2388}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1674, :line 2389, :clk 2549.2089}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1675, :line 2390, :clk 2549.7089}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1676, :line 2391, :clk 2549.7089}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1678, :line 2392, :clk 2550.2089}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1679, :line 2393, :clk 2550.2089, :ends 2551.7089}
 {:clk 2550.2089, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2544.7089, :j 1674, :line 2394}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1675, :line 2395, :clk 2550.2089}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1676, :line 2396, :clk 2550.7089}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1677, :line 2397, :clk 2550.7089}
 {:clk 2551.2089, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2545.7089, :j 1675, :line 2398}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1676, :line 2399, :clk 2551.2089}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1679, :line 2400, :clk 2551.7089}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1680, :line 2401, :clk 2551.7089, :ends 2553.2089}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1677, :line 2402, :clk 2552.2089}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1678, :line 2403, :clk 2552.2089}
 {:clk 2552.2089, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2546.7089, :j 1676, :line 2404}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1677, :line 2405, :clk 2552.2089}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1680, :line 2406, :clk 2553.2089}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1681, :line 2407, :clk 2553.2089, :ends 2554.2089}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1678, :line 2408, :clk 2553.2089}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1679, :line 2409, :clk 2553.2089}
 {:clk 2554.1256, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2547.7089, :j 1677, :line 2410}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1678, :line 2411, :clk 2554.1256}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1681, :line 2412, :clk 2554.2089}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1682, :line 2413, :clk 2554.2089, :ends 2555.2089}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1679, :line 2414, :clk 2554.7089}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1680, :line 2415, :clk 2554.7089}
 {:clk 2555.1256, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2549.2089, :j 1678, :line 2416}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1679, :line 2417, :clk 2555.1256}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1682, :line 2418, :clk 2555.2089}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1683, :line 2419, :clk 2555.2089, :ends 2556.7089}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1680, :line 2420, :clk 2556.2089}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1681, :line 2421, :clk 2556.2089}
 {:clk 2556.6256, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2550.2089, :j 1679, :line 2422}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1680, :line 2423, :clk 2556.6256}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1683, :line 2424, :clk 2556.7089}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1684, :line 2425, :clk 2556.7089, :ends 2557.7089}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1681, :line 2426, :clk 2557.2089}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1682, :line 2427, :clk 2557.2089}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1684, :line 2428, :clk 2557.7089}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1685, :line 2429, :clk 2557.7089, :ends 2559.2089}
 {:clk 2558.1256, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2551.7089, :j 1680, :line 2430}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1681, :line 2431, :clk 2558.1256}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1682, :line 2432, :clk 2558.2089}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1683, :line 2433, :clk 2558.2089}
 {:clk 2559.1256, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2553.2089, :j 1681, :line 2434}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1682, :line 2435, :clk 2559.1256}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1685, :line 2436, :clk 2559.2089}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1686, :line 2437, :clk 2559.2089, :ends 2560.2089}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1683, :line 2438, :clk 2559.7089}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1684, :line 2439, :clk 2559.7089}
 {:clk 2560.1256, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2554.2089, :j 1682, :line 2440}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1683, :line 2441, :clk 2560.1256}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1686, :line 2442, :clk 2560.2089}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1687, :line 2443, :clk 2560.2089, :ends 2561.7089}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1684, :line 2444, :clk 2560.7089}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1685, :line 2445, :clk 2560.7089}
 {:clk 2561.6256, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2555.2089, :j 1683, :line 2446}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1684, :line 2447, :clk 2561.6256}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1687, :line 2448, :clk 2561.7089}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1688, :line 2449, :clk 2561.7089, :ends 2562.7089}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1685, :line 2450, :clk 2562.2089}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1686, :line 2451, :clk 2562.2089}
 {:clk 2562.6256, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2556.7089, :j 1684, :line 2452}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1685, :line 2453, :clk 2562.6256}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1688, :line 2454, :clk 2562.7089}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1689, :line 2455, :clk 2562.7089, :ends 2564.2089}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1686, :line 2456, :clk 2563.2089}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1687, :line 2457, :clk 2563.2089}
 {:clk 2564.1256, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2557.7089, :j 1685, :line 2458}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1686, :line 2459, :clk 2564.1256}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1689, :line 2460, :clk 2564.2089}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1690, :line 2461, :clk 2564.2089, :ends 2565.2089}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1687, :line 2462, :clk 2564.7089}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1688, :line 2463, :clk 2564.7089}
 {:clk 2565.1256, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2559.2089, :j 1686, :line 2464}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1687, :line 2465, :clk 2565.1256}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1690, :line 2466, :clk 2565.2089}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1691, :line 2467, :clk 2565.2089, :ends 2566.7089}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1688, :line 2468, :clk 2565.7089}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1689, :line 2469, :clk 2565.7089}
 {:clk 2566.6256, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2560.2089, :j 1687, :line 2470}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1688, :line 2471, :clk 2566.6256}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1691, :line 2472, :clk 2566.7089}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1692, :line 2473, :clk 2566.7089, :ends 2567.7089}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1689, :line 2474, :clk 2567.2089}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1690, :line 2475, :clk 2567.2089}
 {:clk 2567.6256, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2561.7089, :j 1688, :line 2476}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1689, :line 2477, :clk 2567.6256}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1692, :line 2478, :clk 2567.7089}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1693, :line 2479, :clk 2567.7089, :ends 2568.7089}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1690, :line 2480, :clk 2568.2089}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1691, :line 2481, :clk 2568.2089}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1693, :line 2482, :clk 2568.7089}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1694, :line 2483, :clk 2568.7089, :ends 2570.2089}
 {:clk 2569.1256, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2562.7089, :j 1689, :line 2484}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1690, :line 2485, :clk 2569.1256}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1691, :line 2486, :clk 2569.7089}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1692, :line 2487, :clk 2569.7089}
 {:clk 2570.1256, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2564.2089, :j 1690, :line 2488}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1691, :line 2489, :clk 2570.1256}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1694, :line 2490, :clk 2570.2089}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1695, :line 2491, :clk 2570.2089, :ends 2575.0851}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1692, :line 2492, :clk 2570.7089}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1693, :line 2493, :clk 2570.7089}
 {:clk 2571.6256, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2565.2089, :j 1691, :line 2494}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1692, :line 2495, :clk 2571.6256}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1693, :line 2496, :clk 2571.7089}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1694, :line 2497, :clk 2571.7089}
 {:clk 2572.6256, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2566.7089, :j 1692, :line 2498}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1693, :line 2499, :clk 2572.6256}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1694, :line 2500, :clk 2573.2089}
 {:clk 2573.2089, :act :m2-starved, :m :m2, :mjpact :st, :line 2501}
 {:clk 2573.6256, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2567.7089, :j 1693, :line 2502}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1694, :line 2503, :clk 2573.6256}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1695, :line 2504, :clk 2575.0851}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1696, :line 2505, :clk 2575.0851, :ends 2576.0851}
 {:clk 2575.0851, :act :m2-unstarved, :m :m2, :mjpact :us, :line 2506}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1695, :line 2507, :clk 2575.0851}
 {:clk 2575.1256, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2568.7089, :j 1694, :line 2508}
 {:clk 2575.1256, :act :m3-starved, :m :m3, :mjpact :st, :line 2509}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1696, :line 2510, :clk 2576.0851}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1697, :line 2511, :clk 2576.0851, :ends 2577.5851}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1695, :line 2512, :clk 2576.5851}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1696, :line 2513, :clk 2576.5851}
 {:clk 2576.5851, :act :m3-unstarved, :m :m3, :mjpact :us, :line 2514}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1695, :line 2515, :clk 2576.5851}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1697, :line 2516, :clk 2577.5851}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1698, :line 2517, :clk 2577.5851, :ends 2578.5851}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1696, :line 2518, :clk 2577.5851}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1697, :line 2519, :clk 2577.5851}
 {:clk 2578.0851, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2570.2089, :j 1695, :line 2520}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1696, :line 2521, :clk 2578.0851}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1698, :line 2522, :clk 2578.5851}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1699, :line 2523, :clk 2578.5851, :ends 2579.5851}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1697, :line 2524, :clk 2579.0851}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1698, :line 2525, :clk 2579.0851}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1699, :line 2526, :clk 2579.5851}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1700, :line 2527, :clk 2579.5851, :ends 2583.5786}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1698, :line 2528, :clk 2580.0851}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1699, :line 2529, :clk 2580.0851}
 {:clk 2580.3675, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2575.0851, :j 1696, :line 2530}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1697, :line 2531, :clk 2580.3675}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1699, :line 2532, :clk 2581.0851}
 {:clk 2581.0851, :act :m2-starved, :m :m2, :mjpact :st, :line 2533}
 {:clk 2581.8675, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2576.0851, :j 1697, :line 2534}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1698, :line 2535, :clk 2581.8675}
 {:clk 2582.8675, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2577.5851, :j 1698, :line 2536}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1699, :line 2537, :clk 2582.8675}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1700, :line 2538, :clk 2583.5786}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1701, :line 2539, :clk 2583.5786, :ends 2585.3117}
 {:clk 2583.5786, :act :m2-unstarved, :m :m2, :mjpact :us, :line 2540}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1701, :line 2541, :clk 2585.3117}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1702, :line 2542, :clk 2585.3117, :ends 2586.8117}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1700, :line 2543, :clk 2585.6419}
 {:clk 2586.4848, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2578.5851, :j 1699, :line 2544}
 {:clk 2586.4848, :act :m3-starved, :m :m3, :mjpact :st, :line 2545}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1702, :line 2546, :clk 2586.8117}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1703, :line 2547, :clk 2586.8117, :ends 2588.3117}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1700, :line 2548, :clk 2587.5887}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1701, :line 2549, :clk 2587.5887}
 {:clk 2587.5887, :act :m3-unstarved, :m :m3, :mjpact :us, :line 2550}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1700, :line 2551, :clk 2587.5887}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1703, :line 2552, :clk 2588.3117}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1704, :line 2553, :clk 2588.3117, :ends 2589.3117}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1701, :line 2554, :clk 2588.5887}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1702, :line 2555, :clk 2588.5887}
 {:clk 2589.0887, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2579.5851, :j 1700, :line 2556}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1701, :line 2557, :clk 2589.0887}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1704, :line 2558, :clk 2589.3117}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1705, :line 2559, :clk 2589.3117, :ends 2590.3117}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1702, :line 2560, :clk 2590.0887}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1703, :line 2561, :clk 2590.0887}
 {:clk 2590.0887, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2583.5786, :j 1701, :line 2562}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1702, :line 2563, :clk 2590.0887}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1705, :line 2564, :clk 2590.3117}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1706, :line 2565, :clk 2590.3117, :ends 2591.8117}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1703, :line 2566, :clk 2591.5887}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1704, :line 2567, :clk 2591.5887}
 {:clk 2591.5887, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2585.3117, :j 1702, :line 2568}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1703, :line 2569, :clk 2591.5887}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1706, :line 2570, :clk 2591.8117}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1707, :line 2571, :clk 2591.8117, :ends 2592.8117}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1704, :line 2572, :clk 2592.5887}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1705, :line 2573, :clk 2592.5887}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1707, :line 2574, :clk 2592.8117}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1708, :line 2575, :clk 2592.8117, :ends 2594.5389}
 {:clk 2593.0887, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2586.8117, :j 1703, :line 2576}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1704, :line 2577, :clk 2593.0887}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1705, :line 2578, :clk 2593.5887}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1706, :line 2579, :clk 2593.5887}
 {:clk 2594.0887, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2588.3117, :j 1704, :line 2580}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1705, :line 2581, :clk 2594.0887}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1708, :line 2582, :clk 2594.5389}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1709, :line 2583, :clk 2594.5389, :ends 2595.5389}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1706, :line 2584, :clk 2595.0887}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1707, :line 2585, :clk 2595.0887}
 {:clk 2595.0887, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2589.3117, :j 1705, :line 2586}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1706, :line 2587, :clk 2595.0887}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1709, :line 2588, :clk 2595.5389}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1710, :line 2589, :clk 2595.5389, :ends 2597.0389}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1707, :line 2590, :clk 2596.0887}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1708, :line 2591, :clk 2596.0887}
 {:clk 2596.5887, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2590.3117, :j 1706, :line 2592}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1707, :line 2593, :clk 2596.5887}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1710, :line 2594, :clk 2597.0389}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1711, :line 2595, :clk 2597.0389, :ends 2598.0389}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1708, :line 2596, :clk 2597.5887}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1709, :line 2597, :clk 2597.5887}
 {:clk 2597.5887, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2591.8117, :j 1707, :line 2598}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1708, :line 2599, :clk 2597.5887}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1711, :line 2600, :clk 2598.0389}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1712, :line 2601, :clk 2598.0389, :ends 2599.6555}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1709, :line 2602, :clk 2598.5887}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1710, :line 2603, :clk 2598.5887}
 {:clk 2599.0887, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2592.8117, :j 1708, :line 2604}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1709, :line 2605, :clk 2599.0887}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1712, :line 2606, :clk 2599.6555}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1713, :line 2607, :clk 2599.6555, :ends 2600.6555}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1710, :line 2608, :clk 2600.0887}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1711, :line 2609, :clk 2600.0887}
 {:clk 2600.0887, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2594.5389, :j 1709, :line 2610}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1710, :line 2611, :clk 2600.0887}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1713, :line 2612, :clk 2600.6555}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1714, :line 2613, :clk 2600.6555, :ends 2601.6555}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1711, :line 2614, :clk 2601.0887}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1712, :line 2615, :clk 2601.0887}
 {:clk 2601.5887, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2595.5389, :j 1710, :line 2616}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1711, :line 2617, :clk 2601.5887}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1714, :line 2618, :clk 2601.6555}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1715, :line 2619, :clk 2601.6555, :ends 2602.6555}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1712, :line 2620, :clk 2602.0887}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1713, :line 2621, :clk 2602.0887}
 {:clk 2602.5887, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2597.0389, :j 1711, :line 2622}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1712, :line 2623, :clk 2602.5887}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1715, :line 2624, :clk 2602.6555}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1716, :line 2625, :clk 2602.6555, :ends 2604.1555}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1713, :line 2626, :clk 2603.0887}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1714, :line 2627, :clk 2603.0887}
 {:clk 2603.5887, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2598.0389, :j 1712, :line 2628}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1713, :line 2629, :clk 2603.5887}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1714, :line 2630, :clk 2604.0887}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1715, :line 2631, :clk 2604.0887}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1716, :line 2632, :clk 2604.1555}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1717, :line 2633, :clk 2604.1555, :ends 2605.1555}
 {:clk 2604.5887, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2599.6555, :j 1713, :line 2634}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1714, :line 2635, :clk 2604.5887}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1715, :line 2636, :clk 2605.0887}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1716, :line 2637, :clk 2605.0887}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1717, :line 2638, :clk 2605.1555}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1718, :line 2639, :clk 2605.1555, :ends 2606.1555}
 {:clk 2605.5887, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2600.6555, :j 1714, :line 2640}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1715, :line 2641, :clk 2605.5887}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1718, :line 2642, :clk 2606.1555}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1719, :line 2643, :clk 2606.1555, :ends 2607.6555}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1716, :line 2644, :clk 2606.5887}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1717, :line 2645, :clk 2606.5887}
 {:clk 2606.7274, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2601.6555, :j 1715, :line 2646}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1716, :line 2647, :clk 2606.7274}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1719, :line 2648, :clk 2607.6555}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1720, :line 2649, :clk 2607.6555, :ends 2609.1555}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1717, :line 2650, :clk 2608.1711}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1718, :line 2651, :clk 2608.1711}
 {:clk 2608.2274, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2602.6555, :j 1716, :line 2652}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1717, :line 2653, :clk 2608.2274}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1720, :line 2654, :clk 2609.1555}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1721, :line 2655, :clk 2609.1555, :ends 2610.6555}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1718, :line 2656, :clk 2609.1711}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1719, :line 2657, :clk 2609.1711}
 {:clk 2610.4832, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2604.1555, :j 1717, :line 2658}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1718, :line 2659, :clk 2610.4832}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1721, :line 2660, :clk 2610.6555}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1722, :line 2661, :clk 2610.6555, :ends 2611.6555}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1719, :line 2662, :clk 2610.6711}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1720, :line 2663, :clk 2610.6711}
 {:clk 2611.4832, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2605.1555, :j 1718, :line 2664}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1719, :line 2665, :clk 2611.4832}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1722, :line 2666, :clk 2611.6555}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1723, :line 2667, :clk 2611.6555, :ends 2613.1555}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1720, :line 2668, :clk 2612.1711}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1721, :line 2669, :clk 2612.1711}
 {:clk 2612.9832, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2606.1555, :j 1719, :line 2670}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1720, :line 2671, :clk 2612.9832}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1723, :line 2672, :clk 2613.1555}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1724, :line 2673, :clk 2613.1555, :ends 2614.6555}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1721, :line 2674, :clk 2613.6711}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1722, :line 2675, :clk 2613.6711}
 {:clk 2614.4832, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2607.6555, :j 1720, :line 2676}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1721, :line 2677, :clk 2614.4832}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1724, :line 2678, :clk 2614.6555}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1725, :line 2679, :clk 2614.6555, :ends 2616.1555}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1722, :line 2680, :clk 2614.6711}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1723, :line 2681, :clk 2614.6711}
 {:clk 2615.9832, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2609.1555, :j 1721, :line 2682}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1722, :line 2683, :clk 2615.9832}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1725, :line 2684, :clk 2616.1555}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1726, :line 2685, :clk 2616.1555, :ends 2617.6555}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1723, :line 2686, :clk 2616.1711}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1724, :line 2687, :clk 2616.1711}
 {:clk 2616.9832, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2610.6555, :j 1722, :line 2688}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1723, :line 2689, :clk 2616.9832}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1726, :line 2690, :clk 2617.6555}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1727, :line 2691, :clk 2617.6555, :ends 2618.6555}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1724, :line 2692, :clk 2617.6711}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1725, :line 2693, :clk 2617.6711}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1727, :line 2694, :clk 2618.6555}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1728, :line 2695, :clk 2618.6555, :ends 2620.1555}
 {:clk 2618.8092, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2611.6555, :j 1723, :line 2696}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1724, :line 2697, :clk 2618.8092}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1725, :line 2698, :clk 2619.1711}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1726, :line 2699, :clk 2619.1711}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1728, :line 2700, :clk 2620.1555}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1729, :line 2701, :clk 2620.1555, :ends 2621.6555}
 {:clk 2620.3092, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2613.1555, :j 1724, :line 2702}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1725, :line 2703, :clk 2620.3092}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1726, :line 2704, :clk 2620.6711}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1727, :line 2705, :clk 2620.6711}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1729, :line 2706, :clk 2621.6555}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1730, :line 2707, :clk 2621.6555, :ends 2623.1555}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1727, :line 2708, :clk 2621.6711}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1728, :line 2709, :clk 2621.6711}
 {:clk 2621.8092, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2614.6555, :j 1725, :line 2710}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1726, :line 2711, :clk 2621.8092}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1730, :line 2712, :clk 2623.1555}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1731, :line 2713, :clk 2623.1555, :ends 2626.2741}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1728, :line 2714, :clk 2623.1711}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1729, :line 2715, :clk 2623.1711}
 {:clk 2624.4402, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2616.1555, :j 1726, :line 2716}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1727, :line 2717, :clk 2624.4402}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1729, :line 2718, :clk 2624.6711}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1730, :line 2719, :clk 2624.6711}
 {:clk 2625.4402, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2617.6555, :j 1727, :line 2720}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1728, :line 2721, :clk 2625.4402}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1730, :line 2722, :clk 2626.1711}
 {:clk 2626.1711, :act :m2-starved, :m :m2, :mjpact :st, :line 2723}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1731, :line 2724, :clk 2626.2741}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1732, :line 2725, :clk 2626.2741, :ends 2627.7741}
 {:clk 2626.2741, :act :m2-unstarved, :m :m2, :mjpact :us, :line 2726}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1731, :line 2727, :clk 2626.2741}
 {:clk 2627.6862, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2618.6555, :j 1728, :line 2728}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1729, :line 2729, :clk 2627.6862}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1732, :line 2730, :clk 2627.7741}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1733, :line 2731, :clk 2627.7741, :ends 2629.2741}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1731, :line 2732, :clk 2627.7741}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1732, :line 2733, :clk 2627.7741}
 {:clk 2629.1862, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2620.1555, :j 1729, :line 2734}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1730, :line 2735, :clk 2629.1862}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1733, :line 2736, :clk 2629.2741}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1734, :line 2737, :clk 2629.2741, :ends 2630.7741}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1732, :line 2738, :clk 2629.2741}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1733, :line 2739, :clk 2629.2741}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1735, :line 2740, :clk 2630.7741, :ends 2632.2741}
 {:clk 2630.7741, :act :m2-blocked, :m :m2, :mjpact :bl, :line 2741}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1734, :line 2742, :clk 2630.7741}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1735, :line 2743, :clk 2632.2741}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1736, :line 2744, :clk 2632.2741, :ends 2633.2741}
 {:clk 2632.8988, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2621.6555, :j 1730, :line 2745}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1731, :line 2746, :clk 2632.8988}
 {:clk 2632.8988, :act :m2-unblocked, :m :m2, :mjpact :ub, :line 2747}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1733, :line 2748, :clk 2632.8988}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1734, :line 2749, :clk 2632.8988}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1736, :line 2750, :clk 2633.2741}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1737, :line 2751, :clk 2633.2741, :ends 2634.9631}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1734, :line 2752, :clk 2634.3988}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1735, :line 2753, :clk 2634.3988}
 {:clk 2634.3988, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2623.1555, :j 1731, :line 2754}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1732, :line 2755, :clk 2634.3988}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1737, :line 2756, :clk 2634.9631}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1738, :line 2757, :clk 2634.9631, :ends 2635.9631}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1735, :line 2758, :clk 2635.8988}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1736, :line 2759, :clk 2635.8988}
 {:clk 2635.8988, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2626.2741, :j 1732, :line 2760}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1733, :line 2761, :clk 2635.8988}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1738, :line 2762, :clk 2635.9631}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1739, :line 2763, :clk 2635.9631, :ends 2636.9631}
 {:clk 2636.9631, :act :m1-blocked, :m :m1, :mjpact :bl, :line 2764}
 {:clk 2637.3988, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2627.7741, :j 1733, :line 2765}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1734, :line 2766, :clk 2637.3988}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1736, :line 2767, :clk 2638.2259}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1737, :line 2768, :clk 2638.2259}
 {:clk 2638.2259, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 2769}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1739, :line 2770, :clk 2638.2259}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1740, :line 2771, :clk 2638.2259, :ends 2639.7259}
 {:clk 2638.8988, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2629.2741, :j 1734, :line 2772}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1735, :line 2773, :clk 2638.8988}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1740, :line 2774, :clk 2639.7259}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1741, :line 2775, :clk 2639.7259, :ends 2640.7259}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1737, :line 2776, :clk 2639.7259}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1738, :line 2777, :clk 2639.7259}
 {:clk 2640.7259, :act :m1-blocked, :m :m1, :mjpact :bl, :line 2778}
 {:clk 2642.0838, :act :m2-blocked, :m :m2, :mjpact :bl, :line 2779}
 {:clk 2644.7223, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2630.7741, :j 1735, :line 2780}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1736, :line 2781, :clk 2644.7223}
 {:clk 2644.7223, :act :m2-unblocked, :m :m2, :mjpact :ub, :line 2782}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1738, :line 2783, :clk 2644.7223}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1739, :line 2784, :clk 2644.7223}
 {:clk 2644.7223, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 2785}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1741, :line 2786, :clk 2644.7223}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1742, :line 2787, :clk 2644.7223, :ends 2645.7223}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1742, :line 2788, :clk 2645.7223}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1743, :line 2789, :clk 2645.7223, :ends 2646.7223}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1739, :line 2790, :clk 2645.7223}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1740, :line 2791, :clk 2645.7223}
 {:clk 2645.7223, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2632.2741, :j 1736, :line 2792}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1737, :line 2793, :clk 2645.7223}
 {:clk 2646.7223, :act :m1-blocked, :m :m1, :mjpact :bl, :line 2794}
 {:clk 2647.2223, :act :m2-blocked, :m :m2, :mjpact :bl, :line 2795}
 {:clk 2648.2103, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2633.2741, :j 1737, :line 2796}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1738, :line 2797, :clk 2648.2103}
 {:clk 2648.2103, :act :m2-unblocked, :m :m2, :mjpact :ub, :line 2798}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1740, :line 2799, :clk 2648.2103}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1741, :line 2800, :clk 2648.2103}
 {:clk 2648.2103, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 2801}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1743, :line 2802, :clk 2648.2103}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1744, :line 2803, :clk 2648.2103, :ends 2649.2103}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1744, :line 2804, :clk 2649.2103}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1745, :line 2805, :clk 2649.2103, :ends 2650.7103}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1741, :line 2806, :clk 2649.2103}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1742, :line 2807, :clk 2649.2103}
 {:clk 2649.2103, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2634.9631, :j 1738, :line 2808}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1739, :line 2809, :clk 2649.2103}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1742, :line 2810, :clk 2650.2103}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1743, :line 2811, :clk 2650.2103}
 {:clk 2650.2103, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2635.9631, :j 1739, :line 2812}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1740, :line 2813, :clk 2650.2103}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1745, :line 2814, :clk 2650.7103}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1746, :line 2815, :clk 2650.7103, :ends 2652.3352}
 {:clk 2651.2103, :act :m2-blocked, :m :m2, :mjpact :bl, :line 2816}
 {:clk 2651.7103, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2638.2259, :j 1740, :line 2817}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1741, :line 2818, :clk 2651.7103}
 {:clk 2651.7103, :act :m2-unblocked, :m :m2, :mjpact :ub, :line 2819}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1743, :line 2820, :clk 2651.7103}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1744, :line 2821, :clk 2651.7103}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1746, :line 2822, :clk 2652.3352}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1747, :line 2823, :clk 2652.3352, :ends 2653.3352}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1744, :line 2824, :clk 2652.7103}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1745, :line 2825, :clk 2652.7103}
 {:clk 2652.7103, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2639.7259, :j 1741, :line 2826}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1742, :line 2827, :clk 2652.7103}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1747, :line 2828, :clk 2653.3352}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1748, :line 2829, :clk 2653.3352, :ends 2655.9438}
 {:clk 2653.7103, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2644.7223, :j 1742, :line 2830}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1743, :line 2831, :clk 2653.7103}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1745, :line 2832, :clk 2654.2103}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1746, :line 2833, :clk 2654.2103}
 {:clk 2654.7103, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2645.7223, :j 1743, :line 2834}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1744, :line 2835, :clk 2654.7103}
 {:n 1, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1746, :line 2836, :clk 2655.7103}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1747, :line 2837, :clk 2655.7103}
 {:clk 2655.7103, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2648.2103, :j 1744, :line 2838}
 {:n 2, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1745, :line 2839, :clk 2655.7103}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1748, :line 2840, :clk 2655.9438}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1749, :line 2841, :clk 2655.9438, :ends 2657.4438}
 {:clk 2657.2103, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2649.2103, :j 1745, :line 2842}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1746, :line 2843, :clk 2657.2103}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1749, :line 2844, :clk 2657.4438}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1750, :line 2845, :clk 2657.4438, :ends 2660.7024}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1747, :line 2846, :clk 2658.4737}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1748, :line 2847, :clk 2658.4737}
 {:clk 2658.7103, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2650.7103, :j 1746, :line 2848}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1747, :line 2849, :clk 2658.7103}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1748, :line 2850, :clk 2659.4737}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1749, :line 2851, :clk 2659.4737}
 {:clk 2659.7103, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2652.3352, :j 1747, :line 2852}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1748, :line 2853, :clk 2659.7103}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1750, :line 2854, :clk 2660.7024}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1751, :line 2855, :clk 2660.7024, :ends 2661.7024}
 {:clk 2660.7103, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2653.3352, :j 1748, :line 2856}
 {:clk 2660.7103, :act :m3-starved, :m :m3, :mjpact :st, :line 2857}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1749, :line 2858, :clk 2660.9737}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1750, :line 2859, :clk 2660.9737}
 {:clk 2660.9737, :act :m3-unstarved, :m :m3, :mjpact :us, :line 2860}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1749, :line 2861, :clk 2660.9737}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1751, :line 2862, :clk 2661.7024}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1752, :line 2863, :clk 2661.7024, :ends 2664.0235}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1750, :line 2864, :clk 2662.4737}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1751, :line 2865, :clk 2662.4737}
 {:clk 2662.4737, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2655.9438, :j 1749, :line 2866}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1750, :line 2867, :clk 2662.4737}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1751, :line 2868, :clk 2663.4737}
 {:clk 2663.4737, :act :m2-starved, :m :m2, :mjpact :st, :line 2869}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1752, :line 2870, :clk 2664.0235}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1753, :line 2871, :clk 2664.0235, :ends 2665.0235}
 {:clk 2664.0235, :act :m2-unstarved, :m :m2, :mjpact :us, :line 2872}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1752, :line 2873, :clk 2664.0235}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1753, :line 2874, :clk 2665.0235}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1754, :line 2875, :clk 2665.0235, :ends 2666.5235}
 {:clk 2665.1422, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2657.4438, :j 1750, :line 2876}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1751, :line 2877, :clk 2665.1422}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1752, :line 2878, :clk 2665.5235}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1753, :line 2879, :clk 2665.5235}
 {:clk 2666.1422, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2660.7024, :j 1751, :line 2880}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1752, :line 2881, :clk 2666.1422}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1754, :line 2882, :clk 2666.5235}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1755, :line 2883, :clk 2666.5235, :ends 2667.5235}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1753, :line 2884, :clk 2666.9583}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1754, :line 2885, :clk 2666.9583}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1755, :line 2886, :clk 2667.5235}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1756, :line 2887, :clk 2667.5235, :ends 2668.5235}
 {:clk 2667.6422, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2661.7024, :j 1752, :line 2888}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1753, :line 2889, :clk 2667.6422}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1754, :line 2890, :clk 2668.4583}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1755, :line 2891, :clk 2668.4583}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1756, :line 2892, :clk 2668.5235}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1757, :line 2893, :clk 2668.5235, :ends 2670.0235}
 {:clk 2668.6422, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2664.0235, :j 1753, :line 2894}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1754, :line 2895, :clk 2668.6422}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1755, :line 2896, :clk 2669.4583}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1756, :line 2897, :clk 2669.4583}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1757, :line 2898, :clk 2670.0235}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1758, :line 2899, :clk 2670.0235, :ends 2671.0235}
 {:clk 2670.1422, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2665.0235, :j 1754, :line 2900}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1755, :line 2901, :clk 2670.1422}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1756, :line 2902, :clk 2670.4583}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1757, :line 2903, :clk 2670.4583}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1758, :line 2904, :clk 2671.0235}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1759, :line 2905, :clk 2671.0235, :ends 2672.5235}
 {:clk 2671.1422, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2666.5235, :j 1755, :line 2906}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1756, :line 2907, :clk 2671.1422}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1757, :line 2908, :clk 2671.9583}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1758, :line 2909, :clk 2671.9583}
 {:clk 2672.1422, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2667.5235, :j 1756, :line 2910}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1757, :line 2911, :clk 2672.1422}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1759, :line 2912, :clk 2672.5235}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1760, :line 2913, :clk 2672.5235, :ends 2674.0235}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1758, :line 2914, :clk 2672.9583}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1759, :line 2915, :clk 2672.9583}
 {:clk 2673.6422, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2668.5235, :j 1757, :line 2916}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1758, :line 2917, :clk 2673.6422}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1760, :line 2918, :clk 2674.0235}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1761, :line 2919, :clk 2674.0235, :ends 2675.5235}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1759, :line 2920, :clk 2674.4583}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1760, :line 2921, :clk 2674.4583}
 {:clk 2674.6422, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2670.0235, :j 1758, :line 2922}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1759, :line 2923, :clk 2674.6422}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1761, :line 2924, :clk 2675.5235}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1762, :line 2925, :clk 2675.5235, :ends 2677.0235}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1760, :line 2926, :clk 2675.9583}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1761, :line 2927, :clk 2675.9583}
 {:clk 2676.1422, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2671.0235, :j 1759, :line 2928}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1760, :line 2929, :clk 2676.1422}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1762, :line 2930, :clk 2677.0235}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1763, :line 2931, :clk 2677.0235, :ends 2678.5235}
 {:clk 2677.6422, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2672.5235, :j 1760, :line 2932}
 {:clk 2677.6422, :act :m3-starved, :m :m3, :mjpact :st, :line 2933}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1761, :line 2934, :clk 2677.7419}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1762, :line 2935, :clk 2677.7419}
 {:clk 2677.7419, :act :m3-unstarved, :m :m3, :mjpact :us, :line 2936}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1761, :line 2937, :clk 2677.7419}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1763, :line 2938, :clk 2678.5235}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1764, :line 2939, :clk 2678.5235, :ends 2680.0235}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1762, :line 2940, :clk 2679.2419}
 {:n 1, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1763, :line 2941, :clk 2679.2419}
 {:clk 2679.2419, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2674.0235, :j 1761, :line 2942}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1762, :line 2943, :clk 2679.2419}
 {:n 0, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1764, :line 2944, :clk 2680.0235}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1765, :line 2945, :clk 2680.0235, :ends 2681.5235}
 {:clk 2680.7419, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2675.5235, :j 1762, :line 2946}
 {:clk 2680.7419, :act :m3-starved, :m :m3, :mjpact :st, :line 2947}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1765, :line 2948, :clk 2681.5235}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1766, :line 2949, :clk 2681.5235, :ends 2683.0235}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1763, :line 2950, :clk 2681.7568}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1764, :line 2951, :clk 2681.7568}
 {:clk 2681.7568, :act :m3-unstarved, :m :m3, :mjpact :us, :line 2952}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1763, :line 2953, :clk 2681.7568}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1766, :line 2954, :clk 2683.0235}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1767, :line 2955, :clk 2683.0235, :ends 2684.0235}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1764, :line 2956, :clk 2683.2568}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1765, :line 2957, :clk 2683.2568}
 {:clk 2683.2568, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2677.0235, :j 1763, :line 2958}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1764, :line 2959, :clk 2683.2568}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1767, :line 2960, :clk 2684.0235}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1768, :line 2961, :clk 2684.0235, :ends 2686.171}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1765, :line 2962, :clk 2684.7568}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1766, :line 2963, :clk 2684.7568}
 {:clk 2684.7568, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2678.5235, :j 1764, :line 2964}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1765, :line 2965, :clk 2684.7568}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1768, :line 2966, :clk 2686.171}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1769, :line 2967, :clk 2686.171, :ends 2687.171}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1766, :line 2968, :clk 2686.2568}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1767, :line 2969, :clk 2686.2568}
 {:clk 2686.2568, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2680.0235, :j 1765, :line 2970}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1766, :line 2971, :clk 2686.2568}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1769, :line 2972, :clk 2687.171}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1770, :line 2973, :clk 2687.171, :ends 2688.171}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1767, :line 2974, :clk 2687.2568}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1768, :line 2975, :clk 2687.2568}
 {:clk 2687.7568, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2681.5235, :j 1766, :line 2976}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1767, :line 2977, :clk 2687.7568}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1770, :line 2978, :clk 2688.171}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1771, :line 2979, :clk 2688.171, :ends 2689.171}
 {:clk 2688.7568, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2683.0235, :j 1767, :line 2980}
 {:clk 2688.7568, :act :m3-starved, :m :m3, :mjpact :st, :line 2981}
 {:clk 2689.171, :act :m1-blocked, :m :m1, :mjpact :bl, :line 2982}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1768, :line 2983, :clk 2689.5568}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1768, :line 2984, :clk 2689.5568}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1769, :line 2985, :clk 2689.5568}
 {:clk 2689.5568, :act :m3-unstarved, :m :m3, :mjpact :us, :line 2986}
 {:clk 2689.5568, :act :m1-unblocked, :m :m1, :mjpact :ub, :line 2987}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1771, :line 2988, :clk 2689.5568}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType2, :j 1772, :line 2989, :clk 2689.5568, :ends 2691.0568}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1769, :line 2990, :clk 2690.5568}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1770, :line 2991, :clk 2690.5568}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1772, :line 2992, :clk 2691.0568}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1773, :line 2993, :clk 2691.0568, :ends 2692.0568}
 {:clk 2691.0568, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2684.0235, :j 1768, :line 2994}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1769, :line 2995, :clk 2691.0568}
 {:n 0, :m :m2, :act :m2-complete-job, :mjpact :bj, :bf :b2, :j 1770, :line 2996, :clk 2691.5568}
 {:n 2, :m :m2, :act :m2-start-job, :mjpact :sm, :bf :b1, :j 1771, :line 2997, :clk 2691.5568}
 {:n 1, :m :m1, :act :m1-complete-job, :mjpact :bj, :bf :b1, :j 1773, :line 2998, :clk 2692.0568}
 {:m :m1, :act :m1-start-job, :mjpact :aj, :jt :jobType1, :j 1774, :line 2999, :clk 2692.0568, :ends 2693.0568}
 {:clk 2692.0568, :act :m3-complete-job, :m :m3, :mjpact :ej, :ent 2686.171, :j 1769, :line 3000}
 {:n 1, :m :m3, :act :m3-start-job, :mjpact :sm, :bf :b2, :j 1770, :line 3001, :clk 2692.0568}
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
