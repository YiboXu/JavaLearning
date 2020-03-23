<!DOCTYPE html>
<html lang='zh-CN'>
<head>
<title>README.md · Xiongrj/springcloud-base - Gitee</title>
<link href="https://assets.gitee.com/assets/favicon-9007bd527d8a7851c8330e783151df58.ico" rel="shortcut icon" type="image/vnd.microsoft.icon" />
<meta content='gitee.com/xiongrj/springcloud-base git https://gitee.com/xiongrj/springcloud-base.git' name='go-import'>
<meta charset='utf-8'>
<meta content='always' name='referrer'>
<meta content='Gitee' property='og:site_name'>
<meta content='Object' property='og:type'>
<meta content='http://gitee.com/xiongrj/springcloud-base/blob/master/README.md' property='og:url'>
<meta content='https://gitee.com/static/images/logo_themecolor.png' itemprop='image' property='og:image'>
<meta content='README.md · Xiongrj/springcloud-base - Gitee' itemprop='name' property='og:title'>
<meta content='码云(gitee.com)是 OSCHINA.NET 推出的代码托管平台，支持 Git 和 SVN，提供免费的私有仓库托管。目前已有超过 500 万的开发者选择码云。' property='og:description'>
<meta content='码云,代码托管,git,Git@OSC,gitee.com,开源,内源,项目管理,版本控制,开源代码,代码分享,项目协作,开源项目托管,免费代码托管,Git代码托管,Git托管服务' name='Keywords'>
<meta content='尚硅谷周阳的springcloud源码以及笔记整理' itemprop='description' name='Description'>

<meta content="IE=edge" http-equiv="X-UA-Compatible" />
<meta content="authenticity_token" name="csrf-param" />
<meta content="BWqzuF1wOfQ58Y5aOdnQaXLDVnll+vlx9d64Bj0pJE8=" name="csrf-token" />

<link href="https://assets.gitee.com/assets/application-3f8d1db3a48d2211ad1e18958035b7dc.css" media="screen" rel="stylesheet" />
<script>
//<![CDATA[
window.gon = {};gon.locale="en";gon.sentry_dsn=null;gon.baidu_register_hm_push=null;gon.info={"controller_path":"blob","action_name":"show","current_user":false};gon.tour_env={"current_user":null,"action_name":"show","original_url":"http://gitee.com/xiongrj/springcloud-base/blob/master/README.md","controller_path":"blob"};gon.http_clone="https://gitee.com/xiongrj/springcloud-base.git";gon.user_project="xiongrj/springcloud-base";gon.manage_branch="Manage branch";gon.manage_tag="Manage tag";gon.enterprise_id=0;gon.ref="master";
//]]>
</script>
<script src="https://assets.gitee.com/assets/static/sentry-5.1.0-109ee3d8895a239331efcf947ba7f5d8.js"></script>
<script src="https://assets.gitee.com/assets/application-d017a29f342dd0de92d80b06bce608cb.js"></script>
<script src="https://assets.gitee.com/assets/lib/jquery.timeago.en-d8a06c79c6bf9e7618c1ade936096da5.js"></script>

<link href="https://assets.gitee.com/assets/projects/application-c4d2b90e83d054a150b44a0e5a32f7c5.css" media="screen" rel="stylesheet" />
<script src="https://assets.gitee.com/assets/projects/app-039d52892fc29d6f64a2621e9eff2de6.js"></script>

<script src="//res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
<script>
  var title = document.title.replace(/( - Gitee| - 码云)$/, '')
      imgUrl = '';
  
  document.addEventListener('DOMContentLoaded', function(event) {
    var imgUrlEl = document.querySelector('.readme-box .markdown-body > img, .readme-box .markdown-body :not(a) > img');
    imgUrl = imgUrlEl && imgUrlEl.getAttribute('src');
  
    if (!imgUrl) {
      imgUrlEl = document.querySelector('meta[itemprop=image]');
      imgUrl = imgUrlEl && imgUrlEl.getAttribute('content'); 
      imgUrl = imgUrl || "https://gitee.com/static/images/logo_themecolor.png";
    }
  
    wx.config({
      debug: false,
      appId: "wxff219d611a159737",
      timestamp: "1584976546",
      nonceStr: "3535a243905b7833707796e4c627ea8c",
      signature: "edc204e124d8ab20876d0ca1aebcb37145f24a73",
      jsApiList: [
        'onMenuShareTimeline',
        'onMenuShareAppMessage'
      ]
    });
  
    wx.ready(function () {
      wx.onMenuShareTimeline({
        title: title, // 分享标题
        link: "https://gitee.com/xiongrj/springcloud-base/blob/master/README.md", // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
        imgUrl: imgUrl // 分享图标
      });
      wx.onMenuShareAppMessage({
        title: title, // 分享标题
        link: "https://gitee.com/xiongrj/springcloud-base/blob/master/README.md", // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
        desc: document.querySelector('meta[name=Description]').getAttribute('content'),
        imgUrl: imgUrl // 分享图标
      });
    });
    wx.error(function(res){
      console.error('err', res)
    });
  })
</script>

<script type='text/x-mathjax-config'>
MathJax.Hub.Config({
  tex2jax: {
    inlineMath: [['$','$'], ['\\(','\\)']],
    displayMath: [["$$","$$"],["\\[","\\]"]],
    processEscapes: true,
    skipTags: ['script', 'noscript', 'style', 'textarea', 'pre', 'code'],
    ignoreClass: "container|files",
    processClass: "markdown-body"
  }
});
</script>
<script src="https://assets.gitee.com/uploads/resources/MathJax-2.7.2/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>

<script>
  (function () {
    var messages = {
      'zh-CN': {
        addResult: '增加 <b>{term}</b>',
        count: '已选择 {count}',
        maxSelections: '最多 {maxCount} 个选择',
        noResults: '未找到结果',
        serverError: '连接服务器时发生错误'
      },
      'zh-TW': {
        addResult: '增加 <b>{term}</b>',
        count: '已選擇 {count}',
        maxSelections: '最多 {maxCount} 個選擇',
        noResults: '未找到結果',
        serverError: '連接服務器時發生錯誤'
      }
    }
  
    if (messages[gon.locale]) {
      $.fn.dropdown.settings.message = messages[gon.locale]
    }
  }());
</script>

<!--[if lt IE 10]>
<script>
    window.location.href = "/incompatible.html";
</script>
<![endif]-->
</head>

<body class='git-project lang-en'>
<header class='common-header fixed noborder' id='git-header-nav'>
<div class='ui container'>
<div class='ui menu header-menu'>
<div class='git-nav-expand-bar'>
<i class='iconfont icon-mode-table'></i>
</div>
<div class='gitee-nav__sidebar'>
<div class='gitee-nav__sidebar-container'>
<div class='gitee-nav__sidebar-top'>
<div class='gitee-nav__avatar-box'></div>
<div class='gitee-nav__buttons-box'>
<a class="ui button small fluid orange" href="/login">Sign in</a>
<a class="ui button small fluid basic is-register" href="/signup">Sign up</a>
</div>
</div>
<div class='gitee-nav__sidebar-middle'>
<div class='gitee-nav__sidebar-list'>
<ul>
<li class='gitee-nav__sidebar-item'>
<a href="/explore"><i class='iconfont icon-ic-discover'></i>
<span class='gitee-nav__sidebar-name'>Explore</span>
</a></li>
<li class='gitee-nav__sidebar-item'>
<a href="/enterprises"><i class='iconfont icon-ic-enterprise'></i>
<span class='gitee-nav__sidebar-name'>Enterprise</span>
</a></li>
<li class='gitee-nav__sidebar-item'>
<a href="/education"><i class='iconfont icon-ic-education'></i>
<span class='gitee-nav__sidebar-name'>Education</span>
</a></li>
<li class='gitee-nav__sidebar-item split-line'></li>
<li class='gitee-nav__sidebar-item'>
<a href="/search"><i class='iconfont icon-ic-search'></i>
<span class='gitee-nav__sidebar-name'>Search</span>
</a></li>
<li class='gitee-nav__sidebar-item'>
<a href="/help"><i class='iconfont icon-help-circle'></i>
<span class='gitee-nav__sidebar-name'>Help</span>
</a></li>
<li class='gitee-nav__sidebar-item'>
<a href="/terms"><i class='iconfont icon-file'></i>
<span class='gitee-nav__sidebar-name'>Terms</span>
</a></li>
<li class='gitee-nav__sidebar-item'>
<a href="/about_us"><i class='iconfont icon-issuepx'></i>
<span class='gitee-nav__sidebar-name'>About us</span>
</a></li>
</ul>
</div>
</div>
<div class='gitee-nav__sidebar-bottom'>
<div class='gitee-nav__sidebar-close-button'>
<i class='fa fa-angle-double-left'></i>
</div>
</div>
</div>
</div>

<div class='item gitosc-logo'>
<a href="/"><img alt='码云 Gitee — 基于 Git 的代码托管和研发协作平台' class='ui inline image' height='28' src='/static/images/logo.svg?t=158106664' title='码云 Gitee — 基于 Git 的代码托管和研发协作平台' width='95'>
<img alt='码云 Gitee — 基于 Git 的代码托管和研发协作平台' class='ui inline black image' height='28' src='/static/images/logo-black.svg?t=158106664' title='码云 Gitee — 基于 Git 的代码托管和研发协作平台' width='95'>
</a></div>
<a class="item " href="/explore" title="Explore">Explore
</a><a class="item " href="/enterprises" title="Enterprise">Enterprise
</a><a class="item " href="/education" title="Education">Education
</a><a class="item" href="https://blog.gitee.com/" id="gitee-blog" target="_blank" title="Blog">Blog
</a><div class='center responsive-logo'>
<a href="/"><img alt='码云 Gitee — 基于 Git 的代码托管和研发协作平台' class='ui inline image' height='24' src='/static/images/logo.svg?t=158106664' title='码云 Gitee — 基于 Git 的代码托管和研发协作平台' width='85'>
<img alt='码云 Gitee — 基于 Git 的代码托管和研发协作平台' class='ui inline black image' height='24' src='/static/images/logo-black.svg?t=158106664' title='码云 Gitee — 基于 Git 的代码托管和研发协作平台' width='85'>
</a></div>
<div class='right menu userbar' id='git-nav-user-bar'>
<form accept-charset="UTF-8" action="/search" class="ui item" data-text-filter="Invalid search content" data-text-require="Search keywords can not be less than one" id="navbar-search-form" method="get"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /></div>
<input id="navbar-search-type" name="type" type="hidden" />
<input id="fork_filter" name="fork_filter" type="hidden" value="on" />
<div class='ui search'>
<input class="prompt" id="navbar-search-input" name="q" placeholder="Search" type="text" value="" />
</div>
</form>

<script>
  var can_search_in_repo = 1,
      repo = "VGtSRmQwNVVRWHBOTWtVelRtcE9iV0UzTmpObWE3NjNm",
      reponame = "xiongrj/springcloud-base";
  
  $(function() {
    var $search = $('#navbar-search-form .ui.search');
    $search.search({
      apiSettings: {
        url: '/search/relative_project?q={query}',
        onResponse: function (res) {
          if (res && res.status === 200 && res.data) {
            var query = $search.search('get value');
  
            res.data.map(function (item) {
              item.path_ns = '/' + item.path_ns;
              item.icon = 'iconfont icon-project-public';
            });
            res.data.unshift({
              name_ns: "在全站搜索 <b class='hl'>" + query +"</b> 相关项目",
              path_ns: '/search?fork_filter=on&q=' + query,
              icon: 'iconfont icon-search'
            });
            if(can_search_in_repo == 1) {
              res.data.unshift({
                name_ns: "在当前仓库搜索 <b class='hl'>" + query +"</b> 相关代码",
                path_ns: '/search?type=code&q=' + query + '&repo=' + repo + '&reponame=' + reponame,
                icon: 'iconfont icon-search'
              });
            }
            return res;
          } else {
            return { data: [] };
          }
        }
      },
      fields: {
        results: 'data',
        description: 'name_ns',
        url: 'path_ns',
        icon: 'icon'
      },
      minCharacters: 1,
      maxResults: 10,
      searchDelay: 120,
      showNoResults: false,
      transition: 'fade'
    });
  });
</script>

<a class="item git-nav-user__login-item" href="/login">Sign in
</a><a class="item git-nav-user__register-item" href="/signup">Sign up
</a><script>
  $('.destroy-user-session').on('click', function() {
    $.cookie('access_token', null, { path: '/' });
  })
</script>

</div>
</div>
</div>
</header>
<script>
  Gitee.initNavbar()
  Gitee.initRepoRemoteWay()
</script>

<!--[if lt IE 10]>
<script>
  window.location.href = "/incompatible.html"
</script>
<![endif]-->

<div class='fixed-notice-infos'>
<div class='all-messages'>
<div class='ui info message' id='git-bulletin'>
<a href=https://www.oschina.net/news/114282/gitee-code-search target='_blank'>代码搜索功能「Gitee Search 」上线  >></a>
<i class='icon remove' id='remove-bulletin'></i>
</div>
</div>
<div class='ui container'>
<div class='flash-messages' id='messages-container'></div>
</div>
<script>
  (function() {
    $(function() {
      var $error_box, alertTip, notify_content, notify_options, template;
      template = '<div data-notify="container" class="ui {0} message" role="alert">' + '<i data-notify="dismiss" class="close icon"></i>' + '<span data-notify="message">{2}</span>' + '</div>';
      notify_content = null;
      notify_options = {};
      alertTip = '';
      $error_box = $(".flash_error.flash_error_box");
      if (notify_options.type === 'error' && $error_box.length > 0 && !$.isEmptyObject(notify_content.message)) {
        if (notify_content.message === 'captcha_fail') {
          alertTip = "The captcha is incorrect";
        } else if (notify_content.message === 'captcha_expired') {
          alertTip = "The captcha was expired, please refresh it";
        } else if (notify_content.message === 'not_found_in_database') {
          alertTip = "Invalid email or password.";
        } else if (notify_content.message === 'not_found_and_show_captcha') {
          alertTip = "Invalid email or password.";
        } else if (notify_content.message === 'phone_captcha_fail') {
          alertTip = "The phone captcha is incorrect";
        } else {
          alertTip = notify_content.message;
        }
        return $error_box.html(alertTip).show();
      } else if (notify_content) {
        if ("show" === 'third_party_binding') {
          return $('#third_party_binding-message').html(notify_content.message).addClass('ui message red');
        }
        notify_options.delay = 3000;
        notify_options.template = template;
        notify_options.offset = {
          x: 10,
          y: 30
        };
        notify_options.element = '#messages-container';
        return $.notify(notify_content, notify_options);
      }
    });
  
  }).call(this);
</script>

</div>
<script>
  (function() {
    $(function() {
      var setCookie;
      setCookie = function(name, value) {
        $.cookie(name, value, {
          path: '/',
          expires: 365
        });
      };
      $('#remove-bulletin, #remove-bulletin-dashboard').on('click', function() {
        setCookie('remove_bulletin', "gitee-maintain-1584931177");
        $('#git-bulletin').hide();
      });
      $('#remove-member-bulletin').on('click', function() {
        setCookie('remove_member_bulletin', "gitee_member_bulletin");
        $(this).parent().hide();
      });
      return $('#remove-gift-bulletin').on('click', function() {
        setCookie('remove_gift_bulletin', "gitee-gift-bulletin");
        $(this).parent().hide();
      });
    });
  
  }).call(this);
</script>
<script>
  function closeMessageBanner(pthis, type, val) {
    var json = {}
  
    val = typeof val === 'undefined' ? null : val
    $(pthis).parent().remove()
    if (type === 'out_of_enterprise_member') {
      json = {type: type, data: val}
    } else if (type === 'enterprise_overdue') {
      json = {type: type, data: val}
    }
    $.post('/profile/close_flash_tip', json)
  }
</script>

<div class='site-content'>
<div class='git-project-header'>
<div class='fixed-notice-infos'>
<div class='ui info icon floating message green' id='fetch-ok' style='display: none'>
<div class='content'>
<div class='header status-title'>
<i class='info icon status-icon'></i>
Fetch the repository succeeded.
</div>
</div>
</div>
<div class='ui info icon floating message error' id='fetch-error' style='display: none'>
<div class='content'>
<div class='header status-title'>
<i class='info icon status-icon'></i>
<span class='error_msg'></span>
</div>
</div>
</div>
</div>
<div class='ui container'>

<div class='git-project-header-details'>
<div class='git-project-header-container'>
<div class='git-project-header-actions'>
<div class='ui tiny modal project-donate-modal' id='project-donate-modal'>
<i class='iconfont icon-close close'></i>
<div class='header'>Donate</div>
<div class='content'>
Please sign in before you donate.
</div>
<div class='actions'>
<a class='ui blank button cancel'>Cancel</a>
<a class='ui orange ok button' href='/login'>Sign in</a>
</div>
</div>
<div class='ui small modal wepay-qrcode'>
<i class='iconfont icon-close close'></i>
<div class='header'>
扫描微信二维码支付
<span class='wepay-cash'></span>
</div>
<div class='content weqcode-center'>
<img id='wepay-qrcode' src=''>
</div>
<div class='actions'>
<div class='ui cancel blank button'>取消</div>
<div class='ui ok orange button'>
支付完成
</div>
</div>
</div>
<div class='ui mini modal' id='confirm-alipay-modal'>
<div class='header'>支付提示</div>
<div class='content'>
将跳转至支付宝完成支付
</div>
<div class='actions'>
<div class='ui approve orange button'>
确定
</div>
<div class='ui blank cancel button'>
取消
</div>
</div>
</div>

<span class='ui basic buttons watch-container'>
<a class="ui button watch" href="/login" title="You must be signed in to watch a repository"><i class='iconfont icon-watch'></i>
Watch
</a><a class="ui button action-social-count" href="/xiongrj/springcloud-base/watchers" title="2">2
</a></span>
<span class='ui basic buttons star-container'>
<a class="ui button star" href="/login" title="You must be signed in to star a repository"><i class='iconfont icon-star'></i>
Star
</a><a class="ui button action-social-count" href="/xiongrj/springcloud-base/stargazers" title="3">3
</a></span>
<span class='ui basic buttons fork-container' title='You do not have the permission to fork this repository'>
<a class="ui button fork" href="/login" title="You must be signed in to fork a repository"><i class='iconfont icon-fork'></i>
Fork
</a><a class="ui button action-social-count disabled-style" href="/xiongrj/springcloud-base/members" title="4">4
</a></span>
</div>
<h2 class='git-project-title'>
<i class="project-icon iconfont icon-project-public" title="This is a public repository"></i> <a class="author" href="/xiongrj" title="Xiongrj">Xiongrj</a> / <a class="repository" href="/xiongrj/springcloud-base" style="padding-bottom: 0px" target="" title="springcloud-base">springcloud-base</a>
<input id="project_title" name="project_title" type="hidden" value="Xiongrj/springcloud-base" />
</h2>
</div>
</div>
</div>
<div class='row' id='import-result-message' style='padding-top: 0px; display: none'>
<div class='sixteen wide column'>
<div class='ui icon yellow message status-color'>
<i class='info icon status-icon' style='width:60px;padding-right:12px;'></i>
<i class='close icon'></i>
<div class='header status-title'>
Sync status
</div>
<span class='status-message'></span>
</div>
</div>
</div>
<script>
  var title_import_url = "false";
  var title_post_url = "/xiongrj/springcloud-base/update_import";
  var title_fork_url = "/xiongrj/springcloud-base/sync_fork";
  var title_project_path = "springcloud-base";
  var title_p_name = "springcloud-base";
  var title_p_id= "4105033";
  var title_description = "尚硅谷周阳的springcloud源码以及笔记整理";
  var title_form_authenticity_token = "BWqzuF1wOfQ58Y5aOdnQaXLDVnll+vlx9d64Bj0pJE8=";
  var watch_type = "unwatch";
  
  $('.metrics-radar').dropdown({ action: 'nothing' });
  $('.js-project-watch').dropdown('set selected', watch_type);
  $('.checkbox.sync-wiki').checkbox();
</script>
<style>
  i.loading {
    -webkit-animation: icon-loading 1.2s linear infinite;
    animation: icon-loading 1.2s linear infinite;
  }
  .qrcode_cs {
    float: left;
  }
  .check-sync-wiki {
    float: left;
    height: 28px;
    line-height: 28px;
  }
  .sync-wiki-warn {
    color: #e28560;
  }
</style>

<div class='git-project-nav'>
<div class='ui container'>
<div class='ui secondary pointing menu'>
<a class="item active" href="/xiongrj/springcloud-base"><i class='iconfont icon-code'></i>
Code
</a><a class="item " href="/xiongrj/springcloud-base/issues"><i class='iconfont icon-issue'></i>
Issues
<span class='ui mini circular label'>
0
</span>
</a><a class="item " href="/xiongrj/springcloud-base/pulls"><i class='iconfont icon-pull-request'></i>
Pull Requests
<span class='ui mini circular label'>
0
</span>
</a><a class="item " href="/xiongrj/springcloud-base/attach_files"><i class='iconfont icon-annex'></i>
Attachments
<span class='ui mini circular label'>0</span>
</a><a class="item " href="/xiongrj/springcloud-base/wikis"><i class='iconfont icon-wiki'></i>
Wiki
<span class='ui mini circular label'>
0
</span>
</a><a class="item  " href="/xiongrj/springcloud-base/graph/master"><i class='iconfont icon-statistics'></i>
Insights
</a><div class='item project-devops-item'>
<div class='ui pointing top right dropdown project-devops-dropdown'>
<div class='text'>
<i class='iconfont icon-devops'></i>
DevOps
</div>
<i class='dropdown icon'></i>
<div class='menu' style='display:none'>
<a class="item" href="https://gitee.com/help/articles/4285" target="_blank"><img alt="Baidu efficiency cloud" src="https://assets.gitee.com/assets/baidu_efficiency_cloud-81a98c2eb67fac83b1453ca3d2feb326.svg" />
<div class='item-title'>
Baidu Efficiency Cloud
</div>
</a><a class="item" href="https://gitee.com/help/articles/4193" target="_blank"><img alt="Jenkins for gitee" src="https://assets.gitee.com/assets/jenkins_for_gitee-554ec65c490d0f1f18de632c48acc4e7.png" />
<div class='item-title'>
Jenkins for Gitee
</div>
</a><a class="item" href="/xiongrj/springcloud-base/paas/huaweicloud_cse"><img alt="Hauweiwfw" src="https://assets.gitee.com/assets/hauweiwfw-6d23ceba77e4f4b8c4498f3f5dc2fd99.png" />
<div class='item-title'>
HuaWei ServiceStage Cloud
</div>
</a><a class="item" href="/xiongrj/springcloud-base/paas/select_platform"><img alt="Mopaas mini" src="https://assets.gitee.com/assets/mopaas_mini-e0279e635080d94a1a1d7a386c86ac5f.png" />
<div class='item-title'>
MoPaaS V3
</div>
</a></div>
</div>
</div>
<div class='item'>
<div class='ui pointing top right dropdown git-project-service'>
<div class='text'>
<i class='iconfont icon-service'></i>
Service
</div>
<i class='dropdown icon'></i>
<div class='menu' style='display:none'>
<a class="item" href="/xiongrj/springcloud-base/pages"><img alt="Logo en" src="/static/images/logo-en.svg" />
<div class='item-title'>
Gitee Pages
</div>
</a><a class="item" href="/xiongrj/springcloud-base/javadoc"><img alt="Maven" src="https://assets.gitee.com/assets/maven-bd58aee84f266d64d4b8ce5b006a9fcf.png" />
<div class='item-title'>
JavaDoc
</div>
</a><a class="item" href="/xiongrj/springcloud-base/phpdoc"><img alt="Phpdoc" src="https://assets.gitee.com/assets/phpdoc-a99f87c2feaa2fd99e5065377a39487e.png" />
<div class='item-title'>
PHPDoc
</div>
</a><a class="item" href="/xiongrj/springcloud-base/quality_analyses?platform=sonar_qube"><img alt="Sonar mini" src="https://assets.gitee.com/assets/sonar_mini-5e1b54bb9f6c951d97fb778ef623afea.png" />
<div class='item-title'>
Quality analysis
</div>
</a><a class="item" href="/xiongrj/springcloud-base/quality_analyses?platform=codesafe"><img alt="Codesafe mini" src="https://assets.gitee.com/assets/codesafe_mini-accbe1e555e9864c552620240d10e4de.png" width="100%" />
<div class='item-title'>
CodeSafe
</div>
</a><button class='ui orange basic button quit-button' id='quiting-button'>
Don’t show this again
</button>
</div>
</div>
</div>
<div class='item right mr-0 pr-0'>

</div>
</div>
</div>
</div>
<script>
  $('.git-project-nav .ui.dropdown').dropdown({ action: 'nothing' });
</script>
<style>
  .git-project-nav i.checkmark.icon {
    color: green;
  }
  #quiting-button {
    display: none;
  }
  
  .git-project-nav .dropdown .menu.hidden:after {
    visibility: hidden !important;
  }
</style>
<script>
  isSignIn = false
  isClickGuide = false
  $('#git-versions.dropdown').dropdown();
  $.ajax({
    url:"/xiongrj/springcloud-base/access/add_access_log",
    type:"GET"
  });
  $('#quiting-button').on('click',function() {
    $('.git-project-service').click();
    if (isSignIn) {
      $.post("/projects/set_service_guide")
    }
    $.cookie("Serve_State", true, { expires: 3650, path: '/'})
    $('#quiting-button').hide();
  });
  if (!(isClickGuide || $.cookie("Serve_State") == 'true')) {
    $('.git-project-service').click()
    $('#quiting-button').show()
  }
</script>

</div>
<div class='ui container'>
<div class='register-guide'>
<div class='register-container'>
<div class='regist'>
Join us
</div>
<div class='description'>
Explore and code with more than 5 million developers，Free private repositories ！：）
</div>
<a class="ui orange button free-registion" href="/signup?from=project-guide">Sign up</a>
<div class='login'>
Already have an account?
<a href="/login?from=project-guide">Sign in</a>
</div>
</div>
</div>

<div class='git-project-content-wrapper'>
<div class='git-project-content' id='git-project-content'>
<div class='row'>
<div class='git-project-desc-wrapper'>
<div class='ui yellow message no-license' id='user-no-license-message'>
This repository doesn't specify license. Without author's permission, this code is only for learning and cannot be used for other purposes.
<i class='help circle icon'></i>
<div class='ui popup dark'>
The license selected for the repository is subject to the license used by the main branch of the repository.
</div>
<i class='remove icon' id='remove-no-license-message'></i>
</div>
<div class='git-project-desc'>
<div class='project-introduce'>
<span class='git-project-desc-text'>
尚硅谷周阳的springcloud源码以及笔记整理
</span>
<a class='hide spread' href='javascript:void(0);'>
spread
<i class='caret down icon'></i>
</a>
<a class='retract hide' href='javascript:void(0);'>
retract
<i class='caret up icon'></i>
</a>
<p class='git-project-homepage'>
</p>
</div>
</div>
<div class='git-project-desc-edit flex'>
<div class='sixty-percent ui small input'>
<input name='project[description]' placeholder='Description' type='text' value='尚硅谷周阳的springcloud源码以及笔记整理'>
</div>
<div class='twenty-percent ui small input'>
<input data-regex-value='(^$)|(^(http|https):\/\/(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5]).*)|(^(http|https):\/\/[a-zA-Z0-9]+([_\-\.]{1}[a-zA-Z0-9]+)*\.[a-zA-Z]{2,10}(:[0-9]{1,10})?(\/.*)?$)' name='project[homepage]' placeholder='Homepage(eg: https://gitee.com)' type='text'>
</div>
<div class='zero-percent'>
<button class='ui orange button btn-save'>
Save
</button>
<button class='ui button btn-cancel-edit'>
Cancel
</button>
</div>
</div>
<script>
  $(function () {
    new ProjectInfoEditor({
      el: '.git-project-desc-wrapper',
      homepage: null,
      description: "尚硅谷周阳的springcloud源码以及笔记整理",
      url: "/xiongrj/springcloud-base/update_description",
      modalHelper: Gitee.modalHelper
    })
  })
  
  if (false) {
    gon.project_new_blob_path = "/xiongrj/springcloud-base/new/master/README.md"
    bindShowModal({
      el: $('.no-license .project-license__create'),
      complete: function(data, modal) {
        if (!data.haveNoChoice && !data.data) {
          Flash.show('Please select an open source license')
        } else {
          location.href = gon.project_new_blob_path + '?license=' + data.data
        }
      },
      skip: function () {
        location.href = gon.project_new_blob_path + '?license'
      }
    })
  }
  
  $('i.help.circle.icon').popup({
    popup: '.no-license .ui.popup',
    position: 'right center'
  })
  
  $('#remove-no-license-message').on('click', function(){
    $.cookie("skip_repo_no_license_message_4105033", 'hide', { expires: 365 })
    $('#user-no-license-message').hide()
    return
  })
</script>
</div>

</div>
<div class='git-project-summary' id='git-project-summary'>
<div class='summary-viewer'>
<div class='viewer-wrapper'>
<ul>
<li>
<a href="/xiongrj/springcloud-base/commits/master"><i class='iconfont icon-commit'></i>
<b>1</b>
commits
</a></li>
<li>
<a href="/xiongrj/springcloud-base/branches"><i class='iconfont icon-branches'></i>
<b>1</b>
branches
</a></li>
<li>
<a href="/xiongrj/springcloud-base/tags"><i class='iconfont icon-tag'></i>
<b>0</b>
tags
</a></li>
<li>
<a href="/xiongrj/springcloud-base/releases"><i class='iconfont icon-release'></i>
<b>0</b>
releases
</a></li>
<li>
<a href="/xiongrj/springcloud-base/contributors?ref=master"><i class='iconfont icon-collaborators'></i>
<b class='contributor-count' data-url='/xiongrj/springcloud-base/contributors_count?ref=master'></b>
<span class='contributor-text'>
Fetching contributors
</span>
</a></li>
</ul>
<ul>
</ul>
</div>
</div>
<div class='summary-languages' title='Click for language details'>
</div>

</div>
<div class='git-project-bread' id='git-project-bread'>
<div class='git-project-right-actions float-right'>
<div class='d-inline-block' id='git-project-tree-actions'>
<script>
  $('.disabled-upload-readonly').popup({
    content: "Readonly directory does not allow uploading files",
    className: {
      popup: 'ui popup',
    },
    position: 'bottom center',
  })
  $('.disabled-create-folder').popup({
    content: "Readonly directory does not allow directory creation",
    className: {
      popup: 'ui popup',
    },
    position: 'bottom center',
  })
  $('.disabled-create-file').popup({
    content: "Readonly directory does not allow files creation",
    className: {
      popup: 'ui popup',
    },
    position: 'bottom center',
  })
  $('.disabled-upload-readonly').click(() => {
    return false
  })
  $('.disabled-create-folder').click(() => {
    return false
  })
  $('.disabled-create-file').click(() => {
    return false
  })
</script>
<style>
  .disabled-upload-readonly, .disabled-create-file, .disabled-create-folder {
    background-color: #dcddde !important;
    color: rgba(0, 0, 0, 0.4) !important;
    opacity: 0.3 !important;
    background-image: none !important;
    -webkit-box-shadow: none !important;
            box-shadow: none !important; }
</style>

</div>
<div class='ui orange button' id='btn-dl-or-clone'>
Clone or download
<i class='dropdown icon'></i>
<div class='git-project-download-panel for-project ui bottom right popup'>
<div class='ui small secondary pointing menu'>
<a class='item active' data-text='' data-type='http' data-url='https://gitee.com/xiongrj/springcloud-base.git'>HTTPS</a>
<a class='item' data-text='' data-type='ssh' data-url='git@gitee.com:xiongrj/springcloud-base.git'>SSH</a>
<a class='item' data-text="The repository has forbidden SVN access. if you need it, please visit to &lt;a target='_blank' href=/xiongrj/springcloud-base/settings&gt;【Repository security settings】&lt;/a&gt;" data-type='svn' data-url=''>SVN</a>
<a class='item' data-text="The repository has forbidden SVN access. if you need it, please visit to &lt;a target='_blank' href=/xiongrj/springcloud-base/settings&gt;【Repository security settings】&lt;/a&gt;" data-type='svn_ssh' data-url=''>SVN+SSH</a>
</div>
<div class='ui fluid right labeled small input download-url-panel'>
<input id="project_clone_url" name="project_clone_url" onclick="focus();select()" readonly="readonly" type="text" value="https://gitee.com/xiongrj/springcloud-base.git" />
<div class='ui basic label'>
<div class='ui small basic orange button' data-clipboard-target='#project_clone_url' id='btn-copy-clone-url'>
Copy
</div>
</div>
</div>
<div class='ui fluid right labeled warning-text forbid-warning-text'>

</div>
<hr>
<a class="ui fluid download link button" href="javascript:void(0);"><i class='icon download'></i>
Download ZIP
</a><div class='download_repository_zip form modal tiny ui' id='unlanding-complaint-modal'>
<i class='iconfont icon-close close'></i>
<div class='header'>
Login prompt
</div>
<div class='container actions'>
<div class='content'>
This operation requires login to the code cloud account. Please log in before operating.
</div>
<div class='ui orange icon large button ok'>
Go to login
</div>
<div class='ui button blank cancel'>
No account. Register
</div>
</div>
</div>
<script>
  var $elm = $('.download');
  
  $elm.on('click', function() {
    var modals = $("#unlanding-complaint-modal.download_repository_zip");
    if (modals.length > 1) {
      modals.eq(0).modal('show');
    } else {
      modals.modal('show');
    }
  })
  $("#unlanding-complaint-modal.download_repository_zip").modal({
    onDeny: function() {
      window.location.href = "/signup?from=download_repository_zip";
    },
    onApprove: function() {
      window.location.href = "/login?from=download_repository_zip";
    }
  })
</script>

<hr>
<div class='ent-poster mt-1 toschina-content__hidden'>
<h2>Gitee Enterprise</h2>
<p>Development and Collaboration Platform for Business</p>
<a class="ui button orange" href="/enterprises?utm_source=g_download" target="_blank">Learn more</a>
</div>
</div>
<script>
  (function() {
    var $btnCopy, $input, $item, $panel, clipboard, dataUrl, remoteWay;
  
    $input = $('#project_clone_url');
  
    remoteWay = '';
  
    clipboard = new Clipboard('#btn-copy-clone-url');
  
    $panel = $('.git-project-download-panel');
  
    $btnCopy = $('#btn-copy-clone-url');
  
    $panel.find('.menu > .item').on('click', function() {
      var $item, dataUrl;
      $item = $(this).addClass('active');
      $item.siblings().removeClass('active');
      dataUrl = $item.attr('data-url');
      if (dataUrl) {
        $panel.find('.download-url-panel').show();
        $input.val(dataUrl);
        $panel.find('.forbid-warning-text').html('');
      } else {
        $panel.find('.download-url-panel').hide();
        $panel.find('.forbid-warning-text').html($item.attr('data-text') || '');
      }
      return $.cookie('remote_way', $item.attr('data-type'), {
        expires: 365,
        path: '/'
      });
    });
  
    $('body').on('click', '#btn-dl-or-clone', function(e) {
      e.stopImmediatePropagation();
      if ($(e.target)[0] === $panel[0] || $(e.target).closest($panel).length) {
        return;
      }
      return $panel.transition('fade up');
    });
  
    $('body').on('click', function() {
      if ($panel.transition('is visible')) {
        return $panel.transition('fade up');
      }
    });
  
    $item = $panel.find('.ui.menu .item').eq(0);
  
    $item.addClass('active').siblings().removeClass('active');
  
    dataUrl = $item.attr('data-url');
  
    if (dataUrl) {
      $panel.find('.download-url-panel').show();
      $input.val(dataUrl);
      $panel.find('.forbid-warning-text').html('');
    } else {
      $panel.find('.download-url-panel').hide();
      $panel.find('.forbid-warning-text').html($item.attr('data-text') || '');
    }
  
    clipboard.on('success', function() {
      $btnCopy.popup({
        content: 'Copied',
        position: 'right center',
        onHidden: function() {
          return $btnCopy.popup('destroy');
        }
      });
      return $btnCopy.popup('show');
    });
  
    clipboard.on('error', function() {
      $btnCopy.popup({
        content: 'Copy failed. Please copy it manually',
        position: 'right center',
        onHidden: function() {
          return $btnCopy.popup('destroy');
        }
      });
      return $btnCopy.popup('show');
    });
  
  }).call(this);
</script>

</div>
</div>
<div class='ui horizontal list'>
<div class='item git-project-branch-item'>
<input id="path" name="path" type="hidden" value="README.md" />
<div class='ui top left pointing dropdown gradient button dropdown-has-tabs' id='git-project-branch'>
<input id="ref" name="ref" type="hidden" value="master" />
<div class='default text'>
master
</div>
<i class='dropdown icon'></i>
<div class='menu'>
<div class='ui left icon search input'>
<i class='iconfont icon-search'></i>
<input placeholder='Search branch' type='text'>
</div>
<div class='tab-menu'>
<div class='tab-menu-action' data-tab='branches'>
<a class="ui link button" href="/xiongrj/springcloud-base/branches">Manage</a>
</div>
<div class='tab-menu-action' data-tab='tags'>
<a class="ui link button" href="/xiongrj/springcloud-base/tags">Manage</a>
</div>
<div class='tab-menu-item' data-placeholder='Search branches' data-tab='branches'>
Branches (1)
</div>
</div>
<div class='tab scrolling menu' data-tab='branches'>
<div class='item' data-value='master'>master</div>
</div>
</div>
</div>

<script>
  $(function () {
    Gitee.initTabsInDropdown($('#git-project-branch').dropdown({
      fullTextSearch: true,
      onChange: function (value, text) {
        var path = $('#path').val();
        var href = ['/xiongrj/springcloud-base/tree', encodeURIComponent(value), path].join('/');
        window.location.href = href;
      }
    }));
  })
</script>

</div>
<div class='item' id='git-project-root-actions'>
<div class='repo-index repo-none-index' style='margin-left:0px;'>
<div class='ui horizontal list repo-action-list'>
<div class='item'>
<div class='ui pointing right top dropdown gradient button' id='git-project-file'>
<div class='text'>File</div>
<i class='dropdown icon'></i>
<div class='menu'>
<div class='disabled item'>New file</div>
<div class='disabled item'>Upload file</div>
<a class='item repo-action' id='search-files'>
Search
</a>
</div>
</div>
</div>
<div class='item toschina-content__hidden'>
<a class="ui gradient button webide" href="/-/ide/project/xiongrj/springcloud-base/edit/master" target="_blank">Web IDE</a>
</div>
<div class='item toschina-content__hidden'>
<a class="ui gradient button repo-action" href="/xiongrj/springcloud-base/widget"><i class='iconfont icon-widget icon-orange'></i>
Widget
</a></div>
</div>
<script>
  $('#git-project-file').dropdown({ action: 'hide' });
</script>
</div>

</div>
<div class='item breadcrumb_path path-breadcrumb-contrainer' id='git-project-breadcrumb'>
<div class='ui breadcrumb path project-path-breadcrumb' id='path-breadcrumb'>
<a class="section repo-name" data-direction="back" href="/xiongrj/springcloud-base/tree/master" style="font-weight: bold">springcloud-base
</a><div class='divider'>
/
</div>
<strong>
README.md
</strong>
</div>


</div>
</div>
</div>

<style>
  .ui.dropdown .menu > .header {
    text-transform: none; }
</style>
<script>
  $(document).ready(function () {
    var $gitProjectSummary = $('#git-project-summary');
    var $gitProjectLanguages = $gitProjectSummary.find('.summary-languages');
    var $statsSwitcherWrapper = $gitProjectSummary.find('.viewer-wrapper');
    var $contributorCount = $gitProjectSummary.find('.contributor-count');
    var $contributorText = $gitProjectSummary.find('.contributor-text');
    var contributorsCountUrl = $contributorCount.data('url');
  
    $gitProjectLanguages.on('click', function() {
      $statsSwitcherWrapper.toggleClass('js-lang');
    });
  
    $.ajax({
      url: contributorsCountUrl,
      method: 'GET',
      success: function(data) {
        if (data.status === 1) {
          $contributorCount.text(data.contributors_count);
          $contributorText.text('contributors')
        } else {
          $contributorText.text('Fetching failed')
        }
      }
    });
    var $tip = $('#apk-download-tip');
    if (!$tip.length) {
      return;
    }
    $tip.find('.btn-close').on('click', function () {
      $tip.slideUp();
    });
  });
  (function(){
    function pathAutoRender() {
      var $parent = $('#git-project-bread'),
          $child = $('#git-project-bread').children('.ui.horizontal.list'),
          mainWidth = 0;
      $child.each(function (i,item) {
        mainWidth += $(item).width()
        });
      $('.breadcrumb.path.fork-path').remove();
      if (mainWidth > 995) {
        $('#path-breadcrumb').hide();
        $parent.append('<div class="ui breadcrumb path fork-path">' + $('#path-breadcrumb').html() + '<div/>')
      } else {
        $('#path-breadcrumb').show();
      }
    }
    window.pathAutoRender = pathAutoRender;
    pathAutoRender();
  })();
</script>

<div class='row column tree-holder' id='tree-holder'>

<div class='tree-content-holder' id='tree-content-holder'>
<div class='file_holder'>
<div class='file_title'>
<div class='blob-header-title'>
<div class='blob-description'>
<i class='iconfont icon-readme'></i>
<span class='file_name' title='README.md'>
README.md
</span>
<small>59.40 KB</small>
</div>
<div class='options'><div class='ui mini buttons basic'>
<textarea id="blob_raw" name="blob_raw" style="display:none;">
# SpringCloud&#x000A;&#x000A;## 微服务概述&#x000A;&#x000A;[马丁福勒微服务论文]: https://martinfowler.com/articles/microservices.html&#x000A;&#x000A;### 什么是微服务&#x000A;&#x000A;- 目前的微服务并没有一个统一的标准，一般是以业务来划分&#x000A;- 将传统的一站式应用，拆分成一个个的服务，彻底去耦合，一个微服务就是单功能业务，只做一件事。&#x000A;- 与微服务相对的叫巨石&#x000A;&#x000A;&#x000A;### 微服务与微服务架构&#x000A;&#x000A;- 微服务是一种架构模式或者一种架构风格，提倡将单一应用程序划分成一组小的服务==独立部署==，服务之间相互配合、相互协调，每个服务运行于自己的==进程==中。&#x000A;- 服务与服务间采用轻量级通讯，如HTTP的RESTful API等&#x000A;- 避免统一的、集中式的服务管理机制&#x000A;&#x000A;### 微服务的优缺点&#x000A;&#x000A;#### 优点&#x000A;&#x000A;1. 每个服务足够内聚，足够小，比较容易聚焦&#x000A;2. 开发简单且效率高，一个服务只做一件事情&#x000A;3. 开发团队小，一般2-5人足以（当然按实际为准）&#x000A;4. 微服务是松耦合的，无论开发还是部署都可以独立完成&#x000A;5. 微服务能用不同的语言开发&#x000A;6. 易于和第三方集成，微服务允许容易且灵活的自动集成部署（持续集成工具有Jenkins,Hudson,bamboo等）&#x000A;7. 微服务易于被开发人员理解，修改和维护，这样可以使小团队更加关注自己的工作成果，而无需一定要通过合作才能体现价值&#x000A;8. 微服务允许你融合最新的技术&#x000A;9. ==微服务只是业务逻辑的代码，不会和HTML,CSS或其他界面组件融合==。&#x000A;10. ==每个微服务都可以有自己的存储能力，数据库可自有也可以统一，十分灵活==。&#x000A;&#x000A;#### 缺点&#x000A;&#x000A;1. 开发人员要处理分布式系统的复杂性&#x000A;2. 多服务运维难度，随着服务的增加，运维的压力也会增大&#x000A;3. 依赖系统部署&#x000A;4. 服务间通讯的成本&#x000A;5. 数据的一致性&#x000A;6. 系统集成测试&#x000A;7. 性能监控的难度&#x000A;&#x000A;### 微服务的技术栈&#x000A;&#x000A;|        微服务条目         |                   落地技术                   |&#x000A;| :------------------: | :--------------------------------------: |&#x000A;|         服务开发         |       SpringBoot,Spring,SpringMVC        |&#x000A;|       服务配置与管理        |      Netflix公司的Archaius、阿里的Diamond等      |&#x000A;|       服务注册与发现        |         Eureka、Consul、Zookeeper等         |&#x000A;|         服务调用         |              Rest、RPC、gRPC               |&#x000A;|        服务熔断器         |              Hystrix、Envoy等              |&#x000A;|         负载均衡         |              Ribbon、Nginx等               |&#x000A;| 服务接口调用（客户端调用服务的简化工具） |                  Feign等                  |&#x000A;|         消息队列         |         Kafka、RabbitMQ、ActiveMQ等         |&#x000A;|       服务配置中心管理       |         SpringCloudConfig、Chef等          |&#x000A;|     服务路由（API网关）      |                  Zuul等                   |&#x000A;|         服务监控         |    Zabbix、Nagios、Metrics、Specatator等     |&#x000A;|        全链路追踪         |           Zipkin、Brave、Dapper等           |&#x000A;|         服务部署         |       Docker、OpenStack、Kubernetes等       |&#x000A;|       数据流操作开发包       | SpringCloud Stream(封装与Redis，Rabbit，Kafka等发送接收消息) |&#x000A;|        事件消息总线        |             SpringCloud Bus              |&#x000A;&#x000A;### 为什么选SpringCloud作为微服务架构&#x000A;&#x000A;#### 选型依据&#x000A;&#x000A;1. 整体解决方案和框架的成熟度&#x000A;2. 社区热度&#x000A;3. 可维护性&#x000A;4. 学习曲线&#x000A;&#x000A;#### 当前各大IT公司的微服务架构&#x000A;&#x000A;1. 阿里Dubbo/HSF&#x000A;2. 京东JSF&#x000A;3. 新浪Motan&#x000A;4. 当当DubboX&#x000A;&#x000A;#### 各微服务的框架对比&#x000A;&#x000A;| 功能点/服务框架 |           Netflix/SpringCloud            |                Motan                 |        gRPC        |  Thrift  | Dubbo/DubboX |&#x000A;| :------: | :--------------------------------------: | :----------------------------------: | :----------------: | :------: | :----------: |&#x000A;|   功能定位   |                 完整的微服务架构                 | RPC框架，但整合了ZK或Consul，实现集群环境的基本服务注册/发现 |       RPC框架        |  RPC框架   |     服务框架     |&#x000A;|  支持Rest  |          是，Ribbon支持多种可插拔的序列化选择           |                  否                   |         否          |    否     |      否       |&#x000A;|  支持RPC   |                    否                     |                  是                   |         是          |    是     |      是       |&#x000A;|  支持多语言   |                是（Rest形式）                 |                  否                   |         是          |    是     |      否       |&#x000A;| 服务注册/发现  | 是（Eureka） Eureka服务注册表，Karyon服务端框架支持服务自注册和健康检查 |         是（zookeeper/consul）          |         否          |    否     |      是       |&#x000A;|   负载均衡   | 是（服务端zuul+客户端Ribbon） zuul-服务，动态路由 云端负载均衡  Eureka（针对中间层服务器） |                是（客户端）                |         否          |    否     |    是（客户端）    |&#x000A;|   配置服务   | Netflix Archaius SpringCloud Config Server集中配置 |            是（zookeeper提供）            |         否          |    否     |      否       |&#x000A;| 服务调用链监控  |         是（zuul） Zuul提供边缘服务，API网关         |                  否                   |         否          |    否     |      否       |&#x000A;|  高可用/容错  |         是（服务端Hystrix+客户端Ribbon）          |                是（客户端）                |         否          |    否     |    是（客户端）    |&#x000A;|  典型应用案例  |                 Netflix                  |                 Sina                 |       Google       | Facebook |              |&#x000A;|  社区活跃度   |                    高                     |                  一般                  |         高          |    一般    |  2017年7月才重启  |&#x000A;|   学习难度   |                    中等                    |                  一般                  |         高          |    一般    |      低       |&#x000A;|  文档丰富度   |                    高                     |                  一般                  |         一般         |    一般    |      高       |&#x000A;|    其他    |     Spring Cloud Bus为我们应用程序带来了更多管理端点     |                 支持降级                 | Netflix内部在开发集成gRPC |  IDL定义   |   实践公司比较多    |&#x000A;&#x000A;## SpringCloud入门概述&#x000A;&#x000A;- Spring的三大模块：SpringBoot（构建），Spring Cloud（协调），Spring Cloud Data Flow（连接）&#x000A;&#x000A;### SpringCloud是什么&#x000A;&#x000A;- 分布式系统的简化版（官方介绍）&#x000A;- SpringCloud基于SpringBoot提供了一整套微服务的解决方案，包括服务注册与发现，配置中心，全链路监控，服务网关，负载均衡，熔断器等组件，除了基于Netflix的开源组件做高度抽象封装之外，还有一些选型中立的开源组件&#x000A;- SpringCloud利用SpringBoot的开发便利性巧妙地简化了分布式系统的基础设施开发，SpringCloud为开发人员提供了快速构建分布式系统的一些工具，包括配置管理、服务发现、断路器、路由、微代理、事件总线，全局所、决策精选、分布式会话等等，他们都可以用SpringBoot的开发风格做到一键启动和部署。&#x000A;- ==一句话概括：SpringCloud是分布式微服务架构下的一站式解决方案，是各个微服务架构落地技术的几何体，俗称微服务全家桶==&#x000A;&#x000A;### SpringCloud和SpringBoot的关系&#x000A;&#x000A;SpringBoot：专注于快速方便的开发单个个体微服务（关注微观）&#x000A;&#x000A;SpringCloud：关注全局的微服务协调治理框架，将SpringBoot开发的一个个单体微服务组合并管理起来（关注宏观）&#x000A;&#x000A;- ==SpringBoot可以离开SpringCloud独立使用，但是SpringCloud不可以离开SpringBoot，属于依赖关系==&#x000A;&#x000A;### Dubbo是怎么到SpringCloud的？哪些优缺点去技术选型&#x000A;&#x000A;#### 目前成熟都互联网架构（分布式+服务治理Dubbo）&#x000A;&#x000A;![目前成熟都互联网架构（分布式+服务治理Dubbo）](images\目前成熟的互联网架构.png)&#x000A;&#x000A;#### 对比&#x000A;&#x000A;|        |     Dubbo     |            Spring            |&#x000A;| ------ | :-----------: | :--------------------------: |&#x000A;| 服务注册中心 |   Zookeeper   | Spring Cloud Netfilx Eureka  |&#x000A;| 服务调用方式 |      RPC      |           REST API           |&#x000A;| 服务监控   | Dubbo-monitor |      Spring Boot Admin       |&#x000A;| 断路器    |      不完善      | Spring Cloud Netflix Hystrix |&#x000A;| 服务网关   |       无       |  Spring Cloud Netflix Zuul   |&#x000A;| 分布式配置  |       无       |     Spring Cloud Config      |&#x000A;| 服务跟踪   |       无       |     Spring Cloud Sleuth      |&#x000A;| 消息总线   |       无       |       Spring Cloud Bus       |&#x000A;| 数据流    |       无       |     Spring Cloud Stream      |&#x000A;| 批量任务   |       无       |      Spring Cloud Task       |&#x000A;&#x000A;**最大区别：**&#x000A;&#x000A;- Spring Cloud抛弃了RPC通讯，采用基于HTTP的REST方式。Spring Cloud牺牲了服务调用的性能，但是同时也避免了原生RPC带来的问题。REST比RPC更为灵活，不存在代码级别的强依赖，在强调快速演化的微服务环境下，显然更合适。&#x000A;- ==一句话：Dubbo像组装机，Spring Cloud像一体机==&#x000A;- 社区的支持与力度：Dubbo曾经停运了5年，虽然重启了，但是对于技术发展的新需求，还是需要开发者自行去拓展，对于中小型公司，显然显得比较费时费力，也不一定有强大的实力去修改源码&#x000A;&#x000A;####总结&#x000A;&#x000A;1. 解决的问题域不一样：Dubbo的定位是一款RPC框架，Spring Cloud的目标是微服务架构下的一站式解决方案&#x000A;&#x000A;### SpringCloud的参考资料&#x000A;&#x000A;[SpringCloud的中文参考资料]: https://springcloud.cc/spring-cloud-netflix.html&#x000A;[SpringCloud的中文API]: https://springcloud.cc/spring-cloud-dalston.html&#x000A;[SpringCloud中国社区]: http://springcloud.cn/&#x000A;[SpringCloud中文网]: https://springcloud.cc/&#x000A;&#x000A;## 构建SpringCloud工程&#x000A;概述：SpringCloud工程由一个父工程和若干个Module组成&#x000A;&#x000A;==应该遵循的条件：约定 &gt; 配置 &gt; 编码==&#x000A;### RestTemplate类&#x000A;#### 介绍&#x000A;RestTemplate是Spring提供的用于访问Rest服务的客户端模板工具集，提供了多种远程访问Http的方法&#x000A;&#x000A;[RestTemplate的API]: https://docs.spring.io/spring/docs/5.0.6.RELEASE/javadoc-api/&#x000A;&#x000A;&#x000A;#### 意义&#x000A;在一些不涉及实现方法的模块中（消费者），只需要调用其他服务暴露出的接口即可满足的需求，使用RestTemplate类中的方法可以发出需要的HTTP请求并得到返回结果。（类似Ajax）&#x000A;#### RestTemplate用法&#x000A;```java&#x000A;RestTemplate restTemplate = new RestTemplate();&#x000A;//url:请求地址&#x000A;//requestMap:请求参数&#x000A;//type.class:HTTP响应转换成的对象类型&#x000A;restTemplate.getForObject(url,type.class);&#x000A;restTemplate.postForObject(url,requestMap,type.class);&#x000A;```&#x000A;### 构建父工程&#x000A;- 创建一个Maven父工程并命名GAV&#x000A;- 打包方式为==POM==&#x000A;- 在pom.xml中定义各依赖的版本号（若Module中pom.xml的依赖没有指定版本号，则会根据父工程的版本号加入依赖）&#x000A;- 加入通用的依赖和插件&#x000A;&#x000A;### 构建Module&#x000A;- 在父工程下新建Maven的Module，打包方式为jar&#x000A;- 一般来时GAV中 GV随父工程，自己定义A即可&#x000A;- 在该Module下pom.xml中加入其它需要的依赖&#x000A;- 正常开发即可&#x000A;- 完成后先clean一下Maven项目，然后再install提供给其它模块调用&#x000A;&#x000A;#### 添加其它Module的依赖方法&#x000A;- 直接引用其GAV即可&#x000A;```xml&#x000A;    &lt;dependencies&gt;&#x000A;        &lt;dependency&gt;&#x000A;            &lt;groupId&gt;com.lzl&lt;/groupId&gt;&#x000A;            &lt;artifactId&gt;microservice-api&lt;/artifactId&gt;&#x000A;            &lt;version&gt;${project.version}&lt;/version&gt;&#x000A;        &lt;/dependency&gt;&#x000A;    &lt;/dependencies&gt;&#x000A;```&#x000A;#### 配置该module下的yml&#x000A;- 微服务需要独立的端口&#x000A;- ==微服务最重要的是取名字！！！！一定要给微服务配置一个名字！这个名字就是这个微服务对外暴露的名字！==&#x000A;- 配置该模块下的其它相关配置（如本例配置了mybatis）&#x000A;```yml&#x000A;server:&#x000A;  port: 8001&#x000A;&#x000A;mybatis:&#x000A;  config-location: classpath:mybatis/mybatis.cfg.xml&#x000A;  type-aliases-package: com.XXX.entity&#x000A;  mapper-locations:&#x000A;  - classpath:mybatis/mapper/**/*.xml&#x000A;spring:&#x000A;  application:&#x000A;    name: microservicecloud-dept   #为这个服务取名，非常重要！！！！！&#x000A;  datasource:&#x000A;    type: com.alibaba.druid.pool.DruidDataSource&#x000A;    driver-class-name: org.gjt.mm.mysql.Driver&#x000A;    url: jdbc:mysql://localhost:3306/cloudDB01&#x000A;    username: root&#x000A;    password: 123456&#x000A;    dbcp2:&#x000A;      min-idle: 5         #最小连接数&#x000A;      initial-size: 5    #初始化连接数&#x000A;      max-total: 10      #最大连接数&#x000A;      max-wait-millis: 200    #等待连接最长的超时时间&#x000A;&#x000A;```&#x000A;#### 编写主启动类&#x000A;- 记得主启动类放在根包下,com.xxx.xxx&#x000A;```java&#x000A;package com.XXX;&#x000A;&#x000A;import org.springframework.boot.SpringApplication;&#x000A;import org.springframework.boot.autoconfigure.SpringBootApplication;&#x000A;&#x000A;@SpringBootApplication&#x000A;public class Provider8001_APP {&#x000A;    public static void main(String[] args) {&#x000A;        SpringApplication.run(Provider8001_APP.class,args);&#x000A;    }&#x000A;}&#x000A;```&#x000A;## SpringCloud添加组件的基本套路&#x000A;&#x000A;1. 新增这个组件的maven坐标GAV&#x000A;2. 在启动类上面标注启动该组件（一般来说是@EnableXXXXX）&#x000A;3. 编写业务逻辑代码&#x000A;&#x000A;## Eureka服务注册与发现&#x000A;&#x000A;### Eureka介绍及原理&#x000A;&#x000A;#### 理解&#x000A;&#x000A;==Eureka就像一个物业管理公司，其他微服务就像小区的住户，每个住户入住时都要向物业管理公司注册，并定时向物业公司交管理费==&#x000A;&#x000A;#### 介绍&#x000A;- Eureka是一个基于REST的服务，用于定位服务，以实现云端中间层服务发现和故障转移。&#x000A;- Eureka主管服务注册与发现，在微服务中，以后了这两者，只需要使用服务的标识符（==就是那个在每个服务的yml文件中取得服务名称==），就可以访问到服务，不需要修改服务调用的配置文件&#x000A;- Eureka遵循AP原则（高可用，分区容错性），因为使用了自我保护机制所以保证了高可用&#x000A;&#x000A;#### 原理&#x000A;&#x000A;- Eureka使用的是C-S结构（客户端-服务端）&#x000A;- 两大组件：Eureka Server（提供注册服务）、 Eureka Client（JAVA客户端，负责发送心跳）&#x000A;- 系统中的其他微服务使用Eureka客户端连接到Eureka服务端维持心跳连接（即注册）。SpringCloud的其他模块可以通过Eureka Server 来发现系统中的微服务并加以调用&#x000A;&#x000A;![Eureka的架构图](images\Eureka的架构图.png)&#x000A;&#x000A;### Eureka服务注册中心构建&#x000A;&#x000A;#### 加入服务端依赖&#x000A;&#x000A;```xml&#x000A;&lt;dependency&gt;&#x000A;            &lt;groupId&gt;org.springframework.cloud&lt;/groupId&gt;&#x000A;            &lt;artifactId&gt;spring-cloud-starter-eureka-server&lt;/artifactId&gt;&#x000A;        &lt;/dependency&gt;&#x000A;```&#x000A;&#x000A;#### 配置yml&#x000A;&#x000A;- ==理解：物业公司肯定不向自己注册自己，并肯定知道自己在哪，不用参加检索==&#x000A;&#x000A;```yml&#x000A;server:&#x000A;  port: 7001&#x000A;eureka:&#x000A;  instance:&#x000A;    hostname: localhost&#x000A;  client:&#x000A;    register-with-eureka: false     #false表示不向注册中心注册自己&#x000A;    fetch-registry: false           #false表示自己就是注册中心，职责是维护实例，不参加检索&#x000A;    service-url:&#x000A;      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/    #设置eureka server的交互地址，即对外暴露的地址&#x000A;```&#x000A;&#x000A;#### 添加启动类&#x000A;&#x000A;- ==注意：要在类前加@EnableEurekaServer标注==&#x000A;&#x000A;```java&#x000A;package com.XXX;&#x000A;&#x000A;import org.springframework.boot.SpringApplication;&#x000A;import org.springframework.boot.autoconfigure.SpringBootApplication;&#x000A;import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;&#x000A;&#x000A;@SpringBootApplication&#x000A;@EnableEurekaServer&#x000A;public class Eureka7001_APP {&#x000A;    public static void main(String[] args) {&#x000A;        SpringApplication.run(Eureka7001_APP.class,args);&#x000A;    }&#x000A;}&#x000A;```&#x000A;&#x000A;#### 验证是否构建成功&#x000A;&#x000A;启动主程序，访问该服务地址即可&#x000A;&#x000A;### 向Eureka注册中心注册微服务&#x000A;&#x000A;#### 增加依赖&#x000A;&#x000A;在要注册的微服务的pom.xml文件中增加依赖&#x000A;&#x000A;```xml&#x000A;		&lt;dependency&gt;&#x000A;            &lt;groupId&gt;org.springframework.cloud&lt;/groupId&gt;&#x000A;            &lt;artifactId&gt;spring-cloud-starter-eureka&lt;/artifactId&gt;&#x000A;        &lt;/dependency&gt;&#x000A;        &lt;dependency&gt;&#x000A;            &lt;groupId&gt;org.springframework.cloud&lt;/groupId&gt;&#x000A;            &lt;artifactId&gt;spring-cloud-starter-config&lt;/artifactId&gt;&#x000A;        &lt;/dependency&gt;	&#x000A;```&#x000A;&#x000A;#### 修改yml&#x000A;&#x000A;- 在application.yml中增加以内容，将客户端注册到服务列表内&#x000A;- ==理解：小区用户要找到物业管理处的地址进行注册==&#x000A;&#x000A;```yml&#x000A;eureka:&#x000A;  client:&#x000A;    service-url:&#x000A;      defaultZone: http://localhost:7001/eureka&#x000A;```&#x000A;&#x000A;#### 主启动类增加注解&#x000A;&#x000A;- 增加@EnableEurekaClient注解&#x000A;&#x000A;```java&#x000A;@SpringBootApplication&#x000A;@EnableEurekaClient&#x000A;public class Provider8001_APP {&#x000A;    public static void main(String[] args) {&#x000A;        SpringApplication.run(Provider8001_APP.class,args);&#x000A;    }&#x000A;}&#x000A;```&#x000A;&#x000A;### actuator与微服务注册完善&#x000A;&#x000A;#### 主机名称与服务名称的修改&#x000A;&#x000A;- 修改服务名称，在yml中eureka节点下添加如下内容&#x000A;&#x000A;```yml&#x000A; eureka:&#x000A;  instance:&#x000A;    instance-id: dept8001		#修改别名&#x000A;    prefer-ip-address: true		#显示IP地址&#x000A;```&#x000A;&#x000A;#### info内容的详细信息修改&#x000A;&#x000A;##### 作用&#x000A;&#x000A;在查看Eureka时点击进入某个微服务的info时，能给查看者一些必要的信息，可以帮助查看者快速的了解该微服务，开发中十分有意义。&#x000A;&#x000A;##### 修改方法&#x000A;&#x000A;1. ==当前工程==添加依赖&#x000A;&#x000A;```xml&#x000A;        &lt;dependency&gt;&#x000A;            &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;&#x000A;            &lt;artifactId&gt;spring-boot-starter-actuator&lt;/artifactId&gt;&#x000A;        &lt;/dependency&gt;&#x000A;```&#x000A;&#x000A;2. ==总的父工程==的build节点下添加如下内容&#x000A;&#x000A;```xml&#x000A;&lt;build&gt;&#x000A;        &lt;finalName&gt;microservicecloud&lt;/finalName&gt;&#x000A;        &lt;resources&gt;&#x000A;            &lt;resource&gt;&#x000A;             	&lt;!--允许扫描该路径下的资源文件--&gt;&#x000A;                &lt;directory&gt;src/main/resources&lt;/directory&gt;&#x000A;                &lt;filtering&gt;true&lt;/filtering&gt;&#x000A;            &lt;/resource&gt;&#x000A;        &lt;/resources&gt;&#x000A;        &lt;plugins&gt;&#x000A;            &lt;plugin&gt;&#x000A;                &lt;groupId&gt;org.apache.maven.plugins&lt;/groupId&gt;&#x000A;                &lt;artifactId&gt;maven-resources-plugin&lt;/artifactId&gt;&#x000A;                &lt;configuration&gt;&#x000A;                    &lt;delimiters&gt;&#x000A;                     	&lt;!--指定动态获取以$标志开头结尾的信息--&gt;&#x000A;                        &lt;delimit&gt;$&lt;/delimit&gt;&#x000A;                    &lt;/delimiters&gt;&#x000A;                &lt;/configuration&gt;&#x000A;            &lt;/plugin&gt;&#x000A;        &lt;/plugins&gt;&#x000A;    &lt;/build&gt;&#x000A;```&#x000A;&#x000A;3. 在==当前工程== 的application.yml文件添加回显信息&#x000A;&#x000A;```yml&#x000A;info:&#x000A;  author: XXX&#x000A;  build-version: $project.version$&#x000A;```&#x000A;&#x000A;&#x000A;&#x000A;### Eureka的自我保护&#x000A;&#x000A;#### 介绍&#x000A;&#x000A;Eureka的自我保护机制主要是为了网络异常时保持高可用设计的，当在Eureka中注册的微服务超过设定是时间内（默认90秒）没有向Eureka服务端发送心跳，该微服务会进入自我保护模式。在自我保护模式中，Eureka会保护服务注册表中的信息，不会注销任何服务实例，直至收到的心跳数恢复至阈值以上，该微服务退出自我保护模式。&#x000A;&#x000A;#### 理解&#x000A;&#x000A;好死不如赖活：Eureka的设计哲学是宁可保留错误的服务信息，也不盲目注销可能健康的服务。所以异常的服务不会被注销，而是进入了自我保护模式。&#x000A;&#x000A;#### 自我保护模式的开关&#x000A;&#x000A;在Eureka Server模块下的yml文件中添加配置信息即可，true表示打开自我保护模式；false表示关闭自我保护模式（不推荐）&#x000A;&#x000A;```java&#x000A;  server:&#x000A;    enable-self-preservation: false&#x000A;```&#x000A;&#x000A;### Eureka的服务发现&#x000A;&#x000A;#### 介绍&#x000A;&#x000A;系统中的微服务可以通过Eureka的服务发现去获得在Eureka中注册的服务的信息，这是一个对外暴露的接口。&#x000A;&#x000A;#### 使用方法（provider中）&#x000A;&#x000A;1. 注入DiscoveryClient 对象（spring包下的），在controller方法中获取&#x000A;&#x000A;```java&#x000A;@Autowired&#x000A;private DiscoveryClient discoveryClient;    &#x000A;&#x000A;@ResponseBody&#x000A;@GetMapping(&quot;/provider/discovery&quot;)&#x000A;public Object discovery(){&#x000A;        List&lt;String&gt; list = discoveryClient.getServices();&#x000A;        System.out.println(list);&#x000A;        List&lt;ServiceInstance&gt; insList = discoveryClient.getInstances(&quot;MICROSERVICECLOUD-DEPT&quot;);&#x000A;        for (ServiceInstance si:insList) {&#x000A;            System.out.println(si.getHost() +&quot;,&quot; + si.getServiceId() +&quot;,&quot; +si.getPort() +&quot;,&quot; +si.getUri() +&quot;,&quot; +si.getMetadata());&#x000A;        }&#x000A;        return this.discoveryClient;&#x000A;    }&#x000A;```&#x000A;&#x000A;2. 在主启动类中加入@EnableDiscoveryClient注解&#x000A;&#x000A;```java&#x000A;@SpringBootApplication&#x000A;@EnableEurekaClient&#x000A;@EnableDiscoveryClient&#x000A;public class Provider8001_APP {&#x000A;    public static void main(String[] args) {&#x000A;        SpringApplication.run(Provider8001_APP.class,args);&#x000A;    }&#x000A;}&#x000A;```&#x000A;&#x000A;#### 使用方法（consumer中）&#x000A;&#x000A;在controller方法中使用restTemplate对象调用provider中暴露的URL 并获得返回对象即可&#x000A;&#x000A;```java&#x000A;@GetMapping(&quot;/discovery&quot;)&#x000A;public Object discovery() {&#x000A;        return restTemplate.getForObject(URL_PREFIX+&quot;/provider/discovery&quot;,Object.class);&#x000A;    }&#x000A;```&#x000A;&#x000A;### Eureka的集群配置&#x000A;&#x000A;#### 集群&#x000A;&#x000A;集群就是在不同的机器上配置相同的服务来构建要一个大的运算整体&#x000A;&#x000A;#### 实现集群&#x000A;&#x000A;1. 新建N个Eureka Server模块&#x000A;2. 每个模块的pom.xml中加入与单个Eureka Server相同的依赖&#x000A;3. 每个模块加入主程序（记得加@EnableEurekaServer注解）&#x000A;4. 修改hosts文件（Win7的路径是C:\Windows\System32\drivers\etc）&#x000A;&#x000A;```shell&#x000A;127.0.0.1 eureka7001.com&#x000A;127.0.0.1 eureka7002.com&#x000A;127.0.0.1 eureka7003.com&#x000A;```&#x000A;&#x000A;5. 修改Eureka Server模块的application.yml文件，加入集群，主要修改两个地方：&#x000A;&#x000A;- hostname：修改为hosts文件中映射的地址&#x000A;- service-url下的defaultZone节点：填入集群中另外的server服务端的地址&#x000A;&#x000A;```yml&#x000A;server:&#x000A;  port: 7001&#x000A;eureka:&#x000A;  instance:&#x000A;    hostname: eureka7001.com    #hostname为hosts文件中映射的地址&#x000A;  client:&#x000A;    register-with-eureka: false     #false表示不向注册中心注册自己&#x000A;    fetch-registry: false           #false表示自己就是注册中心，职责是维护实例，不参加检索&#x000A;    service-url:&#x000A;      #defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/    #设置eureka server的交互地址&#x000A;      defaultZone: http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/  #其他两个服务端的地址&#x000A;```&#x000A;&#x000A;6. 修改Eureka Client模块的application.yml文件，使其向集群注册服务&#x000A;&#x000A;- service-url下的defaultZone节点：填入集群中需要向其注册server服务端的地址&#x000A;&#x000A;```yml&#x000A;eureka:&#x000A;  client:&#x000A;    service-url:&#x000A;      defaultZone: http://eureka7001.com:7001/eureka,http://eureka7002.com:7002/eureka,http://eureka7003.com:7003/eureka&#x000A;```&#x000A;&#x000A;7. 访问地址&#x000A;&#x000A;``` shell&#x000A;http://eureka7001.com:7001&#x000A;http://eureka7002.com:7002&#x000A;http://eureka7003.com:7003&#x000A;```&#x000A;&#x000A;8.  ==注：defaultZone中eureka/后缀是必须的，如果删除，Server类不会报错，但是Client注册时会报404错误==&#x000A;&#x000A;### Eureka与Zookeeper对比&#x000A;&#x000A;#### CAP设计原则不同&#x000A;&#x000A;Eureka遵守AP，Zookeeper遵守CP（C：强一致性，A：高可用，P：分区容错性，三者只能选其二，高并发下P必选）&#x000A;&#x000A;#### 网络波动下两者的处理对比&#x000A;&#x000A;| Zookeeper                                | Eureka                                   |&#x000A;| :--------------------------------------- | ---------------------------------------- |&#x000A;| 当网络出现故障时，剩余zk集群会发起投票选举新的leader，但是此过程会持续30~120s，此过程对于高并发来说十分漫长，会导致整个注册服务的瘫痪，这是不可容忍的 | 在15分钟内85%的节点都没有心跳，则注册中心 会认为客户端与之出现了网络故障，则会进入自动保护模式。1.Eureka不会移除没有收到心跳的服务；2.新的服务仍能在服务端注册，但是暂时不会被同步到其他节点上直到网络稳定 |&#x000A;&#x000A;#### 结论&#x000A;&#x000A;Eureka可以很好的应对网络故障导致部分节点失去连接的情况，而不会像zookeeper那样导致整个注册服务系统的瘫痪。&#x000A;&#x000A;## Ribbon负载均衡&#x000A;&#x000A;Spring Cloud Ribbon是基于Netflix Ribbon实现的一套==客户端==负载均衡工具。Ribbon会自动帮助你基于某种规则（简单轮询、随机连接等），也可以实现自定义的负载均衡算法。 &#x000A;&#x000A;[Ribbon源码]: https://github.com/Netflix/Ribbon&#x000A;&#x000A;### 负载均衡&#x000A;&#x000A;- 英文名称：Load Balance，微服务或分布式集群中常用的一种应用&#x000A;&#x000A;- 简单来说负载均衡就是将用户的请求ping平摊的分配到多个任务上，从而是系统达到HA（高可用）&#x000A;- 两种负载均衡：&#x000A;  1. 集中式LB：偏硬件，服务的消费方和提供方之间使用独立的LB设施，由该设施负责把访问请求以某种策略转发至服务的提供方。&#x000A;  2. 进程内LB：骗软件， 将LB逻辑集成到消费方，消费方从服务注册中心指导哪些地址可用，再自己选择一个合适的服务器。&#x000A;&#x000A;#### Ribbon初步配置&#x000A;&#x000A;- ==Ribbon是客户端负载均衡工具！！！Ribbon是客户端负载均衡工具！！！Ribbon是客户端负载均衡工具！！！==所以应该配置在客户端&#x000A;&#x000A;1. 加入依赖，因为Riboon需要依赖Eureka运行，所以要同时加入Eureka依赖&#x000A;&#x000A;```xml&#x000A;        &lt;dependency&gt;&#x000A;            &lt;groupId&gt;org.springframework.cloud&lt;/groupId&gt;&#x000A;            &lt;artifactId&gt;spring-cloud-starter-eureka&lt;/artifactId&gt;&#x000A;        &lt;/dependency&gt;&#x000A;        &lt;dependency&gt;&#x000A;            &lt;groupId&gt;org.springframework.cloud&lt;/groupId&gt;&#x000A;            &lt;artifactId&gt;spring-cloud-starter-ribbon&lt;/artifactId&gt;&#x000A;        &lt;/dependency&gt;&#x000A;        &lt;dependency&gt;&#x000A;            &lt;groupId&gt;org.springframework.cloud&lt;/groupId&gt;&#x000A;            &lt;artifactId&gt;spring-cloud-starter-config&lt;/artifactId&gt;&#x000A;```&#x000A;&#x000A;2. 对实现类加入@LoadBalanced注解&#x000A;&#x000A;```java&#x000A;@Bean&#x000A;@LoadBalanced&#x000A;public RestTemplate getRestTemplate() {&#x000A;        return  new RestTemplate();&#x000A;    }&#x000A;}&#x000A;```&#x000A;&#x000A;3. 在application.yml文件中配置向注册中心注册，如果是作为消费者模块不提供服务，不应该注册自己&#x000A;&#x000A;```yml&#x000A;eureka:&#x000A;  client:&#x000A;    service-url:&#x000A;      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/&#x000A;    register-with-eureka: false				#作为消费者不提供服务，不应该注册自己&#x000A;```&#x000A;&#x000A;4. 主启动类中加入@EnableEurekaClient注解&#x000A;&#x000A;```java&#x000A;@SpringBootApplication&#x000A;@EnableEurekaClient&#x000A;public class Consumer80_APP {&#x000A;    public static void main(String[] args) {&#x000A;        SpringApplication.run(Consumer80_APP.class,args);&#x000A;    }&#x000A;}&#x000A;```&#x000A;&#x000A;5. 以上步骤1~4完成后即可在controller中直接通过服务名访问系统中的微服务，服务名作为URI&#x000A;&#x000A;```java&#x000A;private static final String URL_PREFIX = &quot;http://MICROSERVICECLOUD-DEPT/&quot;;&#x000A;```&#x000A;&#x000A;#### Ribbon负载均衡实现&#x000A;&#x000A;架构示意图：&#x000A;&#x000A;![Ribbon负载均衡架构](images\Ribbon负载均衡架构.png)&#x000A;&#x000A;##### 实现方法&#x000A;&#x000A;目标：构建provider集群后consumer通过负载均衡轮询调用在Eureka中注册的服务&#x000A;&#x000A;1. 构建集群，新开两个provider模块，将原provider的==代码部分和pom.xml中依赖照搬==到新的provider中&#x000A;2. 将原provider中application.yml文件照搬到新provider，并修改端口号，若新的provider使用自己的数据库，则修改数据库信息（其他配置也一样，如修改别名）&#x000A;3. 集群中服务名称必须一致！！！&#x000A;&#x000A;```yml&#x000A;spring:&#x000A;  application:&#x000A;    name: microservicecloud-dept   #同一集群下必须使用同一服务名！！！！！&#x000A;```&#x000A;&#x000A;4. 启动服务，进行测试&#x000A;&#x000A;##### 总结&#x000A;&#x000A;Ribbon其实就是一个软负载均衡的客户端组件，可以和其他需要请求的客户端结合使用。&#x000A;&#x000A;### Ribbon核心组件IRule&#x000A;&#x000A;IRule：根据特定算法从服务列表中选取一个需要访问的服务&#x000A;&#x000A;#### 七大方法&#x000A;&#x000A;==IRule是一个接口，七大方法是其自带的落地实现类==&#x000A;&#x000A;- RoundRobinRule：轮询（默认方法）&#x000A;- RandomRule：随机&#x000A;- AvailabilityFilteringRule：先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，还有并发的连接数量超过阈值的服务，然后对剩余的服务进行轮询&#x000A;- WeightedResponseTimeRule：根据平均响应时间计算服务的权重。统计信息不足时会按照轮询，统计信息足够会按照响应的时间选择服务&#x000A;- RetryRule：正常时按照轮询选择服务，若过程中有服务出现故障，在轮询一定次数后依然故障，则会跳过故障的服务继续轮询。&#x000A;- BestAvailableRule：先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务&#x000A;- ZoneAvoidanceRule：默认规则，符合判断server所在的区域的性能和server的可用性选择服务&#x000A;&#x000A;#### 切换规则方法&#x000A;&#x000A;只需在==配置类==中配置一个返回具体方法的bean即可&#x000A;&#x000A;```java&#x000A;@Bean&#x000A;public IRule MyRule(){&#x000A;        return new RandomRule();    &#x000A;    }&#x000A;```&#x000A;&#x000A;### 自定义Ribbon负载均衡算法&#x000A;&#x000A;#### 配置及包位置&#x000A;&#x000A;1. 自定义的Ribbon算法类不能放在主启动类所在的包及子报下（确切来说是不能放在@ComponentScan注解的包及子包下），否则会被全局应用到Ribbon服务中。应该把自定义算法类放在另外新建的包下，且这个类应该是为==配置类==。（其实与普通切换负载均衡规则类似，只不过是位置不同而已，普通的可以放在主启动类所在的包，自定义的要放在外面的包下）&#x000A;2. 主启动类添加@RibbonClient(name = &quot;微服务名&quot;,configuration = XXX.class)注解指定需要用到负载均衡的微服务名及自定义算法的class对象。&#x000A;&#x000A;```java&#x000A;@SpringBootApplication&#x000A;@EnableEurekaClient&#x000A;@RibbonClient(name = &quot;MICROSERVICECLOUD-DEPT&quot;,configuration = MyRule.class)&#x000A;public class Consumer80_APP {&#x000A;    public static void main(String[] args) {&#x000A;        SpringApplication.run(Consumer80_APP.class,args);&#x000A;    }&#x000A;}&#x000A;```&#x000A;&#x000A;####通过修改源代码获得自定义算法&#x000A;&#x000A;目标：每个服务调用5次后再进行轮询（调用次数不是很对，懒得改了)&#x000A;&#x000A;```java&#x000A;package com.Rules;&#x000A;&#x000A;import com.netflix.client.config.IClientConfig;&#x000A;import com.netflix.loadbalancer.AbstractLoadBalancerRule;&#x000A;import com.netflix.loadbalancer.ILoadBalancer;&#x000A;import com.netflix.loadbalancer.RoundRobinRule;&#x000A;import com.netflix.loadbalancer.Server;&#x000A;import org.slf4j.Logger;&#x000A;import org.slf4j.LoggerFactory;&#x000A;import org.springframework.context.annotation.Configuration;&#x000A;&#x000A;import java.util.List;&#x000A;import java.util.concurrent.atomic.AtomicInteger;&#x000A;&#x000A;&#x000A;public class MyRule extends AbstractLoadBalancerRule {&#x000A;&#x000A;    private AtomicInteger nextServerCyclicCounter;&#x000A;    private static final boolean AVAILABLE_ONLY_SERVERS = true;&#x000A;    private static final boolean ALL_SERVERS = false;&#x000A;    private int total = 0;&#x000A;    private int currentIndex = 0;&#x000A;&#x000A;    private static Logger log = LoggerFactory.getLogger(RoundRobinRule.class);&#x000A;&#x000A;    public MyRule() {&#x000A;        nextServerCyclicCounter = new AtomicInteger(0);&#x000A;    }&#x000A;&#x000A;    public MyRule(ILoadBalancer lb) {&#x000A;        this();&#x000A;        setLoadBalancer(lb);&#x000A;    }&#x000A;&#x000A;    public Server choose(ILoadBalancer lb, Object key) {&#x000A;        if (lb == null) {&#x000A;            log.warn(&quot;no load balancer&quot;);&#x000A;            return null;&#x000A;        }&#x000A;&#x000A;        Server server = null;&#x000A;        int count = 0;&#x000A;        while (server == null &amp;&amp; count++ &lt; 10) {&#x000A;            List&lt;Server&gt; reachableServers = lb.getReachableServers();&#x000A;            List&lt;Server&gt; allServers = lb.getAllServers();&#x000A;            int upCount = reachableServers.size();&#x000A;            int serverCount = allServers.size();&#x000A;&#x000A;            if ((upCount == 0) || (serverCount == 0)) {&#x000A;                log.warn(&quot;No up servers available from load balancer: &quot; + lb);&#x000A;                return null;&#x000A;            }&#x000A;            if (total &gt; 5) {&#x000A;                total = 0;&#x000A;                int nextServerIndex = incrementAndGetModulo(serverCount);&#x000A;                currentIndex = nextServerIndex;&#x000A;                server = allServers.get(nextServerIndex);&#x000A;            }else {&#x000A;                if (currentIndex&gt;=serverCount) {&#x000A;                    currentIndex = 0;&#x000A;                }&#x000A;                server = allServers.get(currentIndex);&#x000A;                total++;&#x000A;            }&#x000A;&#x000A;&#x000A;            if (server == null) {&#x000A;                /* Transient. */&#x000A;                Thread.yield();&#x000A;                continue;&#x000A;            }&#x000A;&#x000A;            if (server.isAlive() &amp;&amp; (server.isReadyToServe())) {&#x000A;                return (server);&#x000A;            }&#x000A;&#x000A;            // Next.&#x000A;            server = null;&#x000A;        }&#x000A;&#x000A;        if (count &gt;= 10) {&#x000A;            log.warn(&quot;No available alive servers after 10 tries from load balancer: &quot;&#x000A;                    + lb);&#x000A;        }&#x000A;        return server;&#x000A;    }&#x000A;&#x000A;    /**&#x000A;     * Inspired by the implementation of {@link AtomicInteger#incrementAndGet()}.&#x000A;     *&#x000A;     * @param modulo The modulo to bound the value of the counter.&#x000A;     * @return The next value.&#x000A;     */&#x000A;    private int incrementAndGetModulo(int modulo) {&#x000A;        for (;;) {&#x000A;            int current = nextServerCyclicCounter.get();&#x000A;            int next = (current + 1) % modulo;&#x000A;            if (nextServerCyclicCounter.compareAndSet(current, next))&#x000A;                return next;&#x000A;        }&#x000A;    }&#x000A;&#x000A;&#x000A;    public Server choose(Object key) {&#x000A;        return choose(getLoadBalancer(), key);&#x000A;    }&#x000A;&#x000A;&#x000A;    public void initWithNiwsConfig(IClientConfig clientConfig) {&#x000A;    }&#x000A;}&#x000A;&#x000A;```&#x000A;&#x000A;## Feign负载均衡&#x000A;&#x000A;Feign是一个声明式WebService客户端，使用方法时定义一个接口并在上面添加注解即可。Feign支持可拔插式的编码器和解码器。Spring Cloud对Feign进行了封装，使其支持SpringMVC和HttpMessageConverters。Feign可以与Eureka和Ribbon组合使用以支持负载均衡。&#x000A;&#x000A;[Feign源码]: https://github.com/OpenFeign/Feign&#x000A;&#x000A;### 使用案例&#x000A;&#x000A;1. 新建Feign模块，加入依赖（其实跟80消费者差不多，主要是多了Feign依赖）&#x000A;&#x000A;```xml&#x000A;    &lt;dependencies&gt;&#x000A;        &lt;dependency&gt;&#x000A;            &lt;groupId&gt;com.XXX&lt;/groupId&gt;&#x000A;            &lt;artifactId&gt;microservice-api&lt;/artifactId&gt;&#x000A;            &lt;version&gt;${project.version}&lt;/version&gt;&#x000A;        &lt;/dependency&gt;&#x000A;        &lt;dependency&gt;&#x000A;            &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;&#x000A;            &lt;artifactId&gt;spring-boot-starter-web&lt;/artifactId&gt;&#x000A;        &lt;/dependency&gt;&#x000A;        &lt;dependency&gt;&#x000A;            &lt;groupId&gt;org.springframework.cloud&lt;/groupId&gt;&#x000A;            &lt;artifactId&gt;spring-cloud-starter-feign&lt;/artifactId&gt;&#x000A;        &lt;/dependency&gt;&#x000A;        &lt;dependency&gt;&#x000A;            &lt;groupId&gt;org.springframework.cloud&lt;/groupId&gt;&#x000A;            &lt;artifactId&gt;spring-cloud-starter-eureka&lt;/artifactId&gt;&#x000A;        &lt;/dependency&gt;&#x000A;        &lt;dependency&gt;&#x000A;            &lt;groupId&gt;org.springframework.cloud&lt;/groupId&gt;&#x000A;            &lt;artifactId&gt;spring-cloud-starter-ribbon&lt;/artifactId&gt;&#x000A;        &lt;/dependency&gt;&#x000A;        &lt;dependency&gt;&#x000A;            &lt;groupId&gt;org.springframework.cloud&lt;/groupId&gt;&#x000A;            &lt;artifactId&gt;spring-cloud-starter-config&lt;/artifactId&gt;&#x000A;        &lt;/dependency&gt;&#x000A;        &lt;!--热部署--&gt;&#x000A;        &lt;dependency&gt;&#x000A;            &lt;groupId&gt;org.springframework&lt;/groupId&gt;&#x000A;            &lt;artifactId&gt;springloaded&lt;/artifactId&gt;&#x000A;        &lt;/dependency&gt;&#x000A;        &lt;dependency&gt;&#x000A;            &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;&#x000A;            &lt;artifactId&gt;spring-boot-devtools&lt;/artifactId&gt;&#x000A;        &lt;/dependency&gt;&#x000A;    &lt;/dependencies&gt;&#x000A;```&#x000A;&#x000A;2. 因为Feign开发其实是面向接口编程，所以Feign接口可以放在api模块中供各模块使用，所以要在api模块中添加Feign依赖&#x000A;3. 在api中编写接口，接口上添加@FeignClient注解，并通过value指定作用的微服务名&#x000A;&#x000A;```java&#x000A;@FeignClient(value = &quot;MICROSERVICECLOUD-DEPT&quot;)&#x000A;public interface DeptClientService {&#x000A;&#x000A;    @PostMapping(&quot;/dept&quot;)&#x000A;    public boolean addDept(Dept dept);&#x000A;&#x000A;    @GetMapping(&quot;/dept&quot;)&#x000A;    public List&lt;Dept&gt; findAll();&#x000A;&#x000A;    @GetMapping(&quot;/dept/{id}&quot;)&#x000A;    public Dept findById(@PathVariable(&quot;id&quot;)Integer id);&#x000A;}&#x000A;&#x000A;```&#x000A;&#x000A;4. 在Feign模块中编写Controller，并注入FeignClient接口，直接调用service接口中的方法即可（因为声明Feign接口时已经指定过微服务，所以访问时会正确地找到微服务）&#x000A;&#x000A;```java&#x000A;@RestController&#x000A;@RequestMapping(&quot;/consumer&quot;)&#x000A;public class ConsumerDeptController {&#x000A;    @Autowired&#x000A;    private DeptClientService service;&#x000A;&#x000A;    @PostMapping(&quot;/dept&quot;)&#x000A;    public boolean addDept(Dept dept){&#x000A;        return service.addDept(dept);&#x000A;    }&#x000A;&#x000A;    @GetMapping(&quot;/dept&quot;)&#x000A;    public List&lt;Dept&gt; findAll(){&#x000A;        return service.findAll();&#x000A;    }&#x000A;&#x000A;    @GetMapping(&quot;/dept/{id}&quot;)&#x000A;    public Dept findById(@PathVariable(&quot;id&quot;)Integer id){&#x000A;        return service.findById(id);&#x000A;    }&#x000A;}&#x000A;```&#x000A;&#x000A;5. 修改Feign模块的主启动类，加入@EnableFeignClients注解和@ComponentScan注解（主要是扫描api中声明的接口）&#x000A;&#x000A;```java&#x000A;@SpringBootApplication&#x000A;@EnableEurekaClient&#x000A;@EnableFeignClients(basePackages = {&quot;com.XXX&quot;})&#x000A;@ComponentScan(&quot;com.XXX&quot;)&#x000A;public class Consumer80Feign_APP {&#x000A;    public static void main(String[] args) {&#x000A;        SpringApplication.run(Consumer80Feign_APP.class,args);&#x000A;    }&#x000A;}&#x000A;```&#x000A;&#x000A;6. 启动后访问，即会按照轮询的方式调用provider集群&#x000A;&#x000A;### 总结&#x000A;&#x000A;- Feign通过接口方法调用REST服务，在Eureka中查找对应的服务&#x000A;- Feign集成了Ribbon技术，所以也支持负载均衡（轮询）&#x000A;&#x000A;## Hystrix断路器&#x000A;&#x000A;### 分布式系统面临的问题&#x000A;&#x000A;#### 扇出&#x000A;&#x000A;多个微服务互相调用的时候，如果A调用B、C，而B、C又继续调用其他微服务，这就是扇出（像一把扇子一样慢慢打开。&#x000A;&#x000A;#### 服务雪崩&#x000A;&#x000A;- 删除过程中，如果某一个环节的服务出现故障或连接超时，就会导致前面的服务占用越来越多的资源，进而引起系统崩溃，就是“雪崩效应”。&#x000A;- 对于高流量的应用来说，单一的后端依赖会导致服务器所有的资源都在几秒钟内饱和。比失败更糟糕的是，这些应用程序还可能导致服务之间的延迟增加，备份队列，线程和其他系统资源紧张，导致整个系统发生更多的级联故障。这些都表示需要==对故障和延迟进行隔离和管理==，以便单个依赖关系的失败，不能取消整个应用程序或系统。&#x000A;&#x000A;### Hystrix介绍&#x000A;&#x000A;- Hystrix是一个用于处理分布式系统延迟和容错的开源库。分布式系统中，依赖避免不了调用失败，比如超时，异常等。Hystrix能保证在出现问题的时候，不会导致整体服务失败，避免级联故障，以提高分布式系统的弹性。&#x000A;- Hystrix类似一个“断路器”，当系统中异常发生时，断路器给调用返回一个符合预期的，可处理的FallBack，这样就可以避免长时间无响应或抛出异常，使故障不能再系统中蔓延，造成雪崩。&#x000A;&#x000A;#### 服务熔断&#x000A;&#x000A;- 熔断机制的注解是@HystrixCommand&#x000A;- 熔断机制是应对雪崩效应的一种==链路保护机制==，一般存在于服务端&#x000A;- 当扇出链路的某个服务出现故障或响应超时，会进行==服务降级==，进而==熔断该节点的服务调用==，快速返回“错误”的相应信息。、&#x000A;- Hystrix的熔断存在阈值，缺省是5秒内20次调用失败就会触发&#x000A;&#x000A;[Hystrix源码]: https://github.com/Netflix/Hystrix&#x000A;&#x000A;##### 熔断案例&#x000A;&#x000A;1. 构建一个新的provider module（如复制8001module）&#x000A;2. pom.xml加入hystrix依赖（一定要配合Eureka）&#x000A;&#x000A;```xml&#x000A;        &lt;dependency&gt;&#x000A;            &lt;groupId&gt;org.springframework.cloud&lt;/groupId&gt;&#x000A;            &lt;artifactId&gt;spring-cloud-starter-hystrix&lt;/artifactId&gt;&#x000A;        &lt;/dependency&gt;&#x000A;```&#x000A;&#x000A;3. application.xml中配置端口和Eureka信息（必配）和其他框架的配置信息（可选，如mybatis）&#x000A;4. 编写具体业务逻辑&#x000A;5. controller类中，在需要配置Fallback的方法上加入@@HystrixCommand(fallbackMethod = &quot;XXX&quot;)注解，XXX为FallBack方法名本例中作为测试所以抛出了异常&#x000A;&#x000A;```java&#x000A;    @ResponseBody&#x000A;    @GetMapping(&quot;/dept/{id}&quot;)&#x000A;    @HystrixCommand(fallbackMethod = &quot;nullDeptFallBack&quot;)&#x000A;    public Dept findById(@PathVariable(&quot;id&quot;)Integer id) {&#x000A;        Dept dept = deptService.findById(id);&#x000A;        if (null == dept){&#x000A;            throw new RuntimeException(&quot;返回值为空！&quot;);&#x000A;        }&#x000A;        return dept;&#x000A;    }&#x000A;```&#x000A;&#x000A;6. 根据需要配置FallBack的方法返回值编写代码&#x000A;&#x000A;```java&#x000A; public Dept nullDeptFallBack(@PathVariable(&quot;id&quot;)Integer id) {&#x000A;        System.out.println(111);&#x000A;        return new Dept().setId(id).setDeptName(&quot;nullName&quot;).setDbSource(&quot;nullDB&quot;);&#x000A;    }&#x000A;```&#x000A;&#x000A;7. 主启动类中加入@EnableCircuitBreaker注解&#x000A;8. 开启服务，测试&#x000A;&#x000A;#### 解耦与降级处理&#x000A;&#x000A;##### 降级&#x000A;&#x000A;- 当系统整体资源快不够的时候，忍痛将部分服务暂时关闭，带渡过难关后，再重新开启。&#x000A;- 降级处理时在==客户端==完成的，与服务端没有关系&#x000A;- 理解：所谓降级，一般是从==整体负荷==考虑，当某个服务熔断之后，服务器将不再被调用，此时客户端可以自己准备一个本地的FallBack回调，返回一个缺省值。这样做虽然服务水平下降，但好歹可用，比直接挂掉好。&#x000A;&#x000A;##### 为什么要解耦&#x000A;&#x000A;如果按照上面的熔断案例来做的话，Controller下的每个方法，都要给其编写一个FallBack方法，当方法慢慢变多，就会造成代码膨胀，一个是增加编写的工作量，另外一个也会增大维护的难度，代码的耦合度也会高，是十分不合理的，所以要将其解耦。&#x000A;&#x000A;##### 解耦思路&#x000A;&#x000A;因为服务端的是通过实现接口访问服务端的，如果在父接口上实现了FallBack方法，通过这样一种方式去维护起来就能实现解耦，也顺便完成了降级的机制。&#x000A;&#x000A;##### 解耦&amp;降级案例&#x000A;&#x000A;1. 在api模块中新建实现了FallbackFactory&lt;T&gt;接口的类，其中泛型T就是我们需要维护其FallBack的接口方法，并实现其create方法，在create方法中返回实现了T的对象，使用匿名内部类实现T。==注意：这个类一定要加@Component注解！！这个类一定要加@Component注解！！这个类一定要加@Component注解！！==&#x000A;&#x000A;```java&#x000A;import com.XXX.entity.Dept;&#x000A;import feign.hystrix.FallbackFactory;&#x000A;import org.springframework.stereotype.Component;&#x000A;&#x000A;import java.util.List;&#x000A;&#x000A;@Component&#x000A;public class DeptClientServiceFallBackFactory implements FallbackFactory&lt;DeptClientService&gt; {&#x000A;    public DeptClientService create(Throwable throwable) {&#x000A;        return new DeptClientService() {&#x000A;            public boolean addDept(Dept dept) {&#x000A;                return false;&#x000A;            }&#x000A;&#x000A;            public List&lt;Dept&gt; findAll() {&#x000A;                return null;&#x000A;            }&#x000A;&#x000A;            public Dept findById(Integer id) {&#x000A;                return new Dept().setId(id).setDeptName(&quot;服务器跪了,&quot;).setDbSource(&quot;迟点来吧&quot;);&#x000A;            }&#x000A;        };&#x000A;    }&#x000A;}&#x000A;```&#x000A;&#x000A;2. 修改步骤1中传入的泛型T接口，添加@FeignClient(fallbackFactory = T.class)注解&#x000A;&#x000A;```java&#x000A;@FeignClient(value = &quot;MICROSERVICECLOUD-DEPT&quot;,fallbackFactory = DeptClientServiceFallBackFactory.class)&#x000A;public interface DeptClientService {&#x000A;&#x000A;    @PostMapping(&quot;/dept&quot;)&#x000A;    public boolean addDept(Dept dept);&#x000A;&#x000A;    @GetMapping(&quot;/dept&quot;)&#x000A;    public List&lt;Dept&gt; findAll();&#x000A;&#x000A;    @GetMapping(&quot;/dept/{id}&quot;)&#x000A;    public Dept findById(@PathVariable(&quot;id&quot;)Integer id);&#x000A;}&#x000A;```&#x000A;&#x000A;3. 修改consumer feign模块的application.xml文件，开启hystrix（注：在IDEA中可能没有代码提示，开启的true也没有正常高亮，但好像不需要做额外操作也不影响结果）&#x000A;&#x000A;```yml&#x000A;feign:&#x000A;  hystrix:&#x000A;    enabled: true&#x000A;```&#x000A;&#x000A;4. 开启服务并测试&#x000A;&#x000A;&#x000A;#### HystrixDashboard服务监控&#x000A;&#x000A;介绍：SpringCloud对Hystrix Dashboard进行了整合，可以对通过Hystrix发起的请求进行准实时统计，并以报表和图形的形式展示给用户（包括每秒执行多少次请求成功和失败等）。&#x000A;&#x000A;##### 配置案例&#x000A;&#x000A;1. 新建HystrixDashboard模块，pom.xml文件加入HystrixDashboard依赖，其他依赖包括Feign，Ribbon，Eureka（可参考80模块的依赖）&#x000A;&#x000A;```xml&#x000A;        &lt;dependency&gt;&#x000A;            &lt;groupId&gt;org.springframework.cloud&lt;/groupId&gt;&#x000A;            &lt;artifactId&gt;spring-cloud-starter-hystrix-dashboard&lt;/artifactId&gt;&#x000A;        &lt;/dependency&gt;&#x000A;```&#x000A;&#x000A;2. application.yml文件中配置端口（如9001）&#x000A;3. provider类中确认要加入actuator依赖（此为监控依赖）&#x000A;&#x000A;```xml&#x000A;        &lt;dependency&gt;&#x000A;            &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;&#x000A;            &lt;artifactId&gt;spring-boot-starter-actuator&lt;/artifactId&gt;&#x000A;        &lt;/dependency&gt;&#x000A;```&#x000A;&#x000A;4. 编写主启动类，上标@EnableHystrixDashboard标注&#x000A;&#x000A;```java&#x000A;@SpringBootApplication&#x000A;@EnableHystrixDashboard&#x000A;public class DashBoard9001_APP {&#x000A;    public static void main(String[] args) {&#x000A;        SpringApplication.run(DashBoard9001_APP.class,args);&#x000A;    }&#x000A;}&#x000A;```&#x000A;&#x000A;5. 启动服务进行测试，访问地址：http://localhost:9001/hystrix，（根据配置端口号），==看到刺猬表示已经配置好了==&#x000A;&#x000A;##### 如何监控&#x000A;&#x000A;- 在dashboard界面中，填入需要监控的服务地址和端口号加上\hystrix.stream和监测间隔即可进入监控。（如http://localhost:8001/hystrix.stream&#x000A;&#x000A;##### 监控分析&#x000A;&#x000A;- 七色：进入监控界面后会有其中颜色的数字，其含义可以对应右上角相同颜色的单词表示的状态，其值代表该状态下触发的次数&#x000A;- 一圈：圈的大小代表该服务的流量，圈越大流量越大&#x000A;- 一线：代表监控间隔中，服务被访问的频率的折线图&#x000A;- 通过观察这些就可以在大量的实例中找出故障实例和高压实例进行修复和维护。&#x000A;&#x000A;![Dashboard监控说明图](images\HystrixDashboard监控说明图.png)&#x000A;&#x000A;## Zuul路由网关&#x000A;&#x000A;### 概述&#x000A;&#x000A;1. 代理：Zuul提供外部的请求转发到具体的微服务实例中的服务&#x000A;&#x000A;2. 路由：Zuul可以对外部访问实现统一的入口&#x000A;&#x000A;3. 过滤：Zuul可以对外部访问进行干预，如请求校验、服务聚合等&#x000A;&#x000A;4. Zuul需要配合Eureka使用，需要在Eureka中注册并获得其他微服务的信息&#x000A;&#x000A;5. 理解：Zuul就像大楼的保安，可以请他找人（代理），找的人在外面叫什么名字（路由），准不准你进楼（过滤）。因为保安属于物业公司，所以保安要在物业公司注册，所获得的信息也来源于物业公司（与Eureka的关系）。&#x000A;&#x000A;   [Zuul的源码]: http://github.com/Netflix/zuul&#x000A;&#x000A;&#x000A;&#x000A;### 基本配置&#x000A;&#x000A;1. 构建新的Zuul模块并在pom.xml中加入依赖（Zuul和Eureka必须同时加入）&#x000A;&#x000A;```xml&#x000A;&lt;dependency&gt;&#x000A;            &lt;groupId&gt;org.springframework.cloud&lt;/groupId&gt;&#x000A;            &lt;artifactId&gt;spring-cloud-starter-eureka&lt;/artifactId&gt;&#x000A;&lt;/dependency&gt;&#x000A;&lt;dependency&gt;&#x000A;       &lt;groupId&gt;org.springframework.cloud&lt;/groupId&gt;&#x000A;       &lt;artifactId&gt;spring-cloud-starter-zuul&lt;/artifactId&gt;&#x000A;&lt;/dependency&gt;&#x000A;```&#x000A;&#x000A;2. 新建application.yml文件并配置（一定要向Eureka注册，因为Zuul本身也是一个微服务）&#x000A;&#x000A;```yml&#x000A;server:&#x000A;  port: 9527&#x000A;&#x000A;spring:&#x000A;  application:&#x000A;    name: microservicecloud-zuul   #为这个服务取名，非常重要！！！！！&#x000A;&#x000A;eureka:&#x000A;  client:&#x000A;    service-url:&#x000A;      defaultZone: http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/&#x000A;  instance:&#x000A;    instance-id: zuul.com&#x000A;    prefer-ip-address: true&#x000A;```&#x000A;&#x000A;3. 修改hosts文件（非必须，不过能更好看出效果）&#x000A;&#x000A;```shell&#x000A;127.0.0.0 zuul.com&#x000A;```&#x000A;&#x000A;4. 创建主启动类，并加入@EnableZuulProxy注解&#x000A;&#x000A;```java&#x000A;@SpringBootApplication&#x000A;@EnableZuulProxy&#x000A;public class Zuul9527_APP {&#x000A;&#x000A;    public static void main(String[] args) {&#x000A;        SpringApplication.run(Zuul9527_APP.class,args);&#x000A;    }&#x000A;}&#x000A;```&#x000A;&#x000A;5. 启动测试，访问规则：步骤3中指定映射+端口号+微服务名称+访问路径。&#x000A;&#x000A;   例子：http://zuul.com:9527/microservicecloud-dept/dept&#x000A;&#x000A;### 路由访问映射规则&#x000A;&#x000A;#### 服务名映射和统一公共前缀&#x000A;&#x000A;当不向暴露真实的服务名时，可以对服务名进行映射，只需在application.yml中配置即可，==具体作用看注释==&#x000A;&#x000A;```yml&#x000A;zuul:&#x000A;  routes:&#x000A;  	#dept0是可以自定义的只是作为区分，没什么具体意义&#x000A;    dept0.serviceId: microservicecloud-dept		&#x000A;    #路径也是自定义的，支持通配符&#x000A;    dept0.path: /dept10/**						&#x000A;  #需要隐藏的服务名，可以使用通配符，配置之后通过这个微服务名访问就失效了&#x000A;  ignored-services: microservicecloud-*&#x000A;  #设置统一公共前缀，设置后访问路径：http://zuul.com:9527/nihao/dept10/dept/3&#x000A;  prefix: /nihao								&#x000A;```&#x000A;&#x000A;==注：因为Zuul是针对外部访问管理的，所以配置了隐藏的服务，在系统中其他模块进行服务名访问时依然可以正常运行的，这点可以通过打开consumer模块进行验证！==&#x000A;&#x000A;## SpringCloud Config 分布式配置中心&#x000A;&#x000A;分布式系统面临的配置问题：微服务意味着将单体应用拆分成一个个自服务，这些服务都是要相应的配置信息才能运行，随着系统内微服务数量越来越多，配置信息也不断地增多，所以一套集中式的、动态的配置管理设施是必不可少的。&#x000A;&#x000A;### 概述&#x000A;&#x000A;- SpringCloud Config是一个提供外部集中式配置管理的设施，配置服务器为各种不同的额微服务应用提供了一个中心化的外部配置&#x000A;- SpringCloud Config分为客户端和服务端两部分&#x000A;  1. 服务端：分布式配置中心，是一个独立的微服务，用来连接并为客户端提供配置信息，加密/解密信息等访问接口&#x000A;  2. 客户端：通过指定的配置中心获取配置资源，cloud推荐用git来存储配置信息&#x000A;- SpringCloud Config解决的问题：&#x000A;  1. 集中管理配置文件&#x000A;  2. 不同环境不同配置，动态化的配置更新&#x000A;  3. 运行期间动态调整配置，不再需要在每个服务部署的机器上编写配置文件，让服务中心统一为服务拉取配置文件&#x000A;  4. 当配置发生变动时，服务不需要重启即可感知配置变化并应用&#x000A;  5. 将配置信息以REST接口形式暴露&#x000A;&#x000A;![SpringCloud Config架构图](images\SpringCloud Config架构图.png)&#x000A;&#x000A;### SpringCloud Config服务端与Github通讯&#x000A;&#x000A;目标：将配置文件部署在github，Config服务端从github获取配置&#x000A;&#x000A;#### 案例&#x000A;&#x000A;1. 新建ConfigServer模块并配置pom.xml&#x000A;&#x000A;```xml&#x000A;		&lt;!-- springCloud Config --&gt;&#x000A;		&lt;dependency&gt;&#x000A;			&lt;groupId&gt;org.springframework.cloud&lt;/groupId&gt;&#x000A;			&lt;artifactId&gt;spring-cloud-config-server&lt;/artifactId&gt;&#x000A;		&lt;/dependency&gt;&#x000A;		&lt;!-- 避免Config的Git插件报错：org/eclipse/jgit/api/TransportConfigCallback --&gt;&#x000A;		&lt;dependency&gt;&#x000A;			&lt;groupId&gt;org.eclipse.jgit&lt;/groupId&gt;&#x000A;			&lt;artifactId&gt;org.eclipse.jgit&lt;/artifactId&gt;&#x000A;			&lt;version&gt;4.10.0.201712302008-r&lt;/version&gt;&#x000A;		&lt;/dependency&gt;&#x000A;```&#x000A;&#x000A;2. 建立远程仓库，并上传配置文件。如下例&#x000A;&#x000A;```yml&#x000A;spring: &#x000A;    profiles: &#x000A;        active:&#x000A;           - dev&#x000A;---&#x000A;spring:&#x000A;    profiles: dev&#x000A;    application:&#x000A;        name: microservicecloud-config-XXX-dev&#x000A;---&#x000A;spring:&#x000A;    profiles: test&#x000A;    application:&#x000A;        name: microservicecloud-config-XXX-test&#x000A;```&#x000A;&#x000A;3. 在application.xml文件中配置github地址&#x000A;&#x000A;```yml&#x000A;server:&#x000A;  port: 3344&#x000A;&#x000A;spring:&#x000A;  application:&#x000A;    #为这个服务取名，非常重要！！！！！&#x000A;    name: microservicecloud-config&#x000A;  cloud:&#x000A;    config:&#x000A;      server:&#x000A;        git:&#x000A;          # uri填github上仓库地址&#x000A;          uri: https://github.com/XXXX/SpringCloud_Configuration.git&#x000A;```&#x000A;&#x000A;4. 编写主启动类，加入@EnableConfigServer注解&#x000A;&#x000A;```java&#x000A;@SpringBootApplication&#x000A;@EnableConfigServer&#x000A;public class ConfigServer3344_APP {&#x000A;    public static void main(String[] args) {&#x000A;        SpringApplication.run(ConfigServer3344_APP.class,args);&#x000A;    }&#x000A;}&#x000A;```&#x000A;&#x000A;5. 启动服务并尝试访问配置文件，有以下五种访问配置规则&#x000A;   - {application}：配置文件的文件名&#x000A;   - {profile}：读取的环境&#x000A;   - {lable}：分支&#x000A;&#x000A;```SHELL&#x000A;/{application}/{profile}[/{lable}]&#x000A;/{application}-{profile}.yml&#x000A;/{lable}/{application}-{profile}.yml&#x000A;/{application}-{profile}.properties&#x000A;/{lable}/{application}-{profile}.properties&#x000A;```&#x000A;&#x000A;可用例子（返回格式可能不大相同，但返回值相同）：&#x000A;&#x000A;- http://config3344.com:3344/application-test.yml&#x000A;- http://config3344.com:3344/master/application-dev.yml&#x000A;- http://config3344.com:3344/application-test.yml/master&#x000A;&#x000A;不可用例子：&#x000A;&#x000A;- 没有该环境，返回空值：http://config3344.com:3344/application-test11.yml/master&#x000A;- 没有配置文件，犯回错误页面：http://config3344.com:3344/lkjliiusdfsddsfl.yml&#x000A;&#x000A;### bootstrap.yml介绍&#x000A;&#x000A;- bootstrap.yml比application.yml具有更高的优先级。&#x000A;- bootstrap.yml是系统级的资源配置项，application.yml是用户级的资源配置项。&#x000A;- SpringCloud会创建&quot;BootStrap Context&quot;作为&quot;ApplicationContext&quot;的==父上下文==。初始化的时候BootStrap Context负责从外部源加载配置属性并解析。这两个上下文共享一个&quot;Environment&quot;，BootStrap 具有更高优先级，他们不会被本地配置覆盖。&#x000A;&#x000A;### 客户端的配置与测试&#x000A;&#x000A;介绍：客户端主要是在==加载时==通过config server服务端获得github配置仓库的地址，进而通过目标配置文件的文件名获取相应的配置，最后将取得的配置对自身资源进行赋值并提供访问&#x000A;&#x000A;#### 实现过程&#x000A;&#x000A;1.创建远程配置yml文件并上传到github上。如下测试案例因为需要进行测试，所以配置了两个profiles方便切换并观察&#x000A;&#x000A;```yml&#x000A;spring: &#x000A;    profiles: &#x000A;        active:&#x000A;           - dev&#x000A;---&#x000A;server: &#x000A;    port: 8201&#x000A;spring:&#x000A;    profiles: dev&#x000A;    application:&#x000A;        name: microservicecloud-config-client-dev&#x000A;eureka:&#x000A;    client: &#x000A;        service-url: &#x000A;            defaultZone: http://eureka-dev.com:7001/eureka/&#x000A;---&#x000A;server: &#x000A;    port: 8202&#x000A;spring:&#x000A;    profiles: test&#x000A;    application:&#x000A;        name: microservicecloud-config-client-test&#x000A;eureka:&#x000A;    client: &#x000A;        service-url: &#x000A;            defaultZone: http://eureka-dev.com:7001/eureka/&#x000A;```&#x000A;&#x000A;2. 本地创建config client模块，并配置好pom.xml，以下本组件是必选依赖&#x000A;&#x000A;```xml&#x000A;        &lt;dependency&gt;&#x000A;            &lt;groupId&gt;org.springframework.cloud&lt;/groupId&gt;&#x000A;            &lt;artifactId&gt;spring-cloud-starter-config&lt;/artifactId&gt;&#x000A;        &lt;/dependency&gt;&#x000A;```&#x000A;&#x000A;3. 编写bootstrap.yml配置文件，这个步骤比较关键，主要是根据此处的配置信息去寻找config server以获得github仓库地址和配置中的目标配置文件文件名&#x000A;&#x000A;```yml&#x000A;spring:&#x000A;  cloud:&#x000A;    config:&#x000A;      name: application_config #需要从github上读取的资源名称，注意没有yml后缀名&#x000A;      profile: test   #本次访问的配置项&#x000A;      label: master&#x000A;      uri: http://config3344.com:3344  #本微服务启动后先去找3344号服务，通过SpringCloudConfig获取GitHub的服务地址&#x000A;```&#x000A;&#x000A;4. application.yml文件在本module中其实是可写可不写的，为了习惯需要，还是给他写了个名字&#x000A;&#x000A;```YML&#x000A;spring:&#x000A;  application:&#x000A;    name: microservicecloud_config&#x000A;```&#x000A;&#x000A;5. 修改host文件增加映射，和3344一样&#x000A;6. 编写主启动类，没什么特别的，最基本的主启动类&#x000A;7. 编写controller，此步骤也比较关键，主要是利用@Value注解赋值，若写错了bootstrap.yml中的配置文件名称而没有获取到配置，启动时这里会抛出异常。@Value中注解的参数即是目标配置文件中的参数值，使用El表达式获取&#x000A;&#x000A;```java&#x000A;@org.springframework.web.bind.annotation.RestController&#x000A;public class RestController {&#x000A;    @Value(&quot;${server.port}&quot;)&#x000A;    private String port;&#x000A;    @Value(&quot;${eureka.client.service-url.defaultZone}&quot;)&#x000A;    private String eurekaZone;&#x000A;    @Value(&quot;${spring.application.name}&quot;)&#x000A;    private String name;&#x000A;&#x000A;&#x000A;    @GetMapping(&quot;/config&quot;)&#x000A;    @Override&#x000A;    public String toString() {&#x000A;        return &quot;RestController{&quot; +&#x000A;                &quot;port=&#39;&quot; + port + &#39;\&#39;&#39; +&#x000A;                &quot;, eurekaZone=&#39;&quot; + eurekaZone + &#39;\&#39;&#39; +&#x000A;                &quot;, name=&#39;&quot; + name + &#39;\&#39;&#39; +&#x000A;                &#39;}&#39;;&#x000A;    }&#x000A;}&#x000A;&#x000A;```&#x000A;&#x000A;8. 先启动config server服务，然后再启用本client服务，根据profiles的值访问对应的端口即可。如本例选择的是test，则访问端口为：http://config3355.com:8202/config。（config3355.com为hosts文件中配置了的映射）&#x000A;&#x000A;### SpringCloud的配置实战&#x000A;&#x000A;介绍：其实前面client的配置案例都是帮助理解这个组件为主，并没有很大的实际意义。。。。。。这节的案例中是配置一个Provider，一个eureka，他们的配置统一在github上获取，实现统一配置分布式管理和多环境变更，这个才比较有实战意义。&#x000A;&#x000A;#### 实现过程&#x000A;&#x000A;1. 先写好provider和Eureka的配置yml文件，这两个文件和平常配置没什么不同，因为这里主要是说config，所以就没有配置集群，上传yml到github&#x000A;&#x000A;Eureka配置文件示例：&#x000A;&#x000A;```yml&#x000A;spring: &#x000A;    profiles: &#x000A;        active:&#x000A;           - dev&#x000A;---&#x000A;spring:&#x000A;    profiles: dev&#x000A;    application:&#x000A;        name: microservicecloud-eureka-client-dev&#x000A;server:&#x000A;  port: 7001&#x000A;eureka:&#x000A;  instance:&#x000A;    hostname: eureka7001.com    #hostname为hosts文件中映射的地址&#x000A;  client:&#x000A;    register-with-eureka: false     #false表示不向注册中心注册自己&#x000A;    fetch-registry: false           #false表示自己就是注册中心，职责是维护实例，不参加检索&#x000A;    service-url:&#x000A;      defaultZone: http://eureka7001.com:7001/eureka/   #设置eureka server的交互地址&#x000A;&#x000A;---&#x000A;spring:&#x000A;    profiles: test&#x000A;    application:&#x000A;        name: microservicecloud-eureka-client-dev&#x000A;server:&#x000A;  port: 7001&#x000A;eureka:&#x000A;  instance:&#x000A;    hostname: eureka7001.com    #hostname为hosts文件中映射的地址&#x000A;  client:&#x000A;    register-with-eureka: false     #false表示不向注册中心注册自己&#x000A;    fetch-registry: false           #false表示自己就是注册中心，职责是维护实例，不参加检索&#x000A;    service-url:&#x000A;      defaultZone: http://eureka7001.com:7001/eureka/    #设置eureka server的交互地址&#x000A;```&#x000A;&#x000A;Provider配置文件示例：&#x000A;&#x000A;```yml&#x000A;spring: &#x000A;    profiles: &#x000A;        active:&#x000A;           - dev&#x000A;---&#x000A;server:&#x000A;  port: 8001&#x000A;&#x000A;mybatis:&#x000A;  config-location: classpath:mybatis/mybatis.cfg.xml&#x000A;  type-aliases-package: com.XXX.entity&#x000A;  mapper-locations:&#x000A;  - classpath:mybatis/mapper/**/*.xml&#x000A;spring:&#x000A;  profiles: dev&#x000A;  application:&#x000A;    name: microservicecloud-dept   #为这个服务取名，非常重要！！！！！&#x000A;  datasource:&#x000A;    type: com.alibaba.druid.pool.DruidDataSource&#x000A;    driver-class-name: org.gjt.mm.mysql.Driver&#x000A;    url: jdbc:mysql://192.168.88.246:3306/cloudDB01&#x000A;    username: root&#x000A;    password: 123456&#x000A;    dbcp2:&#x000A;      min-idle: 5         #最小连接数&#x000A;      initial-size: 5    #初始化连接数&#x000A;      max-total: 10      #最大连接数&#x000A;      max-wait-millis: 200  #等待连接最长的超时时间&#x000A;eureka:&#x000A;  client:&#x000A;    service-url:&#x000A;      defaultZone: http://eureka7001.com:7001/eureka/&#x000A;  instance:&#x000A;    instance-id: dept8001&#x000A;    prefer-ip-address: true&#x000A;---&#x000A;server:&#x000A;  port: 8001&#x000A;&#x000A;mybatis:&#x000A;  config-location: classpath:mybatis/mybatis.cfg.xml&#x000A;  type-aliases-package: com.XXX.entity&#x000A;  mapper-locations:&#x000A;  - classpath:mybatis/mapper/**/*.xml&#x000A;spring:&#x000A;  profiles: test&#x000A;  application:&#x000A;    name: microservicecloud-dept   #为这个服务取名，非常重要！！！！！&#x000A;  datasource:&#x000A;    type: com.alibaba.druid.pool.DruidDataSource&#x000A;    driver-class-name: org.gjt.mm.mysql.Driver&#x000A;    url: jdbc:mysql://192.168.88.246:3306/cloudDB02&#x000A;    username: root&#x000A;    password: 123456&#x000A;    dbcp2:&#x000A;      min-idle: 5         #最小连接数&#x000A;      initial-size: 5    #初始化连接数&#x000A;      max-total: 10      #最大连接数&#x000A;      max-wait-millis: 200  #等待连接最长的超时时间&#x000A;eureka:&#x000A;  client:&#x000A;    service-url:&#x000A;      defaultZone: http://eureka7001.com:7001/eureka/&#x000A;  instance:&#x000A;    instance-id: dept8001&#x000A;    prefer-ip-address: true&#x000A;```&#x000A;&#x000A;2. 新开eureka和provide的模块并在pom.xml中添加依赖，其他必要依赖和之前的案例一样，但是config的依赖一定要添加上&#x000A;&#x000A;```XML&#x000A;        &lt;dependency&gt;&#x000A;            &lt;groupId&gt;org.springframework.cloud&lt;/groupId&gt;&#x000A;            &lt;artifactId&gt;spring-cloud-starter-config&lt;/artifactId&gt;&#x000A;        &lt;/dependency&gt;&#x000A;```&#x000A;&#x000A;3. 两个模块都要编写bootstrap.yml文件，和上面的案例一样&#x000A;&#x000A;```yml&#x000A;spring:&#x000A;  cloud:&#x000A;    config:&#x000A;      name: application_config #需要从github上读取的资源名称，注意没有yml后缀名&#x000A;      profile: test   #本次访问的配置项&#x000A;      label: master&#x000A;      uri: http://config3344.com:3344  #本微服务启动后先去找3344号服务，通过SpringCloudConfig获取GitHub的服务地址&#x000A;```&#x000A;&#x000A;4. (可选)两个模块中编写application.yml文件，可以配置一下服务名&#x000A;&#x000A;```yml&#x000A;spring:&#x000A;  application:&#x000A;    name: microservicecloud_config&#x000A;```&#x000A;&#x000A;5. 两个模块的主启动类，Eureka的正常加EurekaServer注解，Provider加EurekaClient注解，不详述&#x000A;6. 编写Provider模块的业务代码&#x000A;7. 启动测试，因为这两个模块都要通过3344ConfigServer为其在github上获取配置，所以要先启动3344模块，然后再一次启动eureka和provider模块，进行测试即可。&#x000A;</textarea>
<a class="ui button" href="#" id="copy-text" style="border-left: none;">Copy</a>
<a class="ui button disabled has_tooltip edit-blob" href="/xiongrj/springcloud-base/edit/master/README.md" title="无编辑权限">Edit</a>
<a class="ui button web-ide" href="/-/ide/project/xiongrj/springcloud-base/edit/master/-/README.md" target="_blank">Web IDE</a>
<a class="ui button edit-raw" href="/xiongrj/springcloud-base/raw/master/README.md" target="_blank">Raw</a>
<a class="ui button edit-blame" href="/xiongrj/springcloud-base/blame/master/README.md">Blame</a>
<a class="ui button edit-history" href="/xiongrj/springcloud-base/commits/master/README.md">History</a>
</div>
<script>
  "use strict";
  try {
    if((gon.wait_fork!=undefined && gon.wait_fork==true) || (gon.wait_fetch!=undefined && gon.wait_fetch==true)){
      $('.edit-blob').popup({content:"This repository is doing something background, pleace try again later", on: 'hover', delay: { show: 200, hide: 200 }});
      $('.edit-blob').click(function(e){
        e.preventDefault();
      })
    }
  
    var setUrl = function() {
      var params = window.location.search
      if (params==undefined || $.trim(params).length==0) return;
      $('span.options').children('.basic').find('a').each(function(index,ele){
        var origin_href = $(ele).attr('href');
        if (origin_href!="#" && origin_href.indexOf('?') == -1){
          $(ele).attr('href',origin_href+params);
        }
      });
    }
  
    setUrl();
  
    var clipboard = null,
        $btncopy  = $("#copy-text");
  
    clipboard = new Clipboard("#copy-text", {
      text: function(trigger) {
        return $("#blob_raw").val();
      }
    })
  
    clipboard.on('success', function(e) {
      $btncopy.popup('hide');
      $btncopy.popup('destroy');
      $btncopy.popup({content: 'Copied', position: 'bottom center'});
      $btncopy.popup('show');
    })
  
    clipboard.on('error', function(e) {
      var giteeModal = new GiteeModalHelper({okText: 'Confirm'});
      giteeModal.alert("Copy", 'Copy failed. Please copy it manually');
    })
  
    $(function() {
      $btncopy.popup({
        content: 'Copy to clipboard',
        position: 'bottom center'
      })
    })
  
  } catch (error) {
    console.log('blob/action error:' + error);
  }
  
  $('.disabled-edit-readonly').popup({
    content: "Readonly file is not editable",
    className: {
      popup: 'ui popup',
    },
    position: 'bottom center',
  })
  $('.disabled-edit-readonly').click(() => {
    return false
  })
</script>
<style>
  .disabled-edit-readonly {
    background-color: #dcddde !important;
    color: rgba(0, 0, 0, 0.4) !important;
    opacity: 0.3 !important;
    background-image: none !important;
    -webkit-box-shadow: none !important;
            box-shadow: none !important; }
</style>
</div>
</div>
<div class='contributor-description'><span class='recent-commit' style='margin-top: 0.7rem'>
<a class="commit-author-link " href="/xiongrj">Xiongrj</a>
<span>authored</span>
<span class='timeago commit-date' title='2018-08-08 14:41:47 +0800'>
2018-08-08 14:41
</span>
.
<a href="/xiongrj/springcloud-base/commit/76398331da90f2a59f214f76c3f8e7cd4d576ca7">8.8</a>
</span>
</div>
</div>
<div class='clearfix'></div>
<div class='file_content markdown-body'>
<h1>&#x000A;<a id="springcloud" class="anchor" href="#springcloud"></a>SpringCloud</h1>&#x000A;<h2>&#x000A;<a id="微服务概述" class="anchor" href="#%E5%BE%AE%E6%9C%8D%E5%8A%A1%E6%A6%82%E8%BF%B0"></a>微服务概述</h2>&#x000A;<h3>&#x000A;<a id="什么是微服务" class="anchor" href="#%E4%BB%80%E4%B9%88%E6%98%AF%E5%BE%AE%E6%9C%8D%E5%8A%A1"></a>什么是微服务</h3>&#x000A;<ul>&#x000A;<li>目前的微服务并没有一个统一的标准，一般是以业务来划分</li>&#x000A;<li>将传统的一站式应用，拆分成一个个的服务，彻底去耦合，一个微服务就是单功能业务，只做一件事。</li>&#x000A;<li>与微服务相对的叫巨石</li>&#x000A;</ul>&#x000A;<h3>&#x000A;<a id="微服务与微服务架构" class="anchor" href="#%E5%BE%AE%E6%9C%8D%E5%8A%A1%E4%B8%8E%E5%BE%AE%E6%9C%8D%E5%8A%A1%E6%9E%B6%E6%9E%84"></a>微服务与微服务架构</h3>&#x000A;<ul>&#x000A;<li>微服务是一种架构模式或者一种架构风格，提倡将单一应用程序划分成一组小的服务==独立部署==，服务之间相互配合、相互协调，每个服务运行于自己的==进程==中。</li>&#x000A;<li>服务与服务间采用轻量级通讯，如HTTP的RESTful API等</li>&#x000A;<li>避免统一的、集中式的服务管理机制</li>&#x000A;</ul>&#x000A;<h3>&#x000A;<a id="微服务的优缺点" class="anchor" href="#%E5%BE%AE%E6%9C%8D%E5%8A%A1%E7%9A%84%E4%BC%98%E7%BC%BA%E7%82%B9"></a>微服务的优缺点</h3>&#x000A;<h4>&#x000A;<a id="优点" class="anchor" href="#%E4%BC%98%E7%82%B9"></a>优点</h4>&#x000A;<ol>&#x000A;<li>每个服务足够内聚，足够小，比较容易聚焦</li>&#x000A;<li>开发简单且效率高，一个服务只做一件事情</li>&#x000A;<li>开发团队小，一般2-5人足以（当然按实际为准）</li>&#x000A;<li>微服务是松耦合的，无论开发还是部署都可以独立完成</li>&#x000A;<li>微服务能用不同的语言开发</li>&#x000A;<li>易于和第三方集成，微服务允许容易且灵活的自动集成部署（持续集成工具有Jenkins,Hudson,bamboo等）</li>&#x000A;<li>微服务易于被开发人员理解，修改和维护，这样可以使小团队更加关注自己的工作成果，而无需一定要通过合作才能体现价值</li>&#x000A;<li>微服务允许你融合最新的技术</li>&#x000A;<li>==微服务只是业务逻辑的代码，不会和HTML,CSS或其他界面组件融合==。</li>&#x000A;<li>==每个微服务都可以有自己的存储能力，数据库可自有也可以统一，十分灵活==。</li>&#x000A;</ol>&#x000A;<h4>&#x000A;<a id="缺点" class="anchor" href="#%E7%BC%BA%E7%82%B9"></a>缺点</h4>&#x000A;<ol>&#x000A;<li>开发人员要处理分布式系统的复杂性</li>&#x000A;<li>多服务运维难度，随着服务的增加，运维的压力也会增大</li>&#x000A;<li>依赖系统部署</li>&#x000A;<li>服务间通讯的成本</li>&#x000A;<li>数据的一致性</li>&#x000A;<li>系统集成测试</li>&#x000A;<li>性能监控的难度</li>&#x000A;</ol>&#x000A;<h3>&#x000A;<a id="微服务的技术栈" class="anchor" href="#%E5%BE%AE%E6%9C%8D%E5%8A%A1%E7%9A%84%E6%8A%80%E6%9C%AF%E6%A0%88"></a>微服务的技术栈</h3>&#x000A;<table>&#x000A;<thead>&#x000A;<tr>&#x000A;<th align="center">微服务条目</th>&#x000A;<th align="center">落地技术</th>&#x000A;</tr>&#x000A;</thead>&#x000A;<tbody>&#x000A;<tr>&#x000A;<td align="center">服务开发</td>&#x000A;<td align="center">SpringBoot,Spring,SpringMVC</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td align="center">服务配置与管理</td>&#x000A;<td align="center">Netflix公司的Archaius、阿里的Diamond等</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td align="center">服务注册与发现</td>&#x000A;<td align="center">Eureka、Consul、Zookeeper等</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td align="center">服务调用</td>&#x000A;<td align="center">Rest、RPC、gRPC</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td align="center">服务熔断器</td>&#x000A;<td align="center">Hystrix、Envoy等</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td align="center">负载均衡</td>&#x000A;<td align="center">Ribbon、Nginx等</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td align="center">服务接口调用（客户端调用服务的简化工具）</td>&#x000A;<td align="center">Feign等</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td align="center">消息队列</td>&#x000A;<td align="center">Kafka、RabbitMQ、ActiveMQ等</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td align="center">服务配置中心管理</td>&#x000A;<td align="center">SpringCloudConfig、Chef等</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td align="center">服务路由（API网关）</td>&#x000A;<td align="center">Zuul等</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td align="center">服务监控</td>&#x000A;<td align="center">Zabbix、Nagios、Metrics、Specatator等</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td align="center">全链路追踪</td>&#x000A;<td align="center">Zipkin、Brave、Dapper等</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td align="center">服务部署</td>&#x000A;<td align="center">Docker、OpenStack、Kubernetes等</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td align="center">数据流操作开发包</td>&#x000A;<td align="center">SpringCloud Stream(封装与Redis，Rabbit，Kafka等发送接收消息)</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td align="center">事件消息总线</td>&#x000A;<td align="center">SpringCloud Bus</td>&#x000A;</tr>&#x000A;</tbody>&#x000A;</table>&#x000A;<h3>&#x000A;<a id="为什么选springcloud作为微服务架构" class="anchor" href="#%E4%B8%BA%E4%BB%80%E4%B9%88%E9%80%89springcloud%E4%BD%9C%E4%B8%BA%E5%BE%AE%E6%9C%8D%E5%8A%A1%E6%9E%B6%E6%9E%84"></a>为什么选SpringCloud作为微服务架构</h3>&#x000A;<h4>&#x000A;<a id="选型依据" class="anchor" href="#%E9%80%89%E5%9E%8B%E4%BE%9D%E6%8D%AE"></a>选型依据</h4>&#x000A;<ol>&#x000A;<li>整体解决方案和框架的成熟度</li>&#x000A;<li>社区热度</li>&#x000A;<li>可维护性</li>&#x000A;<li>学习曲线</li>&#x000A;</ol>&#x000A;<h4>&#x000A;<a id="当前各大it公司的微服务架构" class="anchor" href="#%E5%BD%93%E5%89%8D%E5%90%84%E5%A4%A7it%E5%85%AC%E5%8F%B8%E7%9A%84%E5%BE%AE%E6%9C%8D%E5%8A%A1%E6%9E%B6%E6%9E%84"></a>当前各大IT公司的微服务架构</h4>&#x000A;<ol>&#x000A;<li>阿里Dubbo/HSF</li>&#x000A;<li>京东JSF</li>&#x000A;<li>新浪Motan</li>&#x000A;<li>当当DubboX</li>&#x000A;</ol>&#x000A;<h4>&#x000A;<a id="各微服务的框架对比" class="anchor" href="#%E5%90%84%E5%BE%AE%E6%9C%8D%E5%8A%A1%E7%9A%84%E6%A1%86%E6%9E%B6%E5%AF%B9%E6%AF%94"></a>各微服务的框架对比</h4>&#x000A;<table>&#x000A;<thead>&#x000A;<tr>&#x000A;<th align="center">功能点/服务框架</th>&#x000A;<th align="center">Netflix/SpringCloud</th>&#x000A;<th align="center">Motan</th>&#x000A;<th align="center">gRPC</th>&#x000A;<th align="center">Thrift</th>&#x000A;<th align="center">Dubbo/DubboX</th>&#x000A;</tr>&#x000A;</thead>&#x000A;<tbody>&#x000A;<tr>&#x000A;<td align="center">功能定位</td>&#x000A;<td align="center">完整的微服务架构</td>&#x000A;<td align="center">RPC框架，但整合了ZK或Consul，实现集群环境的基本服务注册/发现</td>&#x000A;<td align="center">RPC框架</td>&#x000A;<td align="center">RPC框架</td>&#x000A;<td align="center">服务框架</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td align="center">支持Rest</td>&#x000A;<td align="center">是，Ribbon支持多种可插拔的序列化选择</td>&#x000A;<td align="center">否</td>&#x000A;<td align="center">否</td>&#x000A;<td align="center">否</td>&#x000A;<td align="center">否</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td align="center">支持RPC</td>&#x000A;<td align="center">否</td>&#x000A;<td align="center">是</td>&#x000A;<td align="center">是</td>&#x000A;<td align="center">是</td>&#x000A;<td align="center">是</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td align="center">支持多语言</td>&#x000A;<td align="center">是（Rest形式）</td>&#x000A;<td align="center">否</td>&#x000A;<td align="center">是</td>&#x000A;<td align="center">是</td>&#x000A;<td align="center">否</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td align="center">服务注册/发现</td>&#x000A;<td align="center">是（Eureka） Eureka服务注册表，Karyon服务端框架支持服务自注册和健康检查</td>&#x000A;<td align="center">是（zookeeper/consul）</td>&#x000A;<td align="center">否</td>&#x000A;<td align="center">否</td>&#x000A;<td align="center">是</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td align="center">负载均衡</td>&#x000A;<td align="center">是（服务端zuul+客户端Ribbon） zuul-服务，动态路由 云端负载均衡  Eureka（针对中间层服务器）</td>&#x000A;<td align="center">是（客户端）</td>&#x000A;<td align="center">否</td>&#x000A;<td align="center">否</td>&#x000A;<td align="center">是（客户端）</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td align="center">配置服务</td>&#x000A;<td align="center">Netflix Archaius SpringCloud Config Server集中配置</td>&#x000A;<td align="center">是（zookeeper提供）</td>&#x000A;<td align="center">否</td>&#x000A;<td align="center">否</td>&#x000A;<td align="center">否</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td align="center">服务调用链监控</td>&#x000A;<td align="center">是（zuul） Zuul提供边缘服务，API网关</td>&#x000A;<td align="center">否</td>&#x000A;<td align="center">否</td>&#x000A;<td align="center">否</td>&#x000A;<td align="center">否</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td align="center">高可用/容错</td>&#x000A;<td align="center">是（服务端Hystrix+客户端Ribbon）</td>&#x000A;<td align="center">是（客户端）</td>&#x000A;<td align="center">否</td>&#x000A;<td align="center">否</td>&#x000A;<td align="center">是（客户端）</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td align="center">典型应用案例</td>&#x000A;<td align="center">Netflix</td>&#x000A;<td align="center">Sina</td>&#x000A;<td align="center">Google</td>&#x000A;<td align="center">Facebook</td>&#x000A;<td align="center"></td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td align="center">社区活跃度</td>&#x000A;<td align="center">高</td>&#x000A;<td align="center">一般</td>&#x000A;<td align="center">高</td>&#x000A;<td align="center">一般</td>&#x000A;<td align="center">2017年7月才重启</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td align="center">学习难度</td>&#x000A;<td align="center">中等</td>&#x000A;<td align="center">一般</td>&#x000A;<td align="center">高</td>&#x000A;<td align="center">一般</td>&#x000A;<td align="center">低</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td align="center">文档丰富度</td>&#x000A;<td align="center">高</td>&#x000A;<td align="center">一般</td>&#x000A;<td align="center">一般</td>&#x000A;<td align="center">一般</td>&#x000A;<td align="center">高</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td align="center">其他</td>&#x000A;<td align="center">Spring Cloud Bus为我们应用程序带来了更多管理端点</td>&#x000A;<td align="center">支持降级</td>&#x000A;<td align="center">Netflix内部在开发集成gRPC</td>&#x000A;<td align="center">IDL定义</td>&#x000A;<td align="center">实践公司比较多</td>&#x000A;</tr>&#x000A;</tbody>&#x000A;</table>&#x000A;<h2>&#x000A;<a id="springcloud入门概述" class="anchor" href="#springcloud%E5%85%A5%E9%97%A8%E6%A6%82%E8%BF%B0"></a>SpringCloud入门概述</h2>&#x000A;<ul>&#x000A;<li>Spring的三大模块：SpringBoot（构建），Spring Cloud（协调），Spring Cloud Data Flow（连接）</li>&#x000A;</ul>&#x000A;<h3>&#x000A;<a id="springcloud是什么" class="anchor" href="#springcloud%E6%98%AF%E4%BB%80%E4%B9%88"></a>SpringCloud是什么</h3>&#x000A;<ul>&#x000A;<li>分布式系统的简化版（官方介绍）</li>&#x000A;<li>SpringCloud基于SpringBoot提供了一整套微服务的解决方案，包括服务注册与发现，配置中心，全链路监控，服务网关，负载均衡，熔断器等组件，除了基于Netflix的开源组件做高度抽象封装之外，还有一些选型中立的开源组件</li>&#x000A;<li>SpringCloud利用SpringBoot的开发便利性巧妙地简化了分布式系统的基础设施开发，SpringCloud为开发人员提供了快速构建分布式系统的一些工具，包括配置管理、服务发现、断路器、路由、微代理、事件总线，全局所、决策精选、分布式会话等等，他们都可以用SpringBoot的开发风格做到一键启动和部署。</li>&#x000A;<li>==一句话概括：SpringCloud是分布式微服务架构下的一站式解决方案，是各个微服务架构落地技术的几何体，俗称微服务全家桶==</li>&#x000A;</ul>&#x000A;<h3>&#x000A;<a id="springcloud和springboot的关系" class="anchor" href="#springcloud%E5%92%8Cspringboot%E7%9A%84%E5%85%B3%E7%B3%BB"></a>SpringCloud和SpringBoot的关系</h3>&#x000A;<p>SpringBoot：专注于快速方便的开发单个个体微服务（关注微观）</p>&#x000A;<p>SpringCloud：关注全局的微服务协调治理框架，将SpringBoot开发的一个个单体微服务组合并管理起来（关注宏观）</p>&#x000A;<ul>&#x000A;<li>==SpringBoot可以离开SpringCloud独立使用，但是SpringCloud不可以离开SpringBoot，属于依赖关系==</li>&#x000A;</ul>&#x000A;<h3>&#x000A;<a id="dubbo是怎么到springcloud的哪些优缺点去技术选型" class="anchor" href="#dubbo%E6%98%AF%E6%80%8E%E4%B9%88%E5%88%B0springcloud%E7%9A%84%E5%93%AA%E4%BA%9B%E4%BC%98%E7%BC%BA%E7%82%B9%E5%8E%BB%E6%8A%80%E6%9C%AF%E9%80%89%E5%9E%8B"></a>Dubbo是怎么到SpringCloud的？哪些优缺点去技术选型</h3>&#x000A;<h4>&#x000A;<a id="目前成熟都互联网架构分布式服务治理dubbo" class="anchor" href="#%E7%9B%AE%E5%89%8D%E6%88%90%E7%86%9F%E9%83%BD%E4%BA%92%E8%81%94%E7%BD%91%E6%9E%B6%E6%9E%84%E5%88%86%E5%B8%83%E5%BC%8F%E6%9C%8D%E5%8A%A1%E6%B2%BB%E7%90%86dubbo"></a>目前成熟都互联网架构（分布式+服务治理Dubbo）</h4>&#x000A;<p><img src="/xiongrj/springcloud-base/raw/master/images%5C%E7%9B%AE%E5%89%8D%E6%88%90%E7%86%9F%E7%9A%84%E4%BA%92%E8%81%94%E7%BD%91%E6%9E%B6%E6%9E%84.png" alt="目前成熟都互联网架构（分布式+服务治理Dubbo）"></p>&#x000A;<h4>&#x000A;<a id="对比" class="anchor" href="#%E5%AF%B9%E6%AF%94"></a>对比</h4>&#x000A;<table>&#x000A;<thead>&#x000A;<tr>&#x000A;<th></th>&#x000A;<th align="center">Dubbo</th>&#x000A;<th align="center">Spring</th>&#x000A;</tr>&#x000A;</thead>&#x000A;<tbody>&#x000A;<tr>&#x000A;<td>服务注册中心</td>&#x000A;<td align="center">Zookeeper</td>&#x000A;<td align="center">Spring Cloud Netfilx Eureka</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td>服务调用方式</td>&#x000A;<td align="center">RPC</td>&#x000A;<td align="center">REST API</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td>服务监控</td>&#x000A;<td align="center">Dubbo-monitor</td>&#x000A;<td align="center">Spring Boot Admin</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td>断路器</td>&#x000A;<td align="center">不完善</td>&#x000A;<td align="center">Spring Cloud Netflix Hystrix</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td>服务网关</td>&#x000A;<td align="center">无</td>&#x000A;<td align="center">Spring Cloud Netflix Zuul</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td>分布式配置</td>&#x000A;<td align="center">无</td>&#x000A;<td align="center">Spring Cloud Config</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td>服务跟踪</td>&#x000A;<td align="center">无</td>&#x000A;<td align="center">Spring Cloud Sleuth</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td>消息总线</td>&#x000A;<td align="center">无</td>&#x000A;<td align="center">Spring Cloud Bus</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td>数据流</td>&#x000A;<td align="center">无</td>&#x000A;<td align="center">Spring Cloud Stream</td>&#x000A;</tr>&#x000A;<tr>&#x000A;<td>批量任务</td>&#x000A;<td align="center">无</td>&#x000A;<td align="center">Spring Cloud Task</td>&#x000A;</tr>&#x000A;</tbody>&#x000A;</table>&#x000A;<p><strong>最大区别：</strong></p>&#x000A;<ul>&#x000A;<li>Spring Cloud抛弃了RPC通讯，采用基于HTTP的REST方式。Spring Cloud牺牲了服务调用的性能，但是同时也避免了原生RPC带来的问题。REST比RPC更为灵活，不存在代码级别的强依赖，在强调快速演化的微服务环境下，显然更合适。</li>&#x000A;<li>==一句话：Dubbo像组装机，Spring Cloud像一体机==</li>&#x000A;<li>社区的支持与力度：Dubbo曾经停运了5年，虽然重启了，但是对于技术发展的新需求，还是需要开发者自行去拓展，对于中小型公司，显然显得比较费时费力，也不一定有强大的实力去修改源码</li>&#x000A;</ul>&#x000A;<p>####总结</p>&#x000A;<ol>&#x000A;<li>解决的问题域不一样：Dubbo的定位是一款RPC框架，Spring Cloud的目标是微服务架构下的一站式解决方案</li>&#x000A;</ol>&#x000A;<h3>&#x000A;<a id="springcloud的参考资料" class="anchor" href="#springcloud%E7%9A%84%E5%8F%82%E8%80%83%E8%B5%84%E6%96%99"></a>SpringCloud的参考资料</h3>&#x000A;<h2>&#x000A;<a id="构建springcloud工程" class="anchor" href="#%E6%9E%84%E5%BB%BAspringcloud%E5%B7%A5%E7%A8%8B"></a>构建SpringCloud工程</h2>&#x000A;<p>概述：SpringCloud工程由一个父工程和若干个Module组成</p>&#x000A;<p>==应该遵循的条件：约定 &gt; 配置 &gt; 编码==</p>&#x000A;<h3>&#x000A;<a id="resttemplate类" class="anchor" href="#resttemplate%E7%B1%BB"></a>RestTemplate类</h3>&#x000A;<h4>&#x000A;<a id="介绍" class="anchor" href="#%E4%BB%8B%E7%BB%8D"></a>介绍</h4>&#x000A;<p>RestTemplate是Spring提供的用于访问Rest服务的客户端模板工具集，提供了多种远程访问Http的方法</p>&#x000A;<h4>&#x000A;<a id="意义" class="anchor" href="#%E6%84%8F%E4%B9%89"></a>意义</h4>&#x000A;<p>在一些不涉及实现方法的模块中（消费者），只需要调用其他服务暴露出的接口即可满足的需求，使用RestTemplate类中的方法可以发出需要的HTTP请求并得到返回结果。（类似Ajax）</p>&#x000A;<h4>&#x000A;<a id="resttemplate用法" class="anchor" href="#resttemplate%E7%94%A8%E6%B3%95"></a>RestTemplate用法</h4>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="nc">RestTemplate</span> <span class="n">restTemplate</span> <span class="o">=</span> <span class="k">new</span> <span class="nc">RestTemplate</span><span class="o">();</span></span>&#x000A;<span id="LC2" class="line"><span class="c1">//url:请求地址</span></span>&#x000A;<span id="LC3" class="line"><span class="c1">//requestMap:请求参数</span></span>&#x000A;<span id="LC4" class="line"><span class="c1">//type.class:HTTP响应转换成的对象类型</span></span>&#x000A;<span id="LC5" class="line"><span class="n">restTemplate</span><span class="o">.</span><span class="na">getForObject</span><span class="o">(</span><span class="n">url</span><span class="o">,</span><span class="n">type</span><span class="o">.</span><span class="na">class</span><span class="o">);</span></span>&#x000A;<span id="LC6" class="line"><span class="n">restTemplate</span><span class="o">.</span><span class="na">postForObject</span><span class="o">(</span><span class="n">url</span><span class="o">,</span><span class="n">requestMap</span><span class="o">,</span><span class="n">type</span><span class="o">.</span><span class="na">class</span><span class="o">);</span></span></pre></div></div>&#x000A;<h3>&#x000A;<a id="构建父工程" class="anchor" href="#%E6%9E%84%E5%BB%BA%E7%88%B6%E5%B7%A5%E7%A8%8B"></a>构建父工程</h3>&#x000A;<ul>&#x000A;<li>创建一个Maven父工程并命名GAV</li>&#x000A;<li>打包方式为==POM==</li>&#x000A;<li>在pom.xml中定义各依赖的版本号（若Module中pom.xml的依赖没有指定版本号，则会根据父工程的版本号加入依赖）</li>&#x000A;<li>加入通用的依赖和插件</li>&#x000A;</ul>&#x000A;<h3>&#x000A;<a id="构建module" class="anchor" href="#%E6%9E%84%E5%BB%BAmodule"></a>构建Module</h3>&#x000A;<ul>&#x000A;<li>在父工程下新建Maven的Module，打包方式为jar</li>&#x000A;<li>一般来时GAV中 GV随父工程，自己定义A即可</li>&#x000A;<li>在该Module下pom.xml中加入其它需要的依赖</li>&#x000A;<li>正常开发即可</li>&#x000A;<li>完成后先clean一下Maven项目，然后再install提供给其它模块调用</li>&#x000A;</ul>&#x000A;<h4>&#x000A;<a id="添加其它module的依赖方法" class="anchor" href="#%E6%B7%BB%E5%8A%A0%E5%85%B6%E5%AE%83module%E7%9A%84%E4%BE%9D%E8%B5%96%E6%96%B9%E6%B3%95"></a>添加其它Module的依赖方法</h4>&#x000A;<ul>&#x000A;<li>直接引用其GAV即可</li>&#x000A;</ul>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line">    <span class="nt">&lt;dependencies&gt;</span></span>&#x000A;<span id="LC2" class="line">        <span class="nt">&lt;dependency&gt;</span></span>&#x000A;<span id="LC3" class="line">            <span class="nt">&lt;groupId&gt;</span>com.lzl<span class="nt">&lt;/groupId&gt;</span></span>&#x000A;<span id="LC4" class="line">            <span class="nt">&lt;artifactId&gt;</span>microservice-api<span class="nt">&lt;/artifactId&gt;</span></span>&#x000A;<span id="LC5" class="line">            <span class="nt">&lt;version&gt;</span>${project.version}<span class="nt">&lt;/version&gt;</span></span>&#x000A;<span id="LC6" class="line">        <span class="nt">&lt;/dependency&gt;</span></span>&#x000A;<span id="LC7" class="line">    <span class="nt">&lt;/dependencies&gt;</span></span></pre></div></div>&#x000A;<h4>&#x000A;<a id="配置该module下的yml" class="anchor" href="#%E9%85%8D%E7%BD%AE%E8%AF%A5module%E4%B8%8B%E7%9A%84yml"></a>配置该module下的yml</h4>&#x000A;<ul>&#x000A;<li>微服务需要独立的端口</li>&#x000A;<li>==微服务最重要的是取名字！！！！一定要给微服务配置一个名字！这个名字就是这个微服务对外暴露的名字！==</li>&#x000A;<li>配置该模块下的其它相关配置（如本例配置了mybatis）</li>&#x000A;</ul>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="na">server</span><span class="pi">:</span></span>&#x000A;<span id="LC2" class="line">  <span class="na">port</span><span class="pi">:</span> <span class="m">8001</span></span>&#x000A;<span id="LC3" class="line"></span>&#x000A;<span id="LC4" class="line"><span class="na">mybatis</span><span class="pi">:</span></span>&#x000A;<span id="LC5" class="line">  <span class="na">config-location</span><span class="pi">:</span> <span class="s">classpath:mybatis/mybatis.cfg.xml</span></span>&#x000A;<span id="LC6" class="line">  <span class="na">type-aliases-package</span><span class="pi">:</span> <span class="s">com.XXX.entity</span></span>&#x000A;<span id="LC7" class="line">  <span class="na">mapper-locations</span><span class="pi">:</span></span>&#x000A;<span id="LC8" class="line">  <span class="pi">-</span> <span class="s">classpath:mybatis/mapper/**/*.xml</span></span>&#x000A;<span id="LC9" class="line"><span class="na">spring</span><span class="pi">:</span></span>&#x000A;<span id="LC10" class="line">  <span class="na">application</span><span class="pi">:</span></span>&#x000A;<span id="LC11" class="line">    <span class="na">name</span><span class="pi">:</span> <span class="s">microservicecloud-dept</span>   <span class="c1">#为这个服务取名，非常重要！！！！！</span></span>&#x000A;<span id="LC12" class="line">  <span class="na">datasource</span><span class="pi">:</span></span>&#x000A;<span id="LC13" class="line">    <span class="na">type</span><span class="pi">:</span> <span class="s">com.alibaba.druid.pool.DruidDataSource</span></span>&#x000A;<span id="LC14" class="line">    <span class="na">driver-class-name</span><span class="pi">:</span> <span class="s">org.gjt.mm.mysql.Driver</span></span>&#x000A;<span id="LC15" class="line">    <span class="na">url</span><span class="pi">:</span> <span class="s">jdbc:mysql://localhost:3306/cloudDB01</span></span>&#x000A;<span id="LC16" class="line">    <span class="na">username</span><span class="pi">:</span> <span class="s">root</span></span>&#x000A;<span id="LC17" class="line">    <span class="na">password</span><span class="pi">:</span> <span class="m">123456</span></span>&#x000A;<span id="LC18" class="line">    <span class="na">dbcp2</span><span class="pi">:</span></span>&#x000A;<span id="LC19" class="line">      <span class="na">min-idle</span><span class="pi">:</span> <span class="m">5</span>         <span class="c1">#最小连接数</span></span>&#x000A;<span id="LC20" class="line">      <span class="na">initial-size</span><span class="pi">:</span> <span class="m">5</span>    <span class="c1">#初始化连接数</span></span>&#x000A;<span id="LC21" class="line">      <span class="na">max-total</span><span class="pi">:</span> <span class="m">10</span>      <span class="c1">#最大连接数</span></span>&#x000A;<span id="LC22" class="line">      <span class="na">max-wait-millis</span><span class="pi">:</span> <span class="m">200</span>    <span class="c1">#等待连接最长的超时时间</span></span>&#x000A;<span id="LC23" class="line"></span></pre></div></div>&#x000A;<h4>&#x000A;<a id="编写主启动类" class="anchor" href="#%E7%BC%96%E5%86%99%E4%B8%BB%E5%90%AF%E5%8A%A8%E7%B1%BB"></a>编写主启动类</h4>&#x000A;<ul>&#x000A;<li>记得主启动类放在根包下,com.xxx.xxx</li>&#x000A;</ul>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="kn">package</span> <span class="n">com</span><span class="o">.</span><span class="na">XXX</span><span class="o">;</span></span>&#x000A;<span id="LC2" class="line"></span>&#x000A;<span id="LC3" class="line"><span class="kn">import</span> <span class="nn">org.springframework.boot.SpringApplication</span><span class="o">;</span></span>&#x000A;<span id="LC4" class="line"><span class="kn">import</span> <span class="nn">org.springframework.boot.autoconfigure.SpringBootApplication</span><span class="o">;</span></span>&#x000A;<span id="LC5" class="line"></span>&#x000A;<span id="LC6" class="line"><span class="nd">@SpringBootApplication</span></span>&#x000A;<span id="LC7" class="line"><span class="kd">public</span> <span class="kd">class</span> <span class="nc">Provider8001_APP</span> <span class="o">{</span></span>&#x000A;<span id="LC8" class="line">    <span class="kd">public</span> <span class="kd">static</span> <span class="kt">void</span> <span class="nf">main</span><span class="o">(</span><span class="nc">String</span><span class="o">[]</span> <span class="n">args</span><span class="o">)</span> <span class="o">{</span></span>&#x000A;<span id="LC9" class="line">        <span class="nc">SpringApplication</span><span class="o">.</span><span class="na">run</span><span class="o">(</span><span class="n">Provider8001_APP</span><span class="o">.</span><span class="na">class</span><span class="o">,</span><span class="n">args</span><span class="o">);</span></span>&#x000A;<span id="LC10" class="line">    <span class="o">}</span></span>&#x000A;<span id="LC11" class="line"><span class="o">}</span></span></pre></div></div>&#x000A;<h2>&#x000A;<a id="springcloud添加组件的基本套路" class="anchor" href="#springcloud%E6%B7%BB%E5%8A%A0%E7%BB%84%E4%BB%B6%E7%9A%84%E5%9F%BA%E6%9C%AC%E5%A5%97%E8%B7%AF"></a>SpringCloud添加组件的基本套路</h2>&#x000A;<ol>&#x000A;<li>新增这个组件的maven坐标GAV</li>&#x000A;<li>在启动类上面标注启动该组件（一般来说是@EnableXXXXX）</li>&#x000A;<li>编写业务逻辑代码</li>&#x000A;</ol>&#x000A;<h2>&#x000A;<a id="eureka服务注册与发现" class="anchor" href="#eureka%E6%9C%8D%E5%8A%A1%E6%B3%A8%E5%86%8C%E4%B8%8E%E5%8F%91%E7%8E%B0"></a>Eureka服务注册与发现</h2>&#x000A;<h3>&#x000A;<a id="eureka介绍及原理" class="anchor" href="#eureka%E4%BB%8B%E7%BB%8D%E5%8F%8A%E5%8E%9F%E7%90%86"></a>Eureka介绍及原理</h3>&#x000A;<h4>&#x000A;<a id="理解" class="anchor" href="#%E7%90%86%E8%A7%A3"></a>理解</h4>&#x000A;<p>==Eureka就像一个物业管理公司，其他微服务就像小区的住户，每个住户入住时都要向物业管理公司注册，并定时向物业公司交管理费==</p>&#x000A;<h4>&#x000A;<a id="介绍-1" class="anchor" href="#%E4%BB%8B%E7%BB%8D-1"></a>介绍</h4>&#x000A;<ul>&#x000A;<li>Eureka是一个基于REST的服务，用于定位服务，以实现云端中间层服务发现和故障转移。</li>&#x000A;<li>Eureka主管服务注册与发现，在微服务中，以后了这两者，只需要使用服务的标识符（==就是那个在每个服务的yml文件中取得服务名称==），就可以访问到服务，不需要修改服务调用的配置文件</li>&#x000A;<li>Eureka遵循AP原则（高可用，分区容错性），因为使用了自我保护机制所以保证了高可用</li>&#x000A;</ul>&#x000A;<h4>&#x000A;<a id="原理" class="anchor" href="#%E5%8E%9F%E7%90%86"></a>原理</h4>&#x000A;<ul>&#x000A;<li>Eureka使用的是C-S结构（客户端-服务端）</li>&#x000A;<li>两大组件：Eureka Server（提供注册服务）、 Eureka Client（JAVA客户端，负责发送心跳）</li>&#x000A;<li>系统中的其他微服务使用Eureka客户端连接到Eureka服务端维持心跳连接（即注册）。SpringCloud的其他模块可以通过Eureka Server 来发现系统中的微服务并加以调用</li>&#x000A;</ul>&#x000A;<p><img src="/xiongrj/springcloud-base/raw/master/images%5CEureka%E7%9A%84%E6%9E%B6%E6%9E%84%E5%9B%BE.png" alt="Eureka的架构图"></p>&#x000A;<h3>&#x000A;<a id="eureka服务注册中心构建" class="anchor" href="#eureka%E6%9C%8D%E5%8A%A1%E6%B3%A8%E5%86%8C%E4%B8%AD%E5%BF%83%E6%9E%84%E5%BB%BA"></a>Eureka服务注册中心构建</h3>&#x000A;<h4>&#x000A;<a id="加入服务端依赖" class="anchor" href="#%E5%8A%A0%E5%85%A5%E6%9C%8D%E5%8A%A1%E7%AB%AF%E4%BE%9D%E8%B5%96"></a>加入服务端依赖</h4>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="nt">&lt;dependency&gt;</span></span>&#x000A;<span id="LC2" class="line">            <span class="nt">&lt;groupId&gt;</span>org.springframework.cloud<span class="nt">&lt;/groupId&gt;</span></span>&#x000A;<span id="LC3" class="line">            <span class="nt">&lt;artifactId&gt;</span>spring-cloud-starter-eureka-server<span class="nt">&lt;/artifactId&gt;</span></span>&#x000A;<span id="LC4" class="line">        <span class="nt">&lt;/dependency&gt;</span></span></pre></div></div>&#x000A;<h4>&#x000A;<a id="配置yml" class="anchor" href="#%E9%85%8D%E7%BD%AEyml"></a>配置yml</h4>&#x000A;<ul>&#x000A;<li>==理解：物业公司肯定不向自己注册自己，并肯定知道自己在哪，不用参加检索==</li>&#x000A;</ul>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="na">server</span><span class="pi">:</span></span>&#x000A;<span id="LC2" class="line">  <span class="na">port</span><span class="pi">:</span> <span class="m">7001</span></span>&#x000A;<span id="LC3" class="line"><span class="na">eureka</span><span class="pi">:</span></span>&#x000A;<span id="LC4" class="line">  <span class="na">instance</span><span class="pi">:</span></span>&#x000A;<span id="LC5" class="line">    <span class="na">hostname</span><span class="pi">:</span> <span class="s">localhost</span></span>&#x000A;<span id="LC6" class="line">  <span class="na">client</span><span class="pi">:</span></span>&#x000A;<span id="LC7" class="line">    <span class="na">register-with-eureka</span><span class="pi">:</span> <span class="no">false</span>     <span class="c1">#false表示不向注册中心注册自己</span></span>&#x000A;<span id="LC8" class="line">    <span class="na">fetch-registry</span><span class="pi">:</span> <span class="no">false</span>           <span class="c1">#false表示自己就是注册中心，职责是维护实例，不参加检索</span></span>&#x000A;<span id="LC9" class="line">    <span class="na">service-url</span><span class="pi">:</span></span>&#x000A;<span id="LC10" class="line">      <span class="na">defaultZone</span><span class="pi">:</span> <span class="s">http://${eureka.instance.hostname}:${server.port}/eureka/</span>    <span class="c1">#设置eureka server的交互地址，即对外暴露的地址</span></span></pre></div></div>&#x000A;<h4>&#x000A;<a id="添加启动类" class="anchor" href="#%E6%B7%BB%E5%8A%A0%E5%90%AF%E5%8A%A8%E7%B1%BB"></a>添加启动类</h4>&#x000A;<ul>&#x000A;<li>==注意：要在类前加@EnableEurekaServer标注==</li>&#x000A;</ul>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="kn">package</span> <span class="n">com</span><span class="o">.</span><span class="na">XXX</span><span class="o">;</span></span>&#x000A;<span id="LC2" class="line"></span>&#x000A;<span id="LC3" class="line"><span class="kn">import</span> <span class="nn">org.springframework.boot.SpringApplication</span><span class="o">;</span></span>&#x000A;<span id="LC4" class="line"><span class="kn">import</span> <span class="nn">org.springframework.boot.autoconfigure.SpringBootApplication</span><span class="o">;</span></span>&#x000A;<span id="LC5" class="line"><span class="kn">import</span> <span class="nn">org.springframework.cloud.netflix.eureka.server.EnableEurekaServer</span><span class="o">;</span></span>&#x000A;<span id="LC6" class="line"></span>&#x000A;<span id="LC7" class="line"><span class="nd">@SpringBootApplication</span></span>&#x000A;<span id="LC8" class="line"><span class="nd">@EnableEurekaServer</span></span>&#x000A;<span id="LC9" class="line"><span class="kd">public</span> <span class="kd">class</span> <span class="nc">Eureka7001_APP</span> <span class="o">{</span></span>&#x000A;<span id="LC10" class="line">    <span class="kd">public</span> <span class="kd">static</span> <span class="kt">void</span> <span class="nf">main</span><span class="o">(</span><span class="nc">String</span><span class="o">[]</span> <span class="n">args</span><span class="o">)</span> <span class="o">{</span></span>&#x000A;<span id="LC11" class="line">        <span class="nc">SpringApplication</span><span class="o">.</span><span class="na">run</span><span class="o">(</span><span class="n">Eureka7001_APP</span><span class="o">.</span><span class="na">class</span><span class="o">,</span><span class="n">args</span><span class="o">);</span></span>&#x000A;<span id="LC12" class="line">    <span class="o">}</span></span>&#x000A;<span id="LC13" class="line"><span class="o">}</span></span></pre></div></div>&#x000A;<h4>&#x000A;<a id="验证是否构建成功" class="anchor" href="#%E9%AA%8C%E8%AF%81%E6%98%AF%E5%90%A6%E6%9E%84%E5%BB%BA%E6%88%90%E5%8A%9F"></a>验证是否构建成功</h4>&#x000A;<p>启动主程序，访问该服务地址即可</p>&#x000A;<h3>&#x000A;<a id="向eureka注册中心注册微服务" class="anchor" href="#%E5%90%91eureka%E6%B3%A8%E5%86%8C%E4%B8%AD%E5%BF%83%E6%B3%A8%E5%86%8C%E5%BE%AE%E6%9C%8D%E5%8A%A1"></a>向Eureka注册中心注册微服务</h3>&#x000A;<h4>&#x000A;<a id="增加依赖" class="anchor" href="#%E5%A2%9E%E5%8A%A0%E4%BE%9D%E8%B5%96"></a>增加依赖</h4>&#x000A;<p>在要注册的微服务的pom.xml文件中增加依赖</p>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line">		<span class="nt">&lt;dependency&gt;</span></span>&#x000A;<span id="LC2" class="line">            <span class="nt">&lt;groupId&gt;</span>org.springframework.cloud<span class="nt">&lt;/groupId&gt;</span></span>&#x000A;<span id="LC3" class="line">            <span class="nt">&lt;artifactId&gt;</span>spring-cloud-starter-eureka<span class="nt">&lt;/artifactId&gt;</span></span>&#x000A;<span id="LC4" class="line">        <span class="nt">&lt;/dependency&gt;</span></span>&#x000A;<span id="LC5" class="line">        <span class="nt">&lt;dependency&gt;</span></span>&#x000A;<span id="LC6" class="line">            <span class="nt">&lt;groupId&gt;</span>org.springframework.cloud<span class="nt">&lt;/groupId&gt;</span></span>&#x000A;<span id="LC7" class="line">            <span class="nt">&lt;artifactId&gt;</span>spring-cloud-starter-config<span class="nt">&lt;/artifactId&gt;</span></span>&#x000A;<span id="LC8" class="line">        <span class="nt">&lt;/dependency&gt;</span>	</span></pre></div></div>&#x000A;<h4>&#x000A;<a id="修改yml" class="anchor" href="#%E4%BF%AE%E6%94%B9yml"></a>修改yml</h4>&#x000A;<ul>&#x000A;<li>在application.yml中增加以内容，将客户端注册到服务列表内</li>&#x000A;<li>==理解：小区用户要找到物业管理处的地址进行注册==</li>&#x000A;</ul>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="na">eureka</span><span class="pi">:</span></span>&#x000A;<span id="LC2" class="line">  <span class="na">client</span><span class="pi">:</span></span>&#x000A;<span id="LC3" class="line">    <span class="na">service-url</span><span class="pi">:</span></span>&#x000A;<span id="LC4" class="line">      <span class="na">defaultZone</span><span class="pi">:</span> <span class="s">http://localhost:7001/eureka</span></span></pre></div></div>&#x000A;<h4>&#x000A;<a id="主启动类增加注解" class="anchor" href="#%E4%B8%BB%E5%90%AF%E5%8A%A8%E7%B1%BB%E5%A2%9E%E5%8A%A0%E6%B3%A8%E8%A7%A3"></a>主启动类增加注解</h4>&#x000A;<ul>&#x000A;<li>增加@EnableEurekaClient注解</li>&#x000A;</ul>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="nd">@SpringBootApplication</span></span>&#x000A;<span id="LC2" class="line"><span class="nd">@EnableEurekaClient</span></span>&#x000A;<span id="LC3" class="line"><span class="kd">public</span> <span class="kd">class</span> <span class="nc">Provider8001_APP</span> <span class="o">{</span></span>&#x000A;<span id="LC4" class="line">    <span class="kd">public</span> <span class="kd">static</span> <span class="kt">void</span> <span class="nf">main</span><span class="o">(</span><span class="nc">String</span><span class="o">[]</span> <span class="n">args</span><span class="o">)</span> <span class="o">{</span></span>&#x000A;<span id="LC5" class="line">        <span class="nc">SpringApplication</span><span class="o">.</span><span class="na">run</span><span class="o">(</span><span class="n">Provider8001_APP</span><span class="o">.</span><span class="na">class</span><span class="o">,</span><span class="n">args</span><span class="o">);</span></span>&#x000A;<span id="LC6" class="line">    <span class="o">}</span></span>&#x000A;<span id="LC7" class="line"><span class="o">}</span></span></pre></div></div>&#x000A;<h3>&#x000A;<a id="actuator与微服务注册完善" class="anchor" href="#actuator%E4%B8%8E%E5%BE%AE%E6%9C%8D%E5%8A%A1%E6%B3%A8%E5%86%8C%E5%AE%8C%E5%96%84"></a>actuator与微服务注册完善</h3>&#x000A;<h4>&#x000A;<a id="主机名称与服务名称的修改" class="anchor" href="#%E4%B8%BB%E6%9C%BA%E5%90%8D%E7%A7%B0%E4%B8%8E%E6%9C%8D%E5%8A%A1%E5%90%8D%E7%A7%B0%E7%9A%84%E4%BF%AE%E6%94%B9"></a>主机名称与服务名称的修改</h4>&#x000A;<ul>&#x000A;<li>修改服务名称，在yml中eureka节点下添加如下内容</li>&#x000A;</ul>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"> <span class="na">eureka</span><span class="pi">:</span></span>&#x000A;<span id="LC2" class="line">  <span class="na">instance</span><span class="pi">:</span></span>&#x000A;<span id="LC3" class="line">    <span class="na">instance-id</span><span class="pi">:</span> <span class="s">dept8001</span><span class="err">		</span><span class="s">#修改别名</span></span>&#x000A;<span id="LC4" class="line">    <span class="na">prefer-ip-address</span><span class="pi">:</span> <span class="no">true</span><span class="err">		</span><span class="s">#显示IP地址</span></span></pre></div></div>&#x000A;<h4>&#x000A;<a id="info内容的详细信息修改" class="anchor" href="#info%E5%86%85%E5%AE%B9%E7%9A%84%E8%AF%A6%E7%BB%86%E4%BF%A1%E6%81%AF%E4%BF%AE%E6%94%B9"></a>info内容的详细信息修改</h4>&#x000A;<h5>&#x000A;<a id="作用" class="anchor" href="#%E4%BD%9C%E7%94%A8"></a>作用</h5>&#x000A;<p>在查看Eureka时点击进入某个微服务的info时，能给查看者一些必要的信息，可以帮助查看者快速的了解该微服务，开发中十分有意义。</p>&#x000A;<h5>&#x000A;<a id="修改方法" class="anchor" href="#%E4%BF%AE%E6%94%B9%E6%96%B9%E6%B3%95"></a>修改方法</h5>&#x000A;<ol>&#x000A;<li>==当前工程==添加依赖</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line">        <span class="nt">&lt;dependency&gt;</span></span>&#x000A;<span id="LC2" class="line">            <span class="nt">&lt;groupId&gt;</span>org.springframework.boot<span class="nt">&lt;/groupId&gt;</span></span>&#x000A;<span id="LC3" class="line">            <span class="nt">&lt;artifactId&gt;</span>spring-boot-starter-actuator<span class="nt">&lt;/artifactId&gt;</span></span>&#x000A;<span id="LC4" class="line">        <span class="nt">&lt;/dependency&gt;</span></span></pre></div></div>&#x000A;<ol start="2">&#x000A;<li>==总的父工程==的build节点下添加如下内容</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="nt">&lt;build&gt;</span></span>&#x000A;<span id="LC2" class="line">        <span class="nt">&lt;finalName&gt;</span>microservicecloud<span class="nt">&lt;/finalName&gt;</span></span>&#x000A;<span id="LC3" class="line">        <span class="nt">&lt;resources&gt;</span></span>&#x000A;<span id="LC4" class="line">            <span class="nt">&lt;resource&gt;</span></span>&#x000A;<span id="LC5" class="line">             	<span class="c">&lt;!--允许扫描该路径下的资源文件--&gt;</span></span>&#x000A;<span id="LC6" class="line">                <span class="nt">&lt;directory&gt;</span>src/main/resources<span class="nt">&lt;/directory&gt;</span></span>&#x000A;<span id="LC7" class="line">                <span class="nt">&lt;filtering&gt;</span>true<span class="nt">&lt;/filtering&gt;</span></span>&#x000A;<span id="LC8" class="line">            <span class="nt">&lt;/resource&gt;</span></span>&#x000A;<span id="LC9" class="line">        <span class="nt">&lt;/resources&gt;</span></span>&#x000A;<span id="LC10" class="line">        <span class="nt">&lt;plugins&gt;</span></span>&#x000A;<span id="LC11" class="line">            <span class="nt">&lt;plugin&gt;</span></span>&#x000A;<span id="LC12" class="line">                <span class="nt">&lt;groupId&gt;</span>org.apache.maven.plugins<span class="nt">&lt;/groupId&gt;</span></span>&#x000A;<span id="LC13" class="line">                <span class="nt">&lt;artifactId&gt;</span>maven-resources-plugin<span class="nt">&lt;/artifactId&gt;</span></span>&#x000A;<span id="LC14" class="line">                <span class="nt">&lt;configuration&gt;</span></span>&#x000A;<span id="LC15" class="line">                    <span class="nt">&lt;delimiters&gt;</span></span>&#x000A;<span id="LC16" class="line">                     	<span class="c">&lt;!--指定动态获取以$标志开头结尾的信息--&gt;</span></span>&#x000A;<span id="LC17" class="line">                        <span class="nt">&lt;delimit&gt;</span>$<span class="nt">&lt;/delimit&gt;</span></span>&#x000A;<span id="LC18" class="line">                    <span class="nt">&lt;/delimiters&gt;</span></span>&#x000A;<span id="LC19" class="line">                <span class="nt">&lt;/configuration&gt;</span></span>&#x000A;<span id="LC20" class="line">            <span class="nt">&lt;/plugin&gt;</span></span>&#x000A;<span id="LC21" class="line">        <span class="nt">&lt;/plugins&gt;</span></span>&#x000A;<span id="LC22" class="line">    <span class="nt">&lt;/build&gt;</span></span></pre></div></div>&#x000A;<ol start="3">&#x000A;<li>在==当前工程== 的application.yml文件添加回显信息</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="na">info</span><span class="pi">:</span></span>&#x000A;<span id="LC2" class="line">  <span class="na">author</span><span class="pi">:</span> <span class="s">XXX</span></span>&#x000A;<span id="LC3" class="line">  <span class="na">build-version</span><span class="pi">:</span> <span class="s">$project.version$</span></span></pre></div></div>&#x000A;<h3>&#x000A;<a id="eureka的自我保护" class="anchor" href="#eureka%E7%9A%84%E8%87%AA%E6%88%91%E4%BF%9D%E6%8A%A4"></a>Eureka的自我保护</h3>&#x000A;<h4>&#x000A;<a id="介绍-2" class="anchor" href="#%E4%BB%8B%E7%BB%8D-2"></a>介绍</h4>&#x000A;<p>Eureka的自我保护机制主要是为了网络异常时保持高可用设计的，当在Eureka中注册的微服务超过设定是时间内（默认90秒）没有向Eureka服务端发送心跳，该微服务会进入自我保护模式。在自我保护模式中，Eureka会保护服务注册表中的信息，不会注销任何服务实例，直至收到的心跳数恢复至阈值以上，该微服务退出自我保护模式。</p>&#x000A;<h4>&#x000A;<a id="理解-1" class="anchor" href="#%E7%90%86%E8%A7%A3-1"></a>理解</h4>&#x000A;<p>好死不如赖活：Eureka的设计哲学是宁可保留错误的服务信息，也不盲目注销可能健康的服务。所以异常的服务不会被注销，而是进入了自我保护模式。</p>&#x000A;<h4>&#x000A;<a id="自我保护模式的开关" class="anchor" href="#%E8%87%AA%E6%88%91%E4%BF%9D%E6%8A%A4%E6%A8%A1%E5%BC%8F%E7%9A%84%E5%BC%80%E5%85%B3"></a>自我保护模式的开关</h4>&#x000A;<p>在Eureka Server模块下的yml文件中添加配置信息即可，true表示打开自我保护模式；false表示关闭自我保护模式（不推荐）</p>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line">  <span class="nl">server:</span></span>&#x000A;<span id="LC2" class="line">    <span class="n">enable</span><span class="o">-</span><span class="n">self</span><span class="o">-</span><span class="nl">preservation:</span> <span class="kc">false</span></span></pre></div></div>&#x000A;<h3>&#x000A;<a id="eureka的服务发现" class="anchor" href="#eureka%E7%9A%84%E6%9C%8D%E5%8A%A1%E5%8F%91%E7%8E%B0"></a>Eureka的服务发现</h3>&#x000A;<h4>&#x000A;<a id="介绍-3" class="anchor" href="#%E4%BB%8B%E7%BB%8D-3"></a>介绍</h4>&#x000A;<p>系统中的微服务可以通过Eureka的服务发现去获得在Eureka中注册的服务的信息，这是一个对外暴露的接口。</p>&#x000A;<h4>&#x000A;<a id="使用方法provider中" class="anchor" href="#%E4%BD%BF%E7%94%A8%E6%96%B9%E6%B3%95provider%E4%B8%AD"></a>使用方法（provider中）</h4>&#x000A;<ol>&#x000A;<li>注入DiscoveryClient 对象（spring包下的），在controller方法中获取</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="nd">@Autowired</span></span>&#x000A;<span id="LC2" class="line"><span class="kd">private</span> <span class="nc">DiscoveryClient</span> <span class="n">discoveryClient</span><span class="o">;</span>    </span>&#x000A;<span id="LC3" class="line"></span>&#x000A;<span id="LC4" class="line"><span class="nd">@ResponseBody</span></span>&#x000A;<span id="LC5" class="line"><span class="nd">@GetMapping</span><span class="o">(</span><span class="s">"/provider/discovery"</span><span class="o">)</span></span>&#x000A;<span id="LC6" class="line"><span class="kd">public</span> <span class="nc">Object</span> <span class="nf">discovery</span><span class="o">(){</span></span>&#x000A;<span id="LC7" class="line">        <span class="nc">List</span><span class="o">&lt;</span><span class="nc">String</span><span class="o">&gt;</span> <span class="n">list</span> <span class="o">=</span> <span class="n">discoveryClient</span><span class="o">.</span><span class="na">getServices</span><span class="o">();</span></span>&#x000A;<span id="LC8" class="line">        <span class="nc">System</span><span class="o">.</span><span class="na">out</span><span class="o">.</span><span class="na">println</span><span class="o">(</span><span class="n">list</span><span class="o">);</span></span>&#x000A;<span id="LC9" class="line">        <span class="nc">List</span><span class="o">&lt;</span><span class="nc">ServiceInstance</span><span class="o">&gt;</span> <span class="n">insList</span> <span class="o">=</span> <span class="n">discoveryClient</span><span class="o">.</span><span class="na">getInstances</span><span class="o">(</span><span class="s">"MICROSERVICECLOUD-DEPT"</span><span class="o">);</span></span>&#x000A;<span id="LC10" class="line">        <span class="k">for</span> <span class="o">(</span><span class="nc">ServiceInstance</span> <span class="nl">si:</span><span class="n">insList</span><span class="o">)</span> <span class="o">{</span></span>&#x000A;<span id="LC11" class="line">            <span class="nc">System</span><span class="o">.</span><span class="na">out</span><span class="o">.</span><span class="na">println</span><span class="o">(</span><span class="n">si</span><span class="o">.</span><span class="na">getHost</span><span class="o">()</span> <span class="o">+</span><span class="s">","</span> <span class="o">+</span> <span class="n">si</span><span class="o">.</span><span class="na">getServiceId</span><span class="o">()</span> <span class="o">+</span><span class="s">","</span> <span class="o">+</span><span class="n">si</span><span class="o">.</span><span class="na">getPort</span><span class="o">()</span> <span class="o">+</span><span class="s">","</span> <span class="o">+</span><span class="n">si</span><span class="o">.</span><span class="na">getUri</span><span class="o">()</span> <span class="o">+</span><span class="s">","</span> <span class="o">+</span><span class="n">si</span><span class="o">.</span><span class="na">getMetadata</span><span class="o">());</span></span>&#x000A;<span id="LC12" class="line">        <span class="o">}</span></span>&#x000A;<span id="LC13" class="line">        <span class="k">return</span> <span class="k">this</span><span class="o">.</span><span class="na">discoveryClient</span><span class="o">;</span></span>&#x000A;<span id="LC14" class="line">    <span class="o">}</span></span></pre></div></div>&#x000A;<ol start="2">&#x000A;<li>在主启动类中加入@EnableDiscoveryClient注解</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="nd">@SpringBootApplication</span></span>&#x000A;<span id="LC2" class="line"><span class="nd">@EnableEurekaClient</span></span>&#x000A;<span id="LC3" class="line"><span class="nd">@EnableDiscoveryClient</span></span>&#x000A;<span id="LC4" class="line"><span class="kd">public</span> <span class="kd">class</span> <span class="nc">Provider8001_APP</span> <span class="o">{</span></span>&#x000A;<span id="LC5" class="line">    <span class="kd">public</span> <span class="kd">static</span> <span class="kt">void</span> <span class="nf">main</span><span class="o">(</span><span class="nc">String</span><span class="o">[]</span> <span class="n">args</span><span class="o">)</span> <span class="o">{</span></span>&#x000A;<span id="LC6" class="line">        <span class="nc">SpringApplication</span><span class="o">.</span><span class="na">run</span><span class="o">(</span><span class="n">Provider8001_APP</span><span class="o">.</span><span class="na">class</span><span class="o">,</span><span class="n">args</span><span class="o">);</span></span>&#x000A;<span id="LC7" class="line">    <span class="o">}</span></span>&#x000A;<span id="LC8" class="line"><span class="o">}</span></span></pre></div></div>&#x000A;<h4>&#x000A;<a id="使用方法consumer中" class="anchor" href="#%E4%BD%BF%E7%94%A8%E6%96%B9%E6%B3%95consumer%E4%B8%AD"></a>使用方法（consumer中）</h4>&#x000A;<p>在controller方法中使用restTemplate对象调用provider中暴露的URL 并获得返回对象即可</p>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="nd">@GetMapping</span><span class="o">(</span><span class="s">"/discovery"</span><span class="o">)</span></span>&#x000A;<span id="LC2" class="line"><span class="kd">public</span> <span class="nc">Object</span> <span class="nf">discovery</span><span class="o">()</span> <span class="o">{</span></span>&#x000A;<span id="LC3" class="line">        <span class="k">return</span> <span class="n">restTemplate</span><span class="o">.</span><span class="na">getForObject</span><span class="o">(</span><span class="no">URL_PREFIX</span><span class="o">+</span><span class="s">"/provider/discovery"</span><span class="o">,</span><span class="nc">Object</span><span class="o">.</span><span class="na">class</span><span class="o">);</span></span>&#x000A;<span id="LC4" class="line">    <span class="o">}</span></span></pre></div></div>&#x000A;<h3>&#x000A;<a id="eureka的集群配置" class="anchor" href="#eureka%E7%9A%84%E9%9B%86%E7%BE%A4%E9%85%8D%E7%BD%AE"></a>Eureka的集群配置</h3>&#x000A;<h4>&#x000A;<a id="集群" class="anchor" href="#%E9%9B%86%E7%BE%A4"></a>集群</h4>&#x000A;<p>集群就是在不同的机器上配置相同的服务来构建要一个大的运算整体</p>&#x000A;<h4>&#x000A;<a id="实现集群" class="anchor" href="#%E5%AE%9E%E7%8E%B0%E9%9B%86%E7%BE%A4"></a>实现集群</h4>&#x000A;<ol>&#x000A;<li>新建N个Eureka Server模块</li>&#x000A;<li>每个模块的pom.xml中加入与单个Eureka Server相同的依赖</li>&#x000A;<li>每个模块加入主程序（记得加@EnableEurekaServer注解）</li>&#x000A;<li>修改hosts文件（Win7的路径是C:\Windows\System32\drivers\etc）</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line">127.0.0.1 eureka7001.com</span>&#x000A;<span id="LC2" class="line">127.0.0.1 eureka7002.com</span>&#x000A;<span id="LC3" class="line">127.0.0.1 eureka7003.com</span></pre></div></div>&#x000A;<ol start="5">&#x000A;<li>修改Eureka Server模块的application.yml文件，加入集群，主要修改两个地方：</li>&#x000A;</ol>&#x000A;<ul>&#x000A;<li>hostname：修改为hosts文件中映射的地址</li>&#x000A;<li>service-url下的defaultZone节点：填入集群中另外的server服务端的地址</li>&#x000A;</ul>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="na">server</span><span class="pi">:</span></span>&#x000A;<span id="LC2" class="line">  <span class="na">port</span><span class="pi">:</span> <span class="m">7001</span></span>&#x000A;<span id="LC3" class="line"><span class="na">eureka</span><span class="pi">:</span></span>&#x000A;<span id="LC4" class="line">  <span class="na">instance</span><span class="pi">:</span></span>&#x000A;<span id="LC5" class="line">    <span class="na">hostname</span><span class="pi">:</span> <span class="s">eureka7001.com</span>    <span class="c1">#hostname为hosts文件中映射的地址</span></span>&#x000A;<span id="LC6" class="line">  <span class="na">client</span><span class="pi">:</span></span>&#x000A;<span id="LC7" class="line">    <span class="na">register-with-eureka</span><span class="pi">:</span> <span class="no">false</span>     <span class="c1">#false表示不向注册中心注册自己</span></span>&#x000A;<span id="LC8" class="line">    <span class="na">fetch-registry</span><span class="pi">:</span> <span class="no">false</span>           <span class="c1">#false表示自己就是注册中心，职责是维护实例，不参加检索</span></span>&#x000A;<span id="LC9" class="line">    <span class="na">service-url</span><span class="pi">:</span></span>&#x000A;<span id="LC10" class="line">      <span class="c1">#defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/    #设置eureka server的交互地址</span></span>&#x000A;<span id="LC11" class="line">      <span class="na">defaultZone</span><span class="pi">:</span> <span class="s">http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/</span>  <span class="c1">#其他两个服务端的地址</span></span></pre></div></div>&#x000A;<ol start="6">&#x000A;<li>修改Eureka Client模块的application.yml文件，使其向集群注册服务</li>&#x000A;</ol>&#x000A;<ul>&#x000A;<li>service-url下的defaultZone节点：填入集群中需要向其注册server服务端的地址</li>&#x000A;</ul>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="na">eureka</span><span class="pi">:</span></span>&#x000A;<span id="LC2" class="line">  <span class="na">client</span><span class="pi">:</span></span>&#x000A;<span id="LC3" class="line">    <span class="na">service-url</span><span class="pi">:</span></span>&#x000A;<span id="LC4" class="line">      <span class="na">defaultZone</span><span class="pi">:</span> <span class="s">http://eureka7001.com:7001/eureka,http://eureka7002.com:7002/eureka,http://eureka7003.com:7003/eureka</span></span></pre></div></div>&#x000A;<ol start="7">&#x000A;<li>访问地址</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line">http://eureka7001.com:7001</span>&#x000A;<span id="LC2" class="line">http://eureka7002.com:7002</span>&#x000A;<span id="LC3" class="line">http://eureka7003.com:7003</span></pre></div></div>&#x000A;<ol start="8">&#x000A;<li>==注：defaultZone中eureka/后缀是必须的，如果删除，Server类不会报错，但是Client注册时会报404错误==</li>&#x000A;</ol>&#x000A;<h3>&#x000A;<a id="eureka与zookeeper对比" class="anchor" href="#eureka%E4%B8%8Ezookeeper%E5%AF%B9%E6%AF%94"></a>Eureka与Zookeeper对比</h3>&#x000A;<h4>&#x000A;<a id="cap设计原则不同" class="anchor" href="#cap%E8%AE%BE%E8%AE%A1%E5%8E%9F%E5%88%99%E4%B8%8D%E5%90%8C"></a>CAP设计原则不同</h4>&#x000A;<p>Eureka遵守AP，Zookeeper遵守CP（C：强一致性，A：高可用，P：分区容错性，三者只能选其二，高并发下P必选）</p>&#x000A;<h4>&#x000A;<a id="网络波动下两者的处理对比" class="anchor" href="#%E7%BD%91%E7%BB%9C%E6%B3%A2%E5%8A%A8%E4%B8%8B%E4%B8%A4%E8%80%85%E7%9A%84%E5%A4%84%E7%90%86%E5%AF%B9%E6%AF%94"></a>网络波动下两者的处理对比</h4>&#x000A;<table>&#x000A;<thead>&#x000A;<tr>&#x000A;<th align="left">Zookeeper</th>&#x000A;<th>Eureka</th>&#x000A;</tr>&#x000A;</thead>&#x000A;<tbody>&#x000A;<tr>&#x000A;<td align="left">当网络出现故障时，剩余zk集群会发起投票选举新的leader，但是此过程会持续30~120s，此过程对于高并发来说十分漫长，会导致整个注册服务的瘫痪，这是不可容忍的</td>&#x000A;<td>在15分钟内85%的节点都没有心跳，则注册中心 会认为客户端与之出现了网络故障，则会进入自动保护模式。1.Eureka不会移除没有收到心跳的服务；2.新的服务仍能在服务端注册，但是暂时不会被同步到其他节点上直到网络稳定</td>&#x000A;</tr>&#x000A;</tbody>&#x000A;</table>&#x000A;<h4>&#x000A;<a id="结论" class="anchor" href="#%E7%BB%93%E8%AE%BA"></a>结论</h4>&#x000A;<p>Eureka可以很好的应对网络故障导致部分节点失去连接的情况，而不会像zookeeper那样导致整个注册服务系统的瘫痪。</p>&#x000A;<h2>&#x000A;<a id="ribbon负载均衡" class="anchor" href="#ribbon%E8%B4%9F%E8%BD%BD%E5%9D%87%E8%A1%A1"></a>Ribbon负载均衡</h2>&#x000A;<p>Spring Cloud Ribbon是基于Netflix Ribbon实现的一套==客户端==负载均衡工具。Ribbon会自动帮助你基于某种规则（简单轮询、随机连接等），也可以实现自定义的负载均衡算法。</p>&#x000A;<h3>&#x000A;<a id="负载均衡" class="anchor" href="#%E8%B4%9F%E8%BD%BD%E5%9D%87%E8%A1%A1"></a>负载均衡</h3>&#x000A;<ul>&#x000A;<li>&#x000A;<p>英文名称：Load Balance，微服务或分布式集群中常用的一种应用</p>&#x000A;</li>&#x000A;<li>&#x000A;<p>简单来说负载均衡就是将用户的请求ping平摊的分配到多个任务上，从而是系统达到HA（高可用）</p>&#x000A;</li>&#x000A;<li>&#x000A;<p>两种负载均衡：</p>&#x000A;<ol>&#x000A;<li>集中式LB：偏硬件，服务的消费方和提供方之间使用独立的LB设施，由该设施负责把访问请求以某种策略转发至服务的提供方。</li>&#x000A;<li>进程内LB：骗软件， 将LB逻辑集成到消费方，消费方从服务注册中心指导哪些地址可用，再自己选择一个合适的服务器。</li>&#x000A;</ol>&#x000A;</li>&#x000A;</ul>&#x000A;<h4>&#x000A;<a id="ribbon初步配置" class="anchor" href="#ribbon%E5%88%9D%E6%AD%A5%E9%85%8D%E7%BD%AE"></a>Ribbon初步配置</h4>&#x000A;<ul>&#x000A;<li>==Ribbon是客户端负载均衡工具！！！Ribbon是客户端负载均衡工具！！！Ribbon是客户端负载均衡工具！！！==所以应该配置在客户端</li>&#x000A;</ul>&#x000A;<ol>&#x000A;<li>加入依赖，因为Riboon需要依赖Eureka运行，所以要同时加入Eureka依赖</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line">        <span class="nt">&lt;dependency&gt;</span></span>&#x000A;<span id="LC2" class="line">            <span class="nt">&lt;groupId&gt;</span>org.springframework.cloud<span class="nt">&lt;/groupId&gt;</span></span>&#x000A;<span id="LC3" class="line">            <span class="nt">&lt;artifactId&gt;</span>spring-cloud-starter-eureka<span class="nt">&lt;/artifactId&gt;</span></span>&#x000A;<span id="LC4" class="line">        <span class="nt">&lt;/dependency&gt;</span></span>&#x000A;<span id="LC5" class="line">        <span class="nt">&lt;dependency&gt;</span></span>&#x000A;<span id="LC6" class="line">            <span class="nt">&lt;groupId&gt;</span>org.springframework.cloud<span class="nt">&lt;/groupId&gt;</span></span>&#x000A;<span id="LC7" class="line">            <span class="nt">&lt;artifactId&gt;</span>spring-cloud-starter-ribbon<span class="nt">&lt;/artifactId&gt;</span></span>&#x000A;<span id="LC8" class="line">        <span class="nt">&lt;/dependency&gt;</span></span>&#x000A;<span id="LC9" class="line">        <span class="nt">&lt;dependency&gt;</span></span>&#x000A;<span id="LC10" class="line">            <span class="nt">&lt;groupId&gt;</span>org.springframework.cloud<span class="nt">&lt;/groupId&gt;</span></span>&#x000A;<span id="LC11" class="line">            <span class="nt">&lt;artifactId&gt;</span>spring-cloud-starter-config<span class="nt">&lt;/artifactId&gt;</span></span></pre></div></div>&#x000A;<ol start="2">&#x000A;<li>对实现类加入@LoadBalanced注解</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="nd">@Bean</span></span>&#x000A;<span id="LC2" class="line"><span class="nd">@LoadBalanced</span></span>&#x000A;<span id="LC3" class="line"><span class="kd">public</span> <span class="nc">RestTemplate</span> <span class="nf">getRestTemplate</span><span class="o">()</span> <span class="o">{</span></span>&#x000A;<span id="LC4" class="line">        <span class="k">return</span>  <span class="k">new</span> <span class="nf">RestTemplate</span><span class="o">();</span></span>&#x000A;<span id="LC5" class="line">    <span class="o">}</span></span>&#x000A;<span id="LC6" class="line"><span class="o">}</span></span></pre></div></div>&#x000A;<ol start="3">&#x000A;<li>在application.yml文件中配置向注册中心注册，如果是作为消费者模块不提供服务，不应该注册自己</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="na">eureka</span><span class="pi">:</span></span>&#x000A;<span id="LC2" class="line">  <span class="na">client</span><span class="pi">:</span></span>&#x000A;<span id="LC3" class="line">    <span class="na">service-url</span><span class="pi">:</span></span>&#x000A;<span id="LC4" class="line">      <span class="na">defaultZone</span><span class="pi">:</span> <span class="s">http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/</span></span>&#x000A;<span id="LC5" class="line">    <span class="na">register-with-eureka</span><span class="pi">:</span> <span class="no">false</span><span class="err">				</span><span class="s">#作为消费者不提供服务，不应该注册自己</span></span></pre></div></div>&#x000A;<ol start="4">&#x000A;<li>主启动类中加入@EnableEurekaClient注解</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="nd">@SpringBootApplication</span></span>&#x000A;<span id="LC2" class="line"><span class="nd">@EnableEurekaClient</span></span>&#x000A;<span id="LC3" class="line"><span class="kd">public</span> <span class="kd">class</span> <span class="nc">Consumer80_APP</span> <span class="o">{</span></span>&#x000A;<span id="LC4" class="line">    <span class="kd">public</span> <span class="kd">static</span> <span class="kt">void</span> <span class="nf">main</span><span class="o">(</span><span class="nc">String</span><span class="o">[]</span> <span class="n">args</span><span class="o">)</span> <span class="o">{</span></span>&#x000A;<span id="LC5" class="line">        <span class="nc">SpringApplication</span><span class="o">.</span><span class="na">run</span><span class="o">(</span><span class="n">Consumer80_APP</span><span class="o">.</span><span class="na">class</span><span class="o">,</span><span class="n">args</span><span class="o">);</span></span>&#x000A;<span id="LC6" class="line">    <span class="o">}</span></span>&#x000A;<span id="LC7" class="line"><span class="o">}</span></span></pre></div></div>&#x000A;<ol start="5">&#x000A;<li>以上步骤1~4完成后即可在controller中直接通过服务名访问系统中的微服务，服务名作为URI</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="kd">private</span> <span class="kd">static</span> <span class="kd">final</span> <span class="nc">String</span> <span class="no">URL_PREFIX</span> <span class="o">=</span> <span class="s">"http://MICROSERVICECLOUD-DEPT/"</span><span class="o">;</span></span></pre></div></div>&#x000A;<h4>&#x000A;<a id="ribbon负载均衡实现" class="anchor" href="#ribbon%E8%B4%9F%E8%BD%BD%E5%9D%87%E8%A1%A1%E5%AE%9E%E7%8E%B0"></a>Ribbon负载均衡实现</h4>&#x000A;<p>架构示意图：</p>&#x000A;<p><img src="/xiongrj/springcloud-base/raw/master/images%5CRibbon%E8%B4%9F%E8%BD%BD%E5%9D%87%E8%A1%A1%E6%9E%B6%E6%9E%84.png" alt="Ribbon负载均衡架构"></p>&#x000A;<h5>&#x000A;<a id="实现方法" class="anchor" href="#%E5%AE%9E%E7%8E%B0%E6%96%B9%E6%B3%95"></a>实现方法</h5>&#x000A;<p>目标：构建provider集群后consumer通过负载均衡轮询调用在Eureka中注册的服务</p>&#x000A;<ol>&#x000A;<li>构建集群，新开两个provider模块，将原provider的==代码部分和pom.xml中依赖照搬==到新的provider中</li>&#x000A;<li>将原provider中application.yml文件照搬到新provider，并修改端口号，若新的provider使用自己的数据库，则修改数据库信息（其他配置也一样，如修改别名）</li>&#x000A;<li>集群中服务名称必须一致！！！</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="na">spring</span><span class="pi">:</span></span>&#x000A;<span id="LC2" class="line">  <span class="na">application</span><span class="pi">:</span></span>&#x000A;<span id="LC3" class="line">    <span class="na">name</span><span class="pi">:</span> <span class="s">microservicecloud-dept</span>   <span class="c1">#同一集群下必须使用同一服务名！！！！！</span></span></pre></div></div>&#x000A;<ol start="4">&#x000A;<li>启动服务，进行测试</li>&#x000A;</ol>&#x000A;<h5>&#x000A;<a id="总结" class="anchor" href="#%E6%80%BB%E7%BB%93"></a>总结</h5>&#x000A;<p>Ribbon其实就是一个软负载均衡的客户端组件，可以和其他需要请求的客户端结合使用。</p>&#x000A;<h3>&#x000A;<a id="ribbon核心组件irule" class="anchor" href="#ribbon%E6%A0%B8%E5%BF%83%E7%BB%84%E4%BB%B6irule"></a>Ribbon核心组件IRule</h3>&#x000A;<p>IRule：根据特定算法从服务列表中选取一个需要访问的服务</p>&#x000A;<h4>&#x000A;<a id="七大方法" class="anchor" href="#%E4%B8%83%E5%A4%A7%E6%96%B9%E6%B3%95"></a>七大方法</h4>&#x000A;<p>==IRule是一个接口，七大方法是其自带的落地实现类==</p>&#x000A;<ul>&#x000A;<li>RoundRobinRule：轮询（默认方法）</li>&#x000A;<li>RandomRule：随机</li>&#x000A;<li>AvailabilityFilteringRule：先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，还有并发的连接数量超过阈值的服务，然后对剩余的服务进行轮询</li>&#x000A;<li>WeightedResponseTimeRule：根据平均响应时间计算服务的权重。统计信息不足时会按照轮询，统计信息足够会按照响应的时间选择服务</li>&#x000A;<li>RetryRule：正常时按照轮询选择服务，若过程中有服务出现故障，在轮询一定次数后依然故障，则会跳过故障的服务继续轮询。</li>&#x000A;<li>BestAvailableRule：先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务</li>&#x000A;<li>ZoneAvoidanceRule：默认规则，符合判断server所在的区域的性能和server的可用性选择服务</li>&#x000A;</ul>&#x000A;<h4>&#x000A;<a id="切换规则方法" class="anchor" href="#%E5%88%87%E6%8D%A2%E8%A7%84%E5%88%99%E6%96%B9%E6%B3%95"></a>切换规则方法</h4>&#x000A;<p>只需在==配置类==中配置一个返回具体方法的bean即可</p>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="nd">@Bean</span></span>&#x000A;<span id="LC2" class="line"><span class="kd">public</span> <span class="nc">IRule</span> <span class="nf">MyRule</span><span class="o">(){</span></span>&#x000A;<span id="LC3" class="line">        <span class="k">return</span> <span class="k">new</span> <span class="nf">RandomRule</span><span class="o">();</span>    </span>&#x000A;<span id="LC4" class="line">    <span class="o">}</span></span></pre></div></div>&#x000A;<h3>&#x000A;<a id="自定义ribbon负载均衡算法" class="anchor" href="#%E8%87%AA%E5%AE%9A%E4%B9%89ribbon%E8%B4%9F%E8%BD%BD%E5%9D%87%E8%A1%A1%E7%AE%97%E6%B3%95"></a>自定义Ribbon负载均衡算法</h3>&#x000A;<h4>&#x000A;<a id="配置及包位置" class="anchor" href="#%E9%85%8D%E7%BD%AE%E5%8F%8A%E5%8C%85%E4%BD%8D%E7%BD%AE"></a>配置及包位置</h4>&#x000A;<ol>&#x000A;<li>自定义的Ribbon算法类不能放在主启动类所在的包及子报下（确切来说是不能放在@ComponentScan注解的包及子包下），否则会被全局应用到Ribbon服务中。应该把自定义算法类放在另外新建的包下，且这个类应该是为==配置类==。（其实与普通切换负载均衡规则类似，只不过是位置不同而已，普通的可以放在主启动类所在的包，自定义的要放在外面的包下）</li>&#x000A;<li>主启动类添加@RibbonClient(name = "微服务名",configuration = XXX.class)注解指定需要用到负载均衡的微服务名及自定义算法的class对象。</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="nd">@SpringBootApplication</span></span>&#x000A;<span id="LC2" class="line"><span class="nd">@EnableEurekaClient</span></span>&#x000A;<span id="LC3" class="line"><span class="nd">@RibbonClient</span><span class="o">(</span><span class="n">name</span> <span class="o">=</span> <span class="s">"MICROSERVICECLOUD-DEPT"</span><span class="o">,</span><span class="n">configuration</span> <span class="o">=</span> <span class="nc">MyRule</span><span class="o">.</span><span class="na">class</span><span class="o">)</span></span>&#x000A;<span id="LC4" class="line"><span class="kd">public</span> <span class="kd">class</span> <span class="nc">Consumer80_APP</span> <span class="o">{</span></span>&#x000A;<span id="LC5" class="line">    <span class="kd">public</span> <span class="kd">static</span> <span class="kt">void</span> <span class="nf">main</span><span class="o">(</span><span class="nc">String</span><span class="o">[]</span> <span class="n">args</span><span class="o">)</span> <span class="o">{</span></span>&#x000A;<span id="LC6" class="line">        <span class="nc">SpringApplication</span><span class="o">.</span><span class="na">run</span><span class="o">(</span><span class="n">Consumer80_APP</span><span class="o">.</span><span class="na">class</span><span class="o">,</span><span class="n">args</span><span class="o">);</span></span>&#x000A;<span id="LC7" class="line">    <span class="o">}</span></span>&#x000A;<span id="LC8" class="line"><span class="o">}</span></span></pre></div></div>&#x000A;<p>####通过修改源代码获得自定义算法</p>&#x000A;<p>目标：每个服务调用5次后再进行轮询（调用次数不是很对，懒得改了)</p>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="kn">package</span> <span class="n">com</span><span class="o">.</span><span class="na">Rules</span><span class="o">;</span></span>&#x000A;<span id="LC2" class="line"></span>&#x000A;<span id="LC3" class="line"><span class="kn">import</span> <span class="nn">com.netflix.client.config.IClientConfig</span><span class="o">;</span></span>&#x000A;<span id="LC4" class="line"><span class="kn">import</span> <span class="nn">com.netflix.loadbalancer.AbstractLoadBalancerRule</span><span class="o">;</span></span>&#x000A;<span id="LC5" class="line"><span class="kn">import</span> <span class="nn">com.netflix.loadbalancer.ILoadBalancer</span><span class="o">;</span></span>&#x000A;<span id="LC6" class="line"><span class="kn">import</span> <span class="nn">com.netflix.loadbalancer.RoundRobinRule</span><span class="o">;</span></span>&#x000A;<span id="LC7" class="line"><span class="kn">import</span> <span class="nn">com.netflix.loadbalancer.Server</span><span class="o">;</span></span>&#x000A;<span id="LC8" class="line"><span class="kn">import</span> <span class="nn">org.slf4j.Logger</span><span class="o">;</span></span>&#x000A;<span id="LC9" class="line"><span class="kn">import</span> <span class="nn">org.slf4j.LoggerFactory</span><span class="o">;</span></span>&#x000A;<span id="LC10" class="line"><span class="kn">import</span> <span class="nn">org.springframework.context.annotation.Configuration</span><span class="o">;</span></span>&#x000A;<span id="LC11" class="line"></span>&#x000A;<span id="LC12" class="line"><span class="kn">import</span> <span class="nn">java.util.List</span><span class="o">;</span></span>&#x000A;<span id="LC13" class="line"><span class="kn">import</span> <span class="nn">java.util.concurrent.atomic.AtomicInteger</span><span class="o">;</span></span>&#x000A;<span id="LC14" class="line"></span>&#x000A;<span id="LC15" class="line"></span>&#x000A;<span id="LC16" class="line"><span class="kd">public</span> <span class="kd">class</span> <span class="nc">MyRule</span> <span class="kd">extends</span> <span class="nc">AbstractLoadBalancerRule</span> <span class="o">{</span></span>&#x000A;<span id="LC17" class="line"></span>&#x000A;<span id="LC18" class="line">    <span class="kd">private</span> <span class="nc">AtomicInteger</span> <span class="n">nextServerCyclicCounter</span><span class="o">;</span></span>&#x000A;<span id="LC19" class="line">    <span class="kd">private</span> <span class="kd">static</span> <span class="kd">final</span> <span class="kt">boolean</span> <span class="no">AVAILABLE_ONLY_SERVERS</span> <span class="o">=</span> <span class="kc">true</span><span class="o">;</span></span>&#x000A;<span id="LC20" class="line">    <span class="kd">private</span> <span class="kd">static</span> <span class="kd">final</span> <span class="kt">boolean</span> <span class="no">ALL_SERVERS</span> <span class="o">=</span> <span class="kc">false</span><span class="o">;</span></span>&#x000A;<span id="LC21" class="line">    <span class="kd">private</span> <span class="kt">int</span> <span class="n">total</span> <span class="o">=</span> <span class="mi">0</span><span class="o">;</span></span>&#x000A;<span id="LC22" class="line">    <span class="kd">private</span> <span class="kt">int</span> <span class="n">currentIndex</span> <span class="o">=</span> <span class="mi">0</span><span class="o">;</span></span>&#x000A;<span id="LC23" class="line"></span>&#x000A;<span id="LC24" class="line">    <span class="kd">private</span> <span class="kd">static</span> <span class="nc">Logger</span> <span class="n">log</span> <span class="o">=</span> <span class="nc">LoggerFactory</span><span class="o">.</span><span class="na">getLogger</span><span class="o">(</span><span class="nc">RoundRobinRule</span><span class="o">.</span><span class="na">class</span><span class="o">);</span></span>&#x000A;<span id="LC25" class="line"></span>&#x000A;<span id="LC26" class="line">    <span class="kd">public</span> <span class="nf">MyRule</span><span class="o">()</span> <span class="o">{</span></span>&#x000A;<span id="LC27" class="line">        <span class="n">nextServerCyclicCounter</span> <span class="o">=</span> <span class="k">new</span> <span class="nc">AtomicInteger</span><span class="o">(</span><span class="mi">0</span><span class="o">);</span></span>&#x000A;<span id="LC28" class="line">    <span class="o">}</span></span>&#x000A;<span id="LC29" class="line"></span>&#x000A;<span id="LC30" class="line">    <span class="kd">public</span> <span class="nf">MyRule</span><span class="o">(</span><span class="nc">ILoadBalancer</span> <span class="n">lb</span><span class="o">)</span> <span class="o">{</span></span>&#x000A;<span id="LC31" class="line">        <span class="k">this</span><span class="o">();</span></span>&#x000A;<span id="LC32" class="line">        <span class="n">setLoadBalancer</span><span class="o">(</span><span class="n">lb</span><span class="o">);</span></span>&#x000A;<span id="LC33" class="line">    <span class="o">}</span></span>&#x000A;<span id="LC34" class="line"></span>&#x000A;<span id="LC35" class="line">    <span class="kd">public</span> <span class="nc">Server</span> <span class="nf">choose</span><span class="o">(</span><span class="nc">ILoadBalancer</span> <span class="n">lb</span><span class="o">,</span> <span class="nc">Object</span> <span class="n">key</span><span class="o">)</span> <span class="o">{</span></span>&#x000A;<span id="LC36" class="line">        <span class="k">if</span> <span class="o">(</span><span class="n">lb</span> <span class="o">==</span> <span class="kc">null</span><span class="o">)</span> <span class="o">{</span></span>&#x000A;<span id="LC37" class="line">            <span class="n">log</span><span class="o">.</span><span class="na">warn</span><span class="o">(</span><span class="s">"no load balancer"</span><span class="o">);</span></span>&#x000A;<span id="LC38" class="line">            <span class="k">return</span> <span class="kc">null</span><span class="o">;</span></span>&#x000A;<span id="LC39" class="line">        <span class="o">}</span></span>&#x000A;<span id="LC40" class="line"></span>&#x000A;<span id="LC41" class="line">        <span class="nc">Server</span> <span class="n">server</span> <span class="o">=</span> <span class="kc">null</span><span class="o">;</span></span>&#x000A;<span id="LC42" class="line">        <span class="kt">int</span> <span class="n">count</span> <span class="o">=</span> <span class="mi">0</span><span class="o">;</span></span>&#x000A;<span id="LC43" class="line">        <span class="k">while</span> <span class="o">(</span><span class="n">server</span> <span class="o">==</span> <span class="kc">null</span> <span class="o">&amp;&amp;</span> <span class="n">count</span><span class="o">++</span> <span class="o">&lt;</span> <span class="mi">10</span><span class="o">)</span> <span class="o">{</span></span>&#x000A;<span id="LC44" class="line">            <span class="nc">List</span><span class="o">&lt;</span><span class="nc">Server</span><span class="o">&gt;</span> <span class="n">reachableServers</span> <span class="o">=</span> <span class="n">lb</span><span class="o">.</span><span class="na">getReachableServers</span><span class="o">();</span></span>&#x000A;<span id="LC45" class="line">            <span class="nc">List</span><span class="o">&lt;</span><span class="nc">Server</span><span class="o">&gt;</span> <span class="n">allServers</span> <span class="o">=</span> <span class="n">lb</span><span class="o">.</span><span class="na">getAllServers</span><span class="o">();</span></span>&#x000A;<span id="LC46" class="line">            <span class="kt">int</span> <span class="n">upCount</span> <span class="o">=</span> <span class="n">reachableServers</span><span class="o">.</span><span class="na">size</span><span class="o">();</span></span>&#x000A;<span id="LC47" class="line">            <span class="kt">int</span> <span class="n">serverCount</span> <span class="o">=</span> <span class="n">allServers</span><span class="o">.</span><span class="na">size</span><span class="o">();</span></span>&#x000A;<span id="LC48" class="line"></span>&#x000A;<span id="LC49" class="line">            <span class="k">if</span> <span class="o">((</span><span class="n">upCount</span> <span class="o">==</span> <span class="mi">0</span><span class="o">)</span> <span class="o">||</span> <span class="o">(</span><span class="n">serverCount</span> <span class="o">==</span> <span class="mi">0</span><span class="o">))</span> <span class="o">{</span></span>&#x000A;<span id="LC50" class="line">                <span class="n">log</span><span class="o">.</span><span class="na">warn</span><span class="o">(</span><span class="s">"No up servers available from load balancer: "</span> <span class="o">+</span> <span class="n">lb</span><span class="o">);</span></span>&#x000A;<span id="LC51" class="line">                <span class="k">return</span> <span class="kc">null</span><span class="o">;</span></span>&#x000A;<span id="LC52" class="line">            <span class="o">}</span></span>&#x000A;<span id="LC53" class="line">            <span class="k">if</span> <span class="o">(</span><span class="n">total</span> <span class="o">&gt;</span> <span class="mi">5</span><span class="o">)</span> <span class="o">{</span></span>&#x000A;<span id="LC54" class="line">                <span class="n">total</span> <span class="o">=</span> <span class="mi">0</span><span class="o">;</span></span>&#x000A;<span id="LC55" class="line">                <span class="kt">int</span> <span class="n">nextServerIndex</span> <span class="o">=</span> <span class="n">incrementAndGetModulo</span><span class="o">(</span><span class="n">serverCount</span><span class="o">);</span></span>&#x000A;<span id="LC56" class="line">                <span class="n">currentIndex</span> <span class="o">=</span> <span class="n">nextServerIndex</span><span class="o">;</span></span>&#x000A;<span id="LC57" class="line">                <span class="n">server</span> <span class="o">=</span> <span class="n">allServers</span><span class="o">.</span><span class="na">get</span><span class="o">(</span><span class="n">nextServerIndex</span><span class="o">);</span></span>&#x000A;<span id="LC58" class="line">            <span class="o">}</span><span class="k">else</span> <span class="o">{</span></span>&#x000A;<span id="LC59" class="line">                <span class="k">if</span> <span class="o">(</span><span class="n">currentIndex</span><span class="o">&gt;=</span><span class="n">serverCount</span><span class="o">)</span> <span class="o">{</span></span>&#x000A;<span id="LC60" class="line">                    <span class="n">currentIndex</span> <span class="o">=</span> <span class="mi">0</span><span class="o">;</span></span>&#x000A;<span id="LC61" class="line">                <span class="o">}</span></span>&#x000A;<span id="LC62" class="line">                <span class="n">server</span> <span class="o">=</span> <span class="n">allServers</span><span class="o">.</span><span class="na">get</span><span class="o">(</span><span class="n">currentIndex</span><span class="o">);</span></span>&#x000A;<span id="LC63" class="line">                <span class="n">total</span><span class="o">++;</span></span>&#x000A;<span id="LC64" class="line">            <span class="o">}</span></span>&#x000A;<span id="LC65" class="line"></span>&#x000A;<span id="LC66" class="line"></span>&#x000A;<span id="LC67" class="line">            <span class="k">if</span> <span class="o">(</span><span class="n">server</span> <span class="o">==</span> <span class="kc">null</span><span class="o">)</span> <span class="o">{</span></span>&#x000A;<span id="LC68" class="line">                <span class="cm">/* Transient. */</span></span>&#x000A;<span id="LC69" class="line">                <span class="nc">Thread</span><span class="o">.</span><span class="na">yield</span><span class="o">();</span></span>&#x000A;<span id="LC70" class="line">                <span class="k">continue</span><span class="o">;</span></span>&#x000A;<span id="LC71" class="line">            <span class="o">}</span></span>&#x000A;<span id="LC72" class="line"></span>&#x000A;<span id="LC73" class="line">            <span class="k">if</span> <span class="o">(</span><span class="n">server</span><span class="o">.</span><span class="na">isAlive</span><span class="o">()</span> <span class="o">&amp;&amp;</span> <span class="o">(</span><span class="n">server</span><span class="o">.</span><span class="na">isReadyToServe</span><span class="o">()))</span> <span class="o">{</span></span>&#x000A;<span id="LC74" class="line">                <span class="k">return</span> <span class="o">(</span><span class="n">server</span><span class="o">);</span></span>&#x000A;<span id="LC75" class="line">            <span class="o">}</span></span>&#x000A;<span id="LC76" class="line"></span>&#x000A;<span id="LC77" class="line">            <span class="c1">// Next.</span></span>&#x000A;<span id="LC78" class="line">            <span class="n">server</span> <span class="o">=</span> <span class="kc">null</span><span class="o">;</span></span>&#x000A;<span id="LC79" class="line">        <span class="o">}</span></span>&#x000A;<span id="LC80" class="line"></span>&#x000A;<span id="LC81" class="line">        <span class="k">if</span> <span class="o">(</span><span class="n">count</span> <span class="o">&gt;=</span> <span class="mi">10</span><span class="o">)</span> <span class="o">{</span></span>&#x000A;<span id="LC82" class="line">            <span class="n">log</span><span class="o">.</span><span class="na">warn</span><span class="o">(</span><span class="s">"No available alive servers after 10 tries from load balancer: "</span></span>&#x000A;<span id="LC83" class="line">                    <span class="o">+</span> <span class="n">lb</span><span class="o">);</span></span>&#x000A;<span id="LC84" class="line">        <span class="o">}</span></span>&#x000A;<span id="LC85" class="line">        <span class="k">return</span> <span class="n">server</span><span class="o">;</span></span>&#x000A;<span id="LC86" class="line">    <span class="o">}</span></span>&#x000A;<span id="LC87" class="line"></span>&#x000A;<span id="LC88" class="line">    <span class="cm">/**</span></span>&#x000A;<span id="LC89" class="line"><span class="cm">     * Inspired by the implementation of {@link AtomicInteger#incrementAndGet()}.</span></span>&#x000A;<span id="LC90" class="line"><span class="cm">     *</span></span>&#x000A;<span id="LC91" class="line"><span class="cm">     * @param modulo The modulo to bound the value of the counter.</span></span>&#x000A;<span id="LC92" class="line"><span class="cm">     * @return The next value.</span></span>&#x000A;<span id="LC93" class="line"><span class="cm">     */</span></span>&#x000A;<span id="LC94" class="line">    <span class="kd">private</span> <span class="kt">int</span> <span class="nf">incrementAndGetModulo</span><span class="o">(</span><span class="kt">int</span> <span class="n">modulo</span><span class="o">)</span> <span class="o">{</span></span>&#x000A;<span id="LC95" class="line">        <span class="k">for</span> <span class="o">(;;)</span> <span class="o">{</span></span>&#x000A;<span id="LC96" class="line">            <span class="kt">int</span> <span class="n">current</span> <span class="o">=</span> <span class="n">nextServerCyclicCounter</span><span class="o">.</span><span class="na">get</span><span class="o">();</span></span>&#x000A;<span id="LC97" class="line">            <span class="kt">int</span> <span class="n">next</span> <span class="o">=</span> <span class="o">(</span><span class="n">current</span> <span class="o">+</span> <span class="mi">1</span><span class="o">)</span> <span class="o">%</span> <span class="n">modulo</span><span class="o">;</span></span>&#x000A;<span id="LC98" class="line">            <span class="k">if</span> <span class="o">(</span><span class="n">nextServerCyclicCounter</span><span class="o">.</span><span class="na">compareAndSet</span><span class="o">(</span><span class="n">current</span><span class="o">,</span> <span class="n">next</span><span class="o">))</span></span>&#x000A;<span id="LC99" class="line">                <span class="k">return</span> <span class="n">next</span><span class="o">;</span></span>&#x000A;<span id="LC100" class="line">        <span class="o">}</span></span>&#x000A;<span id="LC101" class="line">    <span class="o">}</span></span>&#x000A;<span id="LC102" class="line"></span>&#x000A;<span id="LC103" class="line"></span>&#x000A;<span id="LC104" class="line">    <span class="kd">public</span> <span class="nc">Server</span> <span class="nf">choose</span><span class="o">(</span><span class="nc">Object</span> <span class="n">key</span><span class="o">)</span> <span class="o">{</span></span>&#x000A;<span id="LC105" class="line">        <span class="k">return</span> <span class="nf">choose</span><span class="o">(</span><span class="n">getLoadBalancer</span><span class="o">(),</span> <span class="n">key</span><span class="o">);</span></span>&#x000A;<span id="LC106" class="line">    <span class="o">}</span></span>&#x000A;<span id="LC107" class="line"></span>&#x000A;<span id="LC108" class="line"></span>&#x000A;<span id="LC109" class="line">    <span class="kd">public</span> <span class="kt">void</span> <span class="nf">initWithNiwsConfig</span><span class="o">(</span><span class="nc">IClientConfig</span> <span class="n">clientConfig</span><span class="o">)</span> <span class="o">{</span></span>&#x000A;<span id="LC110" class="line">    <span class="o">}</span></span>&#x000A;<span id="LC111" class="line"><span class="o">}</span></span>&#x000A;<span id="LC112" class="line"></span></pre></div></div>&#x000A;<h2>&#x000A;<a id="feign负载均衡" class="anchor" href="#feign%E8%B4%9F%E8%BD%BD%E5%9D%87%E8%A1%A1"></a>Feign负载均衡</h2>&#x000A;<p>Feign是一个声明式WebService客户端，使用方法时定义一个接口并在上面添加注解即可。Feign支持可拔插式的编码器和解码器。Spring Cloud对Feign进行了封装，使其支持SpringMVC和HttpMessageConverters。Feign可以与Eureka和Ribbon组合使用以支持负载均衡。</p>&#x000A;<h3>&#x000A;<a id="使用案例" class="anchor" href="#%E4%BD%BF%E7%94%A8%E6%A1%88%E4%BE%8B"></a>使用案例</h3>&#x000A;<ol>&#x000A;<li>新建Feign模块，加入依赖（其实跟80消费者差不多，主要是多了Feign依赖）</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line">    <span class="nt">&lt;dependencies&gt;</span></span>&#x000A;<span id="LC2" class="line">        <span class="nt">&lt;dependency&gt;</span></span>&#x000A;<span id="LC3" class="line">            <span class="nt">&lt;groupId&gt;</span>com.XXX<span class="nt">&lt;/groupId&gt;</span></span>&#x000A;<span id="LC4" class="line">            <span class="nt">&lt;artifactId&gt;</span>microservice-api<span class="nt">&lt;/artifactId&gt;</span></span>&#x000A;<span id="LC5" class="line">            <span class="nt">&lt;version&gt;</span>${project.version}<span class="nt">&lt;/version&gt;</span></span>&#x000A;<span id="LC6" class="line">        <span class="nt">&lt;/dependency&gt;</span></span>&#x000A;<span id="LC7" class="line">        <span class="nt">&lt;dependency&gt;</span></span>&#x000A;<span id="LC8" class="line">            <span class="nt">&lt;groupId&gt;</span>org.springframework.boot<span class="nt">&lt;/groupId&gt;</span></span>&#x000A;<span id="LC9" class="line">            <span class="nt">&lt;artifactId&gt;</span>spring-boot-starter-web<span class="nt">&lt;/artifactId&gt;</span></span>&#x000A;<span id="LC10" class="line">        <span class="nt">&lt;/dependency&gt;</span></span>&#x000A;<span id="LC11" class="line">        <span class="nt">&lt;dependency&gt;</span></span>&#x000A;<span id="LC12" class="line">            <span class="nt">&lt;groupId&gt;</span>org.springframework.cloud<span class="nt">&lt;/groupId&gt;</span></span>&#x000A;<span id="LC13" class="line">            <span class="nt">&lt;artifactId&gt;</span>spring-cloud-starter-feign<span class="nt">&lt;/artifactId&gt;</span></span>&#x000A;<span id="LC14" class="line">        <span class="nt">&lt;/dependency&gt;</span></span>&#x000A;<span id="LC15" class="line">        <span class="nt">&lt;dependency&gt;</span></span>&#x000A;<span id="LC16" class="line">            <span class="nt">&lt;groupId&gt;</span>org.springframework.cloud<span class="nt">&lt;/groupId&gt;</span></span>&#x000A;<span id="LC17" class="line">            <span class="nt">&lt;artifactId&gt;</span>spring-cloud-starter-eureka<span class="nt">&lt;/artifactId&gt;</span></span>&#x000A;<span id="LC18" class="line">        <span class="nt">&lt;/dependency&gt;</span></span>&#x000A;<span id="LC19" class="line">        <span class="nt">&lt;dependency&gt;</span></span>&#x000A;<span id="LC20" class="line">            <span class="nt">&lt;groupId&gt;</span>org.springframework.cloud<span class="nt">&lt;/groupId&gt;</span></span>&#x000A;<span id="LC21" class="line">            <span class="nt">&lt;artifactId&gt;</span>spring-cloud-starter-ribbon<span class="nt">&lt;/artifactId&gt;</span></span>&#x000A;<span id="LC22" class="line">        <span class="nt">&lt;/dependency&gt;</span></span>&#x000A;<span id="LC23" class="line">        <span class="nt">&lt;dependency&gt;</span></span>&#x000A;<span id="LC24" class="line">            <span class="nt">&lt;groupId&gt;</span>org.springframework.cloud<span class="nt">&lt;/groupId&gt;</span></span>&#x000A;<span id="LC25" class="line">            <span class="nt">&lt;artifactId&gt;</span>spring-cloud-starter-config<span class="nt">&lt;/artifactId&gt;</span></span>&#x000A;<span id="LC26" class="line">        <span class="nt">&lt;/dependency&gt;</span></span>&#x000A;<span id="LC27" class="line">        <span class="c">&lt;!--热部署--&gt;</span></span>&#x000A;<span id="LC28" class="line">        <span class="nt">&lt;dependency&gt;</span></span>&#x000A;<span id="LC29" class="line">            <span class="nt">&lt;groupId&gt;</span>org.springframework<span class="nt">&lt;/groupId&gt;</span></span>&#x000A;<span id="LC30" class="line">            <span class="nt">&lt;artifactId&gt;</span>springloaded<span class="nt">&lt;/artifactId&gt;</span></span>&#x000A;<span id="LC31" class="line">        <span class="nt">&lt;/dependency&gt;</span></span>&#x000A;<span id="LC32" class="line">        <span class="nt">&lt;dependency&gt;</span></span>&#x000A;<span id="LC33" class="line">            <span class="nt">&lt;groupId&gt;</span>org.springframework.boot<span class="nt">&lt;/groupId&gt;</span></span>&#x000A;<span id="LC34" class="line">            <span class="nt">&lt;artifactId&gt;</span>spring-boot-devtools<span class="nt">&lt;/artifactId&gt;</span></span>&#x000A;<span id="LC35" class="line">        <span class="nt">&lt;/dependency&gt;</span></span>&#x000A;<span id="LC36" class="line">    <span class="nt">&lt;/dependencies&gt;</span></span></pre></div></div>&#x000A;<ol start="2">&#x000A;<li>因为Feign开发其实是面向接口编程，所以Feign接口可以放在api模块中供各模块使用，所以要在api模块中添加Feign依赖</li>&#x000A;<li>在api中编写接口，接口上添加@FeignClient注解，并通过value指定作用的微服务名</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="nd">@FeignClient</span><span class="o">(</span><span class="n">value</span> <span class="o">=</span> <span class="s">"MICROSERVICECLOUD-DEPT"</span><span class="o">)</span></span>&#x000A;<span id="LC2" class="line"><span class="kd">public</span> <span class="kd">interface</span> <span class="nc">DeptClientService</span> <span class="o">{</span></span>&#x000A;<span id="LC3" class="line"></span>&#x000A;<span id="LC4" class="line">    <span class="nd">@PostMapping</span><span class="o">(</span><span class="s">"/dept"</span><span class="o">)</span></span>&#x000A;<span id="LC5" class="line">    <span class="kd">public</span> <span class="kt">boolean</span> <span class="nf">addDept</span><span class="o">(</span><span class="nc">Dept</span> <span class="n">dept</span><span class="o">);</span></span>&#x000A;<span id="LC6" class="line"></span>&#x000A;<span id="LC7" class="line">    <span class="nd">@GetMapping</span><span class="o">(</span><span class="s">"/dept"</span><span class="o">)</span></span>&#x000A;<span id="LC8" class="line">    <span class="kd">public</span> <span class="nc">List</span><span class="o">&lt;</span><span class="nc">Dept</span><span class="o">&gt;</span> <span class="nf">findAll</span><span class="o">();</span></span>&#x000A;<span id="LC9" class="line"></span>&#x000A;<span id="LC10" class="line">    <span class="nd">@GetMapping</span><span class="o">(</span><span class="s">"/dept/{id}"</span><span class="o">)</span></span>&#x000A;<span id="LC11" class="line">    <span class="kd">public</span> <span class="nc">Dept</span> <span class="nf">findById</span><span class="o">(</span><span class="nd">@PathVariable</span><span class="o">(</span><span class="s">"id"</span><span class="o">)</span><span class="nc">Integer</span> <span class="n">id</span><span class="o">);</span></span>&#x000A;<span id="LC12" class="line"><span class="o">}</span></span>&#x000A;<span id="LC13" class="line"></span></pre></div></div>&#x000A;<ol start="4">&#x000A;<li>在Feign模块中编写Controller，并注入FeignClient接口，直接调用service接口中的方法即可（因为声明Feign接口时已经指定过微服务，所以访问时会正确地找到微服务）</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="nd">@RestController</span></span>&#x000A;<span id="LC2" class="line"><span class="nd">@RequestMapping</span><span class="o">(</span><span class="s">"/consumer"</span><span class="o">)</span></span>&#x000A;<span id="LC3" class="line"><span class="kd">public</span> <span class="kd">class</span> <span class="nc">ConsumerDeptController</span> <span class="o">{</span></span>&#x000A;<span id="LC4" class="line">    <span class="nd">@Autowired</span></span>&#x000A;<span id="LC5" class="line">    <span class="kd">private</span> <span class="nc">DeptClientService</span> <span class="n">service</span><span class="o">;</span></span>&#x000A;<span id="LC6" class="line"></span>&#x000A;<span id="LC7" class="line">    <span class="nd">@PostMapping</span><span class="o">(</span><span class="s">"/dept"</span><span class="o">)</span></span>&#x000A;<span id="LC8" class="line">    <span class="kd">public</span> <span class="kt">boolean</span> <span class="nf">addDept</span><span class="o">(</span><span class="nc">Dept</span> <span class="n">dept</span><span class="o">){</span></span>&#x000A;<span id="LC9" class="line">        <span class="k">return</span> <span class="n">service</span><span class="o">.</span><span class="na">addDept</span><span class="o">(</span><span class="n">dept</span><span class="o">);</span></span>&#x000A;<span id="LC10" class="line">    <span class="o">}</span></span>&#x000A;<span id="LC11" class="line"></span>&#x000A;<span id="LC12" class="line">    <span class="nd">@GetMapping</span><span class="o">(</span><span class="s">"/dept"</span><span class="o">)</span></span>&#x000A;<span id="LC13" class="line">    <span class="kd">public</span> <span class="nc">List</span><span class="o">&lt;</span><span class="nc">Dept</span><span class="o">&gt;</span> <span class="nf">findAll</span><span class="o">(){</span></span>&#x000A;<span id="LC14" class="line">        <span class="k">return</span> <span class="n">service</span><span class="o">.</span><span class="na">findAll</span><span class="o">();</span></span>&#x000A;<span id="LC15" class="line">    <span class="o">}</span></span>&#x000A;<span id="LC16" class="line"></span>&#x000A;<span id="LC17" class="line">    <span class="nd">@GetMapping</span><span class="o">(</span><span class="s">"/dept/{id}"</span><span class="o">)</span></span>&#x000A;<span id="LC18" class="line">    <span class="kd">public</span> <span class="nc">Dept</span> <span class="nf">findById</span><span class="o">(</span><span class="nd">@PathVariable</span><span class="o">(</span><span class="s">"id"</span><span class="o">)</span><span class="nc">Integer</span> <span class="n">id</span><span class="o">){</span></span>&#x000A;<span id="LC19" class="line">        <span class="k">return</span> <span class="n">service</span><span class="o">.</span><span class="na">findById</span><span class="o">(</span><span class="n">id</span><span class="o">);</span></span>&#x000A;<span id="LC20" class="line">    <span class="o">}</span></span>&#x000A;<span id="LC21" class="line"><span class="o">}</span></span></pre></div></div>&#x000A;<ol start="5">&#x000A;<li>修改Feign模块的主启动类，加入@EnableFeignClients注解和@ComponentScan注解（主要是扫描api中声明的接口）</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="nd">@SpringBootApplication</span></span>&#x000A;<span id="LC2" class="line"><span class="nd">@EnableEurekaClient</span></span>&#x000A;<span id="LC3" class="line"><span class="nd">@EnableFeignClients</span><span class="o">(</span><span class="n">basePackages</span> <span class="o">=</span> <span class="o">{</span><span class="s">"com.XXX"</span><span class="o">})</span></span>&#x000A;<span id="LC4" class="line"><span class="nd">@ComponentScan</span><span class="o">(</span><span class="s">"com.XXX"</span><span class="o">)</span></span>&#x000A;<span id="LC5" class="line"><span class="kd">public</span> <span class="kd">class</span> <span class="nc">Consumer80Feign_APP</span> <span class="o">{</span></span>&#x000A;<span id="LC6" class="line">    <span class="kd">public</span> <span class="kd">static</span> <span class="kt">void</span> <span class="nf">main</span><span class="o">(</span><span class="nc">String</span><span class="o">[]</span> <span class="n">args</span><span class="o">)</span> <span class="o">{</span></span>&#x000A;<span id="LC7" class="line">        <span class="nc">SpringApplication</span><span class="o">.</span><span class="na">run</span><span class="o">(</span><span class="n">Consumer80Feign_APP</span><span class="o">.</span><span class="na">class</span><span class="o">,</span><span class="n">args</span><span class="o">);</span></span>&#x000A;<span id="LC8" class="line">    <span class="o">}</span></span>&#x000A;<span id="LC9" class="line"><span class="o">}</span></span></pre></div></div>&#x000A;<ol start="6">&#x000A;<li>启动后访问，即会按照轮询的方式调用provider集群</li>&#x000A;</ol>&#x000A;<h3>&#x000A;<a id="总结-1" class="anchor" href="#%E6%80%BB%E7%BB%93-1"></a>总结</h3>&#x000A;<ul>&#x000A;<li>Feign通过接口方法调用REST服务，在Eureka中查找对应的服务</li>&#x000A;<li>Feign集成了Ribbon技术，所以也支持负载均衡（轮询）</li>&#x000A;</ul>&#x000A;<h2>&#x000A;<a id="hystrix断路器" class="anchor" href="#hystrix%E6%96%AD%E8%B7%AF%E5%99%A8"></a>Hystrix断路器</h2>&#x000A;<h3>&#x000A;<a id="分布式系统面临的问题" class="anchor" href="#%E5%88%86%E5%B8%83%E5%BC%8F%E7%B3%BB%E7%BB%9F%E9%9D%A2%E4%B8%B4%E7%9A%84%E9%97%AE%E9%A2%98"></a>分布式系统面临的问题</h3>&#x000A;<h4>&#x000A;<a id="扇出" class="anchor" href="#%E6%89%87%E5%87%BA"></a>扇出</h4>&#x000A;<p>多个微服务互相调用的时候，如果A调用B、C，而B、C又继续调用其他微服务，这就是扇出（像一把扇子一样慢慢打开。</p>&#x000A;<h4>&#x000A;<a id="服务雪崩" class="anchor" href="#%E6%9C%8D%E5%8A%A1%E9%9B%AA%E5%B4%A9"></a>服务雪崩</h4>&#x000A;<ul>&#x000A;<li>删除过程中，如果某一个环节的服务出现故障或连接超时，就会导致前面的服务占用越来越多的资源，进而引起系统崩溃，就是“雪崩效应”。</li>&#x000A;<li>对于高流量的应用来说，单一的后端依赖会导致服务器所有的资源都在几秒钟内饱和。比失败更糟糕的是，这些应用程序还可能导致服务之间的延迟增加，备份队列，线程和其他系统资源紧张，导致整个系统发生更多的级联故障。这些都表示需要==对故障和延迟进行隔离和管理==，以便单个依赖关系的失败，不能取消整个应用程序或系统。</li>&#x000A;</ul>&#x000A;<h3>&#x000A;<a id="hystrix介绍" class="anchor" href="#hystrix%E4%BB%8B%E7%BB%8D"></a>Hystrix介绍</h3>&#x000A;<ul>&#x000A;<li>Hystrix是一个用于处理分布式系统延迟和容错的开源库。分布式系统中，依赖避免不了调用失败，比如超时，异常等。Hystrix能保证在出现问题的时候，不会导致整体服务失败，避免级联故障，以提高分布式系统的弹性。</li>&#x000A;<li>Hystrix类似一个“断路器”，当系统中异常发生时，断路器给调用返回一个符合预期的，可处理的FallBack，这样就可以避免长时间无响应或抛出异常，使故障不能再系统中蔓延，造成雪崩。</li>&#x000A;</ul>&#x000A;<h4>&#x000A;<a id="服务熔断" class="anchor" href="#%E6%9C%8D%E5%8A%A1%E7%86%94%E6%96%AD"></a>服务熔断</h4>&#x000A;<ul>&#x000A;<li>熔断机制的注解是@HystrixCommand</li>&#x000A;<li>熔断机制是应对雪崩效应的一种==链路保护机制==，一般存在于服务端</li>&#x000A;<li>当扇出链路的某个服务出现故障或响应超时，会进行==服务降级==，进而==熔断该节点的服务调用==，快速返回“错误”的相应信息。、</li>&#x000A;<li>Hystrix的熔断存在阈值，缺省是5秒内20次调用失败就会触发</li>&#x000A;</ul>&#x000A;<h5>&#x000A;<a id="熔断案例" class="anchor" href="#%E7%86%94%E6%96%AD%E6%A1%88%E4%BE%8B"></a>熔断案例</h5>&#x000A;<ol>&#x000A;<li>构建一个新的provider module（如复制8001module）</li>&#x000A;<li>pom.xml加入hystrix依赖（一定要配合Eureka）</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line">        <span class="nt">&lt;dependency&gt;</span></span>&#x000A;<span id="LC2" class="line">            <span class="nt">&lt;groupId&gt;</span>org.springframework.cloud<span class="nt">&lt;/groupId&gt;</span></span>&#x000A;<span id="LC3" class="line">            <span class="nt">&lt;artifactId&gt;</span>spring-cloud-starter-hystrix<span class="nt">&lt;/artifactId&gt;</span></span>&#x000A;<span id="LC4" class="line">        <span class="nt">&lt;/dependency&gt;</span></span></pre></div></div>&#x000A;<ol start="3">&#x000A;<li>application.xml中配置端口和Eureka信息（必配）和其他框架的配置信息（可选，如mybatis）</li>&#x000A;<li>编写具体业务逻辑</li>&#x000A;<li>controller类中，在需要配置Fallback的方法上加入@@HystrixCommand(fallbackMethod = "XXX")注解，XXX为FallBack方法名本例中作为测试所以抛出了异常</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line">    <span class="nd">@ResponseBody</span></span>&#x000A;<span id="LC2" class="line">    <span class="nd">@GetMapping</span><span class="o">(</span><span class="s">"/dept/{id}"</span><span class="o">)</span></span>&#x000A;<span id="LC3" class="line">    <span class="nd">@HystrixCommand</span><span class="o">(</span><span class="n">fallbackMethod</span> <span class="o">=</span> <span class="s">"nullDeptFallBack"</span><span class="o">)</span></span>&#x000A;<span id="LC4" class="line">    <span class="kd">public</span> <span class="nc">Dept</span> <span class="nf">findById</span><span class="o">(</span><span class="nd">@PathVariable</span><span class="o">(</span><span class="s">"id"</span><span class="o">)</span><span class="nc">Integer</span> <span class="n">id</span><span class="o">)</span> <span class="o">{</span></span>&#x000A;<span id="LC5" class="line">        <span class="nc">Dept</span> <span class="n">dept</span> <span class="o">=</span> <span class="n">deptService</span><span class="o">.</span><span class="na">findById</span><span class="o">(</span><span class="n">id</span><span class="o">);</span></span>&#x000A;<span id="LC6" class="line">        <span class="k">if</span> <span class="o">(</span><span class="kc">null</span> <span class="o">==</span> <span class="n">dept</span><span class="o">){</span></span>&#x000A;<span id="LC7" class="line">            <span class="k">throw</span> <span class="k">new</span> <span class="nf">RuntimeException</span><span class="o">(</span><span class="s">"返回值为空！"</span><span class="o">);</span></span>&#x000A;<span id="LC8" class="line">        <span class="o">}</span></span>&#x000A;<span id="LC9" class="line">        <span class="k">return</span> <span class="n">dept</span><span class="o">;</span></span>&#x000A;<span id="LC10" class="line">    <span class="o">}</span></span></pre></div></div>&#x000A;<ol start="6">&#x000A;<li>根据需要配置FallBack的方法返回值编写代码</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"> <span class="kd">public</span> <span class="nc">Dept</span> <span class="nf">nullDeptFallBack</span><span class="o">(</span><span class="nd">@PathVariable</span><span class="o">(</span><span class="s">"id"</span><span class="o">)</span><span class="nc">Integer</span> <span class="n">id</span><span class="o">)</span> <span class="o">{</span></span>&#x000A;<span id="LC2" class="line">        <span class="nc">System</span><span class="o">.</span><span class="na">out</span><span class="o">.</span><span class="na">println</span><span class="o">(</span><span class="mi">111</span><span class="o">);</span></span>&#x000A;<span id="LC3" class="line">        <span class="k">return</span> <span class="k">new</span> <span class="nf">Dept</span><span class="o">().</span><span class="na">setId</span><span class="o">(</span><span class="n">id</span><span class="o">).</span><span class="na">setDeptName</span><span class="o">(</span><span class="s">"nullName"</span><span class="o">).</span><span class="na">setDbSource</span><span class="o">(</span><span class="s">"nullDB"</span><span class="o">);</span></span>&#x000A;<span id="LC4" class="line">    <span class="o">}</span></span></pre></div></div>&#x000A;<ol start="7">&#x000A;<li>主启动类中加入@EnableCircuitBreaker注解</li>&#x000A;<li>开启服务，测试</li>&#x000A;</ol>&#x000A;<h4>&#x000A;<a id="解耦与降级处理" class="anchor" href="#%E8%A7%A3%E8%80%A6%E4%B8%8E%E9%99%8D%E7%BA%A7%E5%A4%84%E7%90%86"></a>解耦与降级处理</h4>&#x000A;<h5>&#x000A;<a id="降级" class="anchor" href="#%E9%99%8D%E7%BA%A7"></a>降级</h5>&#x000A;<ul>&#x000A;<li>当系统整体资源快不够的时候，忍痛将部分服务暂时关闭，带渡过难关后，再重新开启。</li>&#x000A;<li>降级处理时在==客户端==完成的，与服务端没有关系</li>&#x000A;<li>理解：所谓降级，一般是从==整体负荷==考虑，当某个服务熔断之后，服务器将不再被调用，此时客户端可以自己准备一个本地的FallBack回调，返回一个缺省值。这样做虽然服务水平下降，但好歹可用，比直接挂掉好。</li>&#x000A;</ul>&#x000A;<h5>&#x000A;<a id="为什么要解耦" class="anchor" href="#%E4%B8%BA%E4%BB%80%E4%B9%88%E8%A6%81%E8%A7%A3%E8%80%A6"></a>为什么要解耦</h5>&#x000A;<p>如果按照上面的熔断案例来做的话，Controller下的每个方法，都要给其编写一个FallBack方法，当方法慢慢变多，就会造成代码膨胀，一个是增加编写的工作量，另外一个也会增大维护的难度，代码的耦合度也会高，是十分不合理的，所以要将其解耦。</p>&#x000A;<h5>&#x000A;<a id="解耦思路" class="anchor" href="#%E8%A7%A3%E8%80%A6%E6%80%9D%E8%B7%AF"></a>解耦思路</h5>&#x000A;<p>因为服务端的是通过实现接口访问服务端的，如果在父接口上实现了FallBack方法，通过这样一种方式去维护起来就能实现解耦，也顺便完成了降级的机制。</p>&#x000A;<h5>&#x000A;<a id="解耦降级案例" class="anchor" href="#%E8%A7%A3%E8%80%A6%E9%99%8D%E7%BA%A7%E6%A1%88%E4%BE%8B"></a>解耦&amp;降级案例</h5>&#x000A;<ol>&#x000A;<li>在api模块中新建实现了FallbackFactory接口的类，其中泛型T就是我们需要维护其FallBack的接口方法，并实现其create方法，在create方法中返回实现了T的对象，使用匿名内部类实现T。==注意：这个类一定要加@Component注解！！这个类一定要加@Component注解！！这个类一定要加@Component注解！！==</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="kn">import</span> <span class="nn">com.XXX.entity.Dept</span><span class="o">;</span></span>&#x000A;<span id="LC2" class="line"><span class="kn">import</span> <span class="nn">feign.hystrix.FallbackFactory</span><span class="o">;</span></span>&#x000A;<span id="LC3" class="line"><span class="kn">import</span> <span class="nn">org.springframework.stereotype.Component</span><span class="o">;</span></span>&#x000A;<span id="LC4" class="line"></span>&#x000A;<span id="LC5" class="line"><span class="kn">import</span> <span class="nn">java.util.List</span><span class="o">;</span></span>&#x000A;<span id="LC6" class="line"></span>&#x000A;<span id="LC7" class="line"><span class="nd">@Component</span></span>&#x000A;<span id="LC8" class="line"><span class="kd">public</span> <span class="kd">class</span> <span class="nc">DeptClientServiceFallBackFactory</span> <span class="kd">implements</span> <span class="nc">FallbackFactory</span><span class="o">&lt;</span><span class="nc">DeptClientService</span><span class="o">&gt;</span> <span class="o">{</span></span>&#x000A;<span id="LC9" class="line">    <span class="kd">public</span> <span class="nc">DeptClientService</span> <span class="nf">create</span><span class="o">(</span><span class="nc">Throwable</span> <span class="n">throwable</span><span class="o">)</span> <span class="o">{</span></span>&#x000A;<span id="LC10" class="line">        <span class="k">return</span> <span class="k">new</span> <span class="nf">DeptClientService</span><span class="o">()</span> <span class="o">{</span></span>&#x000A;<span id="LC11" class="line">            <span class="kd">public</span> <span class="kt">boolean</span> <span class="nf">addDept</span><span class="o">(</span><span class="nc">Dept</span> <span class="n">dept</span><span class="o">)</span> <span class="o">{</span></span>&#x000A;<span id="LC12" class="line">                <span class="k">return</span> <span class="kc">false</span><span class="o">;</span></span>&#x000A;<span id="LC13" class="line">            <span class="o">}</span></span>&#x000A;<span id="LC14" class="line"></span>&#x000A;<span id="LC15" class="line">            <span class="kd">public</span> <span class="nc">List</span><span class="o">&lt;</span><span class="nc">Dept</span><span class="o">&gt;</span> <span class="nf">findAll</span><span class="o">()</span> <span class="o">{</span></span>&#x000A;<span id="LC16" class="line">                <span class="k">return</span> <span class="kc">null</span><span class="o">;</span></span>&#x000A;<span id="LC17" class="line">            <span class="o">}</span></span>&#x000A;<span id="LC18" class="line"></span>&#x000A;<span id="LC19" class="line">            <span class="kd">public</span> <span class="nc">Dept</span> <span class="nf">findById</span><span class="o">(</span><span class="nc">Integer</span> <span class="n">id</span><span class="o">)</span> <span class="o">{</span></span>&#x000A;<span id="LC20" class="line">                <span class="k">return</span> <span class="k">new</span> <span class="nf">Dept</span><span class="o">().</span><span class="na">setId</span><span class="o">(</span><span class="n">id</span><span class="o">).</span><span class="na">setDeptName</span><span class="o">(</span><span class="s">"服务器跪了,"</span><span class="o">).</span><span class="na">setDbSource</span><span class="o">(</span><span class="s">"迟点来吧"</span><span class="o">);</span></span>&#x000A;<span id="LC21" class="line">            <span class="o">}</span></span>&#x000A;<span id="LC22" class="line">        <span class="o">};</span></span>&#x000A;<span id="LC23" class="line">    <span class="o">}</span></span>&#x000A;<span id="LC24" class="line"><span class="o">}</span></span></pre></div></div>&#x000A;<ol start="2">&#x000A;<li>修改步骤1中传入的泛型T接口，添加@FeignClient(fallbackFactory = T.class)注解</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="nd">@FeignClient</span><span class="o">(</span><span class="n">value</span> <span class="o">=</span> <span class="s">"MICROSERVICECLOUD-DEPT"</span><span class="o">,</span><span class="n">fallbackFactory</span> <span class="o">=</span> <span class="nc">DeptClientServiceFallBackFactory</span><span class="o">.</span><span class="na">class</span><span class="o">)</span></span>&#x000A;<span id="LC2" class="line"><span class="kd">public</span> <span class="kd">interface</span> <span class="nc">DeptClientService</span> <span class="o">{</span></span>&#x000A;<span id="LC3" class="line"></span>&#x000A;<span id="LC4" class="line">    <span class="nd">@PostMapping</span><span class="o">(</span><span class="s">"/dept"</span><span class="o">)</span></span>&#x000A;<span id="LC5" class="line">    <span class="kd">public</span> <span class="kt">boolean</span> <span class="nf">addDept</span><span class="o">(</span><span class="nc">Dept</span> <span class="n">dept</span><span class="o">);</span></span>&#x000A;<span id="LC6" class="line"></span>&#x000A;<span id="LC7" class="line">    <span class="nd">@GetMapping</span><span class="o">(</span><span class="s">"/dept"</span><span class="o">)</span></span>&#x000A;<span id="LC8" class="line">    <span class="kd">public</span> <span class="nc">List</span><span class="o">&lt;</span><span class="nc">Dept</span><span class="o">&gt;</span> <span class="nf">findAll</span><span class="o">();</span></span>&#x000A;<span id="LC9" class="line"></span>&#x000A;<span id="LC10" class="line">    <span class="nd">@GetMapping</span><span class="o">(</span><span class="s">"/dept/{id}"</span><span class="o">)</span></span>&#x000A;<span id="LC11" class="line">    <span class="kd">public</span> <span class="nc">Dept</span> <span class="nf">findById</span><span class="o">(</span><span class="nd">@PathVariable</span><span class="o">(</span><span class="s">"id"</span><span class="o">)</span><span class="nc">Integer</span> <span class="n">id</span><span class="o">);</span></span>&#x000A;<span id="LC12" class="line"><span class="o">}</span></span></pre></div></div>&#x000A;<ol start="3">&#x000A;<li>修改consumer feign模块的application.xml文件，开启hystrix（注：在IDEA中可能没有代码提示，开启的true也没有正常高亮，但好像不需要做额外操作也不影响结果）</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="na">feign</span><span class="pi">:</span></span>&#x000A;<span id="LC2" class="line">  <span class="na">hystrix</span><span class="pi">:</span></span>&#x000A;<span id="LC3" class="line">    <span class="na">enabled</span><span class="pi">:</span> <span class="no">true</span></span></pre></div></div>&#x000A;<ol start="4">&#x000A;<li>开启服务并测试</li>&#x000A;</ol>&#x000A;<h4>&#x000A;<a id="hystrixdashboard服务监控" class="anchor" href="#hystrixdashboard%E6%9C%8D%E5%8A%A1%E7%9B%91%E6%8E%A7"></a>HystrixDashboard服务监控</h4>&#x000A;<p>介绍：SpringCloud对Hystrix Dashboard进行了整合，可以对通过Hystrix发起的请求进行准实时统计，并以报表和图形的形式展示给用户（包括每秒执行多少次请求成功和失败等）。</p>&#x000A;<h5>&#x000A;<a id="配置案例" class="anchor" href="#%E9%85%8D%E7%BD%AE%E6%A1%88%E4%BE%8B"></a>配置案例</h5>&#x000A;<ol>&#x000A;<li>新建HystrixDashboard模块，pom.xml文件加入HystrixDashboard依赖，其他依赖包括Feign，Ribbon，Eureka（可参考80模块的依赖）</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line">        <span class="nt">&lt;dependency&gt;</span></span>&#x000A;<span id="LC2" class="line">            <span class="nt">&lt;groupId&gt;</span>org.springframework.cloud<span class="nt">&lt;/groupId&gt;</span></span>&#x000A;<span id="LC3" class="line">            <span class="nt">&lt;artifactId&gt;</span>spring-cloud-starter-hystrix-dashboard<span class="nt">&lt;/artifactId&gt;</span></span>&#x000A;<span id="LC4" class="line">        <span class="nt">&lt;/dependency&gt;</span></span></pre></div></div>&#x000A;<ol start="2">&#x000A;<li>application.yml文件中配置端口（如9001）</li>&#x000A;<li>provider类中确认要加入actuator依赖（此为监控依赖）</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line">        <span class="nt">&lt;dependency&gt;</span></span>&#x000A;<span id="LC2" class="line">            <span class="nt">&lt;groupId&gt;</span>org.springframework.boot<span class="nt">&lt;/groupId&gt;</span></span>&#x000A;<span id="LC3" class="line">            <span class="nt">&lt;artifactId&gt;</span>spring-boot-starter-actuator<span class="nt">&lt;/artifactId&gt;</span></span>&#x000A;<span id="LC4" class="line">        <span class="nt">&lt;/dependency&gt;</span></span></pre></div></div>&#x000A;<ol start="4">&#x000A;<li>编写主启动类，上标@EnableHystrixDashboard标注</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="nd">@SpringBootApplication</span></span>&#x000A;<span id="LC2" class="line"><span class="nd">@EnableHystrixDashboard</span></span>&#x000A;<span id="LC3" class="line"><span class="kd">public</span> <span class="kd">class</span> <span class="nc">DashBoard9001_APP</span> <span class="o">{</span></span>&#x000A;<span id="LC4" class="line">    <span class="kd">public</span> <span class="kd">static</span> <span class="kt">void</span> <span class="nf">main</span><span class="o">(</span><span class="nc">String</span><span class="o">[]</span> <span class="n">args</span><span class="o">)</span> <span class="o">{</span></span>&#x000A;<span id="LC5" class="line">        <span class="nc">SpringApplication</span><span class="o">.</span><span class="na">run</span><span class="o">(</span><span class="n">DashBoard9001_APP</span><span class="o">.</span><span class="na">class</span><span class="o">,</span><span class="n">args</span><span class="o">);</span></span>&#x000A;<span id="LC6" class="line">    <span class="o">}</span></span>&#x000A;<span id="LC7" class="line"><span class="o">}</span></span></pre></div></div>&#x000A;<ol start="5">&#x000A;<li>启动服务进行测试，访问地址：<a href="http://localhost:9001/hystrix%EF%BC%8C%EF%BC%88%E6%A0%B9%E6%8D%AE%E9%85%8D%E7%BD%AE%E7%AB%AF%E5%8F%A3%E5%8F%B7%EF%BC%89%EF%BC%8C==%E7%9C%8B%E5%88%B0%E5%88%BA%E7%8C%AC%E8%A1%A8%E7%A4%BA%E5%B7%B2%E7%BB%8F%E9%85%8D%E7%BD%AE%E5%A5%BD%E4%BA%86==">http://localhost:9001/hystrix，（根据配置端口号），==看到刺猬表示已经配置好了==</a>&#x000A;</li>&#x000A;</ol>&#x000A;<h5>&#x000A;<a id="如何监控" class="anchor" href="#%E5%A6%82%E4%BD%95%E7%9B%91%E6%8E%A7"></a>如何监控</h5>&#x000A;<ul>&#x000A;<li>在dashboard界面中，填入需要监控的服务地址和端口号加上\hystrix.stream和监测间隔即可进入监控。（如<a href="http://localhost:8001/hystrix.stream">http://localhost:8001/hystrix.stream</a>&#x000A;</li>&#x000A;</ul>&#x000A;<h5>&#x000A;<a id="监控分析" class="anchor" href="#%E7%9B%91%E6%8E%A7%E5%88%86%E6%9E%90"></a>监控分析</h5>&#x000A;<ul>&#x000A;<li>七色：进入监控界面后会有其中颜色的数字，其含义可以对应右上角相同颜色的单词表示的状态，其值代表该状态下触发的次数</li>&#x000A;<li>一圈：圈的大小代表该服务的流量，圈越大流量越大</li>&#x000A;<li>一线：代表监控间隔中，服务被访问的频率的折线图</li>&#x000A;<li>通过观察这些就可以在大量的实例中找出故障实例和高压实例进行修复和维护。</li>&#x000A;</ul>&#x000A;<p><img src="/xiongrj/springcloud-base/raw/master/images%5CHystrixDashboard%E7%9B%91%E6%8E%A7%E8%AF%B4%E6%98%8E%E5%9B%BE.png" alt="Dashboard监控说明图"></p>&#x000A;<h2>&#x000A;<a id="zuul路由网关" class="anchor" href="#zuul%E8%B7%AF%E7%94%B1%E7%BD%91%E5%85%B3"></a>Zuul路由网关</h2>&#x000A;<h3>&#x000A;<a id="概述" class="anchor" href="#%E6%A6%82%E8%BF%B0"></a>概述</h3>&#x000A;<ol>&#x000A;<li>&#x000A;<p>代理：Zuul提供外部的请求转发到具体的微服务实例中的服务</p>&#x000A;</li>&#x000A;<li>&#x000A;<p>路由：Zuul可以对外部访问实现统一的入口</p>&#x000A;</li>&#x000A;<li>&#x000A;<p>过滤：Zuul可以对外部访问进行干预，如请求校验、服务聚合等</p>&#x000A;</li>&#x000A;<li>&#x000A;<p>Zuul需要配合Eureka使用，需要在Eureka中注册并获得其他微服务的信息</p>&#x000A;</li>&#x000A;<li>&#x000A;<p>理解：Zuul就像大楼的保安，可以请他找人（代理），找的人在外面叫什么名字（路由），准不准你进楼（过滤）。因为保安属于物业公司，所以保安要在物业公司注册，所获得的信息也来源于物业公司（与Eureka的关系）。</p>&#x000A;</li>&#x000A;</ol>&#x000A;<h3>&#x000A;<a id="基本配置" class="anchor" href="#%E5%9F%BA%E6%9C%AC%E9%85%8D%E7%BD%AE"></a>基本配置</h3>&#x000A;<ol>&#x000A;<li>构建新的Zuul模块并在pom.xml中加入依赖（Zuul和Eureka必须同时加入）</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="nt">&lt;dependency&gt;</span></span>&#x000A;<span id="LC2" class="line">            <span class="nt">&lt;groupId&gt;</span>org.springframework.cloud<span class="nt">&lt;/groupId&gt;</span></span>&#x000A;<span id="LC3" class="line">            <span class="nt">&lt;artifactId&gt;</span>spring-cloud-starter-eureka<span class="nt">&lt;/artifactId&gt;</span></span>&#x000A;<span id="LC4" class="line"><span class="nt">&lt;/dependency&gt;</span></span>&#x000A;<span id="LC5" class="line"><span class="nt">&lt;dependency&gt;</span></span>&#x000A;<span id="LC6" class="line">       <span class="nt">&lt;groupId&gt;</span>org.springframework.cloud<span class="nt">&lt;/groupId&gt;</span></span>&#x000A;<span id="LC7" class="line">       <span class="nt">&lt;artifactId&gt;</span>spring-cloud-starter-zuul<span class="nt">&lt;/artifactId&gt;</span></span>&#x000A;<span id="LC8" class="line"><span class="nt">&lt;/dependency&gt;</span></span></pre></div></div>&#x000A;<ol start="2">&#x000A;<li>新建application.yml文件并配置（一定要向Eureka注册，因为Zuul本身也是一个微服务）</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="na">server</span><span class="pi">:</span></span>&#x000A;<span id="LC2" class="line">  <span class="na">port</span><span class="pi">:</span> <span class="m">9527</span></span>&#x000A;<span id="LC3" class="line"></span>&#x000A;<span id="LC4" class="line"><span class="na">spring</span><span class="pi">:</span></span>&#x000A;<span id="LC5" class="line">  <span class="na">application</span><span class="pi">:</span></span>&#x000A;<span id="LC6" class="line">    <span class="na">name</span><span class="pi">:</span> <span class="s">microservicecloud-zuul</span>   <span class="c1">#为这个服务取名，非常重要！！！！！</span></span>&#x000A;<span id="LC7" class="line"></span>&#x000A;<span id="LC8" class="line"><span class="na">eureka</span><span class="pi">:</span></span>&#x000A;<span id="LC9" class="line">  <span class="na">client</span><span class="pi">:</span></span>&#x000A;<span id="LC10" class="line">    <span class="na">service-url</span><span class="pi">:</span></span>&#x000A;<span id="LC11" class="line">      <span class="na">defaultZone</span><span class="pi">:</span> <span class="s">http://eureka7001.com:7001/eureka/,http://eureka7002.com:7002/eureka/,http://eureka7003.com:7003/eureka/</span></span>&#x000A;<span id="LC12" class="line">  <span class="na">instance</span><span class="pi">:</span></span>&#x000A;<span id="LC13" class="line">    <span class="na">instance-id</span><span class="pi">:</span> <span class="s">zuul.com</span></span>&#x000A;<span id="LC14" class="line">    <span class="na">prefer-ip-address</span><span class="pi">:</span> <span class="no">true</span></span></pre></div></div>&#x000A;<ol start="3">&#x000A;<li>修改hosts文件（非必须，不过能更好看出效果）</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line">127.0.0.0 zuul.com</span></pre></div></div>&#x000A;<ol start="4">&#x000A;<li>创建主启动类，并加入@EnableZuulProxy注解</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="nd">@SpringBootApplication</span></span>&#x000A;<span id="LC2" class="line"><span class="nd">@EnableZuulProxy</span></span>&#x000A;<span id="LC3" class="line"><span class="kd">public</span> <span class="kd">class</span> <span class="nc">Zuul9527_APP</span> <span class="o">{</span></span>&#x000A;<span id="LC4" class="line"></span>&#x000A;<span id="LC5" class="line">    <span class="kd">public</span> <span class="kd">static</span> <span class="kt">void</span> <span class="nf">main</span><span class="o">(</span><span class="nc">String</span><span class="o">[]</span> <span class="n">args</span><span class="o">)</span> <span class="o">{</span></span>&#x000A;<span id="LC6" class="line">        <span class="nc">SpringApplication</span><span class="o">.</span><span class="na">run</span><span class="o">(</span><span class="n">Zuul9527_APP</span><span class="o">.</span><span class="na">class</span><span class="o">,</span><span class="n">args</span><span class="o">);</span></span>&#x000A;<span id="LC7" class="line">    <span class="o">}</span></span>&#x000A;<span id="LC8" class="line"><span class="o">}</span></span></pre></div></div>&#x000A;<ol start="5">&#x000A;<li>&#x000A;<p>启动测试，访问规则：步骤3中指定映射+端口号+微服务名称+访问路径。</p>&#x000A;<p>例子：<a href="http://zuul.com:9527/microservicecloud-dept/dept">http://zuul.com:9527/microservicecloud-dept/dept</a></p>&#x000A;</li>&#x000A;</ol>&#x000A;<h3>&#x000A;<a id="路由访问映射规则" class="anchor" href="#%E8%B7%AF%E7%94%B1%E8%AE%BF%E9%97%AE%E6%98%A0%E5%B0%84%E8%A7%84%E5%88%99"></a>路由访问映射规则</h3>&#x000A;<h4>&#x000A;<a id="服务名映射和统一公共前缀" class="anchor" href="#%E6%9C%8D%E5%8A%A1%E5%90%8D%E6%98%A0%E5%B0%84%E5%92%8C%E7%BB%9F%E4%B8%80%E5%85%AC%E5%85%B1%E5%89%8D%E7%BC%80"></a>服务名映射和统一公共前缀</h4>&#x000A;<p>当不向暴露真实的服务名时，可以对服务名进行映射，只需在application.yml中配置即可，==具体作用看注释==</p>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="na">zuul</span><span class="pi">:</span></span>&#x000A;<span id="LC2" class="line">  <span class="na">routes</span><span class="pi">:</span></span>&#x000A;<span id="LC3" class="line"><span class="err">  	</span><span class="c1">#dept0是可以自定义的只是作为区分，没什么具体意义</span></span>&#x000A;<span id="LC4" class="line">    <span class="s">dept0.serviceId</span><span class="pi">:</span> <span class="s">microservicecloud-dept</span><span class="err">		</span></span>&#x000A;<span id="LC5" class="line">    <span class="c1">#路径也是自定义的，支持通配符</span></span>&#x000A;<span id="LC6" class="line">    <span class="s">dept0.path</span><span class="pi">:</span> <span class="s">/dept10/**</span><span class="err">						</span></span>&#x000A;<span id="LC7" class="line">  <span class="c1">#需要隐藏的服务名，可以使用通配符，配置之后通过这个微服务名访问就失效了</span></span>&#x000A;<span id="LC8" class="line">  <span class="na">ignored-services</span><span class="pi">:</span> <span class="s">microservicecloud-*</span></span>&#x000A;<span id="LC9" class="line">  <span class="c1">#设置统一公共前缀，设置后访问路径：http://zuul.com:9527/nihao/dept10/dept/3</span></span>&#x000A;<span id="LC10" class="line">  <span class="na">prefix</span><span class="pi">:</span> <span class="s">/nihao</span><span class="err">								</span></span></pre></div></div>&#x000A;<p>==注：因为Zuul是针对外部访问管理的，所以配置了隐藏的服务，在系统中其他模块进行服务名访问时依然可以正常运行的，这点可以通过打开consumer模块进行验证！==</p>&#x000A;<h2>&#x000A;<a id="springcloud-config-分布式配置中心" class="anchor" href="#springcloud-config-%E5%88%86%E5%B8%83%E5%BC%8F%E9%85%8D%E7%BD%AE%E4%B8%AD%E5%BF%83"></a>SpringCloud Config 分布式配置中心</h2>&#x000A;<p>分布式系统面临的配置问题：微服务意味着将单体应用拆分成一个个自服务，这些服务都是要相应的配置信息才能运行，随着系统内微服务数量越来越多，配置信息也不断地增多，所以一套集中式的、动态的配置管理设施是必不可少的。</p>&#x000A;<h3>&#x000A;<a id="概述-1" class="anchor" href="#%E6%A6%82%E8%BF%B0-1"></a>概述</h3>&#x000A;<ul>&#x000A;<li>SpringCloud Config是一个提供外部集中式配置管理的设施，配置服务器为各种不同的额微服务应用提供了一个中心化的外部配置</li>&#x000A;<li>SpringCloud Config分为客户端和服务端两部分&#x000A;<ol>&#x000A;<li>服务端：分布式配置中心，是一个独立的微服务，用来连接并为客户端提供配置信息，加密/解密信息等访问接口</li>&#x000A;<li>客户端：通过指定的配置中心获取配置资源，cloud推荐用git来存储配置信息</li>&#x000A;</ol>&#x000A;</li>&#x000A;<li>SpringCloud Config解决的问题：&#x000A;<ol>&#x000A;<li>集中管理配置文件</li>&#x000A;<li>不同环境不同配置，动态化的配置更新</li>&#x000A;<li>运行期间动态调整配置，不再需要在每个服务部署的机器上编写配置文件，让服务中心统一为服务拉取配置文件</li>&#x000A;<li>当配置发生变动时，服务不需要重启即可感知配置变化并应用</li>&#x000A;<li>将配置信息以REST接口形式暴露</li>&#x000A;</ol>&#x000A;</li>&#x000A;</ul>&#x000A;<p>![SpringCloud Config架构图](images\SpringCloud Config架构图.png)</p>&#x000A;<h3>&#x000A;<a id="springcloud-config服务端与github通讯" class="anchor" href="#springcloud-config%E6%9C%8D%E5%8A%A1%E7%AB%AF%E4%B8%8Egithub%E9%80%9A%E8%AE%AF"></a>SpringCloud Config服务端与Github通讯</h3>&#x000A;<p>目标：将配置文件部署在github，Config服务端从github获取配置</p>&#x000A;<h4>&#x000A;<a id="案例" class="anchor" href="#%E6%A1%88%E4%BE%8B"></a>案例</h4>&#x000A;<ol>&#x000A;<li>新建ConfigServer模块并配置pom.xml</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line">		<span class="c">&lt;!-- springCloud Config --&gt;</span></span>&#x000A;<span id="LC2" class="line">		<span class="nt">&lt;dependency&gt;</span></span>&#x000A;<span id="LC3" class="line">			<span class="nt">&lt;groupId&gt;</span>org.springframework.cloud<span class="nt">&lt;/groupId&gt;</span></span>&#x000A;<span id="LC4" class="line">			<span class="nt">&lt;artifactId&gt;</span>spring-cloud-config-server<span class="nt">&lt;/artifactId&gt;</span></span>&#x000A;<span id="LC5" class="line">		<span class="nt">&lt;/dependency&gt;</span></span>&#x000A;<span id="LC6" class="line">		<span class="c">&lt;!-- 避免Config的Git插件报错：org/eclipse/jgit/api/TransportConfigCallback --&gt;</span></span>&#x000A;<span id="LC7" class="line">		<span class="nt">&lt;dependency&gt;</span></span>&#x000A;<span id="LC8" class="line">			<span class="nt">&lt;groupId&gt;</span>org.eclipse.jgit<span class="nt">&lt;/groupId&gt;</span></span>&#x000A;<span id="LC9" class="line">			<span class="nt">&lt;artifactId&gt;</span>org.eclipse.jgit<span class="nt">&lt;/artifactId&gt;</span></span>&#x000A;<span id="LC10" class="line">			<span class="nt">&lt;version&gt;</span>4.10.0.201712302008-r<span class="nt">&lt;/version&gt;</span></span>&#x000A;<span id="LC11" class="line">		<span class="nt">&lt;/dependency&gt;</span></span></pre></div></div>&#x000A;<ol start="2">&#x000A;<li>建立远程仓库，并上传配置文件。如下例</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="na">spring</span><span class="pi">:</span> </span>&#x000A;<span id="LC2" class="line">    <span class="na">profiles</span><span class="pi">:</span> </span>&#x000A;<span id="LC3" class="line">        <span class="na">active</span><span class="pi">:</span></span>&#x000A;<span id="LC4" class="line">           <span class="pi">-</span> <span class="s">dev</span></span>&#x000A;<span id="LC5" class="line"><span class="nn">---</span></span>&#x000A;<span id="LC6" class="line"><span class="na">spring</span><span class="pi">:</span></span>&#x000A;<span id="LC7" class="line">    <span class="na">profiles</span><span class="pi">:</span> <span class="s">dev</span></span>&#x000A;<span id="LC8" class="line">    <span class="na">application</span><span class="pi">:</span></span>&#x000A;<span id="LC9" class="line">        <span class="na">name</span><span class="pi">:</span> <span class="s">microservicecloud-config-XXX-dev</span></span>&#x000A;<span id="LC10" class="line"><span class="nn">---</span></span>&#x000A;<span id="LC11" class="line"><span class="na">spring</span><span class="pi">:</span></span>&#x000A;<span id="LC12" class="line">    <span class="na">profiles</span><span class="pi">:</span> <span class="s">test</span></span>&#x000A;<span id="LC13" class="line">    <span class="na">application</span><span class="pi">:</span></span>&#x000A;<span id="LC14" class="line">        <span class="na">name</span><span class="pi">:</span> <span class="s">microservicecloud-config-XXX-test</span></span></pre></div></div>&#x000A;<ol start="3">&#x000A;<li>在application.xml文件中配置github地址</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="na">server</span><span class="pi">:</span></span>&#x000A;<span id="LC2" class="line">  <span class="na">port</span><span class="pi">:</span> <span class="m">3344</span></span>&#x000A;<span id="LC3" class="line"></span>&#x000A;<span id="LC4" class="line"><span class="na">spring</span><span class="pi">:</span></span>&#x000A;<span id="LC5" class="line">  <span class="na">application</span><span class="pi">:</span></span>&#x000A;<span id="LC6" class="line">    <span class="c1">#为这个服务取名，非常重要！！！！！</span></span>&#x000A;<span id="LC7" class="line">    <span class="na">name</span><span class="pi">:</span> <span class="s">microservicecloud-config</span></span>&#x000A;<span id="LC8" class="line">  <span class="na">cloud</span><span class="pi">:</span></span>&#x000A;<span id="LC9" class="line">    <span class="na">config</span><span class="pi">:</span></span>&#x000A;<span id="LC10" class="line">      <span class="na">server</span><span class="pi">:</span></span>&#x000A;<span id="LC11" class="line">        <span class="na">git</span><span class="pi">:</span></span>&#x000A;<span id="LC12" class="line">          <span class="c1"># uri填github上仓库地址</span></span>&#x000A;<span id="LC13" class="line">          <span class="na">uri</span><span class="pi">:</span> <span class="s">https://github.com/XXXX/SpringCloud_Configuration.git</span></span></pre></div></div>&#x000A;<ol start="4">&#x000A;<li>编写主启动类，加入@EnableConfigServer注解</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="nd">@SpringBootApplication</span></span>&#x000A;<span id="LC2" class="line"><span class="nd">@EnableConfigServer</span></span>&#x000A;<span id="LC3" class="line"><span class="kd">public</span> <span class="kd">class</span> <span class="nc">ConfigServer3344_APP</span> <span class="o">{</span></span>&#x000A;<span id="LC4" class="line">    <span class="kd">public</span> <span class="kd">static</span> <span class="kt">void</span> <span class="nf">main</span><span class="o">(</span><span class="nc">String</span><span class="o">[]</span> <span class="n">args</span><span class="o">)</span> <span class="o">{</span></span>&#x000A;<span id="LC5" class="line">        <span class="nc">SpringApplication</span><span class="o">.</span><span class="na">run</span><span class="o">(</span><span class="n">ConfigServer3344_APP</span><span class="o">.</span><span class="na">class</span><span class="o">,</span><span class="n">args</span><span class="o">);</span></span>&#x000A;<span id="LC6" class="line">    <span class="o">}</span></span>&#x000A;<span id="LC7" class="line"><span class="o">}</span></span></pre></div></div>&#x000A;<ol start="5">&#x000A;<li>启动服务并尝试访问配置文件，有以下五种访问配置规则&#x000A;<ul>&#x000A;<li>{application}：配置文件的文件名</li>&#x000A;<li>{profile}：读取的环境</li>&#x000A;<li>{lable}：分支</li>&#x000A;</ul>&#x000A;</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line">/<span class="o">{</span>application<span class="o">}</span>/<span class="o">{</span>profile<span class="o">}[</span>/<span class="o">{</span>lable<span class="o">}]</span></span>&#x000A;<span id="LC2" class="line">/<span class="o">{</span>application<span class="o">}</span>-<span class="o">{</span>profile<span class="o">}</span>.yml</span>&#x000A;<span id="LC3" class="line">/<span class="o">{</span>lable<span class="o">}</span>/<span class="o">{</span>application<span class="o">}</span>-<span class="o">{</span>profile<span class="o">}</span>.yml</span>&#x000A;<span id="LC4" class="line">/<span class="o">{</span>application<span class="o">}</span>-<span class="o">{</span>profile<span class="o">}</span>.properties</span>&#x000A;<span id="LC5" class="line">/<span class="o">{</span>lable<span class="o">}</span>/<span class="o">{</span>application<span class="o">}</span>-<span class="o">{</span>profile<span class="o">}</span>.properties</span></pre></div></div>&#x000A;<p>可用例子（返回格式可能不大相同，但返回值相同）：</p>&#x000A;<ul>&#x000A;<li><a href="http://config3344.com:3344/application-test.yml">http://config3344.com:3344/application-test.yml</a></li>&#x000A;<li><a href="http://config3344.com:3344/master/application-dev.yml">http://config3344.com:3344/master/application-dev.yml</a></li>&#x000A;<li><a href="http://config3344.com:3344/application-test.yml/master">http://config3344.com:3344/application-test.yml/master</a></li>&#x000A;</ul>&#x000A;<p>不可用例子：</p>&#x000A;<ul>&#x000A;<li>没有该环境，返回空值：<a href="http://config3344.com:3344/application-test11.yml/master">http://config3344.com:3344/application-test11.yml/master</a>&#x000A;</li>&#x000A;<li>没有配置文件，犯回错误页面：<a href="http://config3344.com:3344/lkjliiusdfsddsfl.yml">http://config3344.com:3344/lkjliiusdfsddsfl.yml</a>&#x000A;</li>&#x000A;</ul>&#x000A;<h3>&#x000A;<a id="bootstrapyml介绍" class="anchor" href="#bootstrapyml%E4%BB%8B%E7%BB%8D"></a>bootstrap.yml介绍</h3>&#x000A;<ul>&#x000A;<li>bootstrap.yml比application.yml具有更高的优先级。</li>&#x000A;<li>bootstrap.yml是系统级的资源配置项，application.yml是用户级的资源配置项。</li>&#x000A;<li>SpringCloud会创建"BootStrap Context"作为"ApplicationContext"的==父上下文==。初始化的时候BootStrap Context负责从外部源加载配置属性并解析。这两个上下文共享一个"Environment"，BootStrap 具有更高优先级，他们不会被本地配置覆盖。</li>&#x000A;</ul>&#x000A;<h3>&#x000A;<a id="客户端的配置与测试" class="anchor" href="#%E5%AE%A2%E6%88%B7%E7%AB%AF%E7%9A%84%E9%85%8D%E7%BD%AE%E4%B8%8E%E6%B5%8B%E8%AF%95"></a>客户端的配置与测试</h3>&#x000A;<p>介绍：客户端主要是在==加载时==通过config server服务端获得github配置仓库的地址，进而通过目标配置文件的文件名获取相应的配置，最后将取得的配置对自身资源进行赋值并提供访问</p>&#x000A;<h4>&#x000A;<a id="实现过程" class="anchor" href="#%E5%AE%9E%E7%8E%B0%E8%BF%87%E7%A8%8B"></a>实现过程</h4>&#x000A;<p>1.创建远程配置yml文件并上传到github上。如下测试案例因为需要进行测试，所以配置了两个profiles方便切换并观察</p>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="na">spring</span><span class="pi">:</span> </span>&#x000A;<span id="LC2" class="line">    <span class="na">profiles</span><span class="pi">:</span> </span>&#x000A;<span id="LC3" class="line">        <span class="na">active</span><span class="pi">:</span></span>&#x000A;<span id="LC4" class="line">           <span class="pi">-</span> <span class="s">dev</span></span>&#x000A;<span id="LC5" class="line"><span class="nn">---</span></span>&#x000A;<span id="LC6" class="line"><span class="na">server</span><span class="pi">:</span> </span>&#x000A;<span id="LC7" class="line">    <span class="na">port</span><span class="pi">:</span> <span class="m">8201</span></span>&#x000A;<span id="LC8" class="line"><span class="na">spring</span><span class="pi">:</span></span>&#x000A;<span id="LC9" class="line">    <span class="na">profiles</span><span class="pi">:</span> <span class="s">dev</span></span>&#x000A;<span id="LC10" class="line">    <span class="na">application</span><span class="pi">:</span></span>&#x000A;<span id="LC11" class="line">        <span class="na">name</span><span class="pi">:</span> <span class="s">microservicecloud-config-client-dev</span></span>&#x000A;<span id="LC12" class="line"><span class="na">eureka</span><span class="pi">:</span></span>&#x000A;<span id="LC13" class="line">    <span class="na">client</span><span class="pi">:</span> </span>&#x000A;<span id="LC14" class="line">        <span class="na">service-url</span><span class="pi">:</span> </span>&#x000A;<span id="LC15" class="line">            <span class="na">defaultZone</span><span class="pi">:</span> <span class="s">http://eureka-dev.com:7001/eureka/</span></span>&#x000A;<span id="LC16" class="line"><span class="nn">---</span></span>&#x000A;<span id="LC17" class="line"><span class="na">server</span><span class="pi">:</span> </span>&#x000A;<span id="LC18" class="line">    <span class="na">port</span><span class="pi">:</span> <span class="m">8202</span></span>&#x000A;<span id="LC19" class="line"><span class="na">spring</span><span class="pi">:</span></span>&#x000A;<span id="LC20" class="line">    <span class="na">profiles</span><span class="pi">:</span> <span class="s">test</span></span>&#x000A;<span id="LC21" class="line">    <span class="na">application</span><span class="pi">:</span></span>&#x000A;<span id="LC22" class="line">        <span class="na">name</span><span class="pi">:</span> <span class="s">microservicecloud-config-client-test</span></span>&#x000A;<span id="LC23" class="line"><span class="na">eureka</span><span class="pi">:</span></span>&#x000A;<span id="LC24" class="line">    <span class="na">client</span><span class="pi">:</span> </span>&#x000A;<span id="LC25" class="line">        <span class="na">service-url</span><span class="pi">:</span> </span>&#x000A;<span id="LC26" class="line">            <span class="na">defaultZone</span><span class="pi">:</span> <span class="s">http://eureka-dev.com:7001/eureka/</span></span></pre></div></div>&#x000A;<ol start="2">&#x000A;<li>本地创建config client模块，并配置好pom.xml，以下本组件是必选依赖</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line">        <span class="nt">&lt;dependency&gt;</span></span>&#x000A;<span id="LC2" class="line">            <span class="nt">&lt;groupId&gt;</span>org.springframework.cloud<span class="nt">&lt;/groupId&gt;</span></span>&#x000A;<span id="LC3" class="line">            <span class="nt">&lt;artifactId&gt;</span>spring-cloud-starter-config<span class="nt">&lt;/artifactId&gt;</span></span>&#x000A;<span id="LC4" class="line">        <span class="nt">&lt;/dependency&gt;</span></span></pre></div></div>&#x000A;<ol start="3">&#x000A;<li>编写bootstrap.yml配置文件，这个步骤比较关键，主要是根据此处的配置信息去寻找config server以获得github仓库地址和配置中的目标配置文件文件名</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="na">spring</span><span class="pi">:</span></span>&#x000A;<span id="LC2" class="line">  <span class="na">cloud</span><span class="pi">:</span></span>&#x000A;<span id="LC3" class="line">    <span class="na">config</span><span class="pi">:</span></span>&#x000A;<span id="LC4" class="line">      <span class="na">name</span><span class="pi">:</span> <span class="s">application_config</span> <span class="c1">#需要从github上读取的资源名称，注意没有yml后缀名</span></span>&#x000A;<span id="LC5" class="line">      <span class="na">profile</span><span class="pi">:</span> <span class="s">test</span>   <span class="c1">#本次访问的配置项</span></span>&#x000A;<span id="LC6" class="line">      <span class="na">label</span><span class="pi">:</span> <span class="s">master</span></span>&#x000A;<span id="LC7" class="line">      <span class="na">uri</span><span class="pi">:</span> <span class="s">http://config3344.com:3344</span>  <span class="c1">#本微服务启动后先去找3344号服务，通过SpringCloudConfig获取GitHub的服务地址</span></span></pre></div></div>&#x000A;<ol start="4">&#x000A;<li>application.yml文件在本module中其实是可写可不写的，为了习惯需要，还是给他写了个名字</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="na">spring</span><span class="pi">:</span></span>&#x000A;<span id="LC2" class="line">  <span class="na">application</span><span class="pi">:</span></span>&#x000A;<span id="LC3" class="line">    <span class="na">name</span><span class="pi">:</span> <span class="s">microservicecloud_config</span></span></pre></div></div>&#x000A;<ol start="5">&#x000A;<li>修改host文件增加映射，和3344一样</li>&#x000A;<li>编写主启动类，没什么特别的，最基本的主启动类</li>&#x000A;<li>编写controller，此步骤也比较关键，主要是利用@Value注解赋值，若写错了bootstrap.yml中的配置文件名称而没有获取到配置，启动时这里会抛出异常。@Value中注解的参数即是目标配置文件中的参数值，使用El表达式获取</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="nd">@org</span><span class="o">.</span><span class="na">springframework</span><span class="o">.</span><span class="na">web</span><span class="o">.</span><span class="na">bind</span><span class="o">.</span><span class="na">annotation</span><span class="o">.</span><span class="na">RestController</span></span>&#x000A;<span id="LC2" class="line"><span class="kd">public</span> <span class="kd">class</span> <span class="nc">RestController</span> <span class="o">{</span></span>&#x000A;<span id="LC3" class="line">    <span class="nd">@Value</span><span class="o">(</span><span class="s">"${server.port}"</span><span class="o">)</span></span>&#x000A;<span id="LC4" class="line">    <span class="kd">private</span> <span class="nc">String</span> <span class="n">port</span><span class="o">;</span></span>&#x000A;<span id="LC5" class="line">    <span class="nd">@Value</span><span class="o">(</span><span class="s">"${eureka.client.service-url.defaultZone}"</span><span class="o">)</span></span>&#x000A;<span id="LC6" class="line">    <span class="kd">private</span> <span class="nc">String</span> <span class="n">eurekaZone</span><span class="o">;</span></span>&#x000A;<span id="LC7" class="line">    <span class="nd">@Value</span><span class="o">(</span><span class="s">"${spring.application.name}"</span><span class="o">)</span></span>&#x000A;<span id="LC8" class="line">    <span class="kd">private</span> <span class="nc">String</span> <span class="n">name</span><span class="o">;</span></span>&#x000A;<span id="LC9" class="line"></span>&#x000A;<span id="LC10" class="line"></span>&#x000A;<span id="LC11" class="line">    <span class="nd">@GetMapping</span><span class="o">(</span><span class="s">"/config"</span><span class="o">)</span></span>&#x000A;<span id="LC12" class="line">    <span class="nd">@Override</span></span>&#x000A;<span id="LC13" class="line">    <span class="kd">public</span> <span class="nc">String</span> <span class="nf">toString</span><span class="o">()</span> <span class="o">{</span></span>&#x000A;<span id="LC14" class="line">        <span class="k">return</span> <span class="s">"RestController{"</span> <span class="o">+</span></span>&#x000A;<span id="LC15" class="line">                <span class="s">"port='"</span> <span class="o">+</span> <span class="n">port</span> <span class="o">+</span> <span class="sc">'\''</span> <span class="o">+</span></span>&#x000A;<span id="LC16" class="line">                <span class="s">", eurekaZone='"</span> <span class="o">+</span> <span class="n">eurekaZone</span> <span class="o">+</span> <span class="sc">'\''</span> <span class="o">+</span></span>&#x000A;<span id="LC17" class="line">                <span class="s">", name='"</span> <span class="o">+</span> <span class="n">name</span> <span class="o">+</span> <span class="sc">'\''</span> <span class="o">+</span></span>&#x000A;<span id="LC18" class="line">                <span class="sc">'}'</span><span class="o">;</span></span>&#x000A;<span id="LC19" class="line">    <span class="o">}</span></span>&#x000A;<span id="LC20" class="line"><span class="o">}</span></span>&#x000A;<span id="LC21" class="line"></span></pre></div></div>&#x000A;<ol start="8">&#x000A;<li>先启动config server服务，然后再启用本client服务，根据profiles的值访问对应的端口即可。如本例选择的是test，则访问端口为：<a href="http://config3355.com:8202/config%E3%80%82%EF%BC%88config3355.com%E4%B8%BAhosts%E6%96%87%E4%BB%B6%E4%B8%AD%E9%85%8D%E7%BD%AE%E4%BA%86%E7%9A%84%E6%98%A0%E5%B0%84%EF%BC%89">http://config3355.com:8202/config。（config3355.com为hosts文件中配置了的映射）</a>&#x000A;</li>&#x000A;</ol>&#x000A;<h3>&#x000A;<a id="springcloud的配置实战" class="anchor" href="#springcloud%E7%9A%84%E9%85%8D%E7%BD%AE%E5%AE%9E%E6%88%98"></a>SpringCloud的配置实战</h3>&#x000A;<p>介绍：其实前面client的配置案例都是帮助理解这个组件为主，并没有很大的实际意义。。。。。。这节的案例中是配置一个Provider，一个eureka，他们的配置统一在github上获取，实现统一配置分布式管理和多环境变更，这个才比较有实战意义。</p>&#x000A;<h4>&#x000A;<a id="实现过程-1" class="anchor" href="#%E5%AE%9E%E7%8E%B0%E8%BF%87%E7%A8%8B-1"></a>实现过程</h4>&#x000A;<ol>&#x000A;<li>先写好provider和Eureka的配置yml文件，这两个文件和平常配置没什么不同，因为这里主要是说config，所以就没有配置集群，上传yml到github</li>&#x000A;</ol>&#x000A;<p>Eureka配置文件示例：</p>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="na">spring</span><span class="pi">:</span> </span>&#x000A;<span id="LC2" class="line">    <span class="na">profiles</span><span class="pi">:</span> </span>&#x000A;<span id="LC3" class="line">        <span class="na">active</span><span class="pi">:</span></span>&#x000A;<span id="LC4" class="line">           <span class="pi">-</span> <span class="s">dev</span></span>&#x000A;<span id="LC5" class="line"><span class="nn">---</span></span>&#x000A;<span id="LC6" class="line"><span class="na">spring</span><span class="pi">:</span></span>&#x000A;<span id="LC7" class="line">    <span class="na">profiles</span><span class="pi">:</span> <span class="s">dev</span></span>&#x000A;<span id="LC8" class="line">    <span class="na">application</span><span class="pi">:</span></span>&#x000A;<span id="LC9" class="line">        <span class="na">name</span><span class="pi">:</span> <span class="s">microservicecloud-eureka-client-dev</span></span>&#x000A;<span id="LC10" class="line"><span class="na">server</span><span class="pi">:</span></span>&#x000A;<span id="LC11" class="line">  <span class="na">port</span><span class="pi">:</span> <span class="m">7001</span></span>&#x000A;<span id="LC12" class="line"><span class="na">eureka</span><span class="pi">:</span></span>&#x000A;<span id="LC13" class="line">  <span class="na">instance</span><span class="pi">:</span></span>&#x000A;<span id="LC14" class="line">    <span class="na">hostname</span><span class="pi">:</span> <span class="s">eureka7001.com</span>    <span class="c1">#hostname为hosts文件中映射的地址</span></span>&#x000A;<span id="LC15" class="line">  <span class="na">client</span><span class="pi">:</span></span>&#x000A;<span id="LC16" class="line">    <span class="na">register-with-eureka</span><span class="pi">:</span> <span class="no">false</span>     <span class="c1">#false表示不向注册中心注册自己</span></span>&#x000A;<span id="LC17" class="line">    <span class="na">fetch-registry</span><span class="pi">:</span> <span class="no">false</span>           <span class="c1">#false表示自己就是注册中心，职责是维护实例，不参加检索</span></span>&#x000A;<span id="LC18" class="line">    <span class="na">service-url</span><span class="pi">:</span></span>&#x000A;<span id="LC19" class="line">      <span class="na">defaultZone</span><span class="pi">:</span> <span class="s">http://eureka7001.com:7001/eureka/</span>   <span class="c1">#设置eureka server的交互地址</span></span>&#x000A;<span id="LC20" class="line"></span>&#x000A;<span id="LC21" class="line"><span class="nn">---</span></span>&#x000A;<span id="LC22" class="line"><span class="na">spring</span><span class="pi">:</span></span>&#x000A;<span id="LC23" class="line">    <span class="na">profiles</span><span class="pi">:</span> <span class="s">test</span></span>&#x000A;<span id="LC24" class="line">    <span class="na">application</span><span class="pi">:</span></span>&#x000A;<span id="LC25" class="line">        <span class="na">name</span><span class="pi">:</span> <span class="s">microservicecloud-eureka-client-dev</span></span>&#x000A;<span id="LC26" class="line"><span class="na">server</span><span class="pi">:</span></span>&#x000A;<span id="LC27" class="line">  <span class="na">port</span><span class="pi">:</span> <span class="m">7001</span></span>&#x000A;<span id="LC28" class="line"><span class="na">eureka</span><span class="pi">:</span></span>&#x000A;<span id="LC29" class="line">  <span class="na">instance</span><span class="pi">:</span></span>&#x000A;<span id="LC30" class="line">    <span class="na">hostname</span><span class="pi">:</span> <span class="s">eureka7001.com</span>    <span class="c1">#hostname为hosts文件中映射的地址</span></span>&#x000A;<span id="LC31" class="line">  <span class="na">client</span><span class="pi">:</span></span>&#x000A;<span id="LC32" class="line">    <span class="na">register-with-eureka</span><span class="pi">:</span> <span class="no">false</span>     <span class="c1">#false表示不向注册中心注册自己</span></span>&#x000A;<span id="LC33" class="line">    <span class="na">fetch-registry</span><span class="pi">:</span> <span class="no">false</span>           <span class="c1">#false表示自己就是注册中心，职责是维护实例，不参加检索</span></span>&#x000A;<span id="LC34" class="line">    <span class="na">service-url</span><span class="pi">:</span></span>&#x000A;<span id="LC35" class="line">      <span class="na">defaultZone</span><span class="pi">:</span> <span class="s">http://eureka7001.com:7001/eureka/</span>    <span class="c1">#设置eureka server的交互地址</span></span></pre></div></div>&#x000A;<p>Provider配置文件示例：</p>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="na">spring</span><span class="pi">:</span> </span>&#x000A;<span id="LC2" class="line">    <span class="na">profiles</span><span class="pi">:</span> </span>&#x000A;<span id="LC3" class="line">        <span class="na">active</span><span class="pi">:</span></span>&#x000A;<span id="LC4" class="line">           <span class="pi">-</span> <span class="s">dev</span></span>&#x000A;<span id="LC5" class="line"><span class="nn">---</span></span>&#x000A;<span id="LC6" class="line"><span class="na">server</span><span class="pi">:</span></span>&#x000A;<span id="LC7" class="line">  <span class="na">port</span><span class="pi">:</span> <span class="m">8001</span></span>&#x000A;<span id="LC8" class="line"></span>&#x000A;<span id="LC9" class="line"><span class="na">mybatis</span><span class="pi">:</span></span>&#x000A;<span id="LC10" class="line">  <span class="na">config-location</span><span class="pi">:</span> <span class="s">classpath:mybatis/mybatis.cfg.xml</span></span>&#x000A;<span id="LC11" class="line">  <span class="na">type-aliases-package</span><span class="pi">:</span> <span class="s">com.XXX.entity</span></span>&#x000A;<span id="LC12" class="line">  <span class="na">mapper-locations</span><span class="pi">:</span></span>&#x000A;<span id="LC13" class="line">  <span class="pi">-</span> <span class="s">classpath:mybatis/mapper/**/*.xml</span></span>&#x000A;<span id="LC14" class="line"><span class="na">spring</span><span class="pi">:</span></span>&#x000A;<span id="LC15" class="line">  <span class="na">profiles</span><span class="pi">:</span> <span class="s">dev</span></span>&#x000A;<span id="LC16" class="line">  <span class="na">application</span><span class="pi">:</span></span>&#x000A;<span id="LC17" class="line">    <span class="na">name</span><span class="pi">:</span> <span class="s">microservicecloud-dept</span>   <span class="c1">#为这个服务取名，非常重要！！！！！</span></span>&#x000A;<span id="LC18" class="line">  <span class="na">datasource</span><span class="pi">:</span></span>&#x000A;<span id="LC19" class="line">    <span class="na">type</span><span class="pi">:</span> <span class="s">com.alibaba.druid.pool.DruidDataSource</span></span>&#x000A;<span id="LC20" class="line">    <span class="na">driver-class-name</span><span class="pi">:</span> <span class="s">org.gjt.mm.mysql.Driver</span></span>&#x000A;<span id="LC21" class="line">    <span class="na">url</span><span class="pi">:</span> <span class="s">jdbc:mysql://192.168.88.246:3306/cloudDB01</span></span>&#x000A;<span id="LC22" class="line">    <span class="na">username</span><span class="pi">:</span> <span class="s">root</span></span>&#x000A;<span id="LC23" class="line">    <span class="na">password</span><span class="pi">:</span> <span class="m">123456</span></span>&#x000A;<span id="LC24" class="line">    <span class="na">dbcp2</span><span class="pi">:</span></span>&#x000A;<span id="LC25" class="line">      <span class="na">min-idle</span><span class="pi">:</span> <span class="m">5</span>         <span class="c1">#最小连接数</span></span>&#x000A;<span id="LC26" class="line">      <span class="na">initial-size</span><span class="pi">:</span> <span class="m">5</span>    <span class="c1">#初始化连接数</span></span>&#x000A;<span id="LC27" class="line">      <span class="na">max-total</span><span class="pi">:</span> <span class="m">10</span>      <span class="c1">#最大连接数</span></span>&#x000A;<span id="LC28" class="line">      <span class="na">max-wait-millis</span><span class="pi">:</span> <span class="m">200</span>  <span class="c1">#等待连接最长的超时时间</span></span>&#x000A;<span id="LC29" class="line"><span class="na">eureka</span><span class="pi">:</span></span>&#x000A;<span id="LC30" class="line">  <span class="na">client</span><span class="pi">:</span></span>&#x000A;<span id="LC31" class="line">    <span class="na">service-url</span><span class="pi">:</span></span>&#x000A;<span id="LC32" class="line">      <span class="na">defaultZone</span><span class="pi">:</span> <span class="s">http://eureka7001.com:7001/eureka/</span></span>&#x000A;<span id="LC33" class="line">  <span class="na">instance</span><span class="pi">:</span></span>&#x000A;<span id="LC34" class="line">    <span class="na">instance-id</span><span class="pi">:</span> <span class="s">dept8001</span></span>&#x000A;<span id="LC35" class="line">    <span class="na">prefer-ip-address</span><span class="pi">:</span> <span class="no">true</span></span>&#x000A;<span id="LC36" class="line"><span class="nn">---</span></span>&#x000A;<span id="LC37" class="line"><span class="na">server</span><span class="pi">:</span></span>&#x000A;<span id="LC38" class="line">  <span class="na">port</span><span class="pi">:</span> <span class="m">8001</span></span>&#x000A;<span id="LC39" class="line"></span>&#x000A;<span id="LC40" class="line"><span class="na">mybatis</span><span class="pi">:</span></span>&#x000A;<span id="LC41" class="line">  <span class="na">config-location</span><span class="pi">:</span> <span class="s">classpath:mybatis/mybatis.cfg.xml</span></span>&#x000A;<span id="LC42" class="line">  <span class="na">type-aliases-package</span><span class="pi">:</span> <span class="s">com.XXX.entity</span></span>&#x000A;<span id="LC43" class="line">  <span class="na">mapper-locations</span><span class="pi">:</span></span>&#x000A;<span id="LC44" class="line">  <span class="pi">-</span> <span class="s">classpath:mybatis/mapper/**/*.xml</span></span>&#x000A;<span id="LC45" class="line"><span class="na">spring</span><span class="pi">:</span></span>&#x000A;<span id="LC46" class="line">  <span class="na">profiles</span><span class="pi">:</span> <span class="s">test</span></span>&#x000A;<span id="LC47" class="line">  <span class="na">application</span><span class="pi">:</span></span>&#x000A;<span id="LC48" class="line">    <span class="na">name</span><span class="pi">:</span> <span class="s">microservicecloud-dept</span>   <span class="c1">#为这个服务取名，非常重要！！！！！</span></span>&#x000A;<span id="LC49" class="line">  <span class="na">datasource</span><span class="pi">:</span></span>&#x000A;<span id="LC50" class="line">    <span class="na">type</span><span class="pi">:</span> <span class="s">com.alibaba.druid.pool.DruidDataSource</span></span>&#x000A;<span id="LC51" class="line">    <span class="na">driver-class-name</span><span class="pi">:</span> <span class="s">org.gjt.mm.mysql.Driver</span></span>&#x000A;<span id="LC52" class="line">    <span class="na">url</span><span class="pi">:</span> <span class="s">jdbc:mysql://192.168.88.246:3306/cloudDB02</span></span>&#x000A;<span id="LC53" class="line">    <span class="na">username</span><span class="pi">:</span> <span class="s">root</span></span>&#x000A;<span id="LC54" class="line">    <span class="na">password</span><span class="pi">:</span> <span class="m">123456</span></span>&#x000A;<span id="LC55" class="line">    <span class="na">dbcp2</span><span class="pi">:</span></span>&#x000A;<span id="LC56" class="line">      <span class="na">min-idle</span><span class="pi">:</span> <span class="m">5</span>         <span class="c1">#最小连接数</span></span>&#x000A;<span id="LC57" class="line">      <span class="na">initial-size</span><span class="pi">:</span> <span class="m">5</span>    <span class="c1">#初始化连接数</span></span>&#x000A;<span id="LC58" class="line">      <span class="na">max-total</span><span class="pi">:</span> <span class="m">10</span>      <span class="c1">#最大连接数</span></span>&#x000A;<span id="LC59" class="line">      <span class="na">max-wait-millis</span><span class="pi">:</span> <span class="m">200</span>  <span class="c1">#等待连接最长的超时时间</span></span>&#x000A;<span id="LC60" class="line"><span class="na">eureka</span><span class="pi">:</span></span>&#x000A;<span id="LC61" class="line">  <span class="na">client</span><span class="pi">:</span></span>&#x000A;<span id="LC62" class="line">    <span class="na">service-url</span><span class="pi">:</span></span>&#x000A;<span id="LC63" class="line">      <span class="na">defaultZone</span><span class="pi">:</span> <span class="s">http://eureka7001.com:7001/eureka/</span></span>&#x000A;<span id="LC64" class="line">  <span class="na">instance</span><span class="pi">:</span></span>&#x000A;<span id="LC65" class="line">    <span class="na">instance-id</span><span class="pi">:</span> <span class="s">dept8001</span></span>&#x000A;<span id="LC66" class="line">    <span class="na">prefer-ip-address</span><span class="pi">:</span> <span class="no">true</span></span></pre></div></div>&#x000A;<ol start="2">&#x000A;<li>新开eureka和provide的模块并在pom.xml中添加依赖，其他必要依赖和之前的案例一样，但是config的依赖一定要添加上</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line">        <span class="nt">&lt;dependency&gt;</span></span>&#x000A;<span id="LC2" class="line">            <span class="nt">&lt;groupId&gt;</span>org.springframework.cloud<span class="nt">&lt;/groupId&gt;</span></span>&#x000A;<span id="LC3" class="line">            <span class="nt">&lt;artifactId&gt;</span>spring-cloud-starter-config<span class="nt">&lt;/artifactId&gt;</span></span>&#x000A;<span id="LC4" class="line">        <span class="nt">&lt;/dependency&gt;</span></span></pre></div></div>&#x000A;<ol start="3">&#x000A;<li>两个模块都要编写bootstrap.yml文件，和上面的案例一样</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="na">spring</span><span class="pi">:</span></span>&#x000A;<span id="LC2" class="line">  <span class="na">cloud</span><span class="pi">:</span></span>&#x000A;<span id="LC3" class="line">    <span class="na">config</span><span class="pi">:</span></span>&#x000A;<span id="LC4" class="line">      <span class="na">name</span><span class="pi">:</span> <span class="s">application_config</span> <span class="c1">#需要从github上读取的资源名称，注意没有yml后缀名</span></span>&#x000A;<span id="LC5" class="line">      <span class="na">profile</span><span class="pi">:</span> <span class="s">test</span>   <span class="c1">#本次访问的配置项</span></span>&#x000A;<span id="LC6" class="line">      <span class="na">label</span><span class="pi">:</span> <span class="s">master</span></span>&#x000A;<span id="LC7" class="line">      <span class="na">uri</span><span class="pi">:</span> <span class="s">http://config3344.com:3344</span>  <span class="c1">#本微服务启动后先去找3344号服务，通过SpringCloudConfig获取GitHub的服务地址</span></span></pre></div></div>&#x000A;<ol start="4">&#x000A;<li>(可选)两个模块中编写application.yml文件，可以配置一下服务名</li>&#x000A;</ol>&#x000A;<div class="white"><div class="highlight"><pre><span id="LC1" class="line"><span class="na">spring</span><span class="pi">:</span></span>&#x000A;<span id="LC2" class="line">  <span class="na">application</span><span class="pi">:</span></span>&#x000A;<span id="LC3" class="line">    <span class="na">name</span><span class="pi">:</span> <span class="s">microservicecloud_config</span></span></pre></div></div>&#x000A;<ol start="5">&#x000A;<li>两个模块的主启动类，Eureka的正常加EurekaServer注解，Provider加EurekaClient注解，不详述</li>&#x000A;<li>编写Provider模块的业务代码</li>&#x000A;<li>启动测试，因为这两个模块都要通过3344ConfigServer为其在github上获取配置，所以要先启动3344模块，然后再一次启动eureka和provider模块，进行测试即可。</li>&#x000A;</ol></div>
<script>
  toMathMlCode('','markdown-body');
</script>

</div>
</div>
<div class='tree_progress'></div>
<div class='ui small modal' id='modal-linejump'>
<div class='ui custom form content'>
<div class='field'>
<div class='ui right action input'>
<input placeholder='Jump to line...' type='number'>
<div class='ui orange button'>
Go
</div>
</div>
</div>
</div>
</div>

<div class='row column inner-comment' id='blob-comment'>
<input id="comment_path" name="comment_path" type="hidden" value="README.md" />
<div class='tree-comments'>
<h3 id='tree_comm_title'>
Comment
(
<span class='comments-count'>
0
</span>
)
</h3>
<div class='ui threaded comments middle aligned' id='notes-list'></div>
<input id="ajax_add_note_id" name="ajax_add_note_id" type="hidden" />
<div class='text-center'>
<div class='tip-loading' style='display: none'>
<div class='ui active mini inline loader'></div>
Loading...
</div>
</div>
</div>
<script>
  "use strict";
  $(function(){
    var page = 1
    var commentsCount = 0
    var $container = $('.tree-comments')
    var $comments = $container.find('.ui.comments')
    var $tipLoading = $container.find('.tip-loading')
    var $btnLoad = $container.find('.btn-load-more')
    var noteAnchor = new Gitee.NoteAnchor({ defaultAnchor: '#tree_comm_title' })
  
    if (commentsCount < 1) {
      return;
    }
  
    var path;
    if ($('#comment_path').val() === '') {
      path = '/';
    } else {
      path = $('#comment_path').val();
    }
  
    function loadComments () {
      $btnLoad.hide();
      $tipLoading.show();
      $.ajax({
        url: '/xiongrj/springcloud-base/comment_list',
        data: {
          page: page,
          path: path
        },
        success: function(data) {
          var err;
          try {
            $tipLoading.hide();
            $btnLoad.show();
            if (data.status !== 0) {
              $btnLoad.text('No more comments')
              return $btnLoad.prop('disabled', true).addClass('disabled');
            } else {
              TreeComment.CommentListHandler(data);
              page += 1;
              if (data.comments_count < 10) {
                $('#ajax_add_note_id').val('');
                $btnLoad.text('No more comments')
                $btnLoad.prop('disabled', true).addClass('disabled');
              }
              // osctree can not load script
              $comments.find('.timeago').timeago();
              $comments.find('.commenter-role-label').popup();
              noteAnchor.locate();
              toMathMlCode('', 'comments');
              return $('.markdown-body pre code').each(function(i, block) {
                return hljs.highlightBlock(block);
              });
            }
          } catch (error) {
            err = error;
            return console.log('loadComments error:' + err);
          }
        }
      });
    };
  
  
    function checkLoad () {
      var listTop, top;
      top = $(window).scrollTop();
      listTop = $container.offset().top;
      if (listTop >= top && listTop < top + $(window).height()) {
        $(window).off('scroll', checkLoad);
        return loadComments();
      }
    };
  
    $btnLoad.on('click', loadComments);
    loadComments()
  })
</script>

</div>
<div class='inner-comment-box' id='comment-box'>
<p>
<a href="/login">Sign in</a> for post a comment
</p>

</div>

<div class='complaint'>
<div class='ui modal small form' id='landing-comments-complaint-modal'>
<i class='iconfont icon-close close'></i>
<div class='header'>
Report
</div>
<div class='content'>
<div class='appeal-success-tip hide'>
<i class='iconfont icon-ic_msg_success'></i>
<div class='appeal-success-text'>
Report success
</div>
<span>
We will send you the feedback within 2 working days through the letter!
</span>
</div>
<div class='appeal-tip'>
Please fill in the reason for the report carefully. Provide as detailed a description as possible.
</div>
<div class='ui form appeal-form'>
<div class='inline field'>
<label class='left-part appeal-type-wrap'>
Type
</label>
<div class='ui dropdown selection' id='appeal-comments-types'>
<div class='text default'>
Please select a report type
</div>
<i class='dropdown icon'></i>
<div class='menu'></div>
</div>
</div>
<div class='inline field'>
<label class='left-part'>
Reason
</label>
<textarea class='appeal-reason' id='appeal-comment-reason' name='msg' placeholder='Please explain the reason for the report' rows='3'></textarea>
</div>
<div class='ui message callback-msg hide'></div>
<div class='ui small error text message exceeded-size-tip'></div>
</div>
</div>
<div class='actions'>
<div class='ui button blank cancel'>
Cancel
</div>
<div class='ui orange icon button disabled ok' id='complaint-comment-confirm'>
Send
</div>
</div>
</div>
<script>
  var $complaintCommentsModal = $('#landing-comments-complaint-modal'),
      $complainCommentType = $complaintCommentsModal.find('#appeal-comments-types'),
      $complaintModalTip = $complaintCommentsModal.find('.callback-msg'),
      $complaintCommentsContent = $complaintCommentsModal.find('.appeal-reason'),
      $complaintCommentBtn = $complaintCommentsModal.find('#complaint-comment-confirm'),
      complaintSending = false,
      initedCommentsType = false;
  
  function initCommentsTypeList() {
    if (!initedCommentsType) {
      $.ajax({
        url: "/appeals/fetch_types",
        method: 'get',
        data: {'type': 'comment'},
        success: function (data) {
          var result = '';
          for (var i = 0; i < data.length; i++) {
            result = result + "<div class='item' data-value='" + data[i].id + "'>" + data[i].name + "</div>";
          }
          $complainCommentType.find('.menu').html(result);
        }
      });
      $complainCommentType.dropdown({showOnFocus: false});
      initedCommentsType = true;
    }
  }
  $complainCommentType.on('click', function() {
    $complaintCommentsModal.modal({
      autofocus: false,
      onApprove: function() {
        return false;
      },
      onHidden: function() {
        restoreCommonentDefault();
      }
    }).modal('show');
  });
  
  $complaintCommentsContent.on('change keyup', function(e) {
    var content = $(this).val();
    if ($.trim(content).length > 0 && $complainCommentType.dropdown('get value').length > 0 ) {
      $complaintCommentBtn.removeClass('disabled');
      return;
    }
    $complaintCommentBtn.addClass('disabled');
  });
  
  
  $complainCommentType.dropdown({
    showOnFocus: false,
    onChange: function(value, text, $selectedItem) {
      if (value.length > 0 && $.trim($complaintCommentsContent.val()).length > 0) {
        $complaintCommentBtn.removeClass('disabled');
        return
      }
      $complaintCommentBtn.addClass('disabled');
    }
  });
  
  function restoreCommonentDefault() {
    $complainCommentType.dropdown('restore defaults');
    $complaintCommentsContent.val('');
    $('.exceeded-size-tip').text('').hide();
    $complaintModalTip.text('').hide();
    setTimeout(function() {
      setCommentSendTip(false);
    }, 1500);
  }
  
  $complaintCommentBtn.on('click',function(e){
    var reason = $complaintCommentsContent.val();
    var appealableId = $('#landing-comments-complaint-modal').attr('data-id');
    if (complaintSending) {
      return;
    }
    var appealType = $complainCommentType.dropdown('get value');
    var formData = new FormData();
    formData.append('appeal_type_id', appealType);
    formData.append('reason', reason);
    formData.append('appeal_type','Note');
    formData.append('target_id',appealableId);
    $.ajax({
      type: 'POST',
      url: "/appeals",
      cache: false,
      contentType: false,
      processData: false,
      data: formData,
      beforeSend: function() {
        setCommentSendStatus(true);
      },
      success: function(res) {
        if (res.status == 200) {
          setCommentSendTip(true);
          setTimeout(function() {
            $complaintCommentsModal.modal('hide');
            restoreCommonentDefault();
          }, 3000);
        }
        setCommentSendStatus(false);
      },
      error: function(err) {
        showCommonTips(err.responseJSON.message, 'error');
        setCommentSendStatus(false);
      }
    })
  });
  
  function showCommonTips(text, type) {
    $complaintModalTip.text(text).show();
    if (type == 'error') {
      $complaintModalTip.removeClass('success').addClass('error');
    } else {
      $complaintModalTip.removeClass('error').addClass('success');
    }
  }
  
  function setCommentSendStatus(value) {
    complaintSending = value;
    if (complaintSending) {
      $complaintCommentBtn.addClass('loading');
      $complaintCommentsContent.attr('readonly', true);
      $complainCommentType.attr('readonly', true);
    } else {
      $complaintCommentBtn.removeClass('loading');
      $complaintCommentsContent.attr('readonly', false);
      $complainCommentType.attr('readonly', false);
    }
  }
  
  function setCommentSendTip(value) {
    if (value) {
      $('.appeal-success-tip').removeClass('hide');
      $('.appeal-tip').addClass('hide');
      $('.appeal-form').addClass('hide');
      $('#landing-comments-complaint-modal .actions').addClass('hide');
    } else {
      $('.appeal-success-tip').addClass('hide');
      $('.appeal-tip').removeClass('hide');
      $('.appeal-form').removeClass('hide');
      $('#landing-comments-complaint-modal .actions').removeClass('hide');
    }
  }
</script>

</div>
<script>
  "use strict";
  $('.js-check-star').checkbox('set unchecked')
</script>

</div>
</div>
</div>
<script>
  (function() {
    $(function() {
      Tree.init();
      return TreeCommentActions.init();
    });
  
  }).call(this);
</script>

</div>
<script>
  (function() {
    var donateModal;
  
    Gitee.modalHelper = new GiteeModalHelper({
      alertText: '提示',
      okText: '确定'
    });
  
    donateModal = new ProjectDonateModal({
      el: '#project-donate-modal',
      alipayUrl: '/xiongrj/springcloud-base/alipay',
      wepayUrl: '/xiongrj/springcloud-base/wepay',
      nameIsBlank: 'name cannot be blank',
      nameTooLong: 'name is too long (maximum is 36 character)',
      modalHelper: Gitee.modalHelper
    });
  
    if ("" === 'true') {
      donateModal.show();
    }
  
    $('#project-donate').on('click', function() {
      return donateModal.show();
    });
  
  }).call(this);
</script>
<script>
  Tree.initHighlightTheme('white')
</script>


</div>
<div class='gitee-project-extension'>
<div class='extension public'>1</div>
<div class='extension https'>https://gitee.com/xiongrj/springcloud-base.git</div>
<div class='extension ssh'>git@gitee.com:xiongrj/springcloud-base.git</div>
<div class='extension namespace'>xiongrj</div>
<div class='extension repo'>springcloud-base</div>
<div class='extension name'>springcloud-base</div>
<div class='extension branch'>master</div>
</div>

<script>
  $(function() {
    GitLab.GfmAutoComplete.dataSource = "/xiongrj/springcloud-base/autocomplete_sources"
    GitLab.GfmAutoComplete.Emoji.assetBase = '/images/emoji'
    GitLab.GfmAutoComplete.setup();
  });
</script>

<footer id='git-footer-main'>
<div class='ui container'>
<div class='ui two column grid is-en'>
<div class='nine wide column git-footer-left'>
<p><a href="https://gitee.com/" target="_blank">© Gitee.com</a></p>
<div class='ui four column grid' id='footer-left'>
<div class='column'>
<div class='ui link list'>
<div class='item'>
<a class="item" href="/about_us">About us</a>
</div>
<div class='item'>
<a class="item" href="/terms">Terms</a>
</div>
<div class='item'>
<a class="item" href="/oschina/git-osc/issues">Suggestions</a>
</div>
<div class='item'>
<a class="item" href="/links.html">Partners</a>
</div>
</div>
</div>
<div class='column'>
<div class='ui link list'>
<div class='item'>
<a class="item" href="/all-about-git">All About Git</a>
</div>
<div class='item'>
<a class="item" href="https://oschina.gitee.io/learn-git-branching/">Learn Git Branching</a>
</div>
<div class='item'>
<a class="item" href="https://copycat.gitee.com/">Code Clone Detection</a>
</div>
<div class='item'>
<a class="item" href="/appclient">App and Plugins</a>
</div>
</div>
</div>
<div class='column'>
<div class='ui link list'>
<div class='item'>
<a class="item" href="/gitee-stars">Gitee Stars</a>
</div>
<div class='item'>
<a class="item" href="/gvp">GVP</a>
</div>
<div class='item'>
<a class="item" href="https://blog.gitee.com/">Gitee Blog</a>
</div>
<div class='item'>
<a class="item" href="/enterprises#nonprofit-plan">gitee nonprofit plan</a>
</div>
</div>
</div>
<div class='column'>
<div class='ui link list'>
<div class='item'>
<a class="item" href="/api/v5/swagger">OpenAPI</a>
</div>
<div class='item'>
<a class="item" href="/help">Gitee Docs</a>
</div>
<div class='item'>
<a class="item" href="/self_services">Help</a>
</div>
<div class='item'>
<a class="item" href="/git-osc">Changelog</a>
</div>
</div>
</div>
</div>
</div>
<div class='seven wide column right aligned followus git-footer-right'>
<div class='qrcode weixin'>
<img alt="Qrcode weixin" src="https://assets.gitee.com/assets/qrcode-weixin-9e7cfb27165143d2b8e8b268a52ea822.jpg" />
<p class='weixin-text'>WeChat</p>
</div>
<div class='phone-and-qq column'>
<div class='ui list official-support-container'>
<div class='item'>
<a class="icon-popup" href="//shang.qq.com/wpa/qunwpa?idkey=df785aa7af71f7d74149ab062742d761b845464350ecba25eb440357a3e573b7" title="点击加入码云官方群"><i class='iconfont icon-logo-qq'></i>
<span>Official QQ Group: 1050025484</span>
</a></div>
<div class='item mail-and-zhihu'>
<a href="mailto: git@oschina.cn"><i class='iconfont icon-ic-mail'></i>
<span id='git-footer-email'>git#oschina.cn</span>
</a><a href="https://www.zhihu.com/org/ma-yun-osc/ " target="_blank"><i class='iconfont icon-zhihu'></i>
<span>Gitee</span>
</a></div>
<div class='item'>Enterprise support: 400-606-0201</div>
</div>
</div>
</div>
</div>
</div>
<div class='bottombar'>
<div class='ui container'>
<div class='ui grid'>
<div class='seven wide column partner'>
<div class='copyright'>
<a href="http://www.beian.miit.gov.cn/">粤ICP备12009483号</a>
Powered by OSCHINA
</div>
</div>
<div class='nine wide column right aligned'>
<i class='icon world'></i>
<a href="/language/zh-CN">简 体</a>
/
<a href="/language/zh-TW">繁 體</a>
/
<a href="/language/en">English</a>
</div>
</div>
</div>
</div>
</footer>
<script>
  var officialEmail = $('#git-footer-email').text()
  $('#git-footer-main .icon-popup').popup({ position: 'bottom center' })
  $('#git-footer-email').text(officialEmail.replace('#', '@'))
</script>


<div class='side-toolbar'>
<div class='button toolbar-help'>
<i class='iconfont icon-help'></i>
</div>
<div class='ui popup left center dark'>Need help</div>
<div class='toolbar-help-dialog'>
<div class='toolbar-dialog-header'>
<h3 class='toolbar-dialog-title'>Help Search</h3>
<form accept-charset="UTF-8" action="/help/load_keywords_data" class="toolbar-help-search-form" method="get"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /></div>
<div class='ui icon input fluid toolbar-help-search'>
<input name='keywords' placeholder='Please enter a question' type='text'>
<i class='icon search'></i>
</div>
</form>

<i class='iconfont icon-close toolbar-dialog-close-icon'></i>
</div>
<div class='toolbar-dialog-content'>
<div class='toolbar-help-hot-search'>
<div class='toolbar-roll'>
<a class="init active" href="https://oschina.gitee.io/learn-git-branching/?utm_source==gitee-help-widget" title="Git 命令在线学习"><i class='Blue icon icon-command iconfont'></i>
<span>Git 命令在线学习</span>
</a><a class="init " href="https://gitee.com/help/articles/4261?utm_source==gitee-help-widget" title="如何在码云上导入 GitHub 仓库"><i class='icon icon-clipboard iconfont orange'></i>
<span>如何在码云上导入 GitHub 仓库</span>
</a></div>
<div class='toolbar-list'>
<div class='toolbar-list-item'>
<a href="/help/articles/4114">Git 仓库基础操作</a>
</div>
<div class='toolbar-list-item'>
<a href="/help/articles/4166">企业版和社区版功能对比</a>
</div>
<div class='toolbar-list-item'>
<a href="/help/articles/4191">SSH 公钥设置</a>
</div>
<div class='toolbar-list-item'>
<a href="/help/articles/4194">如何处理代码冲突</a>
</div>
<div class='toolbar-list-item'>
<a href="/help/articles/4232">仓库体积过大，如何减小？</a>
</div>
<div class='toolbar-list-item'>
<a href="/help/articles/4279">如何找回被删除的仓库数据</a>
</div>
<div class='toolbar-list-item'>
<a href="/help/articles/4283">码云使用容量说明</a>
</div>
<div class='toolbar-list-item'>
<a href="/help/articles/4284">GitHub仓库快速导入Gitee及同步更新</a>
</div>
</div>
</div>
<div class='toolbar-help-search-reseult'>
<div class='toolbar-help-flex-column'>
<div class='ui centered inline loader toolbar-help-loader'></div>
<div class='toolbar-list'></div>
<div class='toolbar-help-link-to-help'>
<a href="" target="_blank">More results</a>
</div>
</div>
</div>
</div>
</div>
<script>
  var opt = { position: 'left center' };
  var $helpSideToolbar = $(".button.toolbar-help");
  var $toolbarRoll = $('.toolbar-roll');
  
  $(function() {
    if (false) {
      $helpSideToolbar.popup(opt);
    } else {
      $helpSideToolbar.popup('show', opt);
      setTimeout(function() {
        $helpSideToolbar.popup('hide', opt);
      }, 3000);
    }
  
    if ($toolbarRoll.length) {
      setInterval(function() {
        var $nextActiveLink = $toolbarRoll.find('a.active').next();
        if (!$nextActiveLink.length) {
          $nextActiveLink = $toolbarRoll.find('a:first-child');
        }
        $nextActiveLink.attr('class', 'active').siblings().removeClass('active init');
      }, 5000);
    }
  })
</script>

<div class='button share-link'>
<i class='iconfont icon-share'></i>
</div>
<div class='ui popup dark'>
<div class='header'>
Share to
</div>
<div class='bdsharebuttonbox' style='display: flex'>
<a class='iconfont icon-home-service-wechat' data-cmd='weixin' title='分享到微信'></a>
<a class='iconfont icon-weibo' data-cmd='tsina' title='分享到新浪微博'></a>
<a class='iconfont icon-qq' data-cmd='sqq' title='分享到QQ好友'></a>
<a class='iconfont icon-qzone' data-cmd='qzone' title='分享到QQ空间'></a>
</div>
</div>
<div class='popup button' id='home-comment'>
<i class='iconfont icon-comment'></i>
</div>
<div class='ui popup dark'>Comment</div>
<div class='toolbar-appeal popup button'>
<i class='iconfont icon-report'></i>
</div>
<div class='ui popup dark'>
Repository Report
</div>
<script>
  $('.toolbar-appeal').popup({ position: 'left center' });
</script>

<div class='button gotop popup' id='gotop'>
<i class='iconfont icon-top'></i>
</div>
<div class='ui popup dark'>Back to top</div>
</div>
<div class='form modal normal-modal tiny ui' id='unlanding-complaint-modal'>
<i class='iconfont icon-close close'></i>
<div class='header'>
Login prompt
</div>
<div class='container actions'>
<div class='content'>
This operation requires login to the code cloud account. Please log in before operating.
</div>
<div class='ui orange icon large button ok'>
Go to login
</div>
<div class='ui button blank cancel'>
No account. Register
</div>
</div>
</div>
<script>
  var $elm = $('.toolbar-appeal');
  
  $elm.on('click', function() {
    var modals = $("#unlanding-complaint-modal.normal-modal");
    if (modals.length > 1) {
      modals.eq(0).modal('show');
    } else {
      modals.modal('show');
    }
  })
  $("#unlanding-complaint-modal.normal-modal").modal({
    onDeny: function() {
      window.location.href = "/signup?from=";
    },
    onApprove: function() {
      window.location.href = "/login?from=";
    }
  })
</script>

<style>
  .side-toolbar .bdsharebuttonbox a {
    font-size: 24px;
    color: white !important;
    opacity: 0.9;
    margin: 6px 6px 0px 6px;
    background-image: none;
    text-indent: 0;
    height: auto;
    width: auto;
  }
</style>
<script>
  (function() {
    $('#project-user-message').popup({
      position: 'left center'
    });
  
  }).call(this);
</script>
<script>
  Gitee.initSideToolbar({
    hasComment: true,
    commentUrl: '/xiongrj/springcloud-base#tree_comm_title'
  })
</script>
<script>
  window._bd_share_config = {
    "common": {
      "bdSnsKey": {},
      "bdText": document.title,
      "bdMini": "1",
      "bdMiniList": ["bdxc","tqf","douban","bdhome","sqq","thx","ibaidu","meilishuo","mogujie","diandian","huaban","duitang","hx","fx","youdao","sdo","qingbiji","people","xinhua","mail","isohu","yaolan","wealink","ty","iguba","fbook","twi","linkedin","h163","evernotecn","copy","print"],
      "bdPic": "",
      "bdStyle": "1",
      "bdSize": "32"
    },
    "share": {}
  }
</script>
<script src="/bd_share/static/api/js/share.js"></script>



<style>
  .gitee-stars-main-widget {
    display: none;
    position: fixed;
    left: 0;
    bottom: 0;
    z-index: 99; }
    .gitee-stars-main-widget .close-icon {
      position: absolute;
      top: 40px;
      cursor: pointer; }
    .gitee-stars-main-widget .people-image {
      width: 200px;
      padding: 43px 10px; }
  
  .gitee-stars-main-widget.pendan-widget .close-icon {
    right: 20px; }
  .gitee-stars-main-widget.gitee-stars-widget .close-icon {
    left: 20px; }
</style>
<div class='gitee-stars-main-widget pendan-widget'>
<a href="https://gitee.com/Selected-Activities/Code-relay?from=gitee-guajian" target="_blank"><img alt="220309 7019f5b6 1899542" class="people-image" src="https://images.gitee.com/uploads/images/2020/0322/220309_7019f5b6_1899542.png" />
<img alt="220318 4015cbb9 1899542" class="close-icon" src="https://images.gitee.com/uploads/images/2020/0322/220318_4015cbb9_1899542.png" />
</a></div>
<script>
  $(function () {
    var $giteeStarsWidget = $('.gitee-stars-main-widget')
    var cookieKey = "visit-gitee-"
  
    if ($.cookie(cookieKey) == 1) {
      $giteeStarsWidget.hide()
    } else {
      $giteeStarsWidget.show()
    }
  
    $giteeStarsWidget.on('click', '.close-icon', function (e) {
      e.preventDefault()
      $.cookie(cookieKey, 1, {path: '/', expires: 60})
      $giteeStarsWidget.hide()
    })
  })
</script>


<script>
  (function() {
    this.__gac = {
      domain: 'www.oschina.net'
    };
  
  }).call(this);
</script>
<script defer src='//www.oschina.net/public/javascripts/cjl/ga.js?t=20160926' type='text/javascript'></script>

</body>
</html>
