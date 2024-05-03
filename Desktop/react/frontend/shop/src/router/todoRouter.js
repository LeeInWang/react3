// 중접 라우팅의 분리와 redirection
// '/todo/' 와 관련된 children 설정
// 기존의 root.js 파일의 설정 일부를 별도의 파일로 분리하고 설정을 반환하도록 


//<Navigate> 의 replace 속성을 이용해서 특정 경로로 진입시 자동으로 리다이렉션을 처리
//              렌더링 시점에 다른 페이지로 이동시키고 싶을 때 사용
//    Link : 하이퍼 링크
//    useNavigate Hook : 동적으로 데이터를 처리해서 이동하는 경우 사용
//               특정한 코드의 실행이 끝나고 나서 페이지를 이동시키고 싶을 때



import { Suspense, lazy } from "react";
import { Navigate } from "react-router-dom";

const Loading = <div className="text-3xl text-center text-sky-500">Loading....</div>
const TodoList = lazy(() => import("../pages/todo/ListPage"))
const TodoRead = lazy(() => import("../pages/todo/ReadPage"))
const TodoAdd = lazy(() => import("../pages/todo/AddPage"))
const TodoModify = lazy(() => import("../pages/todo/ModifyPage"))

const todoRouter = () => {

    return [
        {
            path: "list",
            element: <Suspense fallback={Loading}><TodoList /></Suspense>
        },
        {
            // '/todo/' 이하의 경로가 지정되지 않았을 때 동작하는 빈 경로 설정
            path: "",  
            element: <Navigate replace to="list" />
        },
        {
            // React-Router는 경로에 필요한 데이터가 있을 때는 ':'을 활용
            // ':' 경로의 일부를 변수로 사용하기 위한 설정으로 브라우저에서
            // 특정한 번호를 조회하는 용도로 사용
            path: "read/:tno",
            element: <Suspense fallback={Loading}><TodoRead /></Suspense>
        },
        {
            path: "add",
            element: <Suspense fallback={Loading}><TodoAdd /></Suspense>
        },
        {
            path: "modify/:tno",
            element: <Suspense fallback={Loading}><TodoModify /></Suspense>
        }
    ]
}
export default todoRouter; 
