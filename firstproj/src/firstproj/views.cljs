(ns firstproj.views
  (:require
   [re-frame.core :as re-frame]
   [firstproj.subs :as subs]
   [firstproj.events :as events] 
   ))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])
       loading  (re-frame/subscribe [::subs/loading])]
    [:div
     [:h1
      "Hello from " @name]
      (when @loading "Loading..")
      [:button {:on-click #(re-frame/dispatch [::events/fetch-users])} "Make API Call"]
      [:button {:on-click #(re-frame/dispatch [::events/update-name "sadface"])}  "update name 2"]
     ]))
