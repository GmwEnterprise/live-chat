import CryptoJS from 'crypto-js'

var key = CryptoJS.enc.Utf8.parse('GmwEnterprise.cn')
/*加密*/
function aesEncode(str) {
  var encryptedData = CryptoJS.AES.encrypt(str, key, {
    mode: CryptoJS.mode.ECB,
    padding: CryptoJS.pad.Pkcs7
  })
  return encryptedData.toString()
}

/*解密*/
function aesDecode(encryptedStr) {
  var encryptedHexStr = CryptoJS.enc.Base64.parse(encryptedStr)
  var encryptedBase64Str = CryptoJS.enc.Base64.stringify(encryptedHexStr)
  var decryptedData = CryptoJS.AES.decrypt(encryptedBase64Str, key, {
    mode: CryptoJS.mode.ECB,
    padding: CryptoJS.pad.Pkcs7
  })
  return decryptedData.toString(CryptoJS.enc.Utf8)
}

export default {
  aesDecode, aesEncode
}