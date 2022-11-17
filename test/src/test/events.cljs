(ns test.events
  (:require
   [re-frame.core :as re-frame]
   [test.db :as db]
   ))

(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))
