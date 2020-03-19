(function(){/* 
 
 Copyright The Closure Library Authors. 
 SPDX-License-Identifier: Apache-2.0 
*/ 
'use strict';var f=this||self;function ba(){} 
function ca(a){var b=typeof a;if("object"==b)if(a){if(a instanceof Array)return"array";if(a instanceof Object)return b;var c=Object.prototype.toString.call(a);if("[object Window]"==c)return"object";if("[object Array]"==c||"number"==typeof a.length&&"undefined"!=typeof a.splice&&"undefined"!=typeof a.propertyIsEnumerable&&!a.propertyIsEnumerable("splice"))return"array";if("[object Function]"==c||"undefined"!=typeof a.call&&"undefined"!=typeof a.propertyIsEnumerable&&!a.propertyIsEnumerable("call"))return"function"}else return"null"; 
else if("function"==b&&"undefined"==typeof a.call)return"object";return b}function da(a,b,c){return a.call.apply(a.bind,arguments)}function ea(a,b,c){if(!a)throw Error();if(2<arguments.length){var d=Array.prototype.slice.call(arguments,2);return function(){var e=Array.prototype.slice.call(arguments);Array.prototype.unshift.apply(e,d);return a.apply(b,e)}}return function(){return a.apply(b,arguments)}} 
function k(a,b,c){Function.prototype.bind&&-1!=Function.prototype.bind.toString().indexOf("native code")?k=da:k=ea;return k.apply(null,arguments)}var fa=Date.now||function(){return+new Date};function m(a,b){function c(){}c.prototype=b.prototype;a.B=b.prototype;a.prototype=new c;a.prototype.constructor=a};function n(a,b){Array.prototype.forEach.call(a,b,void 0)};function ha(a){let b=!1,c;return function(){b||(c=a(),b=!0);return c}};function r(a,b){this.b=a===t&&b||"";this.c=ia}r.prototype.f=!0;r.prototype.a=function(){return this.b.toString()};var ja=/^(?:(?:https?|mailto|ftp):|[^:/?#]*(?:[/?#]|$))/i;function ka(a){if(a instanceof r)return a;a="object"==typeof a&&a.f?a.a():String(a);ja.test(a)||(a="about:invalid#zClosurez");return new r(t,a)}var ia={},t={};function u(a){u[" "](a);return a}u[" "]=ba;function v(){}var la="function"==typeof Uint8Array;function y(a,b,c){a.a=null;b||(b=[]);a.j=void 0;a.f=-1;a.b=b;a:{if(b=a.b.length){--b;var d=a.b[b];if(!(null===d||"object"!=typeof d||Array.isArray(d)||la&&d instanceof Uint8Array)){a.g=b-a.f;a.c=d;break a}}a.g=Number.MAX_VALUE}a.i={};if(c)for(b=0;b<c.length;b++)if(d=c[b],d<a.g)d+=a.f,a.b[d]=a.b[d]||z;else{var e=a.g+a.f;a.b[e]||(a.c=a.b[e]={});a.c[d]=a.c[d]||z}}var z=[]; 
function B(a,b){if(b<a.g){b+=a.f;var c=a.b[b];return c===z?a.b[b]=[]:c}if(a.c)return c=a.c[b],c===z?a.c[b]=[]:c}function C(a,b,c){a=B(a,b);return null==a?c:a}function D(a,b){a=B(a,b);a=null==a?a:!!a;return null==a?!1:a}function ma(a){var b=E;a.a||(a.a={});if(!a.a[1]){var c=B(a,1);c&&(a.a[1]=new b(c))}return a.a[1]}function na(a){var b=oa;a.a||(a.a={});if(!a.a[1]){for(var c=B(a,1),d=[],e=0;e<c.length;e++)d[e]=new b(c[e]);a.a[1]=d}b=a.a[1];b==z&&(b=a.a[1]=[]);return b}v.prototype.toString=function(){return this.b.toString()};function E(a){y(this,a,pa)}m(E,v);function oa(a){y(this,a,null)}m(oa,v);var pa=[1];function qa(a){y(this,a,null)}m(qa,v);var F=document,G=window;var ra={capture:!0},sa={passive:!0},ta=ha(function(){let a=!1;try{const b=Object.defineProperty({},"passive",{get:function(){a=!0}});f.addEventListener("test",null,b)}catch(b){}return a});function ua(a){return a?a.passive&&ta()?a:a.capture||!1:!1}function H(a,b,c,d){a.addEventListener&&a.addEventListener(b,c,ua(d))};function va(a,b,c){if(Array.isArray(b))for(var d=0;d<b.length;d++)va(a,String(b[d]),c);else null!=b&&c.push(a+(""===b?"":"="+encodeURIComponent(String(b))))};function I(){var a=J;try{var b;if(b=!!a&&null!=a.location.href)a:{try{u(a.foo);b=!0;break a}catch(c){}b=!1}return b}catch(c){return!1}};var wa=/^((market|itms|intent|itms-appss):\/\/)/i;var xa=()=>{var a=`${"http:"===G.location.protocol?"http:":"https:"}//${"pagead2.googlesyndication.com"}/pagead/gen_204`;return b=>{b={id:"unsafeurl",ctx:625,url:b};var c=[];for(d in b)va(d,b[d],c);var d=c.join("&");if(d){b=a.indexOf("#");0>b&&(b=a.length);c=a.indexOf("?");if(0>c||c>b){c=b;var e=""}else e=a.substring(c+1,b);b=[a.substr(0,c),e,a.substr(b)];c=b[1];b[1]=d?c?c+"&"+d:d:c;d=b[0]+(b[1]?"?"+b[1]:"")+b[2]}else d=a;navigator.sendBeacon&&navigator.sendBeacon(d,"")}};var ya=(a,b)=>{if(a)for(let c in a)Object.prototype.hasOwnProperty.call(a,c)&&b.call(void 0,a[c],c,a)},za=!!window.google_async_iframe_id;let J=za&&window.parent||window;var Aa=(a,b)=>{a&&ya(b,(c,d)=>{a.style[d]=c})},Ba=a=>{var b=F.body;const c=document.createDocumentFragment(),d=a.length;for(let e=0;e<d;++e)c.appendChild(a[e]);b.appendChild(c)};var Ca=(a=[])=>{f.google_logging_queue||(f.google_logging_queue=[]);f.google_logging_queue.push([12,a])};let K=null;class Da{constructor(a,b,c,d=0,e){this.label=a;this.type=b;this.value=c;this.duration=d;this.uniqueId=Math.random();this.slotId=e}};const L=f.performance,Ea=!!(L&&L.mark&&L.measure&&L.clearMarks),M=ha(()=>{var a;if(a=Ea){var b;if(null===K){K="";try{a="";try{a=f.top.location.hash}catch(c){a=f.location.hash}a&&(K=(b=a.match(/\bdeid=([\d,]+)/))?b[1]:"")}catch(c){}}b=K;a=!!b.indexOf&&0<=b.indexOf("1337")}return a});function Fa(a){a&&L&&M()&&(L.clearMarks(`goog_${a.label}_${a.uniqueId}_start`),L.clearMarks(`goog_${a.label}_${a.uniqueId}_end`))} 
class Ga{constructor(a,b){this.a=[];this.c=b||f;let c=null;b&&(b.google_js_reporting_queue=b.google_js_reporting_queue||[],this.a=b.google_js_reporting_queue,c=b.google_measure_js_timing);this.b=M()||(null!=c?c:Math.random()<a)}start(a,b){if(!this.b)return null;var c=(c=f.performance)&&c.now?c.now():null;c||(c=(c=f.performance)&&c.now&&c.timing?Math.floor(c.now()+c.timing.navigationStart):fa());a=new Da(a,b,c);b=`goog_${a.label}_${a.uniqueId}_start`;L&&M()&&L.mark(b);return a}};var R;if(za&&!I()){let a="."+F.domain;try{for(;2<a.split(".").length&&!I();)F.domain=a=a.substr(a.indexOf(".")+1),J=window.parent}catch(b){}I()||(J=window)}R=J;const S=new Ga(1,R);var Ha=()=>{R.google_measure_js_timing||(S.b=!1,S.a!=S.c.google_js_reporting_queue&&(M()&&n(S.a,Fa),S.a.length=0))};"number"!==typeof R.google_srt&&(R.google_srt=Math.random());"complete"==R.document.readyState?Ha():S.b&&H(R,"load",()=>{Ha()});var Ia=a=>{H(G,"message",b=>{let c;try{c=JSON.parse(b.data)}catch(d){return}!c||"ig"!==c.googMsgType||a(c,b)})};function T(){this.b=this.b;this.c=this.c}T.prototype.b=!1;function Ja(a){a.b||(a.b=!0,a.f())}T.prototype.f=function(){if(this.c)for(;this.c.length;)this.c.shift()()};function U(a,b,c){T.call(this);this.g=a;this.s=b||0;this.i=c;this.j=k(this.m,this)}m(U,T);U.prototype.a=0;U.prototype.f=function(){U.B.f.call(this);this.stop();delete this.g;delete this.i};U.prototype.start=function(a){this.stop();var b=this.j;a=void 0!==a?a:this.s;if("function"!=ca(b))if(b&&"function"==typeof b.handleEvent)b=k(b.handleEvent,b);else throw Error("Invalid listener argument");this.a=2147483647<Number(a)?-1:f.setTimeout(b,a||0)}; 
U.prototype.stop=function(){0!=this.a&&f.clearTimeout(this.a);this.a=0};U.prototype.m=function(){this.a=0;this.g&&this.g.call(this.i)};const Ka={display:"inline-block",position:"absolute"},La={display:"none",width:"100%",height:"100%",top:"0",left:"0"},V=(a,b)=>{a&&(a.style.display=b?"inline-block":"none")},Ma=(a,b)=>{if(a)return G.getComputedStyle(a).getPropertyValue(b)};function Na(a=""){const b={top:0,right:0,bottom:0,left:0};a&&(a=a.split(","),4==a.length&&a.reduce((c,d)=>c&&!isNaN(d),!0)&&([b.top,b.right,b.bottom,b.left]=a.map(c=>+c)));return b} 
function Oa(a,b,c=2147483647){const d=F.createElement("DIV");Aa(d,Object.assign(Ka,{"z-index":c},b));D(a.a,10)&&H(d,"click",ba);if(D(a.a,11)){a=b=F.createElement("A");c=xa();var e;wa.test("#")?e=new r(t,"#"):e="#";"about:invalid#zClosurez"===(e instanceof r?e:ka(e)).a()&&c(String(e));e=e instanceof r?e:ka(e);a.href=e instanceof r&&e.constructor===r&&e.c===ia?e.b:"type_error:SafeUrl";b.appendChild(d);return b}return d} 
function Pa(a,b){switch(C(b.h,5,1)){case 2:G.AFMA_Communicator&&G.AFMA_Communicator.addEventListener&&G.AFMA_Communicator.addEventListener("onshow",()=>{W(a,b)});break;case 10:H(G,"i-creative-view",()=>{W(a,b)});break;case 4:H(F,"DOMContentLoaded",()=>{W(a,b)});break;case 8:Ia(c=>{c.rr&&W(a,b)});break;case 9:if(G.IntersectionObserver){const c=new IntersectionObserver(d=>{for(let e of d)if(0<e.intersectionRatio){W(a,b);break}});c.observe(F.body);a.A.push(c)}break;case 11:G.AFMA_Communicator&&G.AFMA_Communicator.addEventListener&& 
G.AFMA_Communicator.addEventListener("onAdVisibilityChanged",()=>{W(a,b)})}}function Qa(a,b){b=Na(b);const c=C(a.a,9,0);a.c=[{width:"100%",height:b.top+c+"px",top:-c+"px",left:"0"},{width:b.right+c+"px",height:"100%",top:"0",right:-c+"px"},{width:"100%",height:b.bottom+c+"px",bottom:-c+"px",left:"0"},{width:b.left+c+"px",height:"100%",top:"0",left:-c+"px"}].map(d=>Oa(a,d,9019))} 
function Ra(a){var b=0;for(let d of a.w){const e=d.h,p=a.m[C(e,5,1)];d.l||void 0===p||(b=Math.max(b,p+C(e,2,0)))}a.g&&Ja(a.g);b-=Date.now();const c=a.b;0<b?(V(c,!0),a.g=new U(()=>{V(c,!1)},b),a.g.start()):V(c,!1)}function W(a,b){if(!b.l){var c=C(b.h,5,1);a.m[c]=Date.now();D(b.h,9)&&(a.w.push(b),Ra(a))}} 
class Sa{constructor(){this.c=[];this.g=this.b=null;this.w=[];this.a=null;this.s=[];this.f=[];this.j=[];this.m={};this.A=[];this.i=null}init(a){Ca([a]);this.a=new qa(a);a=ma(this.a);n(na(a),e=>{this.j.push({u:0,l:!1,v:0,h:e,o:-1})});try{var b=F.querySelectorAll("*[data-ifc]")}catch(e){b=[]}this.f=b;let c=!1;b=this.f.length;for(let e=0;e<b;++e)a=new E(JSON.parse(this.f[e].getAttribute("data-ifc")||"[]")),n(na(a),p=>{this.j.push({u:0,l:!1,v:0,h:p,o:e});1===C(p,4,1)&&(c=!0)});b=!1;for(var d of this.j)a= 
d.h,0<C(a,2,0)&&0<C(a,5,1)?(!this.b&&D(a,9)&&(this.b=Oa(this,La)),Pa(this,d)):C(a,1,"")&&D(a,9)&&Qa(this,C(a,1,"")),C(a,1,"")&&(b=!0);d=[];D(this.a,14)?(this.b&&d.push(this.b),!c&&d.push(...this.c),F.body&&Ba(d)):(d.push(...this.c),this.b&&d.push(this.b),!c&&F.body&&Ba(d));if(D(this.a,13))for(d=F.body.querySelectorAll(".amp-fcp, .amp-bcp"),a=0;a<d.length;++a)"absolute"===Ma(d[a],"position")&&V(d[a],!1);H(F,"click",e=>{var p=-1,q=[];for(let w of this.j){var g=w.o,h=-1!==g;if(!(C(w.h,3,0)<=p||w.l|| 
h&&!1===q[g])){var A=!h||q[g]||this.f[g].contains(e.target);h&&A&&(q[g]=!0);if(g=A){g=e;var l=w;h=l.h;if(0<C(h,2,0)&&0<C(h,5,1))g=this.m[C(h,5,1)],g=void 0!==g&&Date.now()<g+C(h,2,0);else if(C(h,1,"")){{h=(0<=l.o?this.f[l.o]:F.body).getBoundingClientRect();A=parseFloat(Ma(F.body,"zoom")||1);const [Ta,Ua]=[g.clientX,g.clientY],[N,O,X,Y]=[Ta/A-h.left,Ua/A-h.top,h.width,h.height];if(!(0<X&&0<Y)||isNaN(N)||isNaN(O)||0>N||0>O)g=!1;else{l=Na(C(l.h,1,""));var Z=!(N>=l.left&&X-N>l.right&&O>=l.top&&Y-O>l.bottom); 
if(this.i&&D(this.a,12)&&500>g.timeStamp-this.i.timeStamp){g=this.i.changedTouches[0];const [P,Q]=[g.clientX/A-h.left,g.clientY/A-h.top];!isNaN(P)&&!isNaN(Q)&&0<=P&&0<=Q&&(Z=Z||!(P>=l.left&&X-P>l.right&&Q>=l.top&&Y-Q>l.bottom))}g=Z}}}else g=!0}if(g){var x=w;p=C(w.h,3,0)}}}if(x)switch(p=x.h,C(p,4,1)){case 2:case 3:e.preventDefault?e.preventDefault():e.returnValue=!1;q=Date.now();500<q-x.v&&(x.v=q,++x.u);q=x.h;if(C(q,8,0)&&x.u>=C(q,8,0))if(x.l=!0,this.b&&0<C(q,2,0))Ra(this);else if(0<this.c.length&& 
C(q,1,""))for(var aa of this.c)V(aa,!1);aa=p.b;for(let w of this.s)w(e,aa)}},ra);b&&D(this.a,12)&&H(F,"touchend",e=>{this.i=e},sa)}registerCallback(a){this.s.push(a)}};window.googqscp=new Sa;}).call(this);
