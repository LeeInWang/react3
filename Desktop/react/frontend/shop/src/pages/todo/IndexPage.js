// /todo/ 이하 메뉴에서 필요한 하위 메뉴를 보여주고 하위 페이지들의 화면을 
// 보여주는 <Outlet> 설정을 추가
//<Outlet> : 중첩적으로 라우티이 적용될 때 기존 컴포넌트의 구조를 유지할 수 있게 함

// import { Outlet } from "react-router-dom";
// import BasicLayout from "../../layouts/BasicLayout";

// const IndexPage = () => {
//     return (
//         <BasicLayout>
//             <div className="w-full flex m-2 p-2">
//                 <div className="text-xl m-1 p-2 w-20 font-extrabold text-center underline">
//                     List
//                 </div>
//                 <div className="text-xl m-1 p-2 w-20 font-extrabold text-center underline">
//                     ADD
//                 </div>
//             </div>
//             <div className="flex flex-wrap w-full">
//                 <Outlet />
//             </div>

//         </BasicLayout>
//     );
// }
// export default IndexPage;

//#2. useNavigate() : 동적으로 데이터를 처리해서 이동하는 경우 사용
//                    주소 표시줄의 url을 변경하지 않으며, 페이지 이동만 수행   
//useCallback(함수 재사용)

import { Outlet, useNavigate } from "react-router-dom";
import BasicLayout from "../../layouts/BasicLayout";
import { useCallback } from "react";

const IndexPage = () => {

    const navigate = useNavigate()
    
    const handleClickList = useCallback(() => {
        navigate({ pathname: "list" })
    })
    const handleClickAdd = useCallback(() => {
        navigate({ pathname: "add" })
    })

    return (
        <BasicLayout>
            <div className="w-full flex m-2 p-2">
                <div className="text-xl m-1 p-2 w-20 font-extrabold text-center underline" onClick={handleClickList}>
                    List
                </div>
                <div className="text-xl m-1 p-2 w-20 font-extrabold text-center underline" onClick={handleClickAdd}>
                    ADD
                </div>
            </div>
            <div className="flex flex-wrap w-full">
                <Outlet />
            </div>

        </BasicLayout>
    );
}
export default IndexPage;
