import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Layout from './layouts/Layout';
import Main from './pages/Main';
import DeliveryManage from './pages/DeliveryManage';
import ProductManage from './pages/ProductManage';
import ProductRegist from './pages/ProductRegist';
import ProductInfo from './pages/ProductInfo';
import Signup from './pages/Signup';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={ <Layout/> }>
          <Route index element={<Main/>}/>
          <Route path="purchases" element={<Main/>}/>
          <Route path="deliveries/history" element={<Main/>}/>
          <Route path="deliveries/manage" element={<DeliveryManage/>}/>
          <Route path="products">
            <Route path=":productNo" element={<ProductInfo/>}/>
          </Route>
          <Route path="products/manage">  
            <Route index element={<ProductManage/>}/>
            <Route path=":productNo" element={<ProductInfo/>}/>
            <Route path="regist" element={<ProductRegist/>}/>
          </Route>
        </Route>
        <Route path="signup" element={<Signup/>}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
