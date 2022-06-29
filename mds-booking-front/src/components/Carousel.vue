<script setup lang="ts">
import { enumStringBody } from "@babel/types";
import { computed, ref } from "vue";
const props = withDefaults(defineProps<{ images: string[] }>(), {});
const imagesLength = computed(() => props.images.length - 1);
const selectedImage = ref(0);
const emits = defineEmits(["imageClick"]);
function goNextImage() {
  if (selectedImage.value < imagesLength.value) {
    selectedImage.value++;
  } else {
    selectedImage.value = 0;
  }
}

function goPrevImage() {
  if (selectedImage.value === 0) {
    selectedImage.value = imagesLength.value;
  } else {
    selectedImage.value--;
  }
}

function imageClicked() {
  emits("imageClick");
}
</script>

<template>
  <div class="carousel">
    <img :src="props.images[selectedImage].url" class="img" @click="imageClicked()" />
    <div>
      <span class="control prev" @click="goPrevImage()">prev</span>
      <span class="control next" @click="goNextImage()">next</span>
    </div>
  </div>
</template>

<style scoped>
.carousel {
  display: flex;
  position: relative;
  width: fit-content;
  height: fit-content;
}

.control {
  position: absolute;
  top: 50%;
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

.img {
  height: 100%;
  width: 100%;
}
</style>
