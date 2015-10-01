(ns testbug.handler.app
  (:require
   [om.core :as om :include-macros true]
   [om.dom :as dom :include-macros true]))

(defn redcube
  [_ _]
  (reify
    om/IRender
    (render
     [_]
      (dom/div (clj->js {:ref "box"
                         :onMouseMove #(.log js/console (.-nativeEvent %))
                         }) nil))))

(om/root redcube nil {:target (.getElementById js/document "subject")})



