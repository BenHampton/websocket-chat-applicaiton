<template>
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div @click="$emit('selected-avatar-image', require(`@/assets/${image}`))">
            <img :src="require(`@/assets/${image}`)" class="avatar-image"/>
        </div>
    </div>
</template>

<script>

    export default {
        name: 'AvatarModalView',
        components: { },
        props: {
            image: String
        }
    }
</script>

<style scoped>
    .avatar-image{
        height: 8vh;
        width: 51%;
    }
    @media screen and (max-width: 1300px){
        .avatar-image{
            height: 8vh;
            width: 100%;
        }
    }
    @media screen and (max-width: 500px){
        .avatar-image{
            height: 8vh;
            width: 100%;
        }
    }
    @media screen and (max-width: 400px){
        .avatar-image{
            height: 8vh;
            width: 120%;
        }
    }
    img.avatar-image:hover{
        cursor: pointer;
    }
</style>
