package druidsurv.cards.bloons;

import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;
import druidsurv.orbs.LightOrb;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.atb;

public class SunBloon extends AbstractEasyCard {
    public final static String ID = makeID("SunBloon");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public SunBloon() {
        super(ID, 2, CardType.SKILL, CardRarity.SPECIAL, CardTarget.SELF, "MaxHeal_CardArt");
        baseDamage = 16;
        baseBlock = 5;
        tags.add(druidsurv.cards.cardvars.CardTags.BLOON);
        tags.add(druidsurv.cards.cardvars.CardTags.ADVANCED);
        setPortraitTextures("druidsurvResources/images/cardui/512/frame_skill_void.png", "druidsurvResources/images/cardui/1024/frame_skill_void.png");
        this.setCardBack(cardSubType.BLOON);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        atb(new ChannelAction(new LightOrb()));
        atb(new ChannelAction(new LightOrb()));
        bloonBlck();
    }

    @Override
    public void upp() {
        upgradeBlock(3);
    }
}