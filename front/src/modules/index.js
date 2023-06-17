import { combineReducers } from "redux";
import productRegistReducer from './ProductRegistModule';
import productFindReducer from "./ProductFindModule";

const rootReducer = combineReducers({
    productRegistReducer,
    productFindReducer
});

export default rootReducer;