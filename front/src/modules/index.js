import { combineReducers } from "redux";
import productRegistReducer from './ProductRegistModule';
import productFindReducer from "./ProductFindModule";
import loginReducer from "./LoginModule";

const rootReducer = combineReducers({
    productRegistReducer,
    productFindReducer,
    loginReducer
});

export default rootReducer;