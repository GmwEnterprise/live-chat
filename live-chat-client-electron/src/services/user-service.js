import axios from "../boot/axios";
import { stringify } from "qs";

const http = axios.axiosInst;

/**
 * 根据ID查询用户信息
 * @param {String} userId
 */
async function findByUserId(userId) {
  return await http.get(`/user/${userId}`);
}

/**
 * 登陆
 * @param {String} key 微信号/手机号/邮箱
 * @param {String} password 输入的密码
 */
async function signIn(key, password) {
  await http.post(
    `/user/sign-in-user`,
    stringify({
      key,
      password
    })
  );
}

/**
 * 注册
 * @param {*} user
 */
async function registry({ username, phoneNumber, password }) {
  await http.post(`/user/registry`, {
    username,
    phoneNumber,
    password
  });
}

export default {
  findByUserId,
  signIn,
  registry
};
