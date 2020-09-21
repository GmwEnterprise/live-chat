export class ScrollItem {
  constructor(name, detail, time, mute, icon) {
    this.name = name; // 标题
    this.detail = detail; // 下方详细信息显示
    this.time = time; // 右上方时间，字符串
    this.mute = mute; // 该项是否静音，布尔值
    this.icon = icon; // 左侧图标
  }
}
