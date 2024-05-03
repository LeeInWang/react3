//조회할 때 사용할 파일
// const ReadPage = () => {
//     return (
//         <div className="text-3xl font-extrabold text-center text-neutral-50 bg-lime-900">
//             Todo 조회 페이지(Read Page Component)
//         </div>
//     );
// }
// export default ReadPage;

//#2. useParams()
//    특정 번호의 경로를 사용하는 경우 컴포넌트에서는 주소창에 있는 경로의 일부를 활용해야 함
//    useParams()를 이용해서 저정된 변수를 추출할 수 있음

// import { useParams } from "react-router-dom";

// const ReadPage = () => {
//     const { tno } = useParams()
//     return (
//         <div className="text-3xl font-extrabold text-center text-neutral-50 bg-lime-900">
//             Todo 조회 페이지(Read Page Component) {tno}
//         </div>
//     );
// }
// export default ReadPage;


//#3  조회 -> 수정/삭제 이동
//import { useCallback } from "react";
// import { useNavigate, useParams } from "react-router-dom";


// const ReadPage = (props) => {
//     // function ReadPage(props) {
//     const { tno } = useParams()

//     const navigate = useNavigate()

//     const moveToModify = useCallback((tno) => {
//         navigate({ pathname: `/todo/modify/${tno}` })
//     }, [tno])

//     return (
//         <div className="text-3xl font-extrabold text-center text-neutral-50 bg-lime-900">
//             Todo 조회 페이지(Read Page Component) {tno}

//             <div>
//                 <button onClick={() => moveToModify(123)} >Test 수정/삭제(Modify)</button>
//             </div>
//         </div>
//     );
// }
// export default ReadPage;

//#4 쿼리스트링의 유지
// import { useCallback } from "react";
// import { useNavigate, useParams, createSearchParams, useSearchParams } from "react-router-dom";


// const ReadPage = (props) => {
//     // function ReadPage(props) {
//     const { tno } = useParams()

//     const navigate = useNavigate()

//     const [queryParams] = useSearchParams()
//     const page = queryParams.get("page") ? parseInt(queryParams.get("page")) : 1
//     const size = queryParams.get("size") ? parseInt(queryParams.get("size")) : 10

//     const queryStr = createSearchParams({ page, size }).toString()

//     const moveToModify = useCallback((tno) => {
//         navigate({
//             pathname: `/todo/modify/${tno}`,
//             search: queryStr
//         })
//     }, [tno, page, size])

//     return (
//         <div className="text-3xl font-extrabold text-center text-neutral-50 bg-lime-900">
//             Todo 조회 페이지(Read Page Component) {tno}

//             <div>
//                 <button onClick={() => moveToModify(tno)} >Test 수정/삭제(Modify)</button>
//             </div>
//         </div>
//     );
// }
// export default ReadPage;

//#5  조회 -> 목록 이동
// import { useCallback } from "react";
// import { useNavigate, useParams, createSearchParams, useSearchParams } from "react-router-dom";


// const ReadPage = (props) => {
//     // function ReadPage(props) {
//     const { tno } = useParams()

//     const navigate = useNavigate()

//     const [queryParams] = useSearchParams()
//     const page = queryParams.get("page") ? parseInt(queryParams.get("page")) : 1
//     const size = queryParams.get("size") ? parseInt(queryParams.get("size")) : 10

//     const queryStr = createSearchParams({ page, size }).toString()

//     const moveToModify = useCallback((tno) => {
//         navigate({
//             pathname: `/todo/modify/${tno}`,
//             search: queryStr
//         })
//     }, [tno, page, size])


//     const moveToList = useCallback(() => {
//         navigate({
//             pathname: `/todo/list`,
//             search: queryStr
//         })
//     }, [page, size])



//     return (
//         <div className="text-3xl font-extrabold text-center text-neutral-50 bg-lime-900">
//             Todo 조회 페이지(Read Page Component) {tno}

//             <div>
//                 <button onClick={() => moveToModify(tno)} >Test 수정/삭제(Modify)</button>
//                 <br />
//                 <button onClick={() => moveToList()} >Test 리스트(List)</button>
//             </div>
//         </div>
//     );
// }
// export default ReadPage;

//------------------------------------
//# 7.
import { useCallback } from "react";
import { useNavigate, useParams, createSearchParams, useSearchParams } from "react-router-dom";
import ReadComponent from "./ReadComponent";


const ReadPage = (props) => {
    // function ReadPage(props) {
    const { tno } = useParams()

    const navigate = useNavigate()

    const [queryParams] = useSearchParams()
    const page = queryParams.get("page") ? parseInt(queryParams.get("page")) : 1
    const size = queryParams.get("size") ? parseInt(queryParams.get("size")) : 10

    const queryStr = createSearchParams({ page, size }).toString()

    const moveToModify = useCallback((tno) => {
        navigate({
            pathname: `/todo/modify/${tno}`,
            search: queryStr
        })
    }, [tno, page, size])


    const moveToList = useCallback(() => {
        navigate({
            pathname: `/todo/list`,
            search: queryStr
        })
    }, [page, size])
// 변경 -------------------------
    return (
        <div className="text-xl font-extrabold text-center text-neutral-50 bg-lime-900  w-full pt-5  mt-4">  
        {/* bg-white */}
            Todo 조회 페이지(Read Page Component) {tno}

            <div className="text-xs mt-2">
                {/* <button onClick={() => moveToModify(tno)} >Test 수정/삭제(Modify)</button>
                <br />
                <button onClick={() => moveToList()} >Test 리스트(List)</button> */}
                Todo Read Page Component {tno}
            </div>
            <ReadComponent tno={tno}> </ReadComponent>
        </div>
    );
}
export default ReadPage;