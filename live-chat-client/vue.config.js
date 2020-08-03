// vue.config.js
module.exports = {
  // 打包路径直接设置为server的/resources/static/dist目录
  outputDir: '../live-chat-client-server/src/main/resources/static/dist',
  configureWebpack: {
    devtool: 'source-map'
  }
}