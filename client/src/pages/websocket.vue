<script setup>
import ip_port from '../config/network.js'
let websocket = new WebSocket("ws://"+ ip_port +"/test");

// 连接打开
websocket.onopen = e => {
  console.log("连接打开");

  // 创建连接后，往服务器连续写入3条消息
  websocket.send("springdoc.cn");
  websocket.send("springdoc.cn");
  websocket.send("springdoc.cn");

  // 最后发送 bye，由服务器断开连接
  websocket.send("bye");

  // 也可以由客户端主动断开
  websocket.close();
}

// 连接断开
websocket.onclose = e => {
  console.log(`连接关闭: code=${e.code}, reason=${e.reason}`)
}
// 收到消息
websocket.onmessage = e => {
  console.log(`收到消息：${e.data}`);
}
// 异常
websocket.onerror = e => {
  console.log("连接异常")
  console.error(e)
}

</script>

<template>

</template>

<style scoped>

</style>