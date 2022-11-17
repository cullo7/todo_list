(ns test.views
  (:require
   [re-frame.core :as re-frame]
   [test.subs :as subs]
   ))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1
      "Todo list for " @name]
     ]

  [:input
    {:type "text"}]))