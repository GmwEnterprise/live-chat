// 正则表达式参考文章：http://toc.lieme.cn/2019/08/07/%E5%B8%B8%E7%94%A8%E7%9A%84JS%E6%AD%A3%E5%88%99%E6%A0%A1%E9%AA%8C%E8%A1%A8%E8%BE%BE%E5%BC%8F.html

// 手机规则校验
const phoneReg = /^1[3456789]\d{9}$/;
// 邮箱规则校验
const emailReg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
// URL规则校验
const urlReg = /^((https?|ftp|file):\/\/)?([\da-z\.-]+)\.([a-z\.]{2,6})([\/\w\.-]*)*\/?$/;
// 只能由字母组成
const onlyLetterReg = /^[a-z]+$/i;
// 只能由英文、数字组成
const onlyLetterAndNumberReg = /^[a-z0-9]+$/i;
// 只能由英文、数字、下划线组成
const onlyLetterAndNumberAndUnderlineReg = /^\w+$/;

export function validOnlyLetterReg(str) {
  return onlyLetterReg.test(str);
}

export function validOnlyLetterAndNumberReg(str) {
  return onlyLetterAndNumberReg.test(str);
}

export function validOnlyLetterAndNumberAndUnderlineReg(str) {
  return onlyLetterAndNumberAndUnderlineReg.test(str);
}

export function validPhone(phone) {
  return phoneReg.test(phone);
}

export function validEmail(email) {
  return emailReg.test(email);
}

export function validURL(url) {
  return urlReg.test(url);
}
