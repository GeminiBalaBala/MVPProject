# MVPProject
androidMVP结构特别适合中小型app的开发,代码逻辑结构清晰,易于读懂,方便新人快速开发<br/>
但是缺点也是很明显的,接口过多,当项目模块很多时,代码就显得很臃肿了,尤其是Presenter的代码,基本不能复用<br/>
此项目去除无用接口,统一层次的回调,精简了再精简,适合快速开发与迭代.<br/>

![](https://github.com/GeminiBalaBala/MVPProject/blob/master/mvpproject.png)

项目中的view就是Activity,Fragment里面只有findViewById和OnClickListener,意思是要放入少量的代码<br/>
Activity负责管理Fragment,除此之外view就不能有任何的复杂业务代码了.view永远都是最被动的.<br/>

Presenter负责处理业务bean,排序,筛选,取值等等.Adapter也属于Presenter.<br/>
很少有界面是一样的,所以Presenter基本不能重用.<br/>

Model则是提供业务bean供给Presenter使用.通常来说业务模型不会很多,但是各种处理就比较多了.<br/>
只有Model才能与NetWork,DB和FileSystem进行交互,所以这里需要将三种方式进行接口封装.目的就是第三方框架更换时不要影响Model.<br/>
Model作为比较重要的一个层级,最好不要有第三方框架的影子<br/>
Model中支持自定义的机制:<br/>
 * 数据同步:1,增量更新-DB 2,全更新-FileSystem<br/>
 * 时间同步:FileSystem<br/>
这两者作为单独的Model而存在

