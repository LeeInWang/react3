// function AboutPage(){ }

// const AboutPage = () =>{
//     return(
//         <div className="text-3xl text-center font-bold text-orange-500">
//             About Page
//         </div>
//     );
// }

// export default AboutPage;

//#2. BasicLayout 적용
import BasicLayout from "../layouts/BasicLayout";

const AboutPage = () => {
    return(
        <BasicLayout>
            <div className="text-3xl">About Page</div>
        </BasicLayout>
    );
}
export default AboutPage;