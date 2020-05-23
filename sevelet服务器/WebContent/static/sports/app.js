const tencentcloud = require("./node_modules/tencentcloud-sdk-nodejs");

const OcrClient = tencentcloud.ocr.v20181119.Client;
const models = tencentcloud.ocr.v20181119.Models;

const Credential = tencentcloud.common.Credential;
const ClientProfile = tencentcloud.common.ClientProfile;
const HttpProfile = tencentcloud.common.HttpProfile;

let cred = new Credential("AKIDRdYjfSubU6QnTPuVgcKmw2dy2qyNuO1N", "LPDgZBsJYbQzYtynNCUYNwJH0UJgqmiR");
let httpProfile = new HttpProfile();
httpProfile.endpoint = "ocr.ap-beijing.tencentcloudapi.com";
let clientProfile = new ClientProfile();
clientProfile.httpProfile = httpProfile;
let client = new OcrClient(cred, "ap-beijing", clientProfile);

let req = new models.IDCardOCRRequest();



var img = "http://huidianedu.com/public/images/1.jpg";//imgurl 就是你的图片路径  

// function getBase64Image(img) {
//   var canvas = document.createElement("canvas");
//   canvas.width = img.width;
//   canvas.height = img.height;
//   var ctx = canvas.getContext("2d");
//   ctx.drawImage(img, 0, 0, img.width, img.height);
//   var ext = img.src.substring(img.src.lastIndexOf(".") + 1).toLowerCase();
//   var dataURL = canvas.toDataURL("image/" + ext);
//   return dataURL;
// }


let params = '{"ImageUrl":"http://huidianedu.com/public/images/1.jpg"}'

// let params = '{"ImageBase64": '+  getBase64Image(img) +' }'
  


req.from_json_string(params);


client.IDCardOCR(req, function(errMsg, response) {

    if (errMsg) {
        console.log(errMsg);
        return;
    }

    console.log(response.to_json_string());
});
