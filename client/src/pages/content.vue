<script setup>
import {useRoute} from "vue-router";
const route = useRoute(); // 获取当前路由对象
let nickname = route.query.nickname, room_id = route.query.room_id;

console.log(nickname + " " + room_id)
</script>
<template>

</template>
<style scoped>

</style>