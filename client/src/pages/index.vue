<script setup>
import {ref} from "vue";
import {useRouter} from "vue-router";
let nickname = ref(), room_id = ref(), router = useRouter()
function login() {
  router.push({path: "/content", query: {nickname: nickname.value, room_id: room_id.value}})
}
</script>
<template>
  <div id="index">
    <input id="nickname" v-model="nickname" placeholder="代号">
    <input id="room_id" v-model="room_id" placeholder="房间ID">
    <button @click="login">进入房间</button>
  </div>
</template>
<style>
  #index {
    text-align: center;
  }
  input {
    width: 20%;
    height: 5vh;
    border-radius: 20px;
    padding: 5px;
    font-size: 15px;
  }
  button {
    width: 6%;
    height: 4vh;
    border-radius: 10px;
    font-size: 13px;
  }
</style>