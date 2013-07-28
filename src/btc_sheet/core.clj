(ns btc-sheet.core
  (:require [clj-http.client :as client]))

(defn mtgox-price
  []
  (->> (client/get "http://api.bitcoincharts.com/v1/markets.json" {:as :json})
      :body
      (filter #(= "mtgoxUSD" (:symbol %)))
      first
      :close))

(comment
  (mtgox-price)                         ;94.5
)
