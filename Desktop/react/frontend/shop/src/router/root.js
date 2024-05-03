import  {createBrowserRouter} from "react-router-dom";
import { Suspense, lazy } from "react";
import todoRouter from "./todoRouter";

//Suspense, lazy : 필요한 순간까지 컴포넌트를 메모리상으로 올리지 않도록(렌더링) 지연로딩을 위해 사용

const Loading = <div>Loading....</div>
const Main = lazy(() => import("../pages/MainPage"))
const About = lazy(() => import("../pages/AboutPage"))
const TodoIndex = lazy(() => import("../pages/todo/IndexPage"))
const TodoList = lazy(() => import("../pages/todo/ListPage"))

const root = createBrowserRouter([
       {
        path:"",
        element:<Suspense fallback={Loading}><Main /></Suspense>
       },
       {
        path:"about",
        element:<Suspense fallback={Loading}><About /></Suspense>   
       },
       {
        path: "todo",
        element: <Suspense fallback={Loading}><TodoIndex /></Suspense>,
        // children:[
        //     {
        //         path: "list",
        //         element: <Suspense fallback={Loading}><TodoList /></Suspense>
        //     }
        // ]
        children:todoRouter()
       }

])

export default root;