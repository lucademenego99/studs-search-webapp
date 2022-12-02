<%--
  Created by IntelliJ IDEA.
  User: lucademenego
  Date: 02/12/22
  Time: 11:18
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="wave-container">
    <img src="assets/wave.svg" alt="Wave UI element">
    <div class="title-container">
        <h1 class="title">studs-search</h1>
        <p class="subtitle">@University of Trento</p>
    </div>
</div>

<style>
    .wave-container {
        position: absolute;
        left: 0;
        bottom: 0;
        width: 100%;
    }

    .wave-container img {
        position: absolute;
        bottom: 0;
        width: 100%;
        object-fit: cover;
    }

    .wave-container .title-container {
        position: absolute;
        right: 15px;
        bottom: 15px;
        display: flex;
        flex-direction: column;
        align-items: flex-end;
        gap: 0.15em;
    }

    .wave-container .title-container .title {
        font-size: 2.6em;
        color: #B9B9B9;
    }

    .wave-container .title-container .subtitle {
        font-size: 1em;
        color: #8B8B8B;
    }
</style>

