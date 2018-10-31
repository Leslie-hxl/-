package Adapter;

import android.graphics.Rect;

import io.agora.rtc.IRtcEngineEventHandler;

public class hanlder {
   public static IRtcEngineEventHandler gethandler(){
        return new IRtcEngineEventHandler() {
            @Override
            public void onJoinChannelSuccess(String channel, int uid, int elapsed) {
                super.onJoinChannelSuccess(channel, uid, elapsed);
            }

            @Override
            public void onRejoinChannelSuccess(String channel, int uid, int elapsed) {
                super.onRejoinChannelSuccess(channel, uid, elapsed);
            }

            @Override
            public void onWarning(int warn) {
                super.onWarning(warn);
            }

            @Override
            public void onError(int err) {
                super.onError(err);
            }

            @Override
            public void onApiCallExecuted(int error, String api, String result) {
                super.onApiCallExecuted(error, api, result);
            }

            @Override
            public void onCameraReady() {
                super.onCameraReady();
            }

            @Override
            public void onCameraFocusAreaChanged(Rect rect) {
                super.onCameraFocusAreaChanged(rect);
            }

            @Override
            public void onVideoStopped() {
                super.onVideoStopped();
            }

            @Override
            public void onAudioQuality(int uid, int quality, short delay, short lost) {
                super.onAudioQuality(uid, quality, delay, lost);
            }

            @Override
            public void onLeaveChannel(RtcStats stats) {
                super.onLeaveChannel(stats);
            }

            @Override
            public void onRtcStats(RtcStats stats) {
                super.onRtcStats(stats);
            }

            @Override
            public void onAudioVolumeIndication(AudioVolumeInfo[] speakers, int totalVolume) {
                super.onAudioVolumeIndication(speakers, totalVolume);
            }

            @Override
            public void onNetworkQuality(int uid, int txQuality, int rxQuality) {
                super.onNetworkQuality(uid, txQuality, rxQuality);
            }

            @Override
            public void onLastmileQuality(int quality) {
                super.onLastmileQuality(quality);
            }

            @Override
            public void onUserJoined(int uid, int elapsed) {
                super.onUserJoined(uid, elapsed);
            }

            @Override
            public void onUserOffline(int uid, int reason) {
                super.onUserOffline(uid, reason);
            }

            @Override
            public void onUserMuteAudio(int uid, boolean muted) {
                super.onUserMuteAudio(uid, muted);
            }

            @Override
            public void onUserMuteVideo(int uid, boolean muted) {
                super.onUserMuteVideo(uid, muted);
            }

            @Override
            public void onUserEnableVideo(int uid, boolean enabled) {
                super.onUserEnableVideo(uid, enabled);
            }

            @Override
            public void onUserEnableLocalVideo(int uid, boolean enabled) {
                super.onUserEnableLocalVideo(uid, enabled);
            }

            @Override
            public void onLocalVideoStat(int sentBitrate, int sentFrameRate) {
                super.onLocalVideoStat(sentBitrate, sentFrameRate);
            }

            @Override
            public void onRemoteVideoStat(int uid, int delay, int receivedBitrate, int receivedFrameRate) {
                super.onRemoteVideoStat(uid, delay, receivedBitrate, receivedFrameRate);
            }

            @Override
            public void onRemoteVideoStats(RemoteVideoStats stats) {
                super.onRemoteVideoStats(stats);
            }

            @Override
            public void onLocalVideoStats(LocalVideoStats stats) {
                super.onLocalVideoStats(stats);
            }

            @Override
            public void onFirstRemoteVideoFrame(int uid, int width, int height, int elapsed) {
                super.onFirstRemoteVideoFrame(uid, width, height, elapsed);
            }

            @Override
            public void onFirstLocalVideoFrame(int width, int height, int elapsed) {
                super.onFirstLocalVideoFrame(width, height, elapsed);
            }

            @Override
            public void onFirstRemoteVideoDecoded(int uid, int width, int height, int elapsed) {
                super.onFirstRemoteVideoDecoded(uid, width, height, elapsed);
            }

            @Override
            public void onVideoSizeChanged(int uid, int width, int height, int rotation) {
                super.onVideoSizeChanged(uid, width, height, rotation);
            }

            @Override
            public void onConnectionLost() {
                super.onConnectionLost();
            }

            @Override
            public void onConnectionInterrupted() {
                super.onConnectionInterrupted();
            }

            @Override
            public void onConnectionBanned() {
                super.onConnectionBanned();
            }

            @Override
            public void onStreamMessage(int uid, int streamId, byte[] data) {
                super.onStreamMessage(uid, streamId, data);
            }

            @Override
            public void onRemoteVideoStateChanged(int uid, int state) {
                super.onRemoteVideoStateChanged(uid, state);
            }

            @Override
            public void onStreamMessageError(int uid, int streamId, int error, int missed, int cached) {
                super.onStreamMessageError(uid, streamId, error, missed, cached);
            }

            @Override
            public void onMediaEngineLoadSuccess() {
                super.onMediaEngineLoadSuccess();
            }

            @Override
            public void onMediaEngineStartCallSuccess() {
                super.onMediaEngineStartCallSuccess();
            }

            @Override
            public void onAudioMixingFinished() {
                super.onAudioMixingFinished();
            }

            @Override
            public void onRequestToken() {
                super.onRequestToken();
            }

            @Override
            public void onAudioRouteChanged(int routing) {
                super.onAudioRouteChanged(routing);
            }

            @Override
            public void onFirstLocalAudioFrame(int elapsed) {
                super.onFirstLocalAudioFrame(elapsed);
            }

            @Override
            public void onFirstRemoteAudioFrame(int uid, int elapsed) {
                super.onFirstRemoteAudioFrame(uid, elapsed);
            }

            @Override
            public void onActiveSpeaker(int uid) {
                super.onActiveSpeaker(uid);
            }

            @Override
            public void onAudioEffectFinished(int soundId) {
                super.onAudioEffectFinished(soundId);
            }

            @Override
            public void onClientRoleChanged(int oldRole, int newRole) {
                super.onClientRoleChanged(oldRole, newRole);
            }

            @Override
            public void onStreamPublished(String url, int error) {
                super.onStreamPublished(url, error);
            }

            @Override
            public void onStreamUnpublished(String url) {
                super.onStreamUnpublished(url);
            }

            @Override
            public void onTranscodingUpdated() {
                super.onTranscodingUpdated();
            }

            @Override
            public void onStreamInjectedStatus(String url, int uid, int status) {
                super.onStreamInjectedStatus(url, uid, status);
            }

            @Override
            public void onTokenPrivilegeWillExpire(String token) {
                super.onTokenPrivilegeWillExpire(token);
            }

            @Override
            public void onLocalPublishFallbackToAudioOnly(boolean isFallbackOrRecover) {
                super.onLocalPublishFallbackToAudioOnly(isFallbackOrRecover);
            }

            @Override
            public void onRemoteSubscribeFallbackToAudioOnly(int uid, boolean isFallbackOrRecover) {
                super.onRemoteSubscribeFallbackToAudioOnly(uid, isFallbackOrRecover);
            }

            @Override
            public void onRemoteVideoTransportStats(int uid, int delay, int lost, int rxKBitRate) {
                super.onRemoteVideoTransportStats(uid, delay, lost, rxKBitRate);
            }

            @Override
            public void onRemoteAudioTransportStats(int uid, int delay, int lost, int rxKBitRate) {
                super.onRemoteAudioTransportStats(uid, delay, lost, rxKBitRate);
            }

            @Override
            public int hashCode() {
                return super.hashCode();
            }

            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }

            @Override
            protected Object clone() throws CloneNotSupportedException {
                return super.clone();
            }

            @Override
            public String toString() {
                return super.toString();
            }

            @Override
            protected void finalize() throws Throwable {
                super.finalize();
            }
        };
    }
}
