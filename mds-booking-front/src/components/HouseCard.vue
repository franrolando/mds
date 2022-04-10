<script setup lang="ts">
import { ref } from "vue";
import { House } from "../views/Search/models";
const props = withDefaults(defineProps<{ house: House }>(), {});
const imagesLength = props.house.images.length - 1;
const selectedImage = ref(0);

function goNextImage() {
  console.log(selectedImage.value);
  if (selectedImage.value < imagesLength) {
    selectedImage.value++;
  } else {
    selectedImage.value = 0;
  }
}

function goPrevImage() {
  console.log(selectedImage.value);
  if (selectedImage.value == 0) {
    selectedImage.value = imagesLength;
  } else {
    selectedImage.value--;
  }
}
</script>

<template>
  <div class="card">
    <div class="carousel">
      <img
        class="image"
        :src="props.house.images[selectedImage] + '=' + Math.floor(Math.random() * 200)"
      />
      <span class="control prev" @click="goPrevImage()">prev</span>
      <span class="control next" @click="goNextImage()">next</span>
    </div>
    <div class="name">{{ props.house.name }}</div>
  </div>
</template>

<style scoped>
.carousel {
  height: 200px;
  display: flex;
  gap: 30px;
  position: relative;
  width: fit-content;
}

.image {
  width: 200px;
}

.control {
  position: absolute;
  margin-top: 90px;
  color: white;
  font-weight: bold;
}

.control:hover {
  cursor: pointer;
  text-decoration: underline;
}

.next {
  right: 0;
}

.prev {
  left: 0;
}

.name {
  text-align: center;
}

.card {
  width: fit-content;
  display: flex;
  flex-direction: column;
}
</style>
