package druidsurv.cards;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.atb;

public class BlackBloon extends AbstractEasyCard {
    public final static String ID = makeID("WhiteBloon");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public BlackBloon() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseBlock = 7;
        tags.add(druidsurv.cards.cardvars.CardTags.BLOON);
        tags.add(druidsurv.cards.cardvars.CardTags.ADVANCED);
        setBackgroundTexture("druidsurvResources/images/512/bloon_skill.png", "druidsurvResources/images/1024/bloon_skill.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {

        bloonBlck();
    }

    @Override
    public void upp()
    {
        upgradeBlock(5);
    }
}