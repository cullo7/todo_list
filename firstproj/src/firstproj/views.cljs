 (ns firstproj.views
  (:require
   [re-frame.core :as re-frame]
   [firstproj.subs :as subs]
   [firstproj.events :as events] 
   ))

(defn display-user [{:keys [id avatar email] first-name :first_name}]
      [:div.horizontal.myclass {:key id}
	[:img.pr-15 {:src avatar}]
	[:div
	[:h2 first-name]
	[:p (str "(" email ")")]
	]
])

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])
       loading  (re-frame/subscribe [::subs/loading])
       users (re-frame/subscribe [::subs/users])]
    [:div
     [:h1
      "Hello from " @name]
      (when @loading "Loading..")
      (map display-user @users)
      [:button {:on-click #(re-frame/dispatch [::events/fetch-users])} "Make API Call"]
      [:button {:on-click #(re-frame/dispatch [::events/update-name "sadface"])}  "update name 2"]
     ]))
