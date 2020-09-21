// vue.config.js
module.exports = {
  // 打包路径直接设置为server的/resources/static/dist目录
  // outputDir: '../live-chat-client-server/src/main/resources/static/dist',
  // configureWebpack: {
  //   devtool: 'source-map'
  // },
  devServer: {
    port: 3000,
    proxy: 'http://localhost:4200/api/v1'
  }
}