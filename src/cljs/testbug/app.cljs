(ns testbug.handler.app
  (:require
   [om.core :as om :include-macros true]
   [om.dom :as dom :include-macros true]))


(def app-state (atom {}))

(defn redcube
  [app owner]
  (reify
    om/IRender
    (render
     [this]
      (dom/div (clj->js {:ref "box"
                         :onMouseMove #(.log js/console (.-nativeEvent %))
                         }) nil))))

(om/root redcube app-state {:target (.getElementById js/document "subject")})
(.log js/console "test123")



